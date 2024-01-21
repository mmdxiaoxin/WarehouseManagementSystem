package com.yangtze.flooring.wms.ui.deposit;

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
import com.yangtze.flooring.wms.ui.deposit.adapter.DepositAdapter;


public class DepositFragment extends Fragment {

    private DepositViewModel depositViewModel;
    private RecyclerView recyclerView;
    private DepositAdapter depositAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        depositViewModel = new ViewModelProvider(this).get(DepositViewModel.class);
        View root = inflater.inflate(R.layout.fragment_deposit, container, false);

        recyclerView = root.findViewById(R.id.deposit_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        depositAdapter = new DepositAdapter();
        recyclerView.setAdapter(depositAdapter);

        // Observe the LiveData in ViewModel
        depositViewModel.getDepositRecords().observe(getViewLifecycleOwner(), depositRecords -> {
            // Update the UI
            depositAdapter.setDepositRecords(depositRecords);
            depositAdapter.notifyDataSetChanged();
        });

        return root;
    }
}
