package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzc<TResult, TContinuationResult> implements zzq<TResult> {
    private final Executor zzafk;
    /* access modifiers changed from: private */
    public final Continuation<TResult, TContinuationResult> zzafl;
    /* access modifiers changed from: private */
    public final zzu<TContinuationResult> zzafm;

    public zzc(Executor executor, Continuation<TResult, TContinuationResult> continuation, zzu<TContinuationResult> zzu) {
        this.zzafk = executor;
        this.zzafl = continuation;
        this.zzafm = zzu;
    }

    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    public final void onComplete(Task<TResult> task) {
        this.zzafk.execute(new zzd(this, task));
    }
}
