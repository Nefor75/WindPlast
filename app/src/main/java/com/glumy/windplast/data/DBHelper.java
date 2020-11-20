package com.glumy.windplast.data;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.glumy.windplast.Cart.Storage;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "windplast.db";
    public static final String TABLE_STORAGE = "storage";

    public static final String KEY_ID = "_ID";
    //public static final String KEY_IMAGE = "image";
    public static final String KEY_NAME = "name";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_COMMENT = "comment";
//    public static final String KEY_SIZES = "sizes";
//    public static final String KEY_AMOUNT = "amount";
//    public static final String KEY_SQUARE = "square";
//    public static final String KEY_PROFILE1 = "profile1";
//    public static final String KEY_PROFILE2 = "profile2";
//    public static final String KEY_FURNITURE = "furniture";
//    public static final String KEY_QUANTITY_GLASSES = "quantity_glasses";
//    public static final String KEY_GLASSES = "glasses";
//    public static final String KEY_MANUFACTURER_SILL = "manufacturer_sill";
//    public static final String KEY_MANUFACTURER_WEATHERING = "manufacturer_weathering";
//    public static final String KEY_MOUNTING = "mounting";
//    public static final String KEY_DELIVERY = "delivery";
    public static final String KEY_DATE = "date";
    public static final String KEY_COST = "cost";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTableCart(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STORAGE);
        onCreate(db);
    }

    private void createTableCart(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_STORAGE + " ("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                // + KEY_IMAGE + " BLOB, "
                + KEY_NAME + " TEXT, "
                + KEY_ADDRESS + " TEXT, "
                + KEY_COMMENT + " TEXT, "
//                + KEY_SIZES + " TEXT, "
//                + KEY_AMOUNT + " TEXT, "
//                + KEY_SQUARE + " TEXT, "
//                + KEY_PROFILE1 + " TEXT, "
//                + KEY_PROFILE2 + " TEXT, "
//                + KEY_FURNITURE + " TEXT, "
//                + KEY_QUANTITY_GLASSES + " TEXT, "
//                + KEY_GLASSES + " TEXT, "
//                + KEY_MANUFACTURER_SILL + " TEXT, "
//                + KEY_MANUFACTURER_WEATHERING + " TEXT, "
//                + KEY_MOUNTING + " TEXT, "
//                + KEY_DELIVERY + " TEXT, "
                + KEY_DATE + " TEXT, "
                + KEY_COST + " TEXT "
                + ")";
        db.execSQL(CREATE_TABLE);
    }

//    private Storage getStoragelistByCursor(Cursor cur) {
//        Storage obj = new Storage();
//        obj.number = cur.getInt(cur.getColumnIndex(KEY_ID));
//        obj.name = cur.getString(cur.getColumnIndex(KEY_NAME));
//        // obj.image = cur.getString(cur.getColumnIndex(COL_WISH_IMAGE));
//        obj.address = cur.getString(cur.getColumnIndex(KEY_ADDRESS));
//        obj.comment = cur.getString(cur.getColumnIndex(KEY_COMMENT));
//        obj.date = cur.getString(cur.getColumnIndex(KEY_DATE));
//        obj.cost = cur.getInt(cur.getColumnIndex(KEY_COST));
//        return obj;
//    }
//
//    public List<Storage> getListStoragelistByCursor(Cursor cur) {
//        List<Storage> items = new ArrayList<>();
//        if (cur.moveToFirst()) {
//            do {
//                items.add(getStoragelistByCursor(cur));
//            } while (cur.moveToNext());
//        }
//        return items;
//    }
//
    public void delTable() {
        db.execSQL("DELETE FROM " + TABLE_STORAGE);
    }
    }


