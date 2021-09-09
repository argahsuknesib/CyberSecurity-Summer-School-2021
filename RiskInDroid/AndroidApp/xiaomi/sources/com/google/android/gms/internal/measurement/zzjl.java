package com.google.android.gms.internal.measurement;

final class zzjl implements Runnable {
    private final /* synthetic */ long zzadj;
    private final /* synthetic */ zzjh zzapx;

    zzjl(zzjh zzjh, long j) {
        this.zzapx = zzjh;
        this.zzadj = j;
    }

    public final void run() {
        this.zzapx.zzag(this.zzadj);
    }
}
