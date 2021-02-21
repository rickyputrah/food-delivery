package com.rickyputrah.fooddelivery.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rickyputrah.fooddelivery.data.repository.cart.CartDao


@Database(entities = [CartModel::class], version = 1)
abstract class FoodDeliveryDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}