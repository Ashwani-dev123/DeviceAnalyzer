package com.example.githhubdemo.deviceinfo.models

import com.example.githhubdemo.deviceinfo.data.model.RamLoad


data class RamData(
    val total: String,
    val available: String,
    val percentageAvailable: Int,
    val threshold: String,
    val ramLoad: RamLoad
)
