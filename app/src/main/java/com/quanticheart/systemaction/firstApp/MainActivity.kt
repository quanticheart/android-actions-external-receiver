package com.quanticheart.systemaction.firstApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.quanticheart.systemaction.R
import com.quanticheart.systemaction.firstApp.receiver.sendAppTaskStatusBroadcast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startTimerTest { // for test only, remove before test
            sendAppTaskStatusBroadcast()
        }
    }
}