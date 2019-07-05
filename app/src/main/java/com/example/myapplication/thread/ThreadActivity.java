package com.example.myapplication.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.testJava.Test;

public class ThreadActivity extends AppCompatActivity {

    private static final String TAG = "ThreadActivity";
    MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        Log.d(TAG, "onCreate: main thread id= "+" "+Thread.currentThread().getId());
        myThread =new MyThread();
        myThread.start();

        ((Button)findViewById(R.id.btnSendMessage)).setOnClickListener((view) -> {

           /* myThread.handler.post(new Runnable() {
                @Override
                public void run() {
                    Log.d(TAG, "run: new thread id from sendMessageToAnotherThread== "+" "+Thread.currentThread().getId());
                }
            });*/


           Message message=new Message();
           message.obj="Hello this message send from main thread";
           myThread.handler.sendMessage(message);

        });
    }

    class MyThread extends Thread{

        Handler handler;

        public MyThread(){}

        @Override
        public void run() {

            Looper.prepare();
            //handler=new Handler();
            //Log.d(TAG, "run: new thread id in MyThread== "+" "+Thread.currentThread().getId());

            handler=new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    System.out.println("@@@@@@@@@@@@@@@@@@");
                    System.out.println("new thread id= "+Thread.currentThread().getId());
                    System.out.println("new thread receive message= "+msg);
                    System.out.println("@@@@@@@@@@@@@@@@@@");
                }
            };



            Looper.loop();
        }
    }
}
