package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class zzhn implements Runnable {
    private final /* synthetic */ AtomicReference zzanv;
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ boolean zzanz;

    zzhn(zzhk zzhk, AtomicReference atomicReference, boolean z) {
        this.zzanw = zzhk;
        this.zzanv = atomicReference;
        this.zzanz = z;
    }

    public final void run() {
        this.zzanw.zzfx().zza(this.zzanv, this.zzanz);
    }
}
