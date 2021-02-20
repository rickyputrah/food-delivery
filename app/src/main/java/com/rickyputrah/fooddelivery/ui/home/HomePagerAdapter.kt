package com.rickyputrah.fooddelivery.ui.home

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class HomePagerAdapter : PagerAdapter() {

    var views = mutableListOf<View>()
    var pageTitle = mutableListOf<String>()


    override fun getItemPosition(`object`: Any): Int {
        val index = views.indexOf(`object`)
        return if (index == -1) PagerAdapter.POSITION_NONE else index
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val v = views[position]
        if (container.indexOfChild(v) != -1) {
            container.removeView(v)
        }
        container.addView(v)
        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(views[position])
    }


    override fun getCount(): Int {
        return views.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    fun addView(v: View): Int {
        return addView(v, views.size)
    }

    fun addView(v: View, position: Int): Int {
        views.add(position, v)
        return position
    }

    fun removeView(pager: ViewPager, v: View?): Int {
        return removeView(pager, views.indexOf(v))
    }

    fun removeView(pager: ViewPager, position: Int): Int {
        pager.adapter = null
        views.removeAt(position)
        pager.adapter = this
        return position
    }

    fun removeAllView(pager: ViewPager) {
        pager.adapter = null
        views.clear()
        pager.adapter = this
    }

    fun getView(position: Int): View? {
        return views[position]
    }

    // Other relevant methods:
    override fun getPageTitle(position: Int): CharSequence? {
        return if (position >= pageTitle.size) "" else pageTitle[position]
    }

    fun removeAllPageTitle() {
        pageTitle.clear()
    }

    fun canScrollVertically(currentItem: Int, direction: Int): Boolean {
        return if (getView(currentItem) != null) {
            getView(currentItem)!!.canScrollVertically(direction)
        } else false
    }

}
