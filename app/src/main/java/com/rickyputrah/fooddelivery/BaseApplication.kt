package com.rickyputrah.fooddelivery

import android.app.Application
import com.rickyputrah.fooddelivery.util.BASE_URL

open class BaseApplication : Application() {

    open fun getBaseUrl() = BASE_URL
}