package com.google.android.gms.internal.measurement;

final class zzix implements Runnable {
    private final /* synthetic */ zzey zzapm;
    private final /* synthetic */ zziw zzapn;

    zzix(zziw zziw, zzey zzey) {
        this.zzapn = zziw;
        this.zzapm = zzey;
    }

    public final void run() {
        synchronized (this.zzapn) {
            boolean unused = this.zzapn.zzapk = false;
            if (!this.zzapn.zzape.isConnected()) {
                this.zzapn.zzape.zzge().zzit().log("Connected to service");
                this.zzapn.zzape.zza(this.zzapm);
            }
        }
    }
}
