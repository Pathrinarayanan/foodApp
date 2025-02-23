package com.example.fooddelivery.repository

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val baseUrl   = "https://whatsappapi-rcqf.onrender.com"
    val client = OkHttpClient.Builder()
        .addInterceptor{it->
            val chain = it.request().newBuilder()
                .build()
            it.proceed(chain)
        }.build()

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}