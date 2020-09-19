package com.example.onlinefoodorder.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlinefoodorder.API.ItemAPI;
import com.example.onlinefoodorder.Model.Item;
import com.example.onlinefoodorder.R;
import com.example.onlinefoodorder.URL.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditFoodItemActivity extends AppCompatActivity {
    EditText etFood, etDesc, etQuantity, etPrice;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food_item);


        etFood = findViewById(R.id.etFood);
        etDesc = findViewById(R.id.edtDesc);
        etQuantity = findViewById(R.id.etQuantity);
        etPrice = findViewById(R.id.etPrice);

        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemAPI itemAPI = URL.getInstance().create(ItemAPI.class);

                Call<Item> call = itemAPI.editItem(URL.token,etFood.getText().toString(),etDesc.getText().toString(),etQuantity.getText().toString(),etPrice.getText().toString());

                call.enqueue(new Callback<Item>() {
                    @Override
                    public void onResponse(Call<Item> call, Response<Item> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(EditFoodItemActivity.this, "Error code:"+response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(EditFoodItemActivity.this, "Food Item is added successfuly!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Item> call, Throwable t) {
                        Toast.makeText(EditFoodItemActivity.this, "Error message"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

    }
}
