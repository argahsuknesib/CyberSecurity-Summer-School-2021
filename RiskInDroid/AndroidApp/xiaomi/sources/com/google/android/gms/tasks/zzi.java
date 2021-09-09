package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzi<TResult> implements zzq<TResult> {
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private final Executor zzafk;
    /* access modifiers changed from: private */
    public OnCompleteListener<TResult> zzafs;

    public zzi(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.zzafk = executor;
        this.zzafs = onCompleteListener;
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzafs = null;
        }
    }

    public final void onComplete(Task<TResult> task) {
        synchronized (this.mLock) {
            if (this.zzafs != null) {
                this.zzafk.execute(new zzj(this, task));
            }
        }
    }
}
