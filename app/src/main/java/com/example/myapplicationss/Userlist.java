package com.example.myapplicationss;




import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class Userlist extends AppCompatActivity {
    //declare the views component

    RecyclerView reclerV;
    ArrayList<String> name, price;
    DBHelper2 DBH;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        //instant of  DBHelper2 class
        DBH= new DBHelper2(this);
        //instant of ArrayList class for name and price
        name = new ArrayList<>();
        price = new ArrayList<>();

        //get the ids
        reclerV= findViewById(R.id.recyclerview);
        adapter= new MyAdapter(this, name,price);
        reclerV.setAdapter(adapter);
        reclerV.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        //display data from the database
        Cursor cursor=DBH.getdata();
        //If no data is added
        if(cursor.getCount()==0)
        {
            //toast message will be shown
            Toast.makeText(Userlist.this, "No entry exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else

        {
            while (cursor.moveToNext())
            {
                //The name and price data are added in order, first the name, then the price
                name.add(cursor.getString(0));
                price.add(cursor.getString(1));


            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.usermenu, menu);
        return true;
    }
    // to create menu
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

