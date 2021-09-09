package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

final class zzab implements PendingResult.StatusListener {
    private final /* synthetic */ BasePendingResult zzgy;
    private final /* synthetic */ zzaa zzgz;

    zzab(zzaa zzaa, BasePendingResult basePendingResult) {
        this.zzgz = zzaa;
        this.zzgy = basePendingResult;
    }

    public final void onComplete(Status status) {
        this.zzgz.zzgw.remove(this.zzgy);
    }
}
