package com.robert.chapter05.gradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by robert on 2017/9/25.
 */

public class SweepGradientView extends View {

    private Paint mPaint;

    public SweepGradientView(Context context) {
        super(context);
        init();
    }

    public SweepGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SweepGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        SweepGradient sg = new SweepGradient(200, 200, Color.RED, Color.GREEN);
        mPaint.setShader(sg);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(50, 50);
        canvas.drawCircle(200, 200, 200, mPaint);
    }
}
