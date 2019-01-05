package com.example.filip.articlekoin

import android.app.Application
import com.example.filip.articlekoin.koin.articleModule
import com.example.filip.articlekoin.koin.networkModule
import com.example.filip.articlekoin.koin.schedulersModuleNamed
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(articleModule, schedulersModuleNamed, networkModule))
    }
}