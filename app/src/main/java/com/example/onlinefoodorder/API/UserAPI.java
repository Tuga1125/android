package com.example.onlinefoodorder.API;

import com.example.onlinefoodorder.Model.User;
import com.example.onlinefoodorder.Response.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserAPI {

    @POST("users/register")
    Call<UserResponse> registerUser(@Body User user);

    @FormUrlEncoded

    @POST("users/login")
    Call<UserResponse> checkUser(@Field("username")String username, @Field("password")String password);

}
