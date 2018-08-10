package com.example.hanh.learningabstract;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.hanh.learningabstract.adapter.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Activity1";
    private TabLayout myTablayout;
    private ViewPager myViewpager;
    private SectionsPagerAdapter sectionsPagerAdapter;
    private List<Fragment> listFragment = new ArrayList<>();



    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myViewpager = (ViewPager) findViewById(R.id.container);
        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        myViewpager.setAdapter(sectionsPagerAdapter);

        myTablayout = (TabLayout) findViewById(R.id.tabs);
        myTablayout.setupWithViewPager(myViewpager);
        //sectionsPagerAdapter.getItem(myViewpager.getCurrentItem());
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        return true;
    }
}
