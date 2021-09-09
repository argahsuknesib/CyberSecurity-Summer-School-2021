package com.xiaomi.accountsdk.utils;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public abstract class AccountLog {
    private static final AccountLog sAndroidLog;
    private static AccountLog sInstance;

    /* access modifiers changed from: protected */
    public abstract int logD(String str, String str2);

    /* access modifiers changed from: protected */
    public abstract int logD(String str, String str2, Throwable th);

    /* access modifiers changed from: protected */
    public abstract int logE(String str, String str2);

    /* access modifiers changed from: protected */
    public abstract int logE(String str, String str2, Throwable th);

    /* access modifiers changed from: protected */
    public abstract int logI(String str, String str2);

    /* access modifiers changed from: protected */
    public abstract int logI(String str, String str2, Throwable th);

    /* access modifiers changed from: protected */
    public abstract int logV(String str, String str2);

    /* access modifiers changed from: protected */
    public abstract int logV(String str, String str2, Throwable th);

    /* access modifiers changed from: protected */
    public abstract int logW(String str, String str2);

    /* access modifiers changed from: protected */
    public abstract int logW(String str, String str2, Throwable th);

    /* access modifiers changed from: protected */
    public abstract int logW(String str, Throwable th);

    static {
        AnonymousClass1 r0 = new AccountLog() {
            /* class com.xiaomi.accountsdk.utils.AccountLog.AnonymousClass1 */

            public final int logV(String str, String str2) {
                return Log.v(str, str2);
            }

            public final int logV(String str, String str2, Throwable th) {
                return Log.v(str, str2, th);
            }

            public final int logD(String str, String str2) {
                return Log.d(str, str2);
            }

            public final int logD(String str, String str2, Throwable th) {
                return Log.d(str, str2, th);
            }

            public final int logI(String str, String str2) {
                return Log.i(str, str2);
            }

            public final int logI(String str, String str2, Throwable th) {
                return Log.i(str, str2, th);
            }

            public final int logW(String str, String str2) {
                return Log.w(str, str2);
            }

            public final int logW(String str, String str2, Throwable th) {
                return Log.w(str, str2, th);
            }

            public final int logW(String str, Throwable th) {
                return Log.w(str, th);
            }

            public final int logE(String str, String str2) {
                return Log.e(str, str2);
            }

            public final int logE(String str, String str2, Throwable th) {
                return Log.e(str, str2, th);
            }
        };
        sAndroidLog = r0;
        sInstance = r0;
    }

    public static AccountLog getInstance() {
        return sInstance;
    }

    public static void setInstance(AccountLog accountLog) {
        if (accountLog != null) {
            sInstance = accountLog;
            return;
        }
        throw new IllegalArgumentException("log == null");
    }

    public static int v(String str, String str2) {
        return getInstance().logV(str, str2);
    }

    public static int v(String str, String str2, Throwable th) {
        AccountLog instance = getInstance();
        return instance.logV(str, str2 + "\n" + enThrowableMsgIfHasIPAddress(th));
    }

    public static int d(String str, String str2) {
        return getInstance().logD(str, str2);
    }

    public static int d(String str, String str2, Throwable th) {
        AccountLog instance = getInstance();
        return instance.logD(str, str2 + "\n" + enThrowableMsgIfHasIPAddress(th));
    }

    public static int i(String str, String str2) {
        return getInstance().logI(str, str2);
    }

    public static int i(String str, String str2, Throwable th) {
        AccountLog instance = getInstance();
        return instance.logI(str, str2 + "\n" + enThrowableMsgIfHasIPAddress(th));
    }

    public static int w(String str, String str2) {
        return getInstance().logW(str, str2);
    }

    public static int w(String str, String str2, Throwable th) {
        AccountLog instance = getInstance();
        return instance.logW(str, str2 + "\n" + enThrowableMsgIfHasIPAddress(th));
    }

    public static int w(String str, Throwable th) {
        return getInstance().logW(str, enThrowableMsgIfHasIPAddress(th));
    }

    public static int e(String str, String str2) {
        return getInstance().logE(str, str2);
    }

    public static int e(String str, String str2, Throwable th) {
        AccountLog instance = getInstance();
        return instance.logE(str, str2 + "\n" + enThrowableMsgIfHasIPAddress(th));
    }

    private static String getStackTraceAsString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private static String enThrowableMsgIfHasIPAddress(Throwable th) {
        if (th == null) {
            return "";
        }
        return IpFilterHelper.envIPAddressIfHas(getStackTraceAsString(th));
    }
}
