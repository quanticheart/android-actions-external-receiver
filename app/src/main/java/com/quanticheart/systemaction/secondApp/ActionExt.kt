package com.quanticheart.systemaction.secondApp

import android.app.Application
import android.content.Context
import android.content.IntentFilter
import com.quanticheart.systemaction.secondApp.receiver.SecondAppReceiver
import com.quanticheart.systemaction.utils.appAction
import com.quanticheart.systemaction.utils.receivers.boot.registerBootReceiver

fun Application.registerSecondAppReceiver() {
    registerBootReceiver {
        start()
    }
    start()
}

private fun Context.start() {
    val intentFilter = IntentFilter(appAction)
    val myReceiver = SecondAppReceiver()
    registerReceiver(myReceiver, intentFilter)
}
