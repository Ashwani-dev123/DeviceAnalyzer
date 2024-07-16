package com.example.githhubdemo.utils

import androidx.activity.ComponentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

inline fun <T> ComponentActivity.launchAndCollectWithLifecycle(
    flow: Flow<T>,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline block: suspend CoroutineScope.(T) -> Unit
) {
    lifecycleScope.launch {
        lifecycle.repeatOnLifecycle(minActiveState) {
            flow.collect {
                block(it)
            }
        }
    }
}