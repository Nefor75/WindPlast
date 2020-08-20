package com.glumy.windplast.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.glumy.windplast.Cart.Storage;
import com.glumy.windplast.R;
import com.glumy.windplast.data.Constant;
import com.glumy.windplast.util.Tools;

import java.util.ArrayList;
import java.util.List;


public class AdapterStorageCalculations extends RecyclerView.Adapter<AdapterStorageCalculations.ViewHolder> {

    private List<Storage> listItems;
    private Context mContext;

    public AdapterStorageCalculations(List<Storage> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_recycler, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Storage itemList = listItems.get(position);
        holder.imageRecicl.setImageResource(itemList.getImage());
        holder.tv_name.setText(itemList.getName());
        holder.tv_address.setText(itemList.getAddress());
        holder.tv_comments.setText(itemList.getComment());
        holder.tv_date.setText(itemList.getDate());
        holder.tv_cost.setText(itemList.getCost() + "");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(mContext, "Recycle Click" + position, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        });
//        holder.tv_date.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
        //Display option menu

//                PopupMenu popupMenu = new PopupMenu(mContext, holder.tv_date);
//                popupMenu.inflate(R.menu.menu_activity_storage_calculations);
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//
//                        switch (item.getItemId()) {
//                            case R.id.action_delete:
//                                //Delete item
//                                listItems.remove(position);
//                                notifyDataSetChanged();
//                                Toast.makeText(mContext, "Deleted", Toast.LENGTH_LONG).show();
//                                break;
//                            default:
//                                break;
//                        }
//                        return false;
        //                   }
//                });
//                popupMenu.show();
        //           }
//        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageRecicl;
        public TextView tv_name;
        public TextView tv_address;
        public TextView tv_comments;
        public TextView tv_date;
        public TextView tv_cost;

        public ViewHolder(View itemView) {
            super(itemView);
            imageRecicl = itemView.findViewById(R.id.image_product);
            tv_name = (TextView) itemView.findViewById(R.id.tv_product_name);
            tv_address = (TextView) itemView.findViewById(R.id.tv_address);
            tv_comments = (TextView) itemView.findViewById(R.id.tv_comment);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_cost = (TextView) itemView.findViewById(R.id.tv_cost);
        }
    }
}