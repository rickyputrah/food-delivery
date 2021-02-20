package com.rickyputrah.fooddelivery.data.repository.food

import com.rickyputrah.fooddelivery.data.model.MenuListResponse
import com.rickyputrah.fooddelivery.data.network.ApiService
import com.rickyputrah.fooddelivery.data.repository.ResultRepository
import com.rickyputrah.fooddelivery.data.repository.handleRequest
import javax.inject.Inject

class FoodRepository @Inject constructor(private val apiService: ApiService) : IFoodRepository {

    override suspend fun getFoodList(): ResultRepository<MenuListResponse> = handleRequest {
        apiService.create(FoodApi::class.java).getFoodList().await()
    }

}