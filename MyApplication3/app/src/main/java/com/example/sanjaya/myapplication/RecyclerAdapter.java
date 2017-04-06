package com.example.sanjaya.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.BarangHolder> {
    private ArrayList<Barang> barang=new ArrayList<Barang>();
    private Context context;

    public RecyclerAdapter(ArrayList<Barang> barang,Context context){
        this.barang=barang;
        this.context=context;
    }

    @Override
    public BarangHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new BarangHolder(inflate);
    }

    @Override
    public void onBindViewHolder(BarangHolder holder, int position) {
        Barang barang = this.barang.get(position);
        holder.bindHolder(barang);
    }

    @Override
    public int getItemCount() {
        return barang.size();
    }


    class BarangHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView image;
        private TextView judul,keterangan;

        public BarangHolder(View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.gambar);
            judul=(TextView) itemView.findViewById(R.id.judul);
            keterangan=(TextView) itemView.findViewById(R.id.keterangan);
            itemView.setOnClickListener(this);
        }
        public void bindHolder(Barang barang){
            image.setImageResource(barang.getUri());
            judul.setText(barang.getJudul());
            keterangan.setText(barang.getHargaSimbol());
        }

        @Override
        public void onClick(View v) {
            int a = getLayoutPosition();
            Context context=itemView.getContext();
            Intent newIntent = new Intent(context,Viewitem.class);
            newIntent.putExtra("image",barang.get(a).getUri());
            newIntent.putExtra("judul",barang.get(a).getJudul());
            newIntent.putExtra("keterangan",barang.get(a).getHargaSimbol());
            context.startActivity(newIntent);
        }
    }
}
