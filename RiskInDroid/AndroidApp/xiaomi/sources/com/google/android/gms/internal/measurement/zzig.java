package com.google.android.gms.internal.measurement;

import android.os.Bundle;

final class zzig implements Runnable {
    private final /* synthetic */ boolean zzaos;
    private final /* synthetic */ zzie zzaot;
    private final /* synthetic */ zzie zzaou;
    private final /* synthetic */ zzif zzaov;

    zzig(zzif zzif, boolean z, zzie zzie, zzie zzie2) {
        this.zzaov = zzif;
        this.zzaos = z;
        this.zzaot = zzie;
        this.zzaou = zzie2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzif.zza(com.google.android.gms.internal.measurement.zzie, android.os.Bundle, boolean):void
     arg types: [com.google.android.gms.internal.measurement.zzie, android.os.Bundle, int]
     candidates:
      com.google.android.gms.internal.measurement.zzif.zza(android.app.Activity, com.google.android.gms.internal.measurement.zzie, boolean):void
      com.google.android.gms.internal.measurement.zzif.zza(com.google.android.gms.internal.measurement.zzie, android.os.Bundle, boolean):void */
    public final void run() {
        if (this.zzaos && this.zzaov.zzaol != null) {
            zzif zzif = this.zzaov;
            zzif.zza(zzif.zzaol);
        }
        zzie zzie = this.zzaot;
        if (zzie == null || zzie.zzaoj != this.zzaou.zzaoj || !zzka.zzs(this.zzaot.zzaoi, this.zzaou.zzaoi) || !zzka.zzs(this.zzaot.zzul, this.zzaou.zzul)) {
            Bundle bundle = new Bundle();
            zzif.zza(this.zzaou, bundle, true);
            zzie zzie2 = this.zzaot;
            if (zzie2 != null) {
                if (zzie2.zzul != null) {
                    bundle.putString("_pn", this.zzaot.zzul);
                }
                bundle.putString("_pc", this.zzaot.zzaoi);
                bundle.putLong("_pi", this.zzaot.zzaoj);
            }
            this.zzaov.zzfu().zza("auto", "_vs", bundle);
        }
        zzif zzif2 = this.zzaov;
        zzif2.zzaol = this.zzaou;
        zzif2.zzfx().zzb(this.zzaou);
    }
}
