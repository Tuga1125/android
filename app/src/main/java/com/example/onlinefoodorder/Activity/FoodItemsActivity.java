package com.example.onlinefoodorder.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.onlinefoodorder.R;

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
        etDesc = findViewById(R.id.etQuantity);
        etQuantity = findViewById(R.id.etQuantity);
        etPrice = findViewById(R.id.etPrice);

        btnAdd = findViewById(R.id.btnAdd);

    }
}