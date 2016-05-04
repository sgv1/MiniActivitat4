package com.android.mdw.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class BroadcastService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int id = intent.getIntExtra("btnini", 0);
        Intent intentl = new Intent(context, ElServicio.class);
        intentl.putExtra("btnini", id);
        if (id == 0) {
            context.stopService(intentl);
        } else {
            context.startService(intentl);
        }

    }
}