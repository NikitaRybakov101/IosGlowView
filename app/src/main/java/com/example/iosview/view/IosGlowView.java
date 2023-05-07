package com.example.iosview.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class IosGlowView extends View implements InterfaceIosGlowView {

    @SuppressLint("ClickableViewAccessibility")
    public IosGlowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    Paint paint = new Paint();
    Paint paintStroke = new Paint();

    private float elevation = 0f;
    private float alpha = 0;

    private boolean isAnimUp = false;
    private boolean isAnimDown = false;

    private final int colorBlue = Color.rgb(89, 183, 255);
    private final int colorRed = Color.rgb(255, 60, 60);

    private int glowColor = colorBlue;
    private int glowStroke = Color.BLUE;

    private final float cornedRad = convertDpToPixels(24);
    private final float strokeWidth = 3f;
    private final float maxElevation = 40f;
    private final float speedElevation = 3f;

    private final int padding = convertDpToPixels(26);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawRect(canvas);
        drawStroke(canvas);

        animateValue();
    }

    private void animateValue() {

        float alphaSet = (255f / (maxElevation / speedElevation) - 10f);
        float elevationSet = speedElevation ;

        if(isAnimUp && elevation < maxElevation) {
            elevation += elevationSet;
            alpha += alphaSet;

            invalidate();
        }  else  {
            isAnimUp = false;
        }

        if(isAnimDown && elevation > 0) {
            elevation -= elevationSet;
            alpha -= alphaSet;

            invalidate();
        }  else  {
            isAnimDown = false;
        }
    }

    private void drawRect(Canvas canvas) {
        paint.setColor(Color.WHITE);
        paint.setShadowLayer(elevation, 0f, 0f, glowColor);

        canvas.drawRoundRect(new RectF(padding, padding,getWidth() - padding,getHeight() - padding), cornedRad,cornedRad,paint);
    }

    private void drawStroke(Canvas canvas) {
        paintStroke.setColor(glowStroke);
        paintStroke.setAntiAlias(true);
        paintStroke.setStyle(Paint.Style.STROKE);
        paintStroke.setStrokeWidth(strokeWidth);
        paintStroke.setAlpha((int) alpha);

        canvas.drawRoundRect(new RectF(padding, padding, getWidth() - padding, getHeight() - padding), cornedRad, cornedRad, paintStroke);
    }
    @Override
    public void animElevationUp() {
        isAnimDown = false;
        isAnimUp = true;
        invalidate();
    }
    @Override
    public void animElevationDown() {
        isAnimUp = false;
        isAnimDown = true;
        invalidate();
    }

    @Override
    public void setGlowColor(int glowColor,int glowStrokeColor) {
        this.glowColor = glowColor;
        this.glowStroke = glowStrokeColor;
    }

    @Override
    public void setGlowRed() {
        this.glowColor = colorRed;
        this.glowStroke = Color.RED;
    }

    @Override
    public void setGlowBlue() {
        this.glowColor = colorBlue;
        this.glowStroke = Color.BLUE;
    }

    private int convertDpToPixels(int dp) {
        return (int) (dp * this.getResources().getDisplayMetrics().density);
    }
}
