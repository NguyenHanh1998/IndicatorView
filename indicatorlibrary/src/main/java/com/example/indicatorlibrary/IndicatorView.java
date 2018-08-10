package com.example.indicatorlibrary;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;

public class IndicatorView extends View implements IndicatorInterface, ViewPager.OnPageChangeListener{
    //viec ve cach cham tron tuong ung voi so page trong ViewPager
    //va lang nghe su di chuyen cac page -> thuc hien animation ve cac cham tron tuong ung voi trang thai

    private static final long DEFAULT_ANIMATE_DURATION = 200;

    private static final int DEFAULT_RADIUS_SELECTED =  20;

    private static final int DEFAULT_RADIUS_UNSELECTED = 15;

    private static final int DEFAULT_DISTANCE = 40;

    private ViewPager viewPager;

    private Dot[] dots;

    private long animateDuration = DEFAULT_ANIMATE_DURATION;

    private int radiusSelected = DEFAULT_RADIUS_SELECTED;

    private int radiusUnSelected = DEFAULT_RADIUS_UNSELECTED;

    private int distance = DEFAULT_DISTANCE;

    private int colorSelected;

    private int colorUnSelected;

    private ValueAnimator animatorZoomin;

    private ValueAnimator animatorZoomout;

    private  int currentPosition;

    private int beforePosition;

    public IndicatorView(Context context) {
        super(context);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.IndicatorView);
        this.radiusSelected = typedArray.getDimensionPixelSize(R.styleable.IndicatorView_hado_color_selected,DEFAULT_RADIUS_SELECTED);
        this.radiusUnSelected = typedArray.getDimensionPixelSize(R.styleable.IndicatorView_hado_color_unselected,DEFAULT_RADIUS_UNSELECTED);
        this.distance = typedArray.getInt(R.styleable.IndicatorView_hado_distance,DEFAULT_DISTANCE);
        this.colorSelected = typedArray.getColor(R.styleable.IndicatorView_hado_color_selected, Color.parseColor("#ffffff"));
        this.colorUnSelected = typedArray.getColor(R.styleable.IndicatorView_hado_color_unselected,Color.parseColor("#ffffff"));
        typedArray.recycle();
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        beforePosition = currentPosition;
        currentPosition = position;

        if(beforePosition == currentPosition)
        {
            beforePosition = currentPosition + 1;
        }

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(animateDuration);

        animatorZoomin = ValueAnimator.ofInt(radiusUnSelected, radiusSelected);
        animatorZoomin.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            int performPosition = currentPosition;
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int newRadius = (int) animation.getAnimatedValue();
                changeNewRadius(performPosition, newRadius);
            }
        });

        animatorZoomout = ValueAnimator.ofInt(radiusSelected, radiusUnSelected);
        animatorZoomout.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            int performPosition = beforePosition;
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int newRadius = (int) animation.getAnimatedValue();
                changeNewRadius(performPosition, newRadius);
            }
        });

        animatorSet.play(animatorZoomin).with(animatorZoomout);
        animatorSet.start();
    }

    private void changeNewRadius(int performPosition, int newRadius) {
        if(dots[performPosition].getCurrentRadius() != newRadius){
            dots[performPosition].setCurrentRadius(newRadius);
            dots[performPosition].setAlpha(newRadius * 255 / radiusSelected);
            invalidate();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void initDot(int count) throws PagesLessExeption
    {
        if(count < 2) throw new PagesLessExeption();

        dots = new Dot[count];
        for (int i = 0; i < dots.length ; i++) {
            dots[i] = new Dot();
        }
    }

    @Override
    public void setViewPager(ViewPager viewPager) throws PagesLessExeption {
        this.viewPager = viewPager;
        viewPager.addOnPageChangeListener(this);
        initDot(viewPager.getAdapter().getCount());
        onPageSelected(0);

    }

    @Override
    public void setAnimateDuration(long duration) {
        this.animateDuration = duration;

    }

    @Override
    public void setRadiusSelected(int radius) {
        this.radiusSelected = radius;

    }

    @Override
    public void setRadiusUnselected(int radius) {
        this.radiusUnSelected = radius;
    }

    @Override
    public void DistanceDot(int distance) {
        this.distance = distance;

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        float yCenter = getHeight()/2;

        int d = distance + 2 * radiusUnSelected;

        float firstXCenter = (getWidth()/2) - (dots.length - 1) * d /2;

        for (int i = 0; i < dots.length ; i++) {

            dots[i].setCenter(i == 0 ? firstXCenter : firstXCenter + d * i, yCenter);
            dots[i].setCurrentRadius(i == currentPosition ? radiusSelected : radiusUnSelected);
            dots[i].setColor(i == currentPosition ? colorSelected : colorUnSelected);
            dots[i].setAlpha(i == currentPosition ? 255 : radiusUnSelected * 255 /radiusSelected);

        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       int desiredHeight = 2 * radiusSelected;

       int width;
       int heigtht;

       int widthMode = MeasureSpec.getMode(widthMeasureSpec);
       int heightMode = MeasureSpec.getMode(heightMeasureSpec);
       int widthSize = MeasureSpec.getSize(widthMeasureSpec);
       int heightSize = MeasureSpec.getSize(heightMeasureSpec);

       if(widthMode == MeasureSpec.EXACTLY){
           width = widthSize;
       }else if(widthMode == MeasureSpec.AT_MOST){
           width = widthSize;
       }else {
           width = 0;
       }

        if(heightMode == MeasureSpec.EXACTLY){
            heigtht = heightSize;
        }else if(heightMode == MeasureSpec.AT_MOST){
            heigtht = Math.min(desiredHeight, heightSize);
        }else {
            heigtht = desiredHeight;
        }

        setMeasuredDimension(width, heigtht);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        for(Dot dot : dots){
            dot.draw(canvas);
        }
    }
}
