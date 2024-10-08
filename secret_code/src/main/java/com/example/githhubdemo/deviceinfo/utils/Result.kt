package com.example.githhubdemo.deviceinfo.utils

import com.example.githhubdemo.deviceinfo.utils.UiResult.Error
import com.example.githhubdemo.deviceinfo.utils.UiResult.Success
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

sealed interface UiResult<out T> {
    data class Success<T>(val data: T) : UiResult<T>
    data class Error(val throwable: Throwable) : UiResult<Nothing>
}

fun <T> Flow<T>.asResult(): Flow<UiResult<T>> {
    return map<T, UiResult<T>>(::Success).catch { emit(Error(it)) }
}
