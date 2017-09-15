package com.robert.viewlearn.graphics2d;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.robert.viewlearn.R;

/**
 * @author: robert
 * @date: 2017-09-14
 * @time: 09:49
 * @说明:
 */
public class Graphics2DActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas2d);
    }

    //    private void drawText() {
//        Bitmap bitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.FILL);
//        paint.setTextSize(14);
//        String text = "番趣科技,彩票玩起来!!!我爱android";
//        canvas.drawText(text, 10, 50, paint);
//        canvas.drawText(text, 0, 4, 10, 150, paint);
//        canvas.drawText(text.toCharArray(), 5, 10, 10, 150, paint);
//        Path path = new Path();
//        path.moveTo(10, 200);
//        path.quadTo(100, 100, 300, 300);
//        canvas.drawTextOnPath(text, path, 15, 15, paint);
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawPath(path, paint);
//        mImageView.setImageBitmap(bitmap);
//    }
//
//    @TargetApi(Build.VERSION_CODES.KITKAT)
//    private void drawPathOp() {
//        Bitmap bitmap = Bitmap.createBitmap(800, 1000, Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.FILL);
//        Path rectPath = new Path();
//        rectPath.addRect(new RectF(10, 10, 110, 100), Path.Direction.CCW);
//        Path circlePath = new Path();
//        circlePath.addCircle(100, 100, 50, Path.Direction.CCW);
//        rectPath.op(circlePath, Path.Op.INTERSECT);
//        canvas.drawPath(rectPath, paint);
//        mImageView.setImageBitmap(bitmap);
//    }
//
//    private void drawBezier() {
//        Bitmap bitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.STROKE);
//        Path path = new Path();
//        path.moveTo(100, 100);
//        path.quadTo(200, 10, 300, 300);
//        canvas.drawPath(path, paint);
//        paint.setStrokeWidth(4);
//        paint.setColor(Color.RED);
//        canvas.drawPoints(new float[]{100, 100, 200, 10, 300, 300}, paint);
//        mImageView.setImageBitmap(bitmap);
//    }
//
//    private void drawPath() {
//        Bitmap bitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.STROKE);
//        Path path = new Path();
//        path.addRect(new RectF(10, 10, 300, 100), Path.Direction.CCW);
//
//        path.addRoundRect(new RectF(10, 120, 300, 220), new float[]{10, 20, 20, 10, 30, 40, 40, 30}, Path.Direction.CCW);
//
//        path.addOval(new RectF(10, 240, 300, 340), Path.Direction.CCW);
//
//        path.addCircle(60, 390, 50, Path.Direction.CCW);
//
//        path.addArc(new RectF(10, 500, 300, 600), -30, -60);
//
//        canvas.drawPath(path, paint);
//
//        mImageView.setImageBitmap(bitmap);
//    }
//
//    private void drawArc() {
//        Bitmap bitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        Paint paint = new Paint();
//        paint.setColor(Color.GRAY);
//        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(2);
//        RectF rect = new RectF(10, 10, 400, 300);
//        canvas.drawOval(rect, paint);
//        paint.setColor(Color.RED);
//        canvas.drawArc(rect, -30, -60, true, paint);
//        mImageView.setImageBitmap(bitmap);
//    }
//
//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    private void drawRect() {
//        Bitmap bitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        Paint paint = new Paint();
//        paint.setColor(Color.RED);
//        canvas.drawRoundRect(10, 10, 400, 300, 50, 30, paint);
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawRoundRect(new RectF(10, 320, 400, 620), 30, 50, paint);
//        mImageView.setImageBitmap(bitmap);
//    }
//
//    private void drawLine() {
//        Bitmap bitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        Paint paint = new Paint();
//        paint.setColor(Color.RED);
//        paint.setStrokeWidth(4);
//        final int offsetDy = 50;
//        for (int i = 1; i < 5; i++) {
//            canvas.drawLine(10, offsetDy * i, 300, offsetDy * i, paint);
//        }
//        mImageView.setImageBitmap(bitmap);
//    }
//
//    private void drawPoint() {
//        Bitmap bitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        Paint paint = new Paint();
//        paint.setColor(Color.RED);
//        paint.setStrokeWidth(10);
//        canvas.drawPoint(120, 20, paint);
//        paint.setColor(Color.BLUE);
//        float[] points = new float[]{10, 10, 50, 50, 50, 100, 50, 150};
//        canvas.drawPoints(points, paint);
//        paint.setColor(Color.GREEN);
//        canvas.drawPoints(points, 1, 4, paint);
//        ImageView imageView = (ImageView) findViewById(R.id.iv);
//        imageView.setImageBitmap(bitmap);
//    }
//
//    private void canvas() {
//
//        Bitmap bmpBuffer = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bmpBuffer);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//        canvas.drawBitmap(bitmap, 0, 0, null);
//        int width = bitmap.getWidth();
//        int height = bitmap.getHeight();
//        Rect src = new Rect(0, 0, width, height);
//        Rect dst = new Rect(0, height, width * 3, height * 4);
//        canvas.drawBitmap(bitmap, src, dst, null);
//
//        ImageView imageView = (ImageView) findViewById(R.id.iv);
//        imageView.setImageBitmap(bitmap);
//    }
//
//    private void paint() {
//        Bitmap bitmap = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.FILL);
//        paint.setTextAlign(Paint.Align.LEFT);
//        int sp = 14;
//        paint.setTextSize(sp);
//        paint.setTextSkewX(-0.5f);//文字倾斜的角度
//        paint.setFakeBoldText(true);//设置文本粗体样式
//        paint.setUnderlineText(true);//文本下滑线
//        canvas.drawText("来来来，我一起dance!!", 10, 100, paint);
//
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setColor(Color.RED);
//        paint.setStrokeWidth(20);
//        paint.setStrokeJoin(Paint.Join.MITER);//线条连接处的样式，三种MITER:直角，ROUND:圆角，BEVEL:折线
//        canvas.drawRect(new Rect(10, 200, 350, 350), paint);
//
//        ImageView imageView = (ImageView) findViewById(R.id.iv);
//        imageView.setImageBitmap(bitmap);
//    }

}
