package com.vinnie.adapter.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

/**
 * 通用适配器
 * @param <T> XML布局对应的Binding文件
 * @param <R> List包含的元素类型
 */
public abstract class BaseRecyclerViewAdapter<T extends ViewDataBinding, R> extends RecyclerView.Adapter<BaseViewHolder> {

    private int layoutID;
    private List<R> list;

    public BaseRecyclerViewAdapter(int layoutID, List<R> list) {
        this.layoutID = layoutID;
        this.list = list;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), layoutID, viewGroup, false);
        return new BaseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        onBaseBindViewHolder((T) baseViewHolder.getBinding(), list.get(i), i);
    }

    public abstract void onBaseBindViewHolder(@NonNull T binding, R r, int i);

    @Override
    public int getItemCount() {
        if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    public void setOnClick(View view, final int i) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onViewClickListener != null) {
                    onViewClickListener.onClick(v, list.get(i), i);
                }
            }
        });
    }

    private OnViewClickListener onViewClickListener;
    public void setOnClickListener(OnViewClickListener onViewClickListener) {
        this.onViewClickListener = onViewClickListener;
    }

    public interface OnViewClickListener<R> {
        void onClick(View v, R r, int i);
    }
}
