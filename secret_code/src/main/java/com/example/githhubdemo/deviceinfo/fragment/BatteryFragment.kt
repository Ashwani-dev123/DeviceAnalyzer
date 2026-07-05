package com.example.githhubdemo.deviceinfo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githhubdemo.databinding.BatteryFragmentBinding

import com.example.githhubdemo.deviceinfo.utils.launchAndCollectWithViewLifecycle
import com.example.githhubdemo.deviceinfo.viewmodel.DataViewModel
import com.example.githhubdemo.information

import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class BatteryFragment : Fragment(), KoinComponent {

    private val viewModel: DataViewModel by viewModel()
    private var _binding: BatteryFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = BatteryFragmentBinding.inflate(inflater, container, false)
        _binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }



    private fun initViews() {
        val currentBinding = _binding ?: return
        currentBinding.listWithItems.layoutManager = LinearLayoutManager(requireContext())
        launchAndCollectWithViewLifecycle(viewModel.batteryInfo) { type ->
            val latestBinding = _binding ?: return@launchAndCollectWithViewLifecycle
            latestBinding.listWithItems.withModels {
                type.data.forEach {
                    information {
                        id(it.details)
                        data(it)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
