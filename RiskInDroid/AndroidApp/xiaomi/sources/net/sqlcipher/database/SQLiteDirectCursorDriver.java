package net.sqlcipher.database;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

public class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
    private Cursor mCursor;
    private SQLiteDatabase mDatabase;
    private String mEditTable;
    private SQLiteQuery mQuery;
    private String mSql;

    public void cursorDeactivated() {
    }

    public void cursorRequeried(android.database.Cursor cursor) {
    }

    public SQLiteDirectCursorDriver(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        this.mDatabase = sQLiteDatabase;
        this.mEditTable = str2;
        this.mSql = str;
    }

    public Cursor query(SQLiteDatabase.CursorFactory cursorFactory, Object[] objArr) {
        SQLiteQuery sQLiteQuery = new SQLiteQuery(this.mDatabase, this.mSql, 0, objArr);
        try {
            sQLiteQuery.bindArguments(objArr);
            if (cursorFactory == null) {
                this.mCursor = new SQLiteCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery);
            } else {
                this.mCursor = cursorFactory.newCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery);
            }
            this.mQuery = sQLiteQuery;
            return this.mCursor;
        } catch (Throwable th) {
            if (sQLiteQuery != null) {
                sQLiteQuery.close();
            }
            throw th;
        }
    }

    public Cursor query(SQLiteDatabase.CursorFactory cursorFactory, String[] strArr) {
        int i;
        int i2 = 0;
        SQLiteQuery sQLiteQuery = new SQLiteQuery(this.mDatabase, this.mSql, 0, strArr);
        if (strArr == null) {
            i = 0;
        } else {
            try {
                i = strArr.length;
            } catch (Throwable th) {
                if (sQLiteQuery != null) {
                    sQLiteQuery.close();
                }
                throw th;
            }
        }
        while (i2 < i) {
            int i3 = i2 + 1;
            sQLiteQuery.bindString(i3, strArr[i2]);
            i2 = i3;
        }
        if (cursorFactory == null) {
            this.mCursor = new SQLiteCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery);
        } else {
            this.mCursor = cursorFactory.newCursor(this.mDatabase, this, this.mEditTable, sQLiteQuery);
        }
        this.mQuery = sQLiteQuery;
        return this.mCursor;
    }

    public void cursorClosed() {
        this.mCursor = null;
    }

    public void setBindArguments(String[] strArr) {
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            this.mQuery.bindString(i2, strArr[i]);
            i = i2;
        }
    }

    public String toString() {
        return "SQLiteDirectCursorDriver: " + this.mSql;
    }
}
