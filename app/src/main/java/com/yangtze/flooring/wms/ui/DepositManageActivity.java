package com.yangtze.flooring.wms.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.View;

import com.yangtze.flooring.wms.R;
import com.yangtze.flooring.wms.databinding.ActivityDepositManageBinding;

public class DepositManageActivity extends AppCompatActivity {

    private ActivityDepositManageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDepositManageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(view -> {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            // 使用 Handler 延迟执行 finish()，实现2秒的停顿
            new Handler().postDelayed(() -> {
                Intent resultIntent = new Intent();
                // 你可以添加额外的数据到 resultIntent 中，如果需要
                setResult(Activity.RESULT_OK, resultIntent);
                finish(); // 结束 ScrollingActivity
            }, 1000);
        });
    }
}