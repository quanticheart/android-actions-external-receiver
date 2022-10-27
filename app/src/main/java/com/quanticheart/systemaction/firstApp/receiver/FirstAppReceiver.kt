package com.quanticheart.systemaction.firstApp.receiver

import android.app.ActivityManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.quanticheart.systemaction.utils.appAction
import com.quanticheart.systemaction.utils.intentKey

//
// Created by Jonn Alves on 18/10/22.
//
internal class AppVerificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.getBooleanExtra(intentKey, false)) {
            context.sendAppTaskStatusBroadcast()
        }
    }
}

internal fun Context.sendAppTaskStatusBroadcast() {
    val intentSend = Intent(appAction)
    intentSend.putExtra("running", isAppForeground())
    intentSend.putExtra("otherInfo", "hello world")
    intentSend.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
    sendBroadcast(intentSend)
    Log.e("APP", "Send Task Status")
}

internal fun Context.isAppForeground(): Boolean {
    var foreground = false
    val appProcesses =
        (getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager).runningAppProcesses
    for (appProcess in appProcesses) {
        if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
            foreground = true
        }
    }
    return foreground
}