package com.example.eduardo.doublerecyclerview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;

import com.example.eduardo.doublerecyclerview.R;
import com.example.eduardo.doublerecyclerview.recyclerview.FirstRecyclerAdapter;
import com.example.eduardo.doublerecyclerview.utils.Items;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mainRecyclerView;
    private List<List<Items>> listList = new ArrayList<>();
    private FirstRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainRecyclerView = findViewById(R.id.first_recycler);
        setRecyclerView();
        setData();

    }

    private void setRecyclerView() {
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapter = new FirstRecyclerAdapter(this);
        mainRecyclerView.setAdapter(adapter);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mainRecyclerView);
    }

    private void setData() {
        for (int i = 0; i < 5; i++) {
            List<Items> items = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                items.add(new Items(j, "Pagina " + i, "Item " + j));
            }
            listList.add(items);
        }

        adapter.swapData(listList);
        Log.d(TAG, "setData: " + listList.toString());
    }
}
