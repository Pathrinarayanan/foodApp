package com.example.fooddelivery.Home.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FaqModel(
    @SerializedName("faqs")
    val faqs : List<FaqData>?,
):Parcelable

@Parcelize
data class FaqData(
    @SerializedName("question")
    val question : String?,
    @SerializedName("answer")
    val answer :String?
):Parcelable
