package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public final class zzgn extends zzez {
    /* access modifiers changed from: private */
    public final zzjr zzajp;
    private Boolean zzanc;
    private String zzand;

    public zzgn(zzjr zzjr) {
        this(zzjr, null);
    }

    private zzgn(zzjr zzjr, String str) {
        Preconditions.checkNotNull(zzjr);
        this.zzajp = zzjr;
        this.zzand = null;
    }

    private final void zzb(zzdz zzdz, boolean z) {
        Preconditions.checkNotNull(zzdz);
        zzc(zzdz.packageName, false);
        this.zzajp.zzgb().zzcg(zzdz.zzadm);
    }

    private final void zzc(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzanc == null) {
                        if (!"com.google.android.gms".equals(this.zzand) && !UidVerifier.isGooglePlayServicesUid(this.zzajp.getContext(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zzajp.getContext()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.zzanc = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.zzanc = Boolean.valueOf(z2);
                    }
                    if (this.zzanc.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zzajp.zzge().zzim().zzg("Measurement Service called with invalid calling package. appId", zzfg.zzbm(str));
                    throw e;
                }
            }
            if (this.zzand == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zzajp.getContext(), Binder.getCallingUid(), str)) {
                this.zzand = str;
            }
            if (!str.equals(this.zzand)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
            }
            return;
        }
        this.zzajp.zzge().zzim().log("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    @VisibleForTesting
    private final void zze(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (!zzew.zzaia.get().booleanValue() || !this.zzajp.zzgd().zzjk()) {
            this.zzajp.zzgd().zzc(runnable);
        } else {
            runnable.run();
        }
    }

    public final List<zzjx> zza(zzdz zzdz, boolean z) {
        zzb(zzdz, false);
        try {
            List<zzjz> list = (List) this.zzajp.zzgd().zzb(new zzhd(this, zzdz)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzjz zzjz : list) {
                if (z || !zzka.zzci(zzjz.name)) {
                    arrayList.add(new zzjx(zzjz));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzajp.zzge().zzim().zze("Failed to get user attributes. appId", zzfg.zzbm(zzdz.packageName), e);
            return null;
        }
    }

    public final List<zzed> zza(String str, String str2, zzdz zzdz) {
        zzb(zzdz, false);
        try {
            return (List) this.zzajp.zzgd().zzb(new zzgv(this, zzdz, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zzajp.zzge().zzim().zzg("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    public final List<zzjx> zza(String str, String str2, String str3, boolean z) {
        zzc(str, true);
        try {
            List<zzjz> list = (List) this.zzajp.zzgd().zzb(new zzgu(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzjz zzjz : list) {
                if (z || !zzka.zzci(zzjz.name)) {
                    arrayList.add(new zzjx(zzjz));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzajp.zzge().zzim().zze("Failed to get user attributes. appId", zzfg.zzbm(str), e);
            return Collections.emptyList();
        }
    }

    public final List<zzjx> zza(String str, String str2, boolean z, zzdz zzdz) {
        zzb(zzdz, false);
        try {
            List<zzjz> list = (List) this.zzajp.zzgd().zzb(new zzgt(this, zzdz, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzjz zzjz : list) {
                if (z || !zzka.zzci(zzjz.name)) {
                    arrayList.add(new zzjx(zzjz));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzajp.zzge().zzim().zze("Failed to get user attributes. appId", zzfg.zzbm(zzdz.packageName), e);
            return Collections.emptyList();
        }
    }

    public final void zza(long j, String str, String str2, String str3) {
        zze(new zzhf(this, str2, str3, str, j));
    }

    public final void zza(zzdz zzdz) {
        zzb(zzdz, false);
        zze(new zzhe(this, zzdz));
    }

    public final void zza(zzed zzed, zzdz zzdz) {
        Preconditions.checkNotNull(zzed);
        Preconditions.checkNotNull(zzed.zzaep);
        zzb(zzdz, false);
        zzed zzed2 = new zzed(zzed);
        zzed2.packageName = zzdz.packageName;
        zze(zzed.zzaep.getValue() == null ? new zzgp(this, zzed2, zzdz) : new zzgq(this, zzed2, zzdz));
    }

    public final void zza(zzeu zzeu, zzdz zzdz) {
        Preconditions.checkNotNull(zzeu);
        zzb(zzdz, false);
        zze(new zzgy(this, zzeu, zzdz));
    }

    public final void zza(zzeu zzeu, String str, String str2) {
        Preconditions.checkNotNull(zzeu);
        Preconditions.checkNotEmpty(str);
        zzc(str, true);
        zze(new zzgz(this, zzeu, str));
    }

    public final void zza(zzjx zzjx, zzdz zzdz) {
        Preconditions.checkNotNull(zzjx);
        zzb(zzdz, false);
        zze(zzjx.getValue() == null ? new zzhb(this, zzjx, zzdz) : new zzhc(this, zzjx, zzdz));
    }

    public final byte[] zza(zzeu zzeu, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeu);
        zzc(str, true);
        this.zzajp.zzge().zzis().zzg("Log and bundle. event", this.zzajp.zzga().zzbj(zzeu.name));
        long nanoTime = this.zzajp.zzbt().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zzajp.zzgd().zzc(new zzha(this, zzeu, str)).get();
            if (bArr == null) {
                this.zzajp.zzge().zzim().zzg("Log and bundle returned null. appId", zzfg.zzbm(str));
                bArr = new byte[0];
            }
            this.zzajp.zzge().zzis().zzd("Log and bundle processed. event, size, time_ms", this.zzajp.zzga().zzbj(zzeu.name), Integer.valueOf(bArr.length), Long.valueOf((this.zzajp.zzbt().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zzajp.zzge().zzim().zzd("Failed to log and bundle. appId, event, error", zzfg.zzbm(str), this.zzajp.zzga().zzbj(zzeu.name), e);
            return null;
        }
    }

    public final void zzb(zzdz zzdz) {
        zzb(zzdz, false);
        zze(new zzgo(this, zzdz));
    }

    public final void zzb(zzed zzed) {
        Preconditions.checkNotNull(zzed);
        Preconditions.checkNotNull(zzed.zzaep);
        zzc(zzed.packageName, true);
        zzed zzed2 = new zzed(zzed);
        zze(zzed.zzaep.getValue() == null ? new zzgr(this, zzed2) : new zzgs(this, zzed2));
    }

    public final String zzc(zzdz zzdz) {
        zzb(zzdz, false);
        return this.zzajp.zzh(zzdz);
    }

    public final void zzd(zzdz zzdz) {
        zzc(zzdz.packageName, false);
        zze(new zzgx(this, zzdz));
    }

    public final List<zzed> zze(String str, String str2, String str3) {
        zzc(str, true);
        try {
            return (List) this.zzajp.zzgd().zzb(new zzgw(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zzajp.zzge().zzim().zzg("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }
}
