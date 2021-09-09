package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zze<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzq<TResult> {
    private final Executor zzafk;
    /* access modifiers changed from: private */
    public final Continuation<TResult, Task<TContinuationResult>> zzafl;
    /* access modifiers changed from: private */
    public final zzu<TContinuationResult> zzafm;

    public zze(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation, zzu<TContinuationResult> zzu) {
        this.zzafk = executor;
        this.zzafl = continuation;
        this.zzafm = zzu;
    }

    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    public final void onCanceled() {
        this.zzafm.zzdp();
    }

    public final void onComplete(Task<TResult> task) {
        this.zzafk.execute(new zzf(this, task));
    }

    public final void onFailure(Exception exc) {
        this.zzafm.setException(exc);
    }

    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.zzafm.setResult(tcontinuationresult);
    }
}
