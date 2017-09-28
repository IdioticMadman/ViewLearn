package com.robert.chapter05.pratice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.robert.chapter05.R;

/**
 * Created by robert on 2017/9/26.
 */

public class PracticeActivity extends AppCompatActivity {

    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        mFrameLayout = (FrameLayout) findViewById(R.id.fl_container);
    }

    public void circleView(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new CirclePhotoView(this));
    }
}
