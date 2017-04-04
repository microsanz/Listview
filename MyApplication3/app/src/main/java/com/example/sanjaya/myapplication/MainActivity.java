package com.example.sanjaya.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        listView1=(ListView) findViewById(R.id.listView1);
        String[] judul={
                "Apple Iphone 7 Plus",
                "HTC U Ultra 2",
                "LG G6",
                "Nokia 6",
                "Samsung Galaxy S8 Plus",
                "Sony Xperia ZX Premium"
        };
        String[] keterangan={
                "AI7P",
                "HUU2",
                "LG6",
                "NO6",
                "SGS8P",
                "SXZXP"
        };
        int[] uri={
                R.drawable.apple_iphone_7_plus_01,
                R.drawable.htc_u_ultra_2,
                R.drawable.lg_g6_1,
                R.drawable.nokia_6_5,
                R.drawable.samsung_galaxy_s8_plus_,
                R.drawable.sony_xperia_xz_premium_2017_0
        };
        Adapter adapter=new Adapter(this,uri,judul,keterangan);
        listView1.setAdapter(adapter);


    }
}
