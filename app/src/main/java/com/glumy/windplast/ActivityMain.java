package com.glumy.windplast;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.glumy.windplast.Cart.Cart;
import com.glumy.windplast.Cart.Storage;
import com.glumy.windplast.connection.JsonPlaceHolderApi;
import com.glumy.windplast.connection.Post;
import com.glumy.windplast.data.AdapterStorageCalculations;
import com.glumy.windplast.data.Constant;
import com.glumy.windplast.fragment.FragmentSettingsOne;
import com.glumy.windplast.fragment.FragmentSettingsTwo;
import com.glumy.windplast.util.NetworkCheck;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ActivityMain extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public String content = "";
    private ActionBar actionBar;
    private Toolbar toolbar;
    private FragmentSettingsOne frag1;
    private FragmentSettingsTwo frag2;
    private FragmentTransaction trans;
    private ImageView ivStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initcomponents();
        initToolbar();
        initFragments();

//        // launch instruction when first launch
//        if (sharedPref.isFirstLaunch()) {
//            startActivity(new Intent(this, ActivityInstruction.class));
//            sharedPref.setFirstLaunch(false);
//        }
    }

    public void initcomponents() {
        ivStorage = findViewById(R.id.image_storage);
//        tv_rate = findViewById(R.id.rate_result);
        //requestRate();
        ivStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, ActivityStorageCalculations.class);
                startActivity(intent);
            }
        });
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
        final Spinner spinner_tolbar = findViewById(R.id.spinner_tolbar);
        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.spinner_menu, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_tolbar.setAdapter(adapter);
        spinner_tolbar.setOnItemSelectedListener(this);
        //spinner.setSelection(0);//выбор позиции загрузки item
    }

    @Override
    public void onBackPressed() {
        dialogExitConfirmation();

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
        //   if (id == R.id.menu_rate) {
        //requestRate();
        //  }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    //onClick
    public void onClick(View view) {
        Intent i;
        Cart recivedMain;

        switch (view.getId()) {

            case R.id.set1_iv_up_left:
                recivedMain = new Cart(R.drawable.img_200x130, "Две секции с одной створкой",
                        1350, 1400, 250, 1450, 160, 1350,
                        1, 1000);
                break;

            case R.id.set1_iv_up_right:
                recivedMain = new Cart(R.drawable.bb, "Балконный блок",
                        2100, 2100, 250, 2200, 160, 2100,
                        1, 3000);
                break;

            case R.id.set1_iv_mid_left:

                recivedMain = new Cart(R.drawable.one_po, "Одна секция - створка",
                        900, 1300, 250, 1000, 160, 900,
                        1, 1000);
                break;

            case R.id.set1_iv_mid_right:
                recivedMain = new Cart(R.drawable.deaf, "Глухое",
                        1000, 1000, 250, 1100, 160, 1000,
                        1, 500);
                break;

            case R.id.set1_iv_bottom_left:
                recivedMain = new Cart(R.drawable.four, "Четыре секции с двумя створками",
                        3000, 1300, 250, 3100, 160, 3000,
                        1, 3000);
                break;

            case R.id.set1_iv_bottom_right:
                recivedMain = new Cart(R.drawable.triple, "Три секции с одной створкой",
                        2000, 1300, 250, 2100, 160, 2000,
                        1, 2000);
                break;

            case R.id.set1_iv_bottom_left2:
                recivedMain = new Cart(R.drawable.two_po, "Две секции с двумя створками",
                        1400, 1300, 250, 1500, 160, 1400,
                        1, 3000);
                break;

            case R.id.set1_iv_bottom_right2:
                recivedMain = new Cart(R.drawable.two_gluh, "Две глухих секции",
                        1400, 1300, 250, 1500, 160, 1400,
                        1, 6000);
                break;

            case R.id.set2_iv_up_left:
                recivedMain = new Cart(R.drawable.img_200x130, "Две секции с одной створкой",
                        1350, 1400, 400, 1550, 200, 1350,
                        1, 1000);
                break;

            case R.id.set2_iv_up_right:
                recivedMain = new Cart(R.drawable.bb, "Балконный блок",
                        2100, 2100, 400, 2200, 200, 2100,
                        1, 3000);
                break;

            case R.id.set2_iv_mid_left:

                recivedMain = new Cart(R.drawable.one_po, "Одна секция - створка",
                        900, 1300, 400, 1000, 200, 900,
                        1, 1000);
                break;

            case R.id.set2_iv_mid_right:
                recivedMain = new Cart(R.drawable.deaf, "Глухое",
                        1000, 1000, 400, 1100, 200, 1000,
                        1, 500);
                break;

            case R.id.set2_iv_bottom_left:
                recivedMain = new Cart(R.drawable.four, "Четыре секции с двумя створками",
                        3000, 1300, 400, 3100, 200, 3000,
                        1, 3000);
                break;

            case R.id.set2_iv_bottom_right:
                recivedMain = new Cart(R.drawable.triple, "Три секции с одной створкой",
                        2000, 1300, 400, 2100, 200, 2000,
                        1, 2000);
                break;

            case R.id.set2_iv_bottom_left2:
                recivedMain = new Cart(R.drawable.two_po, "Две секции с двумя створками",
                        1400, 1300, 400, 1500, 200, 1400,
                        1, 3000);
                break;

            case R.id.set2_iv_bottom_right2:
                recivedMain = new Cart(R.drawable.two_gluh, "Две глухих секции",
                        1400, 1300, 400, 1500, 200, 1400,
                        1, 6000);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
        i = new Intent(ActivityMain.this, ActivityProductDetails.class);
        i.putExtra(Cart.class.getSimpleName(), recivedMain);
        startActivity(i);
    }

    public void initFragments() {
        frag1 = new FragmentSettingsOne();
        frag2 = new FragmentSettingsTwo();
    }

    //-----------------------------------------------------------------
    //метод для получения курса валют (api PrivatBank)
//    private void requestRate() {
//        if (!NetworkCheck.isConnect(this)) {
//            content = "Нет соединения с интернетом";
//            tv_rate.setText(content);
//        } else {
//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl(Constant.WEB_URL_RATE)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//
//            JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
//
//            Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
//            call.enqueue(new Callback<List<Post>>() {
//                @Override
//                public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//
//                    List<Post> posts = response.body();
//
//                    for (Post post : posts) {
//                        content += post.getSale() + "\n";
//                        String s = "Курс USD: Приватбанк " + "\n" + content.substring(0, content.length() - 4);
//                        tv_rate.append(s);
//                        break;
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<List<Post>> call, Throwable t) {
//                    tv_rate.setText(t.getMessage());
//                }
//            });
//        }
//----------------------------------------------------------------------------------------------------------------

    public void dialogExitConfirmation() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Вы действительно хотите выйти из приложения?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface di, int i) {
                di.dismiss();
                finishAffinity();
            }
        }).setNegativeButton("Нет", null);
        builder.show();

    }

}






