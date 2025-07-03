package com.example.githhubdemo.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
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
import com.example.githhubdemo.databinding.ActivityAndroidTipsDetailsBinding
import com.example.githhubdemo.model.MobileTrickModel
import com.example.githhubdemo.adapter.MobileTrickAdapter
import com.example.githhubdemo.utils.ShareModule
import com.example.githhubdemo.utils.SharedPrefsUtilsModule
import com.example.githhubdemo.utils.Util


class AndroidTipsDetailsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityAndroidTipsDetailsBinding
    private var fromNotification = false
    private var mInterstitialAd: NarayanInterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidTipsDetailsBinding.inflate(layoutInflater)
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

    private fun loadInterstitial() {
        if (Util.isNetworkConnected(this)) {
            if (SharedPrefsUtilsModule.getString(this,ShareModule.INTERSTITIAL_ID,"") != "") {
                mInterstitialAd = NarayanAd.getInstance().getInterstitialAds(this , SharedPrefsUtilsModule.getString(this,ShareModule.INTERSTITIAL_ID))
            }
        }

    }

    private fun initListener() {
        binding.btnBack.setOnClickListener(this)
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
                binding.tvToolbar.text = getString(R.string.add_internet_speed)
                val internetSpeedList = ArrayList<MobileTrickModel>()
                internetSpeedList.add(MobileTrickModel(getString(R.string.indicator_in_android_phones),getString(R.string.internet_speed_meter_info)))
                internetSpeedList.add(MobileTrickModel(getString(R.string.indicator_in_xiaomi_phones),getString(R.string.miui_internet_speed_info)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(internetSpeedList, this)
            }

            1 -> {
                binding.tvToolbar.text = getString(R.string.add_owner_information)
                val ownerInfoList = ArrayList<MobileTrickModel>()
                ownerInfoList.add(MobileTrickModel(getString(R.string.how_to_add_owner_information),getString(R.string.owner_info_instructions)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(ownerInfoList, this)
            }
            2 -> {
                binding.tvToolbar.text = getString(R.string.first_few_things_to_do)
                val fewThingsToDoList = ArrayList<MobileTrickModel>()
                fewThingsToDoList.add(MobileTrickModel(getString(R.string.add_owner_info),getString(R.string.owner_info_crucial_steps)))
                fewThingsToDoList.add(MobileTrickModel(getString(R.string.enable_device_manager),getString(R.string.device_manager_tracking)))
                fewThingsToDoList.add(MobileTrickModel(getString(R.string.setup_your_google_account),getString(R.string.set_up_google_account)))
                fewThingsToDoList.add(MobileTrickModel(getString(R.string.enable_usb),getString(R.string.enable_usb_debugging)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(fewThingsToDoList, this)
            }

            3 -> {
                binding.tvToolbar.text = getString(R.string.gesture_setting)
                val gestureSettingList = ArrayList<MobileTrickModel>()
                gestureSettingList.add(MobileTrickModel(getString(R.string.long_press_on_notifications),getString(R.string.android_notification_shortcuts)))
                gestureSettingList.add(MobileTrickModel(getString(R.string.slide_two_fingers_down_to_directly),getString(R.string.android_quick_settings_tip)))
                gestureSettingList.add(MobileTrickModel(getString(R.string.double_tap_to_select_words),getString(R.string.android_text_selection_feature)))
                gestureSettingList.add(MobileTrickModel(getString(R.string.easily_access_safe_mode),getString(R.string.android_safe_mode_instructions)))
                gestureSettingList.add(MobileTrickModel(getString(R.string.zoom_in_on_any_screen),getString(R.string.magnification_gestures_instructions)))
                gestureSettingList.add(MobileTrickModel(getString(R.string.uninstall_an_app_directly),getString(R.string.uninstall_apps_home_screen)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(gestureSettingList, this)
            }

            4 -> {
                binding.tvToolbar.text = getString(R.string.google_now_commands)
                val googleCommandsList = ArrayList<MobileTrickModel>()
                googleCommandsList.add(MobileTrickModel(getString(R.string.general_information),getString(R.string.search_requests)))
                googleCommandsList.add(MobileTrickModel(getString(R.string.device_control),getString(R.string.user_requests)))
                googleCommandsList.add(MobileTrickModel(getString(R.string.productivity),getString(R.string.user_request)))
                googleCommandsList.add(MobileTrickModel(getString(R.string.communication),getString(R.string.user_details)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(googleCommandsList, this)
            }

            5 -> {
                binding.tvToolbar.text = getString(R.string.manage_memory)
                val memoryManageList = ArrayList<MobileTrickModel>()
                memoryManageList.add(MobileTrickModel("",getString(R.string.storage_management_tips)))
                memoryManageList.add(MobileTrickModel(getString(R.string.use_android_built_in),getString(R.string.manage_storage_instructions)))
                memoryManageList.add(MobileTrickModel(getString(R.string.see_which_folders_and_files_are),getString(R.string.disk_usage_instructions)))
                memoryManageList.add(MobileTrickModel(getString(R.string.add_an_sd_card_and_move),getString(R.string.expand_storage_instructions)))
                memoryManageList.add(MobileTrickModel(getString(R.string.move_photos_to_the_cloud),getString(R.string.free_up_space_photos_cloud)))
                memoryManageList.add(MobileTrickModel(getString(R.string.clear_data_of_apps_taking),getString(R.string.clear_app_data_instructions)))
                memoryManageList.add(MobileTrickModel(getString(R.string.empty_the_cache),getString(R.string.clear_app_cache_instructions)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(memoryManageList, this)
            }
            6 -> {
                binding.tvToolbar.text = getString(R.string.optimizing_device)
                val optimizeDeviceList = ArrayList<MobileTrickModel>()
                optimizeDeviceList.add(MobileTrickModel(getString(R.string.how_to_check_for_android),getString(R.string.check_system_updates_instructions)))
                optimizeDeviceList.add(MobileTrickModel(getString(R.string.changing_default_apps),getString(R.string.manage_storage_instructions)))
                optimizeDeviceList.add(MobileTrickModel(getString(R.string.organize_homescreen),getString(R.string.organize_home_screen_folders_instructions)))
                optimizeDeviceList.add(MobileTrickModel(getString(R.string.disable_animations),getString(R.string.disable_animations_instructions)))
                optimizeDeviceList.add(MobileTrickModel(getString(R.string.how_to_turn_off_auto),getString(R.string.turn_off_autocorrection_instructions)))
                optimizeDeviceList.add(MobileTrickModel(getString(R.string.changing_network),getString(R.string.change_network_preferences_instructions)))
                optimizeDeviceList.add(MobileTrickModel(getString(R.string.flash_message_on_lock_screen),getString(R.string.enable_flash_messages_instructions)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(optimizeDeviceList, this)
            }
            7 -> {
                binding.tvToolbar.text = getString(R.string.other_general_tips)
                val generalAppList = ArrayList<MobileTrickModel>()
                generalAppList.add(MobileTrickModel(getString(R.string.application_not_found),getString(R.string.sd_card_issue_explanation)))
                generalAppList.add(MobileTrickModel(getString(R.string.restore_my_phone_book),getString(R.string.restore_lost_contacts_methods)))
                generalAppList.add(MobileTrickModel(getString(R.string.sound_get_lower_when),getString(R.string.safety_volume_feature_explanation)))
                generalAppList.add(MobileTrickModel(getString(R.string.disable_facebook_video),getString(R.string.disable_video_autoplay_instructions)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(generalAppList, this)
            }
            8 -> {
                binding.tvToolbar.text = getString(R.string.privacy_and_security)
                val privacyPolicyAppList = ArrayList<MobileTrickModel>()
                privacyPolicyAppList.add(MobileTrickModel(getString(R.string.turn_off_android),getString(R.string.turn_off_location_tracking_instructions)))
                privacyPolicyAppList.add(MobileTrickModel(getString(R.string.tap_on_location_google),getString(R.string.disable_location_history_instructions)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(privacyPolicyAppList, this)
            }

            9 -> {
                binding.tvToolbar.text = getString(R.string.reduce_data_usage)
                val reduceDataList = ArrayList<MobileTrickModel>()
                reduceDataList.add(MobileTrickModel(getString(R.string.reduce_your_mobile),getString(R.string.follow_usage_tips)))
                reduceDataList.add(MobileTrickModel(getString(R.string.compress_chrome_pages),getString(R.string.compress_web_pages_instructions)))
                reduceDataList.add(MobileTrickModel(getString(R.string.use_opera_video),getString(R.string.compress_web_pages_instructions)))
                reduceDataList.add(MobileTrickModel(getString(R.string.ditch_the_facebook_app),getString(R.string.reduce_data_consumption_instructions)))
                reduceDataList.add(MobileTrickModel(getString(R.string.make_use_of_offline),getString(R.string.offline_apps_games_hint)))
                reduceDataList.add(MobileTrickModel(getString(R.string.restrict_background),getString(R.string.restrict_background_data_hint)))
                reduceDataList.add(MobileTrickModel(getString(R.string.disable_auto_updating),getString(R.string.prevent_auto_update_hint)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(reduceDataList, this)
            }
            10 -> {
                binding.tvToolbar.text = getString(R.string.speedup_android)
                val speedUpAndroidAppList = ArrayList<MobileTrickModel>()
                speedUpAndroidAppList.add(MobileTrickModel(getString(R.string.make_sure_you_re),getString(R.string.ensure_device_up_to_date_hint)))
                speedUpAndroidAppList.add(MobileTrickModel(getString(R.string.go_to_settings_about_device) + getString(R.string.software_update_and),getString(R.string.check_app_updates_hint)))
                speedUpAndroidAppList.add(MobileTrickModel(getString(R.string.clean_up_your_home_screen),getString(R.string.clean_up_home_screen_hint)))
                speedUpAndroidAppList.add(MobileTrickModel(getString(R.string.uninstall_and_disable),getString(R.string.uninstall_disable_apps_hint)))
                speedUpAndroidAppList.add(MobileTrickModel(getString(R.string.turn_off_or_reduce),getString(R.string.reduce_turn_off_animations_hint)))
                speedUpAndroidAppList.add(MobileTrickModel(getString(R.string.clear_cached_app_data),getString(R.string.clear_app_cache_hint)))
                speedUpAndroidAppList.add(MobileTrickModel(getString(R.string.turn_off_or_reduce_auto_sync),getString(R.string.turn_off_auto_sync_hint)))
                speedUpAndroidAppList.add(MobileTrickModel(getString(R.string.wipe_cache_partition),getString(R.string.wipe_cache_partition_hint)))
                speedUpAndroidAppList.add(MobileTrickModel(getString(R.string.perform_a_factory_reset),getString(R.string.factory_reset_hint)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(speedUpAndroidAppList, this)

            }
            11 -> {
                binding.tvToolbar.text = getString(R.string.use_to_otg)
                val useOtgAppList = ArrayList<MobileTrickModel>()
                useOtgAppList.add(MobileTrickModel("",getString(R.string.usb_otg_info)))
                useOtgAppList.add(MobileTrickModel(getString(R.string.how_do_i_know_if_my_android),getString(R.string.usb_otg_support_info)))
                useOtgAppList.add(MobileTrickModel(getString(R.string.what_can_i_do_with_usb),getString(R.string.usb_otg_capabilities_info)))
                useOtgAppList.add(MobileTrickModel(getString(R.string.connect_a_game_controller),getString(R.string.usb_otg_game_controller)))
                useOtgAppList.add(MobileTrickModel(getString(R.string.use_your_broken_smartphone),getString(R.string.usb_otg_broken_touchscreen)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(useOtgAppList, this)
            }
            12 -> {
                binding.tvToolbar.text = getString(R.string.using_google_now)
                val usingGoogleList = ArrayList<MobileTrickModel>()
                usingGoogleList.add(MobileTrickModel(getString(R.string.set_it_up_right),getString(R.string.google_now_setup_guide)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(usingGoogleList, this)
            }
            13 -> {
                binding.tvToolbar.text = getString(R.string.get_longer_battery)
                val getLongerBatteryList = ArrayList<MobileTrickModel>()
                getLongerBatteryList.add(MobileTrickModel(getString(R.string.disable_location_history),getString(R.string.gps_battery_usage)))
                getLongerBatteryList.add(MobileTrickModel(getString(R.string.disable_google_now_cards),getString(R.string.google_now_battery_drain)))
                getLongerBatteryList.add(MobileTrickModel(getString(R.string.wifi_scanning),getString(R.string.wifi_battery_drain)))
                getLongerBatteryList.add(MobileTrickModel(getString(R.string.update_all_your_software),getString(R.string.firmware_updates)))
                getLongerBatteryList.add(MobileTrickModel(getString(R.string.selective_mobile_network),getString(R.string.network_settings)))
                getLongerBatteryList.add(MobileTrickModel(getString(R.string.apps_that_increase_battery),getString(R.string.battery_optimization)))
                getLongerBatteryList.add(MobileTrickModel(getString(R.string.selective_synchronization),getString(R.string.battery_sync_settings)))
                getLongerBatteryList.add(MobileTrickModel(getString(R.string.adjust_brightness_levels),getString(R.string.battery_brightness_settings)))
                getLongerBatteryList.add(MobileTrickModel(getString(R.string.avoid_heavy_hitters),getString(R.string.battery_launcher_settings)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(getLongerBatteryList, this)
            }
            14 -> {
                binding.tvToolbar.text = getString(R.string.save_battery)
                val saveBatteryList = ArrayList<MobileTrickModel>()
                saveBatteryList.add(MobileTrickModel(getString(R.string.select_app_category_from),getString(R.string.battery_background_apps)))
                saveBatteryList.add(MobileTrickModel(getString(R.string.navigate_to_settings),getString(R.string.battery_energy_intensive_apps)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(saveBatteryList, this)
            }
            15 -> {
                binding.tvToolbar.text = getString(R.string.add_hand_to_type)
                val addHandList = ArrayList<MobileTrickModel>()
                addHandList.add(MobileTrickModel(getString(R.string.add_hard_to_type_words),getString(R.string.battery_background_apps)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(addHandList, this)
            }
            16 -> {
                binding.tvToolbar.text = getString(R.string.get_warning_over_data_limits)
                val getWarningList = ArrayList<MobileTrickModel>()
                getWarningList.add(MobileTrickModel("",getString(R.string.manage_data_usage)))
                getWarningList.add(MobileTrickModel(getString(R.string.avoid_common_data_plan) + getString(R.string.first_navigate_to_settings),getString(R.string.monitor_data_usage)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(getWarningList, this)
            }
            17 -> {
                binding.tvToolbar.text = getString(R.string.get_your_lost_phone_back)
                val saveBatteryByList = ArrayList<MobileTrickModel>()
                saveBatteryByList.add(MobileTrickModel("",getString(R.string.save_battery_by)))
                binding.androidTipsDetailsList.adapter = MobileTrickAdapter(saveBatteryByList, this)
            }
        }
    }

    override fun onBackPressed() {
        if (fromNotification) {
            if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                NarayanAd.getInstance().forceShowInterstitial(
                    this,
                    mInterstitialAd,
                    object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                           finish()
                        }

                        override fun onAdFailedToShow(adError: NarayanAdError?) {
                            super.onAdFailedToShow(adError)
                            finish()
                        }


                    },
                    false
                )
            } else {
                loadInterstitial()
                finish()
            }
        }
        else {
            finish()
        }

    }
}