package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class zzhp implements Runnable {
    private final /* synthetic */ AtomicReference zzanv;
    private final /* synthetic */ zzhk zzanw;

    zzhp(zzhk zzhk, AtomicReference atomicReference) {
        this.zzanw = zzhk;
        this.zzanv = atomicReference;
    }

    public final void run() {
        this.zzanw.zzfx().zza(this.zzanv);
    }
}
