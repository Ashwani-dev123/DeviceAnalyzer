package com.example.githhubdemo.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowInsets
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.ads.narayan.ads.NarayanAd
import com.ads.narayan.ads.NarayanAdCallback
import com.ads.narayan.ads.wrapper.NarayanAdError
import com.ads.narayan.ads.wrapper.NarayanInterstitialAd
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.ActivityMobileTrickDetailsBinding
import com.example.githhubdemo.adapter.MobileTrickAdapter
import com.example.githhubdemo.model.MobileTrickModel
import com.example.githhubdemo.utils.ShareModule
import com.example.githhubdemo.utils.SharedPrefsUtilsModule
import com.example.githhubdemo.utils.Util


class MobileTrickDetailsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMobileTrickDetailsBinding
    private var fromNotification = false
    private var mInterstitialAd: NarayanInterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMobileTrickDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
//            window.decorView.setOnApplyWindowInsetsListener { view, insets ->
//                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
//                    val statusBarHeight = insets.getInsets(WindowInsets.Type.statusBars()).top
//                    view.setPadding(0, statusBarHeight, 0, 0)
//                    view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorStatusBar))
//                } else {
//                    @Suppress("DEPRECATION")
//                    window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)
//                }
//
//                insets
//            }
//        }
//        else
//        {
//            window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)
//        }

        fromNotification = intent.getBooleanExtra("fromNotification", false)

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
        setListData()
    }

    private fun initListener() {
        binding.btnBack.setOnClickListener(this)
    }

    private fun loadInterstitial() {
        if (Util.isNetworkConnected(this)) {
            if (SharedPrefsUtilsModule.getString(this,ShareModule.INTERSTITIAL_ID,"") != "") {
                mInterstitialAd = NarayanAd.getInstance().getInterstitialAds(this , SharedPrefsUtilsModule.getString(this,ShareModule.INTERSTITIAL_ID))
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

    private fun setListData() {
        when (intent.getIntExtra("keys", 0)) {
            0 -> {
                binding.tvToolbar.text = getString(R.string.unknown_facts)
                val unknownFacts = ArrayList<MobileTrickModel>()
                unknownFacts.add(MobileTrickModel(getString(R.string.the_facts_about_android_that_you_should_know),getString(R.string.android_history_info)))
                unknownFacts.add(MobileTrickModel(getString(R.string.google_didn_t_create_android),getString(R.string.android_google_info)))
                unknownFacts.add(MobileTrickModel(getString(R.string.many_critics_thought_android),getString(R.string.android_critics_info)))
                unknownFacts.add(MobileTrickModel(getString(R.string.the_first_android_prototype_looked),getString(R.string.android_versions_info)))
                unknownFacts.add(MobileTrickModel(getString(R.string.android_1_0_and_1_1_weren_t_named),getString(R.string.android_version_names_info)))
                unknownFacts.add(MobileTrickModel(getString(R.string.android_3_0_is_the_only_version_to_never),getString(R.string.android_tablet_history_info)))
                unknownFacts.add(MobileTrickModel(getString(R.string.first_android_phone_didn_t_even),getString(R.string.android_t_mobile_g1_history_info)))
                unknownFacts.add(MobileTrickModel(getString(R.string.webos_could_have_destroyed),getString(R.string.android_webos_history)))
                unknownFacts.add(MobileTrickModel(getString(R.string.sony_made_the_first_android2010),getString(R.string.android_smartwatch_history)))
                unknownFacts.add(MobileTrickModel(getString(R.string.some_more_facts),getString(R.string.android_facts)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(unknownFacts, this)
            }
            1 -> {
                binding.tvToolbar.text = getString(R.string.recover_file)
                val recoverFileArrayList = ArrayList<MobileTrickModel>()
                recoverFileArrayList.add(MobileTrickModel(getString(R.string.how_to_retrieve),getString(R.string.android_data_recovery_info)))
                recoverFileArrayList.add(MobileTrickModel(getString(R.string.quick_answer),getString(R.string.file_recovery_methods_info)))
                recoverFileArrayList.add(MobileTrickModel(getString(R.string.stop_using_your_phone_and_put),getString(R.string.android_data_recovery_tips_info)))
                recoverFileArrayList.add(MobileTrickModel(getString(R.string.check_your_recycle_bin),getString(R.string.recycle_bin_info)))
                recoverFileArrayList.add(MobileTrickModel(getString(R.string.check_cloud_backup),getString(R.string.google_photos_bin_info)))
                recoverFileArrayList.add(MobileTrickModel(getString(R.string.how_to_retrieve_whatsapp),getString(R.string.whatsapp_backup_info)))
                recoverFileArrayList.add(MobileTrickModel(getString(R.string.try_android_data_recovery_apps),getString(R.string.android_data_recovery)))
                recoverFileArrayList.add(MobileTrickModel(getString(R.string.android_data_recovery_services),getString(R.string.data_recovery_service_info)))
                recoverFileArrayList.add(MobileTrickModel(getString(R.string.contact_the_developer),getString(R.string.developer_assistance_info)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(recoverFileArrayList, this)
            }
            2 -> {
                binding.tvToolbar.text = getString(R.string.improve_battery)
                val batteryArrayList = ArrayList<MobileTrickModel>()
                batteryArrayList.add(MobileTrickModel(getString(R.string.how_to_improve_android_battery) + "Timing?",getString(R.string.battery_saving_tips)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(batteryArrayList, this)
            }
            3 -> {
                binding.tvToolbar.text = getString(R.string.unlock_pattern)
                val unlockPatternArrayList = ArrayList<MobileTrickModel>()
                unlockPatternArrayList.add(MobileTrickModel(getString(R.string.how_to_unlock_android_lock_pattern) + getString(R.string.using_command_prompt),getString(R.string.unlock_phone_instructions)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(unlockPatternArrayList, this)
            }
            4 -> {
                binding.tvToolbar.text = getString(R.string.break_pattern)
                val breakPatternArrayList = ArrayList<MobileTrickModel>()
                breakPatternArrayList.add(MobileTrickModel(getString(R.string.unlock_locked_pattern_without),getString(R.string.unlock_pattern_description)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(breakPatternArrayList, this)
            }
            5 -> {
                binding.tvToolbar.text = getString(R.string.wifi_hotspot)
                val wifiHotspotArrayList = ArrayList<MobileTrickModel>()
                wifiHotspotArrayList.add(MobileTrickModel(getString(R.string.how_to_use_wifi_hotspot),getString(R.string.hotspot_instructions)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(wifiHotspotArrayList, this)
            }

            6 -> {
                binding.tvToolbar.text = getString(R.string.screen_magnifier)
                val screenMagnifierArrayList = ArrayList<MobileTrickModel>()
                screenMagnifierArrayList.add(MobileTrickModel(getString(R.string.how_to_enable_screen_magnifier),getString(R.string.magnification_instructions)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(screenMagnifierArrayList, this)
            }
            7 -> {
                binding.tvToolbar.text = getString(R.string.show_wifi_password)
                val showWifiPassArrayList = ArrayList<MobileTrickModel>()
                showWifiPassArrayList.add(MobileTrickModel(getString(R.string.wifi_password),getString(R.string.wifi_password_instructions)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(showWifiPassArrayList, this)
            }
            8 -> {
                binding.tvToolbar.text = getString(R.string.block_bluetooth)
                val blackBluetoothArrayList = ArrayList<MobileTrickModel>()
                blackBluetoothArrayList.add(MobileTrickModel(getString(R.string.how_to_block_bluetooth),getString(R.string.bluetooth_instructions)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(blackBluetoothArrayList, this)
            }
            9 -> {
                binding.tvToolbar.text = getString(R.string.take_screenshots)
                val takeScreenshotArrayList = ArrayList<MobileTrickModel>()
                takeScreenshotArrayList.add(MobileTrickModel(getString(R.string.how_to_take_screen_shoot),getString(R.string.button_combinations_instructions)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(takeScreenshotArrayList, this)
            }
            10 -> {
                binding.tvToolbar.text = getString(R.string.delete_notification)
                val deleteNotificationArrayList = ArrayList<MobileTrickModel>()
                deleteNotificationArrayList.add(MobileTrickModel(getString(R.string.see_your_notifications_even),getString(R.string.notifications_instructions)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(deleteNotificationArrayList, this)
            }
            11 -> {
                binding.tvToolbar.text = getString(R.string.hard_factory_reset)
                val hardFactoryResetArrayList = ArrayList<MobileTrickModel>()
                hardFactoryResetArrayList.add(MobileTrickModel(getString(R.string.hard_reset_and_factory_reset),getString(R.string.formatting_instructions)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(hardFactoryResetArrayList, this)
            }
            12 -> {
                binding.tvToolbar.text = getString(R.string.control_your_laptop)
                val controlLaptopArrayList = ArrayList<MobileTrickModel>()
                controlLaptopArrayList.add(MobileTrickModel(getString(R.string.how_to_control_your_laptop),getString(R.string.teamviewer_instructions)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(controlLaptopArrayList, this)
            }
            13 -> {
                binding.tvToolbar.text = getString(R.string.control_your_android)
                val controlAndroidArrayList = ArrayList<MobileTrickModel>()
                controlAndroidArrayList.add(MobileTrickModel(getString(R.string.how_to_control_your_android),getString(R.string.control_instructions)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(controlAndroidArrayList, this)
            }
            14 -> {
                binding.tvToolbar.text = getString(R.string.radiation_level)
                val radiationLevelArrayList = ArrayList<MobileTrickModel>()
                radiationLevelArrayList.add(MobileTrickModel(getString(R.string.check_the_radiation_level_of),getString(R.string.safety_instructions)))
                radiationLevelArrayList.add(MobileTrickModel(getString(R.string.what_is_sar_value),getString(R.string.safety_explanation)))
                radiationLevelArrayList.add(MobileTrickModel(getString(R.string.how_to_check_sar_value),getString(R.string.sar_value_check_process)))
                radiationLevelArrayList.add(MobileTrickModel(getString(R.string.does_your_phone_fall),getString(R.string.sar_guide)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(radiationLevelArrayList, this)
            }
            15 -> {
                binding.tvToolbar.text = getString(R.string.how_to_backup_your)
                val backupAndroidPhoneArrayList = ArrayList<MobileTrickModel>()
                backupAndroidPhoneArrayList.add(MobileTrickModel(getString(R.string.how_to_back_up_your_android_phone),getString(R.string.backup_guide)))
                binding.mobileTrickDetailsList.adapter = MobileTrickAdapter(backupAndroidPhoneArrayList, this)
            }
        }
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        Log.e("CHECKBANNERID", "fromNotification!! : ==> $fromNotification")
        if (fromNotification) {

            Log.e(
                "CHECKBANNERID",
                "INTERSTITIAL_ID : ==> " + SharedPrefsUtilsModule.getString(
                    this,
                    ShareModule.INTERSTITIAL_ID,
                    ""
                )
            )
            if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                Log.e(
                    "CHECKBANNERID",
                    "mInterstitialAd!!.isReady : ==> " + mInterstitialAd!!.isReady
                )
                NarayanAd.getInstance().forceShowInterstitial(
                    this,
                    mInterstitialAd,
                    object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            finish()
                        }

                        override fun onAdFailedToLoad(adError: NarayanAdError?) {
                            super.onAdFailedToLoad(adError)
                            Log.e("CHECKBANNERID", "onAdFailedToLoad : ++> " + adError!!.message)
                        }

                        override fun onInterstitialLoad(interstitialAd: NarayanInterstitialAd?) {
                            super.onInterstitialLoad(interstitialAd)

                            Log.e(
                                "CHECKBANNERID",
                                "onInterstitialLoad ---> :  " + interstitialAd!!.isLoading
                            )
                        }

                        override fun onAdLoaded() {
                            super.onAdLoaded()
                            Log.e("CHECKBANNERID", "onAdLoaded : ==> ")
                        }

                        override fun onInterstitialShow() {
                            super.onInterstitialShow()

                            Log.e("CHECKBANNERID", "onInterstitialShow ---> :  ")
                        }

                        override fun onAdFailedToShow(adError: NarayanAdError?) {
                            super.onAdFailedToShow(adError)
                            Log.e("CHECKBANNERID", "onAdFailedToShow : ==> " + adError!!.message)
                            finish()
                        }

                        /* override fun onNextAction() {
                             super.onNextAction()
                             Log.e("CHECKBANNERID", "onNextAction : ==> ")
                             //finish()
                         }*/

                    },
                    false
                )
            } else {
                loadInterstitial()
                finish()
            }
        } else {
            finish()
        }

    }
}