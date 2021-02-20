package com.rickyputrah.fooddelivery.di

import android.app.Application
import com.rickyputrah.fooddelivery.di.module.AppModule


object DIApplicationManager {
    lateinit var applicationComponent: ApplicationComponent

    fun setupApplicationComponent(app: Application) {
        this.applicationComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule(app)).build()
    }
}

fun getApplicationComponent() = DIApplicationManager.applicationComponent
