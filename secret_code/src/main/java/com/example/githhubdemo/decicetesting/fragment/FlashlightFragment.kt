package com.example.githhubdemo.decicetesting.fragment

import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentFlashlightBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.decicetesting.utils.ButtonClickViewModel

class FlashlightFragment : BaseFragment() {

    private var _binding: FragmentFlashlightBinding? = null
    private val binding get() = _binding!!
    private var isFlashlightOn = false
    private lateinit var cameraManager: CameraManager
    private var cameraId: String? = null
    private val viewModel: ButtonClickViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlashlightBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cameraManager = requireActivity().getSystemService(AppCompatActivity.CAMERA_SERVICE) as CameraManager
        cameraId = getCameraId()

        cameraId?.let {
            turnOnFlashlight()
        } ?: run {
            // Handle the case where no camera is available
            Toast.makeText(requireContext(), "No camera available", Toast.LENGTH_SHORT).show()
        }

        binding.btnNo.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            viewModel.addButtonClick(1, "no")
            turnOffFlashlight()
            navigateToResultFragment()
        }

        binding.btnYes.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            viewModel.addButtonClick(1, "yes")
            turnOffFlashlight()
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
        findNavController().navigate(R.id.loudSpeakerFragment, null, navOptions)
    }

    private fun getCameraId(): String? {
        val cameraIds = cameraManager.cameraIdList
        return if (cameraIds.isNotEmpty()) {
            cameraIds[0] // Usually the first camera is the back camera
        } else {
            null
        }
    }

    private fun turnOnFlashlight() {
        try {
            cameraId?.let {
                cameraManager.setTorchMode(it, true)
                isFlashlightOn = true
            }
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    private fun turnOffFlashlight() {
        try {
            cameraId?.let {
                cameraManager.setTorchMode(it, false)
                isFlashlightOn = false
            }
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        turnOffFlashlight() // Turn off the flashlight when the view is destroyed
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        turnOffFlashlight() // Ensure flashlight is off when fragment is destroyed
    }
}