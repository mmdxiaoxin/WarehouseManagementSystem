package com.yangtze.flooring.wms.ui.deposit;

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
import com.yangtze.flooring.wms.ui.deposit.adapter.DataAdapter;
import com.yangtze.flooring.wms.ui.deposit.adapter.LeftAdapter;

import java.util.List;


public class DepositFragment extends Fragment {

    private DepositViewModel depositViewModel;
    private NoscrollListView mLeft;
    private LeftAdapter mLeftAdapter;

    private NoscrollListView mData;
    private DataAdapter mDataAdapter;

    private SyncHorizontalScrollView mHeaderHorizontal;
    private SyncHorizontalScrollView mDataHorizontal;

    private List<String> mListData;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        depositViewModel = new ViewModelProvider(this).get(DepositViewModel.class);
        View root = inflater.inflate(R.layout.fragment_deposit, container, false);
        mLeft = root.findViewById(R.id.lv_left);
        mData = root.findViewById(R.id.lv_data);
        mDataHorizontal = root.findViewById(R.id.data_horizontal);
        mHeaderHorizontal = root.findViewById(R.id.header_horizontal);
        mDataHorizontal.setScrollView(mHeaderHorizontal);
        mHeaderHorizontal.setScrollView(mDataHorizontal);

        initView();

        return root;
    }

    private void initView() {
        mListData = depositViewModel.getSampleData();

        mLeftAdapter = new LeftAdapter(mListData);
        mLeft.setAdapter(mLeftAdapter);

        mDataAdapter = new DataAdapter(mListData);
        mData.setAdapter(mDataAdapter);
    }
}
