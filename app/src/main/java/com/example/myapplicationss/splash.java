package com.example.myapplicationss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //When splash screen closes, ReW will be appear
                Intent intent=new Intent(splash.this,ReW.class);
                startActivity(intent);
                finish();

            }
        },4000);// splash screen will display for four seconds

    }
}