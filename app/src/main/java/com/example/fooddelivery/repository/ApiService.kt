package com.example.fooddelivery.repository

import com.example.fooddelivery.Home.model.HomeResponseData
import retrofit2.http.GET

interface ApiService {

    @GET("/menu")
    suspend fun getHomePageData(): HomeResponseData
}