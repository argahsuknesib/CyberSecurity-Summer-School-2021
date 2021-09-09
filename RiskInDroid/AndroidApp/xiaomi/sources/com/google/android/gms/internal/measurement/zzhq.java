package com.google.android.gms.internal.measurement;

final class zzhq implements Runnable {
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ long zzaoa;

    zzhq(zzhk zzhk, long j) {
        this.zzanw = zzhk;
        this.zzaoa = j;
    }

    public final void run() {
        zzhk zzhk = this.zzanw;
        long j = this.zzaoa;
        zzhk.zzab();
        zzhk.zzch();
        zzhk.zzge().zzis().log("Resetting analytics data (FE)");
        zzhk.zzgc().zzkj();
        if (zzhk.zzgg().zzba(zzhk.zzfv().zzah())) {
            zzhk.zzgf().zzajz.set(j);
        }
        boolean isEnabled = zzhk.zzacw.isEnabled();
        if (!zzhk.zzgg().zzhg()) {
            zzhk.zzgf().zzh(!isEnabled);
        }
        zzhk.zzfx().resetAnalyticsData();
        zzhk.zzanu = !isEnabled;
    }
}
