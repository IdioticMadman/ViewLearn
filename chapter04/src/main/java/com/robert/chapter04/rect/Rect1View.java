package com.robert.chapter04.rect;

import android.content.Context;
import android.graphics.Bitmap;
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
 * @time: 11:56
 * @说明:
 */
public class Rect1View extends View {
    private static final String TAG = Rect1View.class.getSimpleName();
    private int firstX, firstY;
    private Path mPath;
    private Paint mPaint;
    private Bitmap bitmapBuffer;
    private Canvas bitmapCanvas;

    public Rect1View(Context context) {
        super(context);
        init();
    }

    public Rect1View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Rect1View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        canvas.drawBitmap(bitmapBuffer, 0, 0, null);
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (bitmapBuffer == null) {
            int height = getMeasuredHeight();
            int width = getMeasuredWidth();
            bitmapBuffer = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmapCanvas = new Canvas(bitmapBuffer);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                firstX = x;
                firstY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.reset();
                int l, t, r, b;
                if (x > firstX) {
                    l = firstX;
                    r = x;
                } else {
                    l = x;
                    r = firstX;
                }
                if (y > firstY) {
                    t = firstY;
                    b = y;
                } else {
                    t = y;
                    b = firstY;
                }
                mPath.addRect(l, t, r, b, Path.Direction.CCW);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                bitmapCanvas.drawPath(mPath, mPaint);
                invalidate();
                break;
            default:
                break;
        }
        return true;
    }
}
