package com.example.notificationcenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.notificationcenter.App.CHANNEL_1_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText TitleView;
    private EditText MessageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager=NotificationManagerCompat.from(this);
        TitleView=findViewById(R.id.editTextTitle);
        MessageView=findViewById(R.id.editTextMessage);
    }


    public void sendOnChannel1(View view) {
        String title=TitleView.getText().toString();
        String message= MessageView.getText().toString();

        Notification notification=new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_airplanemode_active_24)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(1,notification);
    }

    public void sendOnChannel2(View view) {
        String title=TitleView.getText().toString();
        String message= MessageView.getText().toString();

        Notification notification=new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_airplanemode_active_24)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(2,notification);
    }

    public void sendOnChannel3(View view) {
        String title=TitleView.getText().toString();
        String message= MessageView.getText().toString();

        Intent activityIntent=new Intent(this,MainActivity.class);
        PendingIntent contntIntent=PendingIntent.getActivity(this,0,activityIntent,0);

        Intent broadcastIntent=new Intent(this,NotificationReciver.class);
        broadcastIntent.putExtra("toastMessage",message);
        PendingIntent actionIntent=PendingIntent.getBroadcast(this,0,broadcastIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification=new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_airplanemode_active_24)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contntIntent)
                .addAction(R.mipmap.ic_launcher,"Toast",actionIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();
        notificationManager.notify(1,notification);
    }
    public void sendOnChannel4(View view) {
        String title=TitleView.getText().toString();
        String message= MessageView.getText().toString();

        Intent activityIntent=new Intent(this,MainActivity.class);
        PendingIntent contntIntent=PendingIntent.getActivity(this,0,activityIntent,0);

        Intent broadcastIntent=new Intent(this,NotificationReciver.class);
        broadcastIntent.putExtra("toastMessage",message);
        PendingIntent actionIntent=PendingIntent.getBroadcast(this,0,broadcastIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap largeIcon= BitmapFactory.decodeResource(getResources(),R.drawable.android_large_icon);

        Notification notification=new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_airplanemode_active_24)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(largeIcon)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(getString(R.string.velika_notifikacija_tekst))
                        .setBigContentTitle(getString(R.string.DesankaMaksimovic))
                        .setSummaryText("Tekst velika notifikacija sazetak"))

                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contntIntent)
                .addAction(R.mipmap.ic_launcher,"Toast",actionIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();
        notificationManager.notify(1,notification);
    }
}