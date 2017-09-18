package com.robert.chapter03;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.robert.chapter03.clip.ClipViewActivity;
import com.robert.chapter03.watchView.WatchViewActivity;

/**
 * @author: robert
 * @date: 2017-09-18
 * @time: 10:25
 * @说明:
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clipView(View view) {
        startActivity(new Intent(this, ClipViewActivity.class));
    }

    public void watchView(View view) {
        startActivity(new Intent(this, WatchViewActivity.class));
    }
}
