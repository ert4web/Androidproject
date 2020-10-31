package com.training.flyhigh;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.training.comebackapp.R;

public class SocialMedia extends AppCompatActivity {
Toolbar toolbar ;
Button btnFb,btnTwitter,btnInsta,btnLinkedin,btnGplus,btnPintrest,btnTumblr,btnFlickr,btnFm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);

      toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

      btnFb = findViewById(R.id.fb);
      btnTwitter = findViewById(R.id.twitter);
      btnInsta = findViewById(R.id.insta);
      btnLinkedin = findViewById(R.id.linkedin);
      btnGplus = findViewById(R.id.gplus);
      btnPintrest = findViewById(R.id.pintrest);
      btnTumblr = findViewById(R.id.tumblr);
      btnFlickr =findViewById(R.id.flickr);
      btnFm = findViewById(R.id.fm);


      btnFb.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
               openApp("com.facebook.katana");
          }
      });
        //Twitter
        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openApp("com.twitter.android");
            }
        });

        //Instagrm
        btnInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openApp("com.instagram.android");
            }
        });

        //LinkedIn
        btnLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openApp("com.linkedin.android");
            }
        });

        //goolge plus

        btnGplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openApp("com.google.android.apps.dynamite");
            }
        });
        //pintrest
        btnPintrest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openApp("com.pinterest");
            }
        });

        //tumblr
        btnTumblr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openApp("com.tumblr");
            }
        });

        //flickr
        btnFlickr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openApp("com.flickr.android");
            }
        });

        //fm
        btnFm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openApp("fm.last.android");
            }
        });




    }

    public void openApp(String name){
        Intent intent = getPackageManager().getLaunchIntentForPackage(name);
        if (intent != null) {
            // We found the activity now start the activity
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            // Bring user to the market or let them choose an app?
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id=" + name));
            startActivity(intent);
        }

    }
}