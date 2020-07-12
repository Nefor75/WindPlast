package com.glumy.windplast.data;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.glumy.windplast.ActivityOrderResult;
import com.glumy.windplast.Cart.Storage;
import com.glumy.windplast.R;

import java.util.ArrayList;

public class AdapterStorageCalculations extends RecyclerView.Adapter<AdapterStorageCalculations.StorageAdapterViewHolder> {
    private ArrayList<Storage> storages;

    public ArrayList<Storage> getStorages() {
        return storages;
    }

    public static class StorageAdapterViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView tvNumberCalc;
        public TextView tvName;
        public TextView tvAddress;
        public TextView tvComment;
        public TextView tvDate;
        public TextView tvCost;

        public StorageAdapterViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_product);
            tvNumberCalc = itemView.findViewById(R.id.tv_calcnumber);
            tvName = itemView.findViewById(R.id.tv_product_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvComment = itemView.findViewById(R.id.tv_comment);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvCost = itemView.findViewById(R.id.tv_cost);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent i = new Intent(v.getContext(), ActivityOrderResult.class);
//                    startActivity(i);
                   int positionindex = getAdapterPosition();
                }
            });
        }
    }

    public AdapterStorageCalculations(ArrayList<Storage> storageList) {
        storages = storageList;
    }

    @Override
    public StorageAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_recycler, parent, false);
        return new StorageAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(StorageAdapterViewHolder holder, int position) {
        Storage currrentItem = storages.get(position);
        holder.mImageView.setImageResource(currrentItem.getImage());
        holder.tvNumberCalc.setText("Расчет № "+currrentItem.getNumbercalc());
        holder.tvName.setText(currrentItem.getName());
        holder.tvAddress.setText(currrentItem.getAddress());
        holder.tvComment.setText(currrentItem.getComment());
        holder.tvDate.setText(currrentItem.getDate());
        holder.tvCost.setText(currrentItem.getCost());
    }

    @Override
    public int getItemCount() {
        return storages.size();
    }
}
