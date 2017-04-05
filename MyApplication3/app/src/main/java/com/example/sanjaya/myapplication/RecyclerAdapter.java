package com.example.sanjaya.myapplication;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sanjaya on 4/5/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>{
    private Activity context;
    private ArrayList<Barang> barang;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null);
        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Barang barang=this.barang.get(position);
    }

    @Override
    public int getItemCount() {
        barang.size();
    }
//    class CustomViewHolder extends RecyclerView.ViewHolder {
//        protected ImageView imageView;
//        protected TextView textView;
//
//        public CustomViewHolder(View view) {
//            super(view);
//            this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
//            this.textView = (TextView) view.findViewById(R.id.title);
//        }
//    }
}
