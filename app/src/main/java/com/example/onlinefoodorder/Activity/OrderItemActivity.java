package com.example.onlinefoodorder.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlinefoodorder.API.OrderAPI;
import com.example.onlinefoodorder.Channel.CreateChannel;
import com.example.onlinefoodorder.R;
import com.example.onlinefoodorder.URL.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderItemActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    EditText slctQuantity, slctPrice;
    Button btnOrderitem;
    TextView txtDate;

    private NotificationManagerCompat notificationManagerCompat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_item);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel createChannel = new CreateChannel(this);
        createChannel.createChannel();


        slctQuantity = findViewById(R.id.slctQuantity);
        slctPrice = findViewById(R.id.slctPrice);
        txtDate = findViewById(R.id.txtDate);

        btnOrderitem = findViewById(R.id.btnOrderitem);

        txtDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });



        btnOrderitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OrderAPI orderAPI = URL.getInstance().create(OrderAPI.class);

                Call<Void> call = orderAPI.add_Order(URL.token, slctQuantity.getText().toString(), slctPrice.getText().toString());

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(OrderItemActivity.this, "Error code:" + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(OrderItemActivity.this, "", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(OrderItemActivity.this, navbar.class));
                        DisplayNotification();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(OrderItemActivity.this, "Error message" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        DisplayNotification2();
                    }
                });
            }

            });


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void loadDatePicker() {
        //Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, year, month,day);
        datePickerDialog.show();

    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "Month/Day/Year: " + month + "/" + dayOfMonth + "/" + year;
        txtDate.setText(date);
    }


    private void DisplayNotification() {
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("Updates")
                .setContentText("Your order has been added successfully!")
                .setCategory(NotificationCompat.CATEGORY_SYSTEM)
                .build();

        notificationManagerCompat.notify(1, notification);
    }
    //activity changes

    private void DisplayNotification2() {
        Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("My E-Foodie")
                .setContentText("You have been connected to a network")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(2,notification);
    }

}

