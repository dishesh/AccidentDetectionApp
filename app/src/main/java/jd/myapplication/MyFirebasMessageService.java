package jd.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import jd.database.DatabaseAccess;
import jd.database.MyDatabaseService;
import jd.myapplication.MainActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Dishesh on 28-02-2018.
 */

public class MyFirebasMessageService extends FirebaseMessagingService{
VehicleDTO dto;
private static final String TAG = "MyFirebasMessageService";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From"+remoteMessage.getFrom());
        Map<String, String> data = remoteMessage.getData();



        String title = remoteMessage.getNotification().getTitle();
        String message = remoteMessage.getNotification().getBody();
        Log.i(TAG, "onMessageReceived: title : "+title);
        Log.i(TAG, "onMessageReceived: message : "+message);
//
//

        if(remoteMessage.getData().size()>0){
            dto = new VehicleDTO(remoteMessage.getData().get("Registration"),remoteMessage.getData().get("Owner"),
                    remoteMessage.getData().get("Location"),remoteMessage.getData().get("Contact"));

            Log.d(TAG, "MsgData"+remoteMessage.getData());
        }
        if(remoteMessage.getNotification() != null){
            Log.d(TAG, "MsgBody"+remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getBody());
        }
    }

    private void sendNotification(String body) {
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("Object", (Serializable) dto);
        i.setFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent p = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_ONE_SHOT);
        Uri nSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder NFBuilder = new NotificationCompat.Builder(this);
        NFBuilder
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Firebase Cloud Messaging")
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(nSound)
                .setContentIntent(p);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 /*ID of notification*/, NFBuilder.build());


    }
}
