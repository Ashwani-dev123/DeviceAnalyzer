package com.example.githhubdemo.decicetesting.utils

import android.util.Log

object ButtonClickTracker {
    private val _buttonClicks = mutableListOf<Pair<Int, String>>()
    val buttonClicks: List<Pair<Int, String>> get() = _buttonClicks


    fun addButtonClick(position: Int, buttonType: String) {
        _buttonClicks.add(Pair(position, buttonType))
        Log.d("ButtonClickTracker", "Button click added: $position, $buttonType. Total clicks: ${_buttonClicks.size}")
    }

    fun getTotal():Int{
        var number = 0
        for (i in buttonClicks){
            if(i.second.equals("yes",true)){
                number++
            }
        }
        return number
    }

    fun clearClicks() {
        _buttonClicks.clear()
    }
}
