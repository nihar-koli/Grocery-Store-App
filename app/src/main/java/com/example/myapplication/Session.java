package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {

    private SharedPreferences sharedPreferences;
    private static String PREF_NAME = "prefs";


    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }


    public static void setuser(Context context, String username, String password) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();
    }

    public static void endsession(Context context){
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.clear();
        editor.commit();


    }
}
