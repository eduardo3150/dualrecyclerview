package com.example.eduardo.doublerecyclerview.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eduardo.doublerecyclerview.R;
import com.example.eduardo.doublerecyclerview.utils.Items;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 3/9/18.
 */

public class SecondRecyclerAdapter extends RecyclerView.Adapter<SecondRecyclerAdapter.ViewHolder> {
    private final String TAG = SecondRecyclerAdapter.class.getSimpleName();
    private List<Items> itemsSecondList = new ArrayList<>();
    private Context context;

    public SecondRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.second_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindView(itemsSecondList.get(holder.getAdapterPosition()));
    }


    @Override
    public int getItemCount() {
        return itemsSecondList.size();
    }

    public void swapData(List<Items> items) {
        if (itemsSecondList != null) {
            itemsSecondList.clear();
            itemsSecondList.addAll(items);

        } else {
            itemsSecondList = items;
        }
        notifyDataSetChanged();
        Log.d(TAG, "swapData: " + itemsSecondList.toString());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, subtitle;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subtitle);
        }

        private void bindView(Items items) {
            title.setText(items.getName());
            subtitle.setText(items.getDescription());
        }

    }
}
