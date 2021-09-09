package com.xiaomi.passport.uicontroller;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class SimpleFutureTask<T> extends FutureTask<T> {
    public O000000o<T> mCallback;

    public static abstract class O000000o<T> {
        public abstract void O000000o(SimpleFutureTask<T> simpleFutureTask);
    }

    public SimpleFutureTask(Callable<T> callable, O000000o<T> o000000o) {
        super(callable);
        this.mCallback = o000000o;
    }

    /* access modifiers changed from: protected */
    public void done() {
        if (!isCancelled() && this.mCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.xiaomi.passport.uicontroller.SimpleFutureTask.AnonymousClass1 */

                public final void run() {
                    SimpleFutureTask.this.mCallback.O000000o(SimpleFutureTask.this);
                }
            });
        }
        super.done();
    }
}
