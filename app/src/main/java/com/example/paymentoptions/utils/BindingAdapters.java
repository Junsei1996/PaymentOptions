package com.example.paymentoptions.utils;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class BindingAdapters {

    @BindingAdapter("ImageLink")
    public static void setImage(ImageView v, String link) {
        Glide.with(v).load(link).into(v);
    }

    @BindingAdapter({"label", "code"})
    public static void setLabel(TextView v, String label, String code) {

        v.setText(label + " (" + code + ")");

    }

}
