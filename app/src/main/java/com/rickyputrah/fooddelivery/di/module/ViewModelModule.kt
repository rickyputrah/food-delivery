package com.rickyputrah.fooddelivery.di.module

import com.rickyputrah.fooddelivery.di.AssistedViewModelFactory
import com.rickyputrah.fooddelivery.di.ViewModelKey
import com.rickyputrah.fooddelivery.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun homeViewModelFactory(factory: HomeViewModel.Factory): AssistedViewModelFactory<*, *>
}