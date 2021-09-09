package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzjh extends zzhh {
    private Handler handler;
    @VisibleForTesting
    private long zzapu = zzbt().elapsedRealtime();
    private final zzem zzapv = new zzji(this, this.zzacw);
    private final zzem zzapw = new zzjj(this, this.zzacw);

    zzjh(zzgl zzgl) {
        super(zzgl);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    /* access modifiers changed from: private */
    public final void zzaf(long j) {
        zzem zzem;
        long j2;
        zzab();
        zzki();
        this.zzapv.cancel();
        this.zzapw.cancel();
        zzge().zzit().zzg("Activity resumed, time", Long.valueOf(j));
        this.zzapu = j;
        if (zzbt().currentTimeMillis() - zzgf().zzakj.get() > zzgf().zzakl.get()) {
            zzgf().zzakk.set(true);
            zzgf().zzakm.set(0);
        }
        if (zzgf().zzakk.get()) {
            zzem = this.zzapv;
            j2 = zzgf().zzaki.get();
        } else {
            zzem = this.zzapw;
            j2 = 3600000;
        }
        zzem.zzh(Math.max(0L, j2 - zzgf().zzakm.get()));
    }

    /* access modifiers changed from: private */
    public final void zzag(long j) {
        zzab();
        zzki();
        this.zzapv.cancel();
        this.zzapw.cancel();
        zzge().zzit().zzg("Activity paused, time", Long.valueOf(j));
        if (this.zzapu != 0) {
            zzgf().zzakm.set(zzgf().zzakm.get() + (j - this.zzapu));
        }
    }

    private final void zzki() {
        synchronized (this) {
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzkk() {
        zzab();
        zzl(false);
        zzft().zzk(zzbt().elapsedRealtime());
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        super.zzfr();
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        super.zzfs();
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        return super.zzft();
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        return super.zzfu();
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        return super.zzfv();
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        return super.zzfw();
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        return super.zzfx();
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        return super.zzfy();
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        return super.zzfz();
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        return super.zzga();
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        return super.zzgb();
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        return super.zzgc();
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        return super.zzgd();
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        return super.zzge();
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        return super.zzgf();
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        return super.zzgg();
    }

    /* access modifiers changed from: protected */
    public final boolean zzhf() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void zzkj() {
        this.zzapv.cancel();
        this.zzapw.cancel();
        this.zzapu = 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzif.zza(com.google.android.gms.internal.measurement.zzie, android.os.Bundle, boolean):void
     arg types: [com.google.android.gms.internal.measurement.zzie, android.os.Bundle, int]
     candidates:
      com.google.android.gms.internal.measurement.zzif.zza(android.app.Activity, com.google.android.gms.internal.measurement.zzie, boolean):void
      com.google.android.gms.internal.measurement.zzif.zza(com.google.android.gms.internal.measurement.zzie, android.os.Bundle, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public final boolean zzl(boolean z) {
        zzab();
        zzch();
        long elapsedRealtime = zzbt().elapsedRealtime();
        zzgf().zzakl.set(zzbt().currentTimeMillis());
        long j = elapsedRealtime - this.zzapu;
        if (z || j >= 1000) {
            zzgf().zzakm.set(j);
            zzge().zzit().zzg("Recording user engagement, ms", Long.valueOf(j));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            zzif.zza(zzfy().zzkc(), bundle, true);
            zzfu().logEvent("auto", "_e", bundle);
            this.zzapu = elapsedRealtime;
            this.zzapw.cancel();
            this.zzapw.zzh(Math.max(0L, 3600000 - zzgf().zzakm.get()));
            return true;
        }
        zzge().zzit().zzg("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
        return false;
    }
}
