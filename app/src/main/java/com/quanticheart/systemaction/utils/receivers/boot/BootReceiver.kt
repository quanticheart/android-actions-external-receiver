package com.quanticheart.systemaction.utils.receivers.boot

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.quanticheart.systemaction.firstApp.alarm.AppAlarm

const val smartphoneBoot = "smartphoneBoot"

@Suppress("PrivatePropertyName", "SpellCheckingInspection")
internal class BootReceiver : BroadcastReceiver() {
    private val BOOT = Intent.ACTION_BOOT_COMPLETED
    private val BOOT_COMPLETED = "android.intent.action.ACTION_BOOT_COMPLETED"
    private val SHUTDOWN = "android.intent.action.ACTION_SHUTDOWN"
    private val POWERON = "android.intent.action.QUICKBOOT_POWERON"
    private val POWERON_HTC = "com.htc.intent.action.QUICKBOOT_POWERON"
    private val POWERON_MIUI = "android.intent.action.REBOOT"

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            BOOT, BOOT_COMPLETED, SHUTDOWN, POWERON, POWERON_HTC, POWERON_MIUI -> {
                AppAlarm.start(context)
            }
        }
    }
}

fun Context.registerBootReceiver(callback: () -> Unit) {
    val b = SmartphoneBootReceive(callback)
    val filter = IntentFilter()
    filter.addAction(smartphoneBoot)
    registerReceiver(b, filter)
}

internal class SmartphoneBootReceive(private val callback: () -> Unit) :
    BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            smartphoneBoot -> callback()
        }
    }
}
