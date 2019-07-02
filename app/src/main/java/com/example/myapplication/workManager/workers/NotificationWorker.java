package com.example.myapplication.workManager.workers;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import com.example.myapplication.R;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class NotificationWorker extends Worker {

    public static final String TASK_TITLE_KEY="title";
    public static final String TASK_DATA_KEY="data";

    public NotificationWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        System.out.println("START WORK=============");
        String title=getInputData().getString(TASK_TITLE_KEY);
        String data=getInputData().getString(TASK_DATA_KEY);

        displayNotification(TASK_TITLE_KEY,TASK_DATA_KEY);

        return Result.success(sendDataToUI(TASK_DATA_KEY,"Work is finished"));
        //return Result.success();
    }

    private void displayNotification(String title, String task) {
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("android_id", "android_name", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), "android_id")
                .setContentTitle(title)
                .setContentText(task)
                .setSmallIcon(R.mipmap.ic_launcher);

        notificationManager.notify(1, notification.build());
    }

    private Data sendDataToUI(String key, String value){
        Data data=new Data.Builder().putString(key,value).build();
        return data;

    }
}
