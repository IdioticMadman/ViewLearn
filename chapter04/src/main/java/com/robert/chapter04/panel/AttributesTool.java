package com.robert.chapter04.panel;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * @author: robert
 * @date: 2017-09-19
 * @time: 15:34
 * @说明:
 */
public class AttributesTool {
    private int color;
    private int borderWidth;
    private boolean fill;
    private static AttributesTool INSTANCE;
    private static Paint sPaint;

    private AttributesTool() {
        reset();
    }

    public synchronized static AttributesTool getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AttributesTool();
        }
        return INSTANCE;
    }

    public Paint getPaint() {
        if (sPaint == null) {
            sPaint = new Paint();
        }
        sPaint.setAntiAlias(true);
        sPaint.setColor(this.color);
        sPaint.setStrokeWidth(this.borderWidth);
        sPaint.setStyle(this.fill ? Paint.Style.FILL : Paint.Style.STROKE);
        sPaint.setTextSize(30);
        return sPaint;
    }

    private void reset() {
        this.color = Color.BLACK;
        this.borderWidth = 1;
        this.fill = false;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }
}
