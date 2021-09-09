package com.google.android.gms.internal.measurement;

final class zzfq implements Runnable {
    private final /* synthetic */ boolean zzajq;
    private final /* synthetic */ zzfp zzajr;

    zzfq(zzfp zzfp, boolean z) {
        this.zzajr = zzfp;
        this.zzajq = z;
    }

    public final void run() {
        this.zzajr.zzajp.zzm(this.zzajq);
    }
}
