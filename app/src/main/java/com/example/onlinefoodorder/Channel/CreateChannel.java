package com.example.onlinefoodorder.Channel;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class CreateChannel {
public final static String CHANNEL_1 = "channel1";
    public final static String CHANNEL_2 = "channel2";
    Context context;

    public CreateChannel(Context context) {this.context=context;}
    public void createChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(CHANNEL_1, "channel_1", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("This is channel 1");

            NotificationChannel channel2 = new NotificationChannel(CHANNEL_2,"channel_2", NotificationManager.IMPORTANCE_HIGH);
            channel2.setDescription("This is channel 2");

            NotificationManager manager = context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }
}
