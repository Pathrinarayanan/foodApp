package com.example.fooddelivery.Home.model

import android.widget.Toast
import java.util.Objects

sealed class FlowData{
    data class Toast(val msg :String) :FlowData()
}