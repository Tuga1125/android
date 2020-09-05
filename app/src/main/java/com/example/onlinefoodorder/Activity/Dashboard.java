package com.example.onlinefoodorder.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.onlinefoodorder.R;
import com.google.android.gms.maps.model.Dash;

public class   Dashboard extends AppCompatActivity {
    TextView txtFood;
    Button btnAddFooditems, btnViewFooditems;
    Button BtnSEarch;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        txtFood = findViewById(R.id.txtFood);
        btnAddFooditems = findViewById(R.id.btnAddFooditems);
        btnViewFooditems = findViewById(R.id.btnViewFooditems);
        BtnSEarch = findViewById(R.id.BtnSEarch);

        txtFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, OrderItemActivity.class));
            }
        });

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

        txtFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, OrderItemActivity.class));
            }
        });
                }
                }