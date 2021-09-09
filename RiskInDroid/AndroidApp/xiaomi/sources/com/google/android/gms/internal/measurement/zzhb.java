package com.google.android.gms.internal.measurement;

final class zzhb implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ zzjx zzanl;

    zzhb(zzgn zzgn, zzjx zzjx, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzanl = zzjx;
        this.zzane = zzdz;
    }

    public final void run() {
        this.zzanf.zzajp.zzkx();
        this.zzanf.zzajp.zzc(this.zzanl, this.zzane);
    }
}
