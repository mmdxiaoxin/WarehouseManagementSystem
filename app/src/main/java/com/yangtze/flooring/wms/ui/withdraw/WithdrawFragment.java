package com.yangtze.flooring.wms.ui.withdraw;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yangtze.flooring.wms.R;

public class WithdrawFragment extends Fragment {

    private WithdrawViewModel mViewModel;

    public static WithdrawFragment newInstance() {
        return new WithdrawFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_withdraw, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WithdrawViewModel.class);
        // TODO: Use the ViewModel
    }

}