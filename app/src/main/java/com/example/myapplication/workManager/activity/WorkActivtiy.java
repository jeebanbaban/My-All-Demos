package com.example.myapplication.workManager.activity;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityRecycleViewBinding;
import com.example.myapplication.databinding.ActivityWorkActivtiyBinding;
import com.example.myapplication.workManager.workers.NotificationWorker;

import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;

import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

public class WorkActivtiy extends AppCompatActivity {

    private ActivityWorkActivtiyBinding binding;
    private OneTimeWorkRequest workRequest;
    private PeriodicWorkRequest periodicWorkRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_work_activtiy);

        Data data=new Data.Builder().putString(NotificationWorker.TASK_TITLE_KEY,"TITLE")
                .putString(NotificationWorker.TASK_DATA_KEY,"This is the data").build();

        workRequest=new OneTimeWorkRequest.Builder(NotificationWorker.class).setInputData(data).build();
        periodicWorkRequest=new PeriodicWorkRequest.Builder(NotificationWorker.class,15, TimeUnit.MINUTES).build();

    }

    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btnStartwork:
                WorkManager.getInstance().enqueue(periodicWorkRequest);
                //WorkManager.getInstance().enqueueUniquePeriodicWork("WorkActivity", ExistingPeriodicWorkPolicy.REPLACE,periodicWorkRequest);
                getWorkStatus();
                break;
        }
    }

    private void getWorkStatus() {

        WorkManager.getInstance().getWorkInfoByIdLiveData(periodicWorkRequest.getId()).observeForever(new Observer<WorkInfo>() {
            @Override
            public void onChanged(@Nullable WorkInfo workInfo) {

                System.out.println("status================="+workInfo.getState().name());
                binding.tvWorkStatus.setText(workInfo.getState().name() + "\n");

                /*if (workInfo.getState().isFinished())
                System.out.println("WORK FINISH============");
*/
                if (null!= workInfo.getOutputData()){
                    String data = workInfo.getOutputData().getString(NotificationWorker.TASK_DATA_KEY);
                    System.out.println("data================"+data);
                }
            }
        });
    }
}
