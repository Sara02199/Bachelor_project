package com.example.myapplicationss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EImageDetail extends AppCompatActivity {
    //declare  text View,button and Image View components
    ImageView iv8;
    TextView t8, t9;
    Button add8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eimage_detail);
        //get the Ids
        iv8=(ImageView) findViewById(R.id.iv8);
        t8=(TextView) findViewById(R.id.t8) ;
        t9=(TextView) findViewById(R.id.t9) ;
        add8=(Button) findViewById(R.id.add8);
        //add action to add8 button
        add8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the button will go to Product page
                Intent ob23 = new Intent(getApplicationContext(),Product.class);
                startActivity(ob23);
            }
        });

    }
    // to create menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.usermenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //any item from the menu will be selected toast message will be shown with name of selected item
        Toast.makeText(this,"Selected Item: "+item.getTitle(),Toast.LENGTH_LONG).show();
        switch (item.getItemId()) {
            case R.id.mh:
                //if this item is clicked then will go to home page
                Intent zxce = new Intent(getApplicationContext(),ReW.class);
                startActivity(zxce);
                return true;

            case R.id.pot:
                //if this item is clicked then will go to product page
                Intent zxcve = new Intent(getApplicationContext(),Product.class);
                startActivity(zxcve);
                return true;
            case R.id.notivi:
            case R.id.ca:
                //if this item is clicked then will go to BuyProduct page
                Intent zxcbe = new Intent(getApplicationContext(),BuyProduct.class);
                startActivity(zxcbe);
                return true;

            case R.id.pa:
                //if this item is clicked then will go to PayMethode page
                Intent zxcbne = new Intent(getApplicationContext(),PayMethode.class);
                startActivity(zxcbne);
                return true;
            case R.id.lo:
                //if this item is clicked then will go to home page
                Intent loute = new Intent(getApplicationContext(),ReW.class);
                startActivity(loute);
                //toast message will appear by clicking this item
                Toast.makeText(this, "You are logged out successfully... ", Toast.LENGTH_SHORT).show();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}