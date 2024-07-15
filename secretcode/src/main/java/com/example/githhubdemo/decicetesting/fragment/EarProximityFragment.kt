package com.example.githhubdemo.decicetesting.fragment

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentEarProximityBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.decicetesting.utils.FeatureTestViewModel
import com.example.githhubdemo.decicetesting.utils.SharedViewModel

class EarProximityFragment : BaseFragment() {

    private var _binding: FragmentEarProximityBinding? = null
    private val binding get() = _binding!!
    private lateinit var sensorManager: SensorManager
    private var proximitySensor: Sensor? = null
    private lateinit var vibrator: Vibrator
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var viewModel: FeatureTestViewModel

    private val proximitySensorListener: SensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
            // You can handle sensor accuracy changes if necessary
        }

        override fun onSensorChanged(event: SensorEvent) {
            if (event.sensor.type == Sensor.TYPE_PROXIMITY) {
                val distance = event.values[0]
                // Handle the proximity sensor data
                if (distance < proximitySensor!!.maximumRange) {
                    startVibration()
                } else {
                    stopVibration()
                }
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentEarProximityBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        viewModel = ViewModelProvider(requireActivity())[FeatureTestViewModel::class.java]

        sensorManager = requireActivity().getSystemService(AppCompatActivity.SENSOR_SERVICE) as SensorManager
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        vibrator = requireActivity().getSystemService(AppCompatActivity.VIBRATOR_SERVICE) as Vibrator

        if (proximitySensor == null) {
            Toast.makeText(requireActivity(), "Proximity sensor not available", Toast.LENGTH_SHORT).show()
        }

        binding.btnYes.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            sharedViewModel.addButtonClick(5, "yes")
            viewModel.responses[5] = true
            stopVibration()
           navigateToResultFragment()
        }

        binding.btnNo.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            sharedViewModel.addButtonClick(5, "no")
            viewModel.responses[5] = false
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
        findNavController().navigate(R.id.lightSensorFragment, null, navOptions)
    }

    private fun startVibration() {
        vibrator = requireActivity().getSystemService(AppCompatActivity.VIBRATOR_SERVICE) as Vibrator

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
        if (::vibrator.isInitialized) {  // Check if vibrator is initialized
            vibrator.cancel() // Stop the vibration when activity is destroyed
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun stopVibration() {
        vibrator.cancel()
    }

    override fun onResume() {
        super.onResume()
        proximitySensor?.also { sensor ->
            sensorManager.registerListener(proximitySensorListener, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(proximitySensorListener)
    }
}