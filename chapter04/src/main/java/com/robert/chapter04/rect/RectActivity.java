package com.robert.chapter04.rect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.robert.chapter04.R;

public class RectActivity extends AppCompatActivity {

    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rect);
        mFrameLayout = (FrameLayout) findViewById(R.id.container);
    }

    public void rect1(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new Rect1View(this));
    }
}
