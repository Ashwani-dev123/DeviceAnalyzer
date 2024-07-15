package com.example.githhubdemo.decicetesting.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val buttonClicks: MutableLiveData<MutableList<Pair<Int, String>>> = MutableLiveData(mutableListOf())
    
    fun addButtonClick(position: Int, buttonType: String) {
        val updatedList = buttonClicks.value
        updatedList?.add(Pair(position, buttonType))
        buttonClicks.value = updatedList!!
    }
}