package com.example.githhubdemo.decicetesting.activity


import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.ActivityDeviceTestingBinding
import com.example.githhubdemo.decicetesting.fragment.VolumeUpFragment
import com.example.githhubdemo.utils.ShareModule
import com.example.githhubdemo.utils.SharedPrefsUtilsModule
import com.example.githhubdemo.utils.Util


class DeviceTestingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeviceTestingBinding

    private lateinit var navController: NavController


    companion object {
        var progressbar: ProgressBar? = null
        var isPopBackStack: Boolean = false
        var isYesOrNoButton: Boolean = false
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val currentFragment = navHostFragment.childFragmentManager.fragments[0] as? VolumeUpFragment
        currentFragment?.let {
            if (it.dispatchKeyEvent(event)) {
                return true
            }
        }
        return super.dispatchKeyEvent(event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeviceTestingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)

        progressbar = binding.customProgressBar

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment


        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.tvToolbar.text = destination.label

            if (!isPopBackStack) {
                val currentProgress = progressbar!!.progress
                if (currentProgress < progressbar!!.max) {
                    isPopBackStack = false
                    progressbar!!.progress = currentProgress + 1

                    //Log.e("CHECKNAVCONTROLLER", "navController: " + navController.currentDestination)
                    Log.e("CHECKNAVCONTROLLER", "progressbar!!.progress: " + progressbar!!.progress)
                    Log.e("CHECKNAVCONTROLLER", "isPopBackStack : " + isPopBackStack)
                }
            }



            if (destination.label == "Device Result") {
                binding.toolbar.isVisible = false
                progressbar!!.isVisible = false
            } else {
                binding.toolbar.isVisible = true
                progressbar!!.isVisible = true
            }
        }


        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        if (Util.isNetworkConnected(this)) {
            if (SharedPrefsUtilsModule.getString(this, ShareModule.BANNER_ID,"") != "") {
                binding.bannerDashboard.loadBanner(this, SharedPrefsUtilsModule.getString(this, ShareModule.BANNER_ID,""))
            }
            else {
                binding.bannerDashboard.isVisible = false
            }
        }
        else {
            binding.bannerDashboard.isVisible = false
        }



    }

    override fun onBackPressed() {
        isPopBackStack = true
        if (navController.popBackStack()) {
            progressbar!!.progress = progressbar!!.progress - 1

            Log.e("CHECKNAVCONTROLLER", "progressbar!!.progress: *** " + progressbar!!.progress)
        } else {
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}