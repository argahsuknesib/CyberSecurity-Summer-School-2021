package _m_j;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.mi.mistatistic.sdk.controller.MiStatDatabaseHelper;
import java.util.ArrayList;

public final class cda {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f13649O000000o = "";
    public static boolean O00000Oo = false;
    private static MiStatDatabaseHelper O00000o0;

    public static void O000000o() {
        O00000o0 = new MiStatDatabaseHelper(ccx.O000000o());
    }

    public static void O000000o(cdm cdm) {
        MiStatDatabaseHelper miStatDatabaseHelper;
        cdh.O000000o();
        long O00000Oo2 = cdh.O00000Oo();
        cdg.O000000o();
        cdm.O000000o(cdg.O00000Oo());
        cdm.O000000o(O00000Oo2);
        if (cdm.O00000o0()) {
            cdg.O000000o();
            cdg.O00000o0();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("category", cdm.O00000o());
        contentValues.put("data", cdm.O00000oO());
        contentValues.put("ts", Long.valueOf(O00000Oo2));
        synchronized (O00000o0) {
            try {
                O00000o0.getWritableDatabase().insert("mistat_data", "", contentValues);
                miStatDatabaseHelper = O00000o0;
            } catch (SQLiteException e) {
                try {
                    cdc.O000000o("EventDAO", "Error to createSession ", e);
                    miStatDatabaseHelper = O00000o0;
                } catch (Throwable th) {
                    O00000o0.close();
                    throw th;
                }
            }
            miStatDatabaseHelper.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0059 A[SYNTHETIC] */
    public static ArrayList<cdm> O00000Oo() {
        MiStatDatabaseHelper miStatDatabaseHelper;
        ArrayList<cdm> arrayList = new ArrayList<>();
        cdh.O000000o();
        long O00000Oo2 = cdh.O00000Oo();
        synchronized (O00000o0) {
            Cursor cursor = null;
            try {
                Cursor query = O00000o0.getReadableDatabase().query("mistat_data", null, "ts  <= ? ", new String[]{String.valueOf(O00000Oo2)}, null, null, null);
                if (query == null || !query.moveToFirst()) {
                    if (query != null) {
                        query.close();
                    }
                    miStatDatabaseHelper = O00000o0;
                    miStatDatabaseHelper.close();
                } else {
                    do {
                        cdm cdm = new cdm();
                        long j = query.getLong(1);
                        String string = query.getString(2);
                        String string2 = query.getString(3);
                        cdm.O000000o(j);
                        cdm.O00000o = string;
                        cdm.O00000o0 = string2;
                        arrayList.add(cdm);
                    } while (query.moveToNext());
                    if (query != null) {
                    }
                    miStatDatabaseHelper = O00000o0;
                    miStatDatabaseHelper.close();
                }
            } catch (SQLiteException e) {
                try {
                    cdc.O000000o("EventDAO", "queryCustomEvent exception", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    miStatDatabaseHelper = O00000o0;
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    O00000o0.close();
                    throw th;
                }
            }
        }
        return arrayList;
    }

    public static void O000000o(long j) {
        MiStatDatabaseHelper miStatDatabaseHelper;
        synchronized (O00000o0) {
            try {
                cdc.O000000o("EventDAO", "deleteEventsByTS, ts:%d", Long.valueOf(j));
                O00000o0.getWritableDatabase().delete("mistat_data", "ts <=?", new String[]{String.valueOf(j)});
                miStatDatabaseHelper = O00000o0;
            } catch (SQLiteException e) {
                try {
                    cdc.O000000o("EventDAO", "Error while deleting event by ts from DB", e);
                    miStatDatabaseHelper = O00000o0;
                } catch (Throwable th) {
                    O00000o0.close();
                    throw th;
                }
            }
            miStatDatabaseHelper.close();
        }
    }
}
