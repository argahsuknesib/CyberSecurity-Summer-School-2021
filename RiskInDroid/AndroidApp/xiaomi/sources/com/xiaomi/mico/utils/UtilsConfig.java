package com.xiaomi.mico.utils;

import java.util.concurrent.TimeUnit;

public class UtilsConfig {
    private static volatile int computationThreadsCount = ((Runtime.getRuntime().availableProcessors() * 2) + 1);
    private static volatile boolean crashOnBugDetected;
    private static volatile LogCallback dummylogCallback = new LogCallback() {
        /* class com.xiaomi.mico.utils.UtilsConfig.AnonymousClass1 */

        public final void d(String str, Throwable th) {
        }

        public final void d(String str, Object... objArr) {
        }

        public final void e(String str, Throwable th) {
        }

        public final void e(String str, Object... objArr) {
        }

        public final void i(String str, Throwable th) {
        }

        public final void i(String str, Object... objArr) {
        }

        public final void v(String str, Throwable th) {
        }

        public final void v(String str, Object... objArr) {
        }

        public final void w(String str, Throwable th) {
        }

        public final void w(String str, Object... objArr) {
        }
    };
    private static long heavyWorkMaxDuration = TimeUnit.SECONDS.toMillis(10);
    private static volatile int ioThreadsCount = 40;
    private static long lightWorkMaxDuration = TimeUnit.SECONDS.toMillis(1);
    private static volatile LogCallback logCallback;
    private static int threadPriority = 0;

    public static LogCallback getLogCallback() {
        LogCallback logCallback2 = logCallback;
        return logCallback2 == null ? dummylogCallback : logCallback2;
    }

    public static void setLogCallback(LogCallback logCallback2) {
        logCallback = logCallback2;
    }

    public static void setCrashOnBugDetected(boolean z) {
        crashOnBugDetected = z;
    }

    public static boolean isCrashOnBugDetected() {
        return crashOnBugDetected;
    }

    public static int getComputationThreadsCount() {
        return computationThreadsCount;
    }

    public static void setComputationThreadsCount(int i) {
        computationThreadsCount = i;
    }

    public static int getIoThreadsCount() {
        return ioThreadsCount;
    }

    public static void setIoThreadsCount(int i) {
        ioThreadsCount = i;
    }

    public static long getLightWorkMaxDuration() {
        return lightWorkMaxDuration;
    }

    public static void setLightWorkMaxDuration(long j) {
        lightWorkMaxDuration = j;
    }

    public static long getHeavyWorkMaxDuration() {
        return heavyWorkMaxDuration;
    }

    public static void setHeavyWorkMaxDuration(long j) {
        heavyWorkMaxDuration = j;
    }

    public static int getThreadPriority() {
        return threadPriority;
    }

    public static void setThreadPriority(int i) {
        threadPriority = i;
    }
}
