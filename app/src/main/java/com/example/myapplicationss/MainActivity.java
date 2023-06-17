package com.example.myapplicationss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //define the variable that used in activity_main.xml
    TextView title;
    EditText username,email,password,repassword,phoneNo;
    Button signup,signin;
    // to import database helper
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize those variable by there IDs

        title=(TextView) findViewById(R.id.title);

        username=(EditText) findViewById(R.id.username);
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        repassword=(EditText) findViewById(R.id.repassword);
        phoneNo=(EditText) findViewById(R.id.phoneNo);
        signup=(Button) findViewById(R.id.signup);
        signin=(Button) findViewById(R.id.signin);
        // to initialize database helper
        DB = new DBHelper(this);


        //listeners for the buttons to make some actions
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //the listeners for the button signup
                String user= username.getText().toString();
                String el= email.getText().toString();
                String pass= password.getText().toString();
                String repass= repassword.getText().toString();
                String pNo= phoneNo.getText().toString();

                //if all field or one of them is empty then massage will shown in toast

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(el) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass)  || TextUtils.isEmpty(pNo))
                    Toast.makeText(MainActivity.this, "You have to fill all the fields", Toast.LENGTH_SHORT).show();
                else {
                    //to check if the customer already exists or not
                    if (pass.equals(repass)){
                        // if the customer is not exists
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            // if it written in the database then a massage in toast will shown
                            if (insert==true) {
                                Toast.makeText(MainActivity.this, "Registration completed successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Product.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Sorry..Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "You are already registered in the system.You have to sign in", Toast.LENGTH_SHORT).show();

                        }
                    }else {
                        Toast.makeText(MainActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // while clicking the button will go redirect to login page
                Intent intent = new Intent(getApplicationContext(),LoginActivityPage.class);
                startActivity(intent);
            }
        });




    }
}