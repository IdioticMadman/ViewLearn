package com.robert.chapter04.panel;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

import com.robert.chapter04.R;

public class PanelActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);
        mImageView = (ImageView) findViewById(R.id.iv);
//        mImageView.setShapeDrawer(new LineDrawer(mImageView));

        findViewById(R.id.btn_blue).setOnClickListener(this);
        findViewById(R.id.btn_red).setOnClickListener(this);
        findViewById(R.id.btn_green).setOnClickListener(this);
        SeekBar seekBar = (SeekBar) findViewById(R.id.sb_progress);
        seekBar.setMax(60);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                AttributesTool.getInstance().setBorderWidth(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_red:
                AttributesTool.getInstance().setColor(Color.RED);
                break;
            case R.id.btn_green:
                AttributesTool.getInstance().setColor(Color.GREEN);
                break;
            case R.id.btn_blue:
                AttributesTool.getInstance().setColor(Color.BLUE);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.panel_operate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clear:
                mImageView.clear();
                break;
            case R.id.cancel:
                mImageView.reDo();
                break;
            case R.id.line:
                mImageView.setShapeDrawer(ImageView.DrawerType.LINE_DRAWER);
                break;
            case R.id.rect:
                mImageView.setShapeDrawer(ImageView.DrawerType.RECT_DRAWER);
                break;
            case R.id.oval:
                mImageView.setShapeDrawer(ImageView.DrawerType.OVAL_DRAWER);
                break;
        }
        return true;
    }

}
