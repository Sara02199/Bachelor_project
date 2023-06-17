package com.example.myapplicationss;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper2 extends SQLiteOpenHelper {
    public static final String DBNAME ="Productdata.db";


    // To create database in Productdata.db
    public DBHelper2(Context context) {
        super(context, "Productdata.db", null, 1);
    }
    // import methodes
    @Override
    public void onCreate(SQLiteDatabase DBHr) {
        //Will have 2 columns in Productdetails table in the database
        DBHr.execSQL("create Table Productdetails(name TEXT Primary key, price TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DBHr, int i, int ii) {
        DBHr.execSQL("drop Table if exists Productdetails");

    }
    //create method(function)
    public Boolean insertproductdata (String name, String price)
    {
        SQLiteDatabase DBHr = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put( "name", name);
        contentValues.put( "price", price);


        long result = DBHr.insert( "Productdetails", null, contentValues);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    //create next function to check the product is exists in the table or not
    public Boolean updateproductdata(String name, String price) {

        SQLiteDatabase DBHr = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( "name", name);
        contentValues.put( "price", price);
        Cursor cursor = DBHr.rawQuery("Select * from Productdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DBHr.update("Productdetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }
    // to delete data from Productdetails
    public Boolean deletedata(String nameTXT) {
        SQLiteDatabase DBHr = this.getWritableDatabase();
        Cursor cursor = DBHr.rawQuery("Select * from Productdetails where name = ?", new String[]{nameTXT});
        if (cursor.getCount() > 0) {
            long result = DBHr.delete("Productdetails", "name=?", new String[]{nameTXT});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    //to get the data from Productdetails
    public Cursor getdata()
    {
        SQLiteDatabase DBHr = this.getWritableDatabase();
        Cursor cursor = DBHr.rawQuery( "Select * from Productdetails", null);
        return cursor;


    }

}
