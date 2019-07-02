package com.example.myapplication.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.android.databinding.library.baseAdapters.BR;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.Serializable;

public class User extends BaseObservable {

    private String name;
    private String image;
    private String about;

    public ObservableField<String> salary=new ObservableField<>();
    public ObservableField<String> expense=new ObservableField<>();
    public ObservableField<String> savings=new ObservableField<>();


    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @BindingAdapter({"android:srcCompat"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(view);
    }

    @Bindable
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
        notifyPropertyChanged(BR.image);
    }

    @Bindable
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
        notifyPropertyChanged(BR.about);
    }

    public ObservableField<String> getSalary() {
        return salary;
    }

    public ObservableField<String> getExpense() {
        return expense;
    }

    public ObservableField<String> getSavings() {
        return savings;
    }
}
