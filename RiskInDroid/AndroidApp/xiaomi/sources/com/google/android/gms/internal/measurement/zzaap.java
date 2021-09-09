package com.google.android.gms.internal.measurement;

final class zzaap<T> implements zzaav<T> {
    private final zzaal zzbtk;
    private final zzabj<?, ?> zzbtl;
    private final boolean zzbtm;
    private final zzzj<?> zzbtn;

    private zzaap(zzabj<?, ?> zzabj, zzzj<?> zzzj, zzaal zzaal) {
        this.zzbtl = zzabj;
        this.zzbtm = zzzj.zza(zzaal);
        this.zzbtn = zzzj;
        this.zzbtk = zzaal;
    }

    static <T> zzaap<T> zza(zzabj<?, ?> zzabj, zzzj<?> zzzj, zzaal zzaal) {
        return new zzaap<>(zzabj, zzzj, zzaal);
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzbtl.zzu(t).equals(this.zzbtl.zzu(t2))) {
            return false;
        }
        if (this.zzbtm) {
            return this.zzbtn.zzs(t).equals(this.zzbtn.zzs(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzbtl.zzu(t).hashCode();
        return this.zzbtm ? (hashCode * 53) + this.zzbtn.zzs(t).hashCode() : hashCode;
    }
}
