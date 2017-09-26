package com.robert.chapter05.gradient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.robert.chapter05.R;

/**
 * @author: robert
 * @date: 2017-09-22
 * @time: 14:24
 * @说明:
 */
public class GradientActivity extends AppCompatActivity {

    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradient);
        mFrameLayout = (FrameLayout) findViewById(R.id.container);

    }

    public void line(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new LineGradientView2(this));
    }

    public void radial(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new RadialGradientView(this));
    }

    public void fiveChess(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new FiveChessView(this));
    }

    public void sweep(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new SweepGradientView(this));
    }

    public void sweep1(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new SweepGradient2View(this));
    }
}
