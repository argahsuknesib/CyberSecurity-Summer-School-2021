package com.mi.mistatistic.sdk.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MiStatDatabaseHelper extends SQLiteOpenHelper {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Object f5061O000000o = new Object();

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public MiStatDatabaseHelper(Context context) {
        super(context, "miglobalstat.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f5061O000000o) {
            sQLiteDatabase.execSQL(String.format("create table %s(_id integer primary key autoincrement, ts integer,start_time integer, end_time integer,network text)", "mistat_session"));
            sQLiteDatabase.execSQL(String.format("create table %s(_id integer primary key autoincrement, ts integer,category text,data text)", "mistat_data"));
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        close();
        super.finalize();
    }
}
