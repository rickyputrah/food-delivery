package com.rickyputrah.fooddelivery.ui.cart

import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.rickyputrah.fooddelivery.R
import com.rickyputrah.fooddelivery.databinding.HomeFragmentBinding
import com.rickyputrah.fooddelivery.ui.home.HomeViewModel
import com.rickyputrah.fooddelivery.util.viewBinding

class CartFragment : Fragment(R.layout.cart_fragment), MavericksView {

    private val viewModel: HomeViewModel by fragmentViewModel()

    private val binding by viewBinding(HomeFragmentBinding::bind)

    override fun invalidate() {

    }
}