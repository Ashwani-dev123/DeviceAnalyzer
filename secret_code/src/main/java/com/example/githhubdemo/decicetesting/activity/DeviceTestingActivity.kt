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
import com.ads.narayan.ads.NarayanAd
import com.ads.narayan.ads.NarayanAdCallback
import com.ads.narayan.ads.wrapper.NarayanAdError
import com.ads.narayan.ads.wrapper.NarayanInterstitialAd
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.ActivityDeviceTestingBinding
import com.example.githhubdemo.decicetesting.fragment.VolumeUpFragment
import com.example.githhubdemo.utils.ShareModule
import com.example.githhubdemo.utils.SharedPrefsUtilsModule
import com.example.githhubdemo.utils.Util

class DeviceTestingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeviceTestingBinding
    private lateinit var navController: NavController
    private var mInterstitialAd: NarayanInterstitialAd? = null

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

        // Get navigation controller from the NavHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // Set the graph explicitly to ensure it uses the device testing graph
        // This is crucial to prevent the MainActivity's graph from being used
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.device_testing_nav_graph)
        navController = navHostFragment.navController
        navController.graph = graph

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.tvToolbar.text = destination.label

            if (!isPopBackStack) {
                val currentProgress = progressbar!!.progress
                if (currentProgress < progressbar!!.max) {
                    isPopBackStack = false
                    progressbar!!.progress = currentProgress + 1

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

        loadInterstitial()

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
            if(mInterstitialAd!=null && mInterstitialAd!!.isReady){
                NarayanAd.getInstance().forceShowInterstitial(this,mInterstitialAd,object : NarayanAdCallback(){
                    override fun onNextAction() {
                        super.onNextAction()
                        finish()
                    }

                    override fun onAdFailedToShow(adError: NarayanAdError?) {
                        super.onAdFailedToShow(adError)
                        finish()
                    }
                },true)
            }else {
                loadInterstitial()
                super.onBackPressed()
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun loadInterstitial() {
        if (Util.isNetworkConnected(this)) {
            if (SharedPrefsUtilsModule.getString(this,ShareModule.INTERSTITIAL_ID,"") != "") {
                mInterstitialAd = NarayanAd.getInstance().getInterstitialAds(this, SharedPrefsUtilsModule.getString(this,ShareModule.INTERSTITIAL_ID))
            }
        }
    }
}