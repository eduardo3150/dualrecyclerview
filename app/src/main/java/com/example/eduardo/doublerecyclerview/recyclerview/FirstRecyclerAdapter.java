package com.example.eduardo.doublerecyclerview.recyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eduardo.doublerecyclerview.R;
import com.example.eduardo.doublerecyclerview.utils.Items;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 3/9/18.
 */

public class FirstRecyclerAdapter extends RecyclerView.Adapter<FirstRecyclerAdapter.ViewHolder> {
    private static final String TAG = FirstRecyclerAdapter.class.getSimpleName();
    private List<List<Items>> itemFirstList = new ArrayList<>();
    private Context context;

    public FirstRecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.first_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(itemFirstList.get(holder.getAdapterPosition()));
        Log.d(TAG, "onBindViewHolder: " + position + " data " + itemFirstList.get(holder.getAdapterPosition()).toString());
    }

    @Override
    public int getItemCount() {
        return itemFirstList.size(); //Cantidad de recyclers deseados
    }

    public void swapData(List<List<Items>> listList) {
        if (itemFirstList != null) {
            itemFirstList.clear();
            itemFirstList.addAll(listList);

        } else {
            itemFirstList = listList;
        }
        notifyDataSetChanged();
        Log.d(TAG, "swapData: " + itemFirstList.toString());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final String TAG = ViewHolder.class.getSimpleName();
        private RecyclerView secondRecyclerView;
        private SecondRecyclerAdapter adapter;

        public ViewHolder(View itemView) {
            super(itemView);
            secondRecyclerView = itemView.findViewById(R.id.second_recycler);


        }

        public void bind(List<Items> itemsList) {
            secondRecyclerView.setLayoutManager(new GridLayoutManager(context, 3)); //5 columnas
            adapter = new SecondRecyclerAdapter(context);
            secondRecyclerView.setAdapter(adapter);
            adapter.swapData(itemsList);
            Log.d(TAG, "bind: " + itemsList.toString());
        }
    }
}
