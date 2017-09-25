package com.robert.chapter05.gradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author: robert
 * @date: 2017-09-25
 * @time: 10:55
 * @说明:
 */
public class RadialGradientView extends View {

    private Paint mPaint;
    private RectF mRect;

    public RadialGradientView(Context context) {
        super(context);
        init();
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRect = new RectF(100, 100, 500, 500);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        RadialGradient radialGradient = new RadialGradient(mRect.centerX(), mRect.centerY(), 200, Color.RED, Color.GREEN, Shader.TileMode.MIRROR);
        mPaint.setShader(radialGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(mRect, mPaint);
        canvas.translate(510, 0);
        canvas.drawOval(mRect, mPaint);
    }
}
