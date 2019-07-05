package com.example.myapplication.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.R;

public class ViewFormActivity extends AppCompatActivity {

    private ActivityViewFormBinding binding;
    private UserForm userForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_form);
        binding= DataBindingUtil.setContentView(ViewFormActivity.this,R.layout.activity_view_form);

        userForm=new UserForm();
        userForm=(UserForm) getIntent().getSerializableExtra("USER_FORM_DATA");
        binding.setUserform(userForm);

    }
}
