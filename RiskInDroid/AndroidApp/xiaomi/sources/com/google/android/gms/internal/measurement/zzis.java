package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class zzis implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzani;
    private final /* synthetic */ String zzanj;
    private final /* synthetic */ zzii zzape;
    private final /* synthetic */ AtomicReference zzapf;

    zzis(zzii zzii, AtomicReference atomicReference, String str, String str2, String str3, zzdz zzdz) {
        this.zzape = zzii;
        this.zzapf = atomicReference;
        this.zzanj = str;
        this.zzanh = str2;
        this.zzani = str3;
        this.zzane = zzdz;
    }

    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        List<zzed> zze;
        synchronized (this.zzapf) {
            try {
                zzey zzd = this.zzape.zzaoy;
                if (zzd == null) {
                    this.zzape.zzge().zzim().zzd("Failed to get conditional properties", zzfg.zzbm(this.zzanj), this.zzanh, this.zzani);
                    this.zzapf.set(Collections.emptyList());
                    this.zzapf.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.zzanj)) {
                    atomicReference2 = this.zzapf;
                    zze = zzd.zza(this.zzanh, this.zzani, this.zzane);
                } else {
                    atomicReference2 = this.zzapf;
                    zze = zzd.zze(this.zzanj, this.zzanh, this.zzani);
                }
                atomicReference2.set(zze);
                this.zzape.zzcu();
                atomicReference = this.zzapf;
                atomicReference.notify();
            } catch (RemoteException e) {
                try {
                    this.zzape.zzge().zzim().zzd("Failed to get conditional properties", zzfg.zzbm(this.zzanj), this.zzanh, e);
                    this.zzapf.set(Collections.emptyList());
                    atomicReference = this.zzapf;
                } catch (Throwable th) {
                    this.zzapf.notify();
                    throw th;
                }
            }
        }
    }
}
