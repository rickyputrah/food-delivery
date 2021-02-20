package com.rickyputrah.fooddelivery.util

import android.content.Context
import android.util.TypedValue
import android.view.View


/**
 * Simplify boolean checking for visibility
 * The default value for true is VISIBLE and false is GONE
 * the default true and false visibility could be replaced by replacing the default value
 */
fun Boolean.toVisibility(
    trueVisibility: Int = View.VISIBLE,
    falseVisibility: Int = View.GONE
): Int = if (this) trueVisibility else falseVisibility


fun Float.getPixelValue(context: Context) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this,
    context.resources.displayMetrics
).toInt()

