package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.zzc;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

final class zzcm implements IBinder.DeathRecipient, zzcn {
    private final WeakReference<BasePendingResult<?>> zzmr;
    private final WeakReference<zzc> zzms;
    private final WeakReference<IBinder> zzmt;

    private zzcm(BasePendingResult<?> basePendingResult, zzc zzc, IBinder iBinder) {
        this.zzms = new WeakReference<>(zzc);
        this.zzmr = new WeakReference<>(basePendingResult);
        this.zzmt = new WeakReference<>(iBinder);
    }

    /* synthetic */ zzcm(BasePendingResult basePendingResult, zzc zzc, IBinder iBinder, zzcl zzcl) {
        this(basePendingResult, null, iBinder);
    }

    private final void zzcf() {
        BasePendingResult basePendingResult = this.zzmr.get();
        zzc zzc = this.zzms.get();
        if (!(zzc == null || basePendingResult == null)) {
            zzc.remove(basePendingResult.zzo().intValue());
        }
        IBinder iBinder = this.zzmt.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    public final void binderDied() {
        zzcf();
    }

    public final void zzc(BasePendingResult<?> basePendingResult) {
        zzcf();
    }
}
