package com.example.onlinefoodorder.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlinefoodorder.API.ItemAPI;
import com.example.onlinefoodorder.R;
import com.example.onlinefoodorder.URL.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodItemsActivity extends AppCompatActivity {
    EditText etFood, etDesc, etQuantity, etPrice;
    Button btnAdd;
    DatePicker showDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R
                .layout.activity_food_items);

        etFood = findViewById(R.id.etFood);
        etDesc = findViewById(R.id.edtDesc);
        etQuantity = findViewById(R.id.etQuantity);
        etPrice = findViewById(R.id.etPrice);

        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:3000/")
//                        .addConverterFactory(GsonConverterFactory.create()).build();
//               Retrofit retrofit = URL.getInstance();

                ItemAPI itemAPI = URL.getInstance().create(ItemAPI.class);

                Call<Void> call = itemAPI.add_Item(URL.token,etFood.getText().toString(),etDesc.getText().toString(),etQuantity.getText().toString(),etPrice.getText().toString());

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(FoodItemsActivity.this, "Error code:"+response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(FoodItemsActivity.this, "Food Item is added successfuly!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(FoodItemsActivity.this, "Error message"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

    }
}