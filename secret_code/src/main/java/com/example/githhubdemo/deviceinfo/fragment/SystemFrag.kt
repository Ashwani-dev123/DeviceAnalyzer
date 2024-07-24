package com.example.githhubdemo.deviceinfo.fragment

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.SystemFragmentBinding
import com.example.githhubdemo.deviceinfo.utils.launchAndCollectWithViewLifecycle
import com.example.githhubdemo.deviceinfo.viewmodel.DataViewModel
import com.example.githhubdemo.information
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SystemFrag : Fragment() {

    private var _binding: SystemFragmentBinding? = null
    private val binding get() = _binding!!
    private val dataViewModel: DataViewModel by viewModel()
    private var colorChangeJob: Job? = null

    fun SystemFrag() {
        // empty constructor
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SystemFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUIElements()
        startColorAnimation(binding.cardView)
    }

    private fun setupUIElements() {
        binding.listWithItems.layoutManager = LinearLayoutManager(requireContext())
        launchAndCollectWithViewLifecycle(dataViewModel.uptimeFlow) { systemUptimeInfo ->
            binding.listWithItems.withModels {
                dataViewModel.systemInfo.forEach { info ->
                    information {
                        id(info.title)
                        data(info)
                    }
                }
                // ADDS SYSTEM UPTIME FLOW
                information {
                    id(systemUptimeInfo.title)
                    data(systemUptimeInfo)
                }
            }
        }

        binding.androidNo.text = getString(
            R.string.android_version,
            dataViewModel.systemInfo.find { it.title == "Android Version" }?.details
        )

        val isRoot =
            dataViewModel.systemInfo.firstOrNull { it.title == "Root Access" }?.details
        binding.isRoot.text = getString(R.string.is_root, isRoot)
        binding.sdk.text = getString(
            R.string.sdk_version,
            dataViewModel.systemInfo.find { it.title == "Android Version" }?.details
        )
    }

    private fun startColorAnimation(cardView: CardView) {
        colorChangeJob = viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            val colors = listOf(
                Color.parseColor("#1E293B"),
                Color.parseColor("#3BB519"),
                Color.parseColor("#E61717")
            )

            while (isActive) {
                val startColor = cardView.cardBackgroundColor.defaultColor
                val endColor = ContextCompat.getColor(requireContext(),R.color.colorToolbar)

                val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), startColor, endColor)
                colorAnimation.duration = 500 // duration in milliseconds
                colorAnimation.addUpdateListener { animator ->
                    cardView.setCardBackgroundColor(animator.animatedValue as Int)
                }
                colorAnimation.start()

                delay(2000) // delay in milliseconds
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        colorChangeJob?.cancel() // Cancel the animation coroutine
    }
}
