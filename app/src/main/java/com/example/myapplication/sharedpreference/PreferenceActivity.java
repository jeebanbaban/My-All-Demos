package com.example.myapplication.sharedpreference;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class PreferenceActivity extends AppCompatActivity {

    private UserSettingsChangeListner listner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
    }

    public void onSettingsClick(View view) {
        listner=new UserSettingsChangeListner(getApplicationContext());
        startActivity(new Intent(PreferenceActivity.this,SettingsActivity.class));
        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).registerOnSharedPreferenceChangeListener(listner);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).unregisterOnSharedPreferenceChangeListener(listner);
    }
}
