package com.example.fooddelivery

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fooddelivery.Home.BestSellersPage
import com.example.fooddelivery.Home.FavoritesPage
import com.example.fooddelivery.Home.HelpCenter
import com.example.fooddelivery.Home.HomeCV
import com.example.fooddelivery.Home.HomeSplashScreen
import com.example.fooddelivery.Home.MainPage
import com.example.fooddelivery.Home.MyOrders
import com.example.fooddelivery.Home.OrderConfirmPage
import com.example.fooddelivery.Home.OrderSuccessPage
import com.example.fooddelivery.Home.PaymentPage
import com.example.fooddelivery.Home.ProductDetailsPage
import com.example.fooddelivery.Home.model.FlowData
import com.example.fooddelivery.Home.model.MenuItem
import com.example.fooddelivery.authentication.ui.BottomBar
import com.example.fooddelivery.authentication.ui.Login
import com.example.fooddelivery.authentication.ui.SignUp
import com.example.fooddelivery.onboarding.ui.OnBoardingPage
import com.example.fooddelivery.repository.FirebaseRepository
import com.example.fooddelivery.ui.theme.FoodDeliveryTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewmodel: MainViewmodel by viewModels()

    @Inject
    lateinit var firebaseRepository: FirebaseRepository

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.statusBarColor = resources.getColor(R.color.yellow_base)
        setContent {
            FoodDeliveryTheme {
                FoodApp()
            }

        }
        fetchData()
        initObservers()

    }

    fun fetchData() {
        viewmodel.viewModelScope.launch {
            viewmodel.getHomePageData()
            viewmodel.getFaqData()
            viewmodel.fetchUsername()
            viewmodel.fetchFavorites()
            viewmodel.fetchCart()
        }
    }

    fun initObservers() {
        viewmodel.viewModelScope.launch {
            viewmodel.sharedFlow.collect {
                when (it) {
                    is FlowData.Toast -> {
                        Toast.makeText(applicationContext, it.msg, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    @SuppressLint("SuspiciousIndentation")
    @Composable
    fun FoodApp() {
        val navController = rememberNavController()
            NavHost(
                startDestination = if (firebaseRepository.firebaseAuth.currentUser == null) "login" else "checkout",
                navController = navController,
                modifier = Modifier.fillMaxSize()
            ) {
                composable("Main/{index}" , arguments =  listOf(navArgument("index"){
                    type = NavType.StringType
                })) {
                    val index = it.arguments?.getString("index")
                    var currentIndex  =0
                    try {
                        currentIndex = index?.toInt() ?:0
                    }
                    catch (e:Exception ){}
                    MainPage(navController, viewmodel,currentIndex)
                }
                composable("home") {
                    HomeCV(viewmodel, navController)
                }
                composable("login") {
                    Login(viewmodel, navController)
                }
                composable("signup") {
                    SignUp(viewmodel, navController)
                }
                composable("onboarding") {
                    OnBoardingPage(navController)
                }
                composable("help") {
                    HelpCenter(viewmodel)
                }
                composable("favorites") {
                    FavoritesPage(viewmodel,navController)
                }
                composable("myOrders") {
                    MyOrders()
                }
                composable("bestSellers") {
                    BestSellersPage(viewmodel,navController)
                }
                composable("splash") {
                    HomeSplashScreen(navController, viewmodel)
                }
                composable("checkout") {
                    OrderConfirmPage(navController, viewmodel)
                }
                composable("payment") {
                    PaymentPage( viewmodel,navController){
                        showNotification(applicationContext, "Your Order is on the way! ", "Thank you for choosing your order, will reach in 25 minutes")
                    }
                }
                composable("orderSuccess") {
                    OrderSuccessPage()
                }
                composable(
                    "details/{menuItem}",
                    arguments = listOf(navArgument("menuItem") {
                        type = NavType.StringType
                    })
                ) { currentBackStackEntry ->
                    val menuItem = currentBackStackEntry.arguments?.getString("menuItem")

                    val decodedMenu =
                        URLDecoder.decode(menuItem, StandardCharsets.UTF_8.toString())
                    val data = Json.decodeFromString<MenuItem>(decodedMenu ?: "")
                    addRecentlyViewed(data.id, viewmodel)
                    ProductDetailsPage(data, viewmodel,navController)
                }

            }
    }
    fun addRecentlyViewed(newNumber: Int, viewmodel: MainViewmodel) {
        if (newNumber in viewmodel.recentlyViewed) return

        viewmodel.recentlyViewed = (listOf(newNumber) + viewmodel.recentlyViewed)
            .distinct()
            .take(5)
            .toMutableList()
    }
    fun showNotification(context: Context, title: String, message: String) {
        val channelId = "notification_channel"
        val notificationId = 1

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Default Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Notification Channel for App"
            }

            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
        val notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.onbording_icon3)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .build()

        val notificationManager = ContextCompat.getSystemService(
            context,
            NotificationManager::class.java
        )
        notificationManager?.notify(notificationId, notification)
    }


}