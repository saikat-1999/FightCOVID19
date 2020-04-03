package com.applex.fightcovid_19;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static androidx.core.content.ContextCompat.getSystemService;

public class Notification_receiver  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

//        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);

//        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
//            NotificationChannel channel=new NotificationChannel("MyNotifications","MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);
//            NotificationManager manager=getSystemService(NotificationManager.class);
//            manager.createNotificationChannel(channel);
//        }

        Intent i =new Intent(context, Repeating_activity.class);
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,i,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"MyNotifications")
                .setContentTitle("Wash Hands")
                .setSmallIcon(R.drawable.ic_access_alarm_black_24dp)
//                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentText("Wash hands for 20 seconds")
                .setContentIntent(pendingIntent);
        NotificationManagerCompat manager = NotificationManagerCompat.from(context);
        manager.notify(100,builder.build());

//        Intent repeating_intent = new Intent(context,Repeating_activity.class);
//        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context).
//                setContentIntent(pendingIntent).
//                setContentTitle("Wash Hands").
//                setContentText("Wash hands for 20 seconds").
//                setAutoCancel(true);
//        notificationManager.notify(100,builder.build());
    }
}
