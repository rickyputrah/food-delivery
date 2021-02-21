package com.rickyputrah.fooddelivery.data.model

import com.rickyputrah.fooddelivery.ui.home.widget.food.FoodListWidgetSpec

data class MenuListResponse(
    val foods: List<MenuCollectionResponse>
) {

    data class MenuCollectionResponse(
        val collectionName: String,
        val menus: List<Menu>
    )

    data class Menu(
        val id: Int,
        val name: String,
        val price: Int,
        val portion: String,
        val imageUrl: String,
        val description: String
    )

    fun toFoodListWidgetSpec(): List<FoodListWidgetSpec> {
        return this.foods.map {
            FoodListWidgetSpec(
                it.collectionName,
                it.menus.map { menu ->
                    FoodListWidgetSpec.Food(
                        id = menu.id,
                        imageUrl = menu.imageUrl,
                        name = menu.name,
                        description = menu.description,
                        portion = menu.portion,
                        price = menu.price
                    )
                }
            )
        }
    }

}

