package com.j256.ormlite.android.compat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public interface ApiCompatibility {

    public interface CancellationHook {
        void cancel();
    }

    CancellationHook createCancellationHook();

    Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, CancellationHook cancellationHook);
}
