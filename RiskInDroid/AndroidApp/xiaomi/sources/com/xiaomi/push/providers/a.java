package com.xiaomi.push.providers;

import _m_j.duv;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class a extends SQLiteOpenHelper {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Object f6459O000000o = new Object();
    private static int O00000Oo = 1;
    private static final String[] O00000o0 = {"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};

    public a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, O00000Oo);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f6459O000000o) {
            try {
                StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
                for (int i = 0; i < O00000o0.length - 1; i += 2) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    sb.append(O00000o0[i]);
                    sb.append(" ");
                    sb.append(O00000o0[i + 1]);
                }
                sb.append(");");
                sQLiteDatabase.execSQL(sb.toString());
            } catch (SQLException e) {
                duv.O000000o(e);
            }
        }
    }
}
