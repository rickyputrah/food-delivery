package com.rickyputrah.fooddelivery.data.repository.banner

import com.rickyputrah.fooddelivery.data.model.BannerResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface BannerApi {

    @GET("banner")
    suspend fun getBannerList(): Deferred<BannerResponse>
}