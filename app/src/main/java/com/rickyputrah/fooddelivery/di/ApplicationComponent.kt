package com.rickyputrah.fooddelivery.di

import com.airbnb.mvrx.MavericksViewModel
import com.rickyputrah.fooddelivery.di.module.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        DatabaseModule::class,
        ServiceModule::class]
)
interface ApplicationComponent {

    fun viewModelFactories(): Map<Class<out MavericksViewModel<*>>, AssistedViewModelFactory<*, *>>
}