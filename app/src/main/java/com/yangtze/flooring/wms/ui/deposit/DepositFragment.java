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
import com.yangtze.flooring.wms.adapter.RecordsContentAdapter;
import com.yangtze.flooring.wms.model.Entity;
import com.yangtze.flooring.wms.adapter.RecordsTopTabAdapter;

import java.util.ArrayList;
import java.util.List;


public class DepositFragment extends Fragment {

    private DepositViewModel depositViewModel;
    private TextView tvLeftTitle;
    private RecyclerView rvTabRight;
    private LinearLayout llTopRoot;
    private RecyclerView recyclerContent;
    private SwipeRefreshLayout swipeRefresh;
    private final List<Entity> mEntities = new ArrayList<>();
    private final List<String> topTabs = new ArrayList<>();

    private RecordsContentAdapter recordsContentAdapter;
    private boolean isLoading = false;

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
        RecordsTopTabAdapter recordsTopTabAdapter = new RecordsTopTabAdapter(requireContext());
        rvTabRight.setAdapter(recordsTopTabAdapter);

        topTabs.add("入库单号");
        topTabs.add("货物名称");
        topTabs.add("入库日期");
        topTabs.add("入库数量");
        topTabs.add("备注");

        recordsTopTabAdapter.setDatas(topTabs);

        //处理内容部分
        recyclerContent.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerContent.setHasFixedSize(true);
        recordsContentAdapter = new RecordsContentAdapter(requireContext(), rvTabRight);
        recyclerContent.setAdapter(recordsContentAdapter);

        recyclerContent.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    Entity entity = new Entity();
                    entity.setLeftTitle(String.valueOf(i));

                    List<String> rightMoveData = new ArrayList<>();

                    rightMoveData.add(String.valueOf((int) (Math.random() * 100000)));
                    rightMoveData.add("货物名称" + i);
                    rightMoveData.add("2023-04-02");
                    rightMoveData.add(String.valueOf((int) (Math.random() * 100)));
                    rightMoveData.add("备注" + i);

                    entity.setRightDatas(rightMoveData);
                    mEntities.add(entity);
                }
                recordsContentAdapter.setData(mEntities);
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
                            entity.setLeftTitle("刷新数据" + i);
                            List<String> rightMoveData = new ArrayList<>();

                            rightMoveData.add(String.valueOf((int) (Math.random() * 100000)));
                            rightMoveData.add("货物名称" + i);
                            rightMoveData.add("2023-04-02");
                            rightMoveData.add(String.valueOf((int) (Math.random() * 100)));
                            rightMoveData.add("备注" + i);

                            entity.setRightDatas(rightMoveData);
                            mEntities.add(entity);
                        }
                        recordsContentAdapter.setData(mEntities);
                        swipeRefresh.setRefreshing(false);
                        Toast.makeText(requireContext(), "刷新完毕,刷新了50条数据", Toast.LENGTH_SHORT).show();
                    }
                }, 1500);
            }
        });

        //上拉加载
        recyclerContent.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // 在这里添加判断是否滑动到底部的逻辑
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                int totalItemCount = layoutManager.getItemCount();
                if (lastVisibleItemPosition == totalItemCount - 1) {
                    // 滑动到底部，执行上拉加载操作
                    loadMoreData();
                }
            }
        });

        return root;
    }

    private void loadMoreData() {
        if (!isLoading) {
            isLoading = true;

            // 显示加载中的样式
            showLoadingIndicator();

            // 模拟延迟加载
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            // 在这里执行加载更多数据的逻辑
                            // 例如，加载更多数据到 mEntities 中
                            for (int i = 0; i < 20; i++) {
                                Entity entity = new Entity();
                                entity.setLeftTitle("新数据" + i);
                                List<String> rightMoveData = new ArrayList<>();
                                rightMoveData.add(String.valueOf((int) (Math.random() * 100000)));
                                rightMoveData.add("货物名称" + i);
                                rightMoveData.add("2023-04-02");
                                rightMoveData.add(String.valueOf((int) (Math.random() * 100)));
                                rightMoveData.add("备注" + i);
                                entity.setRightDatas(rightMoveData);
                                mEntities.add(entity);
                            }

                            // 隐藏加载中的样式
                            hideLoadingIndicator();

                            // 更新适配器
                            recordsContentAdapter.setData(mEntities);

                            // 设置isLoading为false，表示加载完成
                            isLoading = false;
                        }
                    },
                    1500 // 模拟延迟1.5秒
            );
        }
    }

    private void showLoadingIndicator() {
        // 在这里显示加载中的样式，可以是一个ProgressBar或其他加载动画
        // 例如，你可以在布局中添加一个ProgressBar，然后在这里设置它可见
        // progressBar.setVisibility(View.VISIBLE);
        Toast.makeText(requireContext(), "正在加载中...", Toast.LENGTH_SHORT).show();
    }

    private void hideLoadingIndicator() {
        // 在这里隐藏加载中的样式，可以是一个ProgressBar或其他加载动画
        // 例如，你可以在布局中添加一个ProgressBar，然后在这里设置它不可见
        // progressBar.setVisibility(View.GONE);
        Toast.makeText(requireContext(), "加载完成", Toast.LENGTH_SHORT).show();
    }
}
