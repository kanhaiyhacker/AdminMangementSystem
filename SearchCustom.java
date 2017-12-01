package com.example.kanhaiyaadhikari.adminmangementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kanhaiya Adhikari on 7/14/2017.
 */

class SearchCustom extends BaseAdapter {
    Context context=null;
    LayoutInflater inflater;
    ArrayList<HashMap<String ,String>> data;



    public SearchCustom(SearchStudent searchStudent, ArrayList<HashMap<String, String>> studentlists) {
        context=searchStudent;
        data=studentlists;
        inflater=LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return data.size();
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
        view=inflater.inflate(R.layout.searchdesign,null);
        TextView textname=(TextView)view.findViewById(R.id.stdn);
        textname.setText(data.get(i).get("name"));
        TextView textemail=(TextView)view.findViewById(R.id.stdemail);
        textemail.setText(data.get(i).get("email"));
        TextView textmobile=(TextView)view.findViewById(R.id.stdmobile);
        textmobile.setText(data.get(i).get("mobile"));
        TextView textcourse=(TextView)view.findViewById(R.id.stdcourse);
        textcourse.setText(data.get(i).get("course"));
        TextView textedu=(TextView)view.findViewById(R.id.stdedu);
        textedu.setText(data.get(i).get("education"));
        TextView textfee=(TextView)view.findViewById(R.id.stdfee);
        textfee.setText(data.get(i).get("fee"));

        return view;
    }
}
