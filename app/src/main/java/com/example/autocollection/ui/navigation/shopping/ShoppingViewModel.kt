package com.example.autocollection.ui.navigation.shopping

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autocollection.R
import com.example.autocollection.data.CarItem
import com.example.autocollection.data.RetrofitServiceFactoy
import com.example.autocollection.data.WebService
import com.example.autocollection.data.domain.VehiclesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShoppingViewModel() : ViewModel() {


    val vehiclesRepository = VehiclesRepository()

    private val _itemsLiveData = MutableLiveData<List<CarItem>>()
    val itemsLiveData: LiveData<List<CarItem>> get() = _itemsLiveData

    private val _messageLiveData = MutableLiveData<String>()
    val messageLiveData: LiveData<String> get() = _messageLiveData

    private val _processingLiveData = MutableLiveData<Boolean>()
    val processingLiveData: LiveData<Boolean> get() = _processingLiveData


    fun getVehiclesImp() {
        viewModelScope.launch {
            _processingLiveData.value = true
            vehiclesRepository.getVehicles(returnVehicles)
        }
    }

    private val returnVehicles = fun(vehicles: List<CarItem>?) {
        if (vehicles == null) {
            _messageLiveData.value = R.string.not_found.toString()
        } else {
            _itemsLiveData.value = vehicles
        }
        _processingLiveData.value = false
    }


}