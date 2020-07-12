package com.glumy.windplast;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private TextView tv_number_calc, tv_name, tv_address, tv_comment, tv_date, tv_cost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_calculations);

        InitComponent();

        Date date = new Date();
        long millis = date.getTime();

        ArrayList<Storage> storageArrayList = new ArrayList<>();
        ActivityProductDetails apd = new ActivityProductDetails();

        //image_recycler.setImageResource(apd.getMainImage());

       // storageArrayList.add(ActivityOrderResult.class.getClass());

        storageArrayList.add(new Storage(R.drawable.bb, 1, "Глухое окно","Адрес", "Комментарий", Tools.getFormattedDate(millis), "2000 грн"));
        storageArrayList.add(new Storage(R.drawable.four,  2, "Глухое окно","Адрес", "Комментарий", Tools.getFormattedDate(millis), "3000 грн"));
        storageArrayList.add(new Storage(R.drawable.deaf,  3, "Глухое окно","Адрес", "Комментарий", Tools.getFormattedDate(millis), "1000 грн"));
        storageArrayList.add(new Storage(R.drawable.bb,  4, "Глухое окно","Адрес", "Комментарий", Tools.getFormattedDate(millis), "2000 грн"));
        storageArrayList.add(new Storage(R.drawable.four, 5, "Глухое окно","Адрес", "Комментарий", Tools.getFormattedDate(millis), "3000 грн"));
        storageArrayList.add(new Storage(R.drawable.deaf, 6, "Глухое окно","Адрес", "Комментарий", Tools.getFormattedDate(millis), "1000 грн"));
        storageArrayList.add(new Storage(R.drawable.bb, 7, "Глухое окно","Адрес", "Комментарий", Tools.getFormattedDate(millis), "2000 грн"));
        storageArrayList.add(new Storage(R.drawable.four, 8, "Глухое окно","Адрес", "Комментарий", Tools.getFormattedDate(millis), "3000 грн"));
        storageArrayList.add(new Storage(R.drawable.deaf, 9, "Глухое окно","Адрес", "Комментарий", Tools.getFormattedDate(millis), "1000 грн"));
        storageArrayList.add(new Storage(R.drawable.bb, 10, "Глухое окно","Адрес", "Комментарий", Tools.getFormattedDate(millis), "2000 грн"));
        storageArrayList.add(new Storage(R.drawable.four, 11, "Глухое окно","Адрес", "Комментарий", Tools.getFormattedDate(millis), "3000 грн"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new AdapterStorageCalculations(storageArrayList);

        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void InitComponent() {

        image_recycler = findViewById(R.id.image_product);
        tv_number_calc = findViewById(R.id.tv_calcnumber);
        tv_name = findViewById(R.id.tv_product_name);
        tv_address = findViewById(R.id.tv_address);
        tv_comment = findViewById(R.id.tv_comment);
        tv_date = findViewById(R.id.tv_date);
        tv_cost = findViewById(R.id.tv_cost);
        image_arrow_back = findViewById(R.id.image_arrow_back);

    }

    public void onClickForStorage(View view) {

        switch (view.getId()) {

            case R.id.image_arrow_back:
                super.onBackPressed();

                break;

        }
    }
}