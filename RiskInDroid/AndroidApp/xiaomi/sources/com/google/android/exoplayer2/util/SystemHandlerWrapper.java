package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class SystemHandlerWrapper implements HandlerWrapper {
    private final Handler handler;

    public SystemHandlerWrapper(Handler handler2) {
        this.handler = handler2;
    }

    public final Looper getLooper() {
        return this.handler.getLooper();
    }

    public final Message obtainMessage(int i) {
        return this.handler.obtainMessage(i);
    }

    public final Message obtainMessage(int i, Object obj) {
        return this.handler.obtainMessage(i, obj);
    }

    public final Message obtainMessage(int i, int i2, int i3) {
        return this.handler.obtainMessage(i, i2, i3);
    }

    public final Message obtainMessage(int i, int i2, int i3, Object obj) {
        return this.handler.obtainMessage(i, i2, i3, obj);
    }

    public final boolean sendEmptyMessage(int i) {
        return this.handler.sendEmptyMessage(i);
    }

    public final boolean sendEmptyMessageAtTime(int i, long j) {
        return this.handler.sendEmptyMessageAtTime(i, j);
    }

    public final void removeMessages(int i) {
        this.handler.removeMessages(i);
    }

    public final void removeCallbacksAndMessages(Object obj) {
        this.handler.removeCallbacksAndMessages(obj);
    }

    public final boolean post(Runnable runnable) {
        return this.handler.post(runnable);
    }

    public final boolean postDelayed(Runnable runnable, long j) {
        return this.handler.postDelayed(runnable, j);
    }
}
