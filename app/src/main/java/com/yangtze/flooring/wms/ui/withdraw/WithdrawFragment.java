package com.yangtze.flooring.wms.ui.withdraw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.yangtze.flooring.wms.R;
import com.yangtze.flooring.wms.components.LockTable.NoscrollListView;
import com.yangtze.flooring.wms.components.LockTable.SyncHorizontalScrollView;
import com.yangtze.flooring.wms.model.Record;
import com.yangtze.flooring.wms.adapter.RecordDataAdapter;
import com.yangtze.flooring.wms.adapter.RecordDataLeftAdapter;

import java.util.List;

public class WithdrawFragment extends Fragment {

    private WithdrawViewModel withdrawViewModel;
    private NoscrollListView mLeft;
    private RecordDataLeftAdapter mRecordDataLeftAdapter;

    private NoscrollListView mData;
    private RecordDataAdapter mRecordDataAdapter;

    private SyncHorizontalScrollView mHeaderHorizontal;
    private SyncHorizontalScrollView mDataHorizontal;

    private List<Record> mListData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        withdrawViewModel = new ViewModelProvider(this).get(WithdrawViewModel.class);
        View root = inflater.inflate(R.layout.fragment_withdraw, container, false);
        mLeft = root.findViewById(R.id.withdraw_lv_left);
        mData = root.findViewById(R.id.withdraw_lv_data);
        mDataHorizontal = root.findViewById(R.id.withdraw_data_horizontal);
        mHeaderHorizontal = root.findViewById(R.id.withdraw_header_horizontal);
        mDataHorizontal.setScrollView(mHeaderHorizontal);
        mHeaderHorizontal.setScrollView(mDataHorizontal);
        initView();
        return root;
    }

    private void initView() {
        mListData = withdrawViewModel.getSampleData();

        mRecordDataLeftAdapter = new RecordDataLeftAdapter(mListData);
        mLeft.setAdapter(mRecordDataLeftAdapter);

        mRecordDataAdapter = new RecordDataAdapter(mListData);
        mData.setAdapter(mRecordDataAdapter);
    }

}