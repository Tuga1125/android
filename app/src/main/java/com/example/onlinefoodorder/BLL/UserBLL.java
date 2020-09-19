package com.example.onlinefoodorder.BLL;

import com.example.onlinefoodorder.API.UserAPI;
import com.example.onlinefoodorder.Model.User;
import com.example.onlinefoodorder.Response.UserResponse;
import com.example.onlinefoodorder.URL.URL;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class UserBLL {
    private String username;
    private String password;
    private boolean isSuccess = false;

    public UserBLL(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean checkUser(){
        UserAPI userAPI = URL.getInstance().create(UserAPI.class);
        Call<UserResponse> call = userAPI.checkUser(username, password);

        try {
            Response<UserResponse> uresponse = call.execute();
            if (uresponse.body().getStatus().equals("Login Successful!")) {
                URL.token += uresponse.body().getToken();
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}

