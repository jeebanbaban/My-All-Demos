package com.example.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //public static final String BASE_URL="http://206.189.45.61:3000";  alumna jeeban

        //    public static final String BASE_URL="http:174.138.122.221"; both
    }

    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btnLogin:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
        }
    }
}
