package com.robert.chapter04.line;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author: robert
 * @date: 2017-09-18
 * @time: 18:42
 * @说明:
 */
public class LineView extends View {
    private int preX, preY;
    private int currentX, currentY;
    private Bitmap bitmapBuffer;
    private Canvas bitmapCanvas;
    private Paint paint;

    public LineView(Context context) {
        super(context);
        init();
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        this.paint = paint;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (bitmapBuffer == null) {
            int width = getMeasuredWidth();
            int height = getMeasuredHeight();
            bitmapBuffer = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmapCanvas = new Canvas(bitmapBuffer);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmapBuffer, 0, 0, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                currentX = x;
                currentY = y;
                bitmapCanvas.drawLine(preX, preY, currentX, currentY, paint);
                this.invalidate();

                preX = currentX;
                preY = currentY;
                break;
            case MotionEvent.ACTION_UP:
                invalidate();
                break;
        }
        return true;
    }
}
