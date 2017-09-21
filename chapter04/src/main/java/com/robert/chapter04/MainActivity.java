package com.robert.chapter04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.robert.chapter04.line.LineActivity;
import com.robert.chapter04.panel.PanelActivity;
import com.robert.chapter04.rect.RectActivity;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void drawLine(View view) {
        startActivity(new Intent(this, LineActivity.class));
    }

    public void drawRect(View view) {
        startActivity(new Intent(this, RectActivity.class));
    }

    public void drawPanel(View view) {
        startActivity(new Intent(this, PanelActivity.class));
    }
}
