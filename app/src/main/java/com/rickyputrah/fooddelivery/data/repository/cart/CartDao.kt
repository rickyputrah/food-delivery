package com.rickyputrah.fooddelivery.data.repository.cart

import androidx.room.*
import com.rickyputrah.fooddelivery.data.database.CartModel


@Dao
interface CartDao {

    @Query("SELECT * FROM cart")
    fun getCartList(): List<CartModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewItem(cart: CartModel)

    @Delete
    fun removeCartItem(param: CartModel)
}