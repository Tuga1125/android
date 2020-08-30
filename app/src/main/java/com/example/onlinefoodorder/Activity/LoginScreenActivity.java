package com.example.onlinefoodorder.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlinefoodorder.API.UserAPI;
import com.example.onlinefoodorder.Channel.CreateChannel;
import com.example.onlinefoodorder.R;
import com.example.onlinefoodorder.Response.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginScreenActivity extends AppCompatActivity {
    private EditText edtUsername, edtPassword;
    private TextView tvSignUp;
    private Button btnLogin;
    NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel createChannel = new CreateChannel(this);
        createChannel.createChannel();

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

        btnLogin = findViewById(R.id.btnLogin);
        tvSignUp = findViewById(R.id.tvSignUp);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreenActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             login();

            }
        });


    }
    private void login(){
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("http://10.0.2.2:3000/").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        UserAPI userAPI = retrofit.create(UserAPI.class);

        Call<UserResponse> call = userAPI.checkUser(edtUsername.getText().toString().trim(),edtPassword.getText().toString().trim());

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(!response.isSuccessful()) {
                    Toast.makeText(LoginScreenActivity.this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(new Intent(LoginScreenActivity.this, Dashboard.class));
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
               Toast.makeText(LoginScreenActivity.this,"Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displayNotificationSuccess(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_baseline_message_24)
                .setContentTitle("Login")
                .setContentText("Congratulations! Login Successful").setCategory(NotificationCompat.CATEGORY_MESSAGE);

        notificationManagerCompat.notify(1, builder.build());

    }
    private void displayNotificationUnSuccess(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_baseline_message_24)
                .setContentTitle("Login")
                .setContentText("Sorry! Login Unsuccessful").setCategory(NotificationCompat.CATEGORY_MESSAGE);

        notificationManagerCompat.notify(2, builder.build());

    }

}