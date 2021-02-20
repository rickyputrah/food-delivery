package com.rickyputrah.fooddelivery.data.repository.banner

import com.rickyputrah.fooddelivery.data.model.BannerResponse
import com.rickyputrah.fooddelivery.data.network.ApiService
import com.rickyputrah.fooddelivery.data.repository.ResultRepository
import com.rickyputrah.fooddelivery.data.repository.handleRequest
import javax.inject.Inject


class BannerRepository @Inject constructor(private val apiService: ApiService) : IBannerRepository {

    override suspend fun getBanner(): ResultRepository<BannerResponse> = handleRequest {
        apiService.create(BannerApi::class.java).getBannerList().await()
    }

}