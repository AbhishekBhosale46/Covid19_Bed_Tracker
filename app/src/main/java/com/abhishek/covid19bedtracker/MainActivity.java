package com.abhishek.covid19bedtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Hospitals> hospitals;
    String url = "https://sheet.best/api/sheets/6472a0da-47c5-42a9-962a-b756c11e7fe1";
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        hospitals = new ArrayList<>();

        fetchdata();

    }

    private void fetchdata() {

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for(int i = 0; i<response.length();i++) {
                            try {
                                JSONObject hospitalobj = response.getJSONObject(i);

                                Hospitals hospital = new Hospitals();
                                hospital.setHospname(hospitalobj.getString("Hospital_Name"));
                                hospital.setAvailbeds(hospitalobj.getString("Available_Beds"));
                                hospital.setAvailventi(hospitalobj.getString("Available_Ventilators"));
                                hospital.setAvailoxi(hospitalobj.getString("Available_Oxygen"));
                                hospital.setTotalbeds(hospitalobj.getString("Total_Beds"));
                                hospital.setTotalventi(hospitalobj.getString("Total_Ventilators"));
                                hospital.setTotaloxi(hospitalobj.getString("Total_Oxygen"));
                                hospital.setContactno(hospitalobj.getString("Contact_number1"));
                                hospital.setAddress(hospitalobj.getString("Adress"));
                                hospitals.add(hospital);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        adapter = new Adapter(getApplicationContext(),hospitals);
                        recyclerView.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(jsonArrayRequest);


    }
}