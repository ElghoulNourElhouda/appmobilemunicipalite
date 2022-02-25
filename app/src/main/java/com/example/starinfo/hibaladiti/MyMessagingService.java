package com.example.starinfo.hibaladiti;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyMessagingService extends FirebaseMessagingService {
    public MyMessagingService() {
        super();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }

    private void showNotification(String titel_, String body) {
        SharedPreferences prefs = getSharedPreferences("session", MODE_PRIVATE);
        String cin = prefs.getString("cin", null);
String mail = prefs.getString("mail", null);
        if(titel_.contains(cin)) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "Mytestnotification")
                    .setContentTitle("مرحبا  ,"+mail)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setAutoCancel(true)
                    .setContentText(body);

            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
            managerCompat.notify(999, builder.build());
        }
    }
}
