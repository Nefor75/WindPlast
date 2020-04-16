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
    private RadioGroup rg_rehau, rg_wds, rg_opentech, rgroupSill, rgWeathering;
    private RadioButton rb_rehau, rb_wds, rb_opentech;
    private CheckBox checkBoxWeathering, checkBoxSill;
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
        rg_wds = findViewById(R.id.rg_wds);
        rg_opentech = findViewById(R.id.rg_openteck);

        rb_rehau = findViewById(R.id.rb_rehau);
        rb_wds = findViewById(R.id.rb_wds);
        rb_opentech = findViewById(R.id.rb_openteck);

        checkBoxSill = findViewById(R.id.chbx_windowsill);
        checkBoxWeathering = findViewById(R.id.chbx_weadering);

        rgroupSill = findViewById(R.id.radio_group_sill);
        rgWeathering = findViewById(R.id.rg_weathering);

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

            case R.id.rb_openteck:
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
                    rgroupSill.setVisibility(View.GONE);
                    llWindowSillSizes.setVisibility(View.GONE);
                }
                break;

            case R.id.chbx_weadering:
                if (checkBoxWeathering.isChecked()) {
                    rgWeathering.setVisibility(View.VISIBLE);
                    llWeathering.setVisibility(View.VISIBLE);
                } else {
                    rgWeathering.setVisibility(View.GONE);
                    llWeathering.setVisibility(View.GONE);
                }
                break;
            case R.id.btn_calculation:
                openDialogOrderResult();

                break;
        }
    }

    public void openDialogOrderResult() {
        DialogUtils dialogUtils = new DialogUtils();
        dialogUtils.show(getSupportFragmentManager(), "DialogOrderResult");

    }
}
