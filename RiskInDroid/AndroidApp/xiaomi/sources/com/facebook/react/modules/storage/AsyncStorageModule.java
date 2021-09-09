package com.facebook.react.modules.storage;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.common.ModuleDataCleaner;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;

@ReactModule(name = "AsyncSQLiteDBStorage")
public final class AsyncStorageModule extends ReactContextBaseJavaModule implements ModuleDataCleaner.Cleanable {
    private final SerialExecutor executor;
    public ReactDatabaseSupplier mReactDatabaseSupplier;
    private boolean mShuttingDown;

    public final String getName() {
        return "AsyncSQLiteDBStorage";
    }

    class SerialExecutor implements Executor {
        private final Executor executor;
        private Runnable mActive;
        private final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();

        SerialExecutor(Executor executor2) {
            this.executor = executor2;
        }

        public synchronized void execute(final Runnable runnable) {
            this.mTasks.offer(new Runnable() {
                /* class com.facebook.react.modules.storage.AsyncStorageModule.SerialExecutor.AnonymousClass1 */

                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.scheduleNext();
                    }
                }
            });
            if (this.mActive == null) {
                scheduleNext();
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void scheduleNext() {
            Runnable poll = this.mTasks.poll();
            this.mActive = poll;
            if (poll != null) {
                this.executor.execute(this.mActive);
            }
        }
    }

    public AsyncStorageModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @VisibleForTesting
    AsyncStorageModule(ReactApplicationContext reactApplicationContext, Executor executor2) {
        super(reactApplicationContext);
        this.mShuttingDown = false;
        this.executor = new SerialExecutor(executor2);
        this.mReactDatabaseSupplier = ReactDatabaseSupplier.getInstance(reactApplicationContext);
    }

    public final void initialize() {
        super.initialize();
        this.mShuttingDown = false;
    }

