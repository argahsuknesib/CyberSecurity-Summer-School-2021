package com.google.android.gms.internal.measurement;

final class zziu implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzjx zzanl;
    private final /* synthetic */ zzii zzape;
    private final /* synthetic */ boolean zzaph;

    zziu(zzii zzii, boolean z, zzjx zzjx, zzdz zzdz) {
        this.zzape = zzii;
        this.zzaph = z;
        this.zzanl = zzjx;
        this.zzane = zzdz;
    }

    public final void run() {
        zzey zzd = this.zzape.zzaoy;
        if (zzd == null) {
            this.zzape.zzge().zzim().log("Discarding data. Failed to set user attribute");
            return;
        }
        this.zzape.zza(zzd, this.zzaph ? null : this.zzanl, this.zzane);
        this.zzape.zzcu();
    }
}
