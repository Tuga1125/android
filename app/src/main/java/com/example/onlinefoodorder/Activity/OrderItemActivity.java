package com.example.onlinefoodorder.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
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
import com.example.onlinefoodorder.R;
import com.example.onlinefoodorder.URL.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderItemActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    EditText slctQuantity, slctPrice;
    Button btnOrderitem;
    TextView txtDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_item);

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
}
