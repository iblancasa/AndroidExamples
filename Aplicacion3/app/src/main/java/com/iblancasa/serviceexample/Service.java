package com.iblancasa.serviceexample;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class Service extends android.app.Service {
    String TAG= "Hola";

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);


        for(int i=0;i<10;i++){
            Log.d(TAG, "Service started");
        }
        this.stopSelf();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service destroyed");
    }

}
