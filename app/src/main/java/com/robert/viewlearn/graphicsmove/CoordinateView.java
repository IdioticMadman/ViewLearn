package com.robert.viewlearn.graphicsmove;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author: robert
 * @date: 2017-09-14
 * @time: 16:10
 * @说明:
 */
public class CoordinateView extends View {
    private Paint mPaint;

    public CoordinateView(Context context) {
        super(context);
        init();
    }

    public CoordinateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CoordinateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStrokeWidth(10);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        mPaint = paint;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        for (int i = 0; i < 10; i++) {
            canvas.drawRect(0, 0, 150, 150, mPaint);
            canvas.translate(30, 30);
        }
        canvas.restore();

        canvas.translate(0, 500);
        canvas.save();
        for (int i = 0; i < 10; i++) {
            canvas.drawRect(0, 0, 400, 400, mPaint);
            canvas.scale(0.9f, 0.9f, 200, 200);
        }
        canvas.restore();

        canvas.translate(0, 500);
        canvas.save();
        canvas.drawCircle(200, 200, 200, mPaint);
        for (int i = 0; i < 12; i++) {
            canvas.drawLine(200, 200, 400, 200, mPaint);
            canvas.rotate(30, 200, 200);
        }
        canvas.restore();
    }
}
