package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

final class zzu implements zzbq {
    private final /* synthetic */ zzr zzgc;

    private zzu(zzr zzr) {
        this.zzgc = zzr;
    }

    /* synthetic */ zzu(zzr zzr, zzs zzs) {
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
            if (this.zzgc.zzfz) {
                boolean unused = this.zzgc.zzfz = false;
                this.zzgc.zza(i, z);
            } else {
                boolean unused2 = this.zzgc.zzfz = true;
                this.zzgc.zzfr.onConnectionSuspended(i);
            }
        } finally {
            this.zzgc.zzga.unlock();
        }
    }

    public final void zzb(Bundle bundle) {
        this.zzgc.zzga.lock();
        try {
            ConnectionResult unused = this.zzgc.zzfy = ConnectionResult.RESULT_SUCCESS;
            this.zzgc.zzaa();
        } finally {
            this.zzgc.zzga.unlock();
        }
    }

    public final void zzc(ConnectionResult connectionResult) {
        this.zzgc.zzga.lock();
        try {
            ConnectionResult unused = this.zzgc.zzfy = connectionResult;
            this.zzgc.zzaa();
        } finally {
            this.zzgc.zzga.unlock();
        }
    }
}
