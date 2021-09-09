package com.google.android.gms.internal.measurement;

public final class zzfi {
    private final int priority;
    private final /* synthetic */ zzfg zzajc;
    private final boolean zzajd;
    private final boolean zzaje;

    zzfi(zzfg zzfg, int i, boolean z, boolean z2) {
        this.zzajc = zzfg;
        this.priority = i;
        this.zzajd = z;
        this.zzaje = z2;
    }

    public final void log(String str) {
        this.zzajc.zza(this.priority, this.zzajd, this.zzaje, str, null, null, null);
    }

    public final void zzd(String str, Object obj, Object obj2, Object obj3) {
        this.zzajc.zza(this.priority, this.zzajd, this.zzaje, str, obj, obj2, obj3);
    }

    public final void zze(String str, Object obj, Object obj2) {
        this.zzajc.zza(this.priority, this.zzajd, this.zzaje, str, obj, obj2, null);
    }

    public final void zzg(String str, Object obj) {
        this.zzajc.zza(this.priority, this.zzajd, this.zzaje, str, obj, null, null);
    }
}
