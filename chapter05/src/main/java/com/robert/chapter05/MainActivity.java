package com.robert.chapter05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.robert.chapter05.gradient.GradientActivity;
import com.robert.chapter05.pratice.PracticeActivity;
import com.robert.chapter05.shader.ShaderActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void shaderView(View view) {
        startActivity(new Intent(this, ShaderActivity.class));
    }

    public void gradientView(View view) {
        startActivity(new Intent(this, GradientActivity.class));
    }

    public void practice(View view) {
        startActivity(new Intent(this, PracticeActivity.class));
    }
}
