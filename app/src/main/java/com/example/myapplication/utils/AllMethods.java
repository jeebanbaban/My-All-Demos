package com.example.myapplication.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class AllMethods {

    public static final String profileImage="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-jluBcKgjHWKN6xVc---SGE7FqGw4WpVndPjLboJe-eGzwCAr";
    public static final String imageUrl1="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRLMcoEjMuhYn2hwPdt94UxpbQsnpXwKYmosLlpvH1a-HCwQrb";
    public static final String imageUrl2="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqsGpAO6MTEGDw40PCUrdmxaNIRQyzR6tQ_rDwr1DzedLVCHuf";



   /* @BindingAdapter({"android:src"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }*/

    /*@BindingAdapter({"android:src"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(view);
    }*/

    /*@BindingAdapter({"android:src"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }*/
}
