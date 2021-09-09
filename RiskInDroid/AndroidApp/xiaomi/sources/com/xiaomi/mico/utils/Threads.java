package com.xiaomi.mico.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class Threads {
    private static ThreadsImplementation implementation = new ThreadsImplementation();

    private Threads() {
        implementation = new ThreadsImplementation();
    }

    public static ExecutorService getIoThreadPool() {
        return implementation.getIoThreadPool();
    }

    public static int getMaxThreadsOfIoThreadPool() {
        return implementation.getMaxThreadsOfIoThreadPool();
    }

    public static ExecutorService getComputationThreadPool() {
        return implementation.getComputationThreadPool();
    }

    public static int getMaxThreadsOfComputationThreadPool() {
        return implementation.getMaxThreadsOfComputationThreadPool();
    }

    public static ScheduledExecutorService getScheduledExecutorService() {
        return implementation.getScheduledExecutorService();
    }

    public static Handler getLightWorkHandler() {
        return implementation.getLightWorkHandler();
    }

    public static Handler getHeavyWorkHandler() {
        return implementation.getHeavyWorkHandler();
    }

    public void removeCallbacksInLightWorkThread(Runnable runnable) {
        implementation.removeCallbacksInLightWorkThread(runnable);
    }

    public void removeCallbacksInHeavyWorkThread(Runnable runnable) {
        implementation.removeCallbacksInHeavyWorkThread(runnable);
    }

    public static void postInMainThread(Runnable runnable) {
        implementation.postInMainThread(runnable);
    }

    public static void postDelayedInMainThread(Runnable runnable, long j) {
        implementation.postDelayedInMainThread(runnable, j);
    }

    public static void removeCallbacksInMainThread(Runnable runnable) {
        implementation.removeCallbacksInMainThread(runnable);
    }

    public static void verifyThread() {
        if (!isThread()) {
            if (!UtilsConfig.isCrashOnBugDetected()) {
                LogCallback logCallback = getLogCallback();
                if (logCallback != null) {
                    logCallback.e("Unexpectedly in main thread", new Object[0]);
                }
                DebugUtil.printStackTrace("BlockMainThreadError");
                return;
            }
            throw new IllegalStateException("Unexpectedly in main thread");
        }
    }

    public static void verifyMainThread() {
        implementation.verifyMainThread();
    }

    public static boolean isThread() {
        return Looper.getMainLooper() != Looper.myLooper();
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static LogCallback getLogCallback() {
        return UtilsConfig.getLogCallback();
    }
}
