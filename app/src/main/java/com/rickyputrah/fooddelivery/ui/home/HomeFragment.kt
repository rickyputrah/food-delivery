package com.rickyputrah.fooddelivery.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.*
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import com.rickyputrah.fooddelivery.R
import com.rickyputrah.fooddelivery.databinding.HomeFragmentBinding
import com.rickyputrah.fooddelivery.databinding.LayoutTabBarBinding
import com.rickyputrah.fooddelivery.ui.home.widget.food.FoodListWidget
import com.rickyputrah.fooddelivery.ui.home.widget.food.FoodListWidgetSpec
import com.rickyputrah.fooddelivery.util.getPixelValue
import com.rickyputrah.fooddelivery.util.viewBinding
import kotlin.math.abs


class HomeFragment : Fragment(R.layout.home_fragment), MavericksView {

    private val viewModel: HomeViewModel by fragmentViewModel()

    private val binding by viewBinding(HomeFragmentBinding::bind)
    private lateinit var pagerAdapter: HomePagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAppBar()
        setupPager()
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
    }

    private fun setupFoodListData(foodSpecs: List<FoodListWidgetSpec>) {
        foodSpecs.forEachIndexed { position, spec ->
            val productListWidget = FoodListWidget(requireContext())
            productListWidget.setFoodListWidgetSpec(spec)
            pagerAdapter.addView(productListWidget)
            pagerAdapter.pageTitle.add(spec.category)

        }
        pagerAdapter.notifyDataSetChanged()
        foodSpecs.forEachIndexed { position, spec ->
            createTabBarItem(spec.category, position)
        }
    }

    private fun setupPager() {
        pagerAdapter = HomePagerAdapter()
        binding.viewPagerContent.adapter = pagerAdapter
        binding.tabBar.setupWithViewPager(binding.viewPagerContent, true)
        binding.tabBar.tabMode = TabLayout.MODE_SCROLLABLE
    }

    private fun createTabBarItem(title: String, position: Int) {
        val view = LayoutTabBarBinding.inflate(LayoutInflater.from(context)).apply {
            textLabel.text = title
        }
        binding.tabBar.getTabAt(position)?.customView = view.root
    }

    private fun setupAppBar() {
        binding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (abs(verticalOffset) - appBarLayout.totalScrollRange > -30) {
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
        })
        binding.collapsingToolbarLayout.setContentScrimColor(Color.TRANSPARENT)
    }
}