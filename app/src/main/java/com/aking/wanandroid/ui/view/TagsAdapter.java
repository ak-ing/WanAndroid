package com.aking.wanandroid.ui.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Rick on 2022-08-18  16:01.
 * God bless my code!
 *
 * @Description:
 */
public abstract class TagsAdapter {
    private OnDataSetChangeListener onDataSetChangeListener;

    public abstract int getCount();

    public abstract View getView(Context context, int position, ViewGroup parent);

    public abstract Object getItem(int position);

    public abstract int getPopularity(int position);

    public abstract void onThemeColorChanged(View view, int themeColor);

    public final void notifyDataSetChanged() {
        onDataSetChangeListener.onChange();
    }

    protected void setOnDataSetChangeListener(OnDataSetChangeListener listener) {
        onDataSetChangeListener = listener;
    }

    protected interface OnDataSetChangeListener {
        void onChange();
    }
}

