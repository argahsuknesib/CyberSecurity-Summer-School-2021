package com.google.android.gms.internal.measurement;

final class zzjk implements Runnable {
    private final /* synthetic */ long zzadj;
    private final /* synthetic */ zzjh zzapx;

    zzjk(zzjh zzjh, long j) {
        this.zzapx = zzjh;
        this.zzadj = j;
    }

    public final void run() {
        this.zzapx.zzaf(this.zzadj);
    }
}
