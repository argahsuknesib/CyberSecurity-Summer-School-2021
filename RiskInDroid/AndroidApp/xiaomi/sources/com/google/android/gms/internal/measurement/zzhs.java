package com.google.android.gms.internal.measurement;

import com.google.android.gms.measurement.AppMeasurement;

final class zzhs implements Runnable {
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ AppMeasurement.ConditionalUserProperty zzaob;

    zzhs(zzhk zzhk, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.zzanw = zzhk;
        this.zzaob = conditionalUserProperty;
    }

    public final void run() {
        this.zzanw.zzc(this.zzaob);
    }
}
