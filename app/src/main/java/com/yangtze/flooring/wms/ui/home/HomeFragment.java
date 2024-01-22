package com.yangtze.flooring.wms.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.yangtze.flooring.wms.R;
import com.yangtze.flooring.wms.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ImageButton depositManageButton = root.findViewById(R.id.deposit_manageButton);
        ImageButton withdrawManageButton = root.findViewById(R.id.withdraw_manageButton);
        ImageButton depositRecordButton = root.findViewById(R.id.deposit_recordButton);
        ImageButton withdrawRecordButton = root.findViewById(R.id.withdraw_recordButton);

        depositManageButton.setOnClickListener(v -> {
            // 点击入库管理按钮时，启动入库管理 Fragment
            navigateToDepositManageFragment();
        });

        withdrawManageButton.setOnClickListener(v -> {
            // 点击出库管理按钮时，启动出库管理 Fragment
            navigateToWithdrawManageFragment();
        });

        depositRecordButton.setOnClickListener(v -> {
            // 点击入库记录按钮时，启动入库记录 Fragment
            navigateToDepositRecordFragment();
        });

        withdrawRecordButton.setOnClickListener(v -> {
            // 点击出库记录按钮时，启动出库记录 Fragment
            navigateToWithdrawRecordFragment();
        });

        return root;
    }

    private void navigateToDepositManageFragment() {
        // 启动入库管理 Fragment 的逻辑
        // 使用 FragmentTransaction 替换当前的 Fragment 为入库管理 Fragment
        // 例如：
        // FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        // transaction.replace(R.id.fragment_container, new DepositManageFragment());
        // transaction.addToBackStack(null);
        // transaction.commit();
    }

    private void navigateToWithdrawManageFragment() {
        // 启动出库管理 Fragment 的逻辑
        // 使用 FragmentTransaction 替换当前的 Fragment 为出库管理 Fragment
        // 例如：
        // FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        // transaction.replace(R.id.fragment_container, new WithdrawManageFragment());
        // transaction.addToBackStack(null);
        // transaction.commit();
    }

    private void navigateToDepositRecordFragment() {
        Navigation.findNavController(binding.getRoot()).navigate(R.id.navigation_deposit);
    }

    private void navigateToWithdrawRecordFragment() {
        Navigation.findNavController(binding.getRoot()).navigate(R.id.navigation_withdraw);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}