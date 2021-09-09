package com.google.android.exoplayer2.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.exoplayer2.util.Log;

public final class ExoDatabaseProvider extends SQLiteOpenHelper implements DatabaseProvider {
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public ExoDatabaseProvider(Context context) {
        super(context.getApplicationContext(), "exoplayer_internal.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        wipeDatabase(sQLiteDatabase);
    }

    private static void wipeDatabase(SQLiteDatabase sQLiteDatabase) {
        String str;
        Cursor query = sQLiteDatabase.query("sqlite_master", new String[]{"type", "name"}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                String string = query.getString(0);
                String string2 = query.getString(1);
                if (!"sqlite_sequence".equals(string2)) {
                    str = "DROP " + string + " IF EXISTS " + string2;
                    sQLiteDatabase.execSQL(str);
                }
            } catch (SQLException e) {
                Log.e("ExoDatabaseProvider", "Error executing ".concat(String.valueOf(str)), e);
            } catch (Throwable th) {
                Throwable th2 = th;
                try {
                    throw th2;
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
        }
        if (query != null) {
            query.close();
            return;
        }
        return;
        throw th;
    }
}
