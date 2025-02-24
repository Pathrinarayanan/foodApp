package com.example.fooddelivery

import android.util.Log
import android.util.Patterns
import android.view.View
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.fooddelivery.Home.model.FaqData
import com.example.fooddelivery.Home.model.FaqModel
import com.example.fooddelivery.Home.model.FlowData
import com.example.fooddelivery.Home.model.HomeResponseData
import com.example.fooddelivery.Home.model.MenuItem
import com.example.fooddelivery.repository.ApiService
import com.example.fooddelivery.repository.FirebaseRepository
import com.example.fooddelivery.repository.RetrofitRepository
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(private val repository: RetrofitRepository, private val firebaseRepository: FirebaseRepository) : ViewModel(){
    val homeData : MutableState<HomeResponseData?> = mutableStateOf<HomeResponseData?>(null)
    val faqData : MutableState<FaqModel?> = mutableStateOf<FaqModel?>(null)

    private val _sharedFlow : MutableSharedFlow<FlowData> = MutableSharedFlow<FlowData> (replay = 0)
    val sharedFlow = _sharedFlow.asSharedFlow()
    var username by mutableStateOf("")
    var favoritesList : MutableList<Int> =  mutableListOf()
    var recentlyViewed : MutableList<Int> =  mutableListOf()

    private val _menuItemsMap = MutableStateFlow<Map<Int, MenuItem>>(emptyMap())
    val menuItemsMap: StateFlow<Map<Int, MenuItem>> = _menuItemsMap.asStateFlow()

    fun mapMenuItems() {
        val menuList = (homeData.value?.data?.restaurant?.menu?.best_sellers ?: emptyList()) +
                (homeData.value?.data?.restaurant?.menu?.recommended ?: emptyList())

        val menuMap = menuList.associateBy { it.id }
        _menuItemsMap.value = menuMap
    }

    fun getMenuItemsByIds(ids: List<Int>): List<MenuItem> {
        return ids.mapNotNull { menuItemsMap.value[it] }
    }

    suspend fun getHomePageData() {
        try {
            val data = repository.fetchDataFromApi()
            homeData.value = data
            mapMenuItems()
        } catch (e: SocketTimeoutException) {
            _sharedFlow.emit(FlowData.Toast("Socket timeout ->${e.message}"))
        } catch (e: IOException) {
            _sharedFlow.emit(FlowData.Toast("API_ERROR Network Error! Check your connection."))
        } catch (e: HttpException) {
            _sharedFlow.emit(FlowData.Toast("Server Error: ${e.code()} - ${e.message()}"))
        } catch (e: Exception) {
            _sharedFlow.emit(FlowData.Toast("API_ERROR\", \"Unexpected Error: ${e.message}"))
        }
    }
    suspend fun getFaqData() {
        try {
            val data = repository.fetchFaqData()
            faqData.value = data
        } catch (e: SocketTimeoutException) {
            _sharedFlow.emit(FlowData.Toast("Socket timeout ->${e.message}"))
        } catch (e: IOException) {
            _sharedFlow.emit(FlowData.Toast("API_ERROR Network Error! Check your connection."))
        } catch (e: HttpException) {
            _sharedFlow.emit(FlowData.Toast("Server Error: ${e.code()} - ${e.message()}"))
        } catch (e: Exception) {
            _sharedFlow.emit(FlowData.Toast("API_ERROR\", \"Unexpected Error: ${e.message}"))
        }
    }


    fun login(email : String, password :String, navController: NavController) {
        val p: Pattern = Patterns.EMAIL_ADDRESS
        val isValidEmail = p.matcher(email).matches()
        if (!isValidEmail) {
            viewModelScope.launch {
               _sharedFlow.emit(FlowData.Toast("enter the valid mail"))
            }
            return
        } else if (password.length < 8) {
            viewModelScope.launch {
                _sharedFlow.emit(FlowData.Toast("password must be atleast length of 8"))
            }
            return
        } else {
           firebaseRepository.firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(
                OnCompleteListener { task ->
                    if (task.isSuccessful) {
                        navController.navigate("home")
                        viewModelScope.launch {
                            _sharedFlow.emit(FlowData.Toast("success"))
                        }
                    } else {
                        viewModelScope.launch {
                            _sharedFlow.emit(FlowData.Toast(task.exception.toString()))
                        }
                    }
                }
            )
        }
    }
    fun fetchUsername() {
        firebaseRepository.firebaseAuth.currentUser?.uid?.let { uid ->
            firebaseRepository.db.collection("Users")
                .document(uid)
                .get()
                .addOnCompleteListener(OnCompleteListener {
                    if (it.isSuccessful) {
                        val documents = it.result
                        username = documents.data?.get("name").toString()
                    }
                })
        }
    }


    fun signup(email : String, password :String, name :String,  navController: NavController) {
        val p: Pattern = Patterns.EMAIL_ADDRESS
        val isValidEmail = p.matcher(email).matches()
        if (!isValidEmail) {
            viewModelScope.launch {
                _sharedFlow.emit(FlowData.Toast("enter the valid mail"))
            }
            return
        }
        else if (password.length < 8) {
            viewModelScope.launch {
                _sharedFlow.emit(FlowData.Toast("password must be atleast length of 8"))
            }
            return
        } else {

            firebaseRepository.firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(
                OnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val userData = hashMapOf(
                            "name" to name
                        )
                        firebaseRepository.firebaseAuth.currentUser?.uid?.let {uid->
                            firebaseRepository.db.collection("Users")
                                .document(uid)
                                .set(userData).addOnCompleteListener(
                                    OnCompleteListener {
                                        if(it.isSuccessful) {
                                            viewModelScope.launch {
                                                _sharedFlow.emit(FlowData.Toast("success"))
                                            }
                                            navController.navigate("home")
                                        }
                                        else{
                                            viewModelScope.launch {
                                                _sharedFlow.emit(FlowData.Toast(it.exception.toString()))
                                            }
                                        }

                                    }
                                )
                        }

                    } else {
                        viewModelScope.launch {
                            _sharedFlow.emit(FlowData.Toast(task.exception.toString()))
                        }
                    }
                }
            )
        }
    }
    fun logout(){
        firebaseRepository.firebaseAuth.signOut()
    }
    fun addFavorites(id: Int) {
        val user = firebaseRepository.firebaseAuth.currentUser
        if (user == null) {
            viewModelScope.launch {
                _sharedFlow.emit(FlowData.Toast("User not logged in"))
            }
            return
        }

        val uid = user.uid
        val docRef = firebaseRepository.db.collection("Favorites").document(uid)

        docRef.update("favoriteIds", FieldValue.arrayUnion(id))
            .addOnSuccessListener {
                viewModelScope.launch {
                    _sharedFlow.emit(FlowData.Toast("Added to Favorites"))
                }
            }
            .addOnFailureListener { exception ->
                viewModelScope.launch {
                    _sharedFlow.emit(FlowData.Toast(exception.localizedMessage ?: "Error"))
                }
            }
    }
    fun removeFavorites(id: Int) {
        val user = firebaseRepository.firebaseAuth.currentUser
        if (user == null) {
            viewModelScope.launch {
                _sharedFlow.emit(FlowData.Toast("User not logged in"))
            }
            return
        }

        val uid = user.uid
        val docRef = firebaseRepository.db.collection("Favorites").document(uid)

        docRef.update("favoriteIds", FieldValue.arrayRemove(id))
            .addOnSuccessListener {
                viewModelScope.launch {
                    _sharedFlow.emit(FlowData.Toast("Removed from Favorites"))
                }
            }
            .addOnFailureListener { exception ->
                viewModelScope.launch {
                    _sharedFlow.emit(FlowData.Toast(exception.localizedMessage ?: "Error removing favorite"))
                }
            }
    }
    fun isFavorite(id: Int, onResult: (Boolean) -> Unit) {
        val user = firebaseRepository.firebaseAuth.currentUser
        if (user == null) {
            onResult(false)
            return
        }

        val uid = user.uid
        val docRef = firebaseRepository.db.collection("Favorites").document(uid)

        docRef.get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val favoritesList = document.get("favoriteIds") as? List<Int> ?: emptyList()
                    onResult(favoritesList.contains(id.toInt()))
                } else {
                    onResult(false)
                }
            }
            .addOnFailureListener {
                onResult(false)
            }
    }
    fun fetchFavorites() {
        val user = firebaseRepository.firebaseAuth.currentUser
        if (user == null) {
            favoritesList = mutableListOf()
            return
        }

        val uid = user.uid
        val docRef = firebaseRepository.db.collection("Favorites").document(uid)

        docRef.get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val favorites = document.get("favoriteIds") as? List<Int> ?: emptyList()
                    favoritesList = favorites.map { it.toInt() }.toMutableList()
                    Log.d("pathris"," list -> ${favorites}" )
                } else {
                    favoritesList = mutableListOf()
                }
            }
            .addOnFailureListener {
                favoritesList = mutableListOf()
            }
    }

}