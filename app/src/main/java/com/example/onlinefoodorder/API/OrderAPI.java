package com.example.onlinefoodorder.API;

import com.example.onlinefoodorder.Model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface OrderAPI {
    @FormUrlEncoded
    @POST("api/orderitem")
    Call<Void> add_Item(@Header("Authorization") String header,
                        @Field("quantity") String quantity,
                        @Field("price") String price );

    @GET("api/orderitem")
    Call<List<Item>> get_ALLOrders(@Header("Authorization") String header);
}
