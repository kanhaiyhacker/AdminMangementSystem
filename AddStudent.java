package com.example.kanhaiyaadhikari.adminmangementsystem;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class AddStudent extends AppCompatActivity {
    EditText sname,semail,sphone,sfee;
    Spinner sedu,scourse;
    Button sadd, smore;
    static String addurl="https://molded-capture.000webhostapp.com/AquaGuard/student_data.php";
    String responseServer;
    String[] courselist={"PHP","Core Java","Advance Java","Front End Development","Android","C Language","c++ language","Python","Database System"};
    String[] qulist={"10th pass","12 pass","Bachelor in Engineer","BCA","MCA","PHD"};
    String name,mobile,fee,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        sname=(EditText)findViewById(R.id.textname);
        semail=(EditText)findViewById(R.id.textemail);
        sphone=(EditText)findViewById(R.id.phoneno);
        sfee=(EditText)findViewById(R.id.studentfee);
        sedu=(Spinner)findViewById(R.id.education);
        smore=(Button)findViewById(R.id.buttonaddmore);
        scourse=(Spinner)findViewById(R.id.optcourse);
        ArrayAdapter<String> arr=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,courselist);
        scourse.setAdapter(arr);
        ArrayAdapter<String> ars=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,qulist);
        sedu.setAdapter(ars);

        sadd=(Button)findViewById(R.id.buttonadd);
        Log.d("lets check the error","hasaj");
        sadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 name=sname.getText().toString();
                email=semail.getText().toString();
                mobile=sphone.getText().toString();
                fee=sfee.getText().toString();
                if(name!=null&&email!=null&&mobile!=null&&fee!=null) {
                    Asynct asynct = new Asynct();
                    asynct.execute();
                    Toast.makeText(AddStudent.this, "data added", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AddStudent.this, "Enter all Fields", Toast.LENGTH_SHORT).show();
                }

            }
        });
        smore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sname.setText("");
                semail.setText("");
                sphone.setText("");
                sfee.setText("");
            }
        });


    }

    private class Asynct  extends AsyncTask<String,Void,String>{


        @Override
        protected String doInBackground(String... argos) {
            try {

                String education=sedu.getSelectedItem().toString();
                String course=scourse.getSelectedItem().toString();
                URL url=new URL(addurl);
                JSONObject postparamdata=new JSONObject();
                postparamdata.put("name",name);
                postparamdata.put("email",email);
                postparamdata.put("mobile",mobile);
                postparamdata.put("course",course);
                postparamdata.put("fee",fee);
                postparamdata.put("education",education);
                HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postparamdata));

                Log.d("data send ",os+"");
                writer.flush();
                writer.close();
                os.close();
                int responseCode=conn.getResponseCode();
                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in=new BufferedReader(new
                            InputStreamReader(
                            conn.getInputStream()));

                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }

            }
            catch (Exception e)
            {


            }
            return null;
        }
    }

    private String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }
    }

