package com.example.hanh.learningabstract.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.hanh.learningabstract.Fragment1;
import com.example.hanh.learningabstract.Fragment2;
import com.example.hanh.learningabstract.Fragment3;
import com.example.hanh.learningabstract.Fragment4;
import com.example.hanh.learningabstract.Fragment5;

import java.util.ArrayList;
import java.util.List;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList = new ArrayList<>();
    Fragment1 fragment1 = new Fragment1();
    Fragment2 fragment2 = new Fragment2();
    Fragment3 fragment3 = new Fragment3();

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment1 fragment1 = new Fragment1();
                return fragment1;

            case 1:
                Fragment2 fragment2 = new Fragment2();
                return fragment2;
            case 2:
                Fragment3 fragment3 = new Fragment3();
                return fragment3;
            case 3:
                Fragment4 fragment4 = new Fragment4();
                return fragment4;
            case 4:
                Fragment5 fragment5 = new Fragment5();
                return fragment5;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "SECTION 0";
            case 1:
                return "SECTION 1";
            case 2:
                return "SECTION 2";
            case 3:
                return "SECTION 3";
            case 4:
                return "SECTION 4";
        }
        return null;
    }
}

