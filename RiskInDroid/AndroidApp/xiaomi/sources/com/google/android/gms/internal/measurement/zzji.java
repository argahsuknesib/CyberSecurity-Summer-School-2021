package com.google.android.gms.internal.measurement;

import android.os.Bundle;

final class zzji extends zzem {
    private final /* synthetic */ zzjh zzapx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzji(zzjh zzjh, zzhi zzhi) {
        super(zzhi);
        this.zzapx = zzjh;
    }

    public final void run() {
        zzjh zzjh = this.zzapx;
        zzjh.zzab();
        zzjh.zzge().zzit().zzg("Session started, time", Long.valueOf(zzjh.zzbt().elapsedRealtime()));
        zzjh.zzgf().zzakk.set(false);
        zzjh.zzfu().zza("auto", "_s", new Bundle());
        zzjh.zzgf().zzakl.set(zzjh.zzbt().currentTimeMillis());
    }
}
