package com.example.kanhaiyaadhikari.adminmangementsystem;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tablab);
        viewPager = (ViewPager) findViewById(R.id.pagerlab);
        tabLayout.addTab(tabLayout.newTab().setText("AMIN LOGIN"));
        tabLayout.addTab(tabLayout.newTab().setText("FACULTY LOGIN"));
        CustomAdpater customAdpater = new CustomAdpater(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(customAdpater);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());



            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
              
            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });


    }
    }


