package com.example.myapplication.broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.logging.Handler;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("OnReceive= "+intent.getAction());
        Toast.makeText(context, "OnReceive= "+intent.getAction(), Toast.LENGTH_SHORT).show();
    }
}
