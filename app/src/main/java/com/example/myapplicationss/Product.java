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

public class Product extends AppCompatActivity {

    //declare the text views
    TextView teVwte;

    //declare the image views
    ImageView ivprod, ivprod2, ivprod3, ivprod4, ivprod5, ivprod6, ivprod7, ivprod8, ivprod9, ivprod10,
            ivprod11, ivprod12, ivprod13, ivprod14, ivprod15;
    //declare Button
    Button butOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        //Get the Id of the text view
        teVwte=(TextView) findViewById(R.id.teVwte);

        //Get the Ids of the all imageView and button

        ivprod=(ImageView) findViewById(R.id.ivprod);
        ivprod2=(ImageView) findViewById(R.id.ivprod2);
        ivprod3=(ImageView) findViewById(R.id.ivprod3);
        ivprod4=(ImageView) findViewById(R.id.ivprod4);
        ivprod5=(ImageView) findViewById(R.id.ivprod5);
        ivprod6=(ImageView) findViewById(R.id.ivprod6);
        ivprod7=(ImageView) findViewById(R.id.ivprod7);
        ivprod8=(ImageView) findViewById(R.id.ivprod8);
        ivprod9=(ImageView) findViewById(R.id.ivprod9);
        ivprod10=(ImageView) findViewById(R.id.ivprod10);
        ivprod11=(ImageView) findViewById(R.id.ivprod11);
        ivprod12=(ImageView) findViewById(R.id.ivprod12);
        ivprod13=(ImageView) findViewById(R.id.ivprod13);
        ivprod14=(ImageView) findViewById(R.id.ivprod14);
        ivprod15=(ImageView) findViewById(R.id.ivprod15);
        butOrder=(Button) findViewById(R.id.butOrder);


        //Action while clicking the image view that bears the id ivprod
        ivprod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to FirstImDetai page
                Intent asr = new Intent(getApplicationContext(),FirstImDetai.class);
                startActivity(asr);

            }
        });
        //Action while clicking the image view that bears the id ivprod2
        ivprod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to SImageDetail page
                Intent ar = new Intent(getApplicationContext(),SImageDetail.class);
                startActivity(ar);

            }
        });
        //Action while clicking the image view that bears the id ivprod3
        ivprod3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to ThImageDetail page
                Intent e = new Intent(getApplicationContext(),ThImageDetail.class);
                startActivity(e);

            }
        });
        //Action while clicking the image view that bears the id ivprod4
        ivprod4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to FouImageDetail page
                Intent d = new Intent(getApplicationContext(),FouImageDetail.class);
                startActivity(d);

            }
        });
        //Action while clicking the image view that bears the id ivprod5
        ivprod5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to FifImageDetail page
                Intent b = new Intent(getApplicationContext(),FifImageDetail.class);
                startActivity(b);

            }
        });
        //Action while clicking the image view that bears the id ivprod6
        ivprod6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to SixImageDetail page
                Intent r = new Intent(getApplicationContext(),SixImageDetail.class);
                startActivity(r);

            }
        });
        //Action while clicking the image view that bears the id ivprod7
        ivprod7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to SevImageDetail page
                Intent t = new Intent(getApplicationContext(),SevImageDetail.class);
                startActivity(t);

            }
        });
        //Action while clicking the image view that bears the id ivprod8
        ivprod8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to EImageDetail page
                Intent en = new Intent(getApplicationContext(),EImageDetail.class);
                startActivity(en);

            }
        });
        //Action while clicking the image view that bears the id ivprod9
        ivprod9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to NiImageDetail page
                Intent gh = new Intent(getApplicationContext(),NiImageDetail.class);
                startActivity(gh);

            }
        });
        //Action while clicking the image view that bears the id ivprod10
        ivprod10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to TinImageDetail page
                Intent jk = new Intent(getApplicationContext(),TinImageDetail.class);
                startActivity(jk);

            }
        });
        //Action while clicking the image view that bears the id ivprod11
        ivprod11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to ElvenImageDetail page
                Intent ln = new Intent(getApplicationContext(),ElvenImageDetail.class);
                startActivity(ln);

            }
        });
        //Action while clicking the image view that bears the id ivprod12
        ivprod12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to TwImageDetail page
                Intent op = new Intent(getApplicationContext(),TwImageDetail.class);
                startActivity(op);

            }
        });
        //Action while clicking the image view that bears the id ivprod13
        ivprod13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to ThertinImageDetail page
                Intent qr = new Intent(getApplicationContext(),ThertinImageDetail.class);
                startActivity(qr);

            }
        });
        //Action while clicking the image view that bears the id ivprod14
        ivprod14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to ForteenImageDetail page
                Intent st = new Intent(getApplicationContext(),ForteenImageDetail.class);
                startActivity(st);


            }
        });
        //Action while clicking the image view that bears the id ivprod15
        ivprod15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the image view will go to FifteenImageDetail page
                Intent sr = new Intent(getApplicationContext(),FifteenImageDetail.class);
                startActivity(sr);

            }
        });
        //Action while clicking the button that bears the id butOrder
        butOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //by clicking the button will go to BuyProduct page
                Intent sr = new Intent(getApplicationContext(),BuyProduct.class);
                startActivity(sr);
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
                //if this item is clicked then will go to product page
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