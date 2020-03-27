package com.glumy.windplast;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import com.glumy.windplast.Cart.Cart;
import com.glumy.windplast.fragment.FragmentSettingsOne;
import com.glumy.windplast.fragment.FragmentSettingsTwo;


public class ActivityMain extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ActionBar actionBar;
    private Toolbar toolbar;
    private FragmentSettingsOne frag1;
    private FragmentSettingsTwo frag2;
    private FragmentTransaction trans;
    private TextView tvProductDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        initFragments();

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
        toolbar.setNavigationIcon(R.drawable.icon_toolbar100);//иконка слева в тулбаре
        initSpinner();

    }

    private void initSpinner() {
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.spinner_menu, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //spinner.setSelection(0);//выбор позиции загрузки item
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
        Cart recived = new Cart();

        switch (view.getId()){

            case R.id.set1_iv_up_left :
            Cart set1UpLeft = new Cart(view.getId(), R.drawable.img_200x130, R.string.name_settings1_up_left,
                1350, 1400, 1, 1000);
                        recived = set1UpLeft;
                  break;

            case R.id.set1_iv_up_right:
                Cart set1UpRight = new Cart(view.getId(), R.drawable.bb, R.string.name_settings1_up_right,
                        2100, 2100, 1, 3000);
                        recived = set1UpRight;
                break;

            case R.id.set1_iv_mid_left:
                Cart set1MidLeft = new Cart(view.getId(), R.drawable.triple, R.string.name_settings1_mid_left,
                        2100, 1400, 1, 2000);
                        recived = set1MidLeft;
                break;

            case R.id.set1_iv_mid_right:
                Cart set1MidRight = new Cart(view.getId(), R.drawable.deaf, R.string.name_settings1_mid_right,
                        1000, 1000, 1, 500);
                recived = set1MidRight;
                break;

            case R.id.set1_iv_bottom_right:


                break;

            case R.id.set2_iv_up_left :


                break;

            case R.id.set2_iv_mid_left:


                break;

            case R.id.set2_iv_bottom_left:


                break;

            case R.id.set2_iv_up_right:


                break;

            case R.id.set2_iv_mid_right:


                break;

            case R.id.set2_iv_bottom_right:


                break;

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
        i = new Intent(this, ActivityProductDetails.class);
        i.putExtra(Cart.class.getSimpleName(), recived);
        startActivity(i);
    }

    public void initFragments(){
        frag1 = new FragmentSettingsOne();
        frag2 = new FragmentSettingsTwo();

//        ArrayList<Cart> winSet1 = new ArrayList<Cart>();
//        winSet1.add(new Cart(R.id.set1_iv_up_left, R.drawable.img_200x130, R.string.name_settings1_up_left,
//                1350, 1400, 1, 1000));


    }

}



