package com.yangtze.flooring.wms.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class NotificationsViewModel extends ViewModel {
    private final MutableLiveData<List<InventoryItem>> inventoryItems;

    public NotificationsViewModel() {
        inventoryItems = new MutableLiveData<>();
        loadSampleInventoryItems(); // Load sample data
    }

    public LiveData<List<InventoryItem>> getInventoryItems() {
        return inventoryItems;
    }

    private void loadSampleInventoryItems() {
        // Replace this with your actual data retrieval logic
        List<InventoryItem> items = new ArrayList<>();
        items.add(new InventoryItem("Product 1", "辅料", 10));
        items.add(new InventoryItem("Product 2", "木门", 20));
        // Add more items as needed

        // Update LiveData with new data
        inventoryItems.setValue(items);
    }
}
