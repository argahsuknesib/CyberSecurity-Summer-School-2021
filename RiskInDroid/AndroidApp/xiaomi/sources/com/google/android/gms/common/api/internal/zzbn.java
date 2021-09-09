package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import java.util.Collections;

final class zzbn implements Runnable {
    private final /* synthetic */ ConnectionResult zzkl;
    private final /* synthetic */ GoogleApiManager.zzc zzkr;

    zzbn(GoogleApiManager.zzc zzc, ConnectionResult connectionResult) {
        this.zzkr = zzc;
        this.zzkl = connectionResult;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.common.api.internal.GoogleApiManager.zzc.zza(com.google.android.gms.common.api.internal.GoogleApiManager$zzc, boolean):boolean
     arg types: [com.google.android.gms.common.api.internal.GoogleApiManager$zzc, int]
     candidates:
      com.google.android.gms.common.api.internal.GoogleApiManager.zzc.zza(com.google.android.gms.common.internal.IAccountAccessor, java.util.Set<com.google.android.gms.common.api.Scope>):void
      com.google.android.gms.common.api.internal.zzcb.zza(com.google.android.gms.common.internal.IAccountAccessor, java.util.Set<com.google.android.gms.common.api.Scope>):void
      com.google.android.gms.common.api.internal.GoogleApiManager.zzc.zza(com.google.android.gms.common.api.internal.GoogleApiManager$zzc, boolean):boolean */
    public final void run() {
        if (this.zzkl.isSuccess()) {
            boolean unused = this.zzkr.zzkq = true;
            if (this.zzkr.zzka.requiresSignIn()) {
                this.zzkr.zzbu();
            } else {
                this.zzkr.zzka.getRemoteService(null, Collections.emptySet());
            }
        } else {
            ((GoogleApiManager.zza) GoogleApiManager.this.zzju.get(this.zzkr.zzhc)).onConnectionFailed(this.zzkl);
        }
    }
}
