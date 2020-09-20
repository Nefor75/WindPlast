package com.glumy.windplast.data;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;

import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import com.glumy.windplast.ActivityOrderResult;
import com.glumy.windplast.Cart.Storage;
import com.glumy.windplast.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;


public class AdapterStorageCalculations extends RecyclerView.Adapter<AdapterStorageCalculations.ViewHolder> {

    private LayoutInflater inflater;
    private List<Storage> items;

    public AdapterStorageCalculations(Context context, List<Storage> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_recycler, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Storage itemList = items.get(position);
        holder.imageRecicl.setImageResource(itemList.getImage());
        holder.tv_number.setText("Расчет № "+itemList.getNumber());
        holder.tv_name.setText(itemList.getName());
        holder.tv_address.setText(itemList.getAddress());
        holder.tv_comments.setText(itemList.getComment());
        holder.tv_date.setText(itemList.getDate());
        holder.tv_cost.setText(itemList.getCost() + " грн.");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Позиция расчета " + position, Snackbar.LENGTH_LONG).show();
          //  Intent intent = new Intent(getApplicationContext(), ActivityOrderResult.class);
          //      startActivity(intent);


            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final ImageView imageRecicl;
        final TextView tv_number;
        final TextView tv_name;
        final TextView tv_address;
        final TextView tv_comments;
        final TextView tv_date;
        final TextView tv_cost;

        public ViewHolder(View itemView) {
            super(itemView);
            imageRecicl = itemView.findViewById(R.id.image_product);
            tv_number = itemView.findViewById(R.id.tv_calcnumber);
            tv_name = (TextView) itemView.findViewById(R.id.tv_product_name);
            tv_address = (TextView) itemView.findViewById(R.id.tv_address);
            tv_comments = (TextView) itemView.findViewById(R.id.tv_comment);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_cost = (TextView) itemView.findViewById(R.id.tv_cost);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}