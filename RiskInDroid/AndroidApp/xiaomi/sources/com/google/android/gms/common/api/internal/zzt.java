package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class zzt implements zzbq {
    private final /* synthetic */ zzr zzgc;

    private zzt(zzr zzr) {
        this.zzgc = zzr;
    }

    /* synthetic */ zzt(zzr zzr, zzs zzs) {
        this(zzr);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.common.api.internal.zzr.zza(com.google.android.gms.common.api.internal.zzr, boolean):boolean
     arg types: [com.google.android.gms.common.api.internal.zzr, int]
     candidates:
      com.google.android.gms.common.api.internal.zzr.zza(com.google.android.gms.common.api.internal.zzr, com.google.android.gms.common.ConnectionResult):com.google.android.gms.common.ConnectionResult
      com.google.android.gms.common.api.internal.zzr.zza(int, boolean):void
      com.google.android.gms.common.api.internal.zzr.zza(com.google.android.gms.common.api.internal.zzr, android.os.Bundle):void
      com.google.android.gms.common.api.internal.zzr.zza(com.google.android.gms.common.api.internal.zzr, boolean):boolean */
    public final void zzb(int i, boolean z) {
        this.zzgc.zzga.lock();
        try {
            if (!this.zzgc.zzfz && this.zzgc.zzfy != null) {
                if (this.zzgc.zzfy.isSuccess()) {
                    boolean unused = this.zzgc.zzfz = true;
                    this.zzgc.zzfs.onConnectionSuspended(i);
                }
            }
            boolean unused2 = this.zzgc.zzfz = false;
            this.zzgc.zza(i, z);
        } finally {
            this.zzgc.zzga.unlock();
        }
    }

    public final void zzb(Bundle bundle) {
        this.zzgc.zzga.lock();
        try {
            this.zzgc.zza(bundle);
            ConnectionResult unused = this.zzgc.zzfx = ConnectionResult.RESULT_SUCCESS;
            this.zzgc.zzaa();
        } finally {
            this.zzgc.zzga.unlock();
        }
    }

    public final void zzc(ConnectionResult connectionResult) {
        this.zzgc.zzga.lock();
        try {
            ConnectionResult unused = this.zzgc.zzfx = connectionResult;
            this.zzgc.zzaa();
        } finally {
            this.zzgc.zzga.unlock();
        }
    }
}
