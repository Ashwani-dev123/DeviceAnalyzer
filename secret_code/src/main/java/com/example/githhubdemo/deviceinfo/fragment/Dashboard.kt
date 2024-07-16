package com.example.githhubdemo.deviceinfo.fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.githhubdemo.R
import com.example.githhubdemo.cpuProgress
import com.example.githhubdemo.databinding.DashboardFragmentBinding
import com.github.lzyzsd.circleprogress.ArcProgress
import com.example.githhubdemo.deviceinfo.main.GridSpacingItemDecoration
import com.example.githhubdemo.deviceinfo.models.CpuData
import com.example.githhubdemo.deviceinfo.models.RamData
import com.example.githhubdemo.deviceinfo.utils.UiResult
import com.example.githhubdemo.deviceinfo.utils.animatedMovement
import com.example.githhubdemo.deviceinfo.utils.launchAndCollectWithViewLifecycle
import com.example.githhubdemo.deviceinfo.utils.nav
import com.example.githhubdemo.deviceinfo.utils.parsePercentage
import com.example.githhubdemo.deviceinfo.utils.setupActionBar
import com.example.githhubdemo.deviceinfo.utils.showToast
import com.example.githhubdemo.deviceinfo.viewmodel.DataViewModel
import kotlinx.coroutines.flow.Flow
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class Dashboard : Fragment(), KoinComponent {

    private val dataViewModel: DataViewModel by viewModel()
    private var _binding: DashboardFragmentBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DashboardFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.arcProgress.setRamValueAsync(dataViewModel.ramInfo)
        binding.listView.addItemDecoration(GridSpacingItemDecoration(4, 12, true))
        setupUIElements()
        binding.listView.itemAnimator = null

        launchAndCollectWithViewLifecycle(dataViewModel.cpuInfo) {
            handleCpuInfoResult(it)
        }

        setupActionBar(R.menu.settings_menu) {
            when (it.itemId) {
                R.id.settings -> handleSettings()
            }
        }
    }

    private fun setupUIElements() = binding.apply {
        systemStorage.setProgressAndText(dataViewModel.systemStoragePercentage, textView4)
      /*  internalProgress.setProgressAndText(
            dataViewModel.internalStoragePercentage,
            internalPercentage
        )*/

        storageProgress.setProgressAndText(
            dataViewModel.internalStoragePercentage,
            tvPercentage
        )

        //binding.tvPercentage.text = dataViewModel.internalStoragePercentage.toString() + "%"
        binding.tvFreeSpace.text = "Free: " + dataViewModel.internalStorageFree + " GB,"
        binding.tvTotalSapce.text = "Total: " + dataViewModel.internalStorageTotal + " GB"

        launchAndCollectWithViewLifecycle(dataViewModel.batteryInfo) { type ->
            val isCharging = type.data[6].details == "Charging"
            batteryPercentage.text =
                if (isCharging) "Charging ${type.data.first().details}" else type.data.first().details
            batteryProgress.progress = type.data.first().details.parsePercentage()
            Log.e("TEst", type.data.first().details)
            batteryProgress.isIndeterminate = isCharging
        }

        binding.topBar.setOnClickListener(::animatedMovement)
    }

    private fun ProgressBar.setProgressAndText(percentage: Int, textView: TextView) {
        progress = percentage
        textView.text = resources.getString(R.string.percentage_format, percentage.toString())
    }

    private fun handleCpuInfoResult(uiResult: UiResult<CpuData>) {
        when (uiResult) {
            is UiResult.Error -> showToast(uiResult.throwable.message.orEmpty())
            is UiResult.Success -> updateCpuInfoList(uiResult)
        }
    }

    private fun updateCpuInfoList(uiResult: UiResult.Success<CpuData>) {
        binding.listView.withModels {
            uiResult.data.frequencies.forEachIndexed { index, frequency ->
                cpuProgress {
                    id(uiResult.data.coreNumber)
                    position(index + 1)
                    cpuInfo(frequency)
                    //clickListener(::animatedMovement)
                }
            }
        }
    }

    private fun handleSettings() = nav(
        R.id.containerFragment,
        ContainerFragmentDirections.actionDashboardToSettingsFragment()
    )

    private fun ArcProgress.setRamValueAsync(
        flow: Flow<UiResult<RamData>>
    ) = apply {
        launchAndCollectWithViewLifecycle(flow) { handleRamValueResult(it) }
    }

    private fun handleRamValueResult(result: UiResult<RamData>) {
        when (result) {
            is UiResult.Error -> showToast(result.throwable.message.orEmpty())
            is UiResult.Success -> {
                binding.arcProgress.animate(result.data.percentageAvailable)
                binding.ramLoad = result.data.ramLoad
                binding.ramTxt.text = resources.getString(
                    R.string.ram_text,
                    result.data.available,
                    result.data.total
                )
            }

            else -> {}
        }
    }

    private fun ArcProgress.animate(percentageAvailable: Int) = apply {
        ObjectAnimator.ofInt(this, "progress", percentageAvailable).setDuration(1000).start()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}