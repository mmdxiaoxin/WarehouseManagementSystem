// DataAdapter.java
package com.yangtze.flooring.wms.components.LockTable.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import com.yangtze.flooring.wms.R;

public class DataAdapter extends BaseAdapter {

    private final List<String> mListData;

    public DataAdapter(List<String> listData) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, null);
            holder.tvData = convertView.findViewById(R.id.tv_data1);
            holder.linContent = convertView.findViewById(R.id.lin_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Set data or perform other operations as needed

        return convertView;
    }

    static class ViewHolder {
        TextView tvData;
        LinearLayout linContent;
    }
}
