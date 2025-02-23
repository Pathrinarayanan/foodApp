package com.example.fooddelivery

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.fooddelivery.Home.model.FlowData
import com.example.fooddelivery.Home.model.HomeResponseData
import com.example.fooddelivery.repository.ApiService
import com.example.fooddelivery.repository.RetrofitHelper
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

class MainViewmodel : ViewModel() {
    val repository = RetrofitHelper.getInstance().create(ApiService::class.java)
    val homeData : MutableState<HomeResponseData?> = mutableStateOf<HomeResponseData?>(null)
    private val _sharedFlow : MutableSharedFlow<FlowData> = MutableSharedFlow<FlowData> (replay = 0)
    val sharedFlow = _sharedFlow.asSharedFlow()
    suspend fun getHomePageData() {
        try {
            val data = repository.getHomePageData()
            homeData.value = data
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

}