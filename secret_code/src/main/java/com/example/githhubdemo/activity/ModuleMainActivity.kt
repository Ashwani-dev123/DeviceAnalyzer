package com.example.githhubdemo.activity

import android.content.Intent
import android.os.Bundle
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

class ModuleMainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding : ActivityModuleMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModuleMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this,R.color.colorStatusBar)

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
                startActivity(Intent(this, SecretCodeActivity::class.java))
            }

            R.id.btnMobileTricks -> {
                startActivity(Intent(this, MobileTricksActivity::class.java))
            }
            R.id.btnAndroidTips -> {
                startActivity(Intent(this, AndroidTipsActivity::class.java))
            }

            R.id.btnDeviceInfo -> {
                startActivity(Intent(this, DeviceInfoActivity::class.java))
            }

            R.id.btnDeviceTesting -> {
                startActivity(Intent(this, DeviceTestingActivity::class.java))
            }
        }
    }
}