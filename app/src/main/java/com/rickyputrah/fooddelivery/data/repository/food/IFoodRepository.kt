package com.rickyputrah.fooddelivery.data.repository.food

import com.rickyputrah.fooddelivery.data.model.MenuListResponse
import com.rickyputrah.fooddelivery.data.repository.ResultRepository

interface IFoodRepository {
    suspend fun getFoodList(): ResultRepository<MenuListResponse>
}