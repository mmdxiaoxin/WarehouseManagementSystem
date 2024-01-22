package com.yangtze.flooring.wms.model;

public class Record {

    private int recordId;
    private String entryDate;
    private String productName;
    private int entryQuantity;
    private String remarks;

    public Record(int recordId, String entryDate, String productName, int entryQuantity, String remarks) {
        this.recordId = recordId;
        this.entryDate = entryDate;
        this.productName = productName;
        this.entryQuantity = entryQuantity;
        this.remarks = remarks;
    }

    // Add getters for each field
    public int getRecordId() {
        return recordId;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public String getProductName() {
        return productName;
    }

    public int getEntryQuantity() {
        return entryQuantity;
    }

    public String getRemarks() {
        return remarks;
    }
}

