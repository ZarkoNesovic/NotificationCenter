package com.example.notificationcenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
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
}