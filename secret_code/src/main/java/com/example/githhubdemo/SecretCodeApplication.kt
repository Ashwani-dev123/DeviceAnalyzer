package com.example.githhubdemo


import android.app.Application
import android.widget.Toast
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager

import com.chibatching.kotpref.Kotpref
import com.chibatching.kotpref.gsonpref.gson
import com.example.githhubdemo.deviceinfo.data.provider.CpuDataProvider
import com.example.githhubdemo.deviceinfo.di.allModules
import com.example.githhubdemo.deviceinfo.utils.Settings
import com.example.githhubdemo.deviceinfo.workers.SystemMonitorWorker


import com.getkeepsafe.relinker.ReLinker
import com.google.firebase.FirebaseApp
import com.google.gson.Gson

import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import java.util.concurrent.TimeUnit
import javax.inject.Inject

//@HiltAndroidApp
class SecretCodeApplication : Application(),KoinComponent/*, Configuration.Provider*/ {

    private val ADJUST_TOKEN = "cc4jvudppczk"
    private val EVENT_PURCHASE_ADJUST = "gzel1k"
    private val EVENT_AD_IMPRESSION_ADJUST = "gzel1k"
    private val settings: Settings by inject()
    private val cpuDataProvider: CpuDataProvider by inject()

    private var context: SecretCodeApplication? = null


//    override val workManagerConfiguration: Configuration
//        get() = Configuration.Builder().setWorkerFactory(workerFactory).build()

    companion object{
        private lateinit var mInstance : SecretCodeApplication
        const val LIB_NAME = "cpuinfo-libs"
        fun getInstance() : SecretCodeApplication {
            return mInstance
        }
    }

    override fun onCreate() {
        super.onCreate()

        mInstance = this
        context = this

        Kotpref.init(this)
        Kotpref.gson = Gson()

        startKoin()
        initNativeCpuInfo()
        addSystemMonitor()
        FirebaseApp.initializeApp(this)
    }

    private fun addSystemMonitor() {
        val shouldMonitor = settings.systemMonitoringState
        if (shouldMonitor) {
            val workRequest = PeriodicWorkRequestBuilder<SystemMonitorWorker>(
                15,
                TimeUnit.MINUTES
            ).build()
            WorkManager.getInstance(this).enqueue(workRequest)
        }
    }

    private fun startKoin() = org.koin.core.context.startKoin {
        androidContext(this@SecretCodeApplication)
        modules(allModules)
    }

    private fun initNativeCpuInfo() {
        try {
            System.loadLibrary(LIB_NAME)  // Make sure LIB_NAME is correct
           /* ReLinker.loadLibrary(this,
                LIB_NAME
            ).thenCatching {
                cpuDataProvider.initLibrary()
            }.onSuccess {
                Log.i("Initialised CpuInfo", "successfully")
            }.onFailure {
                Log.e("Failed cpu-info", "initialisation", it)
            }*/
        } catch (e: Exception) {
            Toast.makeText(this, "Please try again later", Toast.LENGTH_SHORT).show()
        }
    }

}