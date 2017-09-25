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
        mFrameLayout.addView(new GradientView2(this));
    }
}
