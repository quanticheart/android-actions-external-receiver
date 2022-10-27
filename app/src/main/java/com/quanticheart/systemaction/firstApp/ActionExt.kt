package com.quanticheart.systemaction.firstApp

import android.content.Context
import com.quanticheart.systemaction.firstApp.alarm.AppAlarm
import com.quanticheart.systemaction.utils.receivers.boot.registerBootReceiver

fun Context.registerFirstAppReceiver() {
    registerBootReceiver {
        AppAlarm.start(this)
    }
    AppAlarm.start(this)
}

