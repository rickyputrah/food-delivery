package com.rickyputrah.fooddelivery.data.repository.cart

import com.rickyputrah.fooddelivery.data.database.CartModel
import com.rickyputrah.fooddelivery.data.repository.ResultRepository
import com.rickyputrah.fooddelivery.ui.home.widget.food.FoodListWidgetSpec

interface ICartRepository {
    suspend fun getCartList(): ResultRepository<List<CartModel>>

    suspend fun insertCartData(food: FoodListWidgetSpec.Food): ResultRepository<Any>

    suspend fun removeCartData(cart: CartModel): ResultRepository<Any>
}