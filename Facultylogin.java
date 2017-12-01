package com.example.kanhaiyaadhikari.adminmangementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.kanhaiyaadhikari.adminmangementsystem.Adminlogin.userlogin;

/**
 * Created by Kanhaiya Adhikari on 7/7/2017.
 */

public class Facultylogin  extends Fragment{
    EditText email,password;
    Button login;
    String e,p;
    boolean check=true;
    int len;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.faculty_login,container,false);
        email=(EditText)view.findViewById(R.id.facemail);
        password=(EditText)view.findViewById(R.id.facpass);
        login=(Button) view.findViewById(R.id.loginfaculty);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e = email.getText().toString();
                p = password.getText().toString();
                len=userlogin.size();
                Log.d("data",userlogin+"");
                for(int i=0;i<len;i++)
                {
                    if((userlogin.get(i).get("email").toString().equals(e))&&(userlogin.get(i).get("pass").toString().equals(p)))
                    {
                        startActivity(new Intent(getContext(), Faculty_Main.class));
                        check = false;
                        break;
                    }
                }
                if(check==true)
                {
                    email.setText(" ");
                    password.setText(" ");
                    Toast.makeText(getContext(),"Invalid credentials",Toast.LENGTH_LONG).show();
                }

            }
        });
        return view;
    }
}
