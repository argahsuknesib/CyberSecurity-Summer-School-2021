package com.google.android.gms.internal.measurement;

import com.google.android.gms.measurement.AppMeasurement;

final class zzhr implements Runnable {
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ AppMeasurement.ConditionalUserProperty zzaob;

    zzhr(zzhk zzhk, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.zzanw = zzhk;
        this.zzaob = conditionalUserProperty;
    }

    public final void run() {
        this.zzanw.zzb(this.zzaob);
    }
}
