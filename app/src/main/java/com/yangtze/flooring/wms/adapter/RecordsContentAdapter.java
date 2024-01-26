package com.yangtze.flooring.wms.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yangtze.flooring.wms.R;
import com.yangtze.flooring.wms.model.Entity;

import java.util.HashSet;
import java.util.List;


public class RecordsContentAdapter extends RecyclerView.Adapter<RecordsContentAdapter.ItemViewHolder> {

    private final Context context;
    private List<Entity> data;
    private final HashSet<RecyclerView> observerList = new HashSet<>();
    private int firstPos = -1;
    private int firstOffset = -1;

    public RecordsContentAdapter(Context context, RecyclerView headRecycler) {
        this.context = context;
        //设置头部recycle
        initRecyclerView(headRecycler);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Entity> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_content, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.tvLeftTitle.setText(data.get(i).getLeftTitle());
        //右边滑动部分
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        itemViewHolder.rvItemRight.setLayoutManager(linearLayoutManager);
        itemViewHolder.rvItemRight.setHasFixedSize(true);
        RecordsRightScrollAdapter recordsRightScrollAdapter = new RecordsRightScrollAdapter(context);
        recordsRightScrollAdapter.setDatas(data.get(i).getRightDatas());
        itemViewHolder.rvItemRight.setAdapter(recordsRightScrollAdapter);

        //设置多条recyclerview联动
        initRecyclerView(itemViewHolder.rvItemRight);
    }

    @Override
    public int getItemCount() {
        return null == data ? 0 : data.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvLeftTitle;
        RecyclerView rvItemRight;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLeftTitle = itemView.findViewById(R.id.tv_left_title);
            rvItemRight = itemView.findViewById(R.id.rv_item_right);
        }
    }

    //多条recyclerview联动
    @SuppressLint("ClickableViewAccessibility")
    public void initRecyclerView(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        //为每一个recyclerview创建layoutManager
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        //todo
        // 通过移动layoutManager来实现列表滑动  此行是让新加载的item条目保持跟已经滑动的recyclerview位置保持一致
        // 也就是上拉加载更多的时候  保证新加载出来的item 跟已经滑动的item位置保持一致
        if (layoutManager != null && firstPos > 0 && firstOffset > 0) {
            layoutManager.scrollToPositionWithOffset(firstPos + 1, firstOffset);
        }
        // 添加所有的 recyclerView
        observerList.add(recyclerView);
        //当触摸条目的时候 停止滑动
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_POINTER_DOWN:
                        for (RecyclerView rv : observerList) {
                            rv.stopScroll();
                        }
                }
                return false;
            }
        });
        //添加当前滑动recyclerview的滑动监听
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                //获取显示第一个item的位置
                int firstPos1 = linearLayoutManager.findFirstVisibleItemPosition();
                View firstVisibleItem = linearLayoutManager.getChildAt(0);
                if (firstVisibleItem != null) {
                    //获取第一个item的偏移量
                    int firstRight = linearLayoutManager.getDecoratedRight(firstVisibleItem);
                    //遍历其它的所有的recyclerview条目
                    for (RecyclerView rv : observerList) {
                        if (recyclerView != rv) {
                            LinearLayoutManager layoutManager = (LinearLayoutManager) rv.getLayoutManager();
                            if (layoutManager != null) {
                                firstPos = firstPos1;
                                firstOffset = firstRight;
                                //通过当前显示item的位置和偏移量的位置来置顶recyclerview 也就是同步其它item的移动距离
                                layoutManager.scrollToPositionWithOffset(firstPos + 1, firstRight);
                            }
                        }
                    }
                }
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }
}
