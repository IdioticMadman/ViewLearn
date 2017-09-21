package com.robert.chapter04.panel.drawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.robert.chapter04.panel.AttributesTool;
import com.robert.chapter04.panel.BitmapBuffer;

/**
 * @author: robert
 * @date: 2017-09-19
 * @time: 16:40
 * @说明:
 */
public class RectDrawer extends ShapeDrawer {

    private float firstX;
    private float firstY;
    private float currentX;
    private float currentY;

    public RectDrawer(View view) {
        super(view);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawShape(canvas, firstX, firstY, currentX, currentY);
    }

    protected void drawShape(Canvas canvas, float firstX, float firstY, float currentX, float currentY) {
        Paint paint = AttributesTool.getInstance().getPaint();
        if (firstX < currentX && firstY < currentY) {//右下
            canvas.drawRect(firstX, firstY, currentX, currentY, paint);
        } else if (firstX < currentX && firstY > currentY) {//右上
            canvas.drawRect(firstX, currentY, currentX, firstY, paint);
        } else if (firstX > currentX && firstY < currentY) {//左下
            canvas.drawRect(currentX, firstY, firstX, currentY, paint);
        } else if (firstX > currentX && firstY > currentY) {//左上
            canvas.drawRect(currentX, currentY, firstX, firstY, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstX = x;
                firstY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                currentX = x;
                currentY = y;
                getView().invalidate();
                break;
            case MotionEvent.ACTION_UP:
                Canvas canvas = BitmapBuffer.getInstance().getCanvas();
                drawShape(canvas, firstX, firstY, currentX, currentY);
                BitmapBuffer.getInstance().pushBitmap();
                break;
        }
        return true;
    }

    @Override
    public void logic() {

    }
}
