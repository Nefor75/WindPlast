package com.glumy.windplast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
import com.glumy.windplast.data.Constant;
import com.glumy.windplast.util.DialogUtil;


public class ActivityProductDetails extends AppCompatActivity {

    private ImageView mainImage;

    public ImageView getMainImage() {
        return mainImage;
    }

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
    private CheckBox checkBoxWeathering, checkBoxSill;
    private RadioButton rb_sill_ukraine, rb_sill_usa;
    private RadioButton rb_weath_ukraine, rb_weath_usa;
    private LinearLayout llWindowSillSizes, llWeathering;
    private Button btnCalculation;
    private EditText et_amount;
    private String str_furniture = "Roto";
    private String str_profile = "Rehau";
    private String str_glass = "4/16/4";
    private String str_profile2part = "Euro Disign 60";
    private String str_manufacturer_sill = "Без подоконника";
    private String str_manufacturer_weathering = "Без отлива";
    private String str_quantity_glasses = "1 камер. ";


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

        rgroupSill = findViewById(R.id.radio_group_sill);
        rb_sill_ukraine = findViewById(R.id.rb_sill_ukraine);
        rb_sill_ukraine.setChecked(true);
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
                openDialog();

                break;
        }
    }

    private void openDialog() {
        DialogUtil dialog = new DialogUtil();
        Bundle dataProductDetails = new Bundle();
        dataProductDetails.putString("width_product", tv_width_product.getText().toString());
        dataProductDetails.putString("height_product", tv_height_product.getText().toString());
        dataProductDetails.putString("et_amount", et_amount.getText().toString());
        dataProductDetails.putString("Profile", str_profile);
        dataProductDetails.putString("ProfileSecondPart", str_profile2part);
        dataProductDetails.putString("furniture", str_furniture);
        dataProductDetails.putString("quantity_glasses", str_quantity_glasses);
        dataProductDetails.putString("glass", str_glass);
        dataProductDetails.putString("manufacturer_sill", str_manufacturer_sill);
        dataProductDetails.putString("manufacturer_weathering", str_manufacturer_weathering);
        dialog.setArguments(dataProductDetails);
        dialog.show(getSupportFragmentManager(), "onCreateDialog");
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


