package com.example.autocollection.ui.navigation.shopping

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autocollection.data.CarItem
import com.example.autocollection.data.RetrofitServiceFactoy
import com.example.autocollection.data.WebService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShoppingViewModel() : ViewModel() {

    val service: WebService = RetrofitServiceFactoy.makeWebService()

    private val _itemsLiveData = MutableLiveData<List<CarItem>>().apply {
        viewModelScope.launch {
            value = service.getVehicles()
        }
    }
    val itemsLiveData: LiveData<List<CarItem>> get() = _itemsLiveData





}