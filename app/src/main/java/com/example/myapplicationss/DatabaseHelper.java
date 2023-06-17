package com.example.myapplicationss;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    //database name Orders_detail
    private static final String DATABASE_NAME= "OrdersDetail.dab";
    //table name order_d
    private static final String TABLE_NAME = "order_d";

    // To create database in Orders_detail
    DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //to create table with two column id and txt

        String createTable= "create table " + TABLE_NAME+"(id INTEGER PRIMARY KEY, txt TEXT)";
        db.execSQL(createTable);

    }

    @Override
    //upgrade the table if EXISTS
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    // to add text in the table
    public boolean addText (String text){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put( "txt", text);
        sqLiteDatabase.insert(TABLE_NAME, null,contentValues);
        return true;
    }

    //to get all text from the table
    public ArrayList getAllText(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<String>();
        Cursor cursor= sqLiteDatabase.rawQuery( "select * from "+TABLE_NAME
                , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            arrayList.add(cursor.getString(cursor.getColumnIndex("txt")));
            cursor.moveToNext();
        }
        return arrayList;
    }
}
