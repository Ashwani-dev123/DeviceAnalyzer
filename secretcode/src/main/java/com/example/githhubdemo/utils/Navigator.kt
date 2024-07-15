package com.example.githhubdemo.utils

import android.app.Activity
import android.content.Intent
import com.example.githhubdemo.activity.ModuleMainActivity



object Navigator {
    var OrderId = "OrderId"
    var IsFrom = "ISFrom"
    var Unlock = "Unlock"
    var ModelId = "ModelId"
    var IMEI = "IMEI"
    var ProductId = "ProductId"
    var SERVICE = "SERVICE"
    var isFromCheckEligible = "isFromCheckEligible"
    var Message = "Message"


    fun openMainScreen(context: Activity) {
        val intent = Intent(context, ModuleMainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    fun openMainActivity(context: Activity) {
        val intent = Intent(context, ModuleMainActivity::class.java)
        context.startActivity(intent)
        context.finish()
    }

}