package com.training.flyhigh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.training.comebackapp.R;


public class MainActivity extends AppCompatActivity {
    Button btn_login , btn_signup;
    TextInputLayout lyUname,lyPwd;
    EditText etUname, etPwd;
    RelativeLayout progressBar;


    String uname;
    String password;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login= findViewById(R.id.btn_login);
        etUname =findViewById(R.id.login_id);
        etPwd = findViewById(R.id.login_pwd);
        lyUname = findViewById(R.id.layout_username);
        lyPwd = findViewById(R.id.layout_pwd);
        progressBar = findViewById(R.id.progress_bar);



        btn_signup = findViewById(R.id.btn_signup);

        etUname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lyUname.setError(null);

            }
        });
        etPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lyPwd.setError(null);

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){

               /* Intent login1_intent = new Intent(MainActivity.this,HomePage.class);
                startActivity(login1_intent);*/

                if(etUname.getText().toString().isEmpty()){
                    lyUname.setError("field can't be empty");
                }
                else if(etPwd.getText().toString().isEmpty()){
                    lyPwd.setError("field can't be empty");
                }
                else{

                    /*Bundle reg = getIntent().getExtras();
                    email = reg.getString("email");
                    password = reg.getString("pwd");*/

                    SharedPreferences spref = getSharedPreferences("Register",MODE_PRIVATE);
                    uname = spref.getString("username",null);
                    password = spref.getString("password",null);


                    if(etUname.getText().toString().equals(uname) & etPwd.getText().toString().equals(password)){
                      //  Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.VISIBLE);

                       Intent loginIntent = new Intent(MainActivity.this,HomePage.class);
                       startActivity(loginIntent);



                    }
                    else{
                       // Toast.makeText(MainActivity.this,"Login failed",Toast.LENGTH_LONG).show();
                        lyUname.setError("please enter a valid email address");
                        lyPwd.setError("please enter a valid password");

                    }
                }
//
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            Intent Reg = new Intent(MainActivity.this,Registration.class);
            startActivity(Reg);

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        progressBar.setVisibility(View.GONE);


    }

}