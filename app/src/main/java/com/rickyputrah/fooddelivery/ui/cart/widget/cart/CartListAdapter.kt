package com.rickyputrah.fooddelivery.ui.cart.widget.cart

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
import com.rickyputrah.fooddelivery.data.database.CartModel
import com.rickyputrah.fooddelivery.databinding.CartListItemBinding

class CartListAdapter(
    private val context: Context,
    private val listener: CartItemListener
) : RecyclerView.Adapter<CartViewHolder>() {

    var dataset: List<CartModel> = listOf()
    private val glideRequest by lazy { Glide.with(context) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_list_item, parent, false)
        return CartViewHolder(
            view,
            listener,
            glideRequest
        )
    }

    override fun getItemCount() = dataset.count()

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        dataset.getOrNull(position)?.let {
            (holder as? CartViewHolder)?.bind(it)
        }
    }
}


class CartViewHolder(
    itemView: View,
    private val listener: CartItemListener,
    private val glideRequest: RequestManager
) : RecyclerView.ViewHolder(itemView) {

    private val binding = CartListItemBinding.bind(itemView)

    fun bind(cart: CartModel) {
        binding.textFood.text = cart.name
        binding.imageDelete.setOnClickListener {
            listener.onRemoveClick(cart)
        }

        val requestOptions = RequestOptions()
            .centerCrop()
            .override(300, 300)

        glideRequest.load(cart.imageUrl)
            .apply(requestOptions)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.imageViewMenu)
    }
}

