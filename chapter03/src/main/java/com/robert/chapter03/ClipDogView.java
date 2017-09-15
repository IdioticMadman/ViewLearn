package com.robert.chapter03;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author: robert
 * @date: 2017-09-15
 * @time: 11:39
 * @说明:
 */
public class ClipDogView extends View {

    private Bitmap mDogBmp;
    private Rect mDogRect;

    public ClipDogView(Context context) {
        super(context);
        init();
    }

    public ClipDogView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClipDogView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mDogBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
        mDogRect = new Rect(100, 100, 500, 500);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mDogBmp, 0, 0, null);
        canvas.translate(0, 500);
        canvas.clipRect(mDogRect);
        canvas.drawBitmap(mDogBmp, 0, 0, null);
    }
}
