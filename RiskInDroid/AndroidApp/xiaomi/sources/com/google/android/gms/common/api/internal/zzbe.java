package com.google.android.gms.common.api.internal;

abstract class zzbe {
    private final zzbc zzjg;

    protected zzbe(zzbc zzbc) {
        this.zzjg = zzbc;
    }

    /* access modifiers changed from: protected */
    public abstract void zzaq();

    public final void zzc(zzbd zzbd) {
        zzbd.zzga.lock();
        try {
            if (zzbd.zzjc == this.zzjg) {
                zzaq();
            }
        } finally {
            zzbd.zzga.unlock();
        }
    }
}
