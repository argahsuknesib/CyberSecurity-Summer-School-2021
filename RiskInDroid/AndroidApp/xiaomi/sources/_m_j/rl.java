package _m_j;

import android.database.sqlite.SQLiteDatabase;

public final class rl {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f2429O000000o = "id";
    public static String O00000Oo = "originid";
    public static String O00000o = "time";
    public static String O00000o0 = "frequency";
    private static final String O00000oO = ("CREATE TABLE IF NOT EXISTS AP ( " + f2429O000000o + " LONG PRIMARY KEY, " + O00000Oo + " LONG, " + O00000o0 + " INTEGER DEFAULT 0, " + O00000o + " LONG DEFAULT 0);");

    public static void O000000o(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(O00000oO);
    }
}
