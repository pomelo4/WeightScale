package com.pomelo.weightscale;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pomelo.weightscale.core.WeightDB;

/**
 * 数据适配器
 */
public class WeightDataAdapter extends BaseAdapter {

    private Context mContext;
    private String mCondition = null;

    protected class ViewHolder {
        TextView mWeightWeek;
        TextView mWeightData;
        TextView mWeightBMI;
        TextView mWeightValue;
    }

    public WeightDataAdapter(Context context, String condition) {
        mContext = context;
        mCondition = condition;
    }

    @Override
    public int getCount() {
        return WeightDB.getInstance().size(mCondition);
    }

    @Override
    public Object getItem(int position) {
        return WeightDB.getInstance().get(position,mCondition);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
