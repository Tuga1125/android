package com.example.onlinefoodorder.API;

import com.example.onlinefoodorder.Model.Item;
import com.example.onlinefoodorder.Model.Order;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

import retrofit2.Call;
//import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
//import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
//import retrofit2.http.PUT;

public interface OrderAPI {
    @FormUrlEncoded
    @POST("api/orderitem")
    Call<Void> add_Order(@Header("Authorization") String header,
                        @Field("quantity") String quantity,
                        @Field("price") String price);
//                        @Field("date")String date);
//                        @Field("userid") String userid,
//                        @Field("fooditemid") String fooditemid);



//    @GET("api/orderitem")
//    Call<List<Order>> get_ALLOrders(@Header("Authorization") String header);

//    @DELETE("api/orderitem/{orderitemid}")
////    Call<Order> deleteALLOrders(@Header("Authorization") String header);
////
////    @FormUrlEncoded
////    @PUT("api/orderitem/{orderitemid}")
////    Call<Order> editOrders (@Header("Authorization") String header,
////                            @Field("quantity") String quantity,
////                            @Field("price") String price,
////                            @Field("date")String date);
//                            @Field("userid") String userid,
//                            @Field("orderitemid") String fooditemid);
}
