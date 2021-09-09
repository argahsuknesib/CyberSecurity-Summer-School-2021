package com.google.android.gms.common.internal;

import _m_j.o0oOo0O0;

final class zze extends o0oOo0O0<K, V> {
    private final /* synthetic */ ExpirableLruCache zzss;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zze(ExpirableLruCache expirableLruCache, int i) {
        super(i);
        this.zzss = expirableLruCache;
    }

    public final V create(K k) {
        return this.zzss.create(k);
    }

    public final void entryRemoved(boolean z, K k, V v, V v2) {
        this.zzss.entryRemoved(z, k, v, v2);
        synchronized (this.zzss.mLock) {
            if (v2 == null) {
                try {
                    if (this.zzss.zzct()) {
                        this.zzss.zzsq.remove(k);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (v2 == null && this.zzss.zzcu()) {
                this.zzss.zzsr.remove(k);
            }
        }
    }

    public final int sizeOf(K k, V v) {
        return this.zzss.sizeOf(k, v);
    }
}
