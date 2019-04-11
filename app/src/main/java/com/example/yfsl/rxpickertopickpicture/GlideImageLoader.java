package com.example.yfsl.rxpickertopickpicture;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.caimuhao.rxpicker.utils.RxPickerImageLoader;

public class GlideImageLoader implements RxPickerImageLoader {
    @Override
    public void display(ImageView imageView, String path, int width, int height) {
        Glide.with(imageView.getContext())
                .load(path)
                .centerCrop()
                .override(width,height)
                .into(imageView);
    }
}
