package com.example.onlinefoodorder.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.onlinefoodorder.API.UserAPI;
import com.example.onlinefoodorder.Model.User;
import com.example.onlinefoodorder.R;
import com.example.onlinefoodorder.Response.UserResponse;
import com.example.onlinefoodorder.URL.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtFirstName, edtLastName, edtUsername, edtEmail, edtPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtUsername = findViewById(R.id.edtUsername);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

//        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2:3000/").addConverterFactory(GsonConverterFactory.create()).build();
//        Retrofit retrofit = URL.getInstance();
        UserAPI userAPI= URL.getInstance().create(UserAPI.class);

        Call<UserResponse> call=userAPI.registerUser(new User(edtFirstName.getText().toString(),edtLastName.getText().toString(),edtUsername.getText().toString(),edtEmail.getText().toString(), edtPassword.getText().toString()));

        call.enqueue(new Callback<UserResponse>() {

            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this,"code"+response.code(), Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(RegisterActivity.this, "User Registered Successfully!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, LoginScreenActivity.class));
            }
            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


//       Spinner dropdown = findViewById(R.id.spinner1);
//        String[] items = new String[]{"user", "admin"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//        dropdown.setAdapter(adapter);




    }
}

