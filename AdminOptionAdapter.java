package com.example.kanhaiyaadhikari.adminmangementsystem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kanhaiya Adhikari on 7/10/2017.
 */

class AdminOptionAdapter extends BaseAdapter{
    String[] options={"ADD STUDENT","MANAGE TIMETABLE","SEARCH STUDENT","FEE DETAILS","fACULTY MANAGE","UPDATE STDENT DETAIL","ENQIRY"};
    int[] optimg={R.drawable.addstudent,R.drawable.management,R.drawable.searchstudent,R.drawable.fee,R.drawable.faculty,R.drawable.editstudent,R.drawable.inquiry};
    Context context;
    LayoutInflater inflater=null;
    public AdminOptionAdapter(Admin_Main aminPanel) {
        context=aminPanel;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return options.length;
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
       view=inflater.inflate(R.layout.content_admin_row,null);
        TextView text=(TextView)view.findViewById(R.id.textoptions);
        text.setText(options[i]);
        ImageView image=(ImageView)view.findViewById(R.id.imgoptions);
        image.setImageResource(optimg[i]);
        return view;

    }
}
