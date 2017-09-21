package com.robert.chapter04.panel.drawer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import com.robert.chapter04.panel.BitmapBuffer;

/**
 * @author: robert
 * @date: 2017-09-19
 * @time: 16:25
 * @说明:
 */
public abstract class ShapeDrawer {
    private View mView;

    public ShapeDrawer(View view) {
        this.mView = view;
    }

    public View getView() {
        return mView;
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = BitmapBuffer.getInstance().getBitmap();
        canvas.drawBitmap(bitmap, 0, 0, null);
    }

    public abstract boolean onTouchEvent(MotionEvent event);

    public abstract void logic();

}
