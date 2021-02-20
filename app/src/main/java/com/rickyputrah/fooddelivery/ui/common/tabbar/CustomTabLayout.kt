package com.rickyputrah.fooddelivery.ui.common.tabbar


import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.annotation.NonNull
import com.google.android.material.tabs.TabLayout
import com.rickyputrah.fooddelivery.R


class CustomTabLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TabLayout(context, attrs, defStyleAttr) {

    @NonNull
    override fun newTab(): Tab {
        val tab = super.newTab()
        tab.setCustomView(R.layout.layout_tab_bar)
        if (tabTextColors != null) {
            setTabTextColor(tab, tabTextColors)
        }
        return tab
    }

    override fun setTabTextColors(textColor: ColorStateList?) {
        super.setTabTextColors(textColor)

        //Custom views don't get the color treatment set it here whenever setTabTextColors gets called
        for (tabIter in 0 until this.tabCount) {
            setTabTextColor(getTabAt(tabIter), textColor)
        }
    }

    fun setTabText(title: String, position: Int) {
        val textView =
            this.getTabAt(position)?.customView?.findViewById<View>(R.id.text_label) as? TextView
        textView?.text = title
    }

    private fun setTabTextColor(tab: Tab?, textColor: ColorStateList?) {
        val textView = tab?.customView?.findViewById<View>(R.id.text_label) as? TextView
        textView?.setTextColor(textColor)
    }
}