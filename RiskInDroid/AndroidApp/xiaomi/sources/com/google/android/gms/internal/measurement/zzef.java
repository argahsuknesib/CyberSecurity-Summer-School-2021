package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;

public final class zzef extends zzhg {
    private zzeh zzaet = zzeg.zzaeu;
    private Boolean zzxz;

    zzef(zzgl zzgl) {
        super(zzgl);
    }

    public static long zzhh() {
        return zzew.zzahl.get().longValue();
    }

    public static long zzhi() {
        return zzew.zzagl.get().longValue();
    }

    public static boolean zzhk() {
        return zzew.zzagh.get().booleanValue();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final long zza(String str, zzex<Long> zzex) {
        if (str != null) {
            String zze = this.zzaet.zze(str, zzex.getKey());
            if (!TextUtils.isEmpty(zze)) {
                try {
                    return zzex.get(Long.valueOf(Long.parseLong(zze))).longValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return zzex.get().longValue();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzeh zzeh) {
        this.zzaet = zzeh;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    public final int zzar(String str) {
        return zzb(str, zzew.zzagw);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final Boolean zzas(String str) {
        Preconditions.checkNotEmpty(str);
        try {
            if (getContext().getPackageManager() == null) {
                zzge().zzim().log("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(getContext().getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY);
            if (applicationInfo == null) {
                zzge().zzim().log("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (applicationInfo.metaData == null) {
                zzge().zzim().log("Failed to load metadata: Metadata bundle is null");
                return null;
            } else if (!applicationInfo.metaData.containsKey(str)) {
                return null;
            } else {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
            }
        } catch (PackageManager.NameNotFoundException e) {
            zzge().zzim().zzg("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final boolean zzat(String str) {
        return "1".equals(this.zzaet.zze(str, "gaia_collection_enabled"));
    }

    public final boolean zzau(String str) {
        return "1".equals(this.zzaet.zze(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzav(String str) {
        return zzd(str, zzew.zzahu);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaw(String str) {
        return zzd(str, zzew.zzahw);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzax(String str) {
        return zzd(str, zzew.zzahx);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzay(String str) {
        return zzd(str, zzew.zzahy);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaz(String str) {
        return zzd(str, zzew.zzahz);
    }

    public final int zzb(String str, zzex<Integer> zzex) {
        if (str != null) {
            String zze = this.zzaet.zze(str, zzex.getKey());
            if (!TextUtils.isEmpty(zze)) {
                try {
                    return zzex.get(Integer.valueOf(Integer.parseInt(zze))).intValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return zzex.get().intValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzba(String str) {
        return zzd(str, zzew.zzaic);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    public final double zzc(String str, zzex<Double> zzex) {
        if (str != null) {
            String zze = this.zzaet.zze(str, zzex.getKey());
            if (!TextUtils.isEmpty(zze)) {
                try {
                    return zzex.get(Double.valueOf(Double.parseDouble(zze))).doubleValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return zzex.get().doubleValue();
    }

    public final boolean zzd(String str, zzex<Boolean> zzex) {
        Boolean bool;
        if (str != null) {
            String zze = this.zzaet.zze(str, zzex.getKey());
            if (!TextUtils.isEmpty(zze)) {
                bool = zzex.get(Boolean.valueOf(Boolean.parseBoolean(zze)));
                return bool.booleanValue();
            }
        }
        bool = zzex.get();
        return bool.booleanValue();
    }

    public final boolean zzds() {
        if (this.zzxz == null) {
            synchronized (this) {
                if (this.zzxz == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzxz = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzxz == null) {
                        this.zzxz = Boolean.TRUE;
                        zzge().zzim().log("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzxz.booleanValue();
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

    public final boolean zzhg() {
        Boolean zzas = zzas("firebase_analytics_collection_deactivated");
        return zzas != null && zzas.booleanValue();
    }

    public final String zzhj() {
        String str;
        zzfi zzfi;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "debug.firebase.analytics.app", "");
        } catch (ClassNotFoundException e) {
            e = e;
            zzfi = zzge().zzim();
            str = "Could not find SystemProperties class";
            zzfi.zzg(str, e);
            return "";
        } catch (NoSuchMethodException e2) {
            e = e2;
            zzfi = zzge().zzim();
            str = "Could not find SystemProperties.get() method";
            zzfi.zzg(str, e);
            return "";
        } catch (IllegalAccessException e3) {
            e = e3;
            zzfi = zzge().zzim();
            str = "Could not access SystemProperties.get()";
            zzfi.zzg(str, e);
            return "";
        } catch (InvocationTargetException e4) {
            e = e4;
            zzfi = zzge().zzim();
            str = "SystemProperties.get() threw an exception";
            zzfi.zzg(str, e);
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzhl() {
        return zzd(zzfv().zzah(), zzew.zzahp);
    }

    /* access modifiers changed from: package-private */
    public final String zzhm() {
        String zzah = zzfv().zzah();
        zzex<String> zzex = zzew.zzahq;
        return zzah == null ? zzex.get() : zzex.get(this.zzaet.zze(zzah, zzex.getKey()));
    }
}
