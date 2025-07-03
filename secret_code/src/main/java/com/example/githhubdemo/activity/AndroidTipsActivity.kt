package com.example.githhubdemo.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.widget.AdapterView
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
import com.example.githhubdemo.databinding.ActivityAndroidTipsBinding
import com.example.githhubdemo.utils.ShareModule
import com.example.githhubdemo.utils.SharedPrefsUtilsModule
import com.example.githhubdemo.utils.Util


class AndroidTipsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityAndroidTipsBinding
    private lateinit var itemList: Array<String>
    private lateinit var itemIcons: Array<Int>
    private var mInterstitialAd: NarayanInterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidTipsBinding.inflate(layoutInflater)
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

        binding.ivEdit.visibility = View.INVISIBLE


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
            R.drawable.ic_internet_speed,
            R.drawable.ic_person,
            R.drawable.ic_few_things,
            R.drawable.ic_setting,
            R.drawable.ic_google_now,
            R.drawable.ic_manage_memory,
            R.drawable.ic_optimizing_performance,
            R.drawable.ic_general_app,
            R.drawable.ic_privacy,
            R.drawable.ic_reduce_data,
            R.drawable.ic_speed_up,
            R.drawable.ic_use_otg,
            R.drawable.ic_use_google,
            R.drawable.ic_longer_battery,
            R.drawable.ic_save_battery,
            R.drawable.ic_add,
            R.drawable.ic_warning,
            R.drawable.ic_location
        )

        itemList = arrayOf(getString(R.string.add_internet_speed),getString(R.string.add_owner_information),getString(R.string.first_few_things_to_do),getString(R.string.gesture_setting),getString(R.string.google_now_commands),getString(R.string.manage_memory),getString(R.string.optimizing_device),getString(R.string.other_general_tips),getString(R.string.privacy_and_security),getString(R.string.reduce_data_usage),getString(R.string.speedup_android),getString(R.string.use_to_otg),getString(R.string.using_google_now),getString(R.string.get_longer_battery),getString(R.string.save_battery),getString(R.string.add_hand_to_type),getString(R.string.get_warning_over_data_limits),getString(R.string.get_your_lost_phone_back))
        binding.lvAndroidTipsItem.adapter = CustomItemListAdapter(this, itemList, itemIcons)
    }

    private fun initListener() {
        binding.btnBack.setOnClickListener(this)
        binding.lvAndroidTipsItem.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->

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
                            val intent = Intent(applicationContext, AndroidTipsDetailsActivity::class.java)
                            intent.putExtra("keys", i)
                            startActivity(intent)
                        }

                        override fun onNextAction() {
                            super.onNextAction()
                            val intent = Intent(applicationContext, AndroidTipsDetailsActivity::class.java)
                            intent.putExtra("keys", i)
                            startActivity(intent)
                        }

                    },
                    true
                )
            } else {
                loadInterstitial()
                val intent = Intent(applicationContext, AndroidTipsDetailsActivity::class.java)
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