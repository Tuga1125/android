package com.example.onlinefoodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static String token = "";
    public static String loggedinuserId = "";
    public static boolean loginstatus = false;
    public static String username= "";
    public static String email= "";
    public static String password= "";
    public static String loggedInUserType = "user";

    public static void logout() {
        MainActivity.token = "";
        MainActivity.loggedinuserId = "";
        MainActivity.loginstatus = false;
        MainActivity.username = "";
        MainActivity.email = "";
        MainActivity.password = "";
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}