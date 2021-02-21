package com.rickyputrah.fooddelivery.data.repository.cart

import com.rickyputrah.fooddelivery.data.database.CartModel
import com.rickyputrah.fooddelivery.data.repository.ResultRepository
import com.rickyputrah.fooddelivery.data.repository.handleRequest
import com.rickyputrah.fooddelivery.ui.home.widget.food.FoodListWidgetSpec
import javax.inject.Inject

class CartRepository @Inject constructor(private val cartDao: CartDao) : ICartRepository {

    override suspend fun getCartList(): ResultRepository<List<CartModel>> = handleRequest {
        cartDao.getCartList()
    }


    override suspend fun insertCartData(food: FoodListWidgetSpec.Food): ResultRepository<Any> =
        handleRequest {
            cartDao.insertNewItem(food.toCartModel())
        }

    override suspend fun removeCartData(cart: CartModel): ResultRepository<Any> = handleRequest {
        cartDao.removeCartItem(cart)
    }
}