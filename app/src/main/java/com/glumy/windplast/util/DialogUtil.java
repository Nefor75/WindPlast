package com.glumy.windplast.util;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.glumy.windplast.R;


public class DialogUtil extends AppCompatDialogFragment {


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
                openDiaologSaveOrder().show();
            }
        });

        TextView tv_width_or_res = view.findViewById(R.id.tv_width_or_res);
        tv_width_or_res.setText(getArguments().getString("width_product"));//передались данные из ActivityProductDetails в этот диалог
        TextView tv_height_or_res = view.findViewById(R.id.tv_height_or_res);
        tv_height_or_res.setText(getArguments().getString("height_product"));//передались данные из ActivityProductDetails в этот диалог
        TextView et_amount_or_res = view.findViewById(R.id.tv_amount_or_res);
        et_amount_or_res.setText(getArguments().getString("et_amount"));
        TextView tv_square = view.findViewById(R.id.tv_square);
        tv_square.setText(Tools.getsquareProduct(tv_width_or_res.getText().toString(), tv_height_or_res.getText().toString()));

        TextView tv_profile_or_res = view.findViewById(R.id.tv_profile_or_res);
     //   tv_profile_or_res.setText(getArguments().getString("checkedRadiobuttonProfile"));

        TextView tv_width_sill_or_res = view.findViewById(R.id.tv_width_sill_or_res);
        tv_width_sill_or_res.setText(getArguments().getString("width_sill"));
        TextView tv_length_sill_or_res = view.findViewById(R.id.tv_length_sill_or_res);
        tv_length_sill_or_res.setText(getArguments().getString("length_sill"));

        TextView tv_width_weathering_or_res = view.findViewById(R.id.tv_width_weathering_or_res);
        tv_width_weathering_or_res.setText(getArguments().getString("width_weathering"));
        TextView tv_length_weathering_or_res = view.findViewById(R.id.tv_length_weathering_or_res);
        tv_length_weathering_or_res.setText(getArguments().getString("length_weathering"));

        return builder.create();
    }

    private AlertDialog openDiaologSaveOrder() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_save_result, null);
        InsetDrawable background = new InsetDrawable(getResources().getDrawable(R.drawable.image_splash), 0, 0,
                0, 0);
        background.setAlpha(100);

        builder.setView(view)

                .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        return builder.create();
    }
}