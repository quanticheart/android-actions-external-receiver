package com.quanticheart.systemaction.secondApp.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.quanticheart.systemaction.utils.appAction

internal class SecondAppReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            appAction -> {
                val status = intent.getBooleanExtra("running", false)
                Log.e(
                    "ACTION FROM FIRST APP",
                    "App is Running? = $status"
                )
            }
        }
    }
}
