package com.example.autocollection.data

import retrofit2.http.GET

interface WebService {

    @GET("71b5cc66-2863-4f5c-b4fc-0848b1390d63")
    suspend fun getVehicles(): List<CarItem>
}