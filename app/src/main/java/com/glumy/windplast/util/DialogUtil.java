package com.glumy.windplast.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.glumy.windplast.ActivityProductDetails;
import com.glumy.windplast.R;
import com.glumy.windplast.data.Constant;


public class DialogUtil extends AppCompatDialogFragment {

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
                openDiaologSaveOrder().show();

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

        TextView tv_glasses_or_res = view.findViewById(R.id.tv_glasses_or_res);
        tv_glasses_or_res.setText(getArguments().getString("glass"));

        TextView tv_manufacturer_sill = view.findViewById(R.id.tv_manufacturer_sill);
        tv_manufacturer_sill.setText(getArguments().getString("manufacturer_sill"));

        TextView tv_manufacturer_weathering = view.findViewById(R.id.tv_manufacturer_weathering);
        tv_manufacturer_weathering.setText(getArguments().getString("manufacturer_weathering"));

        return builder.create();
    }

//---------------------------------------------------------------------------------------------------------------------
//    public static AlertDialog getDialog(Activity activity, int ID) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//
//        switch (ID) {
//            case DIALOG_ONE_PACKAGES:
//                int[] single = Constant.singlePackage;
//                builder.setTitle(R.string.choice_glasses);
//                builder.setItems(R.array.one_camera, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                    //TextView tvsingle = ActivityProductDetails.
//
//                    }
//                });
//                return builder.create();
//
//            case DIALOG_TWO_PACKAGES:
//                View view = activity.getLayoutInflater().inflate(R.layout.dialog_two_packages, null);
//                builder.setView(view);
//
//                builder.setTitle(R.string.choice_glasses);
//                builder.setItems(R.array.two_camera, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//
//                        dialog.dismiss();
//                    }
//                });
//                return builder.create();
//            default:
//                return null;
//        }
//    }
//----------------------------------------------------------------------------------------------------
    private AlertDialog openDiaologSaveOrder() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_save_result, null);

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
