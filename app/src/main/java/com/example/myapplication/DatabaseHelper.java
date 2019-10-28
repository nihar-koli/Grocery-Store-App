package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

import java.sql.Blob;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Grocery.db";
    public static final String TABLE_NAME1="users";
    public static final String TABLE_NAME2="Cart";

    //user
    public static final String COLUMN1="user_id";
    public static final String COLUMN2="email";
    public static final String COLUMN3="username";
    public static final String COLUMN4="password";

    //cart
    public static final String COLUMN21="cart_id";
    public static final String COLUMN22="Product";
    public static final String COLUMN23="Price";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null, 3);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME1 +"(user_id Integer PRIMARY KEY AUTOINCREMENT, email Text, username Text, password Text)");
        db.execSQL("create table "+ TABLE_NAME2 + "(cart_id Integer PRIMARY KEY AUTOINCREMENT, Product Text, Price Integer)");
   }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        onCreate(db);
    }

    public boolean insertUser(String email, String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN2, email);
        contentValues.put(COLUMN3, username);
        contentValues.put(COLUMN4, password);

        long result = db.insert(TABLE_NAME1,null,contentValues);

        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isUserRegistered(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select username,password from "+ TABLE_NAME1 +" where username = ? and password = ?",new String[] {username,password});
        return(res.getCount()!=0);
    }


    public boolean Cart(String Product, int Price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN22,Product);
        contentValues.put(COLUMN23,Price);
        long result = db.insert(TABLE_NAME2,null,contentValues);
        if(result==-1){
            Log.i("Status","Failed");
            return false;
        }
        else {
            Log.i("Status","Successful");
            return true;
        }
    }
}
