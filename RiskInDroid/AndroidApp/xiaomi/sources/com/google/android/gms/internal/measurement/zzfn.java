package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

final class zzfn implements Runnable {
    private final String packageName;
    private final int status;
    private final zzfm zzajh;
    private final Throwable zzaji;
    private final byte[] zzajj;
    private final Map<String, List<String>> zzajk;

    private zzfn(String str, zzfm zzfm, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        Preconditions.checkNotNull(zzfm);
        this.zzajh = zzfm;
        this.status = i;
        this.zzaji = th;
        this.zzajj = bArr;
        this.packageName = str;
        this.zzajk = map;
    }

    public final void run() {
        this.zzajh.zza(this.packageName, this.status, this.zzaji, this.zzajj, this.zzajk);
    }
}
