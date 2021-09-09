package _m_j;

import android.database.sqlite.SQLiteDatabase;

public final class rh {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f2426O000000o = "id";
    public static String O00000Oo = "lat";
    public static String O00000o = "acc";
    public static String O00000o0 = "lng";
    public static String O00000oO = "conf";
    public static String O00000oo = "timestamp";
    public static String O0000O0o = "frequency";
    private static final String O0000OOo = ("CREATE TABLE IF NOT EXISTS AP ( " + f2426O000000o + " LONG PRIMARY KEY, " + O00000Oo + " INTEGER, " + O00000o0 + " INTEGER, " + O00000o + " INTEGER, " + O00000oO + " INTEGER, " + O00000oo + " LONG, " + O0000O0o + " INTEGER DEFAULT 0);");

    public static void O000000o(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(O0000OOo);
    }
}
