package com.robert.chapter03.clip;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.robert.chapter03.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author: robert
 * @date: 2017-09-15
 * @time: 17:14
 * @说明:
 */
public class ClipBomView extends View {
    private static final String TAG = ClipBomView.class.getSimpleName();
    private Bitmap mBitmap;
    private int mWidth;//位移的size
    private int position = 0;//当前显示的位置
    private Rect mRect;
    private Disposable mSubscribe;

    public ClipBomView(Context context) {
        super(context);
        init();
    }

    public ClipBomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClipBomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.boom);
        mWidth = mBitmap.getWidth() / 7;
        int height = mBitmap.getHeight();
        mRect = new Rect(0, 0, mWidth, height);
        mSubscribe = Observable.interval(100, 100, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        invalidate();
                    }
                });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(100, 100);
        canvas.clipRect(mRect);
        canvas.drawBitmap(mBitmap, -mWidth * position, 0, null);
        canvas.restore();
        position++;
        if (position == 7) {
            position = 0;
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!mSubscribe.isDisposed()) {
            Log.e(TAG, "onDetachedFromWindow: ");
            mSubscribe.dispose();
        }
    }
}
