package com.example.githhubdemo.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.isVisible
import com.ads.narayan.ads.NarayanAd
import com.ads.narayan.ads.NarayanAdCallback
import com.ads.narayan.ads.wrapper.NarayanAdError
import com.ads.narayan.ads.wrapper.NarayanInterstitialAd
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.ActivitySecretCodeBinding
import com.example.githhubdemo.utils.ShareModule
import com.example.githhubdemo.utils.SharedPrefsUtilsModule
import com.example.githhubdemo.utils.Util


class SecretCodeActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var binding : ActivitySecretCodeBinding
    private var mInterstitialAd: NarayanInterstitialAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecretCodeBinding.inflate(layoutInflater)
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
    }

    private fun initListener() {
        binding.btnBack.setOnClickListener(this)
        binding.cvSamsung.setOnClickListener(this)
        binding.cvOppo.setOnClickListener(this)
        binding.cvMi.setOnClickListener(this)
        binding.cvVivo.setOnClickListener(this)
        binding.cvHtc.setOnClickListener(this)
        binding.cvRealme.setOnClickListener(this)
        binding.cvAsus.setOnClickListener(this)
        binding.cvIphone.setOnClickListener(this)
        binding.cvSony.setOnClickListener(this)
        binding.cvHuawei.setOnClickListener(this)
        binding.cvLg.setOnClickListener(this)
        binding.cvOnePlus.setOnClickListener(this)
        binding.cvAcer.setOnClickListener(this)
        binding.cvLenovo.setOnClickListener(this)
        binding.cvZte.setOnClickListener(this)
    }

    override fun onClick(view : View?) {
        when (view!!.id) {
            R.id.btnBack -> {
                onBackPressed()
            }
            R.id.cvSamsung -> {
                if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                    NarayanAd.getInstance().forceShowInterstitial(
                        this,
                        mInterstitialAd,
                        object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                            intent.putExtra("keys", "Samsung")
                            startActivity(intent)
                        }

                            override fun onAdFailedToShow(adError: NarayanAdError?) {
                                super.onAdFailedToShow(adError)
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Samsung")
                                startActivity(intent)
                            }

                            override fun onNextAction() {
                                super.onNextAction()
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Samsung")
                                startActivity(intent)
                            }

                        },
                        true
                    )
                } else {
                    loadInterstitial()
                    val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                    intent.putExtra("keys", "Samsung")
                    startActivity(intent)
                }

            }
            R.id.cvOppo -> {
                if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                    NarayanAd.getInstance().forceShowInterstitial(
                        this,
                        mInterstitialAd,
                        object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                            intent.putExtra("keys", "Oppo")
                            startActivity(intent)
                        }

                            override fun onAdFailedToShow(adError: NarayanAdError?) {
                                super.onAdFailedToShow(adError)
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Oppo")
                                startActivity(intent)
                            }

                            override fun onNextAction() {
                                super.onNextAction()
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Oppo")
                                startActivity(intent)
                            }

                        },
                        true
                    )
                } else {
                    loadInterstitial()
                    val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                    intent.putExtra("keys", "Oppo")
                    startActivity(intent)
                }

            }
            R.id.cvMi -> {
                if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                    NarayanAd.getInstance().forceShowInterstitial(
                        this,
                        mInterstitialAd,
                        object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                            intent.putExtra("keys", "Xiaomi")
                            startActivity(intent)
                        }

                            override fun onAdFailedToShow(adError: NarayanAdError?) {
                                super.onAdFailedToShow(adError)
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Xiaomi")
                                startActivity(intent)
                            }

                            override fun onNextAction() {
                                super.onNextAction()
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Xiaomi")
                                startActivity(intent)
                            }

                        },
                        true
                    )
                } else {
                    loadInterstitial()
                    val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                    intent.putExtra("keys", "Xiaomi")
                    startActivity(intent)
                }

            }
            R.id.cvVivo -> {
                if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                    NarayanAd.getInstance().forceShowInterstitial(
                        this,
                        mInterstitialAd,
                        object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                            intent.putExtra("keys", "Vivo")
                            startActivity(intent)
                        }

                            override fun onAdFailedToShow(adError: NarayanAdError?) {
                                super.onAdFailedToShow(adError)
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Vivo")
                                startActivity(intent)
                            }

                            override fun onNextAction() {
                                super.onNextAction()
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Vivo")
                                startActivity(intent)
                            }

                        },
                        true
                    )
                } else {
                    loadInterstitial()
                    val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                    intent.putExtra("keys", "Vivo")
                    startActivity(intent)
                }

            }
            R.id.cvHtc -> {

                if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                    NarayanAd.getInstance().forceShowInterstitial(
                        this,
                        mInterstitialAd,
                        object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                            intent.putExtra("keys", "Htc")
                            startActivity(intent)
                        }

                            override fun onAdFailedToShow(adError: NarayanAdError?) {
                                super.onAdFailedToShow(adError)
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Htc")
                                startActivity(intent)
                            }

                            override fun onNextAction() {
                                super.onNextAction()
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Htc")
                                startActivity(intent)
                            }

                        },
                        true
                    )
                } else {
                    loadInterstitial()
                    val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                    intent.putExtra("keys", "Htc")
                    startActivity(intent)
                }

            }
            R.id.cvRealme -> {
                if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                    NarayanAd.getInstance().forceShowInterstitial(
                        this,
                        mInterstitialAd,
                        object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                            intent.putExtra("keys", "Realme")
                            startActivity(intent)
                        }

                            override fun onAdFailedToShow(adError: NarayanAdError?) {
                                super.onAdFailedToShow(adError)
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Realme")
                                startActivity(intent)
                            }

                            override fun onNextAction() {
                                super.onNextAction()
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Realme")
                                startActivity(intent)
                            }

                        },
                        true
                    )
                } else {
                    loadInterstitial()
                    val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                    intent.putExtra("keys", "Realme")
                    startActivity(intent)
                }

            }
            R.id.cvAsus -> {
                if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                    NarayanAd.getInstance().forceShowInterstitial(
                        this,
                        mInterstitialAd,
                        object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                            intent.putExtra("keys", "Asus")
                            startActivity(intent)
                        }

                            override fun onAdFailedToShow(adError: NarayanAdError?) {
                                super.onAdFailedToShow(adError)
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Asus")
                                startActivity(intent)
                            }

                            override fun onNextAction() {
                                super.onNextAction()
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Asus")
                                startActivity(intent)
                            }

                        },
                        true
                    )
                } else {
                    loadInterstitial()
                    val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                    intent.putExtra("keys", "Asus")
                    startActivity(intent)
                }

            }
            R.id.cvIphone -> {
                if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                    NarayanAd.getInstance().forceShowInterstitial(
                        this,
                        mInterstitialAd,
                        object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                            intent.putExtra("keys", "iPhone")
                            startActivity(intent)
                        }

                            override fun onAdFailedToShow(adError: NarayanAdError?) {
                                super.onAdFailedToShow(adError)
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "iPhone")
                                startActivity(intent)
                            }

                            override fun onNextAction() {
                                super.onNextAction()
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "iPhone")
                                startActivity(intent)
                            }

                        },
                        true
                    )
                } else {
                    loadInterstitial()
                    val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                    intent.putExtra("keys", "iPhone")
                    startActivity(intent)
                }

            }
            R.id.cvSony -> {

                if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                    NarayanAd.getInstance().forceShowInterstitial(
                        this,
                        mInterstitialAd,
                        object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                            intent.putExtra("keys", "Sony")
                            startActivity(intent)
                        }

                            override fun onAdFailedToShow(adError: NarayanAdError?) {
                                super.onAdFailedToShow(adError)
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Sony")
                                startActivity(intent)
                            }

                            override fun onNextAction() {
                                super.onNextAction()
                                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                intent.putExtra("keys", "Sony")
                                startActivity(intent)
                            }

                        },
                        true
                    )
                } else {
                    loadInterstitial()
                    val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                    intent.putExtra("keys", "Sony")
                    startActivity(intent)
                }


            }
               R.id.cvHuawei -> {

                   if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                       NarayanAd.getInstance().forceShowInterstitial(
                           this,
                           mInterstitialAd,
                           object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                            intent.putExtra("keys", "Huawei")
                            startActivity(intent)
                        }

                               override fun onAdFailedToShow(adError: NarayanAdError?) {
                                   super.onAdFailedToShow(adError)
                                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                   intent.putExtra("keys", "Huawei")
                                   startActivity(intent)
                               }

                               override fun onNextAction() {
                                   super.onNextAction()
                                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                   intent.putExtra("keys", "Huawei")
                                   startActivity(intent)
                               }

                           },
                           true
                       )
                   } else {
                       loadInterstitial()
                       val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                       intent.putExtra("keys", "Huawei")
                       startActivity(intent)
                   }

               }
               R.id.cvLg -> {

                   if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                       NarayanAd.getInstance().forceShowInterstitial(
                           this,
                           mInterstitialAd,
                           object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                            intent.putExtra("keys", "Lg")
                            startActivity(intent)
                        }

                               override fun onAdFailedToShow(adError: NarayanAdError?) {
                                   super.onAdFailedToShow(adError)
                                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                   intent.putExtra("keys", "Lg")
                                   startActivity(intent)
                               }

                               override fun onNextAction() {
                                   super.onNextAction()
                                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                   intent.putExtra("keys", "Lg")
                                   startActivity(intent)
                               }

                           },
                           true
                       )
                   } else {
                       loadInterstitial()
                       val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                       intent.putExtra("keys", "Lg")
                       startActivity(intent)
                   }


               }
               R.id.cvOnePlus -> {

                   if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                       NarayanAd.getInstance().forceShowInterstitial(
                           this,
                           mInterstitialAd,
                           object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                            intent.putExtra("keys", "OnePlus")
                            startActivity(intent)
                        }

                               override fun onAdFailedToShow(adError: NarayanAdError?) {
                                   super.onAdFailedToShow(adError)
                                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                   intent.putExtra("keys", "OnePlus")
                                   startActivity(intent)
                               }

                               override fun onNextAction() {
                                   super.onNextAction()
                                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                   intent.putExtra("keys", "OnePlus")
                                   startActivity(intent)
                               }

                           },
                           true
                       )
                   } else {
                       loadInterstitial()
                       val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                       intent.putExtra("keys", "OnePlus")
                       startActivity(intent)
                   }

               }
               R.id.cvAcer -> {

                   if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                       NarayanAd.getInstance().forceShowInterstitial(
                           this,
                           mInterstitialAd,
                           object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                            intent.putExtra("keys", "Acer")
                            startActivity(intent)
                        }

                               override fun onAdFailedToShow(adError: NarayanAdError?) {
                                   super.onAdFailedToShow(adError)
                                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                   intent.putExtra("keys", "Acer")
                                   startActivity(intent)
                               }

                               override fun onNextAction() {
                                   super.onNextAction()
                                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                   intent.putExtra("keys", "Acer")
                                   startActivity(intent)
                               }

                           },
                           true
                       )
                   } else {
                       loadInterstitial()
                       val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                       intent.putExtra("keys", "Acer")
                       startActivity(intent)
                   }

               }
               R.id.cvLenovo -> {
                   if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                       NarayanAd.getInstance().forceShowInterstitial(
                           this,
                           mInterstitialAd,
                           object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                            intent.putExtra("keys", "Lenovo")
                            startActivity(intent)
                        }

                               override fun onAdFailedToShow(adError: NarayanAdError?) {
                                   super.onAdFailedToShow(adError)
                                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                   intent.putExtra("keys", "Lenovo")
                                   startActivity(intent)
                               }

                               override fun onNextAction() {
                                   super.onNextAction()
                                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                   intent.putExtra("keys", "Lenovo")
                                   startActivity(intent)
                               }

                           },
                           true
                       )
                   } else {
                       loadInterstitial()
                       val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                       intent.putExtra("keys", "Lenovo")
                       startActivity(intent)
                   }

               }
               R.id.cvZte -> {

                   if (mInterstitialAd != null && mInterstitialAd!!.isReady) {
                       NarayanAd.getInstance().forceShowInterstitial(
                           this,
                           mInterstitialAd,
                           object : NarayanAdCallback() {

                        override fun onAdClosed() {
                            super.onAdClosed()
                            val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                            intent.putExtra("keys", "Zte")
                            startActivity(intent)
                        }

                               override fun onAdFailedToShow(adError: NarayanAdError?) {
                                   super.onAdFailedToShow(adError)
                                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                   intent.putExtra("keys", "Zte")
                                   startActivity(intent)
                               }

                               override fun onNextAction() {
                                   super.onNextAction()
                                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                                   intent.putExtra("keys", "Zte")
                                   startActivity(intent)
                               }

                           },
                           true
                       )
                   } else {
                       loadInterstitial()
                       val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                       intent.putExtra("keys", "Zte")
                       startActivity(intent)
                   }

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

                        override fun onAdClosed() {
                            super.onAdClosed()
                            finish()
                        }

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