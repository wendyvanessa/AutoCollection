package com.example.autocollection.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CarItem(
    @SerializedName("brand")
    @Expose val marca: String?= null,

    @SerializedName("model")
    @Expose val modelo: Int?= null,

    @SerializedName("delet_request")
    @Expose val delet_request: Boolean?= null,

    @SerializedName("state")
    @Expose val state: String?= null,

    @SerializedName("favorite")
    @Expose val favorite: Boolean?= null,

    @SerializedName("image")
    @Expose val url: String?= null,

    @SerializedName("location")
    @Expose val location: Location?= null,

    @SerializedName("collection_name")
    @Expose val collection_name: String?= null,

    @SerializedName("combustion_type")
    @Expose val combustion_type: String?= null,
    ){
}




