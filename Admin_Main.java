package com.example.kanhaiyaadhikari.adminmangementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class Admin_Main extends AppCompatActivity
       { DrawerLayout drawer;
         ListView Listdrawer;
           GridView gridadmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findid();
        AdminOptionAdapter adapter=new AdminOptionAdapter(Admin_Main.this);
        gridadmin.setAdapter(adapter);
        gridadmin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                        Intent intent=new Intent(Admin_Main.this,AddStudent.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(Admin_Main.this, i+"option", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Intent i2=new Intent(Admin_Main.this,SearchStudent.class);
                        startActivity(i2);
                        break;


                }
            }
        });





        CustomDrawer customDrawer=new CustomDrawer(Admin_Main.this);
        Listdrawer.setAdapter(customDrawer);
        Listdrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               switch (i)
               {
                   case 0:
                   {
                       if (drawer.isDrawerOpen(GravityCompat.START)) {
                           drawer.closeDrawer(GravityCompat.START);
                       }

                   }
                   break;
                   case 1:
                   {
                       if (drawer.isDrawerOpen(GravityCompat.START)) {
                           drawer.closeDrawer(GravityCompat.START);
                       }

                   }
                   break;
                   case 2:
                   {
                       if (drawer.isDrawerOpen(GravityCompat.START)) {
                           drawer.closeDrawer(GravityCompat.START);
                       }

                   }
                   break;
                   case 3:
                   {
                       if (drawer.isDrawerOpen(GravityCompat.START)) {
                           drawer.closeDrawer(GravityCompat.START);
                       }

                   }
                   break;
                   case 4:
                   {
                       if (drawer.isDrawerOpen(GravityCompat.START)) {
                           drawer.closeDrawer(GravityCompat.START);
                       }

                   }
                   break;


                   }
            }
        });



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    void findid()
    {
        gridadmin=(GridView)findViewById(R.id.adminoption);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Listdrawer=(ListView)findViewById(R.id.drawerlist);

    }

}
