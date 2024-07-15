package com.example.githhubdemo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.ActivitySecretCodeBinding


class SecretCodeActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var binding : ActivitySecretCodeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecretCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)

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
                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                intent.putExtra("keys", "Samsung")
                startActivity(intent)
            }
            R.id.cvOppo -> {
                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                intent.putExtra("keys", "Oppo")
                startActivity(intent)
            }
            R.id.cvMi -> {
                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                intent.putExtra("keys", "Xiaomi")
                startActivity(intent)
            }
            R.id.cvVivo -> {
                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                intent.putExtra("keys", "Vivo")
                startActivity(intent)
            }
            R.id.cvHtc -> {
                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                intent.putExtra("keys", "Htc")
                startActivity(intent)
            }
            R.id.cvRealme -> {
                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                intent.putExtra("keys", "Realme")
                startActivity(intent)
            }
            R.id.cvAsus -> {
                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                intent.putExtra("keys", "Asus")
                startActivity(intent)
            }
            R.id.cvIphone -> {
                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                intent.putExtra("keys", "iPhone")
                startActivity(intent)
            }
            R.id.cvSony -> {
                val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                intent.putExtra("keys", "Sony")
                startActivity(intent)
            }
               R.id.cvHuawei -> {
                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                   intent.putExtra("keys", "Huawei")
                   startActivity(intent)
               }
               R.id.cvLg -> {
                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                   intent.putExtra("keys", "Lg")
                   startActivity(intent)
               }
               R.id.cvOnePlus -> {
                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                   intent.putExtra("keys", "OnePlus")
                   startActivity(intent)
               }
               R.id.cvAcer -> {
                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                   intent.putExtra("keys", "Acer")
                   startActivity(intent)
               }
               R.id.cvLenovo -> {
                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                   intent.putExtra("keys", "Lenovo")
                   startActivity(intent)
               }
               R.id.cvZte -> {
                   val intent = Intent(applicationContext, SecretCodeListActivity::class.java)
                   intent.putExtra("keys", "Zte")
                   startActivity(intent)
               }
        }
    }
}