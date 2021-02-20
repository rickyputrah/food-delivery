package com.rickyputrah.fooddelivery.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val appContext: Context) {

    @Provides
    internal fun provideAppContext(): Context = appContext
}