package com.yangtze.flooring.wms.data.constant;

public class DetailsTable {
    public static final String TABLE_NAME = "details";
    public static final String COLUMN_ID = "details_id";
    public static final String COLUMN_CATEGORY_ID = "category_id";
    public static final String COLUMN_NAME = "details_name";

    // Other columns if needed

    // SQL commands
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_CATEGORY_ID + " INTEGER," +
                    COLUMN_NAME + " VARCHAR(50) NOT NULL," +
                    "FOREIGN KEY(" + COLUMN_CATEGORY_ID + ") REFERENCES " +
                    CategoryTable.TABLE_NAME + "(" + CategoryTable.COLUMN_ID + "))";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}

