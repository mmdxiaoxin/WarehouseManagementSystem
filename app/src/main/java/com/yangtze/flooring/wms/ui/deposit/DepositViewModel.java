package com.yangtze.flooring.wms.ui.deposit;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yangtze.flooring.wms.ui.deposit.model.DepositRecord;

import java.util.ArrayList;
import java.util.List;

public class DepositViewModel extends ViewModel {

    private final MutableLiveData<List<DepositRecord>> depositRecordsLiveData;

    public DepositViewModel() {
        depositRecordsLiveData = new MutableLiveData<>();
        // Initialize with sample data (replace with your actual data retrieval logic)
        List<DepositRecord> sampleData = getSampleDepositRecords();
        depositRecordsLiveData.setValue(sampleData);
    }

    public LiveData<List<DepositRecord>> getDepositRecords() {
        return depositRecordsLiveData;
    }

    private List<DepositRecord> getSampleDepositRecords() {
        List<DepositRecord> depositRecords = new ArrayList<>();
        // Add sample data
        depositRecords.add(new DepositRecord(1, "2022-01-01", "Product A", 10, "Sample Remarks 1"));
        depositRecords.add(new DepositRecord(2, "2022-01-02", "Product B", 15, "Sample Remarks 2"));
        // Add more items as needed
        return depositRecords;
    }
}
