package com.example.autocollection.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceFactoy {

    fun makeWebService(): WebService {
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(WebService::class.java)
    }
}