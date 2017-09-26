package com.robert.chapter05.gradient;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.robert.chapter05.R;

/**
 * @author: robert
 * @date: 2017-09-26
 * @time: 10:24
 * @说明:
 */
public class ComposeShaderView extends View {
    private static final String TAG = ComposeShaderView.class.getSimpleName();
    private Rect mRect;
    private Paint mPaint;

    public ComposeShaderView(Context context) {
        super(context);
        init();
    }

    public ComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(mRect, mPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e(TAG, "onSizeChanged: ");
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round);
        BitmapShader bs = new BitmapShader(bmp, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR);
        LinearGradient linearGradient = new LinearGradient(0, 0, getMeasuredWidth(), 0, Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
        ComposeShader cs = new ComposeShader(bs, linearGradient, PorterDuff.Mode.MULTIPLY);
        mPaint.setShader(cs);
        mRect = new Rect(0, 0, getMeasuredWidth(), 600);
    }
}
