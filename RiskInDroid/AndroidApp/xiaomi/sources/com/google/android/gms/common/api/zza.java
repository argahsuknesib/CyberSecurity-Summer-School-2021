package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;

final class zza implements PendingResult.StatusListener {
    private final /* synthetic */ Batch zzch;

    zza(Batch batch) {
        this.zzch = batch;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0067, code lost:
        return;
     */
    public final void onComplete(Status status) {
        synchronized (this.zzch.mLock) {
            if (!this.zzch.isCanceled()) {
                if (status.isCanceled()) {
                    boolean unused = this.zzch.zzcf = true;
                } else if (!status.isSuccess()) {
                    boolean unused2 = this.zzch.zzce = true;
                }
                Batch.zzb(this.zzch);
                if (this.zzch.zzcd == 0) {
                    if (this.zzch.zzcf) {
                        zza.super.cancel();
                    } else {
                        this.zzch.setResult(new BatchResult(this.zzch.zzce ? new Status(13) : Status.RESULT_SUCCESS, this.zzch.zzcg));
                    }
                }
            }
        }
    }
}
