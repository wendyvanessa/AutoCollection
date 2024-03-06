package com.example.autocollection.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Location (
    @SerializedName("address")
    @Expose
    val address: String?= null,

    @SerializedName("latitude")
    @Expose
    val latitude: String?= null,

    @SerializedName("longitude")
    @Expose
    val longitude: String?= null,
    ){
}

