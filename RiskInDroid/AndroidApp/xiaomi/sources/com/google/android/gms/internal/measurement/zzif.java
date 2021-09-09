package com.google.android.gms.internal.measurement;

import _m_j.o0O0OOO0;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

public final class zzif extends zzhh {
    @VisibleForTesting
    protected zzie zzaol;
    private volatile zzie zzaom;
    private zzie zzaon;
    private long zzaoo;
    private final Map<Activity, zzie> zzaop = new o0O0OOO0();
    private zzie zzaoq;
    private String zzaor;

    public zzif(zzgl zzgl) {
        super(zzgl);
    }

    private final void zza(Activity activity, zzie zzie, boolean z) {
        zzie zzie2 = this.zzaom == null ? this.zzaon : this.zzaom;
        if (zzie.zzaoi == null) {
            zzie = new zzie(zzie.zzul, zzca(activity.getClass().getCanonicalName()), zzie.zzaoj);
        }
        this.zzaon = this.zzaom;
        this.zzaoo = zzbt().elapsedRealtime();
        this.zzaom = zzie;
        zzgd().zzc(new zzig(this, z, zzie2, zzie));
    }

    /* access modifiers changed from: private */
    public final void zza(zzie zzie) {
        zzft().zzk(zzbt().elapsedRealtime());
        if (zzgc().zzl(zzie.zzaok)) {
            zzie.zzaok = false;
        }
    }

    public static void zza(zzie zzie, Bundle bundle, boolean z) {
        if (bundle != null && zzie != null && (!bundle.containsKey("_sc") || z)) {
            if (zzie.zzul != null) {
                bundle.putString("_sn", zzie.zzul);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", zzie.zzaoi);
            bundle.putLong("_si", zzie.zzaoj);
        } else if (bundle != null && zzie == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    @VisibleForTesting
    private static String zzca(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    private final zzie zze(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzie zzie = this.zzaop.get(activity);
        if (zzie != null) {
            return zzie;
        }
        zzie zzie2 = new zzie(null, zzca(activity.getClass().getCanonicalName()), zzgb().zzlb());
        this.zzaop.put(activity, zzie2);
        return zzie2;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (bundle != null && (bundle2 = bundle.getBundle("com.google.firebase.analytics.screen_service")) != null) {
            this.zzaop.put(activity, new zzie(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zzaop.remove(activity);
    }

    public final void onActivityPaused(Activity activity) {
        zzie zze = zze(activity);
        this.zzaon = this.zzaom;
        this.zzaoo = zzbt().elapsedRealtime();
        this.zzaom = null;
        zzgd().zzc(new zzih(this, zze));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzif.zza(android.app.Activity, com.google.android.gms.internal.measurement.zzie, boolean):void
     arg types: [android.app.Activity, com.google.android.gms.internal.measurement.zzie, int]
     candidates:
      com.google.android.gms.internal.measurement.zzif.zza(com.google.android.gms.internal.measurement.zzie, android.os.Bundle, boolean):void
      com.google.android.gms.internal.measurement.zzif.zza(android.app.Activity, com.google.android.gms.internal.measurement.zzie, boolean):void */
    public final void onActivityResumed(Activity activity) {
        zza(activity, zze(activity), false);
        zzdu zzft = zzft();
        zzft.zzgd().zzc(new zzdx(zzft, zzft.zzbt().elapsedRealtime()));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzie zzie;
        if (bundle != null && (zzie = this.zzaop.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzie.zzaoj);
            bundle2.putString("name", zzie.zzul);
            bundle2.putString("referrer_name", zzie.zzaoi);
            bundle.putBundle("com.google.firebase.analytics.screen_service", bundle2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzif.zza(android.app.Activity, com.google.android.gms.internal.measurement.zzie, boolean):void
     arg types: [android.app.Activity, com.google.android.gms.internal.measurement.zzie, int]
     candidates:
      com.google.android.gms.internal.measurement.zzif.zza(com.google.android.gms.internal.measurement.zzie, android.os.Bundle, boolean):void
      com.google.android.gms.internal.measurement.zzif.zza(android.app.Activity, com.google.android.gms.internal.measurement.zzie, boolean):void */
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        zzgd();
        if (!zzgg.isMainThread()) {
            zzge().zzip().log("setCurrentScreen must be called from the main thread");
        } else if (this.zzaom == null) {
            zzge().zzip().log("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzaop.get(activity) == null) {
            zzge().zzip().log("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zzca(activity.getClass().getCanonicalName());
            }
            boolean equals = this.zzaom.zzaoi.equals(str2);
            boolean zzs = zzka.zzs(this.zzaom.zzul, str);
            if (equals && zzs) {
                zzge().zziq().log("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzge().zzip().zzg("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzge().zzit().zze("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzie zzie = new zzie(str, str2, zzgb().zzlb());
                this.zzaop.put(activity, zzie);
                zza(activity, zzie, true);
            } else {
                zzge().zzip().zzg("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final void zza(String str, zzie zzie) {
        zzab();
        synchronized (this) {
            if (this.zzaor == null || this.zzaor.equals(str) || zzie != null) {
                this.zzaor = str;
                this.zzaoq = zzie;
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        super.zzfr();
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        super.zzfs();
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        return super.zzft();
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        return super.zzfu();
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        return super.zzfv();
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        return super.zzfw();
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        return super.zzfx();
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        return super.zzfy();
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        return super.zzfz();
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        return super.zzga();
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        return super.zzgb();
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        return super.zzgc();
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        return super.zzgd();
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        return super.zzge();
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        return super.zzgf();
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        return super.zzgg();
    }

    /* access modifiers changed from: protected */
    public final boolean zzhf() {
        return false;
    }

    public final zzie zzkc() {
        zzch();
        zzab();
        return this.zzaol;
    }

    public final zzie zzkd() {
        return this.zzaom;
    }
}
