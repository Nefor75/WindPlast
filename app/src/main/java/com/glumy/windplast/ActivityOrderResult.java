package com.glumy.windplast;

import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.glumy.windplast.Cart.Order;
import com.glumy.windplast.Cart.Storage;

import com.glumy.windplast.util.Tools;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ActivityOrderResult extends AppCompatActivity {


    int number = 1;
    private EditText et_address, et_comment;
    private TextInputLayout address_lyt, comment_lyt;
    Storage reciveToStorage;
    private List<Order> itemsOR = new ArrayList<>();
    private ImageView imageView;
    private TextView tv_name, tv_width_height_or_res, et_amount_or_res, tv_square, tv_profile_or_res, tv_prof_second_part, tv_furniture_or_res,
            tv_quantity_glasses, tv_glasses_or_res, tv_manufacturer_sill, tv_manufacturer_weathering, tvMounting, tvDelivery, tv_cost,
            tv_number;
    private int image;
    String str_date2;
    String str_name;
    String str_address;
    String str_comment;
    int cost;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_result);

        iniComponent();

        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);
       // Order orderFromStor = getDataToOR(position);


        Bundle reciveOrder = getIntent().getExtras();
        final Order setActivity;
        if (reciveOrder != null) {
            setActivity = (Order) reciveOrder.getSerializable(Order.class.getSimpleName());
            assert setActivity != null;
            number = getNumberStor("SaveStorage");

            tv_number.setText("Расчет № " + number + "");
            tv_name.setText(setActivity.getName());
            imageView.setImageResource(setActivity.getImageTop());
            image = setActivity.getImageTop();
            String resultPlust = getString(R.string.width) + " " + setActivity.getWidth_product() + "    " + getString(R.string.height) + " " + setActivity.getHeight_product();
            tv_width_height_or_res.setText(resultPlust);
            et_amount_or_res.setText(setActivity.getAmount());
            tv_square.setText(Tools.getsquareProduct(setActivity.getWidth_product(), setActivity.getHeight_product()));
            tv_profile_or_res.setText(setActivity.getProfile());
            tv_prof_second_part.setText(setActivity.getProfile2part());
            tv_furniture_or_res.setText(setActivity.getFurniture());
            tv_quantity_glasses.setText(setActivity.getQuantity_glasses());
            tv_glasses_or_res.setText(setActivity.getGlass());
            tv_manufacturer_sill.setText(setActivity.getManufacturer_sill());
            tv_manufacturer_weathering.setText(setActivity.getManufacturer_weathering());
            tvMounting.setText(setActivity.getMounting());
            tvDelivery.setText(setActivity.getDelivery());
            tv_cost.setText(setActivity.getCost() + "");

            ImageButton ib_back = findViewById(R.id.ib_back);
            ib_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            ImageButton ib_transfer = findViewById(R.id.ib_transfer);
            ib_transfer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mChooser();
                }
            });

            ImageButton ib_save = findViewById(R.id.ib_save);
            ib_save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submitForm();

                }
            });

        }
    }

    public Order getDataToOR(int x) {
        prefs = getSharedPreferences("saveDataOR", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("saveDataOR", null);
        if (json != null) {
            Type type = new TypeToken<List<Order>>() {
            }.getType();

            List<Order> temp = gson.fromJson(json, type);

            return temp.get(x);
        }
//        Type type = new TypeToken<List<Order>>() {
//        }.getType();
//        List<Order> temp = gson.fromJson(json, type);
//        return temp.get(0);
        return null;
    }

    private void iniComponent() {
        tv_number = findViewById(R.id.tv_number);
        tv_name = findViewById(R.id.text_name);
        et_address = findViewById(R.id.editAddress);
        et_comment = findViewById(R.id.editComment);
        address_lyt = findViewById(R.id.address_lyt);
        comment_lyt = findViewById(R.id.comment_lyt);
        imageView = findViewById(R.id.image_top);
        tv_width_height_or_res = findViewById(R.id.tv_width_height_or_res);
        et_amount_or_res = findViewById(R.id.tv_amount_or_res);
        tv_square = findViewById(R.id.tv_square);
        tv_profile_or_res = findViewById(R.id.tv_profile_or_res);
        tv_prof_second_part = findViewById(R.id.tv_prof_second_part);
        tv_furniture_or_res = findViewById(R.id.tv_furniture_or_res);
        tv_quantity_glasses = findViewById(R.id.tv_qwantity_glasses);
        tv_glasses_or_res = findViewById(R.id.tv_glasses_or_res);
        tv_manufacturer_sill = findViewById(R.id.tv_manufacturer_sill);
        tv_manufacturer_weathering = findViewById(R.id.tv_manufacturer_weathering);
        tvMounting = findViewById(R.id.tv_mounting);
        tvDelivery = findViewById(R.id.tv_delivery);
        tv_cost = findViewById(R.id.price_or_res);

    }

    //Методы с валидацией EditText----------------------------
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private void submitForm() {
        if (!validateAddress()) {
            Snackbar.make(findViewById(android.R.id.content), R.string.invalid_address, Snackbar.LENGTH_LONG).show();
            return;
        }
        if (!validateComment()) {
            Snackbar.make(findViewById(android.R.id.content), R.string.invalid_comment, Snackbar.LENGTH_LONG).show();
            return;
        } else {

            str_name = tv_name.getText().toString();
            str_address = et_address.getText().toString();
            str_comment = et_comment.getText().toString();
            String str_sizes = tv_width_height_or_res.getText().toString();
            String str_amount = et_amount_or_res.getText().toString();
            String str_square = tv_square.getText().toString();
            String str_profile1 = tv_profile_or_res.getText().toString();
            String str_profile2 = tv_prof_second_part.getText().toString();
            String str_furniture = tv_furniture_or_res.getText().toString();
            String str_quantity_glasses = tv_quantity_glasses.getText().toString();
            String str_glasses_or_res = tv_glasses_or_res.getText().toString();
            String str_manufacturer_sill = tv_manufacturer_sill.getText().toString();
            String str_manufacturer_weathering = tv_manufacturer_weathering.getText().toString();
            String delivery = "500";
            String mounting = et_amount_or_res.getText().toString();
            cost = Integer.parseInt(tv_cost.getText().toString());

            Date date = new Date();
            String str_date = date.toString();
            str_date2 = Tools.getFormattedDateSimple(str_date);

            reciveToStorage = new Storage(image, str_name, str_address, str_comment, str_date2, cost);
//            Storage reciveToStorage = new Storage(number, image, str_name, str_address, str_comment, str_sizes, str_amount,
//                    str_square, str_profile1, str_profile2, str_furniture, str_quantity_glasses, str_glasses_or_res,
//                    str_manufacturer_sill, str_manufacturer_weathering, mounting, delivery, str_date2, cost);
            Intent i = new Intent(this, ActivityStorageCalculations.class);
            i.putExtra(Storage.class.getSimpleName(), reciveToStorage);
            startActivity(i);

            //         itemsOR.add(reciveToStorage);
//              itemsOR.add(new Storage(number, image, str_name, str_address, str_comment, str_sizes, str_amount,
//                         str_square, str_profile1, str_profile2, str_furniture, str_quantity_glasses, str_glasses_or_res,
//                         str_manufacturer_sill, str_manufacturer_weathering, mounting, delivery, cost));

            itemsOR.add(new Order(number, image, str_name, str_address, str_comment, str_sizes, str_amount,
                    str_square, str_profile1, str_profile2, str_furniture, str_quantity_glasses, str_glasses_or_res,
                    str_manufacturer_sill, str_manufacturer_weathering, mounting, delivery, cost));

            saveDataOR(itemsOR, "saveDataOR");
        }
    }

    private boolean validateAddress() {
        String str = et_address.getText().toString().trim();
        if (str.isEmpty()) {
            address_lyt.setError(getString(R.string.invalid_address));
            requestFocus(et_address);
            return false;
        } else {
            address_lyt.setErrorEnabled(false);
        }
        return true;

    }

    private boolean validateComment() {
        String str = et_comment.getText().toString().trim();
        if (str.isEmpty()) {
            comment_lyt.setError(getString(R.string.invalid_comment));
            requestFocus(et_comment);
            return false;
        } else {
            comment_lyt.setErrorEnabled(false);
        }
        return true;

    }

    private void mChooser() {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);

        String title = getResources().getString(R.string.app_name);

        Intent chooser = Intent.createChooser(sendIntent, title);

// Verify the original intent will resolve to at least one activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }

    public void saveDataOR(List<Order> list, String key) {
        prefs = getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();

    }

    public int getNumberStor(String key) {
        prefs = getSharedPreferences(key, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        if (json != null) {
            Type type = new TypeToken<List<Storage>>() {
            }.getType();
            List<Storage> temp = gson.fromJson(json, type);
            return temp.size() + 1;
        }
        return number;

    }

}

