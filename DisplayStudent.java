package com.example.kanhaiyaadhikari.adminmangementsystem;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static com.example.kanhaiyaadhikari.adminmangementsystem.SearchStudent.studentlists;

public class DisplayStudent extends AppCompatActivity {
    TextView sname,semail,sfee,scourse,sedu,smob;
    Button call,email,sms;
    ArrayList<HashMap<String,String >> studentdetail=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_student);
       sname=(TextView)findViewById(R.id.sname);
        semail=(TextView)findViewById(R.id.stdemail);
        sfee=(TextView)findViewById(R.id.stdfee);
        scourse=(TextView)findViewById(R.id.stdcourse);
        sedu=(TextView)findViewById(R.id.stdedu);
        smob=(TextView)findViewById(R.id.stdmobile);
        call=(Button)findViewById(R.id.callbutton);
        email=(Button)findViewById(R.id.emailbutton);
        sms=(Button)findViewById(R.id.smsbutton);
        studentdetail=studentlists;
        String pos=getIntent().getStringExtra("position");
        int I=Integer.parseInt(pos);
        //int I=Integer.parseInt(pos);
        //img.setImageResource(custom.pic[I]);//the setImage resource
        sname.setText(studentdetail.get(I).get("name"));
        semail.setText(studentdetail.get(I).get("email"));
        smob.setText(studentdetail.get(I).get("mobile"));
        sedu.setText(studentdetail.get(I).get("education"));
        sfee.setText(studentdetail.get(I).get("fee"));
        scourse.setText(studentdetail.get(I).get("course"));
        final String mobile=smob.getText().toString();
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:99494"));
                startActivity(callIntent);




            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });








    }
}
