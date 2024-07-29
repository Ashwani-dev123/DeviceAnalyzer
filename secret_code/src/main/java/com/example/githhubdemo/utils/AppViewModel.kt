package com.example.githhubdemo.utils

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.githhubdemo.deviceinfo.data.model.AppInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModel(application: Application) : AndroidViewModel(application) {
    private val _apps = MutableLiveData<List<AppInfo>>()
    val apps: LiveData<List<AppInfo>> get() = _apps

    private val repository = AppRepository(application)

    fun fetchInstalledApps() {
        viewModelScope.launch(Dispatchers.IO) {
            val appList = repository.getInstalledApps()
            _apps.postValue(appList)
        }
    }
}