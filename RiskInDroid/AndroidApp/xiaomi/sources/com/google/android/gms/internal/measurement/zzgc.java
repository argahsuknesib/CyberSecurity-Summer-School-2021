package com.google.android.gms.internal.measurement;

final class zzgc implements Runnable {
    private final /* synthetic */ zzgl zzalb;
    private final /* synthetic */ zzfg zzalc;

    zzgc(zzgb zzgb, zzgl zzgl, zzfg zzfg) {
        this.zzalb = zzgl;
        this.zzalc = zzfg;
    }

    public final void run() {
        if (this.zzalb.zzjp() == null) {
            this.zzalc.zzim().log("Install Referrer Reporter is null");
        } else {
            this.zzalb.zzjp().zzjh();
        }
    }
}
