package _m_j;

import android.database.sqlite.SQLiteDatabase;

public final class rz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f2445O000000o = "id";
    public static String O00000Oo = "frequency";
    private static final String O00000o0 = ("CREATE TABLE IF NOT EXISTS ACL ( " + f2445O000000o + " TEXT PRIMARY KEY, " + O00000Oo + " INTEGER DEFAULT 0);");

    public static void O000000o(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(O00000o0);
    }
}
