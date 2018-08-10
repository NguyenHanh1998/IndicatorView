package com.example.indicatorlibrary;

import android.support.v4.view.ViewPager;

public interface IndicatorInterface  {

    void setViewPager(ViewPager  viewPager)  throws PagesLessExeption;

    void setAnimateDuration(long duration);

    void setRadiusSelected(int radius);

    void setRadiusUnselected(int radius);

    void DistanceDot(int distance);
}
