package com.example.onlinefoodorder.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.onlinefoodorder.R;

public class   Dashboard extends AppCompatActivity {
    Button btnAddFooditems, btnViewFooditems;
    Button BtnSEarch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnAddFooditems = findViewById(R.id.btnAddFooditems);
        btnViewFooditems = findViewById(R.id.btnViewFooditems);
        BtnSEarch = findViewById(R.id.BtnSEarch);

        btnAddFooditems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, FoodItemsActivity.class));
            }
        });

        btnViewFooditems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, ViewFoodItemsActivity.class));
            }
        });

        BtnSEarch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, SearchActivity.class));
            }
        });
                }
                }