package com.example.autocollection.ui.navigation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.autocollection.data.CarItem

class HomeViewModel : ViewModel() {

    private val _itemsLiveData = MutableLiveData<List<CarItem>>().apply {
        value = listOf(CarItem(
            1,
            "Holitaaas soy un ferrary",
            "https://i.pinimg.com/1200x/08/ca/9e/08ca9ecd4ed75c3539a9e7c104bbeab8.jpg")
        )
    }
    val itemsLiveData: LiveData<List<CarItem>> get() = _itemsLiveData





}