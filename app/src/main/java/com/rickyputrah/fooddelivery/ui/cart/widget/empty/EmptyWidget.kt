package com.rickyputrah.fooddelivery.ui.cart.widget.empty

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.rickyputrah.fooddelivery.R
import com.rickyputrah.fooddelivery.databinding.EmptyWidgetBinding

class EmptyWidget @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private lateinit var binding: EmptyWidgetBinding

    init {
        if (isInEditMode) {
            LayoutInflater.from(getContext()).inflate(R.layout.empty_widget, this, true)
        } else {
            binding = EmptyWidgetBinding.inflate(LayoutInflater.from(context), null, false)
            addView(binding.root)
        }
    }

}