package com.yangtze.flooring.wms.ui.withdraw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yangtze.flooring.wms.R;
import com.yangtze.flooring.wms.ui.withdraw.adapter.WithdrawAdapter;

public class WithdrawFragment extends Fragment {

    private WithdrawViewModel withdrawViewModel;
    private RecyclerView recyclerView;
    private WithdrawAdapter withdrawAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        withdrawViewModel = new ViewModelProvider(this).get(WithdrawViewModel.class);
        View root = inflater.inflate(R.layout.fragment_withdraw, container, false);

        recyclerView = root.findViewById(R.id.withdraw_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        withdrawAdapter = new WithdrawAdapter();
        recyclerView.setAdapter(withdrawAdapter);

        // Observe the LiveData in ViewModel
        withdrawViewModel.getWithdrawRecords().observe(getViewLifecycleOwner(), withdrawRecords -> {
            // Update the UI
            withdrawAdapter.setDepositRecords(withdrawRecords);
            withdrawAdapter.notifyDataSetChanged();
        });

        return root;
    }

}