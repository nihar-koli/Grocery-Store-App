package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Selection extends AppCompatActivity {

    Button button2,button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        setTitle("Make Selection");

        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                    Intent intent = new Intent(Selection.this, com.example.myapplication.SaveVegetable.class);
                    startActivity(intent);
                }
        });

        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Selection.this, com.example.myapplication.Fruits.class);
                startActivity(intent);
            }
        });
    }









}


