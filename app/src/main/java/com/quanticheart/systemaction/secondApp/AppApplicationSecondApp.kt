package com.quanticheart.systemaction.secondApp

import android.app.Application

//
// Created by Jonn Alves on 17/10/22.
//
class AppApplicationSecondApp : Application() {
    override fun onCreate() {
        super.onCreate()
        registerSecondAppReceiver()
    }
}
