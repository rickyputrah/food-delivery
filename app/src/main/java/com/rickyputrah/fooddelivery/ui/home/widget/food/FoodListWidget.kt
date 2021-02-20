package com.rickyputrah.fooddelivery.ui.home.widget.food

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.rickyputrah.fooddelivery.R
import com.rickyputrah.fooddelivery.databinding.FoodListWidgetBinding

data class FoodListWidgetSpec(
    val category: String,
    val foodList: List<Food>
) {
    data class Food(
        val imageUrl: String,
        val name: String,
        val description: String,
        val portion: String,
        val price: Double
    )
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
            initAdapter()
            addView(binding.root)
        }
    }

    private fun initAdapter() {
        adapter = FoodListAdapter(context)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    fun setFoodListWidgetSpec(spec: FoodListWidgetSpec) {
        adapter.dataset = spec.foodList
        adapter.notifyDataSetChanged()
    }

}