package com.robert.chapter04.line;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.robert.chapter04.R;

public class LineActivity extends AppCompatActivity {

    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        mFrameLayout = findViewById(R.id.container);
    }

    public void line(View view) {
        mFrameLayout.removeAllViews();
        LineView lineView = new LineView(this);
        lineView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        mFrameLayout.addView(lineView);
    }

    public void line1(View view) {
        mFrameLayout.removeAllViews();
        LineView1 lineView = new LineView1(this);
        lineView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        mFrameLayout.addView(lineView);
    }

    public void line2(View view) {
        mFrameLayout.removeAllViews();
        LineView2 lineView = new LineView2(this);
        lineView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        mFrameLayout.addView(lineView);
    }
}
