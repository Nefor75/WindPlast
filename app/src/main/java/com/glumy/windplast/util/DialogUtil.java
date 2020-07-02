package com.glumy.windplast.util;

import android.app.Dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.glumy.windplast.R;


public class DialogUtil extends AppCompatDialogFragment {

    private int counterCalculations = 1;//равен длинне массива просчетов??
    private EditText et_saveOrder;
    public static final int DIALOG_ONE_PACKAGES = 1; // Идентификаторы диалоговых окон
    public static final int DIALOG_TWO_PACKAGES = 2;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_order_result, null);
        builder.setView(view);

        ImageButton ib_back = view.findViewById(R.id.ib_back);
        ib_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        ImageButton ib_transfer = view.findViewById(R.id.ib_transfer);
        ib_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        ImageButton ib_save = view.findViewById(R.id.ib_save);
        ib_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDiaologSaveOrder();

            }
        });

        TextView tv_width_height_or_res = view.findViewById(R.id.tv_width_height_or_res);
        String resultPlust = getString(R.string.width) + " " + getArguments().getString("width_product") + "    " + getString(R.string.height) + " " + getArguments().getString("height_product");
        tv_width_height_or_res.setText(resultPlust);

        TextView et_amount_or_res = view.findViewById(R.id.tv_amount_or_res);
        et_amount_or_res.setText(getArguments().getString("et_amount"));

        TextView tv_square = view.findViewById(R.id.tv_square);
        tv_square.setText(Tools.getsquareProduct(getArguments().getString("width_product"), getArguments().getString("height_product")));

        TextView tv_profile_or_res = view.findViewById(R.id.tv_profile_or_res);
        tv_profile_or_res.setText(getArguments().getString("Profile"));

        TextView tv_prof_second_part = view.findViewById(R.id.tv_prof_second_part);
        tv_prof_second_part.setText(getArguments().getString("ProfileSecondPart"));

        TextView tv_furniture_or_res = view.findViewById(R.id.tv_furniture_or_res);
        tv_furniture_or_res.setText(getArguments().getString("furniture"));

        TextView tv_quantity_glasses = view.findViewById(R.id.tv_qwantity_glasses);
        tv_quantity_glasses.setText(getArguments().getString("quantity_glasses"));

        TextView tv_glasses_or_res = view.findViewById(R.id.tv_glasses_or_res);
        tv_glasses_or_res.setText(getArguments().getString("glass"));

        TextView tv_manufacturer_sill = view.findViewById(R.id.tv_manufacturer_sill);
        tv_manufacturer_sill.setText(getArguments().getString("manufacturer_sill"));

        TextView tv_manufacturer_weathering = view.findViewById(R.id.tv_manufacturer_weathering);
        tv_manufacturer_weathering.setText(getArguments().getString("manufacturer_weathering"));

        return builder.create();
    }

    private AlertDialog openDiaologSaveOrder() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_save_result, null);

        builder.setView(view);
        final AlertDialog ad = builder.show();

        TextView tv_counterCalculations = view.findViewById(R.id.tv_counter_calculations);
        Button buttonSave = view.findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //здесь добавить в динамический массив просчет
                //List<> storageCalculations = new ArrayList();
                // tv_counterCalculations.setText("2");//равен длинне массива просчетов?
                ad.dismiss();
            }
        });
        return builder.create();
    }
}
