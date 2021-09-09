package com.xiaomi.aiot.mibeacon.logging;

import android.util.Log;

final class InfoAndroidLogger extends AbstractAndroidLogger {
    public final void d(String str, String str2, Object... objArr) {
    }

    public final void d(Throwable th, String str, String str2, Object... objArr) {
    }

    public final void v(String str, String str2, Object... objArr) {
    }

    public final void v(Throwable th, String str, String str2, Object... objArr) {
    }

    InfoAndroidLogger() {
    }

    public final void i(String str, String str2, Object... objArr) {
        Log.i(str, formatString(str2, objArr));
    }

    public final void i(Throwable th, String str, String str2, Object... objArr) {
        Log.i(str, formatString(str2, objArr), th);
    }

    public final void w(String str, String str2, Object... objArr) {
        Log.w(str, formatString(str2, objArr));
    }

    public final void w(Throwable th, String str, String str2, Object... objArr) {
        Log.w(str, formatString(str2, objArr), th);
    }

    public final void e(String str, String str2, Object... objArr) {
        Log.e(str, formatString(str2, objArr));
    }

    public final void e(Throwable th, String str, String str2, Object... objArr) {
        Log.e(str, formatString(str2, objArr), th);
    }
}
