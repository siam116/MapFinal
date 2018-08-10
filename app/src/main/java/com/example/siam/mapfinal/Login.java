package com.example.siam.mapfinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;



public class SignUp_Garage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void login(View view)
    {
        EditText e= (EditText)findViewById(R.id.name);
        String name =e.getText().toString().trim();
        name = name.replace(" ","%20");

        EditText f= (EditText)findViewById(R.id.add);
        String address =f.getText().toString().trim();

        EditText g= (EditText)findViewById(R.id.email);
        String mail =g.getText().toString().trim();

        EditText h= (EditText)findViewById(R.id.pass);
        String password  =h.getText().toString().trim();

        EditText i= (EditText)findViewById(R.id.mob);
        String mob =i.getText().toString().trim();

        EditText j= (EditText)findViewById(R.id.ONtime);
        String opentime =j.getText().toString().trim();

        EditText k= (EditText)findViewById(R.id.offtime);
        String offtme  =k.getText().toString().trim();

        EditText l= (EditText)findViewById(R.id.costperhour);
        String costperhour = l.getText().toString().trim();




        String url2= "http://192.168.1.19/garr.php?name="+name+"&add="+address+"&email="+mail+"&pass="+password+"&mob="+mob+"&ONtime="+opentime+"&offtime="+offtme+"&costperhour="+costperhour;
        System.out.println(url2);
        StringRequest stringRequest1 = new StringRequest(url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(SignUp_Garage.this,"Inserted Successfully!!",Toast.LENGTH_LONG).show();
                //loading.dismiss();
                //System.out.println("RESPONSE"+response);
                // showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // System.out.println(error.getMessage().toString());
                        // Toast.makeText(MainActivity.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest1);



    }
}
