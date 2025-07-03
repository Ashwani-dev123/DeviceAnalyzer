package com.example.githhubdemo.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.ads.narayan.ads.NarayanAd
import com.ads.narayan.ads.NarayanAdCallback
import com.ads.narayan.ads.wrapper.NarayanAdError
import com.ads.narayan.ads.wrapper.NarayanInterstitialAd
import com.example.githhubdemo.R
import com.example.githhubdemo.adapter.CustomItemListAdapter
import com.example.githhubdemo.databinding.ActivityMobileTricksBinding
import com.example.githhubdemo.utils.ShareModule
import com.example.githhubdemo.utils.SharedPrefsUtilsModule
import com.example.githhubdemo.utils.Util


class MobileTricksActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding : ActivityMobileTricksBinding
    private lateinit var itemList: Array<String>
    private lateinit var itemIcons: Array<Int>
    private var mInterstitialAd: NarayanInterstitialAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMobileTricksBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.setOnApplyWindowInsetsListener { view, insets ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
                val statusBarHeight = insets.getInsets(WindowInsets.Type.statusBars()).top
                view.setPadding(0, statusBarHeight, 0, 0)
                view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorStatusBar))
            } else {
                @Suppress("DEPRECATION")
                window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)
            }

            insets
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

        loadInterstitial()

        initListener()

        itemIcons = arrayOf(
            R.drawable.ic_mobile,
            R.drawable.ic_recover_file,
            R.drawable.ic_improve_battery,
            R.drawable.ic_unlock_pattern,
            R.drawable.ic_break_pattern,
            R.drawable.ic_show_wifi_pass,
            R.drawable.ic_magnifer,
            R.drawable.ic_show_wifi_pass,
            R.drawable.ic_bluetooth_trick,
            R.drawable.ic_screenshot,
            R.drawable.ic_delete,
            R.drawable.ic_hard_factory_reset,
            R.drawable.ic_laptop,
            R.drawable.ic_android,
            R.drawable.ic_radiation_level,
            R.drawable.ic_backup
        )

        itemList = arrayOf(getString(R.string.unknown_facts),getString(R.string.recover_file),getString(R.string.improve_battery),getString(R.string.unlock_pattern),getString(R.string.break_pattern),getString(R.string.wifi_hotspot),getString(R.string.screen_magnifier),getString(R.string.show_wifi_password),getString(R.string.block_bluetooth),getString(R.string.take_screenshots),getString(R.string.delete_notification),getString(R.string.hard_factory_reset),getString(R.string.control_your_laptop),getString(R.string.control_your_android),getString(R.string.radiation_level),getString(R.string.how_to_backup_your))
        binding.lvMobileTricksItem.adapter = CustomItemListAdapter(this, itemList, itemIcons)
    }

    private fun initListener() {
        binding.btnBack.setOnClickListener(this)
        binding.lvMobileTricksItem.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->

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
                            val intent = Intent(applicationContext, MobileTrickDetailsActivity::class.java)
                            intent.putExtra("keys", i)
                            startActivity(intent)
                        }

                        override fun onNextAction() {
                            super.onNextAction()
                            val intent = Intent(applicationContext, MobileTrickDetailsActivity::class.java)
                            intent.putExtra("keys", i)
                            startActivity(intent)
                        }

                    },
                    true
                )
            } else {
                loadInterstitial()
                val intent = Intent(applicationContext, MobileTrickDetailsActivity::class.java)
                intent.putExtra("keys", i)
                startActivity(intent)

            }



        }
    }



    override fun onClick(view : View?) {
        when (view!!.id) {
            R.id.btnBack -> {
                onBackPressed()
            }
        }
    }

    private fun loadInterstitial() {
        if (Util.isNetworkConnected(this)) {
            if (SharedPrefsUtilsModule.getString(this,ShareModule.INTERSTITIAL_ID,"") != "") {
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