package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Fruits extends AppCompatActivity {

    //ImageView prod_img;
    //Bitmap imageBitmap;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
        // prod_img=(ImageView)findViewById(R.id.uploaded_prod_img);
        mydb=new DatabaseHelper(this);

        setTitle("Fruits");
    }

    public void AddFruitToCart (View view) {
        if(view.getId() == R.id.Apple){
            mydb.Cart("Apple",70);
            showMessage("Fruit Added Successfully!","Check your cart...");
        }

        if(view.getId() == R.id.Cabbage){
            mydb.Cart("Mango",120);
            showMessage("Fruit Added Successfully!","Check your cart...");
        }

        if(view.getId() == R.id.Kiwi){
            mydb.Cart("Kiwi",270);
            showMessage("Fruit Added Successfully!","Check your cart...");
        }

        if(view.getId() == R.id.Grapes){
            mydb.Cart("Grapes",60);
            showMessage("Fruit Added Successfully!","Check your cart...");
        }
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }




    public void gotoCart(View view){
        Intent i=new Intent(Fruits.this,FinalCart.class);
        startActivity(i);
    }
}
