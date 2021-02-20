package com.rickyputrah.fooddelivery.ui.home.widget.food

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.rickyputrah.fooddelivery.R
import com.rickyputrah.fooddelivery.databinding.FoodListItemBinding

class FoodListAdapter(private val context: Context) : RecyclerView.Adapter<FoodViewHolder>() {

    var dataset: List<FoodListWidgetSpec.Food> = listOf()
    private val glideRequest by lazy { Glide.with(context) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_list_item, parent, false)
        return FoodViewHolder(view, glideRequest)
    }

    override fun getItemCount() = dataset.count()

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        dataset.getOrNull(position)?.let {
            (holder as? FoodViewHolder)?.bind(it)
        }
    }
}

class FoodViewHolder(
    itemView: View,
    private val glideRequest: RequestManager
) : RecyclerView.ViewHolder(itemView) {

    private val binding = FoodListItemBinding.bind(itemView)

    fun bind(item: FoodListWidgetSpec.Food) {
        binding.textName.text = item.name
        binding.textDescription.text = item.description
        binding.textSizeInfo.text = item.portion
        binding.buttonOrder.text = item.price.toString()

        binding.buttonOrder.setOnClickListener {

        }

        val requestOptions = RequestOptions()
            .centerCrop()
            .override(300, 300)

        glideRequest.load(item.imageUrl)
            .apply(requestOptions)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.imageView)
    }
}

