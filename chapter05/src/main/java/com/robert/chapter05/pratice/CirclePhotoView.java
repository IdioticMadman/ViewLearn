package com.robert.chapter05.pratice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.robert.chapter05.R;

/**
 * Created by robert on 2017/9/26.
 */

public class CirclePhotoView extends View {

    private Paint mPaint;
    private int mRadius;
    private Bitmap dstBmp;
    private PorterDuffXfermode mMode;
    private Bitmap srcBmp;

    public CirclePhotoView(Context context) {
        super(context);
        init();
    }

    public CirclePhotoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CirclePhotoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        dstBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.cat);
        mRadius = Math.min(dstBmp.getWidth(), dstBmp.getHeight()) / 2;
        srcBmp = Bitmap.createBitmap(mRadius * 2, mRadius * 2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(srcBmp);
        canvas.drawCircle(mRadius, mRadius, mRadius, mPaint);
        mMode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(getMeasuredWidth() / 2 - mRadius, getMeasuredHeight() / 3 - mRadius);
        int layer = canvas.saveLayer(0, 0, mRadius * 2, mRadius * 2, mPaint);
//        canvas.drawBitmap(srcBmp, 0, 0, null);
        canvas.drawBitmap(dstBmp, 0, 0, null);
        mPaint.setXfermode(mMode);
        canvas.drawBitmap(srcBmp, 0, 0, mPaint);
//        canvas.drawBitmap(dstBmp, 0, 0, mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(layer);
    }
}
