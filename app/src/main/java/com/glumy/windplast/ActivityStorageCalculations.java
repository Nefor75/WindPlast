package com.glumy.windplast;

import android.content.Context;
import android.content.DialogInterface;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.glumy.windplast.Cart.Storage;

import com.glumy.windplast.data.AdapterStorageCalculations;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Toast;

import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.List;


public class ActivityStorageCalculations extends AppCompatActivity {

    private RecyclerView recyclerView;
    AdapterStorageCalculations adapter;

    private List<Storage> items = new ArrayList<>();
    private int image;
    private int number;
    private int cost;
    private String str_name;
    private String str_address;
    private String str_comments;
    private String str_date2;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_calculations);

        initToolbar();

        Bundle reciveToStorage = getIntent().getExtras();
        final Storage setActivity;
        if (reciveToStorage != null) {
            setActivity = (Storage) reciveToStorage.getSerializable(Storage.class.getSimpleName());
            assert setActivity != null;

            image = setActivity.getImage();
            // number = setActivity.getNumber();
            str_name = setActivity.getName();
            str_address = setActivity.getAddress();
            str_comments = setActivity.getComment();
            str_date2 = setActivity.getDate();
            cost = setActivity.getCost();

            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            items = getListFromLocal("SaveStorage");
            number = items.size() + 1;

            adapter = new AdapterStorageCalculations(this, items);
            recyclerView.setAdapter(adapter);

            items.add(new Storage(image, number, str_name, str_address, str_comments, str_date2, cost));

            saveListInLocal(items, "SaveStorage");

        }else {
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            items = getListFromLocal("SaveStorage");
            if (items.size()!=0) {
                adapter = new AdapterStorageCalculations(this, items);
                recyclerView.setAdapter(adapter);
            }else {
                showNoItemView();
            }
        }
    }

    private void initToolbar() {
        ActionBar actionBar;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle(R.string.myCalc);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_storage_calculations, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id = item.getItemId();
        if (item_id == android.R.id.home) {

            Intent i = new Intent(this, ActivityMain.class);
            startActivity(i);
            //super.onBackPressed();
        } else if (item_id == R.id.action_delete) {
            if (items.size() == 0) {
                Toast toast = Toast.makeText(getApplicationContext(), "Здесь и так ничего нет", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            } else {
                dialogDeleteConfirmation();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void showNoItemView() {
        View lyt_no_item = (View) findViewById(R.id.lyt_no_item);
        if (items.size() == 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Расчетов нет", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            lyt_no_item.setVisibility(View.VISIBLE);
        } else {
            lyt_no_item.setVisibility(View.GONE);
        }
    }

    public void dialogDeleteConfirmation() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title_delete_confirm);
        builder.setMessage(getString(R.string.content_delete_confirm));
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface di, int i) {
                di.dismiss();
                resetListData();
                showNoItemView();

            }
        });
        builder.setNegativeButton("Нет", null);
        builder.show();
    }

    public void saveListInLocal(List<Storage> list, String key) {
        prefs = getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
        //Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();
    }

    public List<Storage> getListFromLocal(String key) {
        prefs = getSharedPreferences(key, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        if (json != null) {
            Type type = new TypeToken<List<Storage>>() {
            }.getType();
            Snackbar.make(findViewById(android.R.id.content), "Данные загружены", Snackbar.LENGTH_LONG).show();
            //Toast.makeText(this, "Данные загружены", Toast.LENGTH_LONG).show();

            return gson.fromJson(json, type);
        } else {
            return new ArrayList<>();
        }
    }

    public void resetListData() {
        prefs = getSharedPreferences("SaveStorage", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();

        items.clear();
        adapter.notifyDataSetChanged();

    }
}
