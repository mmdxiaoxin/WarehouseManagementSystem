package com.yangtze.flooring.wms.data.constant;

public class StorageRecordTable {
    public static final String TABLE_NAME = "storage_record";
    public static final String COLUMN_ID = "record_id";
    public static final String COLUMN_ENTRY_DATE = "entry_date";
    public static final String COLUMN_PRODUCT_ID = "product_id";
    public static final String COLUMN_ENTRY_QUANTITY = "entry_quantity";
    public static final String COLUMN_REMARKS = "remarks";

    // Other columns if needed

    // SQL commands
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_ENTRY_DATE + " DATE," +
                    COLUMN_PRODUCT_ID + " INTEGER," +
                    COLUMN_ENTRY_QUANTITY + " INTEGER," +
                    COLUMN_REMARKS + " TEXT," +
                    "FOREIGN KEY(" + COLUMN_PRODUCT_ID + ") REFERENCES " +
                    ProductTable.TABLE_NAME + "(" + ProductTable.COLUMN_ID + "))";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}

