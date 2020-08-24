package com.glumy.windplast;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;

import com.glumy.windplast.Cart.Order;
import com.glumy.windplast.Cart.Storage;

import com.glumy.windplast.data.AdapterStorageCalculations;
import com.glumy.windplast.data.Constant;
import com.glumy.windplast.util.Tools;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ActivityStorageCalculations extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Storage> listItems;
    private AdapterStorageCalculations adapter;
    private int image;
    private ImageView iv_arrow_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_calculations);

       // recyclerView.getAdapter();

        Bundle reciveToStorage = getIntent().getExtras();
        final Storage setActivity;
        if (reciveToStorage != null) {
            setActivity = (Storage) reciveToStorage.getSerializable(Storage.class.getSimpleName());
            assert setActivity != null;

            image = setActivity.getImage();
            int number = setActivity.getNumber();
            String str_name = setActivity.getName();
            String str_address = setActivity.getAddress();
            String str_comments = setActivity.getComment();

            int cost = setActivity.getCost();
            Date date = new Date();
            String str_date = date.toString();
            String str_date2 = Tools.getFormattedDateSimple(str_date);

            iv_arrow_back = findViewById(R.id.image_arrow_back);
            iv_arrow_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), ActivityMain.class);
                    startActivity(i);
                }
            });

            listItems = new ArrayList<>();
           // for (Storage s:listItems)
           // for (int i = 0; i < 10; i++) {

           // int insertIndex = 1;
            listItems.add(new Storage(image, number, str_name, str_address, str_comments, str_date2, cost));
            listItems.add(new Storage(image, number, str_name, str_address, str_comments, str_date2, cost));

            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new AdapterStorageCalculations(listItems, this);
           // adapter.notifyDataSetChanged();
            recyclerView.setAdapter(adapter);
                //оригинал listItems.add(new Storage("Item " + (i + 1), "Welcome to Torisan channel, this is description of item " + (i+1), 1));
          //  }

         // adapter.notifyItemInserted(listItems.size()-1);
        }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_activity_storage_calculations, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int item_id = item.getItemId();
//        if (item_id == android.R.id.im) {
//            super.onBackPressed();
////        } else if (item_id == R.id.action_delete) {
////            if (adapter.getItemCount() == 0) {
////                Snackbar.make(parent_view, "Нет прощетов", Snackbar.LENGTH_SHORT).show();
////                return true;
//           }
//          //  dialogDeleteConfirmation();
////        }
//        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), ActivityMain.class);
        startActivity(i);
    }

//       public void dialogDeleteConfirmation() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Подтвердите удаление");
//        builder.setMessage(getString(R.string.axor) + getString(R.string.invalid_comment));
//        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface di, int i) {
//                di.dismiss();
//                deleteStorage();
//                startLoadMoreAdapter();
//                Snackbar.make(parent_view, "R.string.delete_success", Snackbar.LENGTH_SHORT).show();
//            }
//        });
//        builder.setNegativeButton("R.string.CANCEL", null);
//        builder.show();
//    }


    public void deleteStorage() {
        listItems.clear();
        Toast toast = Toast.makeText(getApplicationContext(), R.string.text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

    public List<Storage> getListItems() {
        return listItems;
    }
}
