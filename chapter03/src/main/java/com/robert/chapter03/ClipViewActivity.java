package com.robert.chapter03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class ClipViewActivity extends AppCompatActivity {

    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFrameLayout = findViewById(R.id.container);
    }

    public void ClipBom(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new ClipDogView(this));
    }

    public void ClipDog(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new ClipDogView(this));
    }
}
