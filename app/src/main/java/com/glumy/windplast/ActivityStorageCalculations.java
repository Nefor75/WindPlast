package com.glumy.windplast;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.glumy.windplast.Cart.OrderResult;
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

        Bundle recivedData = getIntent().getExtras();
        final OrderResult setActivity;
        if (recivedData != null) {
            setActivity = (OrderResult) recivedData.getSerializable(OrderResult.class.getSimpleName());
            assert setActivity != null;

            TextView tv_address = findViewById(R.id.tv_address);
            tv_address.setText(setActivity.getAddress());

            TextView tv_comment = findViewById(R.id.tv_comment);
            tv_comment.setText(setActivity.getComment());
        }

        InitComponent();

        Date date = new Date();
        long millis = date.getTime();

        ArrayList<Storage> storageArrayList = new ArrayList<>();

        //  String str = et_address.getText().toString().trim();

        storageArrayList.add(new Storage(R.drawable.bb, 1, getResources().getString(R.string.balkon),"", "", Tools.getFormattedDate(millis), "2000 грн"));
        storageArrayList.add(new Storage(R.drawable.four,  2, getResources().getString(R.string.four),"", "", Tools.getFormattedDate(millis), "3000 грн"));
        storageArrayList.add(new Storage(R.drawable.deaf,  3, getResources().getString(R.string.deaf),"", "", Tools.getFormattedDate(millis), "1000 грн"));
        storageArrayList.add(new Storage(R.drawable.bb,  4, getResources().getString(R.string.balkon),"", "", Tools.getFormattedDate(millis), "2000 грн"));
        storageArrayList.add(new Storage(R.drawable.four, 5, getResources().getString(R.string.four),"", "", Tools.getFormattedDate(millis), "3000 грн"));
        storageArrayList.add(new Storage(R.drawable.deaf, 6, getResources().getString(R.string.deaf),"", "", Tools.getFormattedDate(millis), "1000 грн"));
        storageArrayList.add(new Storage(R.drawable.bb, 7, getResources().getString(R.string.balkon),"", "", Tools.getFormattedDate(millis), "2000 грн"));
        storageArrayList.add(new Storage(R.drawable.four, 8, getResources().getString(R.string.four),"", "", Tools.getFormattedDate(millis), "3000 грн"));
        storageArrayList.add(new Storage(R.drawable.deaf, 9, getResources().getString(R.string.deaf),"", "", Tools.getFormattedDate(millis), "1000 грн"));
        storageArrayList.add(new Storage(R.drawable.bb, 10, getResources().getString(R.string.balkon),"", "", Tools.getFormattedDate(millis), "2000 грн"));
        storageArrayList.add(new Storage(R.drawable.four, 11, getResources().getString(R.string.four),"", "", Tools.getFormattedDate(millis), "3000 грн"));

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