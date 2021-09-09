package io.realm.log;

import android.util.Log;
import java.util.Locale;

public final class RealmLog {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f15357O000000o = "REALM_JAVA";

    private static native void nativeAddLogger(RealmLogger realmLogger);

    private static native void nativeClearLoggers();

    static native void nativeCloseCoreLoggerBridge(long j);

    static native long nativeCreateCoreLoggerBridge(String str);

    private static native int nativeGetLogLevel();

    private static native void nativeLog(int i, String str, Throwable th, String str2);

    static native void nativeLogToCoreLoggerBridge(long j, int i, String str);

    private static native void nativeRegisterDefaultLogger();

    private static native void nativeRemoveLogger(RealmLogger realmLogger);

    private static native void nativeSetLogLevel(int i);

    public static void O000000o(Throwable th, String str, Object... objArr) {
        O000000o(6, th, str, objArr);
    }

    public static void O000000o(String str, Object... objArr) {
        O000000o(5, null, str, objArr);
    }

    public static void O00000Oo(String str, Object... objArr) {
        O000000o(7, null, str, objArr);
    }

    private static void O000000o(int i, Throwable th, String str, Object... objArr) {
        if (i >= nativeGetLogLevel()) {
            StringBuilder sb = new StringBuilder();
            if (!(str == null || objArr == null || objArr.length <= 0)) {
                str = String.format(Locale.US, str, objArr);
            }
            if (th != null) {
                sb.append(Log.getStackTraceString(th));
            }
            if (str != null) {
                if (th != null) {
                    sb.append("\n");
                }
                sb.append(str);
            }
            nativeLog(i, f15357O000000o, th, sb.toString());
        }
    }
}
