package com.rickyputrah.fooddelivery.ui.home

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.*
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils
import com.google.android.material.tabs.TabLayout
import com.rickyputrah.fooddelivery.R
import com.rickyputrah.fooddelivery.databinding.HomeFragmentBinding
import com.rickyputrah.fooddelivery.ui.home.widget.food.FoodItemListener
import com.rickyputrah.fooddelivery.ui.home.widget.food.FoodListWidget
import com.rickyputrah.fooddelivery.ui.home.widget.food.FoodListWidgetSpec
import com.rickyputrah.fooddelivery.util.getPixelValue
import com.rickyputrah.fooddelivery.util.viewBinding
import kotlin.math.abs


class HomeFragment : Fragment(R.layout.home_fragment), MavericksView, FoodItemListener {

    private val viewModel: HomeViewModel by fragmentViewModel()
    private val binding by viewBinding(HomeFragmentBinding::bind)

    private var alreadyShow = false
    private var numberCart = 0

    private lateinit var pagerAdapter: HomePagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAppBar()
        setupPager()
        setupListener()
    }

    override fun onButtonAddClicked(food: FoodListWidgetSpec.Food) {
        setupBadgeView(++numberCart)
        viewModel.addToCart(food)
    }

    private fun setupListener() {
        binding.buttonCart.setOnClickListener {
            findNavController().navigate(R.id.action_home_fragment_to_cart_fragment)
        }
    }


    override fun invalidate() = withState(viewModel) { state ->
        when (state.data) {
            is Loading -> binding.loading.showLoading(true)
            is Success -> renderView(state.data.invoke())
            else -> println("")
        }
    }

    private fun renderView(result: HomeResult) {
        setupFoodListData(result.foodList)
        binding.imageGallery.setImageList(result.banners)
        binding.loading.showLoading(false)
        numberCart = result.number
    }

    private fun setupFoodListData(foodSpecs: List<FoodListWidgetSpec>) {
        foodSpecs.forEachIndexed { position, spec ->
            val productListWidget = FoodListWidget(requireContext())
            productListWidget.setFoodListWidgetSpec(spec, this)
            pagerAdapter.addView(productListWidget)
            pagerAdapter.pageTitle.add(spec.category)
        }
        pagerAdapter.notifyDataSetChanged()
        foodSpecs.forEachIndexed { position, spec ->
            binding.tabBar.setTabText(spec.category, position)
        }
    }

    private fun setupPager() {
        pagerAdapter = HomePagerAdapter()
        binding.viewPagerContent.adapter = pagerAdapter
        binding.tabBar.setupWithViewPager(binding.viewPagerContent, true)
        binding.tabBar.tabMode = TabLayout.MODE_SCROLLABLE
        binding.tabBar.tabRippleColor = null
        binding.tabBar.setTabTextColors(
            ContextCompat.getColor(
                requireContext(),
                R.color.dark_secondary
            ), ContextCompat.getColor(requireContext(), R.color.dark_stain)
        )
    }

    private fun setupAppBar() {
        binding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val range = abs(verticalOffset) - appBarLayout.totalScrollRange
            setupTabBarView(range)
            setupButtonCartVisibility(range)
        })
        binding.collapsingToolbarLayout.setContentScrimColor(Color.TRANSPARENT)
    }

    private fun setupTabBarView(range: Int) {
        if (range > -30) {
            binding.tabBar.background = null
            val params = binding.tabBar.layoutParams as LinearLayout.LayoutParams
            params.setMargins(0, 0, 0, 0)
        } else {
            binding.tabBar.background = ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_vector_content_top_radius
            )
            val params = binding.tabBar.layoutParams as LinearLayout.LayoutParams
            params.setMargins(0, (-20f).getPixelValue(requireContext()), 0, 0)
        }
    }

    private fun setupButtonCartVisibility(range: Int) {
        if (range > -1000) {
            binding.buttonCart.visibility = View.VISIBLE
            if (!alreadyShow) {
                alreadyShow = true
                binding.buttonCart.viewTreeObserver.addOnGlobalLayoutListener(object :
                    OnGlobalLayoutListener {
                    @SuppressLint("UnsafeExperimentalUsageError")
                    override fun onGlobalLayout() {
                        badgeDrawable.number = numberCart
                        badgeDrawable.isVisible = numberCart > 0
                        BadgeUtils.attachBadgeDrawable(badgeDrawable, binding.buttonCart, null)
                        binding.buttonCart.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    }
                })
            }
        } else {
            binding.buttonCart.visibility = View.GONE
        }
    }

    private val badgeDrawable by lazy {
        BadgeDrawable.create(requireContext()).apply {
            horizontalOffset = 30
            verticalOffset = 20
        }
    }

    private fun setupBadgeView(number: Int) {
        badgeDrawable.number = number
        badgeDrawable.isVisible = number > 0
    }
}