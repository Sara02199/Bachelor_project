package com.example.myapplicationss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivityPage extends AppCompatActivity {
    //Define and declare the vairible used in activity_login_page.xml
    TextView title2;
    EditText username, password;
    Button signin2;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        //initialize those variables by there IDs
        title2=(TextView) findViewById(R.id.title2);
        username=(EditText) findViewById(R.id.username01);
        password=(EditText) findViewById(R.id.password01);
        signin2=(Button) findViewById(R.id.signin2);
        DB = new DBHelper(this);


        //add action to signin2 button
        signin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //username and password will be typed by user
                String customer = username.getText(). toString();
                String passwo = password.getText().toString();
                //if the fields is empty, toast message will appear and will not able to access the application
                if (customer.equals("")||passwo.equals(""))
                    Toast.makeText(LoginActivityPage.this, "Make sure that you fill all the fields", Toast.LENGTH_SHORT).show();
                else {
                    //to check if the user is already have an account
                    Boolean checkcustomerpasswo = DB.checkusernamepassword(customer,passwo);

                    //if customer password exists with the given information
                    if (checkcustomerpasswo==true){
                        Toast.makeText(LoginActivityPage.this, "Sign in done successfully ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Product.class);
                        startActivity(intent);
                    }
                    //if username and password dose not match to what are stored in database then this massage will shown to the customer
                    else {
                        Toast.makeText(LoginActivityPage.this, "Check again your username and password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
}