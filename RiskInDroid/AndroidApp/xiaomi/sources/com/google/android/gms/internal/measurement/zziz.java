package com.google.android.gms.internal.measurement;

final class zziz implements Runnable {
    private final /* synthetic */ zziw zzapn;
    private final /* synthetic */ zzey zzapo;

    zziz(zziw zziw, zzey zzey) {
        this.zzapn = zziw;
        this.zzapo = zzey;
    }

    public final void run() {
        synchronized (this.zzapn) {
            boolean unused = this.zzapn.zzapk = false;
            if (!this.zzapn.zzape.isConnected()) {
                this.zzapn.zzape.zzge().zzis().log("Connected to remote service");
                this.zzapn.zzape.zza(this.zzapo);
            }
        }
    }
}
