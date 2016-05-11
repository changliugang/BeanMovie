package com.pro.chang.beanmovie.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.pro.chang.beanmovie.R;
import com.pro.chang.beanmovie.adapter.movie.MoviePagerAdapter;

import java.util.List;

public class MainActivity extends BaseToolbarActivity {

    private TabLayout mTabLayout;
    private MoviePagerAdapter mAdapter;
    private ViewPager mViewPager;

    private List<Fragment> fragments;
    private List<String> titles;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(MainActivity.this,ComingSoonActivity.class));
    }

    @Override
    protected void onCreateCustomToolBar(Toolbar toolbar) {
        super.onCreateCustomToolBar(toolbar);
        toolbar.setNavigationIcon(null);
        toolbar.setLogo(R.mipmap.ic_launcher);
    }

}