    public final void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
    }

    public final void clearSensitiveData() {
        this.mReactDatabaseSupplier.clearAndCloseDatabase();
    }

    @ReactMethod
    public final void multiGet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray == null) {
            callback.invoke(AsyncStorageErrorUtil.getInvalidKeyError(null), null);
            return;
        }
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.facebook.react.modules.storage.AsyncStorageModule.AnonymousClass1 */

            /* access modifiers changed from: protected */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x0106  */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x010e  */
            /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
            public void doInBackgroundGuarded(Void... voidArr) {
                Cursor cursor;
                Cursor cursor2;
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError(null), null);
                    return;
                }
                String[] strArr = {"key", "value"};
                HashSet hashSet = new HashSet();
                WritableArray createArray = Arguments.createArray();
                int i = 0;
                while (i < readableArray.size()) {
                    int min = Math.min(readableArray.size() - i, 999);
                    try {
                        int i2 = min;
                        int i3 = i;
                        cursor = AsyncStorageModule.this.mReactDatabaseSupplier.get().query("catalystLocalStorage", strArr, AsyncLocalStorageUtil.buildKeySelection(min), AsyncLocalStorageUtil.buildKeySelectionArgs(readableArray, i, min), null, null, null);
                        try {
                            hashSet.clear();
                            if (cursor.getCount() != readableArray.size()) {
                                for (int i4 = i3; i4 < i3 + i2; i4++) {
                                    hashSet.add(readableArray.getString(i4));
                                }
                            }
                            if (cursor.moveToFirst()) {
                                do {
                                    WritableArray createArray2 = Arguments.createArray();
                                    createArray2.pushString(cursor.getString(0));
                                    createArray2.pushString(cursor.getString(1));
                                    createArray.pushArray(createArray2);
                                    hashSet.remove(cursor.getString(0));
                                } while (cursor.moveToNext());
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                WritableArray createArray3 = Arguments.createArray();
                                createArray3.pushString((String) it.next());
                                createArray3.pushNull();
                                createArray.pushArray(createArray3);
                            }
                            hashSet.clear();
                            i = i3 + 999;
                        } catch (Exception e) {
                            e = e;
                            cursor2 = cursor;
                            try {
                                FLog.w("ReactNative", e.getMessage(), e);
                                callback.invoke(AsyncStorageErrorUtil.getError(null, e.getMessage()), null);
                                if (cursor2 == null) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursor2;
                                if (cursor != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor2 = null;
                        FLog.w("ReactNative", e.getMessage(), e);
                        callback.invoke(AsyncStorageErrorUtil.getError(null, e.getMessage()), null);
                        if (cursor2 == null) {
                            cursor2.close();
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                callback.invoke(null, createArray);
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public final void multiSet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(AsyncStorageErrorUtil.getInvalidKeyError(null));
            return;
        }
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.facebook.react.modules.storage.AsyncStorageModule.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                WritableMap writableMap = null;
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError(null));
                    return;
                }
                SQLiteStatement compileStatement = AsyncStorageModule.this.mReactDatabaseSupplier.get().compileStatement("INSERT OR REPLACE INTO catalystLocalStorage VALUES (?, ?);");
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                    int i = 0;
                    while (i < readableArray.size()) {
                        if (readableArray.getArray(i).size() != 2) {
                            WritableMap invalidValueError = AsyncStorageErrorUtil.getInvalidValueError(null);
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                return;
                            } catch (Exception e) {
                                FLog.w("ReactNative", e.getMessage(), e);
                                if (invalidValueError == null) {
                                    AsyncStorageErrorUtil.getError(null, e.getMessage());
                                    return;
                                }
                                return;
                            }
                        } else if (readableArray.getArray(i).getString(0) == null) {
                            WritableMap invalidKeyError = AsyncStorageErrorUtil.getInvalidKeyError(null);
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                return;
                            } catch (Exception e2) {
                                FLog.w("ReactNative", e2.getMessage(), e2);
                                if (invalidKeyError == null) {
                                    AsyncStorageErrorUtil.getError(null, e2.getMessage());
                                    return;
                                }
                                return;
                            }
                        } else if (readableArray.getArray(i).getString(1) == null) {
                            WritableMap invalidValueError2 = AsyncStorageErrorUtil.getInvalidValueError(null);
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                return;
                            } catch (Exception e3) {
                                FLog.w("ReactNative", e3.getMessage(), e3);
                                if (invalidValueError2 == null) {
                                    AsyncStorageErrorUtil.getError(null, e3.getMessage());
                                    return;
                                }
                                return;
                            }
                        } else {
                            compileStatement.clearBindings();
                            compileStatement.bindString(1, readableArray.getArray(i).getString(0));
                            compileStatement.bindString(2, readableArray.getArray(i).getString(1));
                            compileStatement.execute();
                            i++;
                        }
                    }
                    AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e4) {
                        FLog.w("ReactNative", e4.getMessage(), e4);
                        writableMap = AsyncStorageErrorUtil.getError(null, e4.getMessage());
                    }
                } catch (Exception e5) {
                    FLog.w("ReactNative", e5.getMessage(), e5);
                    WritableMap error = AsyncStorageErrorUtil.getError(null, e5.getMessage());
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e6) {
                        FLog.w("ReactNative", e6.getMessage(), e6);
                        if (error == null) {
                            writableMap = AsyncStorageErrorUtil.getError(null, e6.getMessage());
                        }
                    }
                    writableMap = error;
                } catch (Throwable th) {
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e7) {
                        FLog.w("ReactNative", e7.getMessage(), e7);
                        AsyncStorageErrorUtil.getError(null, e7.getMessage());
                    }
                    throw th;
                }
                if (writableMap != null) {
                    callback.invoke(writableMap);
                    return;
                }
                callback.invoke(new Object[0]);
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public final void multiRemove(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(AsyncStorageErrorUtil.getInvalidKeyError(null));
            return;
        }
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.facebook.react.modules.storage.AsyncStorageModule.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                WritableMap writableMap = null;
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError(null));
                    return;
                }
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                    for (int i = 0; i < readableArray.size(); i += 999) {
                        int min = Math.min(readableArray.size() - i, 999);
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().delete("catalystLocalStorage", AsyncLocalStorageUtil.buildKeySelection(min), AsyncLocalStorageUtil.buildKeySelectionArgs(readableArray, i, min));
                    }
                    AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e) {
                        FLog.w("ReactNative", e.getMessage(), e);
                        writableMap = AsyncStorageErrorUtil.getError(null, e.getMessage());
                    }
                } catch (Exception e2) {
                    FLog.w("ReactNative", e2.getMessage(), e2);
                    WritableMap error = AsyncStorageErrorUtil.getError(null, e2.getMessage());
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e3) {
                        FLog.w("ReactNative", e3.getMessage(), e3);
                        if (error == null) {
                            writableMap = AsyncStorageErrorUtil.getError(null, e3.getMessage());
                        }
                    }
                    writableMap = error;
                } catch (Throwable th) {
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e4) {
                        FLog.w("ReactNative", e4.getMessage(), e4);
                        AsyncStorageErrorUtil.getError(null, e4.getMessage());
                    }
                    throw th;
                }
                if (writableMap != null) {
                    callback.invoke(writableMap);
                    return;
                }
                callback.invoke(new Object[0]);
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public final void multiMerge(final ReadableArray readableArray, final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.facebook.react.modules.storage.AsyncStorageModule.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                WritableMap writableMap = null;
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError(null));
                    return;
                }
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                    int i = 0;
                    while (i < readableArray.size()) {
                        if (readableArray.getArray(i).size() != 2) {
                            WritableMap invalidValueError = AsyncStorageErrorUtil.getInvalidValueError(null);
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                return;
                            } catch (Exception e) {
                                FLog.w("ReactNative", e.getMessage(), e);
                                if (invalidValueError == null) {
                                    AsyncStorageErrorUtil.getError(null, e.getMessage());
                                    return;
                                }
                                return;
                            }
                        } else if (readableArray.getArray(i).getString(0) == null) {
                            WritableMap invalidKeyError = AsyncStorageErrorUtil.getInvalidKeyError(null);
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                return;
                            } catch (Exception e2) {
                                FLog.w("ReactNative", e2.getMessage(), e2);
                                if (invalidKeyError == null) {
                                    AsyncStorageErrorUtil.getError(null, e2.getMessage());
                                    return;
                                }
                                return;
                            }
                        } else if (readableArray.getArray(i).getString(1) == null) {
                            WritableMap invalidValueError2 = AsyncStorageErrorUtil.getInvalidValueError(null);
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                return;
                            } catch (Exception e3) {
                                FLog.w("ReactNative", e3.getMessage(), e3);
                                if (invalidValueError2 == null) {
                                    AsyncStorageErrorUtil.getError(null, e3.getMessage());
                                    return;
                                }
                                return;
                            }
                        } else if (!AsyncLocalStorageUtil.mergeImpl(AsyncStorageModule.this.mReactDatabaseSupplier.get(), readableArray.getArray(i).getString(0), readableArray.getArray(i).getString(1))) {
                            WritableMap dBError = AsyncStorageErrorUtil.getDBError(null);
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                return;
                            } catch (Exception e4) {
                                FLog.w("ReactNative", e4.getMessage(), e4);
                                if (dBError == null) {
                                    AsyncStorageErrorUtil.getError(null, e4.getMessage());
                                    return;
                                }
                                return;
                            }
                        } else {
                            i++;
                        }
                    }
                    AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e5) {
                        FLog.w("ReactNative", e5.getMessage(), e5);
                        writableMap = AsyncStorageErrorUtil.getError(null, e5.getMessage());
                    }
                } catch (Exception e6) {
                    FLog.w("ReactNative", e6.getMessage(), e6);
                    WritableMap error = AsyncStorageErrorUtil.getError(null, e6.getMessage());
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e7) {
                        FLog.w("ReactNative", e7.getMessage(), e7);
                        if (error == null) {
                            writableMap = AsyncStorageErrorUtil.getError(null, e7.getMessage());
                        }
                    }
                    writableMap = error;
                } catch (Throwable th) {
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e8) {
                        FLog.w("ReactNative", e8.getMessage(), e8);
                        AsyncStorageErrorUtil.getError(null, e8.getMessage());
                    }
                    throw th;
                }
                if (writableMap != null) {
                    callback.invoke(writableMap);
                    return;
                }
                callback.invoke(new Object[0]);
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public final void clear(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.facebook.react.modules.storage.AsyncStorageModule.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                if (!AsyncStorageModule.this.mReactDatabaseSupplier.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError(null));
                    return;
                }
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.clear();
                    callback.invoke(new Object[0]);
                } catch (Exception e) {
                    FLog.w("ReactNative", e.getMessage(), e);
                    callback.invoke(AsyncStorageErrorUtil.getError(null, e.getMessage()));
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public final void getAllKeys(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.facebook.react.modules.storage.AsyncStorageModule.AnonymousClass6 */

            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(AsyncStorageErrorUtil.getDBError(null), null);
                    return;
                }
                WritableArray createArray = Arguments.createArray();
                Cursor query = AsyncStorageModule.this.mReactDatabaseSupplier.get().query("catalystLocalStorage", new String[]{"key"}, null, null, null, null, null);
                try {
                    if (query.moveToFirst()) {
                        do {
                            createArray.pushString(query.getString(0));
                        } while (query.moveToNext());
                    }
                    query.close();
                    callback.invoke(null, createArray);
                } catch (Exception e) {
                    FLog.w("ReactNative", e.getMessage(), e);
                    callback.invoke(AsyncStorageErrorUtil.getError(null, e.getMessage()), null);
                    query.close();
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    public final boolean ensureDatabase() {
        return !this.mShuttingDown && this.mReactDatabaseSupplier.ensureDatabase();
    }
}
