package com.robert.chapter03.watchView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author: robert
 * @date: 2017-09-18
 * @time: 10:57
 * @说明:
 */
public class WatchView extends View {

    Paint mPaint;
    private Calendar mCalendar;
    private int mRadius;
    private Disposable mDisposable;

    public WatchView(Context context) {
        super(context);
        init();
    }

    public WatchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WatchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);
        paint.setDither(true);
        mPaint = paint;
        mCalendar = Calendar.getInstance();
        mDisposable = Observable.interval(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        invalidate();
                    }
                });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        mRadius = (width > height ? height : width) / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawCircle(canvas);
        drawPlate(canvas);//画表盘
        drawPoints(canvas);//画时针
    }

    private void drawCircle(Canvas canvas) {
        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(mRadius, mRadius, mRadius, mPaint);
    }

    private void drawPlate(Canvas canvas) {
        Paint paint = mPaint;
        int radius = mRadius;
        canvas.save();
        canvas.translate(radius, radius);
        for (int i = 0; i < 60; i++) {
            if (i % 5 == 0) {
                paint.setStrokeWidth(15);
                paint.setColor(Color.RED);
                canvas.drawLine(radius * (1 - 0.2f), 0, radius, 0, paint);
            } else {
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(10);
                canvas.drawLine(radius * (1 - 0.1f), 0, radius, 0, paint);
            }
            canvas.rotate(6);
        }
        canvas.restore();
    }

    private void drawPoints(Canvas canvas) {
        int radius = mRadius;
        float[] degree = getDegree();
        Paint paint = mPaint;

        canvas.save();
        canvas.translate(radius, radius);
        canvas.rotate(-90);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(0, 0, 18, paint);

        //画时针
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(18);
        float hourStopX = (float) (radius * 0.5 * Math.cos(Math.toRadians(degree[0])));
        float hourStopY = (float) (radius * 0.5 * Math.sin(Math.toRadians(degree[0])));
        canvas.drawLine(0, 0, hourStopX, hourStopY, paint);
        //画分针
        paint.setStrokeWidth(12);
        float minuteStopX = (float) (radius * 0.65 * Math.cos(Math.toRadians(degree[1])));
        float minuteStopY = (float) (radius * 0.65 * Math.sin(Math.toRadians(degree[1])));
        canvas.drawLine(0, 0, minuteStopX, minuteStopY, paint);
        //画秒针
        paint.setStrokeWidth(8);
        paint.setColor(Color.RED);
        float secondStopX = (float) (radius * 0.75 * Math.cos(Math.toRadians(degree[2])));
        float secondStopY = (float) (radius * 0.75 * Math.sin(Math.toRadians(degree[2])));
        canvas.drawLine(0, 0, secondStopX, secondStopY, paint);
        canvas.restore();
    }

    private float[] getDegree() {
        Calendar calendar = mCalendar;
        calendar.setTimeInMillis(System.currentTimeMillis());
        int hour = calendar.get(Calendar.HOUR) % 12;
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        float degree[] = new float[3];
        degree[0] = (hour + minute / 60f + second / 3600f) * 30f;
        degree[1] = (minute + second / 60f) * 6;
        degree[2] = second * 6;
        return degree;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }
}
