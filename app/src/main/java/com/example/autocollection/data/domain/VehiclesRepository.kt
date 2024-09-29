package com.example.autocollection.data.domain

import com.example.autocollection.data.CarItem
import com.example.autocollection.data.RetrofitServiceFactoy
import com.example.autocollection.data.WebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VehiclesRepository {

    val service: WebService = RetrofitServiceFactoy.makeWebService()

    fun getVehicles(callback: (List<CarItem>?) -> Unit)  {
        service.getVehicles().enqueue(object : Callback<List<CarItem>> {
            override fun onResponse(
                call: Call<List<CarItem>>,
                response: Response<List<CarItem>>
            ) {
                if (response.isSuccessful){
                    callback(response.body())
                }else{
                    callback(null)
                }
            }

            override fun onFailure(call: Call<List<CarItem>>, t: Throwable) {}
        })
    }
}