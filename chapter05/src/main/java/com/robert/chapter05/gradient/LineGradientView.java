package com.robert.chapter05.gradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author: robert
 * @date: 2017-09-22
 * @time: 10:28
 * @说明:
 */
public class LineGradientView extends View {

    private static final int OFFSET = 120;
    Paint mPaint;

    public LineGradientView(Context context) {
        super(context);
        init();
    }

    public LineGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LineGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        mPaint = paint;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect1 = new Rect(100, 100, 500, 400);
        LinearGradient lg = new LinearGradient(
                rect1.left, rect1.top, rect1.right, rect1.bottom,
                Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
        mPaint.setShader(lg);
        canvas.drawRect(rect1, mPaint);
        //坐标往下移动
        canvas.translate(0, rect1.height() + OFFSET);
        //放大渐变矩形
        Rect rect2 = new Rect(rect1);
        rect2.inset(-100, -100);
        lg = new LinearGradient(
                rect2.left, rect2.top, rect2.right, rect2.bottom,
                Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
        mPaint.setShader(lg);
        canvas.drawRect(rect1, mPaint);
        //坐标往下移动
        canvas.translate(0, rect1.height() + OFFSET);
        //缩小渐变矩形
        Rect rect3 = new Rect(rect1);
        rect3.inset(100, 100);
        lg = new LinearGradient(
                rect3.left, rect3.top, rect3.right, rect3.bottom,
                Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
        mPaint.setShader(lg);
        canvas.drawRect(rect1, mPaint);

    }
}
