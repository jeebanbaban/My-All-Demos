package com.example.myapplication.databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class FormActivity extends AppCompatActivity {

    private ActivityFormBinding binding;
    private UserForm userForm;
    private String imageUrl="http://www.sclance.com/pngs/small-png/small_png_1255715.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_form);
        binding= DataBindingUtil.setContentView(FormActivity.this,R.layout.activity_form);
        userForm=new UserForm();

        binding.rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbMale:
                        userForm.setGender("Male");
                        break;

                    case R.id.rbFemale:
                        userForm.setGender("Female");
                        break;
                }
            }
        });



        binding.btnUploadImage.setOnClickListener((view) -> {
            //binding.imvPhoto.setImageURI(Uri.parse(imageUrl));
            Glide.with(view.getContext())
                    .load(imageUrl)
                    .into(binding.imvPhoto);
            userForm.setImageUrl(imageUrl);
        });


        binding.btnSubmit.setOnClickListener((view) -> {
            userForm.setUserName(binding.etUserName.getText().toString());
            userForm.setQualification(String.valueOf(binding.spQualification.getSelectedItem()));

            if (userForm.isUserFormValidate(getApplicationContext())){
                Intent intent = new Intent(FormActivity.this, ViewFormActivity.class);
                intent.putExtra("USER_FORM_DATA", userForm);
                startActivity(intent);
            }else {
                Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show();
            }



        });

    }


}
