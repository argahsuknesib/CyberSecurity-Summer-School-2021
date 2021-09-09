package com.google.android.exoplayer2.upstream.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class CacheFileMetadataIndex {
    private static final String[] COLUMNS = {"name", "length", "last_touch_timestamp"};
    private final DatabaseProvider databaseProvider;
    private String tableName;

    public static void delete(DatabaseProvider databaseProvider2, long j) throws DatabaseIOException {
        SQLiteDatabase writableDatabase;
        String hexString = Long.toHexString(j);
        try {
            String tableName2 = getTableName(hexString);
            writableDatabase = databaseProvider2.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            VersionTable.removeVersion(writableDatabase, 2, hexString);
            dropTable(writableDatabase, tableName2);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public CacheFileMetadataIndex(DatabaseProvider databaseProvider2) {
        this.databaseProvider = databaseProvider2;
    }

    public final void initialize(long j) throws DatabaseIOException {
        SQLiteDatabase writableDatabase;
        try {
            String hexString = Long.toHexString(j);
            this.tableName = getTableName(hexString);
            if (VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 2, hexString) != 1) {
                writableDatabase = this.databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                VersionTable.setVersion(writableDatabase, 2, hexString, 1);
                dropTable(writableDatabase, this.tableName);
                writableDatabase.execSQL("CREATE TABLE " + this.tableName + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public final Map<String, CacheFileMetadata> getAll() throws DatabaseIOException {
        Cursor cursor;
        try {
            cursor = getCursor();
            HashMap hashMap = new HashMap(cursor.getCount());
            while (cursor.moveToNext()) {
                hashMap.put(cursor.getString(0), new CacheFileMetadata(cursor.getLong(1), cursor.getLong(2)));
            }
            if (cursor != null) {
                cursor.close();
            }
            return hashMap;
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        } catch (Throwable th) {
            r1.addSuppressed(th);
        }
        throw th;
    }

    public final void set(String str, long j, long j2) throws DatabaseIOException {
        Assertions.checkNotNull(this.tableName);
        try {
            SQLiteDatabase writableDatabase = this.databaseProvider.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j));
            contentValues.put("last_touch_timestamp", Long.valueOf(j2));
            writableDatabase.replaceOrThrow(this.tableName, null, contentValues);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    public final void remove(String str) throws DatabaseIOException {
        Assertions.checkNotNull(this.tableName);
        try {
            this.databaseProvider.getWritableDatabase().delete(this.tableName, "name = ?", new String[]{str});
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    public final void removeAll(Set<String> set) throws DatabaseIOException {
        SQLiteDatabase writableDatabase;
        Assertions.checkNotNull(this.tableName);
        try {
            writableDatabase = this.databaseProvider.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            for (String str : set) {
                writableDatabase.delete(this.tableName, "name = ?", new String[]{str});
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    private Cursor getCursor() {
        Assertions.checkNotNull(this.tableName);
        return this.databaseProvider.getReadableDatabase().query(this.tableName, COLUMNS, null, null, null, null, null);
    }

    private static void dropTable(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(str)));
    }

    private static String getTableName(String str) {
        return "ExoPlayerCacheFileMetadata".concat(String.valueOf(str));
    }
}
