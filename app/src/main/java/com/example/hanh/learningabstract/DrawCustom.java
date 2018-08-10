package com.example.hanh.learningabstract;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DrawCustom extends View {

    private Paint circlePaint;
    private Paint eyeAndMountPaint;

    private float centerX;
    private float centerY;
    private float radius;
    private RectF rectF = new RectF();
    public DrawCustom(Context context) {
        this(context,null);
    }

    public DrawCustom(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public DrawCustom(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setColor(Color.YELLOW);

        eyeAndMountPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        eyeAndMountPaint.setStyle(Paint.Style.STROKE);
        eyeAndMountPaint.setStrokeCap(Paint.Cap.ROUND);
        eyeAndMountPaint.setColor(Color.BLACK);
        eyeAndMountPaint.setStrokeWidth(getResources().getDisplayMetrics().density);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);

        int size = Math.min(w,h);//gioi han
        setMeasuredDimension(size,size);//xac nhan
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        centerX = w / 2f;
        centerY = h / 2f;
        radius = Math.min(w,h) / 2f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(centerX, centerY, radius, circlePaint);
        float eyeRadius = radius/5f;
        float eyeOffsetX = radius/3f;
        float eyeOffsetY = radius/3f;
        canvas.drawCircle(centerX - eyeOffsetX,centerY - eyeOffsetY,eyeRadius,eyeAndMountPaint);
        canvas.drawCircle(centerX + eyeOffsetX, centerY - eyeOffsetY,eyeRadius,eyeAndMountPaint);

        float mouth = radius/3f;
        rectF.set(mouth,mouth,radius * 2 - mouth, radius * 2 - mouth);
        canvas.drawArc(rectF,45f, 90f, false, eyeAndMountPaint);
    }
}