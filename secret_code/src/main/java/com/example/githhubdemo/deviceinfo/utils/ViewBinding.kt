package com.example.githhubdemo.deviceinfo.utils

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar
import com.example.githhubdemo.R
import com.example.githhubdemo.deviceinfo.data.model.CPULoad
import com.example.githhubdemo.deviceinfo.data.model.CpuInfo
import com.example.githhubdemo.deviceinfo.data.model.RamLoad

@BindingAdapter("coreNumber")
fun TextView.coreNumber(coreNumber: Int) {
    text = resources.getString(R.string.coreNumber, coreNumber.toString())
}

@BindingAdapter("integerText")
fun TextView.integerText(number: Long) {
    text = resources.getString(R.string.mhzString, number.toString())
}

@BindingAdapter("coreProgress")
fun IconRoundCornerProgressBar.progress(cpuInfo: CpuInfo.Frequency) {
    max = cpuInfo.max.toFloat()
    progress = cpuInfo.current.toFloat()
}

@BindingAdapter("cpuIcon")
fun IconRoundCornerProgressBar.setCpuIcon(cpuLoad: CPULoad) {
    iconImageResource = when (cpuLoad) {
        CPULoad.Low -> R.drawable.ic_cpu_low
        CPULoad.Medium -> R.drawable.ic_cpu_med
        CPULoad.High -> R.drawable.ic_cpu_high
    }
}

@BindingAdapter("progressColor")
fun IconRoundCornerProgressBar.setProgressColor(cpuLoad: CPULoad) {
    val startColor = progressColor
    val endColor = when (cpuLoad) {
        CPULoad.Low -> Color.parseColor("#FFFFFF")
        CPULoad.Medium -> Color.parseColor("#FFFFFF")
        CPULoad.High -> Color.parseColor("#FFFFFF")
    }

    val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), startColor, endColor)
    colorAnimation.duration = 500 // duration in milliseconds
    colorAnimation.addUpdateListener { animator ->
        progressColor = animator.animatedValue as Int
    }
    colorAnimation.start()
}

@BindingAdapter("ramLoadColor")
fun CardView.setRamLoadColor(ramLoad: RamLoad?) {
    val startColor = cardBackgroundColor.defaultColor
    val endColor = when (ramLoad) {
        RamLoad.Low -> Color.parseColor("#FFFFFF")
        RamLoad.Medium -> Color.parseColor("#FFFFFF")
        RamLoad.High -> Color.parseColor("#FFFFFF")
        else -> Color.parseColor("#FFFFFF")
    }

    val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), startColor, endColor)
    colorAnimation.duration = 300 // duration in milliseconds
    colorAnimation.addUpdateListener { animator ->
        setCardBackgroundColor(animator.animatedValue as Int)
    }
    colorAnimation.start()
}
