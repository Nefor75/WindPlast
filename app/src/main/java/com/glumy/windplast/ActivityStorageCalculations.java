package com.glumy.windplast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.glumy.windplast.Cart.Cart;
import com.glumy.windplast.Cart.Storage;
import com.glumy.windplast.data.AdapterStorageCalculations;
import com.glumy.windplast.util.Tools;

import java.util.ArrayList;
import java.util.Date;

public class ActivityStorageCalculations extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mlayoutManager;
    private RecyclerView.Adapter mAdapter;

    private ImageView image_recycler, image_arrow_back;
    private TextView tv_date, tv_cost;
    private LinearLayout ll_item_recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_calculations);

        InitComponent();

        Date date = new Date();
        long millis = date.getTime();


        ArrayList<Storage> storageArrayList = new ArrayList<>();
        storageArrayList.add(new Storage(R.drawable.deaf, Tools.getFormattedDate(millis), "1000 грн"));
        storageArrayList.add(new Storage(R.drawable.bb, Tools.getFormattedDate(millis), "2000 грн"));
        storageArrayList.add(new Storage(R.drawable.four, Tools.getFormattedDate(millis), "3000 грн"));
        storageArrayList.add(new Storage(R.drawable.deaf, Tools.getFormattedDate(millis), "1000 грн"));
        storageArrayList.add(new Storage(R.drawable.bb, Tools.getFormattedDate(millis), "2000 грн"));
        storageArrayList.add(new Storage(R.drawable.four, Tools.getFormattedDate(millis), "3000 грн"));
        storageArrayList.add(new Storage(R.drawable.deaf, Tools.getFormattedDate(millis), "1000 грн"));
        storageArrayList.add(new Storage(R.drawable.bb, Tools.getFormattedDate(millis), "2000 грн"));
        storageArrayList.add(new Storage(R.drawable.four, Tools.getFormattedDate(millis), "3000 грн"));
        storageArrayList.add(new Storage(R.drawable.deaf, Tools.getFormattedDate(millis), "1000 грн"));
        storageArrayList.add(new Storage(R.drawable.bb, Tools.getFormattedDate(millis), "2000 грн"));
        storageArrayList.add(new Storage(R.drawable.four, Tools.getFormattedDate(millis), "3000 грн"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new AdapterStorageCalculations(storageArrayList);

        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void InitComponent() {

        image_recycler = findViewById(R.id.image_product);
        tv_date = findViewById(R.id.tv_date);
        tv_cost = findViewById(R.id.tv_cost);
        image_arrow_back = findViewById(R.id.image_arrow_back);
        ll_item_recycler = findViewById(R.id.ll_item_recycler);
    }

    public void onClickForStorage(View view) {

        switch (view.getId()) {

            case R.id.image_arrow_back:
                super.onBackPressed();
                break;

            case R.id.ll_item_recycler:

                break;
        }
    }
}