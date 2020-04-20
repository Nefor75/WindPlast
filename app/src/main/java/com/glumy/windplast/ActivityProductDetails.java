package com.glumy.windplast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
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
import com.glumy.windplast.util.DialogUtils;


public class ActivityProductDetails extends AppCompatActivity {//implements AdapterView.OnItemSelectedListener {

    private ImageView mainImage;
    private TextView textView_main;
    private EditText et_width;
    private EditText et_height;
    private RadioGroup rg_rehau, rg_wds, rg_opentech, rg_furnit, rg_glasses, rgroupSill, rgWeathering;
    private RadioButton rb_rehau, rb_wds, rb_opentech;
    private RadioButton rb_rehau_60, rb_rehau_70, rb_rehau_brillant, rb_rehau_sineo, rb_rehau_geneo;
    private RadioButton rb_wds_5s, rb_wds_6s, rb_wds_7s, rb_wds_8s;
    private RadioButton rb_opentech_standart, rb_opentech_delux, rb_opentech_elit;
    private RadioButton rb_roto, rb_axor;
    private RadioButton rb_one_camera;
    private RadioButton rb_two_camera;
    private CheckBox checkBoxWeathering, checkBoxSill;
    private RadioButton rb_sill_ukraine, rb_sill_usa;
    private RadioButton rb_weath_ukraine, rb_weath_usa;
    private LinearLayout llWindowSillSizes, llWeathering;
    private Button btnCalculation;
    private Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        initComponent();

    }

    private void initComponent() {
        mainImage = findViewById(R.id.imageView);
        textView_main = findViewById(R.id.textView);
        et_width = findViewById(R.id.edit_width);
        et_height = findViewById(R.id.edit_height);

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

        rg_opentech = findViewById(R.id.rg_opentech);
        rb_opentech = findViewById(R.id.rb_opentech);
        rb_opentech_standart = findViewById(R.id.rb_opentech_standart);
        rb_opentech_delux = findViewById(R.id.rb_opentech_de_lux);
        rb_opentech_elit = findViewById(R.id.rb_opentech_elit);

        rg_furnit = findViewById(R.id.rg_furnit);
        rb_roto = findViewById(R.id.rb_roto);
        rb_roto.setChecked(true);
        rb_axor = findViewById(R.id.rb_axor);

        rg_glasses = findViewById(R.id.rg_glasses);
        rb_one_camera = findViewById(R.id.rb_one_camera);
        rb_one_camera.setChecked(true);
        rb_two_camera = findViewById(R.id.rb_two_camera);

        checkBoxSill = findViewById(R.id.chbx_windowsill);
        checkBoxWeathering = findViewById(R.id.chbx_weadering);

        rgroupSill = findViewById(R.id.radio_group_sill);
        rb_sill_ukraine = findViewById(R.id.rb_sill_ukraine);
        rb_sill_usa = findViewById(R.id.rb_sill_usa);

        rgWeathering = findViewById(R.id.rg_weathering);
        rb_weath_ukraine = findViewById(R.id.rb_weath_ukraine);
        rb_weath_usa = findViewById(R.id.rb_weath_usa);

        llWindowSillSizes = findViewById(R.id.ll_windowsill_sizes);
        llWeathering = findViewById(R.id.ll_Weathering);

        btnCalculation = findViewById(R.id.btn_calculation);

//Передался экземпляр класса
        Bundle recivedData = getIntent().getExtras();
        final Cart setActivity;
        if (recivedData != null) {
            setActivity = (Cart) recivedData.getSerializable(Cart.class.getSimpleName());
            assert setActivity != null;
            textView_main.setText(setActivity.getName());
            mainImage.setImageResource(setActivity.getImage());
            et_width.setText(setActivity.getWidth() + "");
            et_height.setText(setActivity.getHeight() + "");

        }
    }

    public void Radiogroup(View view) {
        switch (view.getId()) {

            case R.id.rb_rehau:
                rg_rehau.setVisibility(View.VISIBLE);
                rg_wds.setVisibility(View.GONE);
                rg_wds.clearCheck();
                rg_opentech.setVisibility(View.GONE);
                rg_opentech.clearCheck();
                break;

            case R.id.rb_wds:
                rg_wds.setVisibility(View.VISIBLE);
                rg_rehau.setVisibility(View.GONE);
                rg_rehau.clearCheck();
                rg_opentech.setVisibility(View.GONE);
                rg_opentech.clearCheck();
                break;

            case R.id.rb_opentech:
                rg_opentech.setVisibility(View.VISIBLE);
                rg_rehau.setVisibility(View.GONE);
                rg_rehau.clearCheck();
                rg_wds.setVisibility(View.GONE);
                rg_wds.clearCheck();
                break;

            case R.id.chbx_windowsill:
                if (checkBoxSill.isChecked()) {
                    rgroupSill.setVisibility(View.VISIBLE);
                    llWindowSillSizes.setVisibility(View.VISIBLE);
                } else {
                    rgroupSill.clearCheck();
                    rgroupSill.setVisibility(View.GONE);
                    llWindowSillSizes.setVisibility(View.GONE);
                }
                break;

            case R.id.chbx_weadering:
                if (checkBoxWeathering.isChecked()) {
                    rgWeathering.setVisibility(View.VISIBLE);
                    llWeathering.setVisibility(View.VISIBLE);
                } else {
                    rgWeathering.clearCheck();
                    rgWeathering.setVisibility(View.GONE);
                    llWeathering.setVisibility(View.GONE);
                }
                break;
        }
    }

    //Метод для запуска диалога
    public void openDialogOrderResult(View view) {
        DialogUtils dialogUtils = new DialogUtils();
        dialogUtils.show(getSupportFragmentManager(), "DialogOrderResult");
    }
}
