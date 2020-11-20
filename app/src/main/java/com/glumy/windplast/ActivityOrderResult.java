package com.glumy.windplast;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.glumy.windplast.Cart.Order;
import com.glumy.windplast.Cart.Storage;

import com.glumy.windplast.data.AdapterStorageCalculations;
import com.glumy.windplast.data.DBHelper;
import com.glumy.windplast.util.Tools;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.glumy.windplast.data.DBHelper.TABLE_STORAGE;


public class ActivityOrderResult extends AppCompatActivity {

    int number = 1;
    private EditText et_address, et_comment;
    private TextInputLayout address_lyt, comment_lyt;
    private ImageView imageView;
    private TextView tv_name, tv_width_height_or_res, et_amount_or_res, tv_square, tv_profile_or_res, tv_prof_second_part, tv_furniture_or_res,
            tv_quantity_glasses, tv_glasses_or_res, tv_manufacturer_sill, tv_manufacturer_weathering, tvMounting, tvDelivery, tv_cost,
            tv_number;
    String str_sizes;
    String str_amount;
    String str_square;
    String str_profile1;
    String str_profile2;
    String str_furniture;
    String str_quantity_glasses;
    String str_glasses_or_res;
    String str_manufacturer_sill;
    String str_manufacturer_weathering;
    String mounting;
    int delivery = 300;
    private int image;
    String str_name;
    String str_address;
    String str_comment;
    int cost;
    SQLiteDatabase database;
    DBHelper dbHelper;
    Cursor mCursor;
    AdapterStorageCalculations adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_result);

        dbHelper = new DBHelper(this);
        iniComponent();

        Bundle reciveOrder = getIntent().getExtras();
        final Order setActivity;
        if (reciveOrder != null) {
            setActivity = (Order) reciveOrder.getSerializable(Order.class.getSimpleName());
            assert setActivity != null;

            number = getNumberStorSize();
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

            ImageButton ib_save = findViewById(R.id.ib_save);
            ib_save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submitForm();

                }
            });

        }
    }

    private void iniComponent() {
        tv_number = findViewById(R.id.tv_number);
        imageView = findViewById(R.id.image_top);
        tv_name = findViewById(R.id.text_name);
        et_address = findViewById(R.id.editAddress);
        et_comment = findViewById(R.id.editComment);
        address_lyt = findViewById(R.id.address_lyt);
        comment_lyt = findViewById(R.id.comment_lyt);
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
            str_sizes = tv_width_height_or_res.getText().toString();
            str_amount = et_amount_or_res.getText().toString();
            str_square = tv_square.getText().toString();
            str_profile1 = tv_profile_or_res.getText().toString();
            str_profile2 = tv_prof_second_part.getText().toString();
            str_furniture = tv_furniture_or_res.getText().toString();
            str_quantity_glasses = tv_quantity_glasses.getText().toString();
            str_glasses_or_res = tv_glasses_or_res.getText().toString();
            str_manufacturer_sill = tv_manufacturer_sill.getText().toString();
            str_manufacturer_weathering = tv_manufacturer_weathering.getText().toString();
            delivery = 300;
            mounting = et_amount_or_res.getText().toString();
            cost = Integer.parseInt(tv_cost.getText().toString());
            saveToDB();
        }
    }
//            Date date = new Date();
//            String str_date = date.toString();
//            str_date2 = Tools.getFormattedDateSimple(str_date);

    private void saveToDB() {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.KEY_NAME, str_name);
        // contentValues.put(String.valueOf(DBHelper.KEY_IMAGE), image);
        contentValues.put(DBHelper.KEY_ADDRESS, str_address);
        contentValues.put(DBHelper.KEY_COMMENT, str_comment);
//                contentValues.put(DBHelper.KEY_SIZES, str_sizes);
//                contentValues.put(DBHelper.KEY_AMOUNT, str_amount);
//                contentValues.put(DBHelper.KEY_SQUARE, str_square);
//                contentValues.put(DBHelper.KEY_PROFILE1, str_profile1);
//                contentValues.put(DBHelper.KEY_PROFILE2, str_profile2);
//                contentValues.put(DBHelper.KEY_FURNITURE, str_furniture);
//                contentValues.put(DBHelper.KEY_QUANTITY_GLASSES, str_quantity_glasses);
//                contentValues.put(DBHelper.KEY_GLASSES, str_glasses_or_res);
//                contentValues.put(DBHelper.KEY_MANUFACTURER_SILL, str_manufacturer_sill);
//                contentValues.put(DBHelper.KEY_MANUFACTURER_WEATHERING, str_manufacturer_weathering);
//                contentValues.put(DBHelper.KEY_MOUNTING, mounting);
//                contentValues.put(DBHelper.KEY_DELIVERY, delivery);

//                try {
//                    Calendar calendar = Calendar.getInstance();
//                    calendar.setTime((new SimpleDateFormat("dd/MM/yyyy")).get2DigitYearStart());//шо за метод?
//                    long date = calendar.getTimeInMillis();
        long date = 66666666;
        contentValues.put(DBHelper.KEY_DATE, date);
//                } catch (Exception e) {
//                    Toast.makeText(this, "Date is in the wrong format", Toast.LENGTH_LONG).show();
//                    return;
//                }
        contentValues.put(DBHelper.KEY_COST, cost);

        long newRowId = database.insert(TABLE_STORAGE, null, contentValues);

        Toast toast = Toast.makeText(getApplicationContext(), "Запись № " + newRowId, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

          database.close();
        onBackPressed();

    }

    public int getNumberStorSize() {
        database = dbHelper.getReadableDatabase();
        int count = (int) DatabaseUtils.queryNumEntries(database, TABLE_STORAGE);
        int mCont = count + 1;
        return mCont;
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

}

