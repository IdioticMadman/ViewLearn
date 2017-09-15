package com.robert.viewlearn.graphics2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

/**
 * @author: robert
 * @date: 2017-09-13
 * @time: 11:29
 * @说明:
 */
public class VerificationView extends View {
    private static final String TAG = VerificationView.class.getSimpleName();
    private Paint mPaint;
    private RectF mRect;
    private TextPaint mTextPaint;
    private String mRandomCode;
    private Random mRandom;
    int[] a = new int[]{1, 2, 3};
    int[] b = new int[]{0, 2, 3};
    int[] c = new int[]{0, 1, 3};
    int[] d = new int[]{0, 1, 2};

    public VerificationView(Context context) {
        super(context);
        init();
    }

    public VerificationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VerificationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);
        mPaint = paint;

        TextPaint textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(70);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setColor(Color.RED);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textPaint.setLetterSpacing(0.5f);
        }
        mRandom = new Random();
        mRandomCode = getRandomCode();
        float measureText = textPaint.measureText(mRandomCode);
        mRect = new RectF(0, 0, measureText * (1 + 0.5f), 150);
        mTextPaint = textPaint;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(250, 200);
        RectF rect = mRect;
        Paint paint = mPaint;
        paint.setColor(Color.GRAY);
        for (int i = 0; i < 100; i++) {
            Point[] points = getPoints(i);
            canvas.drawLine(points[0].x, points[0].y, points[1].x, points[1].y, paint);
        }
        paint.setColor(Color.BLACK);
        //画矩形
        canvas.drawRect(rect, paint);
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float v = (fontMetrics.top + fontMetrics.bottom) / 2;
        //画四位数字
        canvas.drawText(mRandomCode, rect.centerX(), rect.centerY() - v, mTextPaint);
        //画干扰线

        canvas.restore();
    }

    private Point[] getPoints(int i) {
        Point[] points = new Point[2];
        int index = i % 4;
        points[0] = getPoint(index);
        points[1] = getPoint(getRandomOther(index));
        return points;
    }

    private int getRandomOther(int index) {
        int i = mRandom.nextInt(2);
        switch (index) {
            case 0:
                return a[i];
            case 1:
                return b[i];
            case 2:
                return c[i];
            case 3:
                return d[i];
        }
        return -1;
    }

    private Point getPoint(int index) {
        Point point = new Point();
        Random random = mRandom;
        switch (index) {
            case 0:
                point.x = mRandom.nextInt((int) mRect.right);
                point.y = 0;
                break;
            case 1:
                point.x = (int) mRect.right;
                point.y = random.nextInt((int) mRect.bottom);
                break;
            case 2:
                point.x = mRandom.nextInt((int) mRect.right);
                point.y = (int) mRect.bottom;
                break;
            case 3:
                point.x = 0;
                point.y = random.nextInt((int) mRect.bottom);
                break;
        }
        return point;
    }


    private String getRandomCode() {

        int result = (int) (mRandom.nextInt(9000) + 1000);
        Log.e(TAG, "getRandomCode: ");
        return result + "";
    }
}
