package com.google.android.gms.common.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.stable.zzk;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Set;

public final class DbUtils {
    private DbUtils() {
    }

    public static void clearDatabase(SQLiteDatabase sQLiteDatabase) {
        zza(sQLiteDatabase, "table", "sqlite_sequence", "android_metadata");
        zza(sQLiteDatabase, "trigger", new String[0]);
        zza(sQLiteDatabase, "view", new String[0]);
    }

    public static long countCurrentRowBytes(Cursor cursor) {
        return countCurrentRowBytes(cursor, Charset.forName("UTF-8"));
    }

    public static long countCurrentRowBytes(Cursor cursor, Charset charset) {
        long j;
        int i;
        long j2 = 0;
        for (int i2 = 0; i2 < cursor.getColumnCount(); i2++) {
            int type = cursor.getType(i2);
            if (type == 0 || type == 1 || type == 2) {
                j = 4;
            } else {
                if (type == 3) {
                    i = cursor.getString(i2).getBytes(charset).length;
                } else if (type != 4) {
                } else {
                    i = cursor.getBlob(i2).length;
                }
                j = (long) i;
            }
            j2 += j;
        }
        return j2;
    }

    public static long getDatabaseSize(Context context, String str) {
        try {
            File databasePath = context.getDatabasePath(str);
            if (databasePath != null) {
                return databasePath.length();
            }
            return 0;
        } catch (SecurityException unused) {
            String valueOf = String.valueOf(str);
            Log.w("DbUtils", valueOf.length() != 0 ? "Failed to get db size for ".concat(valueOf) : new String("Failed to get db size for "));
            return 0;
        }
    }

    public static Integer getIntegerFromCursor(Cursor cursor, int i) {
        return getIntegerFromCursor(cursor, i, null);
    }

    public static Integer getIntegerFromCursor(Cursor cursor, int i, Integer num) {
        return (i < 0 || cursor.isNull(i)) ? num : Integer.valueOf(cursor.getInt(i));
    }

    public static Long getLongFromCursor(Cursor cursor, int i) {
        return getLongFromCursor(cursor, i, null);
    }

    public static Long getLongFromCursor(Cursor cursor, int i, Long l) {
        return (i < 0 || cursor.isNull(i)) ? l : Long.valueOf(cursor.getLong(i));
    }

    public static String getStringFromCursor(Cursor cursor, int i) {
        return getStringFromCursor(cursor, i, null);
    }

    public static String getStringFromCursor(Cursor cursor, int i, String str) {
        return (i < 0 || cursor.isNull(i)) ? str : cursor.getString(i);
    }

    public static void putIntegerIntoContentValues(ContentValues contentValues, String str, Integer num) {
        if (num != null) {
            contentValues.put(str, num);
        } else {
            contentValues.putNull(str);
        }
    }

    public static void putLongIntoContentValues(ContentValues contentValues, String str, Long l) {
        if (l != null) {
            contentValues.put(str, l);
        } else {
            contentValues.putNull(str);
        }
    }

    public static void putStringIntoContentValues(ContentValues contentValues, String str, String str2) {
        if (str2 != null) {
            contentValues.put(str, str2);
        } else {
            contentValues.putNull(str);
        }
    }

    private static void zza(SQLiteDatabase sQLiteDatabase, String str, String... strArr) {
        Throwable th;
        Preconditions.checkArgument("table".equals(str) || "view".equals(str) || "trigger".equals(str));
        Cursor query = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "type == ?", new String[]{str}, null, null, null);
        try {
            Set of = CollectionUtils.setOf((Object[]) strArr);
            while (query.moveToNext()) {
                String string = query.getString(0);
                if (!of.contains(string)) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 8 + String.valueOf(string).length());
                    sb.append("DROP ");
                    sb.append(str);
                    sb.append(" '");
                    sb.append(string);
                    sb.append("'");
                    sQLiteDatabase.execSQL(sb.toString());
                }
            }
            if (query != null) {
                query.close();
                return;
            }
            return;
        } catch (Throwable th2) {
            zzk.zza(th, th2);
        }
        throw th;
    }
}
