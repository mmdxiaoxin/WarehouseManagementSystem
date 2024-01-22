package com.yangtze.flooring.wms.ui.deposit;


// DepositViewModel.java
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class DepositViewModel extends ViewModel {

    private List<String> generateSampleData() {
        List<String> sampleData = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            sampleData.add("Row " + i);
        }
        return sampleData;
    }

    public List<String> getSampleData() {
        return generateSampleData();
    }
}

