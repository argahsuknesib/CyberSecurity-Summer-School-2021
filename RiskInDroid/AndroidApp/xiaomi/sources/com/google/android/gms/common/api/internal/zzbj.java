package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;

final class zzbj implements Runnable {
    private final /* synthetic */ GoogleApiManager.zza zzkk;

    zzbj(GoogleApiManager.zza zza) {
        this.zzkk = zza;
    }

    public final void run() {
        this.zzkk.zzbk();
    }
}
