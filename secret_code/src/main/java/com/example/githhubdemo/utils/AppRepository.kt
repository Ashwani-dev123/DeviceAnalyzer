package com.example.githhubdemo.utils

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.util.Log
import com.example.githhubdemo.deviceinfo.data.model.AppInfo
import java.io.File

class AppRepository(private val context: Context) {
    fun getInstalledApps(): List<AppInfo> {
        val packageManager: PackageManager = context.packageManager
        val packages: List<PackageInfo> =
            packageManager.getInstalledPackages(PackageManager.GET_META_DATA)
        val appList = mutableListOf<AppInfo>()

        for (packageInfo in packages) {
            try {
                val launchIntent = packageManager.getLaunchIntentForPackage(packageInfo.packageName)
                if (packageInfo != null && launchIntent != null) {
                    val appName = packageInfo.applicationInfo!!.loadLabel(packageManager).toString()
                    val packageName = packageInfo.packageName
                    val versionName = packageInfo.versionName
                    val versionCode = packageInfo.versionCode
                    val size = File(packageInfo.applicationInfo!!.sourceDir).length() // Size in bytes
                    appList.add(AppInfo(appName, packageName, versionName!!, versionCode, size))
                }

            } catch (e: Exception) {
                Log.e("CHECKINFO", "Exception for package: ${packageInfo.packageName}", e)
            }
        }

        return appList
    }

}