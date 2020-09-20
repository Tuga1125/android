package com.example.onlinefoodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.MessageQueue;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String token = "";
    public static String loggedinuserId = "";
    public static boolean loginstatus = false;
    public static String username= "";
    public static String email= "";
    public static String password= "";
    public static String loggedInUserType = "user";


    public static void login(String token, String userid, String username, String email, String password){
        MainActivity.token = token;
        MainActivity.loginstatus = true;
        MainActivity.loggedinuserId = userid;
        MainActivity.username = username;
        MainActivity.email = email;
        MainActivity.password = password;

    }
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