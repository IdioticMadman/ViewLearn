package com.robert.chapter05.gradient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.robert.chapter05.R;

import java.util.Arrays;
import java.util.List;

/**
 * @author: robert
 * @date: 2017-09-22
 * @time: 14:24
 * @说明:
 */
public class GradientActivity extends AppCompatActivity {

//    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradient);
//        mFrameLayout = (FrameLayout) findViewById(R.id.container);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final List<Entity> data = Arrays.asList(
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(1)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(2)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(1)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(2)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(1)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(2)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(1)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(2)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(1)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(2)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(1)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(2)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(1)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(2)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(1)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(2)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(1)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(2)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(1)"),
                new Entity("啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦", "(2)"));

        recyclerView.setAdapter(new RecyclerView.Adapter<ViewHolder>() {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                holder.mTextView.setText(data.get(position).number);
                holder.mTvContent.setText(data.get(position).title);
            }

            @Override
            public int getItemCount() {
                return data.size();
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {


        TextView mTvContent;
        TextView mTextView;

        ViewHolder(View itemView) {
            super(itemView);
            mTvContent = (TextView) itemView.findViewById(R.id.tv_content);
            mTextView = (TextView) itemView.findViewById(R.id.tv_number);
        }
    }

    static class Entity {
        String title;
        String number;

        Entity(String title, String number) {
            this.title = title;
            this.number = number;
        }
    }
/*
    public void line(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new LineGradientView2(this));
    }

    public void radial(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new RadialGradientView(this));
    }

    public void fiveChess(View view) {
        mFrameLayout.removeAllViews();
        mFrameLayout.addView(new FiveChessView(this));
    }*/
}
