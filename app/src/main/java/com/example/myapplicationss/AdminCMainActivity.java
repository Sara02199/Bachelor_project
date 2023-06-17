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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
public class AdminCMainActivity extends AppCompatActivity {
    //declare  text View,edit text,button and database components
    TextView text;
    EditText name, price;
    Button insert, View, update, delete;
    DBHelper2 DBHr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_cmain);

        //Get the Id of text View components
        text= (TextView) findViewById(R.id.ti);
        //Get the Ids of edit text components
        name = (EditText) findViewById(R.id.prodname);
        price = (EditText) findViewById(R.id.prodprice);
        //Get the Ids of buttons components
        insert= (Button) findViewById(R.id.btnIc);
        View= (Button) findViewById(R.id.btnVw);
        update= (Button) findViewById(R.id.btnUpd);
        delete= (Button) findViewById(R.id.btndele);
        //instant of  DBHelper2 class
        DBHr = new DBHelper2(this);

        //Add an action while click View button
        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                //will  View the recordes in Userlist page
                startActivity(new Intent(AdminCMainActivity.this, Userlist.class));
            }
        });
        //Add an action while click insert button
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                //name and price will be typed by admin
                String nameTXT = name.getText().toString();
                String priceTXT = price.getText().toString();
                //if new product name write it in the text view the record will be inserted. will check from the database
                Boolean checkinsertdata = DBHr.insertproductdata(nameTXT,priceTXT);
                if(checkinsertdata==true)
                {
                    Toast.makeText(AdminCMainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }
                //if there is already recorded with the same name, then record will not be inserted
                else
                {
                    Toast.makeText(AdminCMainActivity.this, "Not Inserted ", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //Add an action while click  update button
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //name and price will be typed by admin
                String nameTXT = name.getText().toString();
                String priceTXT = price.getText().toString();
                //if admin want to update any record, she must write the name of the product as what saved before to be able to update that record. will check from the database if the record is saved before or not
                Boolean checkupdatedata = DBHr.updateproductdata(nameTXT,priceTXT);
                //if the record saved before and the user write exactly the same name of the product, the entry will be update and toast message will be shown
                if(checkupdatedata==true)
                    Toast.makeText(AdminCMainActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    //if the record not saved before and the user name of the product, the entry will not be update and toast message will be shown
                    Toast.makeText(AdminCMainActivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }
        });
        //Add an action while click delete button
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //name  will be typed by admin
                String nameTXT = name.getText().toString();
                //check from database
                Boolean checkudeletedata = DBHr.deletedata(nameTXT);
                //if the name written was saved alreary in the database, the entry will be delete it and toast message will be shown
                if(checkudeletedata==true)
                    Toast.makeText(AdminCMainActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();

                else
                    //if the name written not saved in the database, the entry will not be delete it and toast message will be shown
                    Toast.makeText(AdminCMainActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });


    }
    @Override
    // to create menu
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

