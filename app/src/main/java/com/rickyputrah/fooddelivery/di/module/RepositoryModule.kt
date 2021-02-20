package com.rickyputrah.fooddelivery.di.module

import com.rickyputrah.fooddelivery.BuildConfig
import com.rickyputrah.fooddelivery.data.network.ApiService
import com.rickyputrah.fooddelivery.data.repository.banner.BannerRepository
import com.rickyputrah.fooddelivery.data.repository.banner.FakeBannerRepository
import com.rickyputrah.fooddelivery.data.repository.banner.IBannerRepository
import com.rickyputrah.fooddelivery.data.repository.food.FakeFoodRepository
import com.rickyputrah.fooddelivery.data.repository.food.FoodRepository
import com.rickyputrah.fooddelivery.data.repository.food.IFoodRepository
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule {

    @Provides
    fun provideFoodRepository(apiService: ApiService): IFoodRepository {
        return if (BuildConfig.FAKE) {
            FakeFoodRepository()
        } else {
            FoodRepository(apiService)
        }
    }

    @Provides
    fun provideBannerRepository(apiService: ApiService): IBannerRepository {
        return if (BuildConfig.FAKE) {
            FakeBannerRepository()
        } else {
            BannerRepository(apiService)
        }
    }
}