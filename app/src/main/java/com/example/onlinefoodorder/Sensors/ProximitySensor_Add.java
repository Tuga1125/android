package com.example.onlinefoodorder.Sensors;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlinefoodorder.R;

public class ProximitySensor_Add extends AppCompatActivity {
    private EditText edtFirst, edtSecond;
    private Button btnAdd;
    private SensorManager sensorManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor__add);

        edtFirst = findViewById(R.id.edtFirst);
        edtSecond = findViewById(R.id.edtSecond);

        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });

        proximity();

    }
    private void add(){
        int sum = Integer.parseInt(edtFirst.getText().toString()) + Integer.parseInt(edtSecond.getText().toString());
        Toast.makeText(this, "Sum is" +sum, Toast.LENGTH_SHORT).show();
    }
    private void proximity(){
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        SensorEventListener proxilistener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.values[0] <= 4){
                    add();
                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };
        sensorManager.registerListener(proxilistener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
}