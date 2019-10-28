package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Selection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
    }



    public void gotoSaveVegetable(View view) {
        Intent i = new Intent(Selection.this, SaveVegetable.class);
        startActivity(i);
    }

    public void gotoSaveFruits(View view) {
        Intent i = new Intent(Selection.this, SaveFruit.class);
        startActivity(i);
    }



}


