package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

final class zzjv implements zzek {
    private final /* synthetic */ zzjr zzaqu;
    zzkq zzaqv;
    List<Long> zzaqw;
    List<zzkn> zzaqx;
    private long zzaqy;

    private zzjv(zzjr zzjr) {
        this.zzaqu = zzjr;
    }

    /* synthetic */ zzjv(zzjr zzjr, zzjs zzjs) {
        this(zzjr);
    }

    private static long zza(zzkn zzkn) {
        return ((zzkn.zzatb.longValue() / 1000) / 60) / 60;
    }

    public final boolean zza(long j, zzkn zzkn) {
        Preconditions.checkNotNull(zzkn);
        if (this.zzaqx == null) {
            this.zzaqx = new ArrayList();
        }
        if (this.zzaqw == null) {
            this.zzaqw = new ArrayList();
        }
        if (this.zzaqx.size() > 0 && zza(this.zzaqx.get(0)) != zza(zzkn)) {
            return false;
        }
        long zzvm = this.zzaqy + ((long) zzkn.zzvm());
        if (zzvm >= ((long) Math.max(0, zzew.zzagq.get().intValue()))) {
            return false;
        }
        this.zzaqy = zzvm;
        this.zzaqx.add(zzkn);
        this.zzaqw.add(Long.valueOf(j));
        return this.zzaqx.size() < Math.max(1, zzew.zzagr.get().intValue());
    }

    public final void zzb(zzkq zzkq) {
        Preconditions.checkNotNull(zzkq);
        this.zzaqv = zzkq;
    }
}
