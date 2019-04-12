package com.example.yfsl.rxpickertopickpicture;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.caimuhao.rxpicker.RxPicker;
import com.caimuhao.rxpicker.bean.ImageItem;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {
    private Button picture_btn;
    private RecyclerView recyclerView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        picture_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onClick(View v) {
                RxPicker.init(new GlideImageLoader());
                RxPicker.of()
                        .single(false)
                        .limit(3,9)
                        .start(MainActivity.this)
                        .subscribe(new Consumer<List<ImageItem>>() {
                            @Override
                            public void accept(List<ImageItem> imageItems) throws Exception {
                                Log.e("TAG","照片选择完成");
                                recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//                                recyclerView.getRecycledViewPool().setMaxRecycledViews(0,10);
                                Log.e("TAG","recyclerview布局已设置");
                                PictureAdapter pictureAdapter = new PictureAdapter(imageItems,mContext);
                                Log.e("TAG","imageItems为:"+imageItems);
                                recyclerView.setAdapter(pictureAdapter);
                                Log.e("TAG","适配器已设置");
                            }
                        });
            }
        });
    }

    private void initView() {
        picture_btn = findViewById(R.id.picture_btn);
        recyclerView = findViewById(R.id.showPic_rv);
    }
}
