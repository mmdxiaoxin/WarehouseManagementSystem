package com.yangtze.flooring.wms.ui.notifications;

public class InventoryItem {

    private String productName;
    private String categoryName;
    private int quantity;

    public InventoryItem(String productName, String categoryName, int quantity) {
        this.productName = productName;
        this.categoryName = categoryName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getQuantity() {
        return quantity;
    }
}

