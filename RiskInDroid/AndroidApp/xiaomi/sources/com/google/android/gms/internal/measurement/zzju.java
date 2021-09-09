package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

final class zzju implements Callable<String> {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzjr zzaqu;

    zzju(zzjr zzjr, zzdz zzdz) {
        this.zzaqu = zzjr;
        this.zzane = zzdz;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzdy zza = this.zzaqu.zzgg().zzaz(this.zzane.packageName) ? this.zzaqu.zzg(this.zzane) : this.zzaqu.zzix().zzbc(this.zzane.packageName);
        if (zza != null) {
            return zza.getAppInstanceId();
        }
        this.zzaqu.zzge().zzip().log("App info was null when attempting to get app instance id");
        return null;
    }
}
