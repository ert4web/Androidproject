package com.training.flyhigh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.training.comebackapp.R;

public class Registration extends AppCompatActivity {

    EditText et_un, et_fname,et_lname,et_email,et_pwd,et_cpwd;
    TextInputLayout ly_un, ly_fname,ly_lname,ly_email,ly_pwd,ly_cpwd;
    Button btn_signup;
    Spinner country_spinner;
    RadioGroup gender_group;
    RadioButton gender_option;
    String country_selected;

    String userName, firstName,lastName,email,password,cnfPassword,country,gender;

    String[] countries = { "Select Country","China","India","Japan","United States", "United Kingdom","United Arab Emirates"};

    public void checkedButton(View v){
        int radioId = gender_group.getCheckedRadioButtonId();
        gender_option = findViewById(radioId);

//        Log.d("gender",gender);
//        Log.d("test","test");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //Edit Text fields
        et_un = findViewById(R.id.reg_un);
        et_fname = findViewById(R.id.reg_fn);
        et_lname = findViewById(R.id.reg_ln);
        et_email = findViewById(R.id.reg_email);
        et_pwd = findViewById(R.id.reg_pwd);
        et_cpwd = findViewById(R.id.reg_cpwd);

        //layouts
        ly_un = findViewById(R.id.ly_regun);
        ly_fname = findViewById(R.id.ly_regfn);
        ly_email = findViewById(R.id.ly_regemail);
        ly_pwd = findViewById(R.id.ly_regpwd);
        ly_cpwd = findViewById(R.id.ly_regcpwd);

        //Radio Buttons
        gender_group=  findViewById(R.id.gender);

        country_spinner =findViewById(R.id.country);

        btn_signup = findViewById(R.id.btn_signup);

        //Spinner data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country_spinner.setAdapter(adapter);

        country_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                country_selected = countries[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btn_signup.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){


                        userName = et_un.getText().toString();
                        firstName = et_fname.getText().toString();
                        lastName = et_lname.getText().toString();
                        email = et_email.getText().toString();
                        password = et_pwd.getText().toString();
                        cnfPassword = et_cpwd.getText().toString();
                        if(gender_option!=null){
                            gender=   gender_option.getText().toString();
                        }



                    if(userName.isEmpty()){
                        ly_un.setError("mandatory field");
                    }
                    else if(firstName.isEmpty()){

                        ly_fname.setError("mandatory field");
                    }
                    else if(email.isEmpty()){
                        ly_email.setError("mandatory field");
                    }
                    else if (password.isEmpty()){
                        ly_pwd.setError("mandatory field");
                    }
                    else if(cnfPassword.isEmpty()){
                        ly_cpwd.setError("mandatory field");
                    }
                    else{
                        ly_cpwd.setError(null);
                        ly_pwd.setError(null);
                        ly_cpwd.setError(null);
                        ly_email.setError(null);
                        ly_fname.setError(null);
                        ly_un.setError(null);

                        if(password.equals(cnfPassword)){
                            ly_pwd.setError(null);
                            ly_cpwd.setError(null);
                            SharedPreferences spref = getSharedPreferences("Register",MODE_PRIVATE);
                            SharedPreferences.Editor editor = spref.edit();
                            editor.putString("username",userName);
                            editor.putString("firstname",firstName);
                            editor.putString("lastname",lastName);
                            editor.putString("email",et_email.getText().toString());
                            editor.putString("password",et_pwd.getText().toString());
                            editor.putString("country",country_selected);
                            if(gender!=null){
                                editor.putString("gender",gender);
                            }

                            editor.commit();

                            Intent reg = new Intent(Registration.this, MainActivity.class);

                            /*reg.putExtra("email",et_email.getText().toString());
                            reg.putExtra("pwd",et_pwd.getText().toString());*/

                            startActivity(reg);
                        }
                        else{
                            ly_pwd.setError("passwords didn't match");
                            ly_cpwd.setError("passwords didn't match");
                        }


                    }

        }
        });
    }
}