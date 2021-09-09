package com.google.android.gms.internal.measurement;

import android.content.Intent;

final /* synthetic */ class zzjd implements Runnable {
    private final int zzabp;
    private final zzjc zzapp;
    private final zzfg zzapq;
    private final Intent zzapr;

    zzjd(zzjc zzjc, int i, zzfg zzfg, Intent intent) {
        this.zzapp = zzjc;
        this.zzabp = i;
        this.zzapq = zzfg;
        this.zzapr = intent;
    }

    public final void run() {
        this.zzapp.zza(this.zzabp, this.zzapq, this.zzapr);
    }
}
