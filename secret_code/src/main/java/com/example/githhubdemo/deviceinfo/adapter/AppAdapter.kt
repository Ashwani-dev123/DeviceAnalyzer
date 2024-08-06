package com.example.githhubdemo.deviceinfo.adapter

import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githhubdemo.R
import com.example.githhubdemo.deviceinfo.data.model.AppInfo

class AppAdapter(private var appList: List<AppInfo>) :
    RecyclerView.Adapter<AppAdapter.AppViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.app_list_item, parent, false)
        return AppViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val app = appList[position]
        holder.bind(app)
    }

    fun setData(newAppList: List<AppInfo>) {
        appList = newAppList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = appList.size

    inner class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val appIcon: ImageView = itemView.findViewById(R.id.ivAppIcon)
        private val appName: TextView = itemView.findViewById(R.id.tvAppName)
        private val packageName: TextView = itemView.findViewById(R.id.tvAppPackageName)
        private val versionSize: TextView = itemView.findViewById(R.id.tvAppVersion)
        private val appSize: TextView = itemView.findViewById(R.id.tvAppSize)

        fun bind(appInfo: AppInfo) {
            val packageManager = itemView.context.packageManager
            try {
                val appIconDrawable = packageManager.getApplicationIcon(appInfo.packageName)
                appIcon.setImageDrawable(appIconDrawable)
            } catch (e: PackageManager.NameNotFoundException) {
                // Handle the exception by setting a default icon or leaving the ImageView empty
                appIcon.setImageResource(R.drawable.ic_launcher_background) // Replace with your default icon resource
            }

            appName.text = appInfo.appName
            packageName.text = appInfo.packageName
            versionSize.text = "Version: ${appInfo.versionName}"
            appSize.text = "${getFormattedSize(appInfo.size)}"
        }

        private fun getFormattedSize(size: Long): String {
            val kiloByte = size / 1024
            val megaByte = kiloByte / 1024
            return if (megaByte > 0) {
                "$megaByte MB"
            } else {
                "$kiloByte KB"
            }
        }
    }
}