package com.glumy.windplast;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.glumy.windplast.ActivityMain;
import com.glumy.windplast.Cart.Order;
import com.glumy.windplast.Cart.Storage;

import com.glumy.windplast.R;
import com.glumy.windplast.data.AdapterStorageCalculations;

import com.glumy.windplast.data.DBHelper;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import static com.glumy.windplast.data.DBHelper.TABLE_STORAGE;


public class ActivityStorageCalculations extends AppCompatActivity {

    private RecyclerView recyclerView;
    AdapterStorageCalculations adapter;

    TextView tv_number;
    TextView tv_name;
    TextView tv_address;
    TextView tv_comments;
    TextView tv_date;
    TextView tv_cost;
    private DBHelper dbHelper;
    private SQLiteDatabase mDatabase;
    View lyt_no_item;
    Cursor mCursor;
    CardView cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_calculations);

        initToolbar();
        initComponent();

            dbHelper = new DBHelper(this);

            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            adapter = new AdapterStorageCalculations(this, getAdapterItems());
            recyclerView.setAdapter(adapter);

        if (adapter.getItemCount() == 0) {
            showNoItemView();
        }

//        adapter.setOnItemClickListener(new AdapterStorageCalculations.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
            // dialogLoadStorage();
//                        Toast toast = Toast.makeText(getApplicationContext(), "Здесь и так ничего нет"+position, Toast.LENGTH_LONG);
//                        toast.setGravity(Gravity.CENTER, 0, 0);
//                        toast.show();
            //          }
            //      });
        }
 //   }
    private void initToolbar() {
        ActionBar actionBar;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle(R.string.myCalc);

    }

    private void initComponent() {
        tv_number = findViewById(R.id.tv_calcnumber);
        tv_name = findViewById(R.id.tv_product_name);
        tv_address = findViewById(R.id.tv_address);
        tv_comments = findViewById(R.id.tv_comment);
        tv_date = findViewById(R.id.tv_date);
        tv_cost = findViewById(R.id.tv_cost);
        lyt_no_item = findViewById(R.id.lyt_no_item);
        cv = findViewById(R.id.cv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_storage_calculations, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id = item.getItemId();
        if (item_id == android.R.id.home) {
            onBackPressed();
        } else if (item_id == R.id.action_delete) {
            if (adapter.getItemCount() == 0) {
//                Toast toast = Toast.makeText(getApplicationContext(), "Здесь и так ничего нет", Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//                toast.show();
                return true;
            }
            dialogDeleteConfirmation();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, ActivityMain.class);
        startActivity(i);

    }

    private void showNoItemView() {
  //      if (adapter.getItemCount() == 0) {
//            Toast toast = Toast.makeText(getApplicationContext(), "Расчетов нет", Toast.LENGTH_LONG);
//            toast.setGravity(Gravity.CENTER, 0, 0);
//            toast.show();
            lyt_no_item.setVisibility(View.VISIBLE);
            cv.setVisibility(View.GONE);
//        }else {
//            lyt_no_item.setVisibility(View.GONE);
//            cv.setVisibility(View.VISIBLE);
//        }
    }

    public void dialogDeleteConfirmation() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title_delete_confirm);
        builder.setMessage(getString(R.string.content_delete_confirm));
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface di, int i) {
                delDB();
                showNoItemView();
                di.dismiss();

            }
        });
        builder.setNegativeButton("Нет", null);
        builder.show();
    }

    private Cursor getAdapterItems() {
        mDatabase = new DBHelper(this).getReadableDatabase();
        String[] projection = {
                DBHelper.KEY_ID,
                DBHelper.KEY_NAME,
                DBHelper.KEY_ADDRESS,
                DBHelper.KEY_COMMENT,
                DBHelper.KEY_DATE,
                DBHelper.KEY_COST
        };
        return mDatabase.query(TABLE_STORAGE,
                null,
                // projection,
                null,
                null,
                null,
                null,
                null
        );
    }

    private void delDB() {
        mDatabase = dbHelper.getWritableDatabase();
        mDatabase.delete(TABLE_STORAGE, null, null);
 //       adapter.notifyDataSetChanged();
//        Toast toast = Toast.makeText(getApplicationContext(), "Стерлась вся база", Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        toast.show();

    }
}
//    private void dialogLoadStorage() {
//
//        final Dialog dialog = new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
//        dialog.setContentView(R.layout.dialog_load_storage);
//
//        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
//        lp.copyFrom(Objects.requireNonNull(dialog.getWindow()).getAttributes());
//        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//
//
//        Cursor cursor = database.query(DBHelper.TABLE_STORAGE, null, null, null, null, null, null);
//
//        ImageView iv_image = dialog.findViewById(R.id.image_top);
//       // iv_image.setImageResource(cursor.getInt(DBHelper.KEY_IMAGE));
//
//        TextView tv_number = dialog.findViewById(R.id.tv_number);
//        tv_number.setText("Расчет № " + cursor.getColumnIndex(DBHelper.KEY_ID));
//
//        TextView tv_name = dialog.findViewById(R.id.text_name);
//        tv_name.setText(cursor.getColumnIndex(DBHelper.KEY_NAME));
//
//        TextView tv_address = dialog.findViewById(R.id.tv_address);
//        tv_address.setText(cursor.getColumnIndex(DBHelper.KEY_ADDRESS));
//
//        TextView tv_comment = dialog.findViewById(R.id.tv_comment);
//        tv_comment.setText(cursor.getColumnIndex(DBHelper.KEY_COMMENT));
//
//        TextView tv_size = dialog.findViewById(R.id.tv_width_height_or_res);
//        tv_size.setText(cursor.getColumnIndex(DBHelper.KEY_SIZES));
//
//        TextView tv_amont = dialog.findViewById(R.id.tv_amount_or_res);
//        tv_amont.setText(cursor.getColumnIndex(DBHelper.KEY_AMOUNT));
//
//        TextView tv_square = dialog.findViewById(R.id.tv_square);
//        tv_square.setText(cursor.getColumnIndex(DBHelper.KEY_SQUARE));
//
//        TextView tv_profile = dialog.findViewById(R.id.tv_profile_or_res);
//        tv_profile.setText(cursor.getColumnIndex(DBHelper.KEY_PROFILE1));
//
//        TextView tv_profile2 = dialog.findViewById(R.id.tv_prof_second_part);
//        tv_profile2.setText(cursor.getColumnIndex(DBHelper.KEY_PROFILE2));
//
//        TextView tv_furnit = dialog.findViewById(R.id.tv_furniture_or_res);
//        tv_furnit.setText(cursor.getColumnIndex(DBHelper.KEY_FURNITURE));
//
//        TextView tv_qwantity_glasses = dialog.findViewById(R.id.tv_qwantity_glasses);
//        tv_qwantity_glasses.setText(cursor.getColumnIndex(DBHelper.KEY_QUANTITY_GLASSES));
//
//        TextView tv_glasses_or_res = dialog.findViewById(R.id.tv_glasses_or_res);
//        tv_glasses_or_res.setText(cursor.getColumnIndex(DBHelper.KEY_GLASSES));
//
//        TextView tv_manufacturer_sill = dialog.findViewById(R.id.tv_manufacturer_sill);
//        tv_manufacturer_sill.setText(cursor.getColumnIndex(DBHelper.KEY_MANUFACTURER_SILL));
//
//        TextView tv_manufacturer_weathering = dialog.findViewById(R.id.tv_manufacturer_weathering);
//        tv_manufacturer_weathering.setText(cursor.getColumnIndex(DBHelper.KEY_MANUFACTURER_WEATHERING));
//
//        TextView tv_mounting = dialog.findViewById(R.id.tv_mounting);
//        tv_mounting.setText(cursor.getColumnIndex(DBHelper.KEY_MOUNTING));
//
//        TextView tv_delivery = dialog.findViewById(R.id.tv_delivery);
//        tv_delivery.setText(cursor.getColumnIndex(DBHelper.KEY_DELIVERY));
//
//        TextView tv_cost = dialog.findViewById(R.id.price_or_res);
//        tv_cost.setText(cursor.getColumnIndex(DBHelper.KEY_COST + ""));
//
//        cursor.close();
//
//        ImageButton ib_back = dialog.findViewById(R.id.ib_back);
//        ib_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//                // onBackPressed();
//            }
//        });
//
//        ImageButton ib_transfer = dialog.findViewById(R.id.ib_transfer);
//        ib_transfer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Запускается mChooser", Toast.LENGTH_SHORT).show();
//                //  mChooser();
//            }
//        });
//
//        dialog.show();
//        Objects.requireNonNull(dialog.getWindow()).
//        setAttributes(lp);
//    }


