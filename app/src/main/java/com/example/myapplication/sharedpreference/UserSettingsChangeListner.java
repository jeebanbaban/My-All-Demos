package com.example.myapplication.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class UserSettingsChangeListner implements SharedPreferences.OnSharedPreferenceChangeListener{

    private Context context;

    public UserSettingsChangeListner(Context context) {
        this.context=context;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        System.out.println("################# onSharedPreferenceChanged ######################");
        System.out.println("key=="+key);
        try {
            System.out.println("value=="+sharedPreferences.getString(key,""));
        }catch(ClassCastException e) {
            System.out.println("exeption=="+String.valueOf(sharedPreferences.getAll().get(key)));
        }
        System.out.println("################# onSharedPreferenceChanged ######################");
    }
}
