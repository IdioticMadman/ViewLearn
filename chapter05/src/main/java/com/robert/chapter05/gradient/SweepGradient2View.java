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
 * Created by robert on 2017/9/26.
 */

public class SweepGradient2View extends View {

    private Paint mPaint;

    public SweepGradient2View(Context context) {
        super(context);
        init();
    }

    public SweepGradient2View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SweepGradient2View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //起始和终点的值是同一种颜色会比较好看
        SweepGradient sg = new SweepGradient(500, 500,
                new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.RED}, null);
        mPaint.setShader(sg);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(80, 80);
        canvas.drawCircle(500, 500, 400, mPaint);
    }
}
