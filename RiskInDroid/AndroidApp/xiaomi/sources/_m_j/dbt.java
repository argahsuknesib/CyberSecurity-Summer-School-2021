package _m_j;

import android.util.Log;

public final class dbt {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f14459O000000o = false;

    public static void O000000o(String str, String str2) {
        if (f14459O000000o) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.d(str, (stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + ": " + str2);
        }
    }

    public static void O00000Oo(String str, String str2) {
        if (f14459O000000o) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.i(str, (stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + ": " + str2);
        }
    }

    public static void O00000o0(String str, String str2) {
        if (f14459O000000o) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.e(str, (stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + ": " + str2);
        }
    }

    public static void O00000o(String str, String str2) {
        if (f14459O000000o) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.v(str, (stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + ": " + str2);
        }
    }
}
