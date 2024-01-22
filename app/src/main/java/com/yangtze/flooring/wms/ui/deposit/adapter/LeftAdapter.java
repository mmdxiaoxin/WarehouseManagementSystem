// LeftAdapter.java
package com.yangtze.flooring.wms.ui.deposit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yangtze.flooring.wms.R;
import com.yangtze.flooring.wms.model.DepositRecord;

import java.util.List;

public class LeftAdapter extends BaseAdapter {

    private final List<DepositRecord> mListData;

    public LeftAdapter(List<DepositRecord> listData) {
        this.mListData = listData;
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public Object getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left, null);
            holder.tvLeft = convertView.findViewById(R.id.tv_left);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvLeft.setText(String.valueOf(position));

        return convertView;
    }

    static class ViewHolder {
        TextView tvLeft;
    }
}
