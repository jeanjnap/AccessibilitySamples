package com.example.accessibilitysamples

import android.app.Application
import com.example.accessibilitysamples.di.AccessibilityModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AccessibilityApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AccessibilityApplication)
            modules(AccessibilityModule.instance)
        }
    }

}