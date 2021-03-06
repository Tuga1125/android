package com.example.onlinefoodorder.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.onlinefoodorder.API.UserAPI;
import com.example.onlinefoodorder.BLL.UserBLL;
import com.example.onlinefoodorder.Channel.CreateChannel;
import com.example.onlinefoodorder.R;
import com.example.onlinefoodorder.Response.UserResponse;
import com.example.onlinefoodorder.URL.URL;
import com.example.onlinefoodorder.UserActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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

//                                loginSync();

            }
        });


    }

    private void login() {
//        Retrofit retrofit = new Retrofit.Builder().
//                baseUrl("http://10.0.2.2:3000/").
//                addConverterFactory(GsonConverterFactory.create()).
//                build()
//        Retrofit retrofit = URL.getInstance();


        UserAPI userAPI = URL.getInstance().create(UserAPI.class);

        Call<UserResponse> call = userAPI.checkUser(edtUsername.getText().toString().trim(), edtPassword.getText().toString().trim());

        call.enqueue(new Callback<UserResponse>() {

            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(LoginScreenActivity.this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
                    return;
                }

                URL.token += response.body().getToken();
                startActivity(new Intent(LoginScreenActivity.this, navbar.class));
                displayNotificationSuccess();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(LoginScreenActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                displayNotificationUnSuccess();
            }
        });
    }

    private void displayNotificationSuccess() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_baseline_message_24)
                .setContentTitle("Login")
                .setContentText("Congratulations! Login is Successful").setCategory(NotificationCompat.CATEGORY_MESSAGE);

        notificationManagerCompat.notify(1, builder.build());

    }

    private void displayNotificationUnSuccess() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_baseline_message_24)
                .setContentTitle("Login")
                .setContentText("Sorry! Login is Unsuccessful").setCategory(NotificationCompat.CATEGORY_MESSAGE);

        notificationManagerCompat.notify(2, builder.build());

    }

//
//    private void loginSync() {
//        UserBLL userBLL = new UserBLL(edtUsername.getText().toString(), edtPassword.getText().toString());
//        StrictMode();
//        if(userBLL.checkUser()){
//            startActivity(new Intent(LoginScreenActivity.this, navbar.class));
//        }
//        else{
//            Toast.makeText(this,"Invalid username and password", Toast.LENGTH_SHORT).show();
//        }
//
//    }
//
//    private void StrictMode() {
//        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//    }
}