package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzbl implements BaseGmsClient.SignOutCallbacks {
    final /* synthetic */ GoogleApiManager.zza zzkk;

    zzbl(GoogleApiManager.zza zza) {
        this.zzkk = zza;
    }

    public final void onSignOutComplete() {
        GoogleApiManager.this.handler.post(new zzbm(this));
    }
}
