package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzex<V> {
    private final zzws<V> zzaid;
    private final String zzny;

    private zzex(String str, zzws<V> zzws) {
        Preconditions.checkNotNull(zzws);
        this.zzaid = zzws;
        this.zzny = str;
    }

    static zzex<Double> zza(String str, double d, double d2) {
        return new zzex<>(str, zzew.zzagc.zzb(str, -3.0d));
    }

    static zzex<Long> zzb(String str, long j, long j2) {
        return new zzex<>(str, zzew.zzagc.zze(str, j));
    }

    static zzex<Boolean> zzb(String str, boolean z, boolean z2) {
        return new zzex<>(str, zzew.zzagc.zzf(str, z));
    }

    static zzex<Integer> zzc(String str, int i, int i2) {
        return new zzex<>(str, zzew.zzagc.zzd(str, i));
    }

    static zzex<String> zzd(String str, String str2, String str3) {
        return new zzex<>(str, zzew.zzagc.zzv(str, str2));
    }

    public final V get() {
        return this.zzaid.get();
    }

    public final V get(V v) {
        return v != null ? v : this.zzaid.get();
    }

    public final String getKey() {
        return this.zzny;
    }
}
