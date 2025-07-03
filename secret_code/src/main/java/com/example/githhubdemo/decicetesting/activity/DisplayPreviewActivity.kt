package com.example.githhubdemo.decicetesting.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.ActivityDisplayPreviewBinding


class DisplayPreviewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDisplayPreviewBinding
    private val O = intArrayOf(-16711936,-1, -16777216, -65536, -16776961)
    private var N = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBar)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.container) { v: View, insets: WindowInsetsCompat ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

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