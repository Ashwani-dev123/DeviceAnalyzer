package com.example.githhubdemo.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.os.Build
import android.text.TextUtils
import android.util.Patterns
import com.example.githhubdemo.model.Setting
import java.text.DateFormat
import java.text.DateFormatSymbols
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone


object Util {
    private var stripePublishableKey = "pk_test_DPiZCdKp1w8I2P1SBOGH3rzX"
    private var secret_Key = "sk_test_pc9pMV5VDArJkbe5Wx4RlUV3"
    private var instruction: String? = ""
    const val preference_file_key = "preference_file_key"
    const val USER_NAME = "user_name"
    const val USER_EMAIL = "user_email"
    internal var globalSetting: Setting? = null
    var isShowRate = false
    fun setGlobalSetting(s: Setting?) {
        globalSetting = s
    }



    fun getGlobalSetting(): Setting? {
        return globalSetting
    }

    fun setSecret_Key(secret_Key: String) {
        Util.secret_Key = secret_Key
    }
    fun setStripePublishableKey(publishable_Key: String) {
        stripePublishableKey = publishable_Key
    }
    fun getInstruction(): String? {
        if (!TextUtils.isEmpty(instruction)) {
            return instruction
        }
        val setting: Setting? = getGlobalSetting()
        if (setting != null) {
            instruction = setting.unlock_instruction_url
        }
        return if (instruction != null) instruction else ""
    }

    fun setInstruction(instruction: String?) {
        Util.instruction = instruction
    }

    fun isNetworkConnected(contenxt: Context): Boolean {
        val cm: ConnectivityManager =
            contenxt.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }

    fun isPackageInstalled(packageName: String?, packageManager: PackageManager): Boolean {
        return try {
            packageManager.getApplicationInfo(packageName!!, 0).enabled
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    fun regexEmail(email: String?): Boolean {
        return if (TextUtils.isEmpty(email)) false else Patterns.EMAIL_ADDRESS.matcher(email)
            .matches()
    }

    val model: String
        get() = Build.MODEL

    fun capitalize(s: String?): String {
        if (s == null || s.isEmpty()) {
            return ""
        }
        val first = s[0]
        return if (Character.isUpperCase(first)) {
            s
        } else {
            first.uppercaseChar().toString() + s.substring(1)
        }
    }

    fun getDate(dateTime: String?): String {
        val dateFormatDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val tz = TimeZone.getDefault()
        dateFormatDate.timeZone = tz
        //dateFormatDate.setTimeZone(TimeZone.getTimeZone("UTC"));
        var date: Date? = Date()
        try {
            date = dateFormatDate.parse(dateTime)
            val offsetTime = TimeZone.getDefault().getOffset(System.currentTimeMillis()).toLong()
            date = Date(date.time /*+ offsetTime*/)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        if (date == null) date = Calendar.getInstance().time
        val df: DateFormat = SimpleDateFormat("MMM dd, HH:mm", Locale.ENGLISH)
        return df.format(date)
    }

    fun dateToString(date: Date?, format: String?): String {
        val dateFormat = SimpleDateFormat(format)
        val symbols =
            DateFormatSymbols(Locale.getDefault())
        // OVERRIDE SOME symbols WHILE RETAINING OTHERS
        symbols.amPmStrings = arrayOf("am", "pm")
        dateFormat.dateFormatSymbols = symbols
        return dateFormat.format(date)
    }

    fun isNumberic(s: String): Boolean {
        return s.matches("\\d+(?:\\.\\d+)?".toRegex())
    }

    fun isPlayStoreInstalled(context: Context): Boolean {
        try {
            isShowRate = context.packageManager.getApplicationInfo("com.android.vending", 0).enabled
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            isShowRate = false
        }
        return isShowRate
    }

    fun extractExpireDate(expireDate: String?): IntArray? {
        if (TextUtils.isEmpty(expireDate)) {
            return null
        }
        if (!expireDate!!.contains("/")) {
            return null
        }
        val expireDateAr =
            expireDate.split("/".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()
        if (expireDate == null || expireDate.length < 2) {
            return null
        }
        if (expireDateAr[0].length < 2) {
            return null
        }
        if (expireDateAr[1].length < 2) {
            return null
        }
        if (!isNumberic(expireDateAr[0])) {
            return null
        }
        if (!isNumberic(expireDateAr[1])) {
            return null
        }
        val expireMonth = Integer.valueOf(expireDateAr[0])
        if (expireMonth < 1 || expireMonth > 12) {
            return null
        }
        val expireYear = Integer.valueOf(expireDateAr[1])
        return intArrayOf(expireMonth, expireYear)
    }

    fun saveSetting(context: Context, key: String?, value: String?) {
        val sharedPref: SharedPreferences = context.getSharedPreferences(
            preference_file_key, Context.MODE_PRIVATE
        )
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getSetting(context: Context, key: String?): String {
        val sharedPref: SharedPreferences = context.getSharedPreferences(
            preference_file_key, Context.MODE_PRIVATE
        )
        return sharedPref.getString(key, "")!!
    }

    fun removeSetting(context: Context, key: String?) {
        val sharedPref: SharedPreferences = context.getSharedPreferences(
            preference_file_key, Context.MODE_PRIVATE
        )
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.remove(key)
        editor.apply()
    }

    fun saveUser(context: Context, name: String?, email: String?) {
        saveSetting(context, USER_NAME, name)
        saveSetting(context, USER_EMAIL, email)
    }

    fun hasUser(context: Context): Boolean {
        val name = getSetting(context, USER_NAME)
        return !TextUtils.isEmpty(name)
    }

    fun getUserName(context: Context): String {
        return getSetting(context, USER_NAME)
    }

    fun getUserEmail(context: Context): String {
        return getSetting(context, USER_EMAIL)
    }

    fun removeUser(context: Context) {
        removeSetting(context, USER_NAME)
        removeSetting(context, USER_EMAIL)
    }


}
