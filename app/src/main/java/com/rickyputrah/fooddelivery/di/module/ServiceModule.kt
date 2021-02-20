package com.rickyputrah.fooddelivery.di.module

import com.rickyputrah.fooddelivery.data.network.ApiService
import com.rickyputrah.fooddelivery.data.network.ApiServiceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class ServiceModule {
    @Binds
    abstract fun bindApiService(apiService: ApiServiceImpl): ApiService
}