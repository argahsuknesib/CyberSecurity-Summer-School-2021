package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;

final class SystemClock implements Clock {
    SystemClock() {
    }

    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public final long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    public final long uptimeMillis() {
        return android.os.SystemClock.uptimeMillis();
    }

    public final void sleep(long j) {
        android.os.SystemClock.sleep(j);
    }

    public final HandlerWrapper createHandler(Looper looper, Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }
}
