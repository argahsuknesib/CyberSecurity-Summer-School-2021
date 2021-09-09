package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

final class zzfr extends zzhh {
    @VisibleForTesting
    static final Pair<String, Long> zzajs = new Pair<>("", 0L);
    private SharedPreferences zzabf;
    public zzfv zzajt;
    public final zzfu zzaju = new zzfu(this, "last_upload", 0);
    public final zzfu zzajv = new zzfu(this, "last_upload_attempt", 0);
    public final zzfu zzajw = new zzfu(this, "backoff", 0);
    public final zzfu zzajx = new zzfu(this, "last_delete_stale", 0);
    public final zzfu zzajy = new zzfu(this, "midnight_offset", 0);
    public final zzfu zzajz = new zzfu(this, "first_open_time", 0);
    public final zzfu zzaka = new zzfu(this, "app_install_time", 0);
    public final zzfw zzakb = new zzfw(this, "app_instance_id", null);
    private String zzakc;
    private boolean zzakd;
    private long zzake;
    private String zzakf;
    private long zzakg;
    private final Object zzakh = new Object();
    public final zzfu zzaki = new zzfu(this, "time_before_start", 10000);
    public final zzfu zzakj = new zzfu(this, "session_timeout", 1800000);
    public final zzft zzakk = new zzft(this, "start_new_session", true);
    public final zzfu zzakl = new zzfu(this, "last_pause_time", 0);
    public final zzfu zzakm = new zzfu(this, "time_active", 0);
    public boolean zzakn;

    zzfr(zzgl zzgl) {
        super(zzgl);
    }

    /* access modifiers changed from: private */
    public final SharedPreferences zziy() {
        zzab();
        zzch();
        return this.zzabf;
    }

    /* access modifiers changed from: package-private */
    public final void setMeasurementEnabled(boolean z) {
        zzab();
        zzge().zzit().zzg("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zziy().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final Pair<String, Boolean> zzbo(String str) {
        zzab();
        long elapsedRealtime = zzbt().elapsedRealtime();
        String str2 = this.zzakc;
        if (str2 != null && elapsedRealtime < this.zzake) {
            return new Pair<>(str2, Boolean.valueOf(this.zzakd));
        }
        this.zzake = elapsedRealtime + zzgg().zza(str, zzew.zzagj);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            if (advertisingIdInfo != null) {
                this.zzakc = advertisingIdInfo.getId();
                this.zzakd = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzakc == null) {
                this.zzakc = "";
            }
        } catch (Exception e) {
            zzge().zzis().zzg("Unable to get advertising id", e);
            this.zzakc = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzakc, Boolean.valueOf(this.zzakd));
    }

    /* access modifiers changed from: package-private */
    public final String zzbp(String str) {
        zzab();
        String str2 = (String) zzbo(str).first;
        MessageDigest messageDigest = zzka.getMessageDigest("MD5");
        if (messageDigest == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest(str2.getBytes())));
    }

    /* access modifiers changed from: package-private */
    public final void zzbq(String str) {
        zzab();
        SharedPreferences.Editor edit = zziy().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void zzbr(String str) {
        synchronized (this.zzakh) {
            this.zzakf = str;
            this.zzakg = zzbt().elapsedRealtime();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(boolean z) {
        zzab();
        zzge().zzit().zzg("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zziy().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg(boolean z) {
        zzab();
        return zziy().getBoolean("measurement_enabled", z);
    }

    /* access modifiers changed from: package-private */
    public final void zzh(boolean z) {
        zzab();
        zzge().zzit().zzg("Updating deferred analytics collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zziy().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public final boolean zzhf() {
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    /* access modifiers changed from: protected */
    public final void zzih() {
        this.zzabf = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzakn = this.zzabf.getBoolean("has_been_opened", false);
        if (!this.zzakn) {
            SharedPreferences.Editor edit = this.zzabf.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzajt = new zzfv(this, "health_monitor", Math.max(0L, zzew.zzagk.get().longValue()));
    }

    /* access modifiers changed from: package-private */
    public final String zziz() {
        zzab();
        return zziy().getString("gmp_app_id", null);
    }

    /* access modifiers changed from: package-private */
    public final String zzja() {
        synchronized (this.zzakh) {
            if (Math.abs(zzbt().elapsedRealtime() - this.zzakg) >= 1000) {
                return null;
            }
            String str = this.zzakf;
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzjb() {
        zzab();
        if (!zziy().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zziy().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    public final void zzjc() {
        zzab();
        zzge().zzit().log("Clearing collection preferences.");
        boolean contains = zziy().contains("measurement_enabled");
        boolean z = true;
        if (contains) {
            z = zzg(true);
        }
        SharedPreferences.Editor edit = zziy().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            setMeasurementEnabled(z);
        }
    }

    /* access modifiers changed from: protected */
    public final String zzjd() {
        zzab();
        String string = zziy().getString("previous_os_version", null);
        zzfw().zzch();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zziy().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzje() {
        zzab();
        return zziy().getBoolean("deferred_analytics_collection", false);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzjf() {
        return this.zzabf.contains("deferred_analytics_collection");
    }
}
