package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;

final class zzhd implements Callable<List<zzjz>> {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;

    zzhd(zzgn zzgn, zzdz zzdz) {
        this.zzanf = zzgn;
        this.zzane = zzdz;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzanf.zzajp.zzkx();
        return this.zzanf.zzajp.zzix().zzbb(this.zzane.packageName);
    }
}
