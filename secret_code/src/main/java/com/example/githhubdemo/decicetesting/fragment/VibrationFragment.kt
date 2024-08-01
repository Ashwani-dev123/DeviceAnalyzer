package com.example.githhubdemo.decicetesting.fragment

import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentVibrationBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.decicetesting.utils.ButtonClickViewModel

class VibrationFragment : BaseFragment() {

    private var _binding: FragmentVibrationBinding? = null
    private val binding get() = _binding!!

    private lateinit var vibrator: Vibrator

    private val viewModel: ButtonClickViewModel by activityViewModels()
   
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVibrationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       


        vibrator = requireContext().getSystemService(AppCompatActivity.VIBRATOR_SERVICE) as Vibrator

        startVibration()

        binding.btnYes.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            viewModel.addButtonClick(9, "yes")
            stopVibration()
            navigateToResultFragment()
        }

        binding.btnNo.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            viewModel.addButtonClick(9, "no")
            stopVibration()
            navigateToResultFragment()
        }
    }

    private fun navigateToResultFragment() {

        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_right)
            .setExitAnim(R.anim.slide_out_left)
            .setPopEnterAnim(R.anim.slide_in_left)
            .setPopExitAnim(R.anim.slide_out_right)
            .build()
        findNavController().navigate(R.id.bluetoothFragment, null, navOptions)
    }

    private fun startVibration() {
        vibrator = requireContext().getSystemService(AppCompatActivity.VIBRATOR_SERVICE) as Vibrator

        if (vibrator != null && vibrator.hasVibrator()) {
            // Check if the device has a vibrator
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // For API 26 and above, use VibrationEffect
                val vibrationEffect = VibrationEffect.createWaveform(longArrayOf(0, 1000, 1000), 0)
                vibrator.vibrate(vibrationEffect)
            } else {
                // For older APIs, use the deprecated vibrate method
                vibrator.vibrate(longArrayOf(0, 1000, 1000), 0)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (vibrator != null) {
            vibrator.cancel() // Stop the vibration when activity is destroyed
        }
    }

    private fun stopVibration() {
        vibrator.cancel()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}