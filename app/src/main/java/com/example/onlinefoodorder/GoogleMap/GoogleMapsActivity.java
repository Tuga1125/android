package com.example.onlinefoodorder.GoogleMap;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.onlinefoodorder.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class GoogleMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    AutoCompleteTextView acView;
    Button btnSearch;
    List<LatitudeLongitude> latitudeLongitudes = new ArrayList<>();
    CameraUpdate center, zoom;
    Marker marker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        acView = findViewById(R.id.acView);
        btnSearch = findViewById(R.id.btnSearch);

        setListandAdapter();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(acView.getText().toString())){
                    acView.setError("Please enter the Location");
                    return;
                }
                int position = search(acView.getText().toString());
                if(position>-1){
                    loadMap(position);
                }
                else{
                    Toast.makeText(GoogleMapsActivity.this,"Location not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not i nstalled on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        }


    private void setListandAdapter(){
        latitudeLongitudes.add(new LatitudeLongitude(27.706195, 85.3278509, "Softwarica College"));
        latitudeLongitudes.add(new LatitudeLongitude(27.7181749, 85.3151325, "Narayanhiti Palace"));
        latitudeLongitudes.add(new LatitudeLongitude(27.6980136, 85.3217048, "Singha Durbar"));

        String[] data = new String[latitudeLongitudes.size()];

        for (int i = 0; i < latitudeLongitudes.size(); i++) {
            data[i] = latitudeLongitudes.get(i).getMarker();
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        acView.setAdapter(arrayAdapter);
        acView.setThreshold(1);

      }
      private  int search(String name){
        for (int i=0; i<latitudeLongitudes.size();i++){
            if(latitudeLongitudes.get(i).getMarker().contains(name)){
                return i;
            }
        }
        return  -1;
      }

      private  void  loadMap(int position){

        if(marker!= null){
            marker.remove();
        }

        double latitude = latitudeLongitudes.get(position).getLat();
        double longitude = latitudeLongitudes.get(position).getLon();
        center = CameraUpdateFactory.newLatLng(new LatLng(latitude, longitude));
        zoom = CameraUpdateFactory.zoomTo(18);

        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(latitudeLongitudes.get(position).getMarker()));

          mMap.animateCamera(center);
          mMap.moveCamera(center);
          mMap.getUiSettings().setZoomControlsEnabled(true);

      }

}