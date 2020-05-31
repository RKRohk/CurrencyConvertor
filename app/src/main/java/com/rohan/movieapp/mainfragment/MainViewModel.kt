package com.rohan.movieapp.mainfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var t1 = "Currency Converter "
    var curr1 = MutableLiveData<String>("INR")
    var curr2 = MutableLiveData<String>("INR")

    val input = MutableLiveData<String>()
    val listOfCurrency = listOf("USD","GBP","INR","EUR","CAD")

}