package com.yangtze.flooring.wms.data.constant;

public class ImageTable {
    public static final String TABLE_NAME = "image";
    public static final String COLUMN_ID = "image_id";
    public static final String COLUMN_PRODUCT_ID = "product_id";
    public static final String COLUMN_IMAGE_PATH = "image_path";

    // Other columns if needed

    // SQL commands
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_PRODUCT_ID + " INTEGER," +
                    COLUMN_IMAGE_PATH + " VARCHAR(255)," +
                    "FOREIGN KEY(" + COLUMN_PRODUCT_ID + ") REFERENCES " +
                    ProductTable.TABLE_NAME + "(" + ProductTable.COLUMN_ID + "))";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}

