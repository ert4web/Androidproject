package com.training.flyhigh;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.training.comebackapp.R;

public class MyProfile extends AppCompatActivity {
    TextView uname,lname,fname,email,gender,country,headerName;

    String rUsername,rLname,rFname,rEmail,regGender,rCountry;
   Toolbar toolbar1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        toolbar1= findViewById(R.id.toolbar);

        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);




        uname = findViewById(R.id.username);
        lname = findViewById(R.id.lastname);
        fname = findViewById(R.id.firstname);
        email   =findViewById(R.id.email);
        gender = findViewById(R.id.gender);
        country = findViewById(R.id.country);
        headerName =  findViewById(R.id.header_name);

        SharedPreferences spref = getSharedPreferences("Register",MODE_PRIVATE);
       rUsername = spref.getString("username",null);
       rLname = spref.getString("lastname",null);
       rFname = spref.getString("firstname",null);
       rEmail = spref.getString("email",null);
       rCountry = spref.getString("country",null);
       regGender = spref.getString("gender",null);

       headerName.setText(rLname +" "+ rFname);
       uname.setText(rUsername);
       lname.setText(rLname);
       fname.setText(rFname);
       email.setText(rEmail);
       if(rCountry.toLowerCase().equals("select country")){
           country.setText("none");
       }else{
           country.setText(rCountry);
       }
       if(regGender!=null){
           gender.setText(regGender);
       }



    }
}