package com.example.onlinefoodorder.API;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface FoodItemAPI {
    @FormUrlEncoded
    @POST("api/fooditem")
    Call<Void> foodItems (@Header("Authorization")String header,
        @Field("fooditem")String fooditem);

}
