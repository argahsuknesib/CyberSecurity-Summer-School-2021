package org.pgsqlite;

import _m_j.jlp;
import _m_j.jlq;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.util.Base64;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLitePlugin extends ReactContextBaseJavaModule {
    private static final Pattern FIRST_WORD = Pattern.compile("^\\s*(\\S+)", 2);
    public static final String TAG = "SQLitePlugin";
    static ConcurrentHashMap<String, O00000Oo> dbrmap = new ConcurrentHashMap<>();
    protected Context context = null;
    protected ExecutorService threadPool;

    enum Action {
        open,
        close,
        attach,
        delete,
        executeSqlBatch,
        backgroundExecuteSqlBatch,
        echoStringValue
    }

    enum QueryType {
        update,
        insert,
        delete,
        select,
        begin,
        commit,
        rollback,
        other
    }

    public String getName() {
        return "SQLite";
    }

    public SQLitePlugin(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.context = reactApplicationContext.getApplicationContext();
        this.threadPool = Executors.newCachedThreadPool();
    }

    @ReactMethod
    public void open(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            execute("open", readableMap, new jlp(callback, callback2));
        } catch (Exception e) {
            callback2.invoke("Unexpected error:" + e.getMessage());
        }
    }

    @ReactMethod
    public void close(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            execute("close", readableMap, new jlp(callback, callback2));
        } catch (Exception e) {
            callback2.invoke("Unexpected error" + e.getMessage());
        }
    }

    @ReactMethod
    public void attach(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            execute("attach", readableMap, new jlp(callback, callback2));
        } catch (Exception e) {
            callback2.invoke("Unexpected error" + e.getMessage());
        }
    }

    @ReactMethod
    public void delete(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            execute("delete", readableMap, new jlp(callback, callback2));
        } catch (Exception e) {
            callback2.invoke("Unexpected error" + e.getMessage());
        }
    }

    @ReactMethod
    public void backgroundExecuteSqlBatch(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            execute("backgroundExecuteSqlBatch", readableMap, new jlp(callback, callback2));
        } catch (Exception e) {
            callback2.invoke("Unexpected error" + e.getMessage());
        }
    }

    @ReactMethod
    public void executeSqlBatch(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            execute("executeSqlBatch", readableMap, new jlp(callback, callback2));
        } catch (Exception unused) {
            callback2.invoke("Unexpected error");
        }
    }

    @ReactMethod
    public void echoStringValue(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            execute("echoStringValue", readableMap, new jlp(callback, callback2));
        } catch (Exception unused) {
            callback2.invoke("Unexpected error");
        }
    }

    /* access modifiers changed from: protected */
    public ExecutorService getThreadPool() {
        return this.threadPool;
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: protected */
    public boolean execute(String str, ReadableMap readableMap, jlp jlp) throws Exception {
        try {
            try {
                return executeAndPossiblyThrow(Action.valueOf(str), readableMap, jlp);
            } catch (Exception e) {
                FLog.e(TAG, "unexpected error", e);
                jlp.O00000Oo("Unexpected error executing processing SQLite query");
                throw e;
            }
        } catch (IllegalArgumentException e2) {
            FLog.e(TAG, "unexpected error", e2);
            jlp.O00000Oo("Unexpected error executing processing SQLite query");
            throw e2;
        }
    }

    private boolean executeAndPossiblyThrow(Action action, ReadableMap readableMap, jlp jlp) {
        ReadableArray[] readableArrayArr;
        String[] strArr;
        String[] strArr2;
        switch (action) {
            case echoStringValue:
                jlp.O000000o(jlq.O000000o(readableMap, "value", ""));
                return true;
            case open:
                startDatabase(jlq.O000000o(readableMap, "name", ""), readableMap, jlp);
                return true;
            case close:
                closeDatabase(jlq.O000000o(readableMap, "path", ""), jlp);
                return true;
            case attach:
                attachDatabase(jlq.O000000o(readableMap, "path", ""), jlq.O000000o(readableMap, "dbName", ""), jlq.O000000o(readableMap, "dbAlias", ""), jlp);
                return true;
            case delete:
                deleteDatabase(jlq.O000000o(readableMap, "path", ""), jlp);
                return true;
            case executeSqlBatch:
            case backgroundExecuteSqlBatch:
                String O000000o2 = jlq.O000000o((ReadableMap) jlq.O00000Oo(readableMap, "dbargs"), "dbname", "");
                ReadableArray readableArray = (ReadableArray) jlq.O00000Oo(readableMap, "executes");
                if (readableArray.isNull(0)) {
                    strArr2 = new String[0];
                    strArr = null;
                    readableArrayArr = null;
                } else {
                    int size = readableArray.size();
                    String[] strArr3 = new String[size];
                    String[] strArr4 = new String[size];
                    ReadableArray[] readableArrayArr2 = new ReadableArray[size];
                    for (int i = 0; i < size; i++) {
                        ReadableMap readableMap2 = (ReadableMap) jlq.O000000o(readableArray, i);
                        strArr3[i] = jlq.O000000o(readableMap2, "sql", "");
                        strArr4[i] = jlq.O000000o(readableMap2, "qid", "");
                        readableArrayArr2[i] = (ReadableArray) jlq.O00000Oo(readableMap2, "params");
                    }
                    strArr2 = strArr3;
                    strArr = strArr4;
                    readableArrayArr = readableArrayArr2;
                }
                O000000o o000000o = new O000000o(strArr2, strArr, readableArrayArr, jlp);
                O00000Oo o00000Oo = dbrmap.get(O000000o2);
                if (o00000Oo != null) {
                    try {
                        o00000Oo.O00000o0.put(o000000o);
                        return true;
                    } catch (Exception e) {
                        FLog.e(TAG, "couldn't add to queue", e);
                        jlp.O00000Oo("couldn't add to queue");
                        return true;
                    }
                } else {
                    jlp.O00000Oo("database not open");
                    return true;
                }
            default:
                return true;
        }
    }

    public void closeAllOpenDatabases() {
        while (!dbrmap.isEmpty()) {
            String next = dbrmap.keySet().iterator().next();
            closeDatabaseNow(next);
            try {
                dbrmap.get(next).O00000o0.put(new O000000o());
            } catch (Exception e) {
                FLog.e(TAG, "couldn't stop db thread for db: ".concat(String.valueOf(next)), e);
            }
            dbrmap.remove(next);
        }
    }

    private void startDatabase(String str, ReadableMap readableMap, jlp jlp) {
        if (dbrmap.get(str) != null) {
            jlp.O000000o("database started");
            return;
        }
        O00000Oo o00000Oo = new O00000Oo(str, readableMap, jlp);
        dbrmap.put(str, o00000Oo);
        getThreadPool().execute(o00000Oo);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:36|(1:38)(1:39)|40|41|42|43|46|47|31|32) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:57|58|63|64|32) */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        com.facebook.common.logging.FLog.e(org.pgsqlite.SQLitePlugin.TAG, "pre-populated DB asset NOT FOUND in app bundle www subdirectory: ".concat(java.lang.String.valueOf(r13)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x012b, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        com.facebook.common.logging.FLog.e(org.pgsqlite.SQLitePlugin.TAG, "Error importing pre-populated DB asset", r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0136, code lost:
        throw new java.lang.Exception("Error importing pre-populated DB asset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0179, code lost:
        r12 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00a4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00f5 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:46:0x00a4=Splitter:B:46:0x00a4, B:63:0x00f5=Splitter:B:63:0x00f5, B:29:0x005c=Splitter:B:29:0x005c} */
    public SQLiteDatabase openDatabase(String str, String str2, int i, jlp jlp) throws Exception {
        InputStream inputStream;
        File file;
        try {
            SQLiteDatabase database = getDatabase(str);
            if (database != null) {
                if (database.isOpen()) {
                    throw new Exception("Database already open");
                }
            }
            boolean z = false;
            boolean z2 = str2 != null && str2.length() > 0;
            if (z2) {
                if (str2.compareTo("1") == 0) {
                    String concat = "www/".concat(String.valueOf(str));
                    try {
                        inputStream = getContext().getAssets().open(concat);
                        FLog.v(TAG, "Pre-populated DB asset FOUND  in app bundle www subdirectory: ".concat(String.valueOf(concat)));
                    } catch (Exception unused) {
                        inputStream = null;
                    }
                } else if (str2.charAt(0) == '~') {
                    String substring = str2.startsWith("~/") ? str2.substring(2) : str2.substring(1);
                    try {
                        inputStream = getContext().getAssets().open(substring);
                        FLog.v(TAG, "Pre-populated DB asset FOUND in app bundle subdirectory: ".concat(String.valueOf(substring)));
                    } catch (Exception unused2) {
                        inputStream = null;
                    }
                    FLog.e(TAG, "pre-populated DB asset NOT FOUND in app bundle www subdirectory: ".concat(String.valueOf(substring)));
                    file = null;
                    z = true;
                } else {
                    File filesDir = getContext().getFilesDir();
                    if (str2.startsWith("/")) {
                        str2 = str2.substring(1);
                    }
                    try {
                        file = new File(filesDir, str2);
                        inputStream = new FileInputStream(file);
                        try {
                            FLog.v(TAG, "Pre-populated DB asset FOUND in Files subdirectory: " + file.getCanonicalPath());
                            if (i == 1) {
                                FLog.v(TAG, "Detected read-only mode request for external asset.");
                                FLog.e(TAG, "Error opening pre-populated DB asset in app bundle www subdirectory: ".concat(String.valueOf(str2)));
                                z = true;
                            }
                        } catch (Exception unused3) {
                            file = null;
                        }
                    } catch (Exception unused4) {
                        inputStream = null;
                        file = null;
                    }
                }
                file = null;
            } else {
                inputStream = null;
                file = null;
            }
            if (file == null) {
                i = 268435456;
                file = getContext().getDatabasePath(str);
                if (!file.exists() && z2) {
                    if (z || inputStream == null) {
                        FLog.e(TAG, "Unable to import pre-populated db asset");
                        throw new Exception("Unable to import pre-populated db asset");
                    }
                    FLog.v(TAG, "Copying pre-populated db asset to destination");
                    createFromAssets(str, file, inputStream);
                }
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }
            }
            FLog.v(TAG, "DB file is ready, proceeding to OPEN SQLite DB: " + file.getAbsolutePath());
            SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(file.getAbsolutePath(), null, i);
            if (jlp != null) {
                jlp.O000000o("Database opened");
            }
            closeQuietly(inputStream);
            return openDatabase;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
            closeQuietly(inputStream);
            throw th;
        }
    }

    private void createFromAssets(String str, File file, InputStream inputStream) throws Exception {
        FileOutputStream fileOutputStream = null;
        try {
            FLog.v(TAG, "Copying pre-populated DB content");
            String absolutePath = file.getAbsolutePath();
            String substring = absolutePath.substring(0, absolutePath.lastIndexOf("/") + 1);
            File file2 = new File(substring);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(substring + str);
            FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        String str2 = TAG;
                        FLog.v(str2, "Copied pre-populated DB asset to: " + file3.getAbsolutePath());
                        closeQuietly(fileOutputStream2);
                        return;
                    }
                }
            } catch (Throwable th) {
                fileOutputStream = fileOutputStream2;
                th = th;
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeQuietly(fileOutputStream);
            throw th;
        }
    }

    private void closeDatabase(String str, jlp jlp) {
        O00000Oo o00000Oo = dbrmap.get(str);
        if (o00000Oo != null) {
            try {
                o00000Oo.O00000o0.put(new O000000o(false, jlp));
            } catch (Exception e) {
                if (jlp != null) {
                    jlp.O00000Oo("couldn't close database".concat(String.valueOf(e)));
                }
                FLog.e(TAG, "couldn't close database", e);
            }
        } else if (jlp != null) {
            jlp.O000000o("database closed");
        }
    }

    public void closeDatabaseNow(String str) {
        SQLiteDatabase database = getDatabase(str);
        if (database != null) {
            database.close();
        }
    }

    private void attachDatabase(String str, String str2, String str3, jlp jlp) {
        O00000Oo o00000Oo = dbrmap.get(str);
        if (o00000Oo != null) {
            String absolutePath = getContext().getDatabasePath(str2).getAbsolutePath();
            try {
                o00000Oo.O00000o0.put(new O000000o(new String[]{"ATTACH DATABASE '" + absolutePath + "' AS " + str3}, new String[]{"1111"}, null, jlp));
            } catch (InterruptedException unused) {
                jlp.O00000Oo("Can't put query in the queue. Interrupted.");
            }
        } else {
            jlp.O00000Oo("Database " + str + "i s not created yet");
        }
    }

    private void deleteDatabase(String str, jlp jlp) {
        O00000Oo o00000Oo = dbrmap.get(str);
        if (o00000Oo != null) {
            try {
                o00000Oo.O00000o0.put(new O000000o(true, jlp));
            } catch (Exception e) {
                if (jlp != null) {
                    jlp.O00000Oo("couldn't close database".concat(String.valueOf(e)));
                }
                FLog.e(TAG, "couldn't close database", e);
            }
        } else if (deleteDatabaseNow(str)) {
            jlp.O000000o("database deleted");
        } else {
            jlp.O00000Oo("couldn't delete database");
        }
    }

    @SuppressLint({"NewApi"})
    public boolean deleteDatabaseNow(String str) {
        return SQLiteDatabase.deleteDatabase(getContext().getDatabasePath(str));
    }

    private SQLiteDatabase getDatabase(String str) {
        O00000Oo o00000Oo = dbrmap.get(str);
        if (o00000Oo == null) {
            return null;
        }
        return o00000Oo.O00000oO;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0082, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0125 A[Catch:{ Exception -> 0x0144 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x012f A[Catch:{ Exception -> 0x012d }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0134 A[Catch:{ Exception -> 0x012d }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x016c  */
    @SuppressLint({"NewApi"})
    public void executeSqlBatch(String str, String[] strArr, ReadableArray[] readableArrayArr, String[] strArr2, jlp jlp) {
        int i;
        String str2;
        WritableMap writableMap;
        boolean z;
        String str3;
        ReadableArray readableArray;
        SQLiteStatement sQLiteStatement;
        int i2;
        WritableMap writableMap2;
        String str4;
        String[] strArr3 = strArr;
        jlp jlp2 = jlp;
        SQLiteDatabase database = getDatabase(str);
        if (database == null) {
            jlp2.O00000Oo("database has been closed");
            return;
        }
        int length = strArr3.length;
        WritableArray createArray = Arguments.createArray();
        for (i = 0; i < length; i++) {
            String str5 = strArr2[i];
            str2 = "unknown";
            try {
                String str6 = strArr3[i];
                QueryType queryType = getQueryType(str6);
                if (queryType != QueryType.update) {
                    if (queryType != QueryType.delete) {
                        if (queryType != QueryType.insert || readableArrayArr == null) {
                            str4 = str6;
                            if (queryType == QueryType.begin) {
                                try {
                                    database.beginTransaction();
                                    writableMap2 = Arguments.createMap();
                                    try {
                                        writableMap2.putInt("rowsAffected", 0);
                                    } catch (SQLiteException e) {
                                        e = e;
                                        str2 = e.getMessage();
                                        FLog.e(TAG, "SQLiteDatabase.beginTransaction() failed", e);
                                        writableMap = writableMap2;
                                        str3 = str4;
                                        z = false;
                                        if (z) {
                                        }
                                        if (writableMap != null) {
                                        }
                                    }
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    writableMap2 = null;
                                    str2 = e.getMessage();
                                    FLog.e(TAG, "SQLiteDatabase.beginTransaction() failed", e);
                                    writableMap = writableMap2;
                                    str3 = str4;
                                    z = false;
                                    if (z) {
                                    }
                                    if (writableMap != null) {
                                    }
                                }
                            } else if (queryType == QueryType.commit) {
                                try {
                                    database.setTransactionSuccessful();
                                    database.endTransaction();
                                    writableMap2 = Arguments.createMap();
                                    try {
                                        writableMap2.putInt("rowsAffected", 0);
                                    } catch (SQLiteException e3) {
                                        e = e3;
                                    }
                                } catch (SQLiteException e4) {
                                    e = e4;
                                    writableMap2 = null;
                                    str2 = e.getMessage();
                                    FLog.e(TAG, "SQLiteDatabase.setTransactionSuccessful/endTransaction() failed", e);
                                    writableMap = writableMap2;
                                    str3 = str4;
                                    z = false;
                                    if (z) {
                                    }
                                    if (writableMap != null) {
                                    }
                                }
                            } else if (queryType == QueryType.rollback) {
                                try {
                                    database.endTransaction();
                                    writableMap2 = Arguments.createMap();
                                    try {
                                        writableMap2.putInt("rowsAffected", 0);
                                    } catch (SQLiteException e5) {
                                        e = e5;
                                    }
                                } catch (SQLiteException e6) {
                                    e = e6;
                                    writableMap2 = null;
                                    str2 = e.getMessage();
                                    FLog.e(TAG, "SQLiteDatabase.endTransaction() failed", e);
                                    writableMap = writableMap2;
                                    str3 = str4;
                                    z = false;
                                    if (z) {
                                    }
                                    if (writableMap != null) {
                                    }
                                }
                            } else {
                                str3 = str4;
                                writableMap = null;
                                z = true;
                                if (z) {
                                    if (readableArrayArr != null) {
                                        readableArray = readableArrayArr[i];
                                    } else {
                                        readableArray = null;
                                    }
                                    writableMap = executeSqlStatementQuery(database, str3, readableArray, jlp2);
                                }
                                if (writableMap != null) {
                                    WritableMap createMap = Arguments.createMap();
                                    createMap.putString("qid", str5);
                                    createMap.putString("type", "success");
                                    createMap.putMap("result", writableMap);
                                    createArray.pushMap(createMap);
                                } else {
                                    WritableMap createMap2 = Arguments.createMap();
                                    createMap2.putString("qid", str5);
                                    createMap2.putString("type", "error");
                                    WritableMap createMap3 = Arguments.createMap();
                                    createMap3.putString("message", str2);
                                    createMap2.putMap("result", createMap3);
                                    createArray.pushMap(createMap2);
                                }
                            }
                        } else {
                            FLog.d("executeSqlBatch", "INSERT");
                            SQLiteStatement compileStatement = database.compileStatement(str6);
                            bindArgsToStatement(compileStatement, readableArrayArr[i]);
                            str4 = str6;
                            try {
                                long executeInsert = compileStatement.executeInsert();
                                writableMap = Arguments.createMap();
                                if (executeInsert != -1) {
                                    try {
                                        writableMap.putDouble("insertId", (double) executeInsert);
                                        writableMap.putInt("rowsAffected", 1);
                                    } catch (SQLiteException e7) {
                                        e = e7;
                                        writableMap2 = writableMap;
                                        try {
                                            str2 = e.getMessage();
                                            FLog.e(TAG, "SQLiteDatabase.executeInsert() failed", e);
                                            closeQuietly(compileStatement);
                                            writableMap = writableMap2;
                                            str3 = str4;
                                            z = false;
                                            if (z) {
                                            }
                                        } catch (Exception e8) {
                                            e = e8;
                                            writableMap = writableMap2;
                                        }
                                        if (writableMap != null) {
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        WritableMap writableMap3 = writableMap;
                                        closeQuietly(compileStatement);
                                        throw th;
                                    }
                                } else {
                                    writableMap.putInt("rowsAffected", 0);
                                }
                                try {
                                    closeQuietly(compileStatement);
                                } catch (Exception e9) {
                                    e = e9;
                                }
                            } catch (SQLiteException e10) {
                                e = e10;
                                writableMap2 = null;
                                str2 = e.getMessage();
                                FLog.e(TAG, "SQLiteDatabase.executeInsert() failed", e);
                                closeQuietly(compileStatement);
                                writableMap = writableMap2;
                                str3 = str4;
                                z = false;
                                if (z) {
                                }
                                if (writableMap != null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                closeQuietly(compileStatement);
                                throw th;
                            }
                            str3 = str4;
                            z = false;
                            if (z) {
                            }
                            if (writableMap != null) {
                            }
                        }
                        writableMap = writableMap2;
                        str3 = str4;
                        z = false;
                        if (z) {
                        }
                        if (writableMap != null) {
                        }
                    }
                }
                str3 = str6;
                try {
                    sQLiteStatement = database.compileStatement(str3);
                    if (readableArrayArr != null) {
                        try {
                            bindArgsToStatement(sQLiteStatement, readableArrayArr[i]);
                        } catch (SQLiteException e11) {
                            e = e11;
                            try {
                                str2 = e.getMessage();
                                FLog.e(TAG, "SQLiteStatement.executeUpdateDelete() failed", e);
                                closeQuietly(sQLiteStatement);
                                i2 = -1;
                                if (i2 != -1) {
                                }
                                z = false;
                                if (z) {
                                }
                                if (writableMap != null) {
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                closeQuietly(sQLiteStatement);
                                throw th;
                            }
                        }
                    }
                    i2 = sQLiteStatement.executeUpdateDelete();
                    closeQuietly(sQLiteStatement);
                } catch (SQLiteException e12) {
                    e = e12;
                    sQLiteStatement = null;
                    str2 = e.getMessage();
                    FLog.e(TAG, "SQLiteStatement.executeUpdateDelete() failed", e);
                    closeQuietly(sQLiteStatement);
                    i2 = -1;
                    if (i2 != -1) {
                    }
                    z = false;
                    if (z) {
                    }
                    if (writableMap != null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    sQLiteStatement = null;
                    closeQuietly(sQLiteStatement);
                    throw th;
                }
                if (i2 != -1) {
                    writableMap = Arguments.createMap();
                    writableMap.putInt("rowsAffected", i2);
                } else {
                    writableMap = null;
                }
                z = false;
                if (z) {
                }
            } catch (Exception e13) {
                e = e13;
                writableMap = null;
            }
            if (writableMap != null) {
            }
        }
        jlp2.f1926O000000o.invoke(createArray);
        return;
        str2 = e.getMessage();
        FLog.e(TAG, "SQLitePlugin.executeSql[Batch](): failed", e);
        if (writableMap != null) {
        }
    }

    private QueryType getQueryType(String str) {
        Matcher matcher = FIRST_WORD.matcher(str);
        if (matcher.find()) {
            try {
                return QueryType.valueOf(matcher.group(1).toLowerCase(Locale.US));
            } catch (IllegalArgumentException unused) {
            }
        }
        return QueryType.other;
    }

    private void bindArgsToStatement(SQLiteStatement sQLiteStatement, ReadableArray readableArray) {
        for (int i = 0; i < readableArray.size(); i++) {
            if (readableArray.getType(i) == ReadableType.Number) {
                double d = readableArray.getDouble(i);
                long j = (long) d;
                if (d == ((double) j)) {
                    sQLiteStatement.bindLong(i + 1, j);
                } else {
                    sQLiteStatement.bindDouble(i + 1, d);
                }
            } else if (readableArray.isNull(i)) {
                sQLiteStatement.bindNull(i + 1);
            } else {
                sQLiteStatement.bindString(i + 1, jlq.O000000o(readableArray, i, ""));
            }
        }
    }

    private WritableMap executeSqlStatementQuery(SQLiteDatabase sQLiteDatabase, String str, ReadableArray readableArray, jlp jlp) throws Exception {
        WritableMap createMap = Arguments.createMap();
        Cursor cursor = null;
        try {
            String[] strArr = new String[0];
            if (readableArray != null) {
                int size = readableArray.size();
                String[] strArr2 = new String[size];
                for (int i = 0; i < size; i++) {
                    if (readableArray.isNull(i)) {
                        strArr2[i] = "";
                    } else {
                        strArr2[i] = jlq.O000000o(readableArray, i, "");
                    }
                }
                strArr = strArr2;
            }
            cursor = sQLiteDatabase.rawQuery(str, strArr);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    WritableArray createArray = Arguments.createArray();
                    int columnCount = cursor.getColumnCount();
                    do {
                        WritableMap createMap2 = Arguments.createMap();
                        for (int i2 = 0; i2 < columnCount; i2++) {
                            bindRow(createMap2, cursor.getColumnName(i2), cursor, i2);
                        }
                        createArray.pushMap(createMap2);
                    } while (cursor.moveToNext());
                    createMap.putArray("rows", createArray);
                }
            }
            closeQuietly(cursor);
            return createMap;
        } catch (Exception e) {
            FLog.e(TAG, "SQLitePlugin.executeSql[Batch]() failed", e);
            throw e;
        } catch (Throwable th) {
            closeQuietly(cursor);
            throw th;
        }
    }

    @SuppressLint({"NewApi"})
    private void bindRow(WritableMap writableMap, String str, Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            writableMap.putNull(str);
        } else if (type == 1) {
            writableMap.putDouble(str, (double) cursor.getLong(i));
        } else if (type == 2) {
            writableMap.putDouble(str, cursor.getDouble(i));
        } else if (type != 4) {
            writableMap.putString(str, cursor.getString(i));
        } else {
            writableMap.putString(str, new String(Base64.encode(cursor.getBlob(i), 0)));
        }
    }

    private void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    class O00000Oo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f15468O000000o;
        final int O00000Oo;
        final jlp O00000o;
        final BlockingQueue<O000000o> O00000o0;
        SQLiteDatabase O00000oO;
        private String O0000O0o;
        private boolean O0000OOo;

        O00000Oo(String str, ReadableMap readableMap, jlp jlp) {
            this.f15468O000000o = str;
            int i = 268435456;
            try {
                this.O0000O0o = jlq.O000000o(readableMap, "assetFilename", (String) null);
                if (this.O0000O0o != null && this.O0000O0o.length() > 0 && jlq.O000000o(readableMap, "readOnly")) {
                    i = 1;
                }
            } catch (Exception e) {
                FLog.e(SQLitePlugin.TAG, "Error retrieving assetFilename or mode from options:", e);
            }
            this.O00000Oo = i;
            this.O0000OOo = jlq.O000000o(readableMap, "androidLockWorkaround");
            if (this.O0000OOo) {
                FLog.i(SQLitePlugin.TAG, "Android db closing/locking workaround applied");
            }
            this.O00000o0 = new LinkedBlockingQueue();
            this.O00000o = jlp;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0075  */
        /* JADX WARNING: Removed duplicated region for block: B:61:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        public final void run() {
            O000000o o000000o;
            Exception e;
            try {
                this.O00000oO = SQLitePlugin.this.openDatabase(this.f15468O000000o, this.O0000O0o, this.O00000Oo, this.O00000o);
                try {
                    o000000o = this.O00000o0.take();
                    while (!o000000o.f15467O000000o) {
                        try {
                            SQLitePlugin.this.executeSqlBatch(this.f15468O000000o, o000000o.O00000o, o000000o.O00000oo, o000000o.O00000oO, o000000o.O0000O0o);
                            if (this.O0000OOo && o000000o.O00000o.length == 1 && o000000o.O00000o[0].equals("COMMIT")) {
                                SQLitePlugin.this.closeDatabaseNow(this.f15468O000000o);
                                this.O00000oO = SQLitePlugin.this.openDatabase(this.f15468O000000o, "", this.O00000Oo, null);
                            }
                            o000000o = this.O00000o0.take();
                        } catch (Exception e2) {
                            e = e2;
                            FLog.e(SQLitePlugin.TAG, "unexpected error", e);
                            if (o000000o == null) {
                            }
                        }
                    }
                } catch (Exception e3) {
                    Exception exc = e3;
                    o000000o = null;
                    e = exc;
                    FLog.e(SQLitePlugin.TAG, "unexpected error", e);
                    if (o000000o == null) {
                        return;
                    }
                }
                if (o000000o == null && o000000o.O00000Oo) {
                    try {
                        SQLitePlugin.this.closeDatabaseNow(this.f15468O000000o);
                        SQLitePlugin.dbrmap.remove(this.f15468O000000o);
                        if (!o000000o.O00000o0) {
                            o000000o.O0000O0o.O000000o("database removed");
                            return;
                        }
                        try {
                            if (SQLitePlugin.this.deleteDatabaseNow(this.f15468O000000o)) {
                                o000000o.O0000O0o.O000000o("database removed");
                            } else {
                                o000000o.O0000O0o.O00000Oo("couldn't delete database");
                            }
                        } catch (Exception e4) {
                            FLog.e(SQLitePlugin.TAG, "couldn't delete database", e4);
                            o000000o.O0000O0o.O00000Oo("couldn't delete database: ".concat(String.valueOf(e4)));
                        }
                    } catch (Exception e5) {
                        FLog.e(SQLitePlugin.TAG, "couldn't close database", e5);
                        if (o000000o.O0000O0o != null) {
                            o000000o.O0000O0o.O00000Oo("couldn't close database: ".concat(String.valueOf(e5)));
                        }
                    }
                }
            } catch (SQLiteException e6) {
                FLog.e(SQLitePlugin.TAG, "SQLite error opening database, stopping db thread", e6);
                jlp jlp = this.O00000o;
                if (jlp != null) {
                    jlp.O00000Oo("Can't open database.".concat(String.valueOf(e6)));
                }
                SQLitePlugin.dbrmap.remove(this.f15468O000000o);
            } catch (Exception e7) {
                FLog.e(SQLitePlugin.TAG, "Unexpected error opening database, stopping db thread", e7);
                jlp jlp2 = this.O00000o;
                if (jlp2 != null) {
                    jlp2.O00000Oo("Can't open database.".concat(String.valueOf(e7)));
                }
                SQLitePlugin.dbrmap.remove(this.f15468O000000o);
            }
        }
    }

    final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final boolean f15467O000000o;
        final boolean O00000Oo;
        final String[] O00000o;
        final boolean O00000o0;
        final String[] O00000oO;
        final ReadableArray[] O00000oo;
        final jlp O0000O0o;

        O000000o(String[] strArr, String[] strArr2, ReadableArray[] readableArrayArr, jlp jlp) {
            this.f15467O000000o = false;
            this.O00000Oo = false;
            this.O00000o0 = false;
            this.O00000o = strArr;
            this.O00000oO = strArr2;
            this.O00000oo = readableArrayArr;
            this.O0000O0o = jlp;
        }

        O000000o(boolean z, jlp jlp) {
            this.f15467O000000o = true;
            this.O00000Oo = true;
            this.O00000o0 = z;
            this.O00000o = null;
            this.O00000oO = null;
            this.O00000oo = null;
            this.O0000O0o = jlp;
        }

        O000000o() {
            this.f15467O000000o = true;
            this.O00000Oo = false;
            this.O00000o0 = false;
            this.O00000o = null;
            this.O00000oO = null;
            this.O00000oo = null;
            this.O0000O0o = null;
        }
    }
}
