package com.google.android.gms.internal.measurement;

final class zzgs implements Runnable {
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ zzed zzang;

    zzgs(zzgn zzgn, zzed zzed) {
        this.zzanf = zzgn;
        this.zzang = zzed;
    }

    public final void run() {
        this.zzanf.zzajp.zzkx();
        zzjr zza = this.zzanf.zzajp;
        zzed zzed = this.zzang;
        zzdz zzcb = zza.zzcb(zzed.packageName);
        if (zzcb != null) {
            zza.zzb(zzed, zzcb);
        }
    }
}
