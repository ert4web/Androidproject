package com.training.flyhigh;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.training.comebackapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class GetList extends AppCompatActivity {
    RecyclerView list;
    RequestQueue requestQueue ;

    GetlistAdapter adapter;
    ArrayList arrayList;

    Toolbar toolbar;

    final String url ="https://api.androidhive.info/json/inbox.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_list);

        toolbar= findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        arrayList = new ArrayList();

        requestQueue = Volley.newRequestQueue(GetList.this);

        list = findViewById(R.id.list);

        LinearLayoutManager llm = new LinearLayoutManager(GetList.this);
        list.setLayoutManager(llm);
        adapter = new GetlistAdapter(GetList.this,arrayList);
        list.setAdapter(adapter);

        getList();


    }

    //API request
    public void getList(){
        JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i=0; i<response.length();i++){
                    try {
                        JSONObject objResponse = response.getJSONObject(i);
                        ListModel model = new ListModel();
                        model.setFrom(objResponse.getString("from"));
                        model.setSubject(objResponse.getString("subject"));
                        model.setId(objResponse.getString("id"));
                        model.setIsImp(objResponse.getString("isImportant"));
                        model.setMessage(objResponse.getString("message"));
                        model.setTimeStamp(objResponse.getString("timestamp"));
                        model.setIsRead(objResponse.getString("isRead"));
                        if(objResponse.getString("picture").length() !=0) {
                            model.setImage(objResponse.getString("picture"));
                        }
                        arrayList.add(model);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    adapter.notifyDataSetChanged();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonRequest);
    }

    public void getFromAdapter(String id, String isImp, String image, String from, String subject, String message, String time, String read) {
        /*Log.d("test",from);
        Log.d("test",subject);*/
       Intent detailIntent = new Intent(GetList.this,ListItem.class);
        detailIntent.putExtra("id",id);
        detailIntent.putExtra("imp",isImp);
        detailIntent.putExtra("image",image);
        detailIntent.putExtra("from",from);
        detailIntent.putExtra("subject",subject);
        detailIntent.putExtra("msg",message);
        detailIntent.putExtra("time",time);
        detailIntent.putExtra("read",read);

       startActivity(detailIntent);
    }
}