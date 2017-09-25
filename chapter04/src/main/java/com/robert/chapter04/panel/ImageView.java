package com.robert.chapter04.panel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.robert.chapter04.panel.drawer.LineDrawer;
import com.robert.chapter04.panel.drawer.OvalDrawer;
import com.robert.chapter04.panel.drawer.RectDrawer;
import com.robert.chapter04.panel.drawer.ShapeDrawer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: robert
 * @date: 2017-09-20
 * @time: 10:28
 * @说明:
 */
public class ImageView extends View {
    private ShapeDrawer mShapeDrawer;
    private LineDrawer mLineDrawer;
    private RectDrawer mRectDrawer;
    private OvalDrawer mOvalDrawer;

    public void save() {
        Bitmap bitmap = BitmapBuffer.getInstance().getBitmap();
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), System.currentTimeMillis() + ".png");
            fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            getContext().sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public enum DrawerType {
        LINE_DRAWER(0),
        RECT_DRAWER(1),
        OVAL_DRAWER(2),;
        private int type;

        DrawerType(int i) {
            type = i;
        }

        public int getType() {
            return type;
        }
    }

    public void setShapeDrawer(DrawerType drawerType) {
        switch (drawerType) {
            case LINE_DRAWER:
                mShapeDrawer = mLineDrawer;
                break;
            case OVAL_DRAWER:
                mShapeDrawer = mOvalDrawer;
                break;
            case RECT_DRAWER:
                mShapeDrawer = mRectDrawer;
                break;
        }

    }

    public ImageView(Context context) {
        super(context);
        init();
    }

    public ImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mLineDrawer = new LineDrawer(this);
        mRectDrawer = new RectDrawer(this);
        mOvalDrawer = new OvalDrawer(this);
        mShapeDrawer = mLineDrawer;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (SystemParams.isReset) {
            canvas.drawBitmap(BitmapBuffer.getInstance().getBitmap(), 0, 0, null);
            SystemParams.isReset = false;
            return;
        }
        if (SystemParams.isRedo) {
            canvas.drawBitmap(BitmapBuffer.getInstance().getBitmap(), 0, 0, null);
            SystemParams.isRedo = false;
        } else {
            mShapeDrawer.draw(canvas);
        }
        mShapeDrawer.logic();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mShapeDrawer.onTouchEvent(event);
    }

    public void clear() {
        BitmapHistory.reset();
        BitmapBuffer.getInstance().reset();
        SystemParams.isReset = true;
        invalidate();
    }

    public void reDo() {
        BitmapBuffer.getInstance().reDo();
        SystemParams.isRedo = true;
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        SystemParams.areaHeight = getMeasuredHeight();
        SystemParams.areaWidth = getMeasuredWidth();
    }

}

