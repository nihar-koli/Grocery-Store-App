package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setTitle("Sign Up");

        myDb = new DatabaseHelper(this);
    }

    public void signupUser (View view)
    {
        DatabaseHelper myDb = new DatabaseHelper(this);

        TextView RegisterEmail = findViewById(R.id.RegisterEmail);
        TextView RegisterUsername = findViewById(R.id.RegisterUsername);
        TextView RegisterPassword = findViewById(R.id.RegisterPassword);
        TextView RegisterConfirm = findViewById(R.id.RegisterConfirm);
        String p1=RegisterPassword.getText().toString();
        String p2=RegisterConfirm.getText().toString();

        if(RegisterEmail.getText().toString().equals("") || RegisterPassword.getText().toString().equals("") || RegisterUsername.getText().toString().equals("") || RegisterConfirm.getText().toString().equals("")){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Error!");
            builder.setMessage("Please fill all details...");
            builder.show();
        }else if(!p1.equals(p2)) {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Password mismatch!");
            builder.setMessage("Please Try again...");
            builder.show();
        } else{
            if (myDb.isUserRegistered(RegisterUsername.getText().toString(), RegisterPassword.getText().toString())) {
                showMessage("Already registered","Try logging in");
            }
            else {
                myDb.insertUser(RegisterEmail.getText().toString(),RegisterUsername.getText().toString(), RegisterPassword.getText().toString());
                showMessage("Sign Up Successful","Log in to access");
            }
        }
    }

        public void showMessage(String title, String message){
            new AlertDialog.Builder(Register.this)
                    .setTitle(title)
                    .setMessage(message)
                    .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
    }
}
