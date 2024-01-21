package com.yangtze.flooring.wms.ui.deposit.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.yangtze.flooring.wms.R;
import com.yangtze.flooring.wms.ui.deposit.model.DepositRecord;

import java.util.ArrayList;
import java.util.List;

public class DepositAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_ITEM = 1;

    private List<DepositRecord> depositRecords;

    public DepositAdapter() {
        depositRecords = new ArrayList<>();
    }

    public void setDepositRecords(List<DepositRecord> depositRecords) {
        this.depositRecords = depositRecords;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_deposit_header, parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_deposit_record, parent, false);
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            DepositRecord record = depositRecords.get(position - 1); // Subtract 1 for the header
            ((ItemViewHolder) holder).bind(record);
        }
    }

    @Override
    public int getItemCount() {
        // Add 1 for the header
        return depositRecords.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? VIEW_TYPE_HEADER : VIEW_TYPE_ITEM;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView recordIdTextView;
        TextView entryDateTextView;
        TextView productNameTextView;
        TextView entryQuantityTextView;
        TextView remarksTextView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            recordIdTextView = itemView.findViewById(R.id.recordIdTextView);
            entryDateTextView = itemView.findViewById(R.id.entryDateTextView);
            productNameTextView = itemView.findViewById(R.id.productNameTextView);
            entryQuantityTextView = itemView.findViewById(R.id.entryQuantityTextView);
            remarksTextView = itemView.findViewById(R.id.remarksTextView);
        }

        public void bind(DepositRecord record) {
            // Bind data to views
            recordIdTextView.setText(String.valueOf(record.getRecordId()));
            entryDateTextView.setText(record.getEntryDate());
            productNameTextView.setText(record.getProductName());
            entryQuantityTextView.setText(String.valueOf(record.getEntryQuantity()));
            remarksTextView.setText(record.getRemarks());
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

