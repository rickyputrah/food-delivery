package com.rickyputrah.fooddelivery.ui.home.widget.gallery

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.rickyputrah.fooddelivery.R
import com.rickyputrah.fooddelivery.databinding.ImageGalleryWidgetBinding

class ImageGalleryWidget @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private lateinit var binding: ImageGalleryWidgetBinding

    init {
        if (isInEditMode) {
            LayoutInflater.from(getContext()).inflate(R.layout.image_gallery_widget, this, true)
        } else {
            binding = ImageGalleryWidgetBinding.inflate(LayoutInflater.from(context), null, false)
            addView(binding.root)
        }
    }

    fun setImageList(list: List<String>) {
        val adapter =
            ImageGalleryAdapter(
                context,
                list
            )
        binding.viewPager.adapter = adapter
        adapter.notifyDataSetChanged()
        binding.pageIndicator.attachToPager(binding.viewPager)
        binding.pageIndicator.visibility = View.VISIBLE
    }


}