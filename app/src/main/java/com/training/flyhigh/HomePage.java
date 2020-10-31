package com.training.flyhigh;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.training.comebackapp.R;

public class HomePage extends AppCompatActivity  {

    TextView profileName;
    LinearLayout profile, list, map, SocialMedia, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        profile = findViewById(R.id.profile);
        list = findViewById(R.id.list);
        map = findViewById(R.id.map);
        SocialMedia = findViewById(R.id.media);
        logout = findViewById(R.id.logout);

        profileName = findViewById(R.id.profile_name);

        SharedPreferences spref = getSharedPreferences("Register", MODE_PRIVATE);
        String grtName = spref.getString("username", null);
        profileName.setText(grtName);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfile = new Intent(HomePage.this, MyProfile.class);
                startActivity(intentProfile);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentList = new Intent(HomePage.this, GetList.class);
                startActivity(intentList);
            }
        });

        SocialMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSocial = new Intent(HomePage.this, SocialMedia.class);
                startActivity(intentSocial);
            }

        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMap = new Intent(HomePage.this, MapsActivity.class);
                startActivity(intentMap);
            }

        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LogOut();
            }
        });


    }

    public void LogOut() {
        new AlertDialog.Builder(HomePage.this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences spref = getSharedPreferences("Register", MODE_PRIVATE);
                        spref.edit().clear().commit();
                        Intent intentLogout = new Intent(HomePage.this, MainActivity.class);
                        startActivity(intentLogout);
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //any logic here
                    }
                })
                .show();

    }
}
