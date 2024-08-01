package com.example.githhubdemo.decicetesting.fragment

import android.os.Bundle
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
import com.example.githhubdemo.databinding.FragmentAccelerometerBinding
import com.example.githhubdemo.decicetesting.activity.DeviceTestingActivity
import com.example.githhubdemo.decicetesting.utils.ButtonClickViewModel
import com.example.githhubdemo.decicetesting.utils.ShakeDetector


class AccelerometerFragment : BaseFragment(), ShakeDetector.OnShakeListener {

    private var _binding: FragmentAccelerometerBinding? = null
    private val binding get() = _binding!!

    private lateinit var shakeDetector: ShakeDetector
    private lateinit var vibrator: Vibrator

    private val viewModel: ButtonClickViewModel by activityViewModels()
   

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccelerometerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       

        vibrator = requireActivity().getSystemService(AppCompatActivity.VIBRATOR_SERVICE) as Vibrator
        shakeDetector = ShakeDetector(requireContext(), this)

        binding.btnYes.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            viewModel.addButtonClick(7, "yes")
            navigateToResultFragment()
        }

        binding.btnNo.setOnClickListener {
            DeviceTestingActivity.isPopBackStack = false
            viewModel.addButtonClick(7, "no")
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
        findNavController().navigate(R.id.chargingFragment, null, navOptions)
    }

    override fun onResume() {
        super.onResume()
        shakeDetector.start()
    }

    override fun onPause() {
        shakeDetector.stop()
        super.onPause()
    }

    override fun onShake() {
        vibrator.vibrate(500)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}