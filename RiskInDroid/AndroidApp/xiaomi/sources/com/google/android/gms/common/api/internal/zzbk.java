package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;

final class zzbk implements Runnable {
    private final /* synthetic */ GoogleApiManager.zza zzkk;
    private final /* synthetic */ ConnectionResult zzkl;

    zzbk(GoogleApiManager.zza zza, ConnectionResult connectionResult) {
        this.zzkk = zza;
        this.zzkl = connectionResult;
    }

    public final void run() {
        this.zzkk.onConnectionFailed(this.zzkl);
    }
}
