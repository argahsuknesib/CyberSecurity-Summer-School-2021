package com.google.android.gms.internal.measurement;

final class zzjf implements Runnable {
    private final /* synthetic */ Runnable zzabt;
    private final /* synthetic */ zzjr zzapt;

    zzjf(zzjc zzjc, zzjr zzjr, Runnable runnable) {
        this.zzapt = zzjr;
        this.zzabt = runnable;
    }

    public final void run() {
        this.zzapt.zzkx();
        this.zzapt.zzg(this.zzabt);
        this.zzapt.zzks();
    }
}
