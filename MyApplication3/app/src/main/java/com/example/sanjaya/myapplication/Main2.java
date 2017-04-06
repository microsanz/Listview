package com.example.sanjaya.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by sanjaya on 4/5/2017.
 */

public class Main2 extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerAdapter mRecyclerAdapter ;
    private ArrayList<Barang> barangList;
    private GridLayoutManager mGridLayoutManager;
    private ImageButton switchGrid;
    @Override
    protected void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        setContentView(R.layout.activity2);
        mRecycleView = (RecyclerView) findViewById(R.id.recyclerView1);
        switchGrid=(ImageButton) findViewById(R.id.switchGrid);
        mGridLayoutManager = new GridLayoutManager(this, 2);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLinearLayoutManager);


         barangList= new ArrayList<Barang>();

        barangList.add(new

                Barang(R.drawable.apple_iphone_7_plus_01, "Apple Iphone 7 Plus", "930", "€930"));
        barangList.add(new

                Barang(R.drawable.htc_u_ultra_2, "HTC U Ultra", "720", "€720"));
        barangList.add(new

                Barang(R.drawable.lg_g6_1, "LG G6", "750", "€750"));
        barangList.add(new

                Barang(R.drawable.nokia_6_5, "Nokia 6", "230", "€230"));
        barangList.add(new

                Barang(R.drawable.samsung_galaxy_s8_plus_, "Samsung Galaxy S8 Plus", "900", "€900"));
        barangList.add(new

                Barang(R.drawable.sony_xperia_xz_premium_2017_0, "Sony Xperia XZ Premium 2017", "740", "€740"));

        mRecyclerAdapter = new RecyclerAdapter(barangList,this);
        mRecycleView.setAdapter(mRecyclerAdapter);
        setRecyclerViewScrollListener();
        setRecyclerViewItemTouchListener();

        switchGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLayoutManager();
            }
        });

    }
    private int getLastVisibleItemPosition() {
        return mLinearLayoutManager.findLastVisibleItemPosition();
    }
    private void setRecyclerViewScrollListener() {
        mRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int totalItemCount = mRecycleView.getLayoutManager().getItemCount();
                //if (!mImageRequester.isLoadingData() && totalItemCount == getLastVisibleItemPosition() + 1) {
                  //  requestPhoto();
                //}
            }
        });
    }
    private void setRecyclerViewItemTouchListener() {

        //1
        ItemTouchHelper.SimpleCallback itemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder1) {
                //2
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                //3
                int position = viewHolder.getAdapterPosition();
                barangList.remove(position);
                mRecycleView.getAdapter().notifyItemRemoved(position);
            }
        };

        //4
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecycleView);
    }
    private void changeLayoutManager() {
        if (mRecycleView.getLayoutManager().equals(mLinearLayoutManager)) {
            mRecycleView.setLayoutManager(mGridLayoutManager);
        } else {
            mRecycleView.setLayoutManager(mLinearLayoutManager);
        }
    }
}
