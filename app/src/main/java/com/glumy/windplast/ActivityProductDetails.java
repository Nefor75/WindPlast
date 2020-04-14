package com.glumy.windplast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.glumy.windplast.Cart.Cart;


public class ActivityProductDetails extends AppCompatActivity {//implements AdapterView.OnItemSelectedListener {

    private ImageView mainImage;
    private TextView textView_main;
    private EditText et_width;
    private EditText et_height;
    private RadioGroup rg_rehau, rg_wds, rg_opentech, rgroupSill, rgWeathering;
    private RadioButton rb_rehau, rb_wds, rb_opentech;
    private CheckBox checkBoxWeathering, checkBoxSill;
    private LinearLayout llWindowSillSizes, llWeathering;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        initComponent();
        // initSpinner();

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

//    private void initSpinner() {
//        final Spinner spinner_glasses = findViewById(R.id.spinner_glasses);
//        //Для вывода нестандартного(с изменяемыми параметрами цвета текста и т.д.) списка айтемов в спиннере, нужно
//        //создавать свой класс со своим адаптером
//        AdapterSpinner adapter = new AdapterSpinner(this, R.layout.spinner_item, Tools.glasses);
//    }
//
//    //Методы Спиннера
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//        switch (position) {
//            case 0:
//                // Toast.makeText(this, "Item1", Toast.LENGTH_SHORT).show();
//                break;
//            case 1:
//                // Toast.makeText(this, "Item2", Toast.LENGTH_SHORT).show();
//                break;
//        }
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }

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
        }
    }
}
//    @Override
//    public void onBackPressed() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Подтвердите действие");
//        builder.setMessage("Вы уверены что хотите выйти из приложения?");
//        builder.setPositiveButton("ДА", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//                finish();
//            }
//        });
//        builder.setNegativeButton("НЕТ", null);
//        builder.show();
//    }


////Класс с кастомным адаптером для спиннера к стеклопакетам--------------------------------------------------------------
//public class AdapterSpinner extends ArrayAdapter<String> {
//
//    AdapterSpinner(Context context, int textViewResourceId, String[] objects) {
//        super(context, textViewResourceId, objects);
//    }
//
//    @Override
//    public View getDropDownView(int position, View convertView, ViewGroup parent) {
//        return getCustomView(position, convertView, parent);
//    }
//
//    @NotNull
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return getCustomView(position, convertView, parent);
//    }
//
//    private View getCustomView(int position, View convertView, ViewGroup parent) {
//
//        LayoutInflater inflater = getLayoutInflater();
//        View row = inflater.inflate(R.layout.spinner_item, parent, false);
//        TextView label = (TextView) row.findViewById(R.id.spinner_item);
//        label.setText(Tools.glasses[position]);
////Можно поставить иконки возле спинеровых айтемов
////            ImageView icon = (ImageView) row.findViewById(R.id.icona);
////
////            if (glasses[position].equals("Котопятница")
////                    || glasses[position].equals("Субкота")) {
////                icon.setImageResource(R.drawable.ic_launcher_background);
////            } else {
////                icon.setImageResource(R.drawable.ic_launcher_background);
//
//        return row;
//    }
//  }
//}
////Кастомный адаптер--------------------------------------------------------------
