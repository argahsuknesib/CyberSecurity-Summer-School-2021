package com.google.android.gms.common.internal;

import _m_j.o0oOo0O0;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ExpirableLruCache<K, V> {
    public static int TIME_UNSET = -1;
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private final o0oOo0O0<K, V> zzsn;
    private final long zzso;
    private final long zzsp;
    /* access modifiers changed from: private */
    public HashMap<K, Long> zzsq;
    /* access modifiers changed from: private */
    public HashMap<K, Long> zzsr;

    public ExpirableLruCache(int i, long j, long j2, TimeUnit timeUnit) {
        this.zzso = TimeUnit.NANOSECONDS.convert(j, timeUnit);
        this.zzsp = TimeUnit.NANOSECONDS.convert(j2, timeUnit);
        Preconditions.checkArgument(zzct() || zzcu(), "ExpirableLruCache has both access and write expiration negative");
        this.zzsn = new zze(this, i);
        if (zzct()) {
            this.zzsq = new HashMap<>();
        }
        if (zzcu()) {
            this.zzsr = new HashMap<>();
        }
    }

    private final boolean zza(K k) {
        long nanoTime = System.nanoTime();
        if (!zzct() || !this.zzsq.containsKey(k) || nanoTime - this.zzsq.get(k).longValue() <= this.zzso) {
            return zzcu() && this.zzsr.containsKey(k) && nanoTime - this.zzsr.get(k).longValue() > this.zzsp;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean zzct() {
        return this.zzso >= 0;
    }

    /* access modifiers changed from: private */
    public final boolean zzcu() {
        return this.zzsp >= 0;
    }

    /* access modifiers changed from: protected */
    public V create(K k) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z, K k, V v, V v2) {
    }

    public void evictAll() {
        this.zzsn.evictAll();
    }

    public V get(K k) {
        V v;
        synchronized (this.mLock) {
            if (zza((Object) k)) {
                this.zzsn.remove(k);
            }
            v = this.zzsn.get(k);
            if (v != null && this.zzso > 0) {
                this.zzsq.put(k, Long.valueOf(System.nanoTime()));
            }
        }
        return v;
    }

    public V put(K k, V v) {
        if (zzcu()) {
            long nanoTime = System.nanoTime();
            synchronized (this.mLock) {
                this.zzsr.put(k, Long.valueOf(nanoTime));
            }
        }
        return this.zzsn.put(k, v);
    }

    public V remove(K k) {
        return this.zzsn.remove(k);
    }

    public void removeExpired() {
        for (K next : this.zzsn.snapshot().keySet()) {
            synchronized (this.mLock) {
                if (zza((Object) next)) {
                    this.zzsn.remove(next);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k, V v) {
        return 1;
    }

    public Map<K, V> snapshot() {
        removeExpired();
        return this.zzsn.snapshot();
    }
}
