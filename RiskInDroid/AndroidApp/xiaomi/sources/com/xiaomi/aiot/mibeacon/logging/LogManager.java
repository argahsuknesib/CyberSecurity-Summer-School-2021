package com.xiaomi.aiot.mibeacon.logging;

public class LogManager {
    private static Logger sLogger = Loggers.infoLogger();
    private static boolean sVerboseLoggingEnabled = false;

    public static boolean isVerboseLoggingEnabled() {
        return sVerboseLoggingEnabled;
    }

    public static void setLogger(Logger logger) {
        if (logger != null) {
            sLogger = logger;
            return;
        }
        throw new NullPointerException("Logger may not be null.");
    }

    public static Logger getLogger() {
        return sLogger;
    }

    public static void setVerboseLoggingEnabled(boolean z) {
        sVerboseLoggingEnabled = z;
    }

    public static void v(String str, String str2, Object... objArr) {
        sLogger.v(str, str2, objArr);
    }

    public static void v(Throwable th, String str, String str2, Object... objArr) {
        sLogger.v(th, str, str2, objArr);
    }

    public static void d(String str, String str2, Object... objArr) {
        sLogger.d(str, str2, objArr);
    }

    public static void d(Throwable th, String str, String str2, Object... objArr) {
        sLogger.d(th, str, str2, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        sLogger.i(str, str2, objArr);
    }

    public static void i(Throwable th, String str, String str2, Object... objArr) {
        sLogger.i(th, str, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        sLogger.w(str, str2, objArr);
    }

    public static void w(Throwable th, String str, String str2, Object... objArr) {
        sLogger.w(th, str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        sLogger.e(str, str2, objArr);
    }

    public static void e(Throwable th, String str, String str2, Object... objArr) {
        sLogger.e(th, str, str2, objArr);
    }

    private LogManager() {
    }
}
