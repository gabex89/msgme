package com.smoothspark.msgme.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by SmoothSpark on 2018. 04. 29.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    private int currentPosition;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void onBind(int position) {
        currentPosition = position;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    protected abstract void clear();
}
