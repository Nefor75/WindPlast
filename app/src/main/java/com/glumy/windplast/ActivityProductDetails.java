package com.glumy.windplast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.glumy.windplast.Cart.Cart;
import com.glumy.windplast.Cart.Order;
import com.glumy.windplast.data.Constant;


public class ActivityProductDetails extends AppCompatActivity {

    public ImageView getMainImage() {
        return mainImage;
    }

    private ImageView mainImage;

    private TextView textView_main, tv_width_product, tv_height_product, tv_width_sill, tv_length_sill,
            tv_width_weathering, tv_length_weathering, tv_prof_second_part, tv_one_package, tv_two_package;
    private RadioGroup rg_rehau, rg_wds, rg_openteck, rg_furnit, rg_glasses, rgroupSill, rgWeathering, rg_profil;
    private RadioButton rb_rehau, rb_wds, rb_openteck;
    private RadioButton rb_rehau_60, rb_rehau_70, rb_rehau_brillant, rb_rehau_sineo, rb_rehau_geneo;
    private RadioButton rb_wds_5s, rb_wds_6s, rb_wds_7s, rb_wds_8s;
    private RadioButton rb_openteck_standart, rb_openteck_delux, rb_openteck_elit;
    private RadioButton rb_roto, rb_axor;
    private RadioButton rb_one_camera;
    private RadioButton rb_two_camera;
    private CheckBox checkBoxWeathering, checkBoxSill, checkBoxMounting, checkBoxDelivery;
    private RadioButton rb_sill_ukraine, rb_sill_usa;
    private RadioButton rb_weath_ukraine, rb_weath_usa;
    private LinearLayout llWindowSillSizes, llWeathering, llDelivery, ll_furnit;
    private Button btnCalculation;
    private EditText et_amount, et_delivery;
    private String str_width_product = "";
    private String str_height_product = "";
    private String str_amount = "";
    private String str_furniture = "Roto";
    private String str_profile = "Rehau";
    private String str_glass = "4/16/4";
    private String str_profile2part = "Euro Disign 60";
    private String str_manufacturer_sill = "Без подоконника";
    private String str_manufacturer_weathering = "Без отлива";
    private String str_quantity_glasses = "1 камер. ";
    private String str_mounting = "350 грн.";//эта сумма, сумма монтажа в Настройках и передается и добавляется к сумме Изделия в ActivityOrderResult
    private String str_delivery = " Доставка в пределах города";
    private int cost;
    private String str_name = "";
    private int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        initComponent();

    }

    @SuppressLint("SetTextI18n")
    private void initComponent() {

        //Передался экземпляр класса
        Bundle recivedMain = getIntent().getExtras();
        final Cart setActivity;
        if (recivedMain != null) {
            setActivity = (Cart) recivedMain.getSerializable(Cart.class.getSimpleName());
            assert setActivity != null;

            textView_main = findViewById(R.id.textView);
            textView_main.setText(setActivity.getName());

            str_name = setActivity.getName();
            String strDeaf = getResources().getString(R.string.deaf);
            String strDeaf2 = getResources().getString(R.string.two_deaf);
            if (str_name.equals(strDeaf)|str_name.equals(strDeaf2)) {
                ll_furnit = findViewById(R.id.ll_furnit);
                ll_furnit.setVisibility(View.GONE);//может какое-то другое поведение сделать????
                str_furniture = "Без фурнитуры";
            }

            mainImage = findViewById(R.id.imageView);

            mainImage.setImageResource(setActivity.getImage());
            image = setActivity.getImage();

            tv_width_product = findViewById(R.id.tv_width_product);
            tv_width_product.setText(setActivity.getWidth() + "");
            str_width_product = tv_width_product.getText().toString();

            tv_height_product = findViewById(R.id.tv_height_product);
            tv_height_product.setText(setActivity.getHeight() + "");
            str_height_product = tv_height_product.getText().toString();

            tv_width_sill = findViewById(R.id.tv_width_sill);
            tv_width_sill.setText(setActivity.getWidthSill() + "");

            tv_length_sill = findViewById(R.id.tv_length_sill);
            tv_length_sill.setText(setActivity.getLengthSill() + "");

            tv_width_weathering = findViewById(R.id.tv_width_weathering);
            tv_width_weathering.setText(setActivity.getWidthWeathering() + "");

            tv_length_weathering = findViewById(R.id.tv_length_weathering);
            tv_length_weathering.setText(setActivity.getLengthWeathering() + "");

            et_amount = findViewById(R.id.et_amount);
            et_amount.setText(setActivity.getAmount() + "");
            str_amount = et_amount.getText().toString();

            et_delivery = findViewById(R.id.et_delivery);

            tv_prof_second_part = findViewById(R.id.tv_prof_second_part);

            rg_profil = findViewById(R.id.rg_profil);

            rg_rehau = findViewById(R.id.rg_rehau);
            rb_rehau = findViewById(R.id.rb_rehau);
            rb_rehau.setChecked(true);

            rb_rehau_60 = findViewById(R.id.rb_euro_design_60);
            rb_rehau_60.setChecked(true);

            rb_rehau_70 = findViewById(R.id.rb_euro_design_70);

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
            tv_one_package = findViewById(R.id.tv_one_package);

            rb_two_camera = findViewById(R.id.rb_two_camera);
            tv_two_package = findViewById(R.id.tv_two_package);

            checkBoxSill = findViewById(R.id.chbx_windowsill);
            checkBoxWeathering = findViewById(R.id.chbx_weathering);
            checkBoxMounting = findViewById(R.id.chbx_mounting);
            checkBoxMounting.setChecked(true);
            checkBoxDelivery = findViewById(R.id.chbx_delivery);

            rgroupSill = findViewById(R.id.radio_group_sill);
            rb_sill_ukraine = findViewById(R.id.rb_sill_ukraine);
            rb_sill_ukraine.setChecked(true);
            rb_sill_usa = findViewById(R.id.rb_sill_usa);

            rgWeathering = findViewById(R.id.rg_weathering);
            rb_weath_ukraine = findViewById(R.id.rb_weath_ukraine);
            rb_weath_usa = findViewById(R.id.rb_weath_usa);

            llWindowSillSizes = findViewById(R.id.ll_windowsill_sizes);
            llWeathering = findViewById(R.id.ll_weathering);
            llDelivery = findViewById(R.id.ll_delivery);

            btnCalculation = findViewById(R.id.btn_calculation);
            cost = setActivity.getPrice();
        }
    }

    public void Radiogroup(View view) {

        switch (view.getId()) {

            case R.id.rb_rehau:
                str_profile = Constant.REHAU;
                rb_rehau_60.setChecked(true);
                str_profile2part = Constant.EURO_DESIGN_60;

                rg_rehau.setVisibility(View.VISIBLE);
                rg_wds.setVisibility(View.GONE);
                rg_openteck.setVisibility(View.GONE);

                break;

            case R.id.rb_euro_design_60:
                str_profile = Constant.REHAU;
                str_profile2part = Constant.EURO_DESIGN_60;

                break;

            case R.id.rb_euro_design_70:
                str_profile = Constant.REHAU;
                str_profile2part = Constant.EURO_DESIGN_70;

                break;

            case R.id.rb_brillant_design:
                str_profile = Constant.REHAU;
                str_profile2part = Constant.BRILLANT;

                break;

            case R.id.rb_synego:
                str_profile = Constant.REHAU;
                str_profile2part = Constant.SYNEGO;

                break;

            case R.id.rb_geneo:
                str_profile = Constant.REHAU;
                str_profile2part = Constant.GENEO;

                break;

            case R.id.rb_wds:
                str_profile = Constant.WDS;
                rb_wds_5s.setChecked(true);
                str_profile2part = Constant.WDS_5S;
                rg_wds.setVisibility(View.VISIBLE);
                rg_rehau.setVisibility(View.GONE);
                rg_openteck.setVisibility(View.GONE);

                break;

            case R.id.rb_wds_5s:
                str_profile = Constant.WDS;
                str_profile2part = Constant.WDS_5S;

                break;

            case R.id.rb_wds_6s:
                str_profile = Constant.WDS;
                str_profile2part = Constant.WDS_6S;

                break;

            case R.id.rb_wds_7s:
                str_profile = Constant.WDS;
                str_profile2part = Constant.WDS_7S;

                break;

            case R.id.rb_wds_8s:
                str_profile = Constant.WDS;
                str_profile2part = Constant.WDS_8S;

                break;

            case R.id.rb_openteck:
                str_profile = Constant.OPENTECK;
                rb_openteck_standart.setChecked(true);
                str_profile2part = Constant.OPENTECK_STANDARD;
                rg_openteck.setVisibility(View.VISIBLE);
                rg_rehau.setVisibility(View.GONE);
                rg_wds.setVisibility(View.GONE);

                break;

            case R.id.rb_openteck_standart:
                str_profile = Constant.OPENTECK;
                str_profile2part = Constant.OPENTECK_STANDARD;

                break;

            case R.id.rb_openteck_de_lux:
                str_profile = Constant.OPENTECK;
                str_profile2part = Constant.OPENTECK_DELUX;

                break;

            case R.id.rb_openteck_elit:
                str_profile = Constant.OPENTECK;
                str_profile2part = Constant.OPENTECK_ELIT;

                break;

            case R.id.rb_roto:
                str_furniture = Constant.ROTO;

                break;

            case R.id.rb_axor:
                str_furniture = Constant.AXOR;

                break;

            case R.id.chbx_windowsill:
                if (checkBoxSill.isChecked()) {
                    rgroupSill.setVisibility(View.VISIBLE);
                    llWindowSillSizes.setVisibility(View.VISIBLE);
                    rb_sill_ukraine.setChecked(true);
                    str_manufacturer_sill = "(укр) " + " " + getString(R.string.width1) + " " + tv_width_sill.getText() + "   " + getString(R.string.length1) + " " + tv_length_sill.getText();

                } else {
                    str_manufacturer_sill = " Без подоконника";
                    rgroupSill.setVisibility(View.GONE);
                    llWindowSillSizes.setVisibility(View.GONE);

                }
                break;

            case R.id.rb_sill_ukraine:
                str_manufacturer_sill = "(укр)  " + " " + getString(R.string.width1) + " " + tv_width_sill.getText() + "    " + getString(R.string.length1) + " " + tv_length_sill.getText();

                break;

            case R.id.rb_sill_usa:
                str_manufacturer_sill = "(сша)  " + getString(R.string.width1) + " " + tv_width_sill.getText() + "    " + getString(R.string.length1) + " " + tv_length_sill.getText();

                break;

            case R.id.chbx_weathering:
                if (checkBoxWeathering.isChecked()) {
                    rgWeathering.setVisibility(View.VISIBLE);
                    llWeathering.setVisibility(View.VISIBLE);
                    rb_weath_ukraine.setChecked(true);
                    str_manufacturer_weathering = "(укр)  " + getString(R.string.width1) + " " + tv_width_weathering.getText() + "   " + getString(R.string.length1) + " " + tv_length_weathering.getText();


                } else {
                    str_manufacturer_weathering = " Без отлива";
                    rgWeathering.setVisibility(View.GONE);
                    llWeathering.setVisibility(View.GONE);

                }
                break;

            case R.id.rb_weath_ukraine:
                str_manufacturer_weathering = "(укр)  " + getString(R.string.width1) + " " + tv_width_weathering.getText() + "   " + getString(R.string.length1) + " " + tv_length_weathering.getText();

                break;

            case R.id.rb_weath_usa:
                str_manufacturer_weathering = "(сша)  " + getString(R.string.width1) + " " + tv_width_weathering.getText() + "   " + getString(R.string.length1) + " " + tv_length_weathering.getText();

                break;

            case R.id.rb_one_camera:
                tv_two_package.setVisibility(View.GONE);
                tv_one_package.setVisibility(View.VISIBLE);
                str_quantity_glasses = "1 камер.";

                break;

            case R.id.chbx_mounting:
                if (checkBoxMounting.isChecked()) {//а он включен
                    str_mounting = " 350 грн.";//это если его выключали и опять включили
                } else {
                    str_mounting = " Без монтажа";
                }
                break;

            case R.id.chbx_delivery:
//                if (checkBoxDelivery.isChecked()) {
                llDelivery.setVisibility(View.VISIBLE);
                str_delivery = et_delivery.getText().toString();//нет подтверждения ввода?
//                } else {
//
//                    llDelivery.setVisibility(View.GONE);
//                    strDelivery = " Доставка в пределах города";
//                }
                break;

//            case R.id.et_delivery:
//                 if (et_delivery.getText().length() != 0) {
//
//                     et_delivery.clearFocus();
//                  }else {
//                     strDelivery = " Доставка в пределах города";
//                 }
//
//                break;

            case R.id.tv_one_package:
                openDialogOnePackages();

                break;

            case R.id.tv_two_package:
                openDialogTwoPackages();

                break;

            case R.id.rb_two_camera:
                tv_one_package.setVisibility(View.GONE);
                tv_two_package.setVisibility(View.VISIBLE);
                str_glass = tv_two_package.getText().toString();
                str_quantity_glasses = "2 камер.";

                break;

            case R.id.btn_calculation:

                Order reciveOrder = new Order(str_name, image, str_width_product, str_height_product, str_amount,
                        str_profile, str_profile2part, str_furniture, str_quantity_glasses, str_glass,
                        str_manufacturer_sill, str_manufacturer_weathering, str_mounting, str_delivery, cost);

                Intent i = new Intent(this, ActivityOrderResult.class);
                i.putExtra(Order.class.getSimpleName(), reciveOrder);
                startActivity(i);

                break;
        }
    }

    private AlertDialog openDialogOnePackages() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyAlertDialogTheme);
        LayoutInflater inflater = this.getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_one_packages, null);

        builder.setView(view);

        final ListView listViewUsual = view.findViewById(R.id.listview_usual);
        final ListView listViewFunc = view.findViewById(R.id.listview_function);
        final ListView listViewTinted = view.findViewById(R.id.listview_tinted);

        final String[] arrayUsualGlass = getResources().getStringArray(R.array.one_camera_usual);
        final String[] arrayFuncGlass = getResources().getStringArray(R.array.one_camera_func);
        final String[] arrayTintGlass = getResources().getStringArray(R.array.one_camera_tint);
        final AlertDialog ad = builder.show();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.item_for_listview, R.id.textForListview, arrayUsualGlass);
        listViewUsual.setAdapter(adapter);

        listViewUsual.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv_one_package.setText(arrayUsualGlass[position]);
                str_glass = tv_one_package.getText().toString();
                ad.dismiss();
            }
        });

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.item_for_listview, R.id.textForListview, arrayFuncGlass);
        listViewFunc.setAdapter(adapter1);

        listViewFunc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv_one_package.setText(arrayFuncGlass[position]);
                str_glass = tv_one_package.getText().toString();
                ad.dismiss();
            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                R.layout.item_for_listview, R.id.textForListview, arrayTintGlass);
        listViewTinted.setAdapter(adapter2);

        listViewTinted.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv_one_package.setText(arrayTintGlass[position]);
                str_glass = tv_one_package.getText().toString();
                ad.dismiss();
            }
        });
        return builder.create();
    }

    private AlertDialog openDialogTwoPackages() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyAlertDialogTheme);
        LayoutInflater inflater = this.getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_two_packages, null);


        builder.setView(view);
        final ListView listViewUsual2 = view.findViewById(R.id.listview_usual2);
        final ListView listViewFunc2 = view.findViewById(R.id.listview_function2);
        final ListView listViewTinted2 = view.findViewById(R.id.listview_tinted2);

        final String[] arrayUsualGlass2 = getResources().getStringArray(R.array.two_camera_usual);
        final String[] arrayFuncGlass2 = getResources().getStringArray(R.array.two_camera_func);
        final String[] arrayTintGlass2 = getResources().getStringArray(R.array.two_camera_tint);
        final AlertDialog ad2 = builder.show();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.item_for_listview, R.id.textForListview, arrayUsualGlass2);
        listViewUsual2.setAdapter(adapter);

        listViewUsual2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv_two_package.setText(arrayUsualGlass2[position]);
                str_glass = tv_two_package.getText().toString();
                ad2.dismiss();
            }
        });

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.item_for_listview, R.id.textForListview, arrayFuncGlass2);
        listViewFunc2.setAdapter(adapter1);

        listViewFunc2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv_two_package.setText(arrayFuncGlass2[position]);
                str_glass = tv_two_package.getText().toString();
                ad2.dismiss();
            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                R.layout.item_for_listview, R.id.textForListview, arrayTintGlass2);
        listViewTinted2.setAdapter(adapter2);

        listViewTinted2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv_two_package.setText(arrayTintGlass2[position]);
                str_glass = tv_two_package.getText().toString();
                ad2.dismiss();
            }
        });
        return builder.create();
    }


}
