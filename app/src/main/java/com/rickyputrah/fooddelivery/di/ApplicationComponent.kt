package com.rickyputrah.fooddelivery.di

import com.airbnb.mvrx.MavericksViewModel
import com.rickyputrah.fooddelivery.di.module.AppModule
import com.rickyputrah.fooddelivery.di.module.RepositoryModule
import com.rickyputrah.fooddelivery.di.module.ServiceModule
import com.rickyputrah.fooddelivery.di.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        ServiceModule::class]
)
interface ApplicationComponent {

    fun viewModelFactories(): Map<Class<out MavericksViewModel<*>>, AssistedViewModelFactory<*, *>>
}