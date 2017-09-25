package com.robert.chapter05.gradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author: robert
 * @date: 2017-09-25
 * @time: 11:03
 * @说明:
 */
public class FiveChessView extends View {

    private static final int SIZE = 120;
    private static final int OFFSET = 10;
    private int mHeight;
    private int mWidth;
    private Paint mPaint;

    enum ChessType {
        BLACK, WHITE
    }

    public FiveChessView(Context context) {
        super(context);
        init();
    }

    public FiveChessView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FiveChessView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int rows = mHeight / SIZE;
        int cols = mWidth / SIZE;
        drawChessBoard(canvas, rows, cols);
        drawChess(canvas, 4, 4, ChessType.BLACK);
        drawChess(canvas, 4, 5, ChessType.BLACK);
        drawChess(canvas, 5, 4, ChessType.WHITE);
        drawChess(canvas, 3, 5, ChessType.WHITE);
    }

    private void drawChess(Canvas canvas, int x, int y, ChessType chessType) {
        int colorOuter = chessType == ChessType.BLACK ? Color.BLACK : Color.GRAY;
        int colorInner = Color.WHITE;

    }

    /**
     * 画棋盘
     *
     * @param canvas 画布
     * @param rows   行数
     * @param cols   列数
     */
    private void drawChessBoard(Canvas canvas, int rows, int cols) {
        mPaint.setColor(Color.GRAY);
        mPaint.setShadowLayer(0, 0, 0, Color.GRAY);
        for (int i = 0; i < rows + 1; i++) {
            canvas.drawLine(0, i * SIZE, cols * SIZE, i * SIZE, mPaint);
        }
        for (int i = 0; i < cols + 1; i++) {
            canvas.drawLine(i * SIZE, 0, i * SIZE, rows * SIZE, mPaint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = getMeasuredHeight();
        mWidth = getMeasuredWidth();
    }
}
