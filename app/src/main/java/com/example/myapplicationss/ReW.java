package com.example.myapplicationss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ReW extends AppCompatActivity {
    //declare the text views
    TextView tetV, tView2, txtV4, textView5;
    //declare the image views
    ImageView iVw, imV2, imeV5, imaVi6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_w);
        //Get the Id of the text views
        tetV= (TextView) findViewById(R.id.tetV);
        tView2= (TextView) findViewById(R.id.tView2);
        txtV4= (TextView) findViewById(R.id.txtV4);
        textView5= (TextView) findViewById(R.id.textView5);
        //Get the Ids of the all imageView
        iVw=(ImageView) findViewById(R.id.iVw);
        imV2=(ImageView) findViewById(R.id.imV2);
        imeV5=(ImageView) findViewById(R.id.imeV5);
        imaVi6=(ImageView) findViewById(R.id.imaVi6);

        //Action while clicking the image view that bears the id iVw
        iVw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to AdminSignup page
                Intent obj1=new Intent(getApplicationContext(),AdminSignup.class);
                startActivity(obj1);

            }
        });
        //Action while clicking the image view that bears the id imV2
        imV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to MainActivity page
                Intent obj2=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(obj2);

            }
        });
        //Action while clicking the image view that bears the id  imeV5
        imeV5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to Contact page
                Intent obj3=new Intent(getApplicationContext(),Contact.class);
                startActivity(obj3);

            }
        });
        //Action while clicking the image view that bears the id imaVi6
        imaVi6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to AboutUs page
                Intent obj4=new Intent(getApplicationContext(),AboutUs.class);
                startActivity(obj4);
            }
        });


    }

}
