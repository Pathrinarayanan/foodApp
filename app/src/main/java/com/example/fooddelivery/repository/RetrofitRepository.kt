package com.example.fooddelivery.repository

import com.example.fooddelivery.Home.model.FaqData
import com.example.fooddelivery.Home.model.FaqModel
import com.example.fooddelivery.Home.model.HomeResponseData
import dagger.Module
import retrofit2.Retrofit
import javax.inject.Inject


class RetrofitRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun fetchDataFromApi(): HomeResponseData {
        return apiService.getHomePageData()
    }
    suspend fun fetchFaqData(): FaqModel{
        return apiService.getFaqData()
    }
}
