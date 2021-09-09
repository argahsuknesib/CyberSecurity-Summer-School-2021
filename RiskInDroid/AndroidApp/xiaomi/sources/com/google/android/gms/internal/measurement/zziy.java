package com.google.android.gms.internal.measurement;

import android.content.ComponentName;

final class zziy implements Runnable {
    private final /* synthetic */ ComponentName val$name;
    private final /* synthetic */ zziw zzapn;

    zziy(zziw zziw, ComponentName componentName) {
        this.zzapn = zziw;
        this.val$name = componentName;
    }

    public final void run() {
        this.zzapn.zzape.onServiceDisconnected(this.val$name);
    }
}
