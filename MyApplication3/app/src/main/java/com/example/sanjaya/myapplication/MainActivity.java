package com.example.sanjaya.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListView listView1;
    RelativeLayout pilihLayout,pilihFilter;
    ImageButton switchGrid;
    GridView gridView;
    int pilihan=0;
    int visibility=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final Context context=this;
        Adapter adapter;
        listView1=(ListView) findViewById(R.id.listView1);
        pilihLayout=(RelativeLayout)findViewById(R.id.pilihlayout);
        switchGrid=(ImageButton)findViewById(R.id.switchGrid);
        gridView=(GridView) findViewById(R.id.gridView1);
        pilihFilter=(RelativeLayout)findViewById(R.id.pilihfilter);

        final ArrayList<Barang> barangList= new ArrayList<Barang>();
        barangList.add(new Barang(R.drawable.apple_iphone_7_plus_01,"Apple Iphone 7 Plus","930","€930"));
        barangList.add(new Barang(R.drawable.htc_u_ultra_2,"HTC U Ultra","720","€720"));
        barangList.add(new Barang(R.drawable.lg_g6_1,"LG G6","750","€750"));
        barangList.add(new Barang(R.drawable.nokia_6_5,"Nokia 6","230","€230"));
        barangList.add(new Barang(R.drawable.samsung_galaxy_s8_plus_,"Samsung Galaxy S8 Plus","900","€900"));
        barangList.add(new Barang(R.drawable.sony_xperia_xz_premium_2017_0,"Sony Xperia XZ Premium 2017","740","€740"));




        adapter=new Adapter(this,barangList,R.layout.item);
        listView1.setAdapter(adapter);
        adapter=new Adapter(this,barangList,R.layout.item_grid);
        gridView.setAdapter(adapter);
        pilihLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final Dialog dialog=new Dialog(context);
                dialog.setContentView(R.layout.urutkan);
                dialog.setTitle("Berdasarkan");
                RelativeLayout hargaRendahTinggi = (RelativeLayout) dialog.findViewById(R.id.hargaRendahTinggi);
                RelativeLayout hargaTinggiRendah = (RelativeLayout) dialog.findViewById(R.id.hargaTinggiRendah);
                RelativeLayout nama = (RelativeLayout) dialog.findViewById(R.id.nama);
                hargaRendahTinggi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Collections.sort(barangList,new Comparator<Barang>(){
                            @Override
                            public int compare(Barang barang1,Barang barang2){
                                return barang1.getHarga().compareTo(barang2.getHarga());
                            }
                        });
                        Adapter adapter =new Adapter(MainActivity.this,barangList,R.layout.item);
                        listView1.setAdapter(adapter);
                        adapter=new Adapter(MainActivity.this,barangList,R.layout.item_grid);
                        gridView.setAdapter(adapter);
                        dialog.dismiss();
                    }
                });
                hargaTinggiRendah.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Collections.sort(barangList,new Comparator<Barang>(){
                            @Override
                            public int compare(Barang barang2,Barang barang1){
                                return barang1.getHarga().compareTo(barang2.getHarga());
                            }
                        });
                        Adapter adapter =new Adapter(MainActivity.this,barangList,R.layout.item);
                        listView1.setAdapter(adapter);
                        adapter=new Adapter(MainActivity.this,barangList,R.layout.item_grid);
                        gridView.setAdapter(adapter);
                        dialog.dismiss();
                    }
                });
                nama.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Collections.sort(barangList,new Comparator<Barang>(){
                            @Override
                            public int compare(Barang barang1,Barang barang2){
                                return barang1.getJudul().compareTo(barang2.getJudul());
                            }
                        });
                        Adapter adapter =new Adapter(MainActivity.this,barangList,R.layout.item);
                        listView1.setAdapter(adapter);
                        adapter=new Adapter(MainActivity.this,barangList,R.layout.item_grid);
                        gridView.setAdapter(adapter);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        switchGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.this.visibility==0){
                    listView1.setVisibility(View.GONE);
                    gridView.setVisibility(View.VISIBLE);
                    MainActivity.this.visibility=1;
                }else{
                    listView1.setVisibility(View.VISIBLE);
                    gridView.setVisibility(View.GONE);
                    MainActivity.this.visibility=0;
                }
            }
        });
        pilihFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                builder1.setTitle("Pilih filter.");
                final String[] pilihan = new String[]{
                        "Harga rendah - tinggi",
                        "Harga tinggi - rendah",
                        "Nama"
                };
                builder1.setCancelable(true);
                builder1.setSingleChoiceItems(pilihan, MainActivity.this.pilihan, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.pilihan=which;
                        if(which==0){
                            Collections.sort(barangList,new Comparator<Barang>(){
                                @Override
                                public int compare(Barang barang1,Barang barang2){
                                    return barang1.getHarga().compareTo(barang2.getHarga());
                                }
                            });
                            Adapter adapter =new Adapter(MainActivity.this,barangList,R.layout.item);
                            listView1.setAdapter(adapter);
                            adapter=new Adapter(MainActivity.this,barangList,R.layout.item_grid);
                            gridView.setAdapter(adapter);
                            dialog.dismiss();
                        }else if(which==1){
                            Collections.sort(barangList,new Comparator<Barang>(){
                                @Override
                                public int compare(Barang barang2,Barang barang1){
                                    return barang1.getHarga().compareTo(barang2.getHarga());
                                }
                            });
                            Adapter adapter =new Adapter(MainActivity.this,barangList,R.layout.item);
                            listView1.setAdapter(adapter);
                            adapter=new Adapter(MainActivity.this,barangList,R.layout.item_grid);
                            gridView.setAdapter(adapter);
                            dialog.dismiss();
                        }else if(which==2){
                            Collections.sort(barangList,new Comparator<Barang>(){
                                @Override
                                public int compare(Barang barang1,Barang barang2){
                                    return barang1.getJudul().compareTo(barang2.getJudul());
                                }
                            });
                            Adapter adapter =new Adapter(MainActivity.this,barangList,R.layout.item);
                            listView1.setAdapter(adapter);
                            adapter=new Adapter(MainActivity.this,barangList,R.layout.item_grid);
                            gridView.setAdapter(adapter);
                            dialog.dismiss();
                        }
                    }
                });
                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
    }


}
