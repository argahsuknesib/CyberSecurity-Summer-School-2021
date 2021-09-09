package com.google.android.gms.internal.measurement;

final class zzgx implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;

    zzgx(zzgn zzgn, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzane = zzdz;
    }

    public final void run() {
        this.zzanf.zzajp.zzkx();
        this.zzanf.zzajp.zzd(this.zzane);
    }
}
