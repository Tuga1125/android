package com.example.onlinefoodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlinefoodorder.Activity.Dashboard;
import com.example.onlinefoodorder.Activity.RegisterActivity;
import com.example.onlinefoodorder.BLL.UserBLL;

public class UserActivity extends AppCompatActivity {
    private EditText edtUsername, edtPassword;
    private TextView tvSignUp;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

        btnLogin = findViewById(R.id.btnLogin);
        tvSignUp = findViewById(R.id.tvSignUp);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//             login();

                loginSync();

            }
        });

    }


    private void loginSync() {
        UserBLL userBLL = new UserBLL(edtUsername.getText().toString(), edtPassword.getText().toString());
        StrictMode();
        if(userBLL.checkUser()){
            startActivity(new Intent(UserActivity.this, Dashboard.class));
        }
        else{
            Toast.makeText(this,"Invalid username and password", Toast.LENGTH_SHORT).show();
        }

    }

    private void StrictMode() {
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

}

