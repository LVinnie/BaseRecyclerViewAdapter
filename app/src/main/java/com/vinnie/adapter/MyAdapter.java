package com.vinnie.adapter;

import android.support.annotation.NonNull;

import com.vinnie.adapter.base.BaseRecyclerViewAdapter;
import com.vinnie.adapter.databinding.ViewItemBinding;

import java.util.List;

public class MyAdapter extends BaseRecyclerViewAdapter<ViewItemBinding, String> {

    public MyAdapter(List<String> list) {
        super(R.layout.view_item, list);
    }

    @Override
    public void onBaseBindViewHolder(@NonNull ViewItemBinding binding, String s, int i) {
        //初始化内容
        binding.textView.setText(s);

        //设置点击事件
        setOnClick(binding.button, i);

        //也可以直接设置
        /*binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo
            }
        });*/
    }
}