package com.example.kotlinknowledge

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication: Application(){
    companion object{
        private var mSelf: MainApplication? = null
        fun self(): MainApplication? {
            return mSelf
        }
    }

    override fun onCreate() {
        super.onCreate()
        mSelf = this
    }
}