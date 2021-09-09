package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.api.internal.GooglePlayServicesUpdatedReceiver;

final class zzn extends GooglePlayServicesUpdatedReceiver.Callback {
    private final /* synthetic */ Dialog zzex;
    private final /* synthetic */ zzm zzey;

    zzn(zzm zzm, Dialog dialog) {
        this.zzey = zzm;
        this.zzex = dialog;
    }

    public final void zzv() {
        this.zzey.zzew.zzt();
        if (this.zzex.isShowing()) {
            this.zzex.dismiss();
        }
    }
}
