package com.vinnie.adapter.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 *
 * @author Vinnie
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding mViewDataBinding;
    private int viewType;

    public BaseViewHolder(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        setBinding(viewDataBinding);
    }

    public BaseViewHolder(ViewDataBinding viewDataBinding, int viewType) {
        super(viewDataBinding.getRoot());
        this.mViewDataBinding = viewDataBinding;
        this.viewType = viewType;
    }

    public BaseViewHolder(View view) {
        super(view);
    }

    public <T> T getBinding() {
        return (T) mViewDataBinding;
    }

    public void setBinding(ViewDataBinding viewDataBinding) {
        this.mViewDataBinding = viewDataBinding;
    }

    public int getViewType() {
        return viewType;
    }
}