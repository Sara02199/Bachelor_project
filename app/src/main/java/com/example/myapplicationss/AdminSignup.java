package com.example.myapplicationss;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationss.R;

public class AdminSignup extends AppCompatActivity {
    //Diclaire  text View,edit text,button and database components
    TextView tit;
    EditText adname, passwo, repass;
    Button signup, signin;
    DbaseHelper DBH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_signup);
        //Get the Id of text View components
        tit=(TextView) findViewById(R.id.tit);
        //Get the Ids of edit text components
        adname=(EditText) findViewById(R.id.adname);
        passwo=(EditText) findViewById(R.id.passwo);
        repass=(EditText) findViewById(R.id.repass);
        //Get the Ids of buttons components
        signup=(Button) findViewById(R.id.signup);
        signin=(Button) findViewById(R.id.signin);
        //instant of  DbaseHelper class
        DBH = new DbaseHelper(this);

        //Add an action while click signup button
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //the listeners for the button signup
                String admin= adname.getText().toString();
                String passw= passwo.getText().toString();
                String repassw= repass.getText().toString();


                //if all feild or one of them  is empty then massage will shown in toast

                if (TextUtils.isEmpty(admin) || TextUtils.isEmpty(passw) || TextUtils.isEmpty(repassw))
                    Toast.makeText(AdminSignup.this, " Fill all the fields", Toast.LENGTH_SHORT).show();
                else {
                    //to check if the admin already exists or not
                    if (passw.equals(repassw)){
                        // if the admin is not exists
                        Boolean checkuser = DBH.checkadmin(admin);
                        if (checkuser==false){
                            Boolean insert = DBH.insertData(admin,passw);
                            // if it written in the database then a massage in toast will shown
                            if (insert==true) {
                                Toast.makeText(AdminSignup.this, "Registration completed successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Features.class);
                                startActivity(intent);
                            }
                            else {
                                //if the registration not complete successfully
                                Toast.makeText(AdminSignup.this, "Sorry..Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            // if the admin have already account before
                            Toast.makeText(AdminSignup.this, "You are already registered in the system.You have to sign in", Toast.LENGTH_SHORT).show();

                        }
                    }else {
                        //if the password not match in both fields
                        Toast.makeText(AdminSignup.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        //Add an action while click signin button
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // while clicking the button will go redirect to login page
                Intent tent = new Intent(getApplicationContext(),AdminL.class);
                startActivity(tent);
            }
        });




    }
}

