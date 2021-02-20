package com.rickyputrah.fooddelivery

import com.airbnb.mvrx.Mavericks
import com.rickyputrah.fooddelivery.di.DIApplicationManager

class FoodApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        DIApplicationManager.setupApplicationComponent(this)
        Mavericks.initialize(this)
    }
}