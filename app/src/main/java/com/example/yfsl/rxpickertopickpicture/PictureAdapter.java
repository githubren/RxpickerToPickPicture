package com.example.yfsl.rxpickertopickpicture;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.caimuhao.rxpicker.bean.ImageItem;

import java.util.List;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {
    private List<ImageItem> imageItems;
    private Context mContext;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView showPicitem_iv;

        public ViewHolder(View itemView) {
            super(itemView);
            showPicitem_iv = itemView.findViewById(R.id.showPicitem_iv);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_showpicture,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.e("TAG","onBindViewHolder被调用");
        Glide.with(holder.showPicitem_iv.getContext())
                .load(imageItems.get(position).getPath())
                .into(holder.showPicitem_iv);
        Log.e("TAG","Path为："+imageItems.get(position).getPath());
        Log.e("TAG","展示在："+holder.showPicitem_iv);
    }

    @Override
    public int getItemCount() {
        return imageItems.size();
    }

    public PictureAdapter(List<ImageItem> imageItems, Context mContext) {
        this.imageItems = imageItems;
        this.mContext = mContext;
    }
}
