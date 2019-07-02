package com.example.myapplication.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

public class ServiceActivity extends AppCompatActivity {

    private static final String TAG = "ServiceActivity";
    boolean isServiceBound;
    MyService myService;
    ServiceConnection serviceConnection;
    Intent serviceIntent;
    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        tvData=findViewById(R.id.tvData);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStartService:
                serviceIntent=new Intent(ServiceActivity.this,MyService.class);
                startService(serviceIntent);
                break;

            case R.id.btnStopService:
                stopService(serviceIntent);
                break;

            case R.id.btnBindService:

                if (null==serviceConnection){
                    serviceConnection=new ServiceConnection() {
                        @Override
                        public void onServiceConnected(ComponentName name, IBinder service) {
                            MyService.MyBinder binder = (MyService.MyBinder)service;
                            myService=binder.getSevice();
                            isServiceBound=true;
                        }

                        @Override
                        public void onServiceDisconnected(ComponentName name) {
                            isServiceBound=false;

                        }
                    };
                }
                bindService(serviceIntent,serviceConnection, Context.BIND_AUTO_CREATE);
                break;

            case R.id.btnUnbindService:
                if (isServiceBound) {
                    unbindService(serviceConnection);
                    isServiceBound=false;
                }
                break;

            case R.id.btnGetDataFromService:
                if (isServiceBound) {
                    tvData.setText("" + myService.getRandomNumber());
                    Log.i(TAG, "random number from service " + myService.getRandomNumber());
                }else {
                    Log.i(TAG, "serivce not bound now, thats why data from service won't get");
                }
                break;
        }
    }
}
