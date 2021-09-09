package com.j256.ormlite.android.compat;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.compat.ApiCompatibility;

public class BasicApiCompatibility implements ApiCompatibility {
    public ApiCompatibility.CancellationHook createCancellationHook() {
        return null;
    }

    public Cursor rawQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, ApiCompatibility.CancellationHook cancellationHook) {
        return sQLiteDatabase.rawQuery(str, strArr);
    }
}
