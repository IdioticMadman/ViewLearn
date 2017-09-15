package com.robert.viewlearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.robert.viewlearn.graphics2d.Graphics2DActivity;
import com.robert.viewlearn.graphicsmove.CanvasActivity;
import com.robert.viewlearn.utils.UIUtils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] screenSize = UIUtils.getScreenSize(this);
        int statusBarHeight = UIUtils.getStatusBarHeight(this);
        Log.e(TAG, "onCreate: " + statusBarHeight + " : " + screenSize[0] + " : " + screenSize[1]);
//        paint();

//        canvas();

//        drawPoint();

//        drawLine();

//        drawRect();

//        drawArc();

//        drawPath();

//        drawBezier();

//        drawPathOp();

//        drawText();'
    }

    public void canvas2d(View view) {
        startActivity(new Intent(this, Graphics2DActivity.class));
    }

    public void canvas(View view) {
        startActivity(new Intent(this, CanvasActivity.class));
    }

//
//    private void drawCircle() {
//
//        Paint paint = new Paint();
//        paint.setColor(Color.parseColor(UIUtils.getRandomColorStr()));
//
//    }
}
