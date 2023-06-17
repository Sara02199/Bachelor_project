package com.example.myapplicationss;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbaseHelper extends SQLiteOpenHelper {
    // database name is AdmenLogin.dab
    public static final String DBNAME ="AdmenLogin.dab";
    //declare the password
    private String password;
    // To create database in AdmenLogin.dab
    public DbaseHelper(Context context) {
        super(context, "AdminLogin.dab", null, 1);
    }
    // import methodes
    @Override
    public void onCreate(SQLiteDatabase MDB) {
        //Will have 2 columns in customer table in the database
        MDB.execSQL("create Table admins(admin TEXT primary key ,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MDB, int i, int i1) {
        MDB.execSQL("drop Table if exists admins");

    }
    //create method(function)
    public Boolean insertData (String admin, String password){
        SQLiteDatabase MDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        //write the names of the column
        contentValues.put("admin",admin);
        contentValues.put("password",password);
        //To insert the data
        long result = MDB.insert("admins",null, contentValues);
        //if condition to check the insertion are possible or not
        if (result==-1) return false;
        else
            return true;


    }
    //create next function to check the admin is exists in the table or not
    public  Boolean checkadmin(String admin){
        SQLiteDatabase MDB = this.getWritableDatabase();
        Cursor cursor = MDB.rawQuery("Select * from admins where admin =?", new String[] {admin});
        //if customer exists
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }



    //create function to the password of the customer

    public Boolean checkadminnpassword(String admin, String password) {
        SQLiteDatabase MDB =this.getWritableDatabase();
        Cursor cursor = MDB.rawQuery("Select * from admins where admin = ? and password = ? ", new String[] {admin,password});
        //if condition
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
}



