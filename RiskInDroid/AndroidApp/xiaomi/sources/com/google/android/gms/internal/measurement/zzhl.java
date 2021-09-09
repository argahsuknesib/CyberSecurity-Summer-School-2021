package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class zzhl implements Runnable {
    private final /* synthetic */ AtomicReference zzanv;
    private final /* synthetic */ zzhk zzanw;

    zzhl(zzhk zzhk, AtomicReference atomicReference) {
        this.zzanw = zzhk;
        this.zzanv = atomicReference;
    }

    public final void run() {
        synchronized (this.zzanv) {
            try {
                this.zzanv.set(Boolean.valueOf(this.zzanw.zzgg().zzhl()));
                this.zzanv.notify();
            } catch (Throwable th) {
                this.zzanv.notify();
                throw th;
            }
        }
    }
}
