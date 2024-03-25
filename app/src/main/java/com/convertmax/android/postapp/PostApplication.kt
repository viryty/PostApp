package com.convertmax.android.postapp

import android.app.Application
import com.convertmax.android.postapp.di.AppComponent
import com.convertmax.android.postapp.di.DaggerAppComponent


class PostApplication : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder().build()
    }
}