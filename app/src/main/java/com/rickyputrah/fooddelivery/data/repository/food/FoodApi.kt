package com.rickyputrah.fooddelivery.data.repository.food

import com.rickyputrah.fooddelivery.data.model.MenuListResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface FoodApi {

    @GET("food")
    suspend fun getFoodList(): Deferred<MenuListResponse>
}