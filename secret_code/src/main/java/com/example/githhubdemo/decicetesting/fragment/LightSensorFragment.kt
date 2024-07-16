package com.example.githhubdemo.decicetesting.fragment

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentLightSensorBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.decicetesting.utils.FeatureTestViewModel
import com.example.githhubdemo.decicetesting.utils.SharedViewModel


class LightSensorFragment : BaseFragment(), SensorEventListener {
    private var _binding: FragmentLightSensorBinding? = null
    private val binding get() = _binding!!
    private lateinit var sensorManager: SensorManager
    private var lightSensor: Sensor? = null
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var viewModel: FeatureTestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLightSensorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        viewModel = ViewModelProvider(requireActivity())[FeatureTestViewModel::class.java]

        sensorManager = requireActivity().getSystemService(AppCompatActivity.SENSOR_SERVICE) as SensorManager

        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        lightSensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }

        binding.btnYes.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            sharedViewModel.addButtonClick(6, "yes")
            viewModel.responses[6] = true
           navigateToResultFragment()
        }

        binding.btnNo.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            sharedViewModel.addButtonClick(6, "no")
            viewModel.responses[6] = false
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
        findNavController().navigate(R.id.accelerometerFragment, null, navOptions)
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_LIGHT && event.values.isNotEmpty()) {
            val lux = event.values[0]
            val luxInt = lux.toInt()
            binding.tvSensorValue.text = "$luxInt Lx"  // Null-check for TextView
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onResume() {
        super.onResume()
        lightSensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}