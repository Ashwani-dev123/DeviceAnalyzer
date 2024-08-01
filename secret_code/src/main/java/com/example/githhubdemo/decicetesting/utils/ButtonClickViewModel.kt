package com.example.githhubdemo.decicetesting.utils

import androidx.lifecycle.ViewModel

class ButtonClickViewModel : ViewModel() {
    private val _buttonClicks = MutableList(13) { "" }
    val buttonClicks: List<String> get() = _buttonClicks

    fun addButtonClick(position: Int, buttonType: String) {
        _buttonClicks[position] = buttonType
    }

    fun getTotalYesClicks(): Int {
        return _buttonClicks.count { it.equals("yes", true) }
    }

    fun getTotalClicks(): Int {
        return _buttonClicks.count { it.isNotEmpty() }
    }
}