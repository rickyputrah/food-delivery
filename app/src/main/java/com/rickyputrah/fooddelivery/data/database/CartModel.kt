package com.rickyputrah.fooddelivery.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cart")
data class CartModel(
    @PrimaryKey
    val id: Int,
    val imageUrl: String,
    val name: String,
    val description: String,
    val portion: String,
    val price: Int
)