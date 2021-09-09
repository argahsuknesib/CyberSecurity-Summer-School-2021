package com.xiaomi.youpin.log;

import android.util.Log;

public class LogUtils {
    public static boolean ENABLE_LOG = false;
    public static LogInterface sLogInterface;

    public static void setEnableLog(boolean z) {
        ENABLE_LOG = z;
    }

    public static void setLog(LogInterface logInterface) {
        sLogInterface = logInterface;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.youpin.log.LogUtils.v(java.lang.String, java.lang.String, boolean):int
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      com.xiaomi.youpin.log.LogUtils.v(java.lang.String, java.lang.String, java.lang.Throwable):int
      com.xiaomi.youpin.log.LogUtils.v(java.lang.String, java.lang.String, boolean):int */
    public static int v(String str, String str2) {
        v(str, str2, false);
        return 0;
    }

    public static int v(String str, String str2, boolean z) {
        if (z) {
            XLogUtils.v(str, str2);
        } else if (ENABLE_LOG) {
            return Log.v(str, str2);
        }
        LogInterface logInterface = sLogInterface;
        if (logInterface == null) {
            return 0;
        }
        logInterface.v(str, str2);
        return 0;
    }

    public static int v(String str, String str2, Throwable th) {
        v(str, str2, th, false);
        return 0;
    }

    public static int v(String str, String str2, Throwable th, boolean z) {
        if (z) {
            XLogUtils.v(str, str2, th);
        } else if (ENABLE_LOG) {
            return Log.v(str, str2, th);
        }
        LogInterface logInterface = sLogInterface;
        if (logInterface == null) {
            return 0;
        }
        logInterface.v(str, str2, th);
        return 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.youpin.log.LogUtils.d(java.lang.String, java.lang.String, boolean):int
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      com.xiaomi.youpin.log.LogUtils.d(java.lang.String, java.lang.String, java.lang.Throwable):int
      com.xiaomi.youpin.log.LogUtils.d(boolean, java.lang.String, java.lang.Object[]):int
      com.xiaomi.youpin.log.LogUtils.d(java.lang.String, java.lang.String, boolean):int */
    public static int d(String str, String str2) {
        d(str, str2, false);
        return 0;
    }

    public static int d(String str, String str2, boolean z) {
        if (z) {
            XLogUtils.d(str, str2);
        } else if (ENABLE_LOG) {
            return Log.d(str, str2);
        }
        LogInterface logInterface = sLogInterface;
        if (logInterface == null) {
            return 0;
        }
        logInterface.d(str, str2);
        return 0;
    }

    public static int d(String str, String str2, Throwable th) {
        v(str, str2, th, false);
        return 0;
    }

    public static int d(String str, String str2, Throwable th, boolean z) {
        if (z) {
            XLogUtils.d(str, str2, th);
        } else if (ENABLE_LOG) {
            return Log.d(str, str2, th);
        }
        LogInterface logInterface = sLogInterface;
        if (logInterface == null) {
            return 0;
        }
        logInterface.d(str, str2, th);
        return 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.youpin.log.LogUtils.i(java.lang.String, java.lang.String, boolean):int
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      com.xiaomi.youpin.log.LogUtils.i(java.lang.String, java.lang.String, java.lang.Throwable):int
      com.xiaomi.youpin.log.LogUtils.i(java.lang.String, java.lang.String, boolean):int */
    public static int i(String str, String str2) {
        i(str, str2, false);
        return 0;
    }

    public static int i(String str, String str2, boolean z) {
        if (z) {
            XLogUtils.i(str, str2);
        } else if (ENABLE_LOG) {
            return Log.i(str, str2);
        }
        LogInterface logInterface = sLogInterface;
        if (logInterface == null) {
            return 0;
        }
        logInterface.i(str, str2);
        return 0;
    }

    public static int i(String str, String str2, Throwable th) {
        i(str, str2, th, false);
        return 0;
    }

    public static int i(String str, String str2, Throwable th, boolean z) {
        if (z) {
            XLogUtils.i(str, str2, th);
        } else if (ENABLE_LOG) {
            return Log.i(str, str2, th);
        }
        LogInterface logInterface = sLogInterface;
        if (logInterface == null) {
            return 0;
        }
        logInterface.i(str, str2, th);
        return 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.youpin.log.LogUtils.w(java.lang.String, java.lang.String, boolean):int
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      com.xiaomi.youpin.log.LogUtils.w(java.lang.String, java.lang.String, java.lang.Throwable):int
      com.xiaomi.youpin.log.LogUtils.w(java.lang.String, java.lang.Throwable, boolean):int
      com.xiaomi.youpin.log.LogUtils.w(boolean, java.lang.String, java.lang.Object[]):int
      com.xiaomi.youpin.log.LogUtils.w(java.lang.String, java.lang.String, boolean):int */
    public static int w(String str, String str2) {
        w(str, str2, false);
        return 0;
    }

    public static int w(String str, String str2, boolean z) {
        if (z) {
            XLogUtils.w(str, str2);
        } else if (ENABLE_LOG) {
            return Log.w(str, str2);
        }
        LogInterface logInterface = sLogInterface;
        if (logInterface == null) {
            return 0;
        }
        logInterface.w(str, str2);
        return 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.youpin.log.LogUtils.w(java.lang.String, java.lang.Throwable, boolean):int
     arg types: [java.lang.String, java.lang.Throwable, int]
     candidates:
      com.xiaomi.youpin.log.LogUtils.w(java.lang.String, java.lang.String, java.lang.Throwable):int
      com.xiaomi.youpin.log.LogUtils.w(java.lang.String, java.lang.String, boolean):int
      com.xiaomi.youpin.log.LogUtils.w(boolean, java.lang.String, java.lang.Object[]):int
      com.xiaomi.youpin.log.LogUtils.w(java.lang.String, java.lang.Throwable, boolean):int */
    public static int w(String str, Throwable th) {
        w(str, th, false);
        return 0;
    }

    public static int w(String str, Throwable th, boolean z) {
        if (z) {
            XLogUtils.w(str, th);
        } else if (ENABLE_LOG) {
            return Log.w(str, th);
        }
        LogInterface logInterface = sLogInterface;
        if (logInterface == null) {
            return 0;
        }
        logInterface.w(str, th);
        return 0;
    }

    public static int w(String str, String str2, Throwable th) {
        i(str, str2, th, false);
        return 0;
    }

    public static int w(String str, String str2, Throwable th, boolean z) {
        if (z) {
            XLogUtils.w(str, str2, th);
        } else if (ENABLE_LOG) {
            return Log.w(str, str2, th);
        }
        LogInterface logInterface = sLogInterface;
        if (logInterface == null) {
            return 0;
        }
        logInterface.w(str, str2, th);
        return 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.youpin.log.LogUtils.e(java.lang.String, java.lang.String, boolean):int
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      com.xiaomi.youpin.log.LogUtils.e(java.lang.String, java.lang.String, java.lang.Throwable):int
      com.xiaomi.youpin.log.LogUtils.e(boolean, java.lang.String, java.lang.Object[]):int
      com.xiaomi.youpin.log.LogUtils.e(java.lang.String, java.lang.String, boolean):int */
    public static int e(String str, String str2) {
        e(str, str2, false);
        return 0;
    }

    public static int e(String str, String str2, boolean z) {
        if (z) {
            XLogUtils.e(str, str2);
        } else if (ENABLE_LOG) {
            return Log.e(str, str2);
        }
        LogInterface logInterface = sLogInterface;
        if (logInterface == null) {
            return 0;
        }
        logInterface.e(str, str2);
        return 0;
    }

    public static int e(String str, String str2, Throwable th) {
        e(str, str2, th, false);
        return 0;
    }

    public static int e(String str, String str2, Throwable th, boolean z) {
        if (z) {
            XLogUtils.e(str, str2, th);
        } else if (ENABLE_LOG) {
            return Log.e(str, str2, th);
        }
        LogInterface logInterface = sLogInterface;
        if (logInterface == null) {
            return 0;
        }
        logInterface.e(str, str2, th);
        return 0;
    }

    private static String handleArgs(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object append : objArr) {
            sb.append(append);
            sb.append(", ");
        }
        return sb.toString();
    }

    public static int i(String str, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return 0;
        }
        return i(str, handleArgs(objArr));
    }

    public static int v(String str, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return 0;
        }
        return v(str, handleArgs(objArr));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.youpin.log.LogUtils.d(boolean, java.lang.String, java.lang.Object[]):int
     arg types: [int, java.lang.String, java.lang.Object[]]
     candidates:
      com.xiaomi.youpin.log.LogUtils.d(java.lang.String, java.lang.String, java.lang.Throwable):int
      com.xiaomi.youpin.log.LogUtils.d(java.lang.String, java.lang.String, boolean):int
      com.xiaomi.youpin.log.LogUtils.d(boolean, java.lang.String, java.lang.Object[]):int */
    public static int d(String str, Object... objArr) {
        return d(false, str, objArr);
    }

    public static int d(boolean z, String str, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return 0;
        }
        return d(str, handleArgs(objArr), z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.youpin.log.LogUtils.w(boolean, java.lang.String, java.lang.Object[]):int
     arg types: [int, java.lang.String, java.lang.Object[]]
     candidates:
      com.xiaomi.youpin.log.LogUtils.w(java.lang.String, java.lang.String, java.lang.Throwable):int
      com.xiaomi.youpin.log.LogUtils.w(java.lang.String, java.lang.String, boolean):int
      com.xiaomi.youpin.log.LogUtils.w(java.lang.String, java.lang.Throwable, boolean):int
      com.xiaomi.youpin.log.LogUtils.w(boolean, java.lang.String, java.lang.Object[]):int */
    public static int w(String str, Object... objArr) {
        return w(false, str, objArr);
    }

    public static int w(boolean z, String str, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return 0;
        }
        return w(str, handleArgs(objArr), z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.youpin.log.LogUtils.e(boolean, java.lang.String, java.lang.Object[]):int
     arg types: [int, java.lang.String, java.lang.Object[]]
     candidates:
      com.xiaomi.youpin.log.LogUtils.e(java.lang.String, java.lang.String, java.lang.Throwable):int
      com.xiaomi.youpin.log.LogUtils.e(java.lang.String, java.lang.String, boolean):int
      com.xiaomi.youpin.log.LogUtils.e(boolean, java.lang.String, java.lang.Object[]):int */
    public static int e(String str, Object... objArr) {
        return e(false, str, objArr);
    }

    public static int e(boolean z, String str, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return 0;
        }
        return e(str, handleArgs(objArr), z);
    }

    public static void postCatchedException(Throwable th) {
        LogInterface logInterface = sLogInterface;
        if (logInterface != null) {
            logInterface.postCatchedException(th);
        }
    }

    public static String getStackTraceString(Throwable th) {
        return Log.getStackTraceString(th);
    }
}
