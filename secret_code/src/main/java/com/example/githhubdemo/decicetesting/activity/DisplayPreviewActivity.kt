package com.example.githhubdemo.decicetesting.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.githhubdemo.databinding.ActivityDisplayPreviewBinding


class DisplayPreviewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDisplayPreviewBinding
    private val O = intArrayOf(-16711936,-1, -16777216, -65536, -16776961)
    private var N = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setColor(0)

        binding.llText.isVisible = true

        binding.container.setOnClickListener {
            if (binding.llText.isVisible) {
                binding.llText.isVisible = false
            }
            else {
                if (N == 4) {
                    finish()
                } else {
                    setDisplayColor()
                }
            }

        }

    }

    private fun setDisplayColor() {
        val nextIndex = (N + 1) % O.size
        setColor(nextIndex)
    }

    private fun setColor(i: Int) {
        if (i in 0 until O.size) {
            N = i
            val color = O[i]
            binding.container.setBackgroundColor(color)

        }
    }
}