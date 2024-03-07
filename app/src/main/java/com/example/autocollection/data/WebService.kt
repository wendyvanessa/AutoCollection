package com.example.autocollection.data

import retrofit2.http.GET

/**
 * Documentación: https://www.notion.so/Retrofit-045d73ca33b1467a966a9e521a1f5735?pvs=4
 */
interface WebService {

    @GET("71b5cc66-2863-4f5c-b4fc-0848b1390d63")
    suspend fun getVehicles(): List<CarItem>
}