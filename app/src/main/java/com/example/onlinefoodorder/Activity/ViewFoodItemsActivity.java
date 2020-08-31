package com.example.onlinefoodorder.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.onlinefoodorder.API.ItemAPI;
import com.example.onlinefoodorder.Model.Item;
import com.example.onlinefoodorder.R;
import com.example.onlinefoodorder.URL.URL;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewFoodItemsActivity extends AppCompatActivity {
    ListView lstView;
    List<String> itemsname = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food_items);

        lstView = findViewById(R.id.lstView);

        loadListView();

    }

    private void loadListView(){
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:3000/")
//                .addConverterFactory(GsonConverterFactory.create()).build();
//        Retrofit retrofit = URL.getInstance();


        final ItemAPI itemAPI = URL.getInstance().create(ItemAPI.class);

        Call<List<Item>> call = itemAPI.get_ALLItems(URL.token);
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ViewFoodItemsActivity.this, "Code:"+response.code(),Toast.LENGTH_SHORT).show();
                    return;

                }
                List<Item> itemList = response.body();
                if(itemList!=null){
                    for(Item i:itemList)
                    itemsname.add(i.getFoodname());
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(ViewFoodItemsActivity.this,
                        android.R.layout.simple_list_item_1, itemsname);
                lstView.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(ViewFoodItemsActivity.this,"Error message"+t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();


            }
        });
    }
}