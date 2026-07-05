package com.example.githhubdemo.deviceinfo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githhubdemo.databinding.CpuFragmentBinding
import com.example.githhubdemo.deviceinfo.utils.Do
import com.example.githhubdemo.deviceinfo.utils.UiResult
import com.example.githhubdemo.deviceinfo.utils.launchAndCollectWithViewLifecycle
import com.example.githhubdemo.deviceinfo.utils.showToast
import com.example.githhubdemo.deviceinfo.viewmodel.DataViewModel
import com.example.githhubdemo.information
import org.koin.androidx.viewmodel.ext.android.viewModel

class CPU : Fragment() {

    private var _binding: CpuFragmentBinding? = null
    private val dataViewModel: DataViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = CpuFragmentBinding.inflate(inflater, container, false)
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
        launchAndCollectWithViewLifecycle(dataViewModel.cpuInfo) { result ->
            val latestBinding = _binding ?: return@launchAndCollectWithViewLifecycle
            latestBinding.progressbar.isVisible = true
            Do exhaustive when (result) {
                is UiResult.Error -> {
                    latestBinding.progressbar.isVisible = false
                    if (isAdded) {
                        showToast(result.throwable.message.orEmpty())
                    }
                    Unit
                }

                is UiResult.Success -> {
                    val layoutInfo = result.data.layoutInfo
                    latestBinding.listWithItems.withModels {
                        layoutInfo.forEach { information ->
                            information {
                                id(information.title)
                                data(information)
                            }
                        }
                    }
                    latestBinding.progressbar.isVisible = false
                }
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
