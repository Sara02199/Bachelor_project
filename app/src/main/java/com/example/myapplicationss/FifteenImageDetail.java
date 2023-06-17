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

public class FifteenImageDetail extends AppCompatActivity {
    //declare  ImageView, textView and Button components
    ImageView im15;
    TextView tv15, t15;
    Button add15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifteen_image_detail);
        //get the Ids of the ImageView, textView and Button
        im15=(ImageView) findViewById(R.id.im15);
        tv15=(TextView) findViewById(R.id.tv15) ;
        t15=(TextView) findViewById(R.id.t15) ;
        add15=(Button) findViewById(R.id.add15);
        //add action to add5 button
        add15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the button will go to Product page
                Intent ob6 = new Intent(getApplicationContext(),Product.class);
                startActivity(ob6);

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
                Intent zxc = new Intent(getApplicationContext(),ReW.class);
                startActivity(zxc);
                return true;

            case R.id.pot:
                //if this item is clicked then will go to Product page
                Intent zxcv = new Intent(getApplicationContext(),Product.class);
                startActivity(zxcv);
                return true;
            case R.id.notivi:
            case R.id.ca:
                //if this item is clicked then will go to BuyProduct page
                Intent zxcb = new Intent(getApplicationContext(),BuyProduct.class);
                startActivity(zxcb);
                return true;

            case R.id.pa:
                //if this item is clicked then will go to PayMethode page
                Intent zxcbn = new Intent(getApplicationContext(),PayMethode.class);
                startActivity(zxcbn);
                return true;
            case R.id.lo:
                //if this item is clicked then will go to home page
                Intent lout = new Intent(getApplicationContext(),ReW.class);
                startActivity(lout);
                //toast message will appear by clicking this item
                Toast.makeText(this, "You are logged out successfully... ", Toast.LENGTH_SHORT).show();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}