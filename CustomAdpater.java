package com.example.kanhaiyaadhikari.adminmangementsystem;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Kanhaiya Adhikari on 7/7/2017.
 */

class CustomAdpater extends FragmentStatePagerAdapter{
    int i;

    public CustomAdpater(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        i=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                Adminlogin f1=new Adminlogin();
                return  f1;
            case 1:
                Facultylogin f2=new Facultylogin();
                return f2;
            default:return null;


        }

    }

    @Override
    public int getCount() {
        return i;
    }
}
