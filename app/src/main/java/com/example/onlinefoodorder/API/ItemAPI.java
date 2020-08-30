package com.example.onlinefoodorder.API;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ItemAPI {
    @FormUrlEncoded
    @POST("api/fooditem")
    Call<Void> add_Item(@Header("Authorization") String header,
                        @Field("foodname") String foodname,
                        @Field("description") String description,
                        @Field("quantity") String quantity,
                        @Field("price") String price );

}
