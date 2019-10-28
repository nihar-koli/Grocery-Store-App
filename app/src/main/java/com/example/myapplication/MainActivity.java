package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Grocery Store");
    }

    public void loginUser (View view){

        DatabaseHelper myDb = new DatabaseHelper(this);

        TextView LoginUsername = findViewById(R.id.LoginUsername);
        TextView LoginPassword = findViewById(R.id.LoginPassword);

        if(myDb.isUserRegistered(LoginUsername.getText().toString(),LoginPassword.getText().toString())){
            Session.endsession(this);
            Session.setuser(this,LoginUsername.getText().toString(),LoginPassword.getText().toString());
            gotoSelection(view);

        }
        else{
            showMessage("Invalid Credentials","Please try again!");
        }

    }

    public void gotoSelection(View view){
        Intent i=new Intent(MainActivity.this,Selection.class);
        startActivity(i);
    }
    public void gotoRegister(View view) {
        Intent i = new Intent(MainActivity.this, Register.class);
        startActivity(i);
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
