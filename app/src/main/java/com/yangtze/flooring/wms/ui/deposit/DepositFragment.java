package com.yangtze.flooring.wms.ui.deposit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.yangtze.flooring.wms.R;
import com.yangtze.flooring.wms.components.LockTablePlus.ContentAdapter;
import com.yangtze.flooring.wms.components.LockTablePlus.Entity;
import com.yangtze.flooring.wms.components.LockTablePlus.TopTabAdpater;

import java.util.ArrayList;
import java.util.List;


public class DepositFragment extends Fragment {

    private DepositViewModel depositViewModel;
    private TextView tvLeftTitle;
    private RecyclerView rvTabRight;
    private LinearLayout llTopRoot;
    private RecyclerView recyclerContent;
    private SwipeRefreshLayout swipeRefresh;
    private List<Entity> mEntities = new ArrayList<>();
    private List<String> rightMoveDatas = new ArrayList<>();
    private List<String> topTabs = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        depositViewModel = new ViewModelProvider(this).get(DepositViewModel.class);
        View root = inflater.inflate(R.layout.fragment_deposit, container, false);

        tvLeftTitle = root.findViewById(R.id.tv_left_title);
        rvTabRight = root.findViewById(R.id.rv_tab_right);
        llTopRoot = root.findViewById(R.id.ll_top_root);
        recyclerContent = root.findViewById(R.id.recycler_content);
        swipeRefresh = root.findViewById(R.id.swipe_refresh);

        //处理顶部标题部分
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvTabRight.setLayoutManager(linearLayoutManager);
        TopTabAdpater topTabAdpater = new TopTabAdpater(requireContext());
        rvTabRight.setAdapter(topTabAdpater);
        for (int i = 0; i < 50; i++) {
            topTabs.add("类型" + i);
        }
        topTabAdpater.setDatas(topTabs);
        //处理内容部分
        recyclerContent.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerContent.setHasFixedSize(true);
        final ContentAdapter contentAdapter = new ContentAdapter(requireContext(),rvTabRight);
        recyclerContent.setAdapter(contentAdapter);

        recyclerContent.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    Entity entity = new Entity();
                    entity.setLeftTitle("贵州茅台" + i);
                    rightMoveDatas.clear();
                    for (int j = 0; j < 50; j++) {
                        rightMoveDatas.add("年份" + j);
                    }
                    entity.setRightDatas(rightMoveDatas);
                    mEntities.add(entity);
                }
                contentAdapter.setDatas(mEntities);
                Toast.makeText(requireContext(), "加载完毕,加载了30条数据", Toast.LENGTH_SHORT).show();
            }
        }, 1500);

        //下拉刷新
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerContent.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 50; i++) {
                            Entity entity = new Entity();
                            entity.setLeftTitle("贵州茅台" + i);
                            rightMoveDatas.clear();
                            for (int j = 0; j < 50; j++) {
                                rightMoveDatas.add("年份" + j);
                            }
                            entity.setRightDatas(rightMoveDatas);
                            mEntities.add(entity);
                        }
                        contentAdapter.setDatas(mEntities);
                        swipeRefresh.setRefreshing(false);
                        Toast.makeText(requireContext(), "刷新完毕,刷新了50条数据", Toast.LENGTH_SHORT).show();
                    }
                }, 1500);
            }
        });

        return root;
    }
}
