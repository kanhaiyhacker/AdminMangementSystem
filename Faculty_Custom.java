package com.example.kanhaiyaadhikari.adminmangementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kanhaiya Adhikari on 7/16/2017.
 */

class Faculty_Custom extends BaseAdapter{

    Context c=null;
    LayoutInflater inflate=null;
    String[] name={"Time Table","Course Done","Make a Test","Student Detail","Submit Attendance","submit marks","Inform"};
    int[] image={R.drawable.calendar,R.drawable.course,R.drawable.test,R.drawable.stu,R.drawable.attendance,R.drawable.marks,R.drawable.inform};
    public Faculty_Custom(Faculty_Main faculty_main) {
        c=faculty_main;
        inflate=(LayoutInflater.from(c));
    }

    @Override
    public int getCount() {
        return name.length;
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        convertView=inflate.inflate(R.layout.faculty_design,null);
        ImageView img=(ImageView)convertView.findViewById(R.id.imageView);
        TextView txt=(TextView)convertView.findViewById(R.id.textView);
        img.setImageResource(image[position]);
        txt.setText(name[position]);
        return convertView;
    }
}
