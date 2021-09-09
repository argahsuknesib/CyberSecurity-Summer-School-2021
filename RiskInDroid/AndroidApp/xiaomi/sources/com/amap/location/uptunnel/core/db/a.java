package com.amap.location.uptunnel.core.db;

import _m_j.ok;
import _m_j.td;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, ok.O00000oO() + "_uptunnel.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists count (ID integer PRIMARY KEY AUTOINCREMENT NOT NULL, type integer, value integer, time long)");
        sQLiteDatabase.execSQL(td.O000000o("event"));
        sQLiteDatabase.execSQL(td.O000000o("key_log"));
        sQLiteDatabase.execSQL(td.O000000o("log"));
        sQLiteDatabase.execSQL(td.O000000o("data_block"));
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
