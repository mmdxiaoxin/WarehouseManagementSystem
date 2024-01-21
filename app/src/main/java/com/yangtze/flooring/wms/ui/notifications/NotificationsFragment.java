package com.yangtze.flooring.wms.ui.notifications;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yangtze.flooring.wms.databinding.FragmentNotificationsBinding;

import java.util.List;

public class NotificationsFragment extends Fragment implements OnItemClickListener {

    private FragmentNotificationsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        NotificationsViewModel notificationsViewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final InventoryAdapter adapter = new InventoryAdapter();
        recyclerView.setAdapter(adapter);

        // 设置 OnItemClickListener
        adapter.setOnItemClickListener(this);


        // Observe the LiveData in ViewModel
        notificationsViewModel.getInventoryItems().observe(getViewLifecycleOwner(), new Observer<List<InventoryItem>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChanged(List<InventoryItem> inventoryItems) {
                // Update the UI
                adapter.setInventoryItems(inventoryItems);
                adapter.notifyDataSetChanged();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(int position) {
        // 处理选中状态的更新，例如改变背景颜色或其他效果
        // position 是被点击项的位置
        Log.d("ItemClicked", "Item clicked at position: " + position);
    }
}
