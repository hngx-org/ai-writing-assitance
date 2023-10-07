package com.example.aiwritingassitance

import android.app.Application
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext

class MyApp: Application() {
    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

    }
}