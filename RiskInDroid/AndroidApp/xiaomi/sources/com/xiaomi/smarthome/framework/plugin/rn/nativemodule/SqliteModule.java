package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import _m_j.fwz;
import _m_j.fyf;
import _m_j.gbi;
import _m_j.gfr;
import _m_j.gsy;
import _m_j.jlp;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.pgsqlite.SQLitePlugin;

public class SqliteModule extends SQLitePlugin {
    public SqliteModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        FLogDefaultLoggingDelegate.getInstance().setMinimumLoggingLevel(0);
        FLog.setLoggingDelegate(FLogDefaultLoggingDelegate.getInstance());
    }

    public Context getContext() {
        return new ContextWrapper(super.getContext()) {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.SqliteModule.AnonymousClass1 */

            public final File getDatabasePath(String str) {
                return new File(SqliteModule.this.getDatabasePath(), str);
            }
        };
    }

    private static <T> T simpleProxy(Class<T> cls, InvocationHandler invocationHandler) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0092 A[SYNTHETIC, Splitter:B:36:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009d A[SYNTHETIC, Splitter:B:42:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    @ReactMethod
    public void open(final ReadableMap readableMap, final Callback callback, final Callback callback2) {
        if (readableMap.hasKey("assetFilename")) {
            File file = new File(getDatabasePath(), fyf.O000000o(readableMap, "name", ""));
            gbi.O00000o0(file.getAbsolutePath());
            String O000000o2 = fyf.O000000o(readableMap, "assetFilename", "");
            if (!file.exists()) {
                if (O000000o2.startsWith("file://")) {
                    if (gfr.f17662O000000o) {
                        gsy.O000000o(4, "getDatabasePath", O000000o2.substring(7));
                    }
                    FileInputStream fileInputStream = null;
                    try {
                        File file2 = new File(O000000o2.substring(7));
                        if (file2.exists()) {
                            FileInputStream fileInputStream2 = new FileInputStream(file2);
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                byte[] bArr = new byte[16384];
                                while (true) {
                                    int read = fileInputStream2.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                fileOutputStream.close();
                                fileInputStream = fileInputStream2;
                            } catch (Exception e) {
                                e = e;
                                fileInputStream = fileInputStream2;
                                try {
                                    callback2.invoke(Log.getStackTraceString(e));
                                    if (fileInputStream == null) {
                                        try {
                                            fileInputStream.close();
                                            return;
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                }
                                throw th;
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        callback2.invoke(Log.getStackTraceString(e));
                        if (fileInputStream == null) {
                        }
                    }
                } else if (O000000o2.startsWith("http://")) {
                    MIOTPersistModule.download("", O000000o2, null, file.getAbsolutePath(), 15000, 15000, new Callback() {
                        /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.SqliteModule.AnonymousClass2 */

                        public final void invoke(Object... objArr) {
                            if (!((Boolean) objArr[0]).booleanValue() || objArr[1] == null || !(objArr[1] instanceof ReadableMap)) {
                                callback2.invoke(readableMap);
                                return;
                            }
                            SqliteModule.super.open(readableMap, callback, callback2);
                        }
                    });
                    return;
                }
            }
        }
        super.open(readableMap, callback, callback2);
    }

    public File getDatabasePath() {
        File file = new File(MIOTBaseJavaModule.getPluginDir(getReactApplicationContext(), fwz.O000000o().O00000Oo().O0000OoO), "databases");
        file.mkdirs();
        return file;
    }

    @ReactMethod
    public void close(ReadableMap readableMap, Callback callback, Callback callback2) {
        super.close(readableMap, callback, callback2);
    }

    @ReactMethod
    public void attach(ReadableMap readableMap, Callback callback, Callback callback2) {
        super.attach(readableMap, callback, callback2);
    }

    @ReactMethod
    public void delete(ReadableMap readableMap, Callback callback, Callback callback2) {
        super.delete(readableMap, callback, callback2);
    }

    @ReactMethod
    public void backgroundExecuteSqlBatch(ReadableMap readableMap, Callback callback, Callback callback2) {
        super.backgroundExecuteSqlBatch(readableMap, callback, callback2);
    }

    @ReactMethod
    public void executeSqlBatch(ReadableMap readableMap, Callback callback, Callback callback2) {
        super.executeSqlBatch(readableMap, callback, callback2);
    }

    @ReactMethod
    public void echoStringValue(ReadableMap readableMap, Callback callback, Callback callback2) {
        super.echoStringValue(readableMap, callback, callback2);
    }

    public boolean execute(String str, final ReadableMap readableMap, jlp jlp) throws Exception {
        return "open".equalsIgnoreCase(str) ? super.execute(str, (ReadableMap) simpleProxy(ReadableMap.class, new InvocationHandler() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.SqliteModule.AnonymousClass3 */

            public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                if (objArr != null && objArr.length == 1 && "getString".equals(method.getName()) && "assetFilename".equals(objArr[0])) {
                    return null;
                }
                try {
                    return method.invoke(readableMap, objArr);
                } catch (Exception unused) {
                    throw new NoSuchKeyException((objArr == null || objArr[0] == null) ? "no args" : objArr[0].toString());
                }
            }
        }), jlp) : super.execute(str, readableMap, jlp);
    }
}
