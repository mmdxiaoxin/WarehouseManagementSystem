package com.yangtze.flooring.wms.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.yangtze.flooring.wms.R;

public class WithdrawManageActivity extends AppCompatActivity {

    private Button withdrawButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_manage);

        withdrawButton = findViewById(R.id.withdraw_button);

        withdrawButton.setOnClickListener(v -> new Handler().postDelayed(() -> {
            Intent resultIntent = new Intent();
            // 你可以添加额外的数据到 resultIntent 中，如果需要
            setResult(Activity.RESULT_OK, resultIntent);
            finish(); // 结束 ScrollingActivity
        }, 1000));
    }
}