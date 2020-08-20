package com.glumy.windplast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
import com.glumy.windplast.util.Tools;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;


public class ActivityOrderResult extends AppCompatActivity {


    int number = 1;
    private static int counterCalculations = 1;//равен длинне массива просчетов??
    private EditText et_address, et_comment;
    private TextInputLayout address_lyt, comment_lyt;
    // private ActivityStorageCalculations asc;

    private ArrayList<Storage> storageArrayList;
    ImageView imageView;
    TextView tv_name, tv_width_height_or_res, et_amount_or_res, tv_square, tv_profile_or_res, tv_prof_second_part, tv_furniture_or_res,
            tv_quantity_glasses, tv_glasses_or_res, tv_manufacturer_sill, tv_manufacturer_weathering, tvMounting, tvDelivery, tv_cost;
    private int image;

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
                    onBackPressed();
                }
            });

            ImageButton ib_save = findViewById(R.id.ib_save);
            ib_save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submitForm();
                    // Constant.storageArrayList.add(Storage());
                    // loadData();
                    // saveData();

                }
            });
        }
    }

    private void iniComponent() {
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
            Toast toast = Toast.makeText(getApplicationContext(), R.string.text, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

            String str_name = tv_name.getText().toString();
            String str_address = et_address.getText().toString();
            String str_comment = et_comment.getText().toString();
            int cost = Integer.parseInt(tv_cost.getText().toString());

            Storage reciveToStorage = new Storage(image, str_name, str_address, str_comment, cost);

            Intent i = new Intent(this, ActivityStorageCalculations.class);
            i.putExtra(Storage.class.getSimpleName(), reciveToStorage);
            startActivity(i);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////-------------------------------------------------------------------------
//    public static void navigate(Activity activity, Long id, Boolean from_notif) {
//        Intent i = navigateBase(activity, id, from_notif);
//        activity.startActivity(i);
//    }
//    public static Intent navigateBase(Context context, Long id, Boolean from_notif) {
//        Intent i = new Intent(context, ActivityProductDetails.class);
//        i.putExtra(EXTRA_OBJECT_ID, id);
//        i.putExtra(EXTRA_FROM_NOTIF, from_notif);
//        return i;
//    }
/////////////////////////////////////////////////////////////////////////////////------------------------------------------------------------------------------------
//            });

    // int image = getResources().getDrawable(imageView);
//            OrderResult recivedOR = new OrderResult(image,tv_width_product.getText().toString(), tv_height_product.getText().toString(),
//                    et_amount.getText().toString(), str_profile, str_profile2part, str_furniture, str_quantity_glasses, str_glass,
//                    str_manufacturer_sill, str_manufacturer_weathering, mounting, strDelivery);
    //           Intent i = new Intent(this, AdapterStorageCalculations.class);
    //           i.putExtra(Storage.class.getSimpleName(), reciveToStorage);
    // startActivity(i);

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

    public ArrayList<Storage> getStorageArrayList() {
        return storageArrayList;
    }
}

