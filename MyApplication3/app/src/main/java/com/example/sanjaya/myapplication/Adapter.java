package com.example.sanjaya.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sanjaya on 4/4/2017.
 */

public class Adapter extends ArrayAdapter<String> {
    private final Activity context;
    private String[] judul, keterangan;
    private int[] uri;

    public Adapter(Activity context,int[] uri, String[] judul, String[]keterangan){
        super(context,R.layout.item);
        this.context = context;
        this.uri = uri;
        this.judul=judul;
        this.keterangan=keterangan;
    }

    static class ViewHolder{
        public ImageView image;
        public TextView judul,keterangan;
    }
    @Override
    public int getCount() {
        return keterangan.length;
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
            rowView = inflater.inflate(R.layout.item, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) rowView.findViewById(R.id.gambar);
            viewHolder.judul = (TextView) rowView.findViewById(R.id.judul);
            viewHolder.keterangan= (TextView) rowView.findViewById(R.id.keterangan);

            rowView.setTag(viewHolder);
        }else{
            holder = (ViewHolder) rowView.getTag();
        }
        holder = (ViewHolder) rowView.getTag();
        int[] uri=this.uri;
        String[] judul=this.judul,keterangan=this.keterangan;
        holder.image.setImageResource(uri[position]);
        holder.judul.setText(judul[position]);
        holder.keterangan.setText(keterangan[position]);
        return rowView;
    }
}
