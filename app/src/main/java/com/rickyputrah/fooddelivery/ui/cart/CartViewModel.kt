package com.rickyputrah.fooddelivery.ui.cart

import com.airbnb.mvrx.*
import com.rickyputrah.fooddelivery.data.database.CartModel
import com.rickyputrah.fooddelivery.data.repository.ResultRepository
import com.rickyputrah.fooddelivery.data.repository.cart.ICartRepository
import com.rickyputrah.fooddelivery.di.AssistedViewModelFactory
import com.rickyputrah.fooddelivery.di.daggerMavericksViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class CartState(val data: Async<List<CartModel>> = Uninitialized) : MavericksState

class CartViewModel @AssistedInject constructor(
    @Assisted state: CartState,
    private val cartRepository: ICartRepository
) : MavericksViewModel<CartState>(state) {

    init {
        loadCartData()
    }

    private fun loadCartData() {
        viewModelScope.launch {
            setState {
                this.copy(data = Loading())
            }
            withContext(Dispatchers.IO) {
                when (val cartData = cartRepository.getCartList()) {
                    is ResultRepository.Success -> setState {
                        this.copy(data = Success(cartData.data))
                    }
                    else -> setState {
                        this.copy(data = Fail(error = Throwable("Failed to fetch data")))
                    }
                }
            }
        }
    }

    fun removeCart(cartModel: CartModel) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                cartRepository.removeCartData(cartModel)
                loadCartData()
            }
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<CartViewModel, CartState> {
        override fun create(state: CartState): CartViewModel
    }

    companion object :
        MavericksViewModelFactory<CartViewModel, CartState> by daggerMavericksViewModelFactory()
}

