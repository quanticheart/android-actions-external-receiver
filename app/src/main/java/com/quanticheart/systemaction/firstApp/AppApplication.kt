package com.quanticheart.systemaction.firstApp

import android.app.Application

//
// Created by Jonn Alves on 17/10/22.
//
class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        registerFirstAppReceiver()
    }
}
