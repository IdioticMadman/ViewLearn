package com.robert.chapter04.panel.drawer;

import android.graphics.Canvas;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import com.robert.chapter04.panel.AttributesTool;
import com.robert.chapter04.panel.BitmapBuffer;

/**
 * @author: robert
 * @date: 2017-09-20
 * @time: 10:32
 * @说明:
 */
public class LineDrawer extends ShapeDrawer {
    private Path mPath;

    public LineDrawer(View view) {
        super(view);
        mPath = new Path();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawPath(mPath, AttributesTool.getInstance().getPaint());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                mPath.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(x, y);
                getView().invalidate();
                break;
            case MotionEvent.ACTION_UP:
                BitmapBuffer.getInstance().getCanvas().drawPath(mPath, AttributesTool.getInstance().getPaint());
                BitmapBuffer.getInstance().pushBitmap();
                break;
        }
        return true;
    }

    @Override
    public void logic() {

    }
}
