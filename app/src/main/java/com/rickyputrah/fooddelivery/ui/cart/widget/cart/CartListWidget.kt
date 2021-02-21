package com.rickyputrah.fooddelivery.ui.cart.widget.cart

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rickyputrah.fooddelivery.R
import com.rickyputrah.fooddelivery.data.database.CartModel
import com.rickyputrah.fooddelivery.databinding.CartListWidgetBinding
import com.rickyputrah.fooddelivery.util.toVisibility


class CartListWidget @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private lateinit var adapter: CartListAdapter
    private lateinit var binding: CartListWidgetBinding

    private var callback: CartItemListener? = null

    init {
        if (isInEditMode) {
            LayoutInflater.from(getContext()).inflate(R.layout.cart_list_widget, this, true)
        } else {
            binding = CartListWidgetBinding.inflate(LayoutInflater.from(context), null, false)
            setupListener()
            addView(binding.root)
        }
    }

    fun setCartModel(carts: List<CartModel>, listener: CartItemListener) {
        adapter =
            CartListAdapter(
                context,
                listener
            )
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        adapter.dataset = carts
        adapter.notifyDataSetChanged()
        val price = carts.fold(0) { acc, cart -> acc.plus(cart.price) }
        binding.textPrice.text = "$$price"
        setupVisibility(carts)
        callback = listener
    }

    private fun setupVisibility(carts: List<CartModel>) {
        binding.layoutPriceFee.visibility = (carts.isNotEmpty()).toVisibility()
        binding.recyclerView.visibility = (carts.isNotEmpty()).toVisibility()
        binding.layoutEmpty.visibility = (carts.isEmpty()).toVisibility()
    }

    private fun setupListener() {
        binding.buttonOrder.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}

interface CartItemListener {
    fun onRemoveClick(cartModel: CartModel)
}
