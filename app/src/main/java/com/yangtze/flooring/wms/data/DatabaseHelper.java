package com.yangtze.flooring.wms.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.yangtze.flooring.wms.data.constant.CategoryTable;
import com.yangtze.flooring.wms.data.constant.DetailsTable;
import com.yangtze.flooring.wms.data.constant.ImageTable;
import com.yangtze.flooring.wms.data.constant.ProductTable;
import com.yangtze.flooring.wms.data.constant.StorageRecordTable;
import com.yangtze.flooring.wms.data.constant.WithdrawalRecordTable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "warehouse_management.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建表
        db.execSQL(CategoryTable.CREATE_TABLE);
        db.execSQL(DetailsTable.CREATE_TABLE);
        db.execSQL(ProductTable.CREATE_TABLE);
        db.execSQL(StorageRecordTable.CREATE_TABLE);
        db.execSQL(WithdrawalRecordTable.CREATE_TABLE);
        db.execSQL(ImageTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 升级数据库，如果需要
    }
}

