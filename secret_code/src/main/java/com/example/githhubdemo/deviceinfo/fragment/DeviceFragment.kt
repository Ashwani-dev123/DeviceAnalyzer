package com.example.githhubdemo.deviceinfo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githhubdemo.databinding.DeviceFragmentBinding
import com.example.githhubdemo.deviceinfo.viewmodel.DataViewModel
import com.example.githhubdemo.information
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class DeviceFragment : Fragment(), KoinComponent {

    private val dataViewModel: DataViewModel by viewModel()
    private var _binding: DeviceFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DeviceFragmentBinding.inflate(inflater, container, false)
        _binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUIElements()
    }

    private fun setupUIElements() {
        val currentBinding = _binding ?: return
        currentBinding.listWithItems.layoutManager = LinearLayoutManager(requireContext())
        currentBinding.listWithItems.withModels {
            dataViewModel.deviceData.forEach {
                information {
                    id(it.title)
                    data(it)
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
