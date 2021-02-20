package com.rickyputrah.fooddelivery.util

import android.content.Context
import android.util.TypedValue

fun getAttributeColor(context: Context, attributeId: Int): Int {
    val typedValue = TypedValue()
    context.theme.resolveAttribute(attributeId, typedValue, true)

    return typedValue.data
}