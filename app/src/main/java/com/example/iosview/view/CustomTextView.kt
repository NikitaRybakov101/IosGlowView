package com.example.iosview.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CustomTextView @JvmOverloads constructor(context : Context, attrs : AttributeSet? = null, style: Int = 0) : View(context,attrs,style) ,
    CustomTextViewInterface {

    private val paintText = Paint().apply { color = Color.argb(255,0, 0,0)
        isAntiAlias = true
    }

    private var string = ""
    private var isStart = false

    private lateinit var canvas : Canvas
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        this.canvas = canvas

        if(isStart) {
            animText.render()
        }
    }

    private val animText = ValueAnimatorX.ofValue(0f, string.length.toFloat()).apply {
        vectorFunction { 10f }
        render { value -> drawText(value) }
    }

    private fun drawText(value: Float) {
        val bounds = Rect()
        paintText.getTextBounds(string, 0, string.length, bounds)
        val heightText: Int = bounds.height()
        val widthText: Int = bounds.width()

        canvas.drawText(string,0,value.toInt(),width/2f - widthText/2f,height/2f + heightText/2f,paintText)

        invalidate()
    }

    override fun setText(text : String, font: String, sizeText : Float) {
        animText.currentX = 0f
        animText.x2 = text.length.toFloat()
        this.string = text

        if(font != "null") {
            paintText.typeface = Typeface.createFromAsset(context.assets, font)
        }
        paintText.textSize = sizeText
        isStart = true
    }
}