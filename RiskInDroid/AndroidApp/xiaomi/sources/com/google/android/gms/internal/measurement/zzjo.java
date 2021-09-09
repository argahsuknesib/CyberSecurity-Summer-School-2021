package com.google.android.gms.internal.measurement;

final class zzjo extends zzem {
    private final /* synthetic */ zzjr zzapt;
    private final /* synthetic */ zzjn zzapz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjo(zzjn zzjn, zzhi zzhi, zzjr zzjr) {
        super(zzhi);
        this.zzapz = zzjn;
        this.zzapt = zzjr;
    }

    public final void run() {
        this.zzapz.cancel();
        this.zzapz.zzge().zzit().log("Starting upload from DelayedRunnable");
        this.zzapt.zzks();
    }
}
