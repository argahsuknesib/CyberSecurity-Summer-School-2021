package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

public final class zzch<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    /* access modifiers changed from: private */
    public final Object zzfa = new Object();
    /* access modifiers changed from: private */
    public final WeakReference<GoogleApiClient> zzfc;
    /* access modifiers changed from: private */
    public ResultTransform<? super R, ? extends Result> zzmd = null;
    /* access modifiers changed from: private */
    public zzch<? extends Result> zzme = null;
    private volatile ResultCallbacks<? super R> zzmf = null;
    private PendingResult<R> zzmg = null;
    private Status zzmh = null;
    /* access modifiers changed from: private */
    public final zzcj zzmi;
    private boolean zzmj = false;

    public zzch(WeakReference<GoogleApiClient> weakReference) {
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.zzfc = weakReference;
        GoogleApiClient googleApiClient = this.zzfc.get();
        this.zzmi = new zzcj(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    /* access modifiers changed from: private */
    public static void zzb(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("TransformedResultImpl", sb.toString(), e);
            }
        }
    }

    private final void zzcb() {
        if (this.zzmd != null || this.zzmf != null) {
            GoogleApiClient googleApiClient = this.zzfc.get();
            if (!(this.zzmj || this.zzmd == null || googleApiClient == null)) {
                googleApiClient.zza(this);
                this.zzmj = true;
            }
            Status status = this.zzmh;
            if (status != null) {
                zze(status);
                return;
            }
            PendingResult<R> pendingResult = this.zzmg;
            if (pendingResult != null) {
                pendingResult.setResultCallback(this);
            }
        }
    }

    private final boolean zzcd() {
        return (this.zzmf == null || this.zzfc.get() == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public final void zzd(Status status) {
        synchronized (this.zzfa) {
            this.zzmh = status;
            zze(this.zzmh);
        }
    }

    private final void zze(Status status) {
        synchronized (this.zzfa) {
            if (this.zzmd != null) {
                Status onFailure = this.zzmd.onFailure(status);
                Preconditions.checkNotNull(onFailure, "onFailure must not return null");
                this.zzme.zzd(onFailure);
            } else if (zzcd()) {
                this.zzmf.onFailure(status);
            }
        }
    }

    public final void andFinally(ResultCallbacks<? super R> resultCallbacks) {
        synchronized (this.zzfa) {
            boolean z = true;
            Preconditions.checkState(this.zzmf == null, "Cannot call andFinally() twice.");
            if (this.zzmd != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zzmf = resultCallbacks;
            zzcb();
        }
    }

    public final void onResult(R r) {
        synchronized (this.zzfa) {
            if (!r.getStatus().isSuccess()) {
                zzd(r.getStatus());
                zzb(r);
            } else if (this.zzmd != null) {
                zzbw.zzbe().submit(new zzci(this, r));
            } else if (zzcd()) {
                this.zzmf.onSuccess(r);
            }
        }
    }

    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        zzch<? extends Result> zzch;
        synchronized (this.zzfa) {
            boolean z = true;
            Preconditions.checkState(this.zzmd == null, "Cannot call then() twice.");
            if (this.zzmf != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.zzmd = resultTransform;
            zzch = new zzch<>(this.zzfc);
            this.zzme = zzch;
            zzcb();
        }
        return zzch;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.gms.common.api.PendingResult<?>, com.google.android.gms.common.api.PendingResult<R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void zza(PendingResult<?> r2) {
        synchronized (this.zzfa) {
            this.zzmg = r2;
            zzcb();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzcc() {
        this.zzmf = null;
    }
}
