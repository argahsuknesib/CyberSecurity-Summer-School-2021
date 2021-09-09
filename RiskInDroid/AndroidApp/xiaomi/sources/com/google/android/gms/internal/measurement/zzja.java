package com.google.android.gms.internal.measurement;

import android.content.ComponentName;

final class zzja implements Runnable {
    private final /* synthetic */ zziw zzapn;

    zzja(zziw zziw) {
        this.zzapn = zziw;
    }

    public final void run() {
        this.zzapn.zzape.onServiceDisconnected(new ComponentName(this.zzapn.zzape.getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
