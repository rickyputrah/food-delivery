package com.rickyputrah.fooddelivery.data.repository.banner

import com.rickyputrah.fooddelivery.data.model.BannerResponse
import com.rickyputrah.fooddelivery.data.repository.ResultRepository

interface IBannerRepository {
    suspend fun getBanner(): ResultRepository<BannerResponse>
}