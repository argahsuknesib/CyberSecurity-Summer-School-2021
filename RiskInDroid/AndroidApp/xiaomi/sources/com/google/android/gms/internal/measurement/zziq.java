package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;

final class zziq implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ String zzanj;
    private final /* synthetic */ zzeu zzank;
    private final /* synthetic */ zzii zzape;
    private final /* synthetic */ boolean zzapg = true;
    private final /* synthetic */ boolean zzaph;

    zziq(zzii zzii, boolean z, boolean z2, zzeu zzeu, zzdz zzdz, String str) {
        this.zzape = zzii;
        this.zzaph = z2;
        this.zzank = zzeu;
        this.zzane = zzdz;
        this.zzanj = str;
    }

    public final void run() {
        zzey zzd = this.zzape.zzaoy;
        if (zzd == null) {
            this.zzape.zzge().zzim().log("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zzapg) {
            this.zzape.zza(zzd, this.zzaph ? null : this.zzank, this.zzane);
        } else {
            try {
                if (TextUtils.isEmpty(this.zzanj)) {
                    zzd.zza(this.zzank, this.zzane);
                } else {
                    zzd.zza(this.zzank, this.zzanj, this.zzape.zzge().zziv());
                }
            } catch (RemoteException e) {
                this.zzape.zzge().zzim().zzg("Failed to send event to the service", e);
            }
        }
        this.zzape.zzcu();
    }
}
