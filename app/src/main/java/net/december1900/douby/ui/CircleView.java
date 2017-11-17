package net.december1900.douby.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import net.december1900.douby.R;

/**
 * Created by december on 21/10/2017.
 */

public class CircleView extends View {


    private static final String TAG = "CircleView";

    private float mRadius = 360;
    private float mStrokeWidth = 40;


    private Paint mPaint;
    private Paint mTextPaint;

    private int mHeight;
    private int mWidth;

    private int[] percents = new int[]{};
    private int[] colors = new int[]{getResources().getColor(R.color.comment_excellent_color), getResources().getColor(R.color.comment_great_color)
            , getResources().getColor(R.color.comment_normal_color), getResources().getColor(R.color.comment_bad_color)};
    private String text;


    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, mHeight + "");
        Log.d(TAG, mWidth + "");
        mHeight = getHeight();
        mWidth = getWidth();
//        canvas.translate(mWidth / 2 - mRadius / 2, mHeight / 2);
        initPaint();
        canvas.drawText(text, mWidth / 2, mHeight / 2, mTextPaint);

        drawCircle(canvas);
    }


    public void setText(String text) {
        this.text = text;
    }


    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mStrokeWidth);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setStrokeWidth(1);
        mTextPaint.setTextSize(48);
        mTextPaint.setColor(getResources().getColor(R.color.comment_excellent_color));
    }





    public void setPercents(int[] percents) {
        this.percents = percents;
    }

    private void drawCircle(Canvas canvas) {
        float startPercent = 0;
        float sweepPercent = 0;
        for (int i = 0; i < percents.length; i++) {
            mPaint.setColor(colors[i]);
            startPercent = sweepPercent + startPercent;
            sweepPercent = percents[i] * 360 / 100;
            canvas.drawArc(new RectF(0, 0, mRadius, mRadius), startPercent, sweepPercent, false, mPaint);
        }

    }



}

