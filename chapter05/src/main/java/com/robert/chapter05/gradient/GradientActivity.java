package com.robert.chapter05.gradient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
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
    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradient);
        mFrameLayout = (FrameLayout) findViewById(R.id.container);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);

    }

    public void line(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new LineGradientView2(this));
        mDrawer.closeDrawer(Gravity.LEFT);
    }

    public void radial(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new RadialGradientView(this));
        mDrawer.closeDrawer(Gravity.LEFT);
    }

    public void fiveChess(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new FiveChessView(this));
        mDrawer.closeDrawer(Gravity.LEFT);
    }

    public void sweep(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new SweepGradientView(this));
        mDrawer.closeDrawer(Gravity.LEFT);
    }

    public void sweep1(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new SweepGradient2View(this));
        mDrawer.closeDrawer(Gravity.LEFT);
    }

    public void bitmap(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new BitmapGradientView(this));
        mDrawer.closeDrawer(Gravity.LEFT);
    }

    public void compose(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new ComposeShaderView(this));
        mDrawer.closeDrawer(Gravity.LEFT);
    }

    public void sweep2(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new SweepView(this));
        mDrawer.closeDrawer(Gravity.LEFT);
    }

    public void porterDuffer(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new PorterDufferView(this));
        mDrawer.closeDrawer(Gravity.LEFT);
    }
}
