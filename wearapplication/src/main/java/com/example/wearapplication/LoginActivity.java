package com.example.wearapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wearapplication.Channel.CreateChannel;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel createChannel = new CreateChannel(this);
        createChannel.createChannel();

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtUsername.getText().toString().equals("Tuga") && edtPassword.getText().toString().equals("1125")){
                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                    displayNotificationSuccess();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    displayNotificationUnSuccess();
                }
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

}
