package com.example.sanjaya.myapplication;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sanjaya on 4/6/2017.
 */

public class Viewitem extends AppCompatActivity{
    ImageView image;
    TextView judul, keterangan;

    @Override
    public void onCreate(Bundle viewSavedState){
        super.onCreate(viewSavedState);
        setContentView(R.layout.viewitem);
        image = (ImageView) findViewById(R.id.gambarDetail);
        judul=(TextView) findViewById(R.id.judulDetail);
        keterangan=(TextView) findViewById((R.id.keteranganDetail));

        image.setImageResource(getIntent().getIntExtra("image",0));
        judul.setText(getIntent().getStringExtra("judul"));
        keterangan.setText(getIntent().getStringExtra("keterangan"));


    }
}
