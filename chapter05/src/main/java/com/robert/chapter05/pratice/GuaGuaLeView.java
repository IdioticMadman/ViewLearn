package com.robert.chapter05.pratice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.robert.chapter05.R;

import java.util.Random;

/**
 * @author: robert
 * @date: 2017-09-28
 * @time: 17:28
 * @说明:
 */
public class GuaGuaLeView extends View {
    private Random rnd;
    private Paint mPaint;
    private Paint mClearPaint;
    private static final String[] PRIZE = new String[]{
            "恭喜，您中了一等奖，奖金一亿元",
            "恭喜，您中了二等奖，奖金 5000 万元",
            "恭喜，您中了三等奖，奖金 100 元",
            "很遗憾，您没有中奖，继续加油哦"
    };

    public static final int FINGER = 50;


    public GuaGuaLeView(Context context) {
        super(context);
        init();
    }

    public GuaGuaLeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GuaGuaLeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        initBackground();
    }

    private void initBackground() {
        Bitmap bgBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.konglong);
        Bitmap bmp = bgBmp.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bmp);
        String text = PRIZE[rnd.nextInt(PRIZE.length)];

    }
}
