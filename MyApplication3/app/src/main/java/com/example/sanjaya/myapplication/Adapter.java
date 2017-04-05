package com.example.sanjaya.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjaya on 4/4/2017.
 */

public class Adapter extends ArrayAdapter<String> {
    private final Activity context;
    private ArrayList<Barang> barang;
    int layout=R.layout.item;

    public Adapter(Activity context,ArrayList<Barang> barang,int layout){
        super(context,layout);
        this.context = context;
        this.barang=barang;
        this.layout=layout;
    }

    static class ViewHolder{
        public ImageView image;
        public TextView judul,keterangan;
    }
    @Override
    public int getCount() {
        return barang.size();
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View rowView=convertView;
        if(rowView==null){
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(layout, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) rowView.findViewById(R.id.gambar);
            viewHolder.judul = (TextView) rowView.findViewById(R.id.judul);
            viewHolder.keterangan= (TextView) rowView.findViewById(R.id.keterangan);

            rowView.setTag(viewHolder);
        }else{
            holder = (ViewHolder) rowView.getTag();
        }
        holder = (ViewHolder) rowView.getTag();
        holder.image.setImageResource(barang.get(position).getUri());
        holder.judul.setText(barang.get(position).getJudul());
        holder.keterangan.setText(barang.get(position).getHargaSimbol());
        return rowView;
    }
}
