package com.xiaomi.mico.common.util;

import android.os.Looper;

public class AssertionUtil {
    public static void checkUiThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the main thread. Was: " + Thread.currentThread());
        }
    }

    public static void checkNotUiThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException("Must not be called from the main thread. Was: " + Thread.currentThread());
        }
    }
}
