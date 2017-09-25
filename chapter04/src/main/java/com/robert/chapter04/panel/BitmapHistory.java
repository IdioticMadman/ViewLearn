package com.robert.chapter04.panel;

import android.graphics.Bitmap;

import java.util.Stack;

/**
 * @author: robert
 * @date: 2017-09-19
 * @time: 15:47
 * @说明:
 */
public class BitmapHistory {

    private static Stack<Bitmap> sBitmapStack;
    private static BitmapHistory INSTANCE;

    private BitmapHistory() {
        if (sBitmapStack == null) {
            sBitmapStack = new Stack<>();
        }
    }

    public synchronized static BitmapHistory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BitmapHistory();
        }
        return INSTANCE;
    }

    public static void reset() {
        while (!sBitmapStack.empty()) {
            Bitmap bmp = sBitmapStack.pop();
            if (bmp != null && !bmp.isRecycled()) {
                bmp.recycle();
                bmp = null;
            }
        }
    }

    public void pushBitmap(Bitmap bitmap) {
        int count = sBitmapStack.size();
        if (count >= 5) {
            Bitmap bmp = sBitmapStack.remove(0);
            if (!bmp.isRecycled()) {
                bmp.recycle();
                bmp = null;
            }
        }
        sBitmapStack.push(bitmap);
    }

    public Bitmap reDo() {
        if (sBitmapStack.empty()) return null;
        Bitmap bmp = sBitmapStack.pop();
        if (bmp != null && !bmp.isRecycled()) {
            bmp.recycle();
            bmp = null;
        }
        if (sBitmapStack.empty()) return null;
        return sBitmapStack.peek();
    }

    public boolean isReDo() {
        return !sBitmapStack.empty();
    }
}
