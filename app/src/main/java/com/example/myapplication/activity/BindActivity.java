package com.example.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.util.Util;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityBindBinding;
import com.example.myapplication.interfaces.DataInterface;
import com.example.myapplication.model.Student;
import com.example.myapplication.utils.AllMethods;

public class BindActivity extends AppCompatActivity implements DataInterface{

    private ActivityBindBinding binding;
    private Student student;
    private String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_bind);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_bind);
        imageUrl="http://www.sclance.com/pngs/small-png/small_png_1255715.jpg";
        student=new Student();

        student.setName("Jeeban Bagdi");
        student.setStream("Computer Science");
        student.setRollNo("15800112008");
        student.setImageUrl(imageUrl);

        binding.setStudent(student);
        binding.setData(this);

    }

    @Override
    public void sendData(View view,Student student) {
        Toast.makeText(this, "name= "+student.getName() +" "+"stream= "+student.getStream(), Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btnChangeActivity:

                break;
        }
    }
}
