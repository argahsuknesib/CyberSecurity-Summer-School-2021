package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class zzfd extends SQLiteOpenHelper {
    private final /* synthetic */ zzfc zzaii;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfd(zzfc zzfc, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.zzaii = zzfc;
    }

    public final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e) {
            throw e;
        } catch (SQLiteException unused) {
            this.zzaii.zzge().zzim().log("Opening the local database failed, dropping and recreating it");
            if (!this.zzaii.getContext().getDatabasePath("google_app_measurement_local.db").delete()) {
                this.zzaii.zzge().zzim().zzg("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e2) {
                this.zzaii.zzge().zzim().zzg("Failed to open local database. Events will bypass local storage", e2);
                return null;
            }
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzei.zza(this.zzaii.zzge(), sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (Build.VERSION.SDK_INT < 15) {
            ? r0 = 0;
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", r0);
                rawQuery.moveToFirst();
                r0 = rawQuery;
            } finally {
                if (r0 != 0) {
                    r0.close();
                }
            }
        }
        zzei.zza(this.zzaii.zzge(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
