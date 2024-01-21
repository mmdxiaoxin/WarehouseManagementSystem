package com.yangtze.flooring.wms.ui.withdraw;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yangtze.flooring.wms.ui.deposit.model.DepositRecord;
import com.yangtze.flooring.wms.ui.withdraw.model.WithdrawRecord;

import java.util.ArrayList;
import java.util.List;

public class WithdrawViewModel extends ViewModel {
    private final MutableLiveData<List<WithdrawRecord>> withdrawRecordsLiveData;

    public WithdrawViewModel() {
        withdrawRecordsLiveData = new MutableLiveData<>();
        // Initialize with sample data (replace with your actual data retrieval logic)
        List<WithdrawRecord> sampleData = getSampleWithdrawRecords();
        withdrawRecordsLiveData.setValue(sampleData);
    }

    public LiveData<List<WithdrawRecord>> getWithdrawRecords() {
        return withdrawRecordsLiveData;
    }

    private List<WithdrawRecord> getSampleWithdrawRecords() {
        List<WithdrawRecord> withdrawRecords = new ArrayList<>();

        // Define the number of records you want to generate
        int numberOfRecords = 100;

        for (int i = 1; i <= numberOfRecords; i++) {
            // Generate sample data and add it to the list
            WithdrawRecord record = new WithdrawRecord(
                    i,
                    "2023-04-02",
                    "Product " + i + "w",
                    i * 3,  // Example: quantity increases with the record number
                    "Sample description " + i
            );

            withdrawRecords.add(record);
        }

        return withdrawRecords;
    }
}