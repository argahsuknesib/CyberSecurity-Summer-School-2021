package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class zzip implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzii zzape;

    zzip(zzii zzii, zzdz zzdz) {
        this.zzape = zzii;
        this.zzane = zzdz;
    }

    public final void run() {
        zzey zzd = this.zzape.zzaoy;
        if (zzd == null) {
            this.zzape.zzge().zzim().log("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzd.zzb(this.zzane);
            this.zzape.zzcu();
        } catch (RemoteException e) {
            this.zzape.zzge().zzim().zzg("Failed to send measurementEnabled to the service", e);
        }
    }
}
