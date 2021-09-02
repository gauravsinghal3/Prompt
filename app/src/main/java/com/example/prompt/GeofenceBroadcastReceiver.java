package com.example.prompt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;

import java.util.List;

public class GeofenceBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "GeofenceBroadcastReceiv";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving

        NotificationHelper notificationHelper = new NotificationHelper(context);

        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);

        if (geofencingEvent.hasError()) {
            Log.d(TAG, "onReceive: Error receiving geofence event...");
            return;
        }

        List<Geofence> geofenceList = geofencingEvent.getTriggeringGeofences();
        String idGeofence="";
        String title="";
        String body="";
        for (Geofence geofence: geofenceList) {
            Log.d(TAG, "onReceive: " + geofence.getRequestId());
            idGeofence=geofence.getRequestId();
        }

        if (idGeofence.equalsIgnoreCase("0")) {
            title = "Welcome to Walmart Milpitas Store!";
            body = "Wait is over! Buy PS5 🎮 at our Games Section now 😍";
        }
        else {
            title = "Welcome to Walmart Santa Clara Store!";
            body = "Only today!! Speakers 🔈 FREE with purchase of any LED 📺. What 😮??";
        }

        int transitionType = geofencingEvent.getGeofenceTransition();

        switch (transitionType) {

            case Geofence.GEOFENCE_TRANSITION_ENTER:
                Toast.makeText(context, "GEOFENCE_TRANSITION_ENTER", Toast.LENGTH_SHORT).show();
                notificationHelper.sendHighPriorityNotification(title, body, MapsActivity.class);
                break;
        }

    }
}