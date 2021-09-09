package com.google.android.gms.internal.measurement;

final class zzgy implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ zzeu zzank;

    zzgy(zzgn zzgn, zzeu zzeu, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzank = zzeu;
        this.zzane = zzdz;
    }

    public final void run() {
        this.zzanf.zzajp.zzkx();
        this.zzanf.zzajp.zzb(this.zzank, this.zzane);
    }
}
