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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.glumy.windplast.Cart.Cart;
import com.glumy.windplast.connection.JsonPlaceHolderApi;
import com.glumy.windplast.connection.Post;
import com.glumy.windplast.data.AdapterStorageCalculations;
import com.glumy.windplast.data.Constant;
import com.glumy.windplast.fragment.FragmentSettingsOne;
import com.glumy.windplast.fragment.FragmentSettingsTwo;
import com.glumy.windplast.util.NetworkCheck;

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
        Cart recived;

        switch (view.getId()) {

            case R.id.set1_iv_up_left:
                recived = new Cart(R.drawable.img_200x130, R.string.two,
                        1350, 1400, 250, 1450, 160, 1350,
                        1, 1000);
                break;

            case R.id.set1_iv_up_right:
                recived = new Cart(R.drawable.bb, R.string.balkon,
                        2100, 2100, 250, 2200, 160, 2100,
                        1, 3000);
                break;

            case R.id.set1_iv_mid_left:
                recived = new Cart(R.drawable.one_po, R.string.one_po,
                        900, 1300, 250, 1000, 160, 900,
                        1, 1000);
                break;

            case R.id.set1_iv_mid_right:
                recived = new Cart(R.drawable.deaf, R.string.deaf,
                        1000, 1000, 250, 1100, 160, 1000,
                        1, 500);
                break;

            case R.id.set1_iv_bottom_left:
                recived = new Cart(R.drawable.four, R.string.four,
                        3000, 1300, 250, 3100, 160, 3000,
                        1, 3000);
                break;

            case R.id.set1_iv_bottom_right:
                recived = new Cart(R.drawable.triple, R.string.triple,
                        2000, 1300, 250, 2100, 160, 2000,
                        1, 2000);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
        i = new Intent(this, ActivityProductDetails.class);
        i.putExtra(Cart.class.getSimpleName(), recived);
        startActivity(i);
    }

    public void initFragments() {
        frag1 = new FragmentSettingsOne();
        frag2 = new FragmentSettingsTwo();
    }

    //-----------------------------------------------------------------
    //метод для извлечения курса валют (api PrivatBank)
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
    public void onClickMainMenu(View v) {

        switch (v.getId()) {

            case R.id.image_storage:
                Intent intent = new Intent(this, ActivityStorageCalculations.class);
                startActivity(intent);
                break;

        }
    }

}






