package com.glumy.windplast.data;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;

import android.content.DialogInterface;
import android.content.Intent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Gravity;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import com.glumy.windplast.ActivityOrderResult;

import com.glumy.windplast.Cart.Order;
import com.glumy.windplast.Cart.Storage;
import com.glumy.windplast.R;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class AdapterStorageCalculations extends RecyclerView.Adapter<AdapterStorageCalculations.ViewHolder> {

    Context mContext;
    Cursor mCursor;
    SQLiteDatabase dbAdapter;

   // private List<Storage> items;
   // private OnItemClickListener onItemClickListener;

//    public interface OnItemClickListener {
//        void onItemClick(View view, int position);
//    }
//
//    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
//        this.onItemClickListener = onItemClickListener;
//    }

    public AdapterStorageCalculations(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_recycler, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        mCursor.moveToPosition(position);
        holder.bindCursor(mCursor);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Cursor del=dbAdapter.execSQL("delete from TABLE_STORAGE where Id="+v.get(position).getId());
//                v.remove(position);
//                notifyDataSetChanged();
//            }
//        });

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        //        final ImageView imageRecycl;
        public TextView tv_number;
        public TextView tv_name;
        public TextView tv_address;
        public TextView tv_comments;
        public TextView tv_date;
        public TextView tv_cost;

        public ViewHolder(View itemView) {
            super(itemView);
            //            imageRecycl = itemView.findViewById(R.id.image_product);
            tv_number = itemView.findViewById(R.id.tv_calcnumber);
            tv_name = (TextView) itemView.findViewById(R.id.tv_product_name);
            tv_address = (TextView) itemView.findViewById(R.id.tv_address);
            tv_comments = (TextView) itemView.findViewById(R.id.tv_comment);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_cost = (TextView) itemView.findViewById(R.id.tv_cost);
        }

        public void bindCursor(Cursor cursor) {
            tv_number.setText("Расчет № " + String.valueOf(cursor.getInt(
                    cursor.getColumnIndexOrThrow(DBHelper.KEY_ID)
            )));
            tv_name.setText(cursor.getString(
                    cursor.getColumnIndexOrThrow(DBHelper.KEY_NAME)
            ));
            tv_address.setText(cursor.getString(
                    cursor.getColumnIndexOrThrow(DBHelper.KEY_ADDRESS)
            ));
            tv_comments.setText(cursor.getString(
                    cursor.getColumnIndexOrThrow(DBHelper.KEY_COMMENT)
            ));
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(cursor.getLong(
                    cursor.getColumnIndexOrThrow(DBHelper.KEY_DATE)));
            tv_date.setText(new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
            tv_cost.setText(cursor.getString(
                    cursor.getColumnIndexOrThrow(DBHelper.KEY_COST)
            ));
        }
    }

    @Override
    public int getItemCount() {
            return mCursor.getCount();

    }

}