package com.robert.viewlearn.graphics2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.robert.viewlearn.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: robert
 * @date: 2017-09-12
 * @time: 20:31
 * @说明:
 */
public class ManyCircleView extends View {
    private static final String TAG = ManyCircleView.class.getSimpleName();
    Paint mPaint;
    private int centerX = 100;
    private int centerY = 100;
    private int mWidth;
    private int mHeight;
    private int mRadius = 100;
    private int lineX = 1;
    private int lineY = 1;
    private List<CirclePoint> mCirclePoints;
    private Disposable mDisposable;

    public ManyCircleView(Context context) {
        super(context);
        init();
    }

    public ManyCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ManyCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor(UIUtils.getRandomColorStr()));
        mPaint = paint;
        mDisposable = Observable.interval(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (setCenterPoint()) {
                            postInvalidate();
                        }else {
                            mDisposable.dispose();
                        }
                    }
                });
        mCirclePoints = new ArrayList<>();
        mCirclePoints.add(new CirclePoint(100, 100, Color.parseColor(UIUtils.getRandomColorStr())));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (CirclePoint circlePoint : mCirclePoints) {
            mPaint.setColor(circlePoint.color);
            canvas.drawCircle(circlePoint.x, circlePoint.y, mRadius, mPaint);
        }
    }

    private boolean setCenterPoint() {
        lineX++;
        int nextCenterX = (2 * lineX - 1) * mRadius;
        int nextCenterY = centerY;
        if (nextCenterX > mWidth) {
            lineY++;
            nextCenterX = 100;
            nextCenterY = (2 * lineY - 1) * mRadius;
            lineX = 1;
        }
        if (nextCenterY >= mHeight) {
            return false;
        }
        int color = Color.parseColor(UIUtils.getRandomColorStr());
        centerX = nextCenterX;
        centerY = nextCenterY;
        mCirclePoints.add(new CirclePoint(nextCenterX, nextCenterY, color));
        Log.e(TAG, "setCenterPoint: CenterX: " + nextCenterX + " ,CenterY: " + nextCenterY);
        return true;
    }

    static class CirclePoint {
        int x;
        int y;
        int color;

        CirclePoint(int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}

