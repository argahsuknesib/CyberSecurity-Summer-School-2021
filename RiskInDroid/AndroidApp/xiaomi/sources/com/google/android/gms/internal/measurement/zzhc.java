package com.google.android.gms.internal.measurement;

final class zzhc implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ zzjx zzanl;

    zzhc(zzgn zzgn, zzjx zzjx, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzanl = zzjx;
        this.zzane = zzdz;
    }

    public final void run() {
        this.zzanf.zzajp.zzkx();
        this.zzanf.zzajp.zzb(this.zzanl, this.zzane);
    }
}
