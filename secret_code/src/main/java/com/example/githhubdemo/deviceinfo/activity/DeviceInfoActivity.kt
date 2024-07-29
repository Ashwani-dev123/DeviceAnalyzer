package com.example.githhubdemo.deviceinfo.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.ads.narayan.ads.NarayanAd
import com.ads.narayan.ads.NarayanAdCallback
import com.ads.narayan.ads.wrapper.NarayanAdError
import com.ads.narayan.ads.wrapper.NarayanInterstitialAd
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.ActivityDeviceinfoBinding
import com.example.githhubdemo.utils.ShareModule
import com.example.githhubdemo.utils.SharedPrefsUtilsModule
import com.example.githhubdemo.utils.Util


class DeviceInfoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewBinding : ActivityDeviceinfoBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private var mInterstitialAd: NarayanInterstitialAd? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDeviceinfoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)

        if (Util.isNetworkConnected(this)) {
            if (SharedPrefsUtilsModule.getString(this, ShareModule.BANNER_ID,"") != "") {
                viewBinding.bannerDashboard.loadBanner(this, SharedPrefsUtilsModule.getString(this, ShareModule.BANNER_ID,""))
            }
            else {
                viewBinding.bannerDashboard.isVisible = false
            }
        }
        else {
            viewBinding.bannerDashboard.isVisible = false
        }

        loadInterstitial()

        init()


    }



    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    private fun init() {
        initListener()
    }



    private fun initListener() {

        viewBinding.btnBack.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnBack -> {
                onBackPressed()
            }
        }

    }

    private fun loadInterstitial() {
        if (Util.isNetworkConnected(this)) {
            if (SharedPrefsUtilsModule.getString(this, ShareModule.INTERSTITIAL_ID,"") != "") {
                mInterstitialAd = NarayanAd.getInstance().getInterstitialAds(this , SharedPrefsUtilsModule.getString(this,ShareModule.INTERSTITIAL_ID))
            }
        }

    }
    override fun onBackPressed() {
        if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
            NarayanAd.getInstance().forceShowInterstitial(
                this,
                mInterstitialAd,
                object : NarayanAdCallback() {

//                        override fun onAdClosed() {
//                            super.onAdClosed()
//                            gotoNext(service)
//                        }

                    override fun onAdFailedToShow(adError: NarayanAdError?) {
                        super.onAdFailedToShow(adError)
                        finish()
                    }

                    override fun onNextAction() {
                        super.onNextAction()
                        finish()
                    }

                },
                true
            )
        } else {
            loadInterstitial()
            finish()
        }
    }
}