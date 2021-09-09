package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class zzu<TResult> extends Task<TResult> {
    private final Object mLock = new Object();
    private final zzr<TResult> zzage = new zzr<>();
    private boolean zzagf;
    private TResult zzagg;
    private Exception zzagh;
    private volatile boolean zzfi;

    static class zza extends LifecycleCallback {
        private final List<WeakReference<zzq<?>>> zzagi = new ArrayList();

        private zza(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
        }

        public static zza zze(Activity activity) {
            LifecycleFragment fragment = getFragment(activity);
            zza zza = (zza) fragment.getCallbackOrNull("TaskOnStopCallback", zza.class);
            return zza == null ? new zza(fragment) : zza;
        }

        public void onStop() {
            synchronized (this.zzagi) {
                for (WeakReference<zzq<?>> weakReference : this.zzagi) {
                    zzq zzq = (zzq) weakReference.get();
                    if (zzq != null) {
                        zzq.cancel();
                    }
                }
                this.zzagi.clear();
            }
        }

        public final <T> void zzb(zzq<T> zzq) {
            synchronized (this.zzagi) {
                this.zzagi.add(new WeakReference(zzq));
            }
        }
    }

    zzu() {
    }

    private final void zzdq() {
        Preconditions.checkState(this.zzagf, "Task is not yet complete");
    }

    private final void zzdr() {
        Preconditions.checkState(!this.zzagf, "Task is already complete");
    }

    private final void zzds() {
        if (this.zzfi) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void zzdt() {
        synchronized (this.mLock) {
            if (this.zzagf) {
                this.zzage.zza(this);
            }
        }
    }

    public final Task<TResult> addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        zzg zzg = new zzg(TaskExecutors.MAIN_THREAD, onCanceledListener);
        this.zzage.zza(zzg);
        zza.zze(activity).zzb(zzg);
        zzdt();
        return this;
    }

    public final Task<TResult> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        return addOnCanceledListener(TaskExecutors.MAIN_THREAD, onCanceledListener);
    }

    public final Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        this.zzage.zza(new zzg(executor, onCanceledListener));
        zzdt();
        return this;
    }

    public final Task<TResult> addOnCompleteListener(Activity activity, OnCompleteListener<TResult> onCompleteListener) {
        zzi zzi = new zzi(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.zzage.zza(zzi);
        zza.zze(activity).zzb(zzi);
        zzdt();
        return this;
    }

    public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    public final Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.zzage.zza(new zzi(executor, onCompleteListener));
        zzdt();
        return this;
    }

    public final Task<TResult> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        zzk zzk = new zzk(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.zzage.zza(zzk);
        zza.zze(activity).zzb(zzk);
        zzdt();
        return this;
    }

    public final Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    public final Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.zzage.zza(new zzk(executor, onFailureListener));
        zzdt();
        return this;
    }

    public final Task<TResult> addOnSuccessListener(Activity activity, OnSuccessListener<? super TResult> onSuccessListener) {
        zzm zzm = new zzm(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.zzage.zza(zzm);
        zza.zze(activity).zzb(zzm);
        zzdt();
        return this;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.tasks.Task.addOnSuccessListener(java.util.concurrent.Executor, com.google.android.gms.tasks.OnSuccessListener<? super ?>):com.google.android.gms.tasks.Task<TResult>
     arg types: [java.util.concurrent.Executor, com.google.android.gms.tasks.OnSuccessListener<? super TResult>]
     candidates:
      com.google.android.gms.tasks.zzu.addOnSuccessListener(android.app.Activity, com.google.android.gms.tasks.OnSuccessListener):com.google.android.gms.tasks.Task<TResult>
      com.google.android.gms.tasks.Task.addOnSuccessListener(android.app.Activity, com.google.android.gms.tasks.OnSuccessListener<? super ?>):com.google.android.gms.tasks.Task<TResult>
      com.google.android.gms.tasks.Task.addOnSuccessListener(java.util.concurrent.Executor, com.google.android.gms.tasks.OnSuccessListener<? super ?>):com.google.android.gms.tasks.Task<TResult> */
    public final Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super Object>) onSuccessListener);
    }

    public final Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzage.zza(new zzm(executor, onSuccessListener));
        zzdt();
        return this;
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        zzu zzu = new zzu();
        this.zzage.zza(new zzc(executor, continuation, zzu));
        zzdt();
        return zzu;
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzu zzu = new zzu();
        this.zzage.zza(new zze(executor, continuation, zzu));
        zzdt();
        return zzu;
    }

    public final Exception getException() {
        Exception exc;
        synchronized (this.mLock) {
            exc = this.zzagh;
        }
        return exc;
    }

    public final TResult getResult() {
        TResult tresult;
        synchronized (this.mLock) {
            zzdq();
            zzds();
            if (this.zzagh == null) {
                tresult = this.zzagg;
            } else {
                throw new RuntimeExecutionException(this.zzagh);
            }
        }
        return tresult;
    }

    public final <X extends Throwable> TResult getResult(Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.mLock) {
            zzdq();
            zzds();
            if (cls.isInstance(this.zzagh)) {
                throw ((Throwable) cls.cast(this.zzagh));
            } else if (this.zzagh == null) {
                tresult = this.zzagg;
            } else {
                throw new RuntimeExecutionException(this.zzagh);
            }
        }
        return tresult;
    }

    public final boolean isCanceled() {
        return this.zzfi;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzagf;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzagf && !this.zzfi && this.zzagh == null;
        }
        return z;
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return onSuccessTask(TaskExecutors.MAIN_THREAD, successContinuation);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        zzu zzu = new zzu();
        this.zzage.zza(new zzo(executor, successContinuation, zzu));
        zzdt();
        return zzu;
    }

    public final void setException(Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.mLock) {
            zzdr();
            this.zzagf = true;
            this.zzagh = exc;
        }
        this.zzage.zza(this);
    }

    public final void setResult(TResult tresult) {
        synchronized (this.mLock) {
            zzdr();
            this.zzagf = true;
            this.zzagg = tresult;
        }
        this.zzage.zza(this);
    }

    public final boolean trySetException(Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.mLock) {
            if (this.zzagf) {
                return false;
            }
            this.zzagf = true;
            this.zzagh = exc;
            this.zzage.zza(this);
            return true;
        }
    }

    public final boolean trySetResult(TResult tresult) {
        synchronized (this.mLock) {
            if (this.zzagf) {
                return false;
            }
            this.zzagf = true;
            this.zzagg = tresult;
            this.zzage.zza(this);
            return true;
        }
    }

    public final boolean zzdp() {
        synchronized (this.mLock) {
            if (this.zzagf) {
                return false;
            }
            this.zzagf = true;
            this.zzfi = true;
            this.zzage.zza(this);
            return true;
        }
    }
}
