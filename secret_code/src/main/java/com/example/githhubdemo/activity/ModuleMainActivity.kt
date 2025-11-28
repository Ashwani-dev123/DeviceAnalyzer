package com.example.githhubdemo.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
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

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            window.decorView.setOnApplyWindowInsetsListener { view, insets ->
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                    val statusBarHeight = insets.getInsets(WindowInsets.Type.statusBars()).top
                    val navBarHeight = insets.getInsets(WindowInsets.Type.navigationBars()).bottom
                    view.setPadding(0, statusBarHeight, 0, navBarHeight)
                    view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorStatusBar))

                    window.navigationBarColor = ContextCompat.getColor(this, R.color.white) // pick a dark color
                    val controller = WindowInsetsControllerCompat(window, window.decorView)
                    controller.isAppearanceLightNavigationBars = false //
                } else {
                    @Suppress("DEPRECATION")
                    window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)
                }

                insets
            }
        }
        else
        {
            window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)
        }

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
                binding.btnSecretCode.isClickable = false
                val bundle = Bundle()
                bundle.putString("DeviceAnalyzer","SecretCodeModule")
                FirebaseAnalytics.getInstance(applicationContext).logEvent(appName!!, bundle)
                startActivity(Intent(this, SecretCodeActivity::class.java))
                // Re-enable click after 500ms
                binding.btnSecretCode.postDelayed({
                    binding.btnSecretCode.isClickable = true
                }, 500)
            }

            R.id.btnMobileTricks -> {
                binding.btnMobileTricks.isClickable = false
                val bundle = Bundle()
                bundle.putString("DeviceAnalyzer","MobileTricksModule")
                FirebaseAnalytics.getInstance(applicationContext).logEvent(appName!!, bundle)
                startActivity(Intent(this, MobileTricksActivity::class.java))
                // Re-enable click after 500ms
                binding.btnMobileTricks.postDelayed({
                    binding.btnMobileTricks.isClickable = true
                }, 500)
            }
            R.id.btnAndroidTips -> {
                binding.btnAndroidTips.isClickable = false
                val bundle = Bundle()
                bundle.putString("DeviceAnalyzer","AndroidTipsModule")
                FirebaseAnalytics.getInstance(applicationContext).logEvent(appName!!, bundle)
                startActivity(Intent(this, AndroidTipsActivity::class.java))
                // Re-enable click after 500ms
                binding.btnAndroidTips.postDelayed({
                    binding.btnAndroidTips.isClickable = true
                }, 500)
            }

            R.id.btnDeviceInfo -> {
                binding.btnDeviceInfo.isClickable = false
                val bundle = Bundle()
                bundle.putString("DeviceAnalyzer","DeviceInfoModule")
                FirebaseAnalytics.getInstance(applicationContext).logEvent(appName!!, bundle)
                startActivity(Intent(this, DeviceInfoActivity::class.java))
                // Re-enable click after 500ms
                binding.btnDeviceInfo.postDelayed({
                    binding.btnDeviceInfo.isClickable = true
                }, 500)
            }

            R.id.btnDeviceTesting -> {
                binding.btnDeviceTesting.isClickable = false
                val bundle = Bundle()
                bundle.putString("DeviceAnalyzer","DeviceTestingModule")
                FirebaseAnalytics.getInstance(applicationContext).logEvent(appName!!, bundle)
                startActivity(Intent(this, DeviceTestingActivity::class.java))
                // Re-enable click after 500ms
                binding.btnDeviceTesting.postDelayed({
                    binding.btnDeviceTesting.isClickable = true
                }, 500)
            }
        }
    }
}