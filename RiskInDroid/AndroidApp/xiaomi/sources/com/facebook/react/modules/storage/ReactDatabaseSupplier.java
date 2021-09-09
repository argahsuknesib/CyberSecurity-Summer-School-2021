package com.facebook.react.modules.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.common.logging.FLog;

public class ReactDatabaseSupplier extends SQLiteOpenHelper {
    private static ReactDatabaseSupplier sReactDatabaseSupplierInstance;
    private Context mContext;
    private SQLiteDatabase mDb;
    private long mMaximumDatabaseSize = 6291456;

    private ReactDatabaseSupplier(Context context) {
        super(context, "RKStorage", (SQLiteDatabase.CursorFactory) null, 1);
        this.mContext = context;
    }

    public static ReactDatabaseSupplier getInstance(Context context) {
        if (sReactDatabaseSupplierInstance == null) {
            sReactDatabaseSupplierInstance = new ReactDatabaseSupplier(context.getApplicationContext());
        }
        return sReactDatabaseSupplierInstance;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE catalystLocalStorage (key TEXT PRIMARY KEY, value TEXT NOT NULL)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i != i2) {
            deleteDatabase();
            onCreate(sQLiteDatabase);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:15|16|17|18|19|20|34|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x002f, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0028 */
    public synchronized boolean ensureDatabase() {
        if (this.mDb != null && this.mDb.isOpen()) {
            return true;
        }
        SQLiteException e = null;
        int i = 0;
        while (true) {
            if (i < 2) {
                if (i <= 0) {
                    break;
                }
                try {
                    deleteDatabase();
                    break;
                } catch (SQLiteException e2) {
                    e = e2;
                    Thread.sleep(30);
                    Thread.currentThread().interrupt();
                    i++;
                }
            } else {
                break;
            }
        }
        this.mDb = getWritableDatabase();
        if (this.mDb != null) {
            this.mDb.setMaximumSize(this.mMaximumDatabaseSize);
            return true;
        }
        throw e;
    }

    public synchronized SQLiteDatabase get() {
        ensureDatabase();
        return this.mDb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        throw new java.lang.RuntimeException("Clearing and deleting database RKStorage failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (deleteDatabase() != false) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        com.facebook.common.logging.FLog.d("ReactNative", "Deleted Local Database RKStorage");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0012 */
    public synchronized void clearAndCloseDatabase() throws RuntimeException {
        clear();
        closeDatabase();
        FLog.d("ReactNative", "Cleaned RKStorage");
    }

    /* access modifiers changed from: package-private */
    public synchronized void clear() {
        get().delete("catalystLocalStorage", null, null);
    }

    public synchronized void setMaximumSize(long j) {
        this.mMaximumDatabaseSize = j;
        if (this.mDb != null) {
            this.mDb.setMaximumSize(this.mMaximumDatabaseSize);
        }
    }

    private synchronized boolean deleteDatabase() {
        closeDatabase();
        return this.mContext.deleteDatabase("RKStorage");
    }

    private synchronized void closeDatabase() {
        if (this.mDb != null && this.mDb.isOpen()) {
            this.mDb.close();
            this.mDb = null;
        }
    }

    public static void deleteInstance() {
        sReactDatabaseSupplierInstance = null;
    }
}
