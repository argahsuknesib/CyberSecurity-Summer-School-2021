package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzg<TResult> implements zzq<TResult> {
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private final Executor zzafk;
    /* access modifiers changed from: private */
    public OnCanceledListener zzafq;

    public zzg(Executor executor, OnCanceledListener onCanceledListener) {
        this.zzafk = executor;
        this.zzafq = onCanceledListener;
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzafq = null;
        }
    }

    public final void onComplete(Task task) {
        if (task.isCanceled()) {
            synchronized (this.mLock) {
                if (this.zzafq != null) {
                    this.zzafk.execute(new zzh(this));
                }
            }
        }
    }
}
