package com.amap.location.uptunnel.core.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.amap.location.common.database.AbstractContentProvider;

public class DBProvider extends AbstractContentProvider {
    public static String O00000o = "com.amap.android.uptunnel.dbPersistent";
    private static Object O00000oO = new Object();
    private static volatile DBProvider O00000oo;
    private static Context O0000O0o;
    private a O0000OOo;

    private DBProvider(Context context) {
        O0000O0o = context;
        onCreate();
    }

    public static Uri O000000o(String str) {
        return Uri.parse("content://" + O00000o + "/" + str);
    }

    public static DBProvider O000000o(Context context) {
        try {
            if (O00000oo == null) {
                synchronized (O00000oO) {
                    if (O00000oo == null) {
                        O00000oo = new DBProvider(context.getApplicationContext());
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return O00000oo;
    }

    public final String O000000o() {
        return O00000o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.location.common.database.AbstractContentProvider.O000000o(java.lang.Integer, java.lang.String, android.database.sqlite.SQLiteOpenHelper):void
     arg types: [int, java.lang.String, com.amap.location.uptunnel.core.db.a]
     candidates:
      com.amap.location.common.database.AbstractContentProvider.O000000o(android.net.Uri, android.content.ContentValues, java.lang.String):int
      com.amap.location.common.database.AbstractContentProvider.O000000o(android.net.Uri, java.lang.String, java.lang.String[]):int
      com.amap.location.common.database.AbstractContentProvider.O000000o(java.lang.Integer, java.lang.String, android.database.sqlite.SQLiteOpenHelper):void */
    public final void O00000Oo() {
        a aVar = new a(O0000O0o);
        this.O0000OOo = aVar;
        O000000o((Integer) 1, "count", (SQLiteOpenHelper) aVar);
        O000000o((Integer) 2, "event", (SQLiteOpenHelper) aVar);
        O000000o((Integer) 3, "key_log", (SQLiteOpenHelper) aVar);
        O000000o((Integer) 4, "log", (SQLiteOpenHelper) aVar);
        O000000o((Integer) 5, "data_block", (SQLiteOpenHelper) aVar);
    }

    public final SQLiteDatabase O00000o0() {
        try {
            return this.O0000OOo.getWritableDatabase();
        } catch (Exception unused) {
            return null;
        }
    }
}
