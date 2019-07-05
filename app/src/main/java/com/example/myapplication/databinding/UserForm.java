package com.example.myapplication.databinding;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.bumptech.glide.Glide;

import java.io.Serializable;

public class UserForm extends BaseObservable implements Serializable {

    private int id;
    private String userName;
    private String gender;
    private String qualification;
    private String imageUrl;

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        notifyPropertyChanged(BR.gender);
    }

    @Bindable
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
        notifyPropertyChanged(BR.qualification);
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
    }

    @BindingAdapter("android:formImage")
    public static void setImageUrl(ImageView view,String imageUrl){
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", qualification='" + qualification + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }


    public boolean isUserFormValidate(Context context){

        if (TextUtils.isEmpty(this.userName)){
            Toast.makeText(context, " Please Enter username", Toast.LENGTH_SHORT).show();
            return false;
        }else if (TextUtils.isEmpty(this.gender)){
            Toast.makeText(context, " Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        }else if (TextUtils.isEmpty(this.qualification) || this.qualification.equalsIgnoreCase("select-qualification")){
            Toast.makeText(context, " Please Select Qualification", Toast.LENGTH_SHORT).show();
            return false;
        }else if (TextUtils.isEmpty(this.imageUrl)){
            Toast.makeText(context, "Please Upload Image", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
