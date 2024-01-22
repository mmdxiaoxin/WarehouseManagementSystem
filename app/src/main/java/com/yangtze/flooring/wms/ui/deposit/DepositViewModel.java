package com.yangtze.flooring.wms.ui.deposit;


// DepositViewModel.java

import androidx.lifecycle.ViewModel;

import com.yangtze.flooring.wms.model.DepositRecord;

import java.util.ArrayList;
import java.util.List;

public class DepositViewModel extends ViewModel {

    private List<DepositRecord> generateSampleData() {
        List<DepositRecord> sampleData = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            DepositRecord record = new DepositRecord(
                    (int)(Math.random() * 1000000),
                    "2023-04-02",
                    "货物 " + i,
                    (int)(Math.random() * 100),
                    "Sample description " + i
            );
            sampleData.add(record);
        }
        return sampleData;
    }

    public List<DepositRecord> getSampleData() {
        return generateSampleData();
    }
}

