package com.glumy.windplast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.glumy.windplast.Cart.Cart;
import com.glumy.windplast.data.Constant;
import com.glumy.windplast.util.DialogUtil;


public class ActivityProductDetails extends AppCompatActivity {

    private ImageView mainImage;
    private TextView textView_main, tv_width_product, tv_height_product, tv_width_sill, tv_length_sill, tv_width_weathering, tv_length_weathering;
    private RadioGroup rg_rehau, rg_wds, rg_openteck, rg_furnit, rg_glasses, rgroupSill, rgWeathering, rg_profil;
    private RadioButton rb_rehau, rb_wds, rb_openteck;
    private RadioButton rb_rehau_60, rb_rehau_70, rb_rehau_brillant, rb_rehau_sineo, rb_rehau_geneo;
    private RadioButton rb_wds_5s, rb_wds_6s, rb_wds_7s, rb_wds_8s;
    private RadioButton rb_openteck_standart, rb_openteck_delux, rb_openteck_elit;
    private RadioButton rb_roto, rb_axor;
    private RadioButton rb_one_camera;
    private RadioButton rb_two_camera;
    private CheckBox checkBoxWeathering, checkBoxSill;
    private RadioButton rb_sill_ukraine, rb_sill_usa;
    private RadioButton rb_weath_ukraine, rb_weath_usa;
    private LinearLayout llWindowSillSizes, llWeathering;
    private Button btnCalculation;
    private EditText et_amount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        initComponent();

    }

    private void initComponent() {
        mainImage = findViewById(R.id.imageView);
        textView_main = findViewById(R.id.textView);
        tv_width_product = findViewById(R.id.tv_width_product);
        tv_height_product = findViewById(R.id.tv_height_product);
        tv_width_sill = findViewById(R.id.tv_width_sill);
        tv_length_sill = findViewById(R.id.tv_length_sill);
        tv_width_weathering = findViewById(R.id.tv_width_weathering);
        tv_length_weathering = findViewById(R.id.tv_length_weathering);
        et_amount = findViewById(R.id.et_amount);

        rg_profil = findViewById(R.id.rg_profil);

        rg_rehau = findViewById(R.id.rg_rehau);
        rb_rehau = findViewById(R.id.rb_rehau);
        rb_rehau.setChecked(true);

        rb_rehau_60 = findViewById(R.id.rb_euro_design_60);
        rb_rehau_60.setChecked(true);

        rg_wds = findViewById(R.id.rg_wds);
        rb_wds = findViewById(R.id.rb_wds);
        rb_wds_5s = findViewById(R.id.rb_wds_5s);
        rb_wds_6s = findViewById(R.id.rb_wds_6s);
        rb_wds_7s = findViewById(R.id.rb_wds_7s);
        rb_wds_8s = findViewById(R.id.rb_wds_8s);

        rg_openteck = findViewById(R.id.rg_openteck);
        rb_openteck = findViewById(R.id.rb_openteck);
        rb_openteck_standart = findViewById(R.id.rb_openteck_standart);
        rb_openteck_delux = findViewById(R.id.rb_openteck_de_lux);
        rb_openteck_elit = findViewById(R.id.rb_openteck_elit);

        rg_furnit = findViewById(R.id.rg_furnit);
        rb_roto = findViewById(R.id.rb_roto);
        rb_roto.setChecked(true);
        rb_axor = findViewById(R.id.rb_axor);

        rg_glasses = findViewById(R.id.rg_glasses);
        rb_one_camera = findViewById(R.id.rb_one_camera);
        rb_one_camera.setChecked(true);
        rb_two_camera = findViewById(R.id.rb_two_camera);

        checkBoxSill = findViewById(R.id.chbx_windowsill);
        checkBoxWeathering = findViewById(R.id.chbx_weathering);

        rgroupSill = findViewById(R.id.radio_group_sill);
        rb_sill_ukraine = findViewById(R.id.rb_sill_ukraine);
        rb_sill_usa = findViewById(R.id.rb_sill_usa);

        rgWeathering = findViewById(R.id.rg_weathering);
        rb_weath_ukraine = findViewById(R.id.rb_weath_ukraine);
        rb_weath_usa = findViewById(R.id.rb_weath_usa);

        llWindowSillSizes = findViewById(R.id.ll_windowsill_sizes);
        llWeathering = findViewById(R.id.ll_weathering);

        btnCalculation = findViewById(R.id.btn_calculation);

//Передался экземпляр класса
        Bundle recivedData = getIntent().getExtras();
        final Cart setActivity;
        if (recivedData != null) {
            setActivity = (Cart) recivedData.getSerializable(Cart.class.getSimpleName());
            assert setActivity != null;
            textView_main.setText(setActivity.getName());
            mainImage.setImageResource(setActivity.getImage());
            tv_width_product.setText(setActivity.getWidth() + "");
            tv_height_product.setText(setActivity.getHeight() + "");
            tv_width_sill.setText(setActivity.getWidthSill() + "");
            tv_length_sill.setText(setActivity.getLengthSill() + "");
            tv_width_weathering.setText(setActivity.getWidthWeathering() + "");
            tv_length_weathering.setText(setActivity.getLengthWeathering() + "");
            et_amount.setText(setActivity.getAmount() + "");


        }
    }
    String str_CheckedRadiobuttonProfile = "";//rb_rehau.getText().toString();
    String str_profileTwoPart = "";//rb_rehau_60.getText().toString();
    String str_fullProfileName = str_CheckedRadiobuttonProfile + " " + str_profileTwoPart;


    public void Radiogroup(View view) {


        switch (view.getId()) {

            case R.id.rb_rehau:
                str_CheckedRadiobuttonProfile = rb_rehau.getText().toString();

                rg_rehau.setVisibility(View.VISIBLE);
                rg_wds.setVisibility(View.GONE);
                rg_wds.clearCheck();
                rg_openteck.setVisibility(View.GONE);
                rg_openteck.clearCheck();
                break;

            case R.id.rb_euro_design_60:
                str_profileTwoPart = rb_rehau_60.getText().toString();
                break;
            case R.id.rb_euro_design_70:
                str_profileTwoPart = rb_rehau_70.getText().toString();
                break;

            case R.id.rb_wds:
                str_CheckedRadiobuttonProfile = Constant.WDS;
                rg_wds.setVisibility(View.VISIBLE);
                rg_rehau.setVisibility(View.GONE);
                rg_rehau.clearCheck();
                rg_openteck.setVisibility(View.GONE);
                rg_openteck.clearCheck();
                break;

            case R.id.rb_openteck:
                str_CheckedRadiobuttonProfile = Constant.OPENTECK;
                rg_openteck.setVisibility(View.VISIBLE);
                rg_rehau.setVisibility(View.GONE);
                rg_rehau.clearCheck();
                rg_wds.setVisibility(View.GONE);
                rg_wds.clearCheck();
                break;

            case R.id.chbx_windowsill:
                if (checkBoxSill.isChecked()) {
                    rgroupSill.setVisibility(View.VISIBLE);
                    rb_sill_ukraine.setChecked(true);
                    llWindowSillSizes.setVisibility(View.VISIBLE);
                } else {
                    rgroupSill.clearCheck();
                    rgroupSill.setVisibility(View.GONE);
                    llWindowSillSizes.setVisibility(View.GONE);
                }
                break;

            case R.id.chbx_weathering:
                if (checkBoxWeathering.isChecked()) {
                    rgWeathering.setVisibility(View.VISIBLE);
                    rb_weath_ukraine.setChecked(true);
                    llWeathering.setVisibility(View.VISIBLE);
                } else {
                    rgWeathering.clearCheck();
                    rgWeathering.setVisibility(View.GONE);
                    llWeathering.setVisibility(View.GONE);
                }
                break;
            case R.id.btn_calculation:
                openDialog();
        }
    }

    private void openDialog() {
        DialogUtil dialog = new DialogUtil();
        Bundle dataProductDetails = new Bundle();
        dataProductDetails.putString("width_product", tv_width_product.getText().toString());
        dataProductDetails.putString("height_product", tv_height_product.getText().toString());
        dataProductDetails.putString("et_amount", et_amount.getText().toString());

        dataProductDetails.putString("checkedRadiobuttonProfile", str_fullProfileName);
        dataProductDetails.putString("width_sill", tv_width_sill.getText().toString());
        dataProductDetails.putString("length_sill", tv_length_sill.getText().toString());
        dataProductDetails.putString("width_weathering", tv_width_weathering.getText().toString());
        dataProductDetails.putString("length_weathering", tv_length_weathering.getText().toString());
        dialog.setArguments(dataProductDetails);
        dialog.show(getSupportFragmentManager(), "onCreateDialog");
    }
}
