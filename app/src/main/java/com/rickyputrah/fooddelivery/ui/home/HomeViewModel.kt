package com.rickyputrah.fooddelivery.ui.home

import com.airbnb.mvrx.*
import com.rickyputrah.fooddelivery.data.repository.ResultRepository
import com.rickyputrah.fooddelivery.data.repository.banner.IBannerRepository
import com.rickyputrah.fooddelivery.data.repository.cart.ICartRepository
import com.rickyputrah.fooddelivery.data.repository.food.IFoodRepository
import com.rickyputrah.fooddelivery.di.AssistedViewModelFactory
import com.rickyputrah.fooddelivery.di.daggerMavericksViewModelFactory
import com.rickyputrah.fooddelivery.ui.home.widget.food.FoodListWidgetSpec
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class HomeState(val data: Async<HomeResult> = Uninitialized) : MavericksState

data class HomeResult(
    val foodList: List<FoodListWidgetSpec>,
    val banners: List<String>,
    val number: Int
)

class HomeViewModel @AssistedInject constructor(
    @Assisted state: HomeState,
    private val foodRepository: IFoodRepository,
    private val bannerRepository: IBannerRepository,
    private val cartRepository: ICartRepository
) : MavericksViewModel<HomeState>(state) {

    private var subscription: Disposable? = null

    init {
        loadFoodList()
    }

    private fun loadFoodList() {
        viewModelScope.launch {
            setState {
                this.copy(data = Loading())
            }
            withContext(Dispatchers.IO) {
                val result = foodRepository.getFoodList()
                val resultBanner = bannerRepository.getBanner()
                val resultCart = cartRepository.getCartList()

                val numberCart = (resultCart as? ResultRepository.Success)?.data?.size ?: 0

                if (result is ResultRepository.Success && resultBanner is ResultRepository.Success) {
                    setState {
                        this.copy(
                            data = Success(
                                HomeResult(
                                    result.data.toFoodListWidgetSpec(),
                                    resultBanner.data.imageUrls,
                                    numberCart
                                )
                            )
                        )
                    }
                } else {
                    setState {
                        this.copy(data = Fail(error = Throwable("Failed to fetch data")))
                    }
                }
            }
        }
    }

    fun addToCart(food: FoodListWidgetSpec.Food) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                cartRepository.insertCartData(food)
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        subscription?.dispose()
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<HomeViewModel, HomeState> {
        override fun create(state: HomeState): HomeViewModel
    }

    companion object :
        MavericksViewModelFactory<HomeViewModel, HomeState> by daggerMavericksViewModelFactory()
}

