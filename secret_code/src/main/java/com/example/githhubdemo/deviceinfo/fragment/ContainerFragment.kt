package com.example.githhubdemo.deviceinfo.fragment

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentContainerBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.githhubdemo.deviceinfo.main.SectionsPagerAdapter
import com.example.githhubdemo.utils.Share


class ContainerFragment : Fragment() {

    private var _binding: FragmentContainerBinding? = null
    private val binding get() = _binding!!

    private val tabIcons = intArrayOf(
        R.drawable.ic_dashboard,
        R.drawable.ic_devicee,
        R.drawable.ic_system,
        R.drawable.ic_storage,
        R.drawable.ic_cpu,
        R.drawable.ic_battery,
        R.drawable.ic_screen
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContainerBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentContainerBinding.bind(view)
        setupViewPager()
    }

    private fun setupViewPager() {
        val adapter = SectionsPagerAdapter(requireContext(), requireActivity())
        with(binding) {
            viewPager.adapter = adapter
            TabLayoutMediator(tabs, viewPager) { tab, position ->
                tab.text = adapter.getPageTitle(position)
                tab.setIcon(tabIcons[position])
            }.attach()
        }
        binding.viewPager.offscreenPageLimit = 5

        binding.tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.icon?.setColorFilter(
                    ContextCompat.getColor(requireContext(), R.color.white),
                    PorterDuff.Mode.SRC_IN
                )

                Share.tabPosition =  tab!!.position

                Log.e("CHECKFRAGMENT", "isSelected: " +  tab.position)

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.icon?.setColorFilter(
                    ContextCompat.getColor(requireContext(), R.color.textGrey),
                    PorterDuff.Mode.SRC_IN
                )
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Do nothing
            }
        })

        val firstTab = binding.tabs.getTabAt(0)
        firstTab?.icon?.setColorFilter(
            ContextCompat.getColor(requireContext(), R.color.white),
            PorterDuff.Mode.SRC_IN
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
