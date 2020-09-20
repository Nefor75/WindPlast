package com.glumy.windplast;

import android.content.Intent;

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

import java.util.ArrayList;
import java.util.Date;


public class ActivityOrderResult extends AppCompatActivity {


    int number = 100;//равен длинне массива просчетов??
    private EditText et_address, et_comment;
    private TextInputLayout address_lyt, comment_lyt;
    private ActivityStorageCalculations asc;
    Storage reciveToStorage;
    private ArrayList<Storage> storageArrayList;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_result);

        iniComponent();

        Bundle reciveOrder = getIntent().getExtras();
        final Order setActivity;
        if (reciveOrder != null) {
            setActivity = (Order) reciveOrder.getSerializable(Order.class.getSimpleName());
            assert setActivity != null;

            tv_number.setText("Расчет № " + number);
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
            cost = Integer.parseInt(tv_cost.getText().toString());

            Date date = new Date();
            String str_date = date.toString();
            str_date2 = Tools.getFormattedDateSimple(str_date);

            reciveToStorage = new Storage(image, number, str_name, str_address, str_comment, str_date2, cost);
            Intent i = new Intent(this, ActivityStorageCalculations.class);
            i.putExtra(Storage.class.getSimpleName(), reciveToStorage);
            startActivity(i);

//                storageArrayList.add(new Order(image, tv_width_product.getText().toString(), tv_height_product.getText().toString(),
//                        et_amount.getText().toString(), str_profile, str_profile2part, str_furniture, str_quantity_glasses, str_glass,
//                        str_manufacturer_sill, str_manufacturer_weathering, mounting, strDelivery));
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
}