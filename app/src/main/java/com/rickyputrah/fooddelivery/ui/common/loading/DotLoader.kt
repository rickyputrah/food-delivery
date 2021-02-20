package com.rickyputrah.fooddelivery.ui.common.loading


import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.rickyputrah.fooddelivery.R
import com.rickyputrah.fooddelivery.util.getAttributeColor

class DotLoader @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    val DEFAULT_DOT_AMOUNT = 3
    val DEFAULT_COLOR = getAttributeColor(context, R.attr.colorPrimary)
    private var loadingAnimation: DotAnimation
    var isLoading: Boolean = true
        set(value) {
            field = value
            if (value) {
                startAnimation(loadingAnimation)
            } else {
                clearAnimation()
            }
        }

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.DotLoader, defStyleAttr, 0)
        val dotAmount = a.getInteger(R.styleable.DotLoader_dotAmount, DEFAULT_DOT_AMOUNT)
        val color = a.getInteger(R.styleable.DotLoader_color, DEFAULT_COLOR)
        a.recycle()

        loadingAnimation = DotAnimation(context, dotAmount, color)

        post { if (isLoading) startAnimation(loadingAnimation) }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = loadingAnimation.width
        val desiredHeight = loadingAnimation.height

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val width: Int
        val height: Int

        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize)
        } else {
            //Be whatever you want
            width = desiredWidth
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize)
        } else {
            //Be whatever you want
            height = desiredHeight
        }

        //MUST CALL THIS
        setMeasuredDimension(width, height)
    }

    @JvmOverloads
    fun setLoadingAnimation(dotAmount: Int = DEFAULT_DOT_AMOUNT, color: Int = DEFAULT_COLOR) {
        loadingAnimation = DotAnimation(context, dotAmount, color)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (isLoading) loadingAnimation.draw(this, canvas)
    }
}