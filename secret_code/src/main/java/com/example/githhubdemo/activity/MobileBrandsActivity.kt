package com.example.githhubdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.ActivityMobileBrandsBinding


class MobileBrandsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityMobileBrandsBinding
    private val brandNameList = arrayOf("SAMSUNG", "HTC", "SONY", "LENOVO", "BLACKBERRY", "MOTOROLA", "LG", "OPPO", "QMOBILE", "CHINA", "GENERIC", "MICROSOFT/WINDOW", "HUAWEI", "INFINIX", "VIVO", "ACER", "XIAOMI", "NOKIA", "Tecno", "ASUS", "HONOR", "IPHONE", "RealMe", "ZTE", "One Plus", "Plam", "Amol", "BQ-Mobile", "I-Mobile", "LEECO Mobile")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMobileBrandsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()

        binding.mobileBrands.adapter = ArrayAdapter(this, R.layout.mobile_brands_item_layout, R.id.devicename, brandNameList)

    }

    private fun initListener() {

        binding.mobileBrands.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->



        }
    }

    override fun onClick(view : View?) {

    }
}