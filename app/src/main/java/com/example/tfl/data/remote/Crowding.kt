package com.example.tfl.data.remote


import com.google.gson.annotations.SerializedName

data class Crowding(
    @SerializedName("type")
    val type: String
)