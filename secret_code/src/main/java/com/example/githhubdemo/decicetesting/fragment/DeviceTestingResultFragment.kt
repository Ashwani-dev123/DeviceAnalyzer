package com.example.githhubdemo.decicetesting.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentDeviceTestingResultBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.decicetesting.activity.PdfPreviewActivity
import com.example.githhubdemo.decicetesting.utils.ButtonClickTracker
import com.example.githhubdemo.decicetesting.utils.StoragePermissionHandler


class DeviceTestingResultFragment : BaseFragment() {

    private var _binding: FragmentDeviceTestingResultBinding? = null
    private val binding get() = _binding!!

    private lateinit var storagePermissionHandler: StoragePermissionHandler


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDeviceTestingResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        storagePermissionHandler = StoragePermissionHandler()



        setResult()

        binding.btnFinished.setOnClickListener {
            ButtonClickTracker.clearClicks()
            DeviceTestingActivity.isPopBackStack = false
            requireActivity().finish()
        }

        /*binding.btnPreviewPdf.setOnClickListener {
            startActivity(Intent(requireContext(), PdfPreviewActivity::class.java))
        }*/
    }

    private fun setResult() {
        val clicks = ButtonClickTracker.buttonClicks
        val percentage = (ButtonClickTracker.getTotal() / clicks.size) * 100
        binding.tvResultPercentage.text = "${percentage.toInt()}%"



        clicks.forEach { (position, buttonType) ->
            when (position) {
                0 -> {
                    if (buttonType == "yes") {
                        binding.ivDisplayChecked.setImageResource(R.drawable.ic_yes)
                    }
                    else {
                        binding.ivDisplayChecked.setImageResource(R.drawable.ic_no)
                    }
                }
                1 -> {
                    if (buttonType == "yes") {
                        binding.ivFlashlightChecked.setImageResource(R.drawable.ic_yes)
                    }
                    else {
                        binding.ivFlashlightChecked.setImageResource(R.drawable.ic_no)
                    }
                }
                2 -> {
                    if (buttonType == "yes") {
                        binding.ivLoudSpeakerChecked.setImageResource(R.drawable.ic_yes)
                    }
                    else {
                        binding.ivLoudSpeakerChecked.setImageResource(R.drawable.ic_no)
                    }
                }
                3 -> {
                    if (buttonType == "yes") {
                        binding.ivEarSpeakerChecked.setImageResource(R.drawable.ic_yes)
                    }
                    else {
                        binding.ivEarSpeakerChecked.setImageResource(R.drawable.ic_no)
                    }
                }
                4 -> {
                    if (buttonType == "yes") {
                        binding.ivMicrophoneChecked.setImageResource(R.drawable.ic_yes)
                    }
                    else {
                        binding.ivMicrophoneChecked.setImageResource(R.drawable.ic_no)
                    }
                }
                5 -> {
                    if (buttonType == "yes") {
                        binding.ivEarProximityChecked.setImageResource(R.drawable.ic_yes)
                    }
                    else {
                        binding.ivEarProximityChecked.setImageResource(R.drawable.ic_no)
                    }
                }
                6 -> {
                    if (buttonType == "yes") {
                        binding.ivLightSensorChecked.setImageResource(R.drawable.ic_yes)
                    }
                    else {
                        binding.ivLightSensorChecked.setImageResource(R.drawable.ic_no)
                    }
                }
                7 -> {
                    if (buttonType == "yes") {
                        binding.ivAccelerometerChecked.setImageResource(R.drawable.ic_yes)
                    }
                    else {
                        binding.ivAccelerometerChecked.setImageResource(R.drawable.ic_no)
                    }
                }
                8 -> {
                    if (buttonType == "yes") {
                        binding.ivChargingChecked.setImageResource(R.drawable.ic_yes)
                    }
                    else {
                        binding.ivChargingChecked.setImageResource(R.drawable.ic_no)
                    }
                }
                9 -> {
                    if (buttonType == "yes") {
                        binding.ivVibrationChecked.setImageResource(R.drawable.ic_yes)
                    }
                    else {
                        binding.ivVibrationChecked.setImageResource(R.drawable.ic_no)
                    }
                }
                10 -> {
                    if (buttonType == "yes") {
                        binding.ivBluetoothChecked.setImageResource(R.drawable.ic_yes)
                    }
                    else {
                        binding.ivBluetoothChecked.setImageResource(R.drawable.ic_no)
                    }
                }
                11 -> {
                    if (buttonType == "yes") {
                        binding.ivVolumeUpChecked.setImageResource(R.drawable.ic_yes)
                    }
                    else {
                        binding.ivVolumeUpChecked.setImageResource(R.drawable.ic_no)
                    }
                }
                12 -> {
                    if (buttonType == "yes") {
                        binding.ivVolumeDownChecked.setImageResource(R.drawable.ic_yes)
                    }
                    else {
                        binding.ivVolumeDownChecked.setImageResource(R.drawable.ic_no)
                    }
                }
            }

        }

        binding.tvResultText.text = getConditionText(percentage.toDouble())

        binding.tvDeviceCondition.text = getConditionMassage(percentage.toDouble())


    }

    private fun getConditionText(percentage: Double): String {
        return when {
            percentage >= 90 -> getString(R.string.excellent)
            percentage >= 70 -> getString(R.string.good)
            percentage >= 50 -> getString(R.string.fair)
            percentage >= 30 -> getString(R.string.average)
            percentage >= 10 -> getString(R.string.bad)
            else -> "Needs Improvement"
        }
    }

    private fun getConditionMassage(percentage: Double): String {
        return when {
            percentage >= 90 -> getString(R.string.your_device_is_in_excellent)
            percentage >= 70 -> getString(R.string.your_device_is_in_good)
            percentage >= 50 -> getString(R.string.your_device_is_in_fair)
            percentage >= 30 -> getString(R.string.your_device_is_in_average)
            percentage >= 10 -> getString(R.string.your_device_is_in_poor)
            else -> getString(R.string.your_device_is_in_very_poor)
        }
    }
}