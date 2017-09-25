package com.robert.chapter04.panel.drawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.robert.chapter04.panel.AttributesTool;

/**
 * @author: robert
 * @date: 2017-09-20
 * @time: 10:10
 * @说明:
 */
public class OvalDrawer extends RectDrawer{
    public OvalDrawer(View view) {
        super(view);
    }

    @Override
    public void drawShape(Canvas canvas, float firstX, float firstY, float currentX, float currentY) {
        Paint paint = AttributesTool.getInstance().getPaint();
        if (firstX < currentX && firstY < currentY) {//右下
            canvas.drawOval(firstX, firstY, currentX, currentY, paint);
        } else if (firstX < currentX && firstY > currentY) {//右上
            canvas.drawOval(firstX, currentY, currentX, firstY, paint);
        } else if (firstX > currentX && firstY < currentY) {//左下
            canvas.drawOval(currentX, firstY, firstX, currentY, paint);
        } else if (firstX > currentX && firstY > currentY) {//左上
            canvas.drawOval(currentX, currentY, firstX, firstY, paint);
        }
    }
}
