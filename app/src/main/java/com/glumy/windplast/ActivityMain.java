package com.glumy.windplast;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.glumy.windplast.fragment.FragmentSettingsOne;
import com.glumy.windplast.fragment.FragmentSettingsThree;
import com.glumy.windplast.fragment.FragmentSettingsTwo;


public class ActivityMain extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ActionBar actionBar;
    private Toolbar toolbar;
    private FragmentSettingsOne frag1;
    private FragmentSettingsTwo frag2;
    private FragmentSettingsThree frag3;
    private FragmentTransaction trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag1 = new FragmentSettingsOne();
        frag2 = new FragmentSettingsTwo();
        frag3 = new FragmentSettingsThree();

        initToolbar();

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
             trans = getSupportFragmentManager().beginTransaction();

        switch (position) {
            case 0:
                trans.replace(R.id.ll_settings, frag1);
                break;
            case 1:
                trans.replace(R.id.ll_settings, frag2);
                break;
            case 2:
                trans.replace(R.id.ll_settings, frag3);
                break;
        }
        trans.commit();
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
    //onClick
    public void onClick(View view){
        Intent i;
        int resource = 0;

        switch (view.getId()){

            case R.id.iv_1_1:
                ImageView mImageView = findViewById(R.id.iv_1_1);
               // mImageView.setImageResource(R.drawable.icon_toolbar100);
                resource = R.drawable.icon_toolbar100;
                i = new Intent(this, ActivityProductDetails.class);
                i.putExtra("image", resource);
                startActivity(i);
                break;

            case R.id.iv_1_2:
                ImageView mImageView_1_2 = findViewById(R.id.iv_1_2);
              //  mImageView_1_2.setImageResource(R.drawable.icon_toolbar100);
                resource = R.drawable.my_rectangle;
                i = new Intent(this, ActivityProductDetails.class);
                i.putExtra("image", resource);
                startActivity(i);
                break;
        }


    }
}


