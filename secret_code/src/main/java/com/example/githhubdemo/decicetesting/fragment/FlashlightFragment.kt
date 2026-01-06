package com.example.githhubdemo.decicetesting.fragment

import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentFlashlightBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.decicetesting.utils.ButtonClickViewModel
import com.google.firebase.crashlytics.FirebaseCrashlytics

class FlashlightFragment : BaseFragment() {

    private var _binding: FragmentFlashlightBinding? = null
    private val binding get() = _binding!!
    private var isFlashlightOn = false
    private lateinit var cameraManager: CameraManager
    private var cameraId: String? = null
    private val viewModel: ButtonClickViewModel by activityViewModels()

    // Flag to track if device has flash
    private var hasFlash = false

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

        // Find a camera with flash capability
        cameraId = findCameraWithFlash()

        if (cameraId != null && hasFlash) {
            turnOnFlashlight()
        } else {
            // Device doesn't have flash, show toast and change Yes button to Skip
            Toast.makeText(
                requireContext(),
                "This device doesn't have a flashlight",
                Toast.LENGTH_LONG
            ).show()

            // Change Yes button text to "Skip"
            val yesTextView = binding.btnYes.getChildAt(1) as? android.widget.TextView
            yesTextView?.text = getString(R.string.skip)

            // Remove the yes icon
            val yesImageView = binding.btnYes.getChildAt(0) as? android.widget.ImageView
            yesImageView?.visibility = View.GONE

            // Disable No button since there's no flash to test
            binding.btnNo.isEnabled = false
            binding.btnNo.alpha = 0.5f // Make it visually disabled
        }

        binding.btnNo.setOnClickListener {
            if (binding.btnNo.isEnabled) {
                DeviceTestingActivity.isPopBackStack = false
                viewModel.addButtonClick(1, "no")
                turnOffFlashlight()
                navigateToResultFragment()
            }
        }

        binding.btnYes.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false

            if (hasFlash) {
                // Device has flash, record "yes" response
                viewModel.addButtonClick(1, "yes")
            } else {
                // Device doesn't have flash, record "skip" response
                viewModel.addButtonClick(1, "skip")
            }

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

    private fun findCameraWithFlash(): String? {
        try {
            val cameraIds = cameraManager.cameraIdList

            for (id in cameraIds) {
                val characteristics = cameraManager.getCameraCharacteristics(id)

                // Check if this camera has flash capability
                val flashAvailable = characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)
                val lensFacing = characteristics.get(CameraCharacteristics.LENS_FACING)

                // Prefer back camera with flash, but accept any camera with flash
                if (flashAvailable == true) {
                    hasFlash = true
                    // Prefer back camera (LENS_FACING_BACK = 0)
                    if (lensFacing == CameraCharacteristics.LENS_FACING_BACK) {
                        return id
                    }
                }
            }

            // If no back camera with flash, return first camera with flash
            for (id in cameraIds) {
                val characteristics = cameraManager.getCameraCharacteristics(id)
                val flashAvailable = characteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)

                if (flashAvailable == true) {
                    hasFlash = true
                    return id
                }
            }

            // No camera with flash found
            hasFlash = false
            return null

        } catch (e: CameraAccessException) {
            FirebaseCrashlytics.getInstance().log("CameraAccessException: ${e.message}")
            hasFlash = false
            return null
        } catch (e: Exception) {
            FirebaseCrashlytics.getInstance().log("Exception finding camera: ${e.message}")
            hasFlash = false
            return null
        }
    }

    private fun turnOnFlashlight() {
        try {
            cameraId?.let {
                cameraManager.setTorchMode(it, true)
                isFlashlightOn = true
            }
        } catch (e: CameraAccessException) {
            Toast.makeText(requireContext(), "Cannot access flashlight", Toast.LENGTH_SHORT).show()
            FirebaseCrashlytics.getInstance().log("CameraAccessException in turnOnFlashlight: ${e.message}")
        } catch (e: IllegalArgumentException) {
            // This catches the "does not have a flash unit" error
            Toast.makeText(requireContext(), "Flashlight not available", Toast.LENGTH_SHORT).show()
            FirebaseCrashlytics.getInstance().log("IllegalArgumentException in turnOnFlashlight: ${e.message}")
        }
    }

    private fun turnOffFlashlight() {
        try {
            cameraId?.let {
                if (isFlashlightOn) {
                    cameraManager.setTorchMode(it, false)
                    isFlashlightOn = false
                }
            }
        } catch (e: CameraAccessException) {
            // Log but don't show error when turning off
            FirebaseCrashlytics.getInstance().log("CameraAccessException in turnOffFlashlight: ${e.message}")
        } catch (e: IllegalArgumentException) {
            // Log but don't show error when turning off
            FirebaseCrashlytics.getInstance().log("IllegalArgumentException in turnOffFlashlight: ${e.message}")
        }
    }

    override fun onPause() {
        super.onPause()
        turnOffFlashlight() // Turn off when fragment is paused
    }

    override fun onDestroyView() {
        super.onDestroyView()
        turnOffFlashlight()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        turnOffFlashlight()
    }
}