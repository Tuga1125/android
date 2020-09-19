package com.example.onlinefoodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MActivity extends AppCompatActivity {
    EditText etText;
    Button btnClick;
    TextView tvDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        etText = findViewById(R.id.etText);
        btnClick = findViewById(R.id.btnClick);
        tvDisplay = findViewById(R.id.tvDisplay);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplay.setText(etText.getText().toString());
            }
        });
    }
}