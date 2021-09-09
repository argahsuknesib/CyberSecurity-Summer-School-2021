package com.google.android.gms.internal.measurement;

import android.app.job.JobParameters;

final /* synthetic */ class zzje implements Runnable {
    private final JobParameters zzabs;
    private final zzjc zzapp;
    private final zzfg zzaps;

    zzje(zzjc zzjc, zzfg zzfg, JobParameters jobParameters) {
        this.zzapp = zzjc;
        this.zzaps = zzfg;
        this.zzabs = jobParameters;
    }

    public final void run() {
        this.zzapp.zza(this.zzaps, this.zzabs);
    }
}
