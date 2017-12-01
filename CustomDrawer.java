package com.example.kanhaiyaadhikari.adminmangementsystem;

import android.content.Context;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kanhaiya Adhikari on 7/10/2017.
 */

class CustomDrawer  extends BaseAdapter{
    String[] optiondrawer={"Account","Logout","Setting","Share","About us"};
    int[] drawericons={R.drawable.accountss,R.drawable.logouts,R.drawable.settings,R.drawable.shareimg,R.drawable.aboutus};
    LayoutInflater inflater;
    Context context;

    public CustomDrawer(Admin_Main admin_main) {
        context=admin_main;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return optiondrawer.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
            view=inflater.inflate(R.layout.drawerlist,null);
        TextView text=(TextView)view.findViewById(R.id.txt);
        text.setText(optiondrawer[i]);
        ImageView imags=(ImageView)view.findViewById(R.id.img);
        imags.setImageResource(drawericons[i]);
        return view;
    }
}
