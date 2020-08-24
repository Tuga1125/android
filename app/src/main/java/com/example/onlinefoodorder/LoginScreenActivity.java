package com.example.onlinefoodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginScreenActivity extends AppCompatActivity {
    private EditText edtUsername, edtPassword;
    private TextView lkRegr;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!LoginScreenActivity.this.edtUsername.getText().toString().equals("Star") && !LoginScreenActivity.this.edtPassword.getText().toString().equals("1125")) {


                    Toast.makeText(LoginScreenActivity.this, "username or password is incorrect", Toast.LENGTH_SHORT).show();
                    LoginScreenActivity.this.edtUsername.setError("username or password is incorrect");
                    LoginScreenActivity.this.edtUsername.requestFocus();
                    return;
                }
                LoginScreenActivity.this.startActivity(new Intent(LoginScreenActivity.this, Dashboard.class));
                LoginScreenActivity.this.finish();

            }
        });

        TextView register = (TextView)findViewById(R.id.lkRegr);
        register.setMovementMethod(LinkMovementMethod.getInstance());
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreenActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}