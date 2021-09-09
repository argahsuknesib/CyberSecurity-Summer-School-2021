package net.sqlcipher.database;

import android.content.ContentValues;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;
import net.sqlcipher.CrossProcessCursorWrapper;
import net.sqlcipher.Cursor;
import net.sqlcipher.CursorWrapper;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDebug;

public class SQLiteDatabase extends SQLiteClosable {
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap<>();
    private static int sQueryLogTimeInMillis = 0;
    private int mCacheFullWarnings;
    Map<String, SQLiteCompiledSql> mCompiledQueries;
    private final DatabaseErrorHandler mErrorHandler;
    private CursorFactory mFactory;
    private int mFlags;
    private boolean mInnerTransactionIsSuccessful;
    private long mLastLockMessageTime;
    private String mLastSqlStatement;
    private final ReentrantLock mLock;
    private long mLockAcquiredThreadTime;
    private long mLockAcquiredWallTime;
    private boolean mLockingEnabled;
    private int mMaxSqlCacheSize;
    long mNativeHandle;
    private int mNumCacheHits;
    private int mNumCacheMisses;
    private String mPath;
    private String mPathForLogs;
    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    private final int mSlowQueryThreshold;
    private Throwable mStackTrace;
    private final Map<String, SyncUpdateInfo> mSyncUpdateInfo;
    int mTempTableSequence;
    private String mTimeClosed;
    private String mTimeOpened;
    private boolean mTransactionIsSuccessful;
    private SQLiteTransactionListener mTransactionListener;

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery);
    }

    public interface LibraryLoader {
        void loadLibraries(String... strArr);
    }

    enum SQLiteDatabaseTransactionType {
        Deferred,
        Immediate,
        Exclusive
    }

    private native void dbclose();

    private native void dbopen(String str, int i);

    private native void enableSqlProfiling(String str);

    private native void enableSqlTracing(String str);

    private native int native_getDbLookaside();

    private native void native_rawExecSQL(String str);

    private native int native_status(int i, boolean z);

    private native void rekey(byte[] bArr) throws SQLException;

    public static native int releaseMemory();

    public static native void setICURoot(String str);

    public native void key(byte[] bArr) throws SQLException;

    public native void key_mutf8(char[] cArr) throws SQLException;

    /* access modifiers changed from: package-private */
    public native int lastChangeCount();

    /* access modifiers changed from: package-private */
    public native long lastInsertRow();

    /* access modifiers changed from: package-private */
    public native void native_execSQL(String str) throws SQLException;

    /* access modifiers changed from: package-private */
    public native void native_setLocale(String str, int i);

    public int status(int i, boolean z) {
        return native_status(i, z);
    }

    public void changePassword(String str) throws SQLiteException {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        } else if (str != null) {
            byte[] bytes = getBytes(str.toCharArray());
            rekey(bytes);
            Arrays.fill(bytes, (byte) 0);
        }
    }

    public void changePassword(char[] cArr) throws SQLiteException {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        } else if (cArr != null) {
            byte[] bytes = getBytes(cArr);
            rekey(bytes);
            Arrays.fill(bytes, (byte) 0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0074 A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0080 A[SYNTHETIC, Splitter:B:43:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0088 A[Catch:{ IOException -> 0x0084 }] */
    private static void loadICUData(Context context, File file) {
        ZipInputStream zipInputStream;
        FileOutputStream fileOutputStream;
        File file2 = new File(file, "icu");
        File file3 = new File(file2, "icudt46l.dat");
        FileOutputStream fileOutputStream2 = null;
        try {
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!file3.exists()) {
                zipInputStream = new ZipInputStream(context.getAssets().open("icudt46l.zip"));
                try {
                    zipInputStream.getNextEntry();
                    fileOutputStream = new FileOutputStream(file3);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (Exception e) {
                        Exception exc = e;
                        fileOutputStream2 = fileOutputStream;
                        e = exc;
                        try {
                            if (file3.exists()) {
                            }
                            throw new RuntimeException(e);
                        } catch (Throwable th) {
                            th = th;
                            if (zipInputStream != null) {
                            }
                            if (fileOutputStream2 != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        fileOutputStream2 = fileOutputStream;
                        th = th2;
                        if (zipInputStream != null) {
                        }
                        if (fileOutputStream2 != null) {
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    if (file3.exists()) {
                        file3.delete();
                    }
                    throw new RuntimeException(e);
                }
            } else {
                fileOutputStream = null;
                zipInputStream = null;
            }
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (IOException e3) {
                    throw new RuntimeException(e3);
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (Exception e4) {
            e = e4;
            zipInputStream = null;
            if (file3.exists()) {
            }
            throw new RuntimeException(e);
        } catch (Throwable th3) {
            th = th3;
            zipInputStream = null;
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (IOException e5) {
                    throw new RuntimeException(e5);
                }
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.flush();
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    public static synchronized void loadLibs(Context context) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir());
        }
    }

    public static synchronized void loadLibs(Context context, File file) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, file, new LibraryLoader() {
                /* class net.sqlcipher.database.SQLiteDatabase.AnonymousClass1 */

                public final void loadLibraries(String... strArr) {
                    for (String loadLibrary : strArr) {
                        System.loadLibrary(loadLibrary);
                    }
                }
            });
        }
    }

    public static synchronized void loadLibs(Context context, LibraryLoader libraryLoader) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir(), libraryLoader);
        }
    }

    public static synchronized void loadLibs(Context context, File file, LibraryLoader libraryLoader) {
        synchronized (SQLiteDatabase.class) {
            libraryLoader.loadLibraries("sqlcipher");
        }
    }

    /* access modifiers changed from: package-private */
    public void addSQLiteClosable(SQLiteClosable sQLiteClosable) {
        lock();
        try {
            this.mPrograms.put(sQLiteClosable, null);
        } finally {
            unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void removeSQLiteClosable(SQLiteClosable sQLiteClosable) {
        lock();
        try {
            this.mPrograms.remove(sQLiteClosable);
        } finally {
            unlock();
        }
    }

    /* access modifiers changed from: protected */
    public void onAllReferencesReleased() {
        if (isOpen()) {
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = getTime();
            }
            dbclose();
            synchronized (sActiveDatabases) {
                sActiveDatabases.remove(this);
            }
        }
    }

    public void setLockingEnabled(boolean z) {
        this.mLockingEnabled = z;
    }

    /* access modifiers changed from: package-private */
    public void onCorruption() {
        this.mErrorHandler.onCorruption(this);
    }

    /* access modifiers changed from: package-private */
    public void lock() {
        if (this.mLockingEnabled) {
            this.mLock.lock();
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            }
        }
    }

    private void lockForced() {
        this.mLock.lock();
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
        }
    }

    /* access modifiers changed from: package-private */
    public void unlock() {
        if (this.mLockingEnabled) {
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                checkLockHoldTime();
            }
            this.mLock.unlock();
        }
    }

    private void unlockForced() {
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            checkLockHoldTime();
        }
        this.mLock.unlock();
    }

    private void checkLockHoldTime() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.mLockAcquiredWallTime;
        if ((j >= 2000 || Log.isLoggable("Database", 2) || elapsedRealtime - this.mLastLockMessageTime >= 20000) && j > 300) {
            int threadCpuTimeNanos = (int) ((Debug.threadCpuTimeNanos() - this.mLockAcquiredThreadTime) / 1000000);
            if (threadCpuTimeNanos > 100 || j > 2000) {
                this.mLastLockMessageTime = elapsedRealtime;
                StringBuilder sb = new StringBuilder("lock held on ");
                sb.append(this.mPath);
                sb.append(" for ");
                sb.append(j);
                sb.append("ms. Thread time was ");
                sb.append(threadCpuTimeNanos);
                sb.append("ms");
                boolean z = SQLiteDebug.DEBUG_LOCK_TIME_TRACKING_STACK_TRACE;
            }
        }
    }

    public boolean isDatabaseIntegrityOk() {
        Pair<Boolean, String> resultFromPragma = getResultFromPragma("PRAGMA integrity_check;");
        return ((Boolean) resultFromPragma.first).booleanValue() ? ((String) resultFromPragma.second).equals("ok") : ((Boolean) resultFromPragma.first).booleanValue();
    }

    public List<Pair<String, String>> getAttachedDbs() {
        return getAttachedDbs(this);
    }

    public boolean enableWriteAheadLogging() {
        if (!inTransaction()) {
            ArrayList<Pair<String, String>> attachedDbs = getAttachedDbs(this);
            if ((attachedDbs != null && attachedDbs.size() > 1) || isReadOnly() || getPath().equals(":memory:")) {
                return false;
            }
            rawExecSQL("PRAGMA journal_mode = WAL;");
            return true;
        }
        throw new IllegalStateException("Write Ahead Logging cannot be enabled while in a transaction");
    }

    public void disableWriteAheadLogging() {
        if (!inTransaction()) {
            rawExecSQL("PRAGMA journal_mode = DELETE;");
            return;
        }
        throw new IllegalStateException("Write Ahead Logging cannot be disabled while in a transaction");
    }

    public boolean isWriteAheadLoggingEnabled() {
        Pair<Boolean, String> resultFromPragma = getResultFromPragma("PRAGMA journal_mode;");
        return ((Boolean) resultFromPragma.first).booleanValue() ? ((String) resultFromPragma.second).equals("wal") : ((Boolean) resultFromPragma.first).booleanValue();
    }

    public void setForeignKeyConstraintsEnabled(boolean z) {
        if (!inTransaction()) {
            Object[] objArr = new Object[1];
            objArr[0] = z ? "ON" : "OFF";
            execSQL(String.format("PRAGMA foreign_keys = %s;", objArr));
            return;
        }
        throw new IllegalStateException("Foreign key constraints may not be changed while in a transaction");
    }

    public void beginTransaction() {
        beginTransactionWithListener(null);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransactionWithListenerInternal(sQLiteTransactionListener, SQLiteDatabaseTransactionType.Exclusive);
    }

    public void beginTransactionNonExclusive() {
        beginTransactionWithListenerInternal(null, SQLiteDatabaseTransactionType.Immediate);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransactionWithListenerInternal(sQLiteTransactionListener, SQLiteDatabaseTransactionType.Immediate);
    }

    public void endTransaction() {
        RuntimeException e;
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        } else if (this.mLock.isHeldByCurrentThread()) {
            try {
                if (this.mInnerTransactionIsSuccessful) {
                    this.mInnerTransactionIsSuccessful = false;
                } else {
                    this.mTransactionIsSuccessful = false;
                }
                if (this.mLock.getHoldCount() == 1) {
                    if (this.mTransactionListener != null) {
                        if (this.mTransactionIsSuccessful) {
                            this.mTransactionListener.onCommit();
                        } else {
                            this.mTransactionListener.onRollback();
                        }
                    }
                    e = null;
                    if (this.mTransactionIsSuccessful) {
                        execSQL("COMMIT;");
                    } else {
                        try {
                            execSQL("ROLLBACK;");
                            if (e != null) {
                                throw e;
                            }
                        } catch (SQLException unused) {
                        }
                    }
                }
            } catch (RuntimeException e2) {
                e = e2;
                this.mTransactionIsSuccessful = false;
            } catch (Throwable th) {
                this.mTransactionListener = null;
                unlockForced();
                throw th;
            }
            this.mTransactionListener = null;
            unlockForced();
        } else {
            throw new IllegalStateException("no transaction pending");
        }
    }

    public void setTransactionSuccessful() {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        } else if (!this.mLock.isHeldByCurrentThread()) {
            throw new IllegalStateException("no transaction pending");
        } else if (!this.mInnerTransactionIsSuccessful) {
            this.mInnerTransactionIsSuccessful = true;
        } else {
            throw new IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
        }
    }

    public boolean inTransaction() {
        return this.mLock.getHoldCount() > 0;
    }

    public boolean isDbLockedByCurrentThread() {
        return this.mLock.isHeldByCurrentThread();
    }

    public boolean isDbLockedByOtherThreads() {
        return !this.mLock.isHeldByCurrentThread() && this.mLock.isLocked();
    }

    @Deprecated
    public boolean yieldIfContended() {
        if (!isOpen()) {
            return false;
        }
        return yieldIfContendedHelper(false, -1);
    }

    public boolean yieldIfContendedSafely() {
        if (!isOpen()) {
            return false;
        }
        return yieldIfContendedHelper(true, -1);
    }

    public boolean yieldIfContendedSafely(long j) {
        if (!isOpen()) {
            return false;
        }
        return yieldIfContendedHelper(true, j);
    }

    private boolean yieldIfContendedHelper(boolean z, long j) {
        if (this.mLock.getQueueLength() == 0) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            return false;
        }
        setTransactionSuccessful();
        SQLiteTransactionListener sQLiteTransactionListener = this.mTransactionListener;
        endTransaction();
        if (!z || !isDbLockedByCurrentThread()) {
            if (j > 0) {
                while (j > 0) {
                    try {
                        Thread.sleep(j < 1000 ? j : 1000);
                    } catch (InterruptedException unused) {
                        Thread.interrupted();
                    }
                    j -= 1000;
                    if (this.mLock.getQueueLength() == 0) {
                        break;
                    }
                }
            }
            beginTransactionWithListener(sQLiteTransactionListener);
            return true;
        }
        throw new IllegalStateException("Db locked more than once. yielfIfContended cannot yield");
    }

    public Map<String, String> getSyncedTables() {
        HashMap hashMap;
        synchronized (this.mSyncUpdateInfo) {
            hashMap = new HashMap();
            for (String next : this.mSyncUpdateInfo.keySet()) {
                SyncUpdateInfo syncUpdateInfo = this.mSyncUpdateInfo.get(next);
                if (syncUpdateInfo.deletedTable != null) {
                    hashMap.put(next, syncUpdateInfo.deletedTable);
                }
            }
        }
        return hashMap;
    }

    static class SyncUpdateInfo {
        String deletedTable;
        String foreignKey;
        String masterTable;

        SyncUpdateInfo(String str, String str2, String str3) {
            this.masterTable = str;
            this.deletedTable = str2;
            this.foreignKey = str3;
        }
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i) {
        return openDatabase(str, str2, cursorFactory, i, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i) {
        return openDatabase(str, cArr, cursorFactory, i, (SQLiteDatabaseHook) null, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, str2, cursorFactory, i, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, cArr, cursorFactory, i, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, str2 == null ? null : str2.toCharArray(), cursorFactory, i, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, getBytes(cArr), cursorFactory, i, sQLiteDatabaseHook, databaseErrorHandler);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002f A[SYNTHETIC] */
    public static SQLiteDatabase openDatabase(String str, byte[] bArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        SQLiteDatabase sQLiteDatabase;
        if (databaseErrorHandler == null) {
            databaseErrorHandler = new DefaultDatabaseErrorHandler();
        }
        try {
            sQLiteDatabase = new SQLiteDatabase(str, cursorFactory, i, databaseErrorHandler);
            try {
                sQLiteDatabase.openDatabaseInternal(bArr, sQLiteDatabaseHook);
            } catch (SQLiteDatabaseCorruptException unused) {
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            sQLiteDatabase = null;
            databaseErrorHandler.onCorruption(sQLiteDatabase);
            sQLiteDatabase = new SQLiteDatabase(str, cursorFactory, i, databaseErrorHandler);
            sQLiteDatabase.openDatabaseInternal(bArr, sQLiteDatabaseHook);
            if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
            }
            if (SQLiteDebug.DEBUG_SQL_TIME) {
            }
            synchronized (sActiveDatabases) {
            }
        }
        if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
            sQLiteDatabase.enableSqlTracing(str);
        }
        if (SQLiteDebug.DEBUG_SQL_TIME) {
            sQLiteDatabase.enableSqlProfiling(str);
        }
        synchronized (sActiveDatabases) {
            sActiveDatabases.put(sQLiteDatabase, null);
        }
        return sQLiteDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openOrCreateDatabase(file, str, cursorFactory, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openOrCreateDatabase(file == null ? null : file.getPath(), str, cursorFactory, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, str2, cursorFactory, 268435456, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, str2 == null ? null : str2.toCharArray(), cursorFactory, 268435456, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, cArr, cursorFactory, 268435456, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, cArr, cursorFactory, 268435456, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, bArr, cursorFactory, 268435456, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, bArr, cursorFactory, 268435456, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory) {
        return openOrCreateDatabase(file, str, cursorFactory, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory) {
        return openDatabase(str, str2, cursorFactory, 268435456, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory) {
        return openDatabase(str, cArr, cursorFactory, 268435456, (SQLiteDatabaseHook) null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory) {
        return openDatabase(str, bArr, cursorFactory, 268435456, (SQLiteDatabaseHook) null, (DatabaseErrorHandler) null);
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, String str) {
        return openDatabase(":memory:", str == null ? null : str.toCharArray(), cursorFactory, 268435456);
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, char[] cArr) {
        return openDatabase(":memory:", cArr, cursorFactory, 268435456);
    }

    public void close() {
        if (isOpen()) {
            lock();
            try {
                closeClosable();
                onAllReferencesReleased();
            } finally {
                unlock();
            }
        }
    }

    private void closeClosable() {
        deallocCachedSqlStatements();
        for (Map.Entry<SQLiteClosable, Object> key : this.mPrograms.entrySet()) {
            SQLiteClosable sQLiteClosable = (SQLiteClosable) key.getKey();
            if (sQLiteClosable != null) {
                sQLiteClosable.onAllReferencesReleasedFromContainer();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    public int getVersion() {
        lock();
        SQLiteStatement sQLiteStatement = null;
        try {
            if (isOpen()) {
                SQLiteStatement sQLiteStatement2 = new SQLiteStatement(this, "PRAGMA user_version;");
                try {
                    int simpleQueryForLong = (int) sQLiteStatement2.simpleQueryForLong();
                    sQLiteStatement2.close();
                    unlock();
                    return simpleQueryForLong;
                } catch (Throwable th) {
                    SQLiteStatement sQLiteStatement3 = sQLiteStatement2;
                    th = th;
                    sQLiteStatement = sQLiteStatement3;
                    if (sQLiteStatement != null) {
                    }
                    unlock();
                    throw th;
                }
            } else {
                throw new IllegalStateException("database not open");
            }
        } catch (Throwable th2) {
            th = th2;
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            unlock();
            throw th;
        }
    }

    public void setVersion(int i) {
        execSQL("PRAGMA user_version = ".concat(String.valueOf(i)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032  */
    public long getMaximumSize() {
        lock();
        SQLiteStatement sQLiteStatement = null;
        try {
            if (isOpen()) {
                SQLiteStatement sQLiteStatement2 = new SQLiteStatement(this, "PRAGMA max_page_count;");
                try {
                    long simpleQueryForLong = sQLiteStatement2.simpleQueryForLong() * getPageSize();
                    sQLiteStatement2.close();
                    unlock();
                    return simpleQueryForLong;
                } catch (Throwable th) {
                    SQLiteStatement sQLiteStatement3 = sQLiteStatement2;
                    th = th;
                    sQLiteStatement = sQLiteStatement3;
                    if (sQLiteStatement != null) {
                        sQLiteStatement.close();
                    }
                    unlock();
                    throw th;
                }
            } else {
                throw new IllegalStateException("database not open");
            }
        } catch (Throwable th2) {
            th = th2;
            if (sQLiteStatement != null) {
            }
            unlock();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    public long setMaximumSize(long j) {
        lock();
        SQLiteStatement sQLiteStatement = null;
        try {
            if (isOpen()) {
                long pageSize = getPageSize();
                long j2 = j / pageSize;
                if (j % pageSize != 0) {
                    j2++;
                }
                SQLiteStatement sQLiteStatement2 = new SQLiteStatement(this, "PRAGMA max_page_count = ".concat(String.valueOf(j2)));
                try {
                    long simpleQueryForLong = sQLiteStatement2.simpleQueryForLong() * pageSize;
                    sQLiteStatement2.close();
                    unlock();
                    return simpleQueryForLong;
                } catch (Throwable th) {
                    th = th;
                    sQLiteStatement = sQLiteStatement2;
                    if (sQLiteStatement != null) {
                    }
                    unlock();
                    throw th;
                }
            } else {
                throw new IllegalStateException("database not open");
            }
        } catch (Throwable th2) {
            th = th2;
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            unlock();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
    public long getPageSize() {
        lock();
        SQLiteStatement sQLiteStatement = null;
        try {
            if (isOpen()) {
                SQLiteStatement sQLiteStatement2 = new SQLiteStatement(this, "PRAGMA page_size;");
                try {
                    long simpleQueryForLong = sQLiteStatement2.simpleQueryForLong();
                    sQLiteStatement2.close();
                    unlock();
                    return simpleQueryForLong;
                } catch (Throwable th) {
                    SQLiteStatement sQLiteStatement3 = sQLiteStatement2;
                    th = th;
                    sQLiteStatement = sQLiteStatement3;
                    if (sQLiteStatement != null) {
                    }
                    unlock();
                    throw th;
                }
            } else {
                throw new IllegalStateException("database not open");
            }
        } catch (Throwable th2) {
            th = th2;
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            unlock();
            throw th;
        }
    }

    public void setPageSize(long j) {
        execSQL("PRAGMA page_size = ".concat(String.valueOf(j)));
    }

    public void markTableSyncable(String str, String str2) {
        if (isOpen()) {
            markTableSyncable(str, "_id", str, str2);
            return;
        }
        throw new SQLiteException("database not open");
    }

    public void markTableSyncable(String str, String str2, String str3) {
        if (isOpen()) {
            markTableSyncable(str, str2, str3, null);
            return;
        }
        throw new SQLiteException("database not open");
    }

    /* JADX INFO: finally extract failed */
    private void markTableSyncable(String str, String str2, String str3, String str4) {
        lock();
        try {
            native_execSQL("SELECT _sync_dirty FROM " + str3 + " LIMIT 0");
            native_execSQL("SELECT " + str2 + " FROM " + str + " LIMIT 0");
            unlock();
            SyncUpdateInfo syncUpdateInfo = new SyncUpdateInfo(str3, str4, str2);
            synchronized (this.mSyncUpdateInfo) {
                this.mSyncUpdateInfo.put(str, syncUpdateInfo);
            }
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void rowUpdated(String str, long j) {
        SyncUpdateInfo syncUpdateInfo;
        synchronized (this.mSyncUpdateInfo) {
            syncUpdateInfo = this.mSyncUpdateInfo.get(str);
        }
        if (syncUpdateInfo != null) {
            execSQL("UPDATE " + syncUpdateInfo.masterTable + " SET _sync_dirty=1 WHERE _id=(SELECT " + syncUpdateInfo.foreignKey + " FROM " + str + " WHERE _id=" + j + ")");
        }
    }

    public static String findEditTable(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(32);
            int indexOf2 = str.indexOf(44);
            if (indexOf > 0 && (indexOf < indexOf2 || indexOf2 < 0)) {
                return str.substring(0, indexOf);
            }
            if (indexOf2 > 0) {
                return (indexOf2 < indexOf || indexOf < 0) ? str.substring(0, indexOf2) : str;
            }
            return str;
        }
        throw new IllegalStateException("Invalid tables");
    }

    public SQLiteStatement compileStatement(String str) throws SQLException {
        lock();
        try {
            if (isOpen()) {
                return new SQLiteStatement(this, str);
            }
            throw new IllegalStateException("database not open");
        } finally {
            unlock();
        }
    }

    public Cursor query(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return queryWithFactory(null, z, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (isOpen()) {
            return rawQueryWithFactory(cursorFactory, SQLiteQueryBuilder.buildQueryString(z, str, strArr, str2, str3, str4, str5, str6), strArr2, findEditTable(str));
        }
        throw new IllegalStateException("database not open");
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, null);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    public Cursor rawQuery(String str, String[] strArr) {
        return rawQueryWithFactory(null, str, strArr, null);
    }

    public SQLiteQueryStats getQueryStats(String str, Object[] objArr) {
        try {
            execSQL(String.format("CREATE TABLE tempstat AS %s", str), objArr);
            Cursor rawQuery = rawQuery("SELECT sum(payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);
            if (rawQuery == null) {
                return new SQLiteQueryStats(0, 0);
            }
            rawQuery.moveToFirst();
            long j = rawQuery.getLong(0);
            rawQuery.close();
            Cursor rawQuery2 = rawQuery("SELECT max(mx_payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);
            if (rawQuery2 == null) {
                return new SQLiteQueryStats(j, 0);
            }
            rawQuery2.moveToFirst();
            long j2 = rawQuery2.getLong(0);
            rawQuery2.close();
            execSQL("DROP TABLE tempstat;");
            return new SQLiteQueryStats(j, j2);
        } catch (SQLiteException e) {
            execSQL("DROP TABLE IF EXISTS tempstat;");
            throw e;
        }
    }

    /* JADX INFO: finally extract failed */
    public Cursor rawQuery(String str, Object[] objArr) {
        if (isOpen()) {
            long j = 0;
            int i = -1;
            if (this.mSlowQueryThreshold != -1) {
                j = System.currentTimeMillis();
            }
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, null);
            try {
                Cursor query = sQLiteDirectCursorDriver.query(this.mFactory, objArr);
                if (this.mSlowQueryThreshold != -1) {
                    if (query != null) {
                        i = query.getCount();
                    }
                    long currentTimeMillis = System.currentTimeMillis() - j;
                    if (currentTimeMillis >= ((long) this.mSlowQueryThreshold)) {
                        Log.v("Database", "query (" + currentTimeMillis + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is " + i);
                    }
                }
                return new CrossProcessCursorWrapper(query);
            } catch (Throwable th) {
                if (this.mSlowQueryThreshold != -1) {
                    long currentTimeMillis2 = System.currentTimeMillis() - j;
                    if (currentTimeMillis2 >= ((long) this.mSlowQueryThreshold)) {
                        Log.v("Database", "query (" + currentTimeMillis2 + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is -1");
                    }
                }
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, String[] strArr, String str2) {
        if (isOpen()) {
            long j = 0;
            int i = -1;
            if (this.mSlowQueryThreshold != -1) {
                j = System.currentTimeMillis();
            }
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, str2);
            if (cursorFactory == null) {
                try {
                    cursorFactory = this.mFactory;
                } catch (Throwable th) {
                    if (this.mSlowQueryThreshold != -1) {
                        long currentTimeMillis = System.currentTimeMillis() - j;
                        if (currentTimeMillis >= ((long) this.mSlowQueryThreshold)) {
                            Log.v("Database", "query (" + currentTimeMillis + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is -1");
                        }
                    }
                    throw th;
                }
            }
            Cursor query = sQLiteDirectCursorDriver.query(cursorFactory, strArr);
            if (this.mSlowQueryThreshold != -1) {
                if (query != null) {
                    i = query.getCount();
                }
                long currentTimeMillis2 = System.currentTimeMillis() - j;
                if (currentTimeMillis2 >= ((long) this.mSlowQueryThreshold)) {
                    Log.v("Database", "query (" + currentTimeMillis2 + " ms): " + sQLiteDirectCursorDriver.toString() + ", args are <redacted>, count is " + i);
                }
            }
            return new CrossProcessCursorWrapper(query);
        }
        throw new IllegalStateException("database not open");
    }

    public Cursor rawQuery(String str, String[] strArr, int i, int i2) {
        CursorWrapper cursorWrapper = (CursorWrapper) rawQueryWithFactory(null, str, strArr, null);
        ((SQLiteCursor) cursorWrapper.getWrappedCursor()).setLoadStyle(i, i2);
        return cursorWrapper;
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 0);
        } catch (SQLException unused) {
            return -1;
        }
    }

    public long insertOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 0);
    }

    public long replace(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 5);
        } catch (SQLException unused) {
            return -1;
        }
    }

    public long replaceOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 5);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    public long insertWithOnConflict(String str, String str2, ContentValues contentValues, int i) {
        Set<Map.Entry<String, Object>> set;
        if (isOpen()) {
            StringBuilder sb = new StringBuilder(152);
            sb.append("INSERT");
            sb.append(CONFLICT_VALUES[i]);
            sb.append(" INTO ");
            sb.append(str);
            StringBuilder sb2 = new StringBuilder(40);
            int i2 = 0;
            SQLiteStatement sQLiteStatement = null;
            if (contentValues == null || contentValues.size() <= 0) {
                sb.append("(" + str2 + ") ");
                sb2.append("NULL");
                set = sQLiteStatement;
            } else {
                Set<Map.Entry<String, Object>> valueSet = contentValues.valueSet();
                sb.append('(');
                boolean z = false;
                for (Map.Entry<String, Object> key : valueSet) {
                    if (z) {
                        sb.append(", ");
                        sb2.append(", ");
                    }
                    sb.append((String) key.getKey());
                    sb2.append('?');
                    z = true;
                }
                sb.append(')');
                set = valueSet;
            }
            sb.append(" VALUES(");
            sb.append((CharSequence) sb2);
            sb.append(");");
            lock();
            try {
                SQLiteStatement compileStatement = compileStatement(sb.toString());
                if (set != 0) {
                    int size = set.size();
                    Iterator it = set.iterator();
                    while (i2 < size) {
                        i2++;
                        DatabaseUtils.bindObjectToProgram(compileStatement, i2, ((Map.Entry) it.next()).getValue());
                    }
                }
                compileStatement.execute();
                long lastInsertRow = lastChangeCount() > 0 ? lastInsertRow() : -1;
                if (compileStatement != null) {
                    compileStatement.close();
                }
                unlock();
                return lastInsertRow;
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (Throwable th) {
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public int delete(String str, String str2, String[] strArr) {
        lock();
        SQLiteStatement sQLiteStatement = null;
        try {
            if (isOpen()) {
                StringBuilder sb = new StringBuilder("DELETE FROM ");
                sb.append(str);
                sb.append(!TextUtils.isEmpty(str2) ? " WHERE ".concat(String.valueOf(str2)) : "");
                SQLiteStatement compileStatement = compileStatement(sb.toString());
                if (strArr != null) {
                    int length = strArr.length;
                    int i = 0;
                    while (i < length) {
                        int i2 = i + 1;
                        DatabaseUtils.bindObjectToProgram(compileStatement, i2, strArr[i]);
                        i = i2;
                    }
                }
                compileStatement.execute();
                int lastChangeCount = lastChangeCount();
                if (compileStatement != null) {
                    compileStatement.close();
                }
                unlock();
                return lastChangeCount;
            }
            throw new IllegalStateException("database not open");
        } catch (SQLiteDatabaseCorruptException e) {
            onCorruption();
            throw e;
        } catch (Throwable th) {
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            unlock();
            throw th;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        return updateWithOnConflict(str, contentValues, str2, strArr, 0);
    }

    public int updateWithOnConflict(String str, ContentValues contentValues, String str2, String[] strArr, int i) {
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        StringBuilder sb = new StringBuilder(120);
        sb.append("UPDATE ");
        sb.append(CONFLICT_VALUES[i]);
        sb.append(str);
        sb.append(" SET ");
        Set<Map.Entry<String, Object>> valueSet = contentValues.valueSet();
        Iterator<Map.Entry<String, Object>> it = valueSet.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next().getKey());
            sb.append("=?");
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        SQLiteStatement sQLiteStatement = null;
        lock();
        try {
            if (isOpen()) {
                SQLiteStatement compileStatement = compileStatement(sb.toString());
                int size = valueSet.size();
                Iterator<Map.Entry<String, Object>> it2 = valueSet.iterator();
                int i2 = 1;
                for (int i3 = 0; i3 < size; i3++) {
                    DatabaseUtils.bindObjectToProgram(compileStatement, i2, it2.next().getValue());
                    i2++;
                }
                if (strArr != null) {
                    for (String bindString : strArr) {
                        compileStatement.bindString(i2, bindString);
                        i2++;
                    }
                }
                compileStatement.execute();
                int lastChangeCount = lastChangeCount();
                if (compileStatement != null) {
                    compileStatement.close();
                }
                unlock();
                return lastChangeCount;
            }
            throw new IllegalStateException("database not open");
        } catch (SQLiteDatabaseCorruptException e) {
            onCorruption();
            throw e;
        } catch (SQLException e2) {
            throw e2;
        } catch (Throwable th) {
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            unlock();
            throw th;
        }
    }

    public void execSQL(String str) throws SQLException {
        SystemClock.uptimeMillis();
        lock();
        try {
            if (isOpen()) {
                native_execSQL(str);
                unlock();
                return;
            }
            throw new IllegalStateException("database not open");
        } catch (SQLiteDatabaseCorruptException e) {
            onCorruption();
            throw e;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    public void rawExecSQL(String str) {
        SystemClock.uptimeMillis();
        lock();
        try {
            if (isOpen()) {
                native_rawExecSQL(str);
                unlock();
                return;
            }
            throw new IllegalStateException("database not open");
        } catch (SQLiteDatabaseCorruptException e) {
            onCorruption();
            throw e;
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    public void execSQL(String str, Object[] objArr) throws SQLException {
        if (objArr != null) {
            SystemClock.uptimeMillis();
            lock();
            SQLiteStatement sQLiteStatement = null;
            try {
                if (isOpen()) {
                    SQLiteStatement compileStatement = compileStatement(str);
                    if (objArr != null) {
                        int length = objArr.length;
                        int i = 0;
                        while (i < length) {
                            int i2 = i + 1;
                            DatabaseUtils.bindObjectToProgram(compileStatement, i2, objArr[i]);
                            i = i2;
                        }
                    }
                    compileStatement.execute();
                    if (compileStatement != null) {
                        compileStatement.close();
                    }
                    unlock();
                    return;
                }
                throw new IllegalStateException("database not open");
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (Throwable th) {
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                unlock();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Empty bindArgs");
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (isOpen()) {
            closeClosable();
            onAllReferencesReleased();
        }
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i) {
        this(str, cursorFactory, i, (DatabaseErrorHandler) null);
        openDatabaseInternal(cArr, (SQLiteDatabaseHook) null);
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(str, cursorFactory, i, (DatabaseErrorHandler) null);
        openDatabaseInternal(cArr, sQLiteDatabaseHook);
    }

    public SQLiteDatabase(String str, byte[] bArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(str, cursorFactory, i, (DatabaseErrorHandler) null);
        openDatabaseInternal(bArr, sQLiteDatabaseHook);
    }

    private SQLiteDatabase(String str, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        this.mLock = new ReentrantLock(true);
        this.mLockAcquiredWallTime = 0;
        this.mLockAcquiredThreadTime = 0;
        this.mLastLockMessageTime = 0;
        this.mLastSqlStatement = null;
        this.mNativeHandle = 0;
        this.mTempTableSequence = 0;
        this.mPathForLogs = null;
        this.mCompiledQueries = new HashMap();
        this.mMaxSqlCacheSize = 250;
        this.mTimeOpened = null;
        this.mTimeClosed = null;
        this.mStackTrace = null;
        this.mLockingEnabled = true;
        this.mSyncUpdateInfo = new HashMap();
        if (str != null) {
            this.mFlags = i;
            this.mPath = str;
            this.mSlowQueryThreshold = -1;
            this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
            this.mFactory = cursorFactory;
            this.mPrograms = new WeakHashMap<>();
            this.mErrorHandler = databaseErrorHandler;
            return;
        }
        throw new IllegalArgumentException("path should not be null");
    }

    private void openDatabaseInternal(char[] cArr, SQLiteDatabaseHook sQLiteDatabaseHook) {
        openDatabaseInternal(getBytes(cArr), sQLiteDatabaseHook);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(char[], char):void}
     arg types: [char[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(char[], char):void} */
    private void openDatabaseInternal(final byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook) {
        dbopen(this.mPath, this.mFlags);
        boolean z = true;
        try {
            keyDatabase(sQLiteDatabaseHook, new Runnable() {
                /* class net.sqlcipher.database.SQLiteDatabase.AnonymousClass2 */

                public void run() {
                    byte[] bArr = bArr;
                    if (bArr != null && bArr.length > 0) {
                        SQLiteDatabase.this.key(bArr);
                    }
                }
            });
            return;
        } catch (RuntimeException e) {
            final char[] chars = getChars(bArr);
            if (containsNull(chars)) {
                keyDatabase(sQLiteDatabaseHook, new Runnable() {
                    /* class net.sqlcipher.database.SQLiteDatabase.AnonymousClass3 */

                    public void run() {
                        if (bArr != null) {
                            SQLiteDatabase.this.key_mutf8(chars);
                        }
                    }
                });
                if (bArr != null && bArr.length > 0) {
                    rekey(bArr);
                }
                if (chars == null) {
                    return;
                }
                if (chars.length > 0) {
                    Arrays.fill(chars, 0);
                    return;
                }
                return;
            }
            throw e;
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        if (z) {
            dbclose();
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = getTime();
            }
        }
        throw th;
    }

    private boolean containsNull(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return false;
        }
        for (char c : cArr) {
            if (c == 0) {
                return true;
            }
        }
        return false;
    }

    private void keyDatabase(SQLiteDatabaseHook sQLiteDatabaseHook, Runnable runnable) {
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.preKey(this);
        }
        if (runnable != null) {
            runnable.run();
        }
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.postKey(this);
        }
        if (SQLiteDebug.DEBUG_SQL_CACHE) {
            this.mTimeOpened = getTime();
        }
        try {
            Cursor rawQuery = rawQuery("select count(*) from sqlite_master;", new String[0]);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                rawQuery.getInt(0);
                rawQuery.close();
            }
        } catch (RuntimeException e) {
            throw e;
        }
    }

    private String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
    }

    public boolean isReadOnly() {
        return (this.mFlags & 1) == 1;
    }

    public boolean isOpen() {
        return this.mNativeHandle != 0;
    }

    public boolean needUpgrade(int i) {
        return i > getVersion();
    }

    public final String getPath() {
        return this.mPath;
    }

    private String getPathForLogs() {
        String str = this.mPathForLogs;
        if (str != null) {
            return str;
        }
        String str2 = this.mPath;
        if (str2 == null) {
            return null;
        }
        if (str2.indexOf(64) == -1) {
            this.mPathForLogs = this.mPath;
        } else {
            this.mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(this.mPath).replaceAll("XX@YY");
        }
        return this.mPathForLogs;
    }

    public void setLocale(Locale locale) {
        lock();
        try {
            native_setLocale(locale.toString(), this.mFlags);
        } finally {
            unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    public void addToCompiledQueries(String str, SQLiteCompiledSql sQLiteCompiledSql) {
        if (this.mMaxSqlCacheSize == 0) {
            boolean z = SQLiteDebug.DEBUG_SQL_CACHE;
            return;
        }
        synchronized (this.mCompiledQueries) {
            if (this.mCompiledQueries.get(str) == null) {
                if (this.mCompiledQueries.size() == this.mMaxSqlCacheSize) {
                    this.mCacheFullWarnings++;
                } else {
                    this.mCompiledQueries.put(str, sQLiteCompiledSql);
                    boolean z2 = SQLiteDebug.DEBUG_SQL_CACHE;
                }
            }
        }
    }

    private void deallocCachedSqlStatements() {
        synchronized (this.mCompiledQueries) {
            for (SQLiteCompiledSql releaseSqlStatement : this.mCompiledQueries.values()) {
                releaseSqlStatement.releaseSqlStatement();
            }
            this.mCompiledQueries.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        if (r2 == false) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        r3.mNumCacheHits++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        r3.mNumCacheMisses++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        r0 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        return r4;
     */
    public SQLiteCompiledSql getCompiledStatementForSql(String str) {
        synchronized (this.mCompiledQueries) {
            if (this.mMaxSqlCacheSize == 0) {
                boolean z = SQLiteDebug.DEBUG_SQL_CACHE;
                return null;
            }
            SQLiteCompiledSql sQLiteCompiledSql = this.mCompiledQueries.get(str);
            boolean z2 = sQLiteCompiledSql != null;
        }
    }

    public boolean isInCompiledSqlCache(String str) {
        boolean containsKey;
        synchronized (this.mCompiledQueries) {
            containsKey = this.mCompiledQueries.containsKey(str);
        }
        return containsKey;
    }

    public void purgeFromCompiledSqlCache(String str) {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.remove(str);
        }
    }

    public void resetCompiledSqlCache() {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.clear();
        }
    }

    public synchronized int getMaxSqlCacheSize() {
        return this.mMaxSqlCacheSize;
    }

    public synchronized void setMaxSqlCacheSize(int i) {
        if (i > 250 || i < 0) {
            throw new IllegalStateException("expected value between 0 and 250");
        } else if (i >= this.mMaxSqlCacheSize) {
            this.mMaxSqlCacheSize = i;
        } else {
            throw new IllegalStateException("cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call.");
        }
    }

    public static byte[] getBytes(char[] cArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        ByteBuffer encode = Charset.forName("UTF-8").encode(CharBuffer.wrap(cArr));
        byte[] bArr = new byte[encode.limit()];
        encode.get(bArr);
        return bArr;
    }

    public static char[] getChars(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        CharBuffer decode = Charset.forName("UTF-8").decode(ByteBuffer.wrap(bArr));
        char[] cArr = new char[decode.limit()];
        decode.get(cArr);
        return cArr;
    }

    private void beginTransactionWithListenerInternal(SQLiteTransactionListener sQLiteTransactionListener, SQLiteDatabaseTransactionType sQLiteDatabaseTransactionType) {
        lockForced();
        if (isOpen()) {
            try {
                if (this.mLock.getHoldCount() <= 1) {
                    if (sQLiteDatabaseTransactionType == SQLiteDatabaseTransactionType.Exclusive) {
                        execSQL("BEGIN EXCLUSIVE;");
                    } else if (sQLiteDatabaseTransactionType == SQLiteDatabaseTransactionType.Immediate) {
                        execSQL("BEGIN IMMEDIATE;");
                    } else if (sQLiteDatabaseTransactionType == SQLiteDatabaseTransactionType.Deferred) {
                        execSQL("BEGIN DEFERRED;");
                    } else {
                        throw new IllegalArgumentException(String.format("%s is an unsupported transaction type", sQLiteDatabaseTransactionType));
                    }
                    this.mTransactionListener = sQLiteTransactionListener;
                    this.mTransactionIsSuccessful = true;
                    this.mInnerTransactionIsSuccessful = false;
                    if (sQLiteTransactionListener != null) {
                        sQLiteTransactionListener.onBegin();
                    }
                } else if (this.mInnerTransactionIsSuccessful) {
                    throw new IllegalStateException("Cannot call beginTransaction between calling setTransactionSuccessful and endTransaction");
                }
            } catch (RuntimeException e) {
                execSQL("ROLLBACK;");
                throw e;
            } catch (Throwable th) {
                unlockForced();
                throw th;
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    static ArrayList<SQLiteDebug.DbStats> getDbStats() {
        String str;
        ArrayList<SQLiteDebug.DbStats> arrayList = new ArrayList<>();
        Iterator<SQLiteDatabase> it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            SQLiteDatabase next = it.next();
            if (next != null && next.isOpen()) {
                int native_getDbLookaside = next.native_getDbLookaside();
                String path = next.getPath();
                int lastIndexOf = path.lastIndexOf("/");
                String substring = path.substring(lastIndexOf != -1 ? lastIndexOf + 1 : 0);
                ArrayList<Pair<String, String>> attachedDbs = getAttachedDbs(next);
                if (attachedDbs != null) {
                    int i = native_getDbLookaside;
                    for (int i2 = 0; i2 < attachedDbs.size(); i2++) {
                        Pair pair = attachedDbs.get(i2);
                        long pragmaVal = getPragmaVal(next, ((String) pair.first) + ".page_count;");
                        if (i2 == 0) {
                            str = substring;
                        } else {
                            String str2 = "  (attached) " + ((String) pair.first);
                            if (((String) pair.second).trim().length() > 0) {
                                int lastIndexOf2 = ((String) pair.second).lastIndexOf("/");
                                StringBuilder sb = new StringBuilder();
                                sb.append(str2);
                                sb.append(" : ");
                                sb.append(((String) pair.second).substring(lastIndexOf2 != -1 ? lastIndexOf2 + 1 : 0));
                                str2 = sb.toString();
                            }
                            str = str2;
                            i = 0;
                        }
                        if (pragmaVal > 0) {
                            arrayList.add(new SQLiteDebug.DbStats(str, pragmaVal, next.getPageSize(), i));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        ArrayList<SQLiteDatabase> arrayList = new ArrayList<>();
        synchronized (sActiveDatabases) {
            arrayList.addAll(sActiveDatabases.keySet());
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027  */
    private static long getPragmaVal(SQLiteDatabase sQLiteDatabase, String str) {
        if (!sQLiteDatabase.isOpen()) {
            return 0;
        }
        SQLiteStatement sQLiteStatement = null;
        try {
            SQLiteStatement sQLiteStatement2 = new SQLiteStatement(sQLiteDatabase, "PRAGMA ".concat(String.valueOf(str)));
            try {
                long simpleQueryForLong = sQLiteStatement2.simpleQueryForLong();
                sQLiteStatement2.close();
                return simpleQueryForLong;
            } catch (Throwable th) {
                th = th;
                sQLiteStatement = sQLiteStatement2;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (sQLiteStatement != null) {
            }
            throw th;
        }
    }

    private static ArrayList<Pair<String, String>> getAttachedDbs(SQLiteDatabase sQLiteDatabase) {
        if (!sQLiteDatabase.isOpen()) {
            return null;
        }
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        Cursor rawQuery = sQLiteDatabase.rawQuery("pragma database_list;", (String[]) null);
        while (rawQuery.moveToNext()) {
            arrayList.add(new Pair(rawQuery.getString(1), rawQuery.getString(2)));
        }
        rawQuery.close();
        return arrayList;
    }

    private Pair<Boolean, String> getResultFromPragma(String str) {
        Cursor rawQuery = rawQuery(str, new Object[0]);
        if (rawQuery == null) {
            return new Pair<>(Boolean.FALSE, "");
        }
        rawQuery.moveToFirst();
        String string = rawQuery.getString(0);
        rawQuery.close();
        return new Pair<>(Boolean.TRUE, string);
    }
}
