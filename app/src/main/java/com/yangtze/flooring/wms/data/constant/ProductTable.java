package com.yangtze.flooring.wms.data.constant;

public class ProductTable {
    public static final String TABLE_NAME = "product";
    public static final String COLUMN_ID = "product_id";
    public static final String COLUMN_NAME = "product_name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_STOCK_QUANTITY = "stock_quantity";
    public static final String COLUMN_UNIT_PRICE = "unit_price";
    public static final String COLUMN_SUPPLIER_INFO = "supplier_info";
    public static final String COLUMN_IMAGE_PATH = "image_path";
    public static final String COLUMN_CATEGORY_ID = "category_id";
    public static final String COLUMN_DETAILS_ID = "details_id";

    // Other columns if needed

    // SQL commands
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME + " VARCHAR(50) NOT NULL," +
                    COLUMN_DESCRIPTION + " TEXT," +
                    COLUMN_STOCK_QUANTITY + " INTEGER," +
                    COLUMN_UNIT_PRICE + " DECIMAL(10,2)," +
                    COLUMN_SUPPLIER_INFO + " TEXT," +
                    COLUMN_IMAGE_PATH + " VARCHAR(255)," +
                    COLUMN_CATEGORY_ID + " INTEGER," +
                    COLUMN_DETAILS_ID + " INTEGER," +
                    "FOREIGN KEY(" + COLUMN_CATEGORY_ID + ") REFERENCES " +
                    CategoryTable.TABLE_NAME + "(" + CategoryTable.COLUMN_ID + ")," +
                    "FOREIGN KEY(" + COLUMN_DETAILS_ID + ") REFERENCES " +
                    DetailsTable.TABLE_NAME + "(" + DetailsTable.COLUMN_ID + "))";

    public static final String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}

