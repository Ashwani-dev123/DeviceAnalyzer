package com.example.githhubdemo.deviceinfo.fragment

import android.app.ProgressDialog
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githhubdemo.R
import com.example.githhubdemo.databinding.FragmentAppListBinding
import com.example.githhubdemo.deviceinfo.adapter.AppAdapter
import com.example.githhubdemo.deviceinfo.data.model.AppInfo
import com.example.githhubdemo.utils.AppViewModel
import com.example.githhubdemo.utils.ShareModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File


class AppListFragment : Fragment() {

    private var installedApps: ArrayList<AppInfo> = ArrayList()
    private var _binding: FragmentAppListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: AppAdapter
    private var progressDialog: ProgressDialog? = null

    private val appViewModel: AppViewModel by viewModels()

    fun AppListFragment() {
        // empty constructor
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAppListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvAppList.layoutManager = LinearLayoutManager(requireContext())
        adapter = AppAdapter(emptyList())
        binding.rvAppList.adapter = adapter


        appViewModel.fetchInstalledApps()

        appViewModel.apps.observe(requireActivity(), Observer { appList ->
            hideProgressDialog()

            installedApps.clear()
            installedApps.addAll(appList)

            adapter.setData(installedApps)
            hideProgressDialog()


        })

        showPermissionMessageWithDelay(requireContext())

    }

    private fun showPermissionMessageWithDelay(context: Context) {
        val showDelayMillis: Long = 1000 // 1 second
        val dismissDelayMillis: Long = 5000 // 5 seconds after showing the dialog

        // Show the dialog after 1 second
        Handler(Looper.getMainLooper()).postDelayed({
            val alertDialog = showPermissionMessage(context)
            alertDialog.show()

            // Dismiss the dialog after another 5 seconds
            Handler(Looper.getMainLooper()).postDelayed({
                alertDialog.dismiss()
            }, dismissDelayMillis)
        }, showDelayMillis)
    }

    private fun showPermissionMessage(context: Context): AlertDialog {
        val message =
            "Permission QUERY_ALL_PACKAGES is used for this screen i.e. to get and show all installed applications of the device."

        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.apply {
            setTitle("QUERY_ALL_PACKAGES Permission")
            setMessage(message)
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE)) // Set background color
        alertDialog.window?.setGravity(Gravity.BOTTOM) // Set gravity to bottom
        return alertDialog
    }

    override fun onResume() {
        super.onResume()
        Log.e("CHECKFRAGMENT", "onViewCreated: " + ShareModule.tabPosition)
        if (ShareModule.tabPosition == 6 && installedApps.size <= 0) {
            showProgressDialog()
            appViewModel.fetchInstalledApps()
        }

    }

    private fun showProgressDialog() {
        Log.e("CHECKLAN", "progressDialog -->" + progressDialog)
        if (progressDialog == null) {
            progressDialog = ProgressDialog(requireContext())
            progressDialog!!.setCanceledOnTouchOutside(false)
            progressDialog!!.setCancelable(false)
            try {
                progressDialog!!.show()
            } catch (e: WindowManager.BadTokenException) {
            }
            progressDialog!!.setCancelable(false)
            progressDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val config = resources.configuration
            Log.e("CHECKLAN", "showProgressDialog: language-->" + config.locale + "==>")
            progressDialog!!.setContentView(R.layout.progressdialog)
        }
        if (!progressDialog!!.isShowing) {
            progressDialog!!.show()
        }
    }

    private fun hideProgressDialog() {
        try {
            if (progressDialog != null && progressDialog!!.isShowing) {
                progressDialog!!.dismiss()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}