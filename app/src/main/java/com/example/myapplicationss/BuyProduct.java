package com.example.myapplicationss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BuyProduct extends AppCompatActivity {
    //Diclaire button components
    Button bOrder, bpay;
    // Diclaire text View components
    TextView tvti, tvItSe;
    //array for listItems
    String[] listItems;
    boolean[] checkedItems;//array list to hold check items
    ArrayList<Integer> uProducts = new ArrayList<>();//array to hold checked items
    //Diclaire EditText components
    EditText etText;
    //Diclaire button components
    Button btAdd;
    //Diclaire ListView components
    ListView listView;
    // Diclaire database components
    DatabaseHelper databaseHelper;
    ArrayList arrayList; // Diclaire ArrayList components
    ArrayAdapter arrayAdapter;// Diclaire ArrayAdapter components


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);
        //Initialise the views

        bOrder = (Button) findViewById(R.id.bOrder);
        bpay=(Button) findViewById(R.id.bpay);
        tvti = (TextView) findViewById(R.id.tvti);
        tvItSe = (TextView) findViewById(R.id.tvItSe);


        //pass the value of list items
        listItems = getResources().getStringArray(R.array.Farm_item);
        //initialise the check item
        checkedItems = new boolean[listItems.length];

        //when click the button will show the dialog
        bOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(BuyProduct.this);
                //title of the list
                mBuilder.setTitle(R.string.dialog_title);
                //set the multy chose item
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
//                        if (isChecked) {
                        //if the item not part of the list will added to the list
//                            if (!uProducts.contains(position)) {
//                                uProducts.add(position);
//                            }

//                        } else if (uProducts.contains(position)) {
//                            uProducts.remove(position);
//                        }
                        if(isChecked){
                            uProducts.add(position);
                        }else{
                            uProducts.remove((Integer.valueOf(position)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //loop through the list items uProducts
                        String item = "";
                        for (int i = 0; i < uProducts.size(); i++) {
                            //hold individual item in the list
                            item = item + listItems[uProducts.get(i)];
                            //between each item selected will be add comma but if the item is at the end of the list then no comma
                            if (i != uProducts.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        //call the list view
                        tvItSe.setText(item);
                    }
                });

                mBuilder.setNegativeButton(R.string.dismiss_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //call the dialog dismiss
                        dialogInterface.dismiss();
                    }
                });

                //Add action to clear all button to clear the item selected

                mBuilder.setNeutralButton(R.string.clear_all_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //loop
                        for (int i = 0; i < checkedItems.length; i++) {
                            //uncheked everything
                            checkedItems[i] = false;
                            //to clear the item inside the user list
                            uProducts.clear();
                            //empty text for the text view
                            tvItSe.setText("");
                        }
                    }
                });

                //To show the dialog
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });
        bpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String protexv = tvItSe.getText(). toString();
                if(protexv.equals("")){
                    Toast.makeText(BuyProduct.this, "You did not make any order. Please Make an order ", Toast.LENGTH_SHORT).show();
                Intent asdc = new Intent(getApplicationContext(), EmptyCart.class);
                startActivity(asdc);}
                else {
                    Intent asdc = new Intent(getApplicationContext(), PayMethode.class);
                    startActivity(asdc);
                }


            }
        });

        // get the Ids
        etText=(EditText) findViewById(R.id.et_text);
        btAdd=(Button) findViewById(R.id.bt_add);
        listView=(ListView) findViewById(R.id.lest_view);
        databaseHelper= new DatabaseHelper( BuyProduct.this);
        arrayList = databaseHelper.getAllText();
        arrayAdapter = new ArrayAdapter( BuyProduct.this, android.R.layout.simple_list_item_1,arrayList);

        // set the array adapter
        listView.setAdapter(arrayAdapter);
        //add action while clicking btAdd button
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to enable type text
                String text = etText.getText().toString();
                if (!text.isEmpty()){
                    if (databaseHelper.addText(text)){
                        etText.setText("");
                        Toast.makeText(BuyProduct.this, "Data inserted", Toast.LENGTH_SHORT).show();
                        arrayList.clear();
                        arrayList.addAll(databaseHelper.getAllText());
                        arrayAdapter.notifyDataSetChanged();
                        listView.invalidateViews();
                        listView.refreshDrawableState();
                    }
                }
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
                Intent qzxc = new Intent(getApplicationContext(),ReW.class);
                startActivity(qzxc);
                return true;

            case R.id.pot:
                //if this item is clicked then will go to product page
                Intent qzxcv = new Intent(getApplicationContext(),Product.class);
                startActivity(qzxcv);
                return true;
            case R.id.notivi:
            case R.id.ca:
                //if this item is clicked then will go to BuyProduct page
                Intent qzxcb = new Intent(getApplicationContext(),BuyProduct.class);
                startActivity(qzxcb);
                return true;

            case R.id.pa:
                //if this item is clicked then will go to PayMethode page
                Intent qzxcbn = new Intent(getApplicationContext(),PayMethode.class);
                startActivity(qzxcbn);
                return true;
            case R.id.lo:
                //if this item is clicked then will go to home page
                Intent qlout = new Intent(getApplicationContext(),ReW.class);
                startActivity(qlout);
                //toast message will appear by clicking this item
                Toast.makeText(this, "You are logged out successfully... ", Toast.LENGTH_SHORT).show();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}