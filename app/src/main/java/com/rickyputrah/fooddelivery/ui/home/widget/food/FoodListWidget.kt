package com.rickyputrah.fooddelivery.ui.home.widget.food

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.rickyputrah.fooddelivery.R
import com.rickyputrah.fooddelivery.data.database.CartModel
import com.rickyputrah.fooddelivery.databinding.FoodListWidgetBinding

data class FoodListWidgetSpec(
    val category: String,
    val foodList: List<Food>
) {
    data class Food(
        val id: Int,
        val imageUrl: String,
        val name: String,
        val description: String,
        val portion: String,
        val price: Int
    ) {
        fun toCartModel(): CartModel {
            return CartModel(
                id = this.id,
                imageUrl = this.imageUrl,
                name = this.name,
                description = this.description,
                portion = this.portion,
                price = this.price
            )
        }
    }
}

class FoodListWidget @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private lateinit var adapter: FoodListAdapter
    private lateinit var binding: FoodListWidgetBinding

    init {
        if (isInEditMode) {
            LayoutInflater.from(getContext()).inflate(R.layout.food_list_widget, this, true)
        } else {
            binding = FoodListWidgetBinding.inflate(LayoutInflater.from(context), null, false)
            addView(binding.root)
        }
    }

    fun setFoodListWidgetSpec(spec: FoodListWidgetSpec, listener: FoodItemListener) {
        adapter = FoodListAdapter(context, listener)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        adapter.dataset = spec.foodList
        adapter.notifyDataSetChanged()
    }
}

interface FoodItemListener {
    fun onButtonAddClicked(food: FoodListWidgetSpec.Food)
}