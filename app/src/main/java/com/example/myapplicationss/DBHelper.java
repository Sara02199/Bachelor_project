package com.example.myapplicationss;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    // database name is Login.dab
    public static final String DBNAME ="Login.dab";
    //declare the password
    private String password;


    // To create database in Login.db

    public DBHelper(Context context) {
        super(context, "Login.dab", null, 1);
    }
    // import methodes
    @Override
    public void onCreate(SQLiteDatabase MineDB) {
        //Will have 3 columns in customer table in the database
        MineDB.execSQL("create Table users(username TEXT primary key , password TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MineDB, int i, int i1) {
        MineDB.execSQL("drop Table if exists users");

    }
    //create method(function)
    public Boolean insertData (String username, String password){
        SQLiteDatabase MineDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        //write the names of the column
        contentValues.put("username",username);
        contentValues.put("password",password);



        //To insert the data
        long result = MineDB.insert("users",null, contentValues);
        //if condition to check the insertion are possible or not
        if (result == -1)
            return false;
        else
            return true;

    }
    //create next function to check the customer is exists in the table or not
    public  Boolean checkusername(String username){
        SQLiteDatabase MineDB = this.getWritableDatabase();
        Cursor cursor = MineDB.rawQuery("Select * from users where username =?", new String[] {username});
        //if customer exists
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    //create function to the password of the customer
    public Boolean checkusernamepassword(String username, String password ){
        SQLiteDatabase MineDB =this.getWritableDatabase();
        Cursor cursor = MineDB.rawQuery("Select * from users where username = ? and password = ?" , new String[] {username,password});
        //if condition
        if (cursor.getCount()>0)
            return true;
        else
            return false;

    }

}
