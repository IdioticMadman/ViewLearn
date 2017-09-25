package com.robert.chapter05.shader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author: robert
 * @date: 2017-09-21
 * @time: 18:52
 * @说明:
 */
public class ShaderView extends View {

    private Paint mPaint;

    public ShaderView(Context context) {
        super(context);
        init();
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setTextSize(100);
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, mPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setShadowLayer(10, 1, 1, Color.RED);
        canvas.drawText("Android开发", 100, 100, mPaint);
        mPaint.setShadowLayer(10, 5, 5, Color.BLUE);
        canvas.drawText("Android绘图技术", 100, 200, mPaint);
    }
}
