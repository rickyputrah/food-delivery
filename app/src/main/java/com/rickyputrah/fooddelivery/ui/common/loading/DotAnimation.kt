package com.rickyputrah.fooddelivery.ui.common.loading

import android.animation.ArgbEvaluator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.Transformation
import com.rickyputrah.fooddelivery.R
import com.rickyputrah.fooddelivery.util.getAttributeColor
import com.rickyputrah.fooddelivery.util.getPixelValue

class DotAnimation @JvmOverloads constructor(
    context: Context,
    private val dotAmount: Int = 3,
    private val color: Int = getAttributeColor(context, R.attr.colorPrimary)
) : Animation() {
    private val DOT_DISTANCE: Int
    private val NEXT_BOUNCE_TIME: Int
    private val ANIMATION_TIME: Int
    private val totalAnimationTime: Int
    private var interpolatedTime = 0f

    private val dotRadius: Float = 2f.getPixelValue(context).toFloat()
    private val bounceDotRadius: Float = 6f.getPixelValue(context).toFloat()

    private val colorEvaluator = ArgbEvaluator()
    private val fadeColor: Int =
        androidx.core.graphics.ColorUtils.setAlphaComponent(color, 255 * 40 / 100)
    private val primaryPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG).apply {
        color = this@DotAnimation.color
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = 20f
    }

    val width: Int
    val height: Int

    init {
        DOT_DISTANCE = context.resources.getDimension(R.dimen.spacing_xs).toInt()
        NEXT_BOUNCE_TIME = context.resources.getInteger(R.integer.animation_timing_instant)
        ANIMATION_TIME = context.resources.getInteger(R.integer.animation_timing_normal)
        totalAnimationTime = (ANIMATION_TIME * 2) + (dotAmount * NEXT_BOUNCE_TIME)

        width = ((bounceDotRadius * 2) + (DOT_DISTANCE + (2 * dotRadius)) * (dotAmount - 1)).toInt()
        height = (bounceDotRadius * 2).toInt()

        duration = totalAnimationTime.toLong()
        repeatCount = INFINITE
        interpolator = LinearInterpolator()
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
        super.applyTransformation(interpolatedTime, t)
        this.interpolatedTime = interpolatedTime
    }

    fun getX(view: View): Float = (view.measuredWidth - width) / 2f + bounceDotRadius

    fun getY(view: View): Float = view.measuredHeight / 2f

    fun draw(view: View, canvas: Canvas) {
        val x = getX(view)
        val y = getY(view)

        var step = 0f
        for (i in 0 until dotAmount) {
            val start = (i * NEXT_BOUNCE_TIME).toFloat() / totalAnimationTime
            val mid = ((i * NEXT_BOUNCE_TIME) + ANIMATION_TIME).toFloat() / totalAnimationTime
            val end = ((i * NEXT_BOUNCE_TIME) + (ANIMATION_TIME * 2).toFloat()) / totalAnimationTime

            if (interpolatedTime >= start && interpolatedTime < mid) {
                drawCircleUp(canvas, step, x, y, (interpolatedTime - start) / (mid - start))
            } else if (interpolatedTime >= mid && interpolatedTime < end) {
                drawCircleDown(canvas, step, x, y, (interpolatedTime - mid) / (end - mid))
            } else {
                drawCircle(canvas, step, x, y)
            }
            step += DOT_DISTANCE + (2 * dotRadius)
        }
        view.invalidate()
    }

    private fun drawCircle(canvas: Canvas, step: Float, x: Float, y: Float) {
        canvas.drawCircle(
            x + step,
            y,
            dotRadius,
            primaryPaint.apply {
                color = fadeColor
            }
        )
    }

    private fun drawCircleDown(
        canvas: Canvas,
        step: Float,
        x: Float,
        y: Float,
        interpolatedTime: Float
    ) {
        canvas.drawCircle(
            x + step,
            y,
            bounceDotRadius - ((bounceDotRadius - dotRadius) * interpolatedTime),
            primaryPaint.apply {
                color = colorEvaluator.evaluate(
                    interpolatedTime,
                    this@DotAnimation.color,
                    fadeColor
                ) as Int
            }
        )
    }

    private fun drawCircleUp(
        canvas: Canvas,
        step: Float,
        x: Float,
        y: Float,
        interpolatedTime: Float
    ) {
        canvas.drawCircle(x + step,
            y,
            dotRadius + ((bounceDotRadius - dotRadius) * interpolatedTime),
            primaryPaint.apply {
                color = colorEvaluator.evaluate(
                    interpolatedTime,
                    fadeColor,
                    this@DotAnimation.color
                ) as Int
            }
        )
    }
}
