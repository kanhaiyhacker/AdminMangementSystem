package com.example.kanhaiyaadhikari.adminmangementsystem;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kanhaiya Adhikari on 7/7/2017.
 */

public  class Adminlogin extends Fragment {
    EditText email, password;
    Button login;
    public int len;
    String e, p;
    boolean check=true;
    public static ArrayList<HashMap<String, String>> userlogin;
    private String TAG = Adminlogin.class.getSimpleName();
    private ProgressDialog progressDialog;
    static String urllogin = "https://molded-capture.000webhostapp.com/Aquaguard/Login_Location.php";

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admin_login, container, false);
        email = (EditText) view.findViewById(R.id.adminemail);
        password = (EditText) view.findViewById(R.id.adminpass);
        login = (Button) view.findViewById(R.id.adminlogin);
        userlogin = new ArrayList<>();
        new GetUsers().execute();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 e = email.getText().toString();
                 p = password.getText().toString();
                for(int i=0;i<len;i++)
                {
                    if((userlogin.get(i).get("email").toString().equals(e))&&(userlogin.get(i).get("pass").toString().equals(p)))
                    {
                        startActivity(new Intent(getContext(), Admin_Main.class));
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

    private class GetUsers extends AsyncTask<Void,Void,String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.show();

        }

        @Override
        protected String doInBackground(Void... voids) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(urllogin);
            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    JSONArray info = jsonObject.getJSONArray("contacts");
                    for (int i = 0; i < info.length(); i++) {
                        JSONObject c = info.getJSONObject(i);
                        String emails = c.getString("email");
                        String pass = c.getString("pass");
                        HashMap<String, String> contact = new HashMap<>();
                        contact.put("email", emails);
                        contact.put("pass", pass);
                        userlogin.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    new android.os.Handler().postDelayed(
                            new Runnable() {

                                @Override
                                public void run() {
                                    Toast.makeText(getContext(), "Json parsing error: " + e.getMessage(), Toast.LENGTH_LONG).show();

                                }
                            }, 3000);

                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String o) {
            super.onPostExecute(o);
            if (progressDialog.isShowing())
                progressDialog.dismiss();
            len=userlogin.size();
            Log.d("data",userlogin+"");

        }
    }
}
