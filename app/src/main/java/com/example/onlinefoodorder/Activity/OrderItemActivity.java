package com.example.onlinefoodorder.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlinefoodorder.API.ItemAPI;
import com.example.onlinefoodorder.API.OrderAPI;
import com.example.onlinefoodorder.R;
import com.example.onlinefoodorder.URL.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderItemActivity extends AppCompatActivity {
    EditText slctQuantity, slctPrice;
    Button btnOrderitem;
    DatePicker showDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_item);

        slctQuantity = findViewById(R.id.slctQuantity);
        slctPrice = findViewById(R.id.slctPrice);
        showDate = findViewById(R.id.showDate);

        btnOrderitem = findViewById(R.id.btnOrderitem);

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
                        Toast.makeText(OrderItemActivity.this, "Food Item is added successfully!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(OrderItemActivity.this, "Error message" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }

            });


    }
}