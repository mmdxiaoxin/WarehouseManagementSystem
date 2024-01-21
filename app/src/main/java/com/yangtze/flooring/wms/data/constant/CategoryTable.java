package com.yangtze.flooring.wms.data.constant;

public class CategoryTable {
    public static final String TABLE_NAME = "category";
    public static final String COLUMN_ID = "category_id";
    public static final String COLUMN_NAME = "category_name";

    // Other columns if needed

    // SQL commands
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME + " VARCHAR(50) NOT NULL)";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}
