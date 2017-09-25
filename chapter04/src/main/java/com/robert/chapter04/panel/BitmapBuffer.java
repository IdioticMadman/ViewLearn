package com.robert.chapter04.panel;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * @author: robert
 * @date: 2017-09-19
 * @time: 15:41
 * @说明:
 */
public class BitmapBuffer {

    private Bitmap mBitmap;
    private Canvas mCanvas;
    private static BitmapBuffer INSTANCE;

    private BitmapBuffer(int width, int height) {
        init(width, height);
    }

    private void init(int width, int height) {
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas();
        mCanvas.setBitmap(mBitmap);
    }

    public synchronized static BitmapBuffer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BitmapBuffer(SystemParams.areaWidth, SystemParams.areaHeight);
        }
        return INSTANCE;
    }

    public void reset() {
        if (mBitmap != null && !mBitmap.isRecycled()) {
            mBitmap.recycle();
            mBitmap = null;
        }
        mCanvas = null;
        init(SystemParams.areaWidth, SystemParams.areaHeight);
    }

    public Canvas getCanvas() {
        return mCanvas;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public void pushBitmap() {
        BitmapHistory.getInstance().pushBitmap(mBitmap.copy(Bitmap.Config.ARGB_8888, false));
    }

    public void reDo() {
        BitmapHistory history = BitmapHistory.getInstance();
        if (history.isReDo()) {
            Bitmap bmp = history.reDo();
            if (bmp != null) {
                mBitmap = bmp.copy(Bitmap.Config.ARGB_8888, true);
                mCanvas.setBitmap(mBitmap);
                if (!bmp.isRecycled()) {
                    bmp.recycle();
                    bmp = null;
                }
            }
        }
    }
}
