package com.yangtze.flooring.wms.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.yangtze.flooring.wms.R;
import com.yangtze.flooring.wms.databinding.FragmentHomeBinding;
import com.yangtze.flooring.wms.ui.DepositManageActivity;
import com.yangtze.flooring.wms.ui.WithdrawManageActivity;

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
        ImageButton testButton = root.findViewById(R.id.test_button);

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

        testButton.setOnClickListener(v -> {
            // 点击测试按钮时，启动测试

        });

        return root;
    }

    private void navigateToDepositManageFragment() {
        // 使用 Intent 启动 DepositManageActivity
        Intent intent = new Intent(getActivity(), DepositManageActivity.class);
        manageLauncher.launch(intent);
    }


    private void navigateToWithdrawManageFragment() {
        // 使用 Intent 启动 WithdrawManageActivity
        Intent intent = new Intent(getActivity(), WithdrawManageActivity.class);
        manageLauncher.launch(intent);
    }

    private void navigateToDepositRecordFragment() {
        Navigation.findNavController(binding.getRoot()).navigate(R.id.navigation_deposit);
    }

    private void navigateToWithdrawRecordFragment() {
        Navigation.findNavController(binding.getRoot()).navigate(R.id.navigation_withdraw);
    }

    private final ActivityResultLauncher<Intent> manageLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    // 处理来自 ScrollingActivity 的响应
                    Intent data = result.getData();
                    // 你可以从 data 中获取额外的信息，如果 ScrollingActivity 设置了响应数据
                }
            }
    );


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}