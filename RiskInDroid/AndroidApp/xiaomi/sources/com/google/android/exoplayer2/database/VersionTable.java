package com.google.android.exoplayer2.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public final class VersionTable {
    private VersionTable() {
    }

    public static void setVersion(SQLiteDatabase sQLiteDatabase, int i, String str, int i2) throws DatabaseIOException {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))");
            ContentValues contentValues = new ContentValues();
            contentValues.put("feature", Integer.valueOf(i));
            contentValues.put("instance_uid", str);
            contentValues.put("version", Integer.valueOf(i2));
            sQLiteDatabase.replaceOrThrow("ExoPlayerVersions", null, contentValues);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    public static void removeVersion(SQLiteDatabase sQLiteDatabase, int i, String str) throws DatabaseIOException {
        try {
            if (tableExists(sQLiteDatabase, "ExoPlayerVersions")) {
                sQLiteDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", featureAndInstanceUidArguments(i, str));
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    public static int getVersion(SQLiteDatabase sQLiteDatabase, int i, String str) throws DatabaseIOException {
        Cursor query;
        try {
            if (!tableExists(sQLiteDatabase, "ExoPlayerVersions")) {
                return -1;
            }
            query = sQLiteDatabase.query("ExoPlayerVersions", new String[]{"version"}, "feature = ? AND instance_uid = ?", featureAndInstanceUidArguments(i, str), null, null, null);
            if (query.getCount() == 0) {
                if (query != null) {
                    query.close();
                }
                return -1;
            }
            query.moveToNext();
            int i2 = query.getInt(0);
            if (query != null) {
                query.close();
            }
            return i2;
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        } catch (Throwable th) {
            r11.addSuppressed(th);
        }
        throw th;
    }

    static boolean tableExists(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    private static String[] featureAndInstanceUidArguments(int i, String str) {
        return new String[]{Integer.toString(i), str};
    }
}
