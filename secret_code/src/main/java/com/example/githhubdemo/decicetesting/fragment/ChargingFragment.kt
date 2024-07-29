package com.example.githhubdemo.decicetesting.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentChargingBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.decicetesting.utils.ButtonClickTracker
import kotlin.math.abs


class ChargingFragment : BaseFragment() {

    private var _binding: FragmentChargingBinding? = null
    private val binding get() = _binding!!

    private var batteryReceiver: BroadcastReceiver? = null

   
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChargingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       

        receiver()

        binding.btnYes.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            ButtonClickTracker.addButtonClick(8, "yes")
            navigateToResultFragment()
        }

        binding.btnNo.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            ButtonClickTracker.addButtonClick(8, "no")
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
        findNavController().navigate(R.id.vibrationFragment, null, navOptions)
    }

    private fun receiver() {
        batteryReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (intent?.action == Intent.ACTION_BATTERY_CHANGED) {
                    val status: Int = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
                    val isCharging: Boolean = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                            status == BatteryManager.BATTERY_STATUS_FULL

                    if (isCharging) {
                        binding.tvCharging.text = requireContext().getString(R.string.charging)
                    } else {
                        binding.tvCharging.text = requireContext().getString(R.string.discharging)
                    }

                    val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                    val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
                    val batteryPct: Float = level * 100 / scale.toFloat()

                    binding.tvChargingLevel.text = batteryPct.toInt().toString() + "%"

                    val temperature: Int = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0)
                    val temperatureCelsius: Float = temperature / 10f

                    binding.tvTemperature.text = "${temperatureCelsius.toInt()}°C"

                    val voltage: Int = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1)
                    val voltageVolts: Float = voltage / 1000f
                    val voltageMilliVolts = voltage

                    binding.tvVoltage.text = "$voltageMilliVolts mV"

                    val batteryManager =
                        context!!.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
                    val currentMicroAmps =
                        batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW)
                    val currentMilliAmps = abs(currentMicroAmps / 1000f)

                    binding.tvCurrent.text = "${currentMilliAmps.toInt()} mA"

                    val powerWatts = voltageVolts * currentMilliAmps / 1000f
                    val powerFormatted = String.format("%.2f", powerWatts)

                    binding.tvPower.text = "${powerFormatted} W"
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // Register BroadcastReceiver to receive battery status updates
        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        requireContext().registerReceiver(batteryReceiver, filter)
    }

    override fun onPause() {
        super.onPause()
        // Unregister the BroadcastReceiver when activity is paused
        requireContext().unregisterReceiver(batteryReceiver)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}