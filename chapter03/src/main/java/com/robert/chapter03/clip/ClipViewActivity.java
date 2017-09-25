package com.robert.chapter03.clip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.robert.chapter03.R;

public class ClipViewActivity extends AppCompatActivity {

    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_clip_view);
        mFrameLayout = (FrameLayout) findViewById(R.id.container);
    }

    public void ClipBom(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new ClipBomView(this));
    }

    public void ClipDog(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new ClipDogView(this));
    }
}
