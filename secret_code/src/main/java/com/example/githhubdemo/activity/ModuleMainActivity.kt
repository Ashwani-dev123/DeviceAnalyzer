package com.example.githhubdemo.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.ActivityModuleMainBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.deviceinfo.activity.DeviceInfoActivity
import com.example.githhubdemo.utils.ShareModule
import com.example.githhubdemo.utils.SharedPrefsUtilsModule
import com.example.githhubdemo.utils.Util
import com.google.firebase.analytics.FirebaseAnalytics

class ModuleMainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding : ActivityModuleMainBinding
    private var appName : String ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModuleMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this,R.color.colorStatusBar)

        appName = SharedPrefsUtilsModule.getString(this, ShareModule.APP_NAME,"")

        Log.e("CHECKAPPNAME", "appName =====> : " + appName)

        if (Util.isNetworkConnected(this)) {
            if (SharedPrefsUtilsModule.getString(this, ShareModule.BANNER_ID,"") != "") {
                binding.bannerDashboard.loadBanner(this, SharedPrefsUtilsModule.getString(this, ShareModule.BANNER_ID))
            }
            else {
                binding.bannerDashboard.isVisible = false
            }
        }
        else {
            binding.bannerDashboard.isVisible = false
        }

        initListener()
    }

    private fun initListener() {
        binding.btnMobileTricks.setOnClickListener(this)
        binding.btnAndroidTips.setOnClickListener(this)
        binding.btnDeviceTesting.setOnClickListener(this)
        binding.btnDeviceInfo.setOnClickListener(this)
        binding.btnBack.setOnClickListener(this)
        binding.btnSecretCode.setOnClickListener(this)
    }


    override fun onClick(view : View?) {
        when (view!!.id) {
            R.id.btnBack -> {
                finish()
            }
            R.id.btnSecretCode -> {
                val bundle = Bundle()
                bundle.putString("DeviceAnalyzer","SecretCodeModule")
                FirebaseAnalytics.getInstance(applicationContext).logEvent(appName!!, bundle)
                startActivity(Intent(this, SecretCodeActivity::class.java))
            }

            R.id.btnMobileTricks -> {
                val bundle = Bundle()
                bundle.putString("DeviceAnalyzer","MobileTricksModule")
                FirebaseAnalytics.getInstance(applicationContext).logEvent(appName!!, bundle)
                startActivity(Intent(this, MobileTricksActivity::class.java))
            }
            R.id.btnAndroidTips -> {
                val bundle = Bundle()
                bundle.putString("DeviceAnalyzer","AndroidTipsModule")
                FirebaseAnalytics.getInstance(applicationContext).logEvent(appName!!, bundle)
                startActivity(Intent(this, AndroidTipsActivity::class.java))
            }

            R.id.btnDeviceInfo -> {
                val bundle = Bundle()
                bundle.putString("DeviceAnalyzer","DeviceInfoModule")
                FirebaseAnalytics.getInstance(applicationContext).logEvent(appName!!, bundle)
                startActivity(Intent(this, DeviceInfoActivity::class.java))
            }

            R.id.btnDeviceTesting -> {
                val bundle = Bundle()
                bundle.putString("DeviceAnalyzer","DeviceTestingModule")
                FirebaseAnalytics.getInstance(applicationContext).logEvent(appName!!, bundle)
                startActivity(Intent(this, DeviceTestingActivity::class.java))
            }
        }
    }
}