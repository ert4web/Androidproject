package com.training.flyhigh;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;
import com.training.comebackapp.R;

public class ListItem extends AppCompatActivity {
    TextView tvId,tvImp,tvFrom,tvSubject,tvMsg,tvTime,tvRead;
    ImageView ivImg;
    String id,important,image,from,subj,msg,time,read;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        tvId = findViewById(R.id.id);
       tvImp = findViewById(R.id.imp);
        ivImg = findViewById(R.id.image);
        tvFrom = findViewById(R.id.from);
        tvSubject = findViewById(R.id.subject);
       tvMsg = findViewById(R.id.message);
       tvTime = findViewById(R.id.time);
       // tvRead = findViewById(R.id.read);

        Bundle listDetails = getIntent().getExtras();


        id = listDetails.getString("id");
        important = listDetails.getString("imp");
        image = listDetails.getString("image");
       from = listDetails.getString("from");
        subj = listDetails.getString("subject");
        msg = listDetails.getString("msg");
        time = listDetails.getString("time");
       // read = listDetails.getString("read");



        //Log.d("test-item",from);

       // Log.d("test-item",image);


        tvId.setText(id);
       // tvImp.setText(imp);
        tvSubject.setText(subj);
        tvFrom.setText("From: " +from);
        tvMsg.setText(msg);
       tvTime.setText(time);
        //tvRead.setText(read);
        if(image!= null){
            Picasso.get().load(image).into(ivImg);
        }
        else{
            ivImg.setVisibility(View.GONE);

        }
        if(important.toLowerCase().equals("true")){
            tvImp.setVisibility(View.VISIBLE);
        }


    }
}