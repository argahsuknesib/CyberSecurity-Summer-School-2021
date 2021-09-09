package com.google.android.gms.internal.measurement;

final class zzen implements Runnable {
    private final /* synthetic */ zzhi zzafk;
    private final /* synthetic */ zzem zzafl;

    zzen(zzem zzem, zzhi zzhi) {
        this.zzafl = zzem;
        this.zzafk = zzhi;
    }

    public final void run() {
        this.zzafk.zzgd();
        if (zzgg.isMainThread()) {
            this.zzafk.zzgd().zzc(this);
            return;
        }
        boolean zzef = this.zzafl.zzef();
        long unused = this.zzafl.zzye = 0;
        if (zzef) {
            this.zzafl.run();
        }
    }
}
