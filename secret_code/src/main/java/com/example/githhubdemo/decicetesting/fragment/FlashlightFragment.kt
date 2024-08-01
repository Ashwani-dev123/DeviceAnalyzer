package com.example.githhubdemo.decicetesting.fragment

import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    private lateinit var cameraId: String
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

       

        cameraManager =
            requireActivity().getSystemService(AppCompatActivity.CAMERA_SERVICE) as CameraManager
        cameraId = getCameraId()

        turnOnFlashlight()



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

    private fun getCameraId(): String {
        val cameraIds = cameraManager.cameraIdList
        return cameraIds[0] // Usually the first camera is the back camera
    }

    private fun turnOnFlashlight() {
        try {
            cameraManager.setTorchMode(cameraId, true)
            isFlashlightOn = true
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    private fun turnOffFlashlight() {
        try {
            cameraManager.setTorchMode(cameraId, false)
            isFlashlightOn = false
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