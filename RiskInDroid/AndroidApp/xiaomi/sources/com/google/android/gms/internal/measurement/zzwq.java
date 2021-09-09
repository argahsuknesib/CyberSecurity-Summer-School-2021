package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class zzwq extends ContentObserver {
    private final /* synthetic */ zzwp zzbnb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzwq(zzwp zzwp, Handler handler) {
        super(null);
        this.zzbnb = zzwp;
    }

    public final void onChange(boolean z) {
        this.zzbnb.zzru();
        this.zzbnb.zzrw();
    }
}
