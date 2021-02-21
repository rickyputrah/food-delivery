package com.rickyputrah.fooddelivery.ui.cart

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.google.android.material.tabs.TabLayout
import com.rickyputrah.fooddelivery.R
import com.rickyputrah.fooddelivery.data.database.CartModel
import com.rickyputrah.fooddelivery.databinding.CartFragmentBinding
import com.rickyputrah.fooddelivery.ui.cart.widget.cart.CartItemListener
import com.rickyputrah.fooddelivery.ui.cart.widget.cart.CartListWidget
import com.rickyputrah.fooddelivery.ui.cart.widget.empty.EmptyWidget
import com.rickyputrah.fooddelivery.ui.home.HomePagerAdapter
import com.rickyputrah.fooddelivery.util.viewBinding

class CartFragment : Fragment(R.layout.cart_fragment), MavericksView,
    CartItemListener {

    private val viewModel: CartViewModel by fragmentViewModel()
    private val binding by viewBinding(CartFragmentBinding::bind)
    private val pageList by lazy {
        mutableListOf(
            resources.getString(R.string.text_cart_title_page),
            resources.getString(R.string.text_order_title_page),
            resources.getString(R.string.text_information_title_page)
        )
    }
    private val cartWidget by lazy {
        CartListWidget(
            requireContext()
        )
    }

    private lateinit var pagerAdapter: HomePagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
        setupPager()
    }

    override fun invalidate() = withState(viewModel) { state ->
        when (state.data) {
            is Success -> renderView(state.data.invoke())
        }
    }

    override fun onRemoveClick(cartModel: CartModel) {
        viewModel.removeCart(cartModel)
    }

    private fun renderView(carts: List<CartModel>) {
        cartWidget.setCartModel(carts, this)
    }

    private fun setupListener() {
        binding.textBackMenu.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupPager() {
        pagerAdapter = HomePagerAdapter()
        pagerAdapter.addView(cartWidget)
        pagerAdapter.addView(
            EmptyWidget(
                requireContext()
            )
        )
        pagerAdapter.addView(
            EmptyWidget(
                requireContext()
            )
        )
        binding.viewPagerContent.adapter = pagerAdapter
        binding.tabBar.setupWithViewPager(binding.viewPagerContent, true)
        binding.tabBar.tabMode = TabLayout.MODE_SCROLLABLE
        binding.tabBar.tabRippleColor = null
        binding.tabBar.setTabTextColors(
            ContextCompat.getColor(
                requireContext(),
                R.color.light_secondary
            ), ContextCompat.getColor(requireContext(), R.color.dark_stain)
        )
        pagerAdapter.notifyDataSetChanged()
        pageList.forEachIndexed { position, page ->
            binding.tabBar.setTabText(page, position)
        }
    }

}