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

        // Define the number of records you want to generate
        int numberOfRecords = 100;

        for (int i = 1; i <= numberOfRecords; i++) {
            // Generate sample data and add it to the list
            DepositRecord record = new DepositRecord(
                    i,
                    "2022-01-01",
                    "Product " + i,
                    i * 5,  // Example: quantity increases with the record number
                    "Sample Remarks " + i
            );

            depositRecords.add(record);
        }

        return depositRecords;
    }

}
