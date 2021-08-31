package com.aashiq.kotlin_arch_ash

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {


    companion object{
        lateinit var instance : MyApplication
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
    }


}