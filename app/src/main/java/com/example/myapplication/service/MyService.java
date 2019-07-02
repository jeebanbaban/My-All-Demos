package com.example.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.sql.SQLOutput;
import java.util.Random;

import static android.support.constraint.Constraints.TAG;

public class MyService extends Service {


    int randomNumber;
    boolean isRandomGenerator;
    IBinder iBinder=new MyBinder();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        isRandomGenerator=true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                startRandomNumber();
            }
        }).start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRandomNumber();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    class MyBinder extends Binder{
        public MyService getSevice(){
            return MyService.this;
        }
    }

    public void startRandomNumber(){

        while (isRandomGenerator) {
            try {
                Thread.sleep(1000);
                randomNumber = new Random().nextInt(1000);
                Log.i(TAG, "getRandomNumber: " + randomNumber);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void stopRandomNumber(){
        isRandomGenerator=false;
    }

    public int getRandomNumber(){
        return randomNumber;
    }
}
