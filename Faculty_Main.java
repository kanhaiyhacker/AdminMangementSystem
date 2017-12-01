package com.example.kanhaiyaadhikari.adminmangementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Faculty_Main extends AppCompatActivity {
    GridView gridOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty__main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gridOption=(GridView)findViewById(R.id.gridview);

       Faculty_Custom c= new Faculty_Custom(Faculty_Main.this);
        gridOption.setAdapter(c);
        gridOption.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                        Toast.makeText(Faculty_Main.this, i+"option", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(Faculty_Main.this, i+"option", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(Faculty_Main.this, i+"option", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Intent i2=new Intent(Faculty_Main.this,SearchStudent.class);
                        startActivity(i2);
                        break;


                }

            }
        });


    }

}
