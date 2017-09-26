package com.robert.chapter05.gradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author: robert
 * @date: 2017-09-26
 * @time: 11:05
 * @说明:
 */
public class SweepView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float mRotate;
    private Matrix mMatrix = new Matrix();
    private Shader mShader;

    public SweepView(Context context) {
        super(context);
        init();
    }

    public SweepView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SweepView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        float x = 160;
        float y = 100;
        mShader = new SweepGradient(x, y, new int[]{Color.GREEN, Color.RED, Color.BLUE, Color.GREEN}, null);
        mPaint.setShader(mShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = mPaint;
        Matrix matrix = mMatrix;
        float x = 160;
        float y = 100;
        canvas.translate(300, 300);
        canvas.drawColor(Color.WHITE);
        matrix.setRotate(mRotate, x, y);
        mShader.setLocalMatrix(matrix);
        mRotate += 3;
        if (mRotate >= 360) mRotate = 0;
        invalidate();
        canvas.drawCircle(x, y, 380, paint);
    }
}
