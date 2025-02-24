package com.example.fooddelivery.repository

import com.example.fooddelivery.Home.model.FaqData
import com.example.fooddelivery.Home.model.FaqModel
import com.example.fooddelivery.Home.model.HomeResponseData
import retrofit2.http.GET

interface ApiService {

    @GET("/menu")
    suspend fun getHomePageData(): HomeResponseData
    @GET("/faqs")
    suspend fun getFaqData(): FaqModel
}