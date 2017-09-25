package com.robert.chapter04.line;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author: robert
 * @date: 2017-09-19
 * @time: 10:29
 * @说明:
 */
public class LineView1 extends View {

    private Path mPath;
    private int preX, preY;
    private Paint mPaint;

    public LineView1(Context context) {
        super(context);
        init();
    }

    public LineView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LineView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        mPaint = paint;
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                preX = x;
                preY = y;
                mPath.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.quadTo(preX, preY, x, y);
                invalidate();
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return true;
    }
}
