package com.yangtze.flooring.wms.ui.withdraw.model;

public class WithdrawRecord {

    private int recordId;
    private String withdrawDate;
    private String productName;
    private int withdrawQuantity;
    private String remarks;

    public WithdrawRecord(int recordId, String withdrawDate, String productName, int withdrawQuantity, String remarks) {
        this.recordId = recordId;
        this.withdrawDate = withdrawDate;
        this.productName = productName;
        this.withdrawQuantity = withdrawQuantity;
        this.remarks = remarks;
    }

    // Add getters for each field
    public int getRecordId() {
        return recordId;
    }

    public String getWithdrawDate() {
        return withdrawDate;
    }

    public String getProductName() {
        return productName;
    }

    public int getWithdrawQuantity() {
        return withdrawQuantity;
    }

    public String getRemarks() {
        return remarks;
    }
}

