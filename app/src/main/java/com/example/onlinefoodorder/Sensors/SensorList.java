package com.example.onlinefoodorder.Sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.onlinefoodorder.R;

import java.util.List;

public class SensorList extends AppCompatActivity {
    private TextView tvSensor;
    private SensorManager sensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);

        tvSensor = findViewById(R.id.tvSensor);

    sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

    List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for(int i=0; i<sensorList.size(); i++){
        String sensors = "";
        sensors+=sensorList.get(i).getName()+"\n";
        tvSensor.append(sensors); 
    }

  }

}
