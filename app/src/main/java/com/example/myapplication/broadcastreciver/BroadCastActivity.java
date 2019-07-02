package com.example.myapplication.broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class BroadCastActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);
        //broadcastReceiver=new MyBroadcastReceiver();
    }

    public void broadCastButtonClick(View view) {
        Intent intent=new Intent();
        intent.setAction("android.provider.Telephony.SMS_RECEIVED");
        sendBroadcast(intent);
    }
}
