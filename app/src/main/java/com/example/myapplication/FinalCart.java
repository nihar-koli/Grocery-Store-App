package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class FinalCart extends AppCompatActivity {

    DatabaseHelper mydb;
    boolean empty = false;

    public void confirm(View view){
        SQLiteDatabase db = mydb.getReadableDatabase();
        db.execSQL("DELETE FROM " + DatabaseHelper.TABLE_NAME2);
        db.close();

        if(empty == true){
            new AlertDialog.Builder(FinalCart.this)
                    .setTitle("Sorry!")
                    .setMessage("Cart is empty...")
                    .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(FinalCart.this,Selection.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    })
                    .show();
        }else {
            new AlertDialog.Builder(FinalCart.this)
                    .setTitle("Thank You!")
                    .setMessage("Your order placed successfully!!!")
                    .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(FinalCart.this, Selection.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    })
                    .show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_cart);

        setTitle("Checkout");

        TextView totalTextView = findViewById(R.id.totalTextView);
        // Create DatabaseHelper instance

        mydb=new DatabaseHelper(this);

        SQLiteDatabase db = mydb.getReadableDatabase();
        // Start the transaction.
        db.beginTransaction();

        try
        {
            Cursor cursor = db.rawQuery("SELECT SUM(" + DatabaseHelper.COLUMN23 + ") FROM " + DatabaseHelper.TABLE_NAME2, null);
            if (cursor.moveToFirst()) {
                Log.e("Net Total", cursor.getInt(0) + "");
                if(cursor.getInt(0) == 0){
                    empty=true;
                }else{
                    empty=false;
                }
                String total = "Rs. " + cursor.getInt(0);
                totalTextView.setText(total);
            }

            db.setTransactionSuccessful();
            cursor.close();
        }
        catch (SQLiteException e)
        {
            e.printStackTrace();
        }
        finally
        {
            db.endTransaction();
            // End the transaction.
            db.close();
            // Close database
        }
    }
}
