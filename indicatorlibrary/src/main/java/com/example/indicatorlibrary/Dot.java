package com.example.indicatorlibrary;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

public class Dot { // ve hinh tron

    private Paint paint;
    private PointF pointF;
    private int currentRadius;

    public Dot()
    {
        paint = new Paint();
        paint.setAntiAlias(true);
        pointF = new PointF();
    }

    public void setColor(int color){
        paint.setColor(color);
    }

    public void setAlpha(int alpha){
        paint.setAlpha(alpha);
    }

    public void setCenter(float x, float y){
        pointF.set(x, y);
    }

    public int getCurrentRadius() {
        return currentRadius;
    }

    public void setCurrentRadius(int currentRadius) {
        this.currentRadius = currentRadius;
    }

    public void draw(Canvas canvas)
    {
        canvas.drawCircle(pointF.x,pointF.y,currentRadius,paint);
    }
}
