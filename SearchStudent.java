package com.example.kanhaiyaadhikari.adminmangementsystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchStudent extends AppCompatActivity {
    SearchView searchView;
    static int numbers;
    ListView liststd;
    private ProgressDialog pDialog;
    private static String parseurl = "https://molded-capture.000webhostapp.com/Aquaguard/Parse_student_data.php";
    private String TAG = SearchStudent.class.getSimpleName();
    static ArrayList<HashMap<String,String>> studentlists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        liststd=(ListView)findViewById(R.id.studentlist);
        studentlists=new ArrayList<>();
        new getData().execute();
       liststd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent=new Intent(SearchStudent.this,DisplayStudent.class);
               intent.putExtra("position",i+"");
               startActivity(intent);
           }
       });


    }


    private class getData extends AsyncTask {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(SearchStudent.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            //User define class use to download data by url in json formate
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response and storing result into jsonstr (String)
            String jsonStr = sh.makeServiceCall(parseurl);
            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
//now have to convert string data (jsonstr) into jsonObject
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array using node ("contacts") with the help of Jsonobject
                    JSONArray contacts = jsonObj.getJSONArray("contacts");

                    // getting all user data separetly using loop
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String id = c.getString("id");
                        String name = c.getString("name");
                        String email = c.getString("email");
                        String mobile = c.getString("mobile");
                        String course = c.getString("course");
                        String fee = c.getString("fee");
                        String education = c.getString("education");



                        // To store key value data from Jsonobject and storing in HashMap
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put("id", id);
                        contact.put("name", name);
                        contact.put("email", email);
                        contact.put("mobile", mobile);
                        contact.put("course", course);
                        contact.put("fee", fee);
                        contact.put("education", education);


                        // storing HashMap data into ArrayList , to set into listview
                        studentlists.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
           SearchCustom custom=new SearchCustom(SearchStudent.this,studentlists);
            liststd.setAdapter(custom);

        }
    }


}
