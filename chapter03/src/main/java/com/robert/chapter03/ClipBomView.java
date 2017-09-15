package com.robert.chapter03;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author: robert
 * @date: 2017-09-15
 * @time: 17:14
 * @说明:
 */
public class ClipBomView extends View {
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
        BitmapFactory.decodeResource(getResources(), R.mipmap.boom);
    }

    @Override
    protected void onDraw(Canvas canvas) {

    }
}
