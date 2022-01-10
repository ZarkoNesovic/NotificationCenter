package com.example.notificationcenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;

import android.app.Notification;
import android.app.PendingIntent;
//import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.notificationcenter.App.CHANNEL_1_ID;
import static com.example.notificationcenter.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText TitleView;
    private EditText MessageView;

    static List<Message> MESSAGES = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager=NotificationManagerCompat.from(this);
        TitleView=findViewById(R.id.editTextTitle);
        MessageView=findViewById(R.id.editTextMessage);

        MESSAGES.add(new Message("Prva poruka","Zarko"));
        MESSAGES.add(new Message("Prva poruka",null));
        MESSAGES.add(new Message("Prva poruka","Nikola"));
    }

/*Obicna notivikacija
*/
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

        Notification notification=new NotificationCompat.Builder(this,CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_baseline_airplanemode_active_24)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(2,notification);
    }
// Notifikacija sa akcijom
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

    //Big text style notifikacija

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

    //Inbox style notifikacija

    public void sendOnChannel5(View view) {
        String title=TitleView.getText().toString();
        String message= MessageView.getText().toString();

        Notification notification=new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_airplanemode_active_24)
                .setContentTitle(title)
                .setContentText(message)
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("Ovo je linija 1")
                        .addLine("Ovo je linija 2")
                        .addLine("Ovo je linija 3")
                        .addLine("Ovo je linija 4")
                        .addLine("Ovo je linija 5")
                        .addLine("Ovo je linija 6")
                        .addLine("Ovo je linija 7")
                        .setBigContentTitle("Veliki naslov")
                        .setSummaryText("Kratki text")
                )
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(2,notification);
    }

    //Big picture notification

    public void sendOnChannel6(View view) {
        String title=TitleView.getText().toString();
        String message= MessageView.getText().toString();

        Intent activityIntent=new Intent(this,MainActivity.class);
        PendingIntent contntIntent=PendingIntent.getActivity(this,0,activityIntent,0);


        Bitmap picture= BitmapFactory.decodeResource(getResources(),R.drawable.nature);

        Notification notification=new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_airplanemode_active_24)
                .setContentTitle(title)
                .setContentText(message)
                .setLargeIcon(picture)
                .setStyle(new NotificationCompat.BigPictureStyle()
                .bigPicture(picture)
                .bigLargeIcon(null))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contntIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();
        notificationManager.notify(1,notification);
    }

    public void sendOnChannel7(View v) {
        sendChannel1Notification(this);
    }

    public static void sendChannel1Notification(Context context) {
        Intent activityIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,
                0, activityIntent, 0);

        RemoteInput remoteInput = new RemoteInput.Builder("key_text_reply")
                .setLabel("Odgovor ...")
                .build();

        Intent replyIntent;
        PendingIntent replyPendingIntent = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            replyIntent = new Intent(context, DirectReplyReceiver.class);
            replyPendingIntent = PendingIntent.getBroadcast(context,
                    0, replyIntent, 0);
        } else {
            //start chat activity instead (PendingIntent.getActivity)
            //cancel notification with notificationManagerCompat.cancel(id)
        }

        NotificationCompat.Action replyAction = new NotificationCompat.Action.Builder(
                R.drawable.ic_baseline_add_24,
                "Odgovori",
                replyPendingIntent
        ).addRemoteInput(remoteInput).build();

        NotificationCompat.MessagingStyle messagingStyle =
                new NotificationCompat.MessagingStyle("Me");
        messagingStyle.setConversationTitle("Group Chat");

        for (Message chatMessage : MESSAGES) {
            NotificationCompat.MessagingStyle.Message notificationMessage =
                    new NotificationCompat.MessagingStyle.Message(
                            chatMessage.getText(),
                            chatMessage.getTimestamp(),
                            chatMessage.getSender()
                    );
            messagingStyle.addMessage(notificationMessage);
        }

        Notification notification = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_add_24)
                .setStyle(messagingStyle)
                .addAction(replyAction)
                .setColor(Color.BLUE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(1, notification);
    }

    public void sendOnChannel8(View v) {
        final int progressMax = 100;

        final NotificationCompat.Builder notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_add_24)
                .setContentTitle("Download")
                .setContentText("Download je u toku")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setOngoing(true)
                .setOnlyAlertOnce(true)
                .setProgress(progressMax, 0, true);

        notificationManager.notify(2, notification.build());

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                for (int progress = 0; progress <= progressMax; progress += 20) {
                    /*notification.setProgress(progressMax, progress, false);
                    notificationManager.notify(2, notification.build());*/
                    SystemClock.sleep(1000);
                }
                notification.setContentText("Download finished")
                        .setProgress(0, 0, false)
                        .setOngoing(false);
                notificationManager.notify(2, notification.build());
            }
        }).start();
    }



}