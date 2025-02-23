package com.example.fooddelivery.Home.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer


data class HomeResponseData(
    val status: String,
    val base_image_url: String,
    val data: RestaurantData
)

data class RestaurantData(
    val restaurant: Restaurant
)

data class Restaurant(
    val id: Int,
    val name: String,
    val rating: Double,
    val cuisine: String,
    val image_url: String,
    val delivery_time: String,
    val menu: Menu
)

data class Menu(
    val best_sellers: List<MenuItem>,
    val recommended: List<MenuItem>,
    val advertise: List<AdvertisedItem>
)
@Parcelize
@Serializable
data class MenuItem(
    val id: Int,
    val name: String,
    val price: Int,
    val currency: String,
    val image_url: String,
    val description: String,
    val is_veg: Boolean
) : Parcelable

data class AdvertisedItem(
    val id: Int,
    val name: String,
    val tagline: String,
    val image_url: String,
    val offer: String
)
