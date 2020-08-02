package com.glumy.windplast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.glumy.windplast.Cart.OrderResult;
import com.glumy.windplast.util.Tools;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;


public class ActivityOrderResult extends AppCompatActivity {

    private static int counterCalculations = 1;//равен длинне массива просчетов??
    private EditText et_address, et_comment;
    private TextInputLayout address_lyt, comment_lyt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_result);

        iniComponent();

        Bundle recivedData = getIntent().getExtras();
        final OrderResult setActivity;
        if (recivedData != null) {
            setActivity = (OrderResult) recivedData.getSerializable(OrderResult.class.getSimpleName());
            assert setActivity != null;

            TextView tv_width_height_or_res = findViewById(R.id.tv_width_height_or_res);
            String resultPlust = getString(R.string.width) + " " + setActivity.getWidth_product() + "    " + getString(R.string.height) + " " + setActivity.getHeight_product();
            tv_width_height_or_res.setText(resultPlust);

            TextView et_amount_or_res = findViewById(R.id.tv_amount_or_res);
            et_amount_or_res.setText(setActivity.getAmount());

            TextView tv_square = findViewById(R.id.tv_square);
            tv_square.setText(Tools.getsquareProduct(setActivity.getWidth_product(), setActivity.getHeight_product()));

            TextView tv_profile_or_res = findViewById(R.id.tv_profile_or_res);
            tv_profile_or_res.setText(setActivity.getProfile());

            TextView tv_prof_second_part = findViewById(R.id.tv_prof_second_part);
            tv_prof_second_part.setText(setActivity.getProfile2part());

            TextView tv_furniture_or_res = findViewById(R.id.tv_furniture_or_res);
            tv_furniture_or_res.setText(setActivity.getFurniture());

            TextView tv_quantity_glasses = findViewById(R.id.tv_qwantity_glasses);
            tv_quantity_glasses.setText(setActivity.getQuantity_glasses());

            TextView tv_glasses_or_res = findViewById(R.id.tv_glasses_or_res);
            tv_glasses_or_res.setText(setActivity.getGlass());

            TextView tv_manufacturer_sill = findViewById(R.id.tv_manufacturer_sill);
            tv_manufacturer_sill.setText(setActivity.getManufacturer_sill());

            TextView tv_manufacturer_weathering = findViewById(R.id.tv_manufacturer_weathering);
            tv_manufacturer_weathering.setText(setActivity.getManufacturer_weathering());

            TextView tvMounting = findViewById(R.id.tv_mounting);
            tvMounting.setText(setActivity.getMounting());

            TextView tvDelivery = findViewById(R.id.tv_delivery);
            tvDelivery.setText(setActivity.getDelivery());

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

                }
            });
        }
    }

    private void iniComponent() {
        et_address = findViewById(R.id.editAddress);
        et_comment = findViewById(R.id.editComment);
        address_lyt = findViewById(R.id.address_lyt);
        comment_lyt = findViewById(R.id.comment_lyt);
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
            Intent i = new Intent(this, ActivityMain.class);
            startActivity(i);
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
//Методы с валидацией EditText--------------------------------------------------------------------
}
