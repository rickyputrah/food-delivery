package com.rickyputrah.fooddelivery.ui.cart

import com.airbnb.mvrx.*
import com.rickyputrah.fooddelivery.data.database.CartModel
import com.rickyputrah.fooddelivery.data.repository.cart.ICartRepository
import com.rickyputrah.fooddelivery.di.AssistedViewModelFactory
import com.rickyputrah.fooddelivery.di.daggerMavericksViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

data class CartState(val data: Async<List<CartModel>> = Uninitialized) : MavericksState

class CartViewModel @AssistedInject constructor(
    @Assisted state: CartState,
    private val cartRepository: ICartRepository
) : MavericksViewModel<CartState>(state) {


    @AssistedFactory
    interface Factory : AssistedViewModelFactory<CartViewModel, CartState> {
        override fun create(state: CartState): CartViewModel
    }

    companion object :
        MavericksViewModelFactory<CartViewModel, CartState> by daggerMavericksViewModelFactory()
}

