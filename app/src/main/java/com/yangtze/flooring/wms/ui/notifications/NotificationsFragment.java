package com.yangtze.flooring.wms.ui.notifications;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yangtze.flooring.wms.R;
import com.yangtze.flooring.wms.databinding.FragmentNotificationsBinding;
import com.yangtze.flooring.wms.ui.notifications.adapter.DividerItemDecoration;
import com.yangtze.flooring.wms.ui.notifications.adapter.RecyclerAdapter;
import com.yangtze.flooring.wms.model.DataBean;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private RecyclerView mRecyclerView;
    private List<DataBean> dataBeanList;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        NotificationsViewModel notificationsViewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);
        mRecyclerView = binding.notificationsRecyclerView;

        //初始化数据
        initData();
        RecyclerAdapter mAdapter = new RecyclerAdapter(requireContext(), dataBeanList);

        int dividerHeight = getResources().getDimensionPixelSize(R.dimen.divider_height);
        int dividerColor = ContextCompat.getColor(requireContext(), R.color.neutral_color_division_line);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(requireContext(), dividerHeight, dividerColor);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setAdapter(mAdapter);

        // Scroll listener
        mAdapter.setOnScrollListener(pos -> mRecyclerView.scrollToPosition(pos));

        notificationsViewModel.getDataBeanList().observe(getViewLifecycleOwner(), dataBeans -> {
            // Update the UI
            dataBeanList = dataBeans;
            mAdapter.notifyDataSetChanged();
        });
        return root;
    }

    private void initData() {
        dataBeanList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            DataBean dataBean = new DataBean();
            dataBean.setID(String.valueOf(i));
            dataBean.setType(0);
            dataBean.setParentLeftTxtName("货物" + i);
            dataBean.setParentRightTxtCategory("种类" + i);
            dataBean.setParentRightTxtQuantity(String.valueOf(i * 10));
            dataBean.setChildLeftTxt("子--" + i);
            dataBean.setChildRightTxt("子内容--" + i);
            dataBean.setChildBean(dataBean);
            dataBeanList.add(dataBean);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
