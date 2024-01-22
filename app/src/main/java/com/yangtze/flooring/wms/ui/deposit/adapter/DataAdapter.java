// DataAdapter.java
package com.yangtze.flooring.wms.ui.deposit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yangtze.flooring.wms.R;
import com.yangtze.flooring.wms.model.DepositRecord;

import java.util.List;

public class DataAdapter extends BaseAdapter {

    private final List<DepositRecord> mListData;

    public DataAdapter(List<DepositRecord> listData) {
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
            holder.tvData1 = convertView.findViewById(R.id.tv_data1);
            holder.tvData2 = convertView.findViewById(R.id.tv_data2);
            holder.tvData3 = convertView.findViewById(R.id.tv_data3);
            holder.tvData4 = convertView.findViewById(R.id.tv_data4);
            holder.tvData5 = convertView.findViewById(R.id.tv_data5);
            holder.linContent = convertView.findViewById(R.id.lin_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Set data or perform other operations as needed
        holder.tvData1.setText(String.valueOf(mListData.get(position).getRecordId()));
        holder.tvData2.setText(mListData.get(position).getProductName());
        holder.tvData3.setText(mListData.get(position).getEntryDate());
        holder.tvData4.setText(String.valueOf(mListData.get(position).getEntryQuantity()));
        holder.tvData5.setText(mListData.get(position).getRemarks());

        return convertView;
    }

    static class ViewHolder {
        TextView tvData1;
        TextView tvData2;
        TextView tvData3;
        TextView tvData4;
        TextView tvData5;
        LinearLayout linContent;
    }
}
