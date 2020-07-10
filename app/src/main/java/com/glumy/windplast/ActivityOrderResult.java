package com.glumy.windplast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.glumy.windplast.Cart.OrderResult;
import com.glumy.windplast.util.Tools;

import java.util.ArrayList;

public class ActivityOrderResult extends AppCompatActivity {

    private static int counterCalculations = 1;//равен длинне массива просчетов??
    private EditText et_address, et_comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_result);

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
                    openDiaologSaveOrder();

                }
            });
        }
    }

    private AlertDialog openDiaologSaveOrder() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_save_result, null);

        builder.setView(view);
        final AlertDialog ad = builder.show();

        et_address = view.findViewById(R.id.editAddress);
        et_comment = view.findViewById(R.id.editComment);
        TextView tv_counterCalculations = view.findViewById(R.id.tv_counter_calculations);

        //  tv_counterCalculations.setText(counterCalculations);
        Button buttonSave = view.findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //здесь добавить в динамический массив просчет

                ArrayList<AlertDialog> storageDialog = new ArrayList<>();
//storageDialog.add(new Storage());
                // tv_counterCalculations.setText("2");//равен длинне массива просчетов?

                ad.dismiss();
                Toast toast = Toast.makeText(getApplicationContext(), R.string.text, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
        return builder.create();
    }
}
