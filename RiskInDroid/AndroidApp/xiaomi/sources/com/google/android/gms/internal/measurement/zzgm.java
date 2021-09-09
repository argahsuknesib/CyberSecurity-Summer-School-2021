package com.google.android.gms.internal.measurement;

final class zzgm implements Runnable {
    private final /* synthetic */ zzhj zzana;
    private final /* synthetic */ zzgl zzanb;

    zzgm(zzgl zzgl, zzhj zzhj) {
        this.zzanb = zzgl;
        this.zzana = zzhj;
    }

    public final void run() {
        this.zzanb.zza(this.zzana);
        this.zzanb.start();
    }
}
