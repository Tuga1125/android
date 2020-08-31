package com.example.onlinefoodorder.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.onlinefoodorder.R;

public class SearchActivity extends AppCompatActivity {
    Button MainbtnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        MainbtnSearch = findViewById(R.id.MainbtnSearch);

        MainbtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchActivity.this, MapsActivity.class));
            }
        });
    }
}