package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VolleyLog {
    public static boolean DEBUG = Log.isLoggable("Volley", 2);
    public static String TAG = "Volley";

    public static void setTag(String str) {
        d("Changing log tag to %s", str);
        TAG = str;
        DEBUG = Log.isLoggable(str, 2);
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, buildMessage(str, objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        Log.d(TAG, buildMessage(str, objArr));
    }

    public static void e(String str, Object... objArr) {
        Log.e(TAG, buildMessage(str, objArr));
    }

    public static void e(Throwable th, String str, Object... objArr) {
        Log.e(TAG, buildMessage(str, objArr), th);
    }

    public static void wtf(String str, Object... objArr) {
        Log.wtf(TAG, buildMessage(str, objArr));
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        Log.wtf(TAG, buildMessage(str, objArr), th);
    }

    private static String buildMessage(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClass().equals(VolleyLog.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    static class MarkerLog {
        public static final boolean ENABLED = VolleyLog.DEBUG;
        private boolean mFinished = false;
        private final List<Marker> mMarkers = new ArrayList();

        MarkerLog() {
        }

        static class Marker {
            public final String name;
            public final long thread;
            public final long time;

            public Marker(String str, long j, long j2) {
                this.name = str;
                this.thread = j;
                this.time = j2;
            }
        }

        public synchronized void add(String str, long j) {
            if (!this.mFinished) {
                this.mMarkers.add(new Marker(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public synchronized void finish(String str) {
            this.mFinished = true;
            long totalDuration = getTotalDuration();
            if (totalDuration > 0) {
                long j = this.mMarkers.get(0).time;
                VolleyLog.d("(%-4d ms) %s", Long.valueOf(totalDuration), str);
                for (Marker next : this.mMarkers) {
                    long j2 = next.time;
                    VolleyLog.d("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(next.thread), next.name);
                    j = j2;
                }
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            if (!this.mFinished) {
                finish("Request on the loose");
                VolleyLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        private long getTotalDuration() {
            if (this.mMarkers.size() == 0) {
                return 0;
            }
            long j = this.mMarkers.get(0).time;
            List<Marker> list = this.mMarkers;
            return list.get(list.size() - 1).time - j;
        }
    }
}
