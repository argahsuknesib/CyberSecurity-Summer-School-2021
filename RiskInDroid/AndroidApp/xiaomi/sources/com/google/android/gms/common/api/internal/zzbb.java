package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GooglePlayServicesUpdatedReceiver;
import java.lang.ref.WeakReference;

final class zzbb extends GooglePlayServicesUpdatedReceiver.Callback {
    private WeakReference<zzav> zziy;

    zzbb(zzav zzav) {
        this.zziy = new WeakReference<>(zzav);
    }

    public final void zzv() {
        zzav zzav = this.zziy.get();
        if (zzav != null) {
            zzav.resume();
        }
    }
}
