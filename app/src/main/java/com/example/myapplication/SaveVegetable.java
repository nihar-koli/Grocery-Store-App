package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SaveVegetable extends AppCompatActivity {

    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savevegetable);

        setTitle("Vegetables");

        mydb=new DatabaseHelper(this);
    }


    public void AddVegetableToCart (View view) {
        if(view.getId() == R.id.Cauliflower){
            mydb.Cart("Cauliflower",12);
            showMessage("Vegetable Added Successfully!","Check your cart...");
        }

        if(view.getId() == R.id.Brinjal){
            mydb.Cart("Brinjal",68);
            showMessage("Vegetable Added Successfully!","Check your cart...");
        }

        if(view.getId() == R.id.Cabbage){
            mydb.Cart("Cabbage",29);
            showMessage("Vegetable Added Successfully!","Check your cart...");
        }

        if(view.getId() == R.id.Tomato){
            mydb.Cart("Tomato",36);
            showMessage("Vegetable Added Successfully!","Check your cart...");
        }

        if(view.getId() == R.id.Onion){
            mydb.Cart("Onion",62);
            showMessage("Vegetable Added Successfully!","Check your cart...");
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
        Intent i=new Intent(SaveVegetable.this,FinalCart.class);
        startActivity(i);
    }
}