//   private void readForAdapterFromDB() {
//  int sqlNumber = dbHelper.
//        String name = binding.nameEditText.getText().toString();
//        String desc = binding.descEditText.getText().toString();
//dbHelper = new DBHelper(this);
//               database = new DBHelper(this).getReadableDatabase();
//        String[] projection = {
//                DBHelper.KEY_ID,
//                DBHelper.KEY_NAME,
//                DBHelper.KEY_ADDRESS,
//                DBHelper.KEY_COMMENT,
//                DBHelper.KEY_DATE,
//                DBHelper.KEY_COST
//        };
//        String selection =
//                DBHelper.KEY_NAME + " like ? and " +
//                DBHelper.KEY_ADDRESS + " like ? and " +
//                DBHelper.KEY_COMMENT + " like ? and " +
//                DBHelper.KEY_DATE + " like ? and " +
//                DBHelper.KEY_COST + " like ? and " + " like ?";
//       String[] selectionArgs = {"%" + name + "%", date + "", "%" + desc + "%"};
//       Cursor cursor = database.query(
//                DBHelper.TABLE_STORAGE,     // Запрашиваемая таблица
//                projection,                               // Возвращаемый столбец
// //               selection,
//                null,
//                  null,                                          // Столбец для условия WHERE
////                selectionArgs,                            // Значение для условия WHERE
//                null,                                     // не группировать строки
//                null,                                     // не фильтровать по группам строк
//                null                                      // не сортировать
//        );
//        Log.d(TAG, "The total cursor count is " + cursor.getCount());
//recyclerView.setAdapter(new AdapterStorageCalculations(this, cursor));

//  }

//}
//    private void mChooser() {
//        Intent sendIntent = new Intent(Intent.ACTION_SEND);
//
//        String title = getResources().getString(R.string.app_name);
//
//        Intent chooser = Intent.createChooser(sendIntent, title);
//
//// Verify the original intent will resolve to at least one activity
//        if (sendIntent.resolveActivity(getPackageManager()) != null) {
//            startActivity(chooser);
//}


