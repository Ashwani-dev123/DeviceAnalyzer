package com.example.githhubdemo.deviceinfo.models


import com.example.githhubdemo.deviceinfo.data.model.CpuInfo

data class CpuData(
    val processorName: String,
    val abi: String,
    val coreNumber: Int,
    val hasArmNeon: Boolean,
    val frequencies: List<CpuInfo.Frequency>,
    val layoutInfo: List<Information>
)
