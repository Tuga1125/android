package com.example.onlinefoodorder.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlinefoodorder.API.FoodItemAPI;
import com.example.onlinefoodorder.R;
import com.example.onlinefoodorder.URL.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddFoodItemsActivity extends AppCompatActivity {
    private EditText edtFooditem;
    private Button btnAddFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_items);

        edtFooditem = findViewById(R.id.edtFooditem);
        btnAddFood = findViewById(R.id.btnAddFood);

        btnAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder().
                        baseUrl("http://10.0.2.2:3000/").
                        addConverterFactory(GsonConverterFactory.create()).build();

                FoodItemAPI foodItemAPI = retrofit.create(FoodItemAPI.class);

                Call<Void> call= foodItemAPI.foodItems(URL.token, edtFooditem.getText().toString());

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(AddFoodItemsActivity.this,"Error code:"+response.code(), Toast.LENGTH_SHORT).show();

                        }
                        Toast.makeText(AddFoodItemsActivity.this,"Success:Food Item Added", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(AddFoodItemsActivity.this, "Error message"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}