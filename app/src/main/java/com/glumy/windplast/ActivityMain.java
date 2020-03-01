package com.glumy.windplast;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;



public class ActivityMain extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ActionBar actionBar;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initToolbar();
      //  initFragment();
//        // launch instruction when first launch
//        if (sharedPref.isFirstLaunch()) {
//            startActivity(new Intent(this, ActivityInstruction.class));
//            sharedPref.setFirstLaunch(false);
//        }
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);//не отображается title слева
        toolbar.setNavigationIcon(R.drawable.icon_toolbar100);
        initSpinner();

    }

    private void initSpinner() {
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.spinner_menu, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //spinner.setSelection(0);//выбор позиции загрузки
    }

    //Методы Спиннера
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            switch (position){
                case 0:
                    String text = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
                    break;
            }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //Методы меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settings) {
            Toast.makeText(this, "Item1", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    }


