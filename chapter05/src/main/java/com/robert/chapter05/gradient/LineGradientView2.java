package com.robert.chapter05.gradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author: robert
 * @date: 2017-09-22
 * @time: 16:19
 * @说明:
 */
public class LineGradientView2 extends View {
    private Paint clampPaint;
    private Paint repeatPaint;
    private Paint mirrorPaint;

    public LineGradientView2(Context context) {
        super(context);
        init();
    }

    public LineGradientView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LineGradientView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        clampPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        clampPaint.setStyle(Paint.Style.FILL);
        LinearGradient lgClamp = new LinearGradient(0, 0, 400, 0,
                new int[]{Color.RED, Color.GREEN, Color.BLUE}, new float[]{0f, 0.5f, 1f}, Shader.TileMode.CLAMP);
        clampPaint.setShader(lgClamp);

        mirrorPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mirrorPaint.setStyle(Paint.Style.FILL);
        LinearGradient lgMirror = new LinearGradient(0, 0, 400, 0,
                new int[]{Color.RED, Color.GREEN, Color.BLUE}, new float[]{0.1f, 0.33f, 1f}, Shader.TileMode.CLAMP);
        mirrorPaint.setShader(lgMirror);

        repeatPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        repeatPaint.setStyle(Paint.Style.FILL);
        LinearGradient lgRepeat = new LinearGradient(0, 0, 400, 0,
                new int[]{Color.RED, Color.GREEN, Color.BLUE}, new float[]{0.33f, 0.8f, 0f}, Shader.TileMode.CLAMP);
        repeatPaint.setShader(lgRepeat);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0, 0, 400, 300, clampPaint);
        canvas.translate(0, 320);
        canvas.drawRect(0, 0, 400, 300, mirrorPaint);
        canvas.translate(0, 320);
        canvas.drawRect(0, 0, 400, 300, repeatPaint);
    }
}
