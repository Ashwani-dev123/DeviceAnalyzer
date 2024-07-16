package com.example.githhubdemo.deviceinfo.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.ActivityDeviceinfoBinding


class DeviceInfoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewBinding : ActivityDeviceinfoBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDeviceinfoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)

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

    override fun onBackPressed() {
        finish()
    }
}