package com.robert.chapter05.gradient;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author: robert
 * @date: 2017-09-26
 * @time: 13:47
 * @说明:
 */
public class PorterDufferView extends View {

    private Bitmap mB3;

    public PorterDufferView(Context context) {
        super(context);
        init();
    }

    public PorterDufferView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PorterDufferView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Bitmap dst = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
        Bitmap src = dst.copy(Bitmap.Config.ARGB_8888, true);
        mB3 = Bitmap.createBitmap(450, 450, Bitmap.Config.ARGB_8888);

        Canvas canvasDst = new Canvas(dst);
        Canvas canvasSrc = new Canvas(src);
        Canvas canvasB3 = new Canvas(mB3);

        Paint p1 = new Paint();
        p1.setColor(Color.GRAY);
        canvasDst.drawCircle(150, 150, 150, p1);

        Paint p2 = new Paint();
        p2.setColor(Color.GREEN);
        canvasSrc.drawRect(0, 0, 300, 300, p2);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        canvasB3.saveLayer(150, 150, 450, 450, null, Canvas.ALL_SAVE_FLAG);
        canvasB3.drawBitmap(dst, 0, 0, null);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        canvasB3.drawBitmap(src, 150, 150, paint);
        paint.setXfermode(null);
        canvasB3.restore();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mB3, 0, 0, null);
    }
}
