package com.rickyputrah.fooddelivery.ui.home.widget.gallery

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions


class ImageGalleryAdapter(private val context: Context, private val list: List<String>) :
    PagerAdapter() {

    private val glideRequest by lazy { Glide.with(context) }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(context).apply {
            scaleType = ImageView.ScaleType.CENTER_CROP
        }
        val requestOptions = RequestOptions()
            .centerCrop()
            .override(300, 300)

        glideRequest.load(list[position])
            .apply(requestOptions)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)
        container.addView(imageView)
        return imageView
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, obj: Any) = view == obj
    override fun getCount(): Int = list.count()
}
