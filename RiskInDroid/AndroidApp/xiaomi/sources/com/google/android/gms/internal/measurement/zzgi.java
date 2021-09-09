package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

final class zzgi implements Thread.UncaughtExceptionHandler {
    private final String zzaly;
    private final /* synthetic */ zzgg zzalz;

    public zzgi(zzgg zzgg, String str) {
        this.zzalz = zzgg;
        Preconditions.checkNotNull(str);
        this.zzaly = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zzalz.zzge().zzim().zzg(this.zzaly, th);
    }
}
