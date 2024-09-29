package com.example.autocollection.data

import retrofit2.Call
import retrofit2.http.GET

/**
 * Documentación: https://www.notion.so/Retrofit-045d73ca33b1467a966a9e521a1f5735?pvs=4
 */
interface WebService {

    @GET("5df59863-d1bd-4f6b-96f3-b4a6e9a773db")
    fun getVehicles(): Call<List<CarItem>>
}