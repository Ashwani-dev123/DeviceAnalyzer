package com.example.githhubdemo.deviceinfo.utils

import com.example.githhubdemo.deviceinfo.models.Information

fun Pair<String, String>.toInformation(): Information {
    return Information(
        title = first,
        details = second
    )
}

fun List<Information>.clearEmptyEntries(): List<Information> {
    return filter { it.details.isNotEmpty() }
}
