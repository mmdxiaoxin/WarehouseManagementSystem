package com.yangtze.flooring.wms.ui.withdraw;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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
        // Add sample data
        withdrawRecords.add(new WithdrawRecord(1, "2022-01-03", "Product C", 10, "Sample Remarks 3"));
        withdrawRecords.add(new WithdrawRecord(2, "2022-01-04", "Product D", 15, "Sample Remarks 4"));
        // Add more items as needed
        return withdrawRecords;
    }
}