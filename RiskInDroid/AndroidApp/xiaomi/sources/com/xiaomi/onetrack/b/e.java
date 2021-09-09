package com.xiaomi.onetrack.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class e extends SQLiteOpenHelper {
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public e(Context context) {
        super(context, "one_track_cloud", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events_cloud (_id  INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT,cloud_data TEXT,timestamp INTEGER,data_hash TEXT)");
        Log.d("ConfigDatabaseHelper", "onCreate: ");
    }
}
