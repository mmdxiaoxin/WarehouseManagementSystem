package com.yangtze.flooring.wms.ui.notifications;

import android.annotation.SuppressLint;
import android.os.Bundle;
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

public class NotificationsFragment extends Fragment {

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
}
