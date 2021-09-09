package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;

final class zzgt implements Callable<List<zzjz>> {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzani;

    zzgt(zzgn zzgn, zzdz zzdz, String str, String str2) {
        this.zzanf = zzgn;
        this.zzane = zzdz;
        this.zzanh = str;
        this.zzani = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzanf.zzajp.zzkx();
        return this.zzanf.zzajp.zzix().zzb(this.zzane.packageName, this.zzanh, this.zzani);
    }
}
