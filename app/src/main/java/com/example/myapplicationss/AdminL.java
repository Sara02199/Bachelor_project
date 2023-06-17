package com.example.myapplicationss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminL extends AppCompatActivity {
    //Diclaire  text View,Image View,edit text,button and database components
    TextView titsi;
    ImageView iView7;
    EditText admname1, admpassword;
    Button adsi;
    DbaseHelper DBH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_l);
        //Get the Id of text View components
        titsi=(TextView)findViewById(R.id.titsi);
        //Get the Id of ImageView components
        iView7 =(ImageView) findViewById(R.id.iView7);
        //Get the Ids of EditText components
        admname1=(EditText) findViewById(R.id.admname1);
        admpassword=(EditText) findViewById(R.id.admpassword);
        //Get the Id of buttons components
        adsi=(Button) findViewById(R.id.adsi);
        //instant of  DbaseHelper class
        DBH = new DbaseHelper(this);

        //Add an action while click adsi button
        adsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // to allow type from the admin
                String adminn = admname1.getText(). toString();
                String passd = admpassword.getText().toString();

                //if the fields is empty, toast message will appear and will not able to access the application
                if (adminn.equals("")||passd.equals(""))
                    Toast.makeText(AdminL.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                else {
                    //to check if the admin is already have an account
                    Boolean checkadminpasswo = DBH.checkadminnpassword(adminn,passd);

                    //if admin password exists with the given information
                    if (checkadminpasswo==true){
                        Toast.makeText(AdminL.this, "Sign in successfully done", Toast.LENGTH_SHORT).show();
                        Intent inte = new Intent(getApplicationContext(), Features.class);
                        startActivity(inte);
                    }
                    //if username and password dose not match to what are stored in database then this massage will shown to the customer
                    else {
                        Toast.makeText(AdminL.this, "Check again your username, password or you are not admin", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}