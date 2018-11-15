package com.vinnie.adapter.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.vinnie.adapter.MyAdapter;
import com.vinnie.adapter.R;
import com.vinnie.adapter.base.BaseRecyclerViewAdapter;
import com.vinnie.adapter.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<String> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        initData();
        initAdapter();
    }

    void initData() {
        list = new ArrayList<>();
        for (int i=0; i<20; i++) {
            list.add("ELEMENT " + i);
        }
    }

    void initAdapter() {
        adapter = new MyAdapter(list);
        binding.recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new BaseRecyclerViewAdapter.OnViewClickListener<String>() {
            @Override
            public void onClick(View v, String s, int i) {
                switch (v.getId()) {
                    case R.id.button:
                        showToast("Click Button ," + s + "," + i);
                        break;
                }
            }
        });
    }

    Toast toast;
    void showToast(String s) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT);
        toast.show();
    }
}