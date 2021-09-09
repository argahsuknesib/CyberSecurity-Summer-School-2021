package com.google.android.gms.internal.measurement;

import _m_j.o0O0OOO0;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzjr implements zzec {
    private zzgl zzacw;
    zzgf zzaqa;
    zzfk zzaqb;
    private zzei zzaqc;
    private zzfp zzaqd;
    private zzjn zzaqe;
    private zzeb zzaqf;
    private boolean zzaqg;
    @VisibleForTesting
    private long zzaqh;
    private List<Runnable> zzaqi;
    private int zzaqj;
    private int zzaqk;
    private boolean zzaql;
    private boolean zzaqm;
    private boolean zzaqn;
    private FileLock zzaqo;
    private FileChannel zzaqp;
    private List<Long> zzaqq;
    private List<Long> zzaqr;
    long zzaqs;
    private boolean zzvo = false;

    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        zzab();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzge().zzim().log("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    zzge().zzip().zzg("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            zzge().zzim().zzg("Failed to read from channel", e);
            return 0;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzdz.<init>(java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, java.lang.String, boolean, boolean, java.lang.String, long, long, int, boolean, boolean, boolean):void
     arg types: [java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, int, long, ?[OBJECT, ARRAY], boolean, int, java.lang.String, int, long, int, boolean, boolean, int]
     candidates:
      com.google.android.gms.internal.measurement.zzdz.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, boolean, boolean, long, java.lang.String, long, long, int, boolean, boolean, boolean):void
      com.google.android.gms.internal.measurement.zzdz.<init>(java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, java.lang.String, boolean, boolean, java.lang.String, long, long, int, boolean, boolean, boolean):void */
    private final zzdz zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j) {
        String str3;
        String str4;
        int i;
        String str5 = str;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            zzge().zzim().log("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str3 = packageManager.getInstallerPackageName(str5);
        } catch (IllegalArgumentException unused) {
            zzge().zzim().zzg("Error retrieving installer package name. appId", zzfg.zzbm(str));
            str3 = "Unknown";
        }
        if (str3 == null) {
            str3 = "manual_install";
        } else if ("com.android.vending".equals(str3)) {
            str3 = "";
        }
        String str6 = str3;
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str5, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str5);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    String charSequence = applicationLabel.toString();
                }
                String str7 = packageInfo.versionName;
                i = packageInfo.versionCode;
                str4 = str7;
            } else {
                i = Integer.MIN_VALUE;
                str4 = "Unknown";
            }
            return new zzdz(str, str2, str4, (long) i, str6, 12451L, zzgb().zzd(context, str5), (String) null, z, false, "", 0L, zzgg().zzba(str5) ? j : 0, 0, z2, z3, false);
        } catch (PackageManager.NameNotFoundException unused2) {
            zzge().zzim().zze("Error retrieving newly installed package info. appId, appName", zzfg.zzbm(str), "Unknown");
            return null;
        }
    }

    private static void zza(zzjq zzjq) {
        if (zzjq == null) {
            throw new IllegalStateException("Upload component not created");
        } else if (!zzjq.isInitialized()) {
            String valueOf = String.valueOf(zzjq.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        zzab();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzge().zzim().log("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                zzge().zzim().zzg("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            zzge().zzim().zzg("Failed to write to channel", e);
            return false;
        }
    }

    private final boolean zza(String str, zzeu zzeu) {
        long j;
        zzjz zzjz;
        String string = zzeu.zzafq.getString("currency");
        if ("ecommerce_purchase".equals(zzeu.name)) {
            double doubleValue = zzeu.zzafq.zzbh("value").doubleValue() * 1000000.0d;
            if (doubleValue == 0.0d) {
                double longValue = (double) zzeu.zzafq.getLong("value").longValue();
                Double.isNaN(longValue);
                doubleValue = longValue * 1000000.0d;
            }
            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                zzge().zzip().zze("Data lost. Currency value is too big. appId", zzfg.zzbm(str), Double.valueOf(doubleValue));
                return false;
            }
            j = Math.round(doubleValue);
        } else {
            j = zzeu.zzafq.getLong("value").longValue();
        }
        if (!TextUtils.isEmpty(string)) {
            String upperCase = string.toUpperCase(Locale.US);
            if (upperCase.matches("[A-Z]{3}")) {
                String valueOf = String.valueOf(upperCase);
                String concat = valueOf.length() != 0 ? "_ltv_".concat(valueOf) : new String("_ltv_");
                zzjz zzh = zzix().zzh(str, concat);
                if (zzh == null || !(zzh.value instanceof Long)) {
                    zzei zzix = zzix();
                    int zzb = zzgg().zzb(str, zzew.zzahm) - 1;
                    Preconditions.checkNotEmpty(str);
                    zzix.zzab();
                    zzix.zzch();
                    try {
                        zzix.getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(zzb)});
                    } catch (SQLiteException e) {
                        zzix.zzge().zzim().zze("Error pruning currencies. appId", zzfg.zzbm(str), e);
                    }
                    zzjz = new zzjz(str, zzeu.origin, concat, zzbt().currentTimeMillis(), Long.valueOf(j));
                } else {
                    zzjz = new zzjz(str, zzeu.origin, concat, zzbt().currentTimeMillis(), Long.valueOf(((Long) zzh.value).longValue() + j));
                }
                if (!zzix().zza(zzjz)) {
                    zzge().zzim().zzd("Too many unique user properties are set. Ignoring user property. appId", zzfg.zzbm(str), zzga().zzbl(zzjz.name), zzjz.value);
                    zzgb().zza(str, 9, (String) null, (String) null, 0);
                }
            }
        }
        return true;
    }

    private final zzkm[] zza(String str, zzks[] zzksArr, zzkn[] zzknArr) {
        Preconditions.checkNotEmpty(str);
        return zziw().zza(str, zzknArr, zzksArr);
    }

    private final void zzb(zzdy zzdy) {
        o0O0OOO0 o0o0ooo0;
        zzab();
        if (TextUtils.isEmpty(zzdy.getGmpAppId())) {
            zzb(zzdy.zzah(), 204, null, null, null);
            return;
        }
        String gmpAppId = zzdy.getGmpAppId();
        String appInstanceId = zzdy.getAppInstanceId();
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder encodedAuthority = builder.scheme(zzew.zzagm.get()).encodedAuthority(zzew.zzagn.get());
        String valueOf = String.valueOf(gmpAppId);
        encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", appInstanceId).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "12451");
        String uri = builder.build().toString();
        try {
            URL url = new URL(uri);
            zzge().zzit().zzg("Fetching remote configuration", zzdy.zzah());
            zzkk zzbu = zzkm().zzbu(zzdy.zzah());
            String zzbv = zzkm().zzbv(zzdy.zzah());
            if (zzbu == null || TextUtils.isEmpty(zzbv)) {
                o0o0ooo0 = null;
            } else {
                o0O0OOO0 o0o0ooo02 = new o0O0OOO0();
                o0o0ooo02.put("If-Modified-Since", zzbv);
                o0o0ooo0 = o0o0ooo02;
            }
            this.zzaql = true;
            zzfk zzkn = zzkn();
            String zzah = zzdy.zzah();
            zzjt zzjt = new zzjt(this);
            zzkn.zzab();
            zzkn.zzch();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzjt);
            zzkn.zzgd().zzd(new zzfo(zzkn, zzah, url, null, o0o0ooo0, zzjt));
        } catch (MalformedURLException unused) {
            zzge().zzim().zze("Failed to parse config URL. Not fetching. appId", zzfg.zzbm(zzdy.zzah()), uri);
        }
    }

    private final Boolean zzc(zzdy zzdy) {
        try {
            if (zzdy.zzgm() != -2147483648L) {
                if (zzdy.zzgm() == ((long) Wrappers.packageManager(getContext()).getPackageInfo(zzdy.zzah(), 0).versionCode)) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(getContext()).getPackageInfo(zzdy.zzah(), 0).versionName;
                if (zzdy.zzag() != null && zzdy.zzag().equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzka.zza(android.os.Bundle, java.lang.String, java.lang.Object):void
     arg types: [android.os.Bundle, java.lang.String, long]
     candidates:
      com.google.android.gms.internal.measurement.zzka.zza(int, java.lang.Object, boolean):java.lang.Object
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, boolean):java.lang.String
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String[]):java.lang.String
      com.google.android.gms.internal.measurement.zzka.zza(com.google.android.gms.internal.measurement.zzko[], java.lang.String, java.lang.Object):com.google.android.gms.internal.measurement.zzko[]
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(android.os.Bundle, java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0547, code lost:
        r2 = true;
     */
    private final void zzc(zzeu zzeu, zzdz zzdz) {
        zzeq zzeq;
        zzkq zzkq;
        zzdy zzbc;
        zzeu zzeu2 = zzeu;
        zzdz zzdz2 = zzdz;
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz2.packageName);
        long nanoTime = System.nanoTime();
        zzab();
        zzkq();
        String str = zzdz2.packageName;
        zzgb();
        if (zzka.zzd(zzeu, zzdz)) {
            if (!zzdz2.zzadw) {
                zzg(zzdz2);
            } else if (zzkm().zzn(str, zzeu2.name)) {
                zzge().zzip().zze("Dropping blacklisted event. appId", zzfg.zzbm(str), zzga().zzbj(zzeu2.name));
                boolean z = zzkm().zzby(str) || zzkm().zzbz(str);
                if (!z && !"_err".equals(zzeu2.name)) {
                    zzgb().zza(str, 11, "_ev", zzeu2.name, 0);
                }
                if (z && (zzbc = zzix().zzbc(str)) != null) {
                    if (Math.abs(zzbt().currentTimeMillis() - Math.max(zzbc.zzgs(), zzbc.zzgr())) > zzew.zzahh.get().longValue()) {
                        zzge().zzis().log("Fetching config for blacklisted app");
                        zzb(zzbc);
                    }
                }
            } else {
                if (zzge().isLoggable(2)) {
                    zzge().zzit().zzg("Logging event", zzga().zzb(zzeu2));
                }
                zzix().beginTransaction();
                zzg(zzdz2);
                if (("_iap".equals(zzeu2.name) || "ecommerce_purchase".equals(zzeu2.name)) && !zza(str, zzeu2)) {
                    zzix().setTransactionSuccessful();
                    zzix().endTransaction();
                    return;
                }
                try {
                    boolean zzcc = zzka.zzcc(zzeu2.name);
                    boolean equals = "_err".equals(zzeu2.name);
                    zzej zza = zzix().zza(zzkr(), str, true, zzcc, false, equals, false);
                    long intValue = zza.zzafe - ((long) zzew.zzags.get().intValue());
                    if (intValue > 0) {
                        if (intValue % 1000 == 1) {
                            zzge().zzim().zze("Data loss. Too many events logged. appId, count", zzfg.zzbm(str), Long.valueOf(zza.zzafe));
                        }
                        zzix().setTransactionSuccessful();
                        zzix().endTransaction();
                        return;
                    }
                    if (zzcc) {
                        long intValue2 = zza.zzafd - ((long) zzew.zzagu.get().intValue());
                        if (intValue2 > 0) {
                            if (intValue2 % 1000 == 1) {
                                zzge().zzim().zze("Data loss. Too many public events logged. appId, count", zzfg.zzbm(str), Long.valueOf(zza.zzafd));
                            }
                            zzgb().zza(str, 16, "_ev", zzeu2.name, 0);
                            zzix().setTransactionSuccessful();
                            zzix().endTransaction();
                            return;
                        }
                    }
                    if (equals) {
                        long max = zza.zzafg - ((long) Math.max(0, Math.min(1000000, zzgg().zzb(zzdz2.packageName, zzew.zzagt))));
                        if (max > 0) {
                            if (max == 1) {
                                zzge().zzim().zze("Too many error events logged. appId, count", zzfg.zzbm(str), Long.valueOf(zza.zzafg));
                            }
                            zzix().setTransactionSuccessful();
                            zzix().endTransaction();
                            return;
                        }
                    }
                    Bundle zzif = zzeu2.zzafq.zzif();
                    zzgb().zza(zzif, "_o", zzeu2.origin);
                    if (zzgb().zzcj(str)) {
                        zzgb().zza(zzif, "_dbg", (Object) 1L);
                        zzgb().zza(zzif, "_r", (Object) 1L);
                    }
                    long zzbd = zzix().zzbd(str);
                    if (zzbd > 0) {
                        zzge().zzip().zze("Data lost. Too many events stored on disk, deleted. appId", zzfg.zzbm(str), Long.valueOf(zzbd));
                    }
                    long j = nanoTime;
                    zzep zzep = r5;
                    String str2 = "_r";
                    zzep zzep2 = new zzep(this.zzacw, zzeu2.origin, str, zzeu2.name, zzeu2.zzagb, 0, zzif);
                    zzeq zzf = zzix().zzf(str, zzep.name);
                    if (zzf != null) {
                        zzep zza2 = zzep.zza(this.zzacw, zzf.zzaft);
                        zzeq = zzf.zzac(zza2.timestamp);
                        zzep = zza2;
                    } else if (zzix().zzbg(str) < 500 || !zzcc) {
                        zzeq = new zzeq(str, zzep.name, 0, 0, zzep.timestamp, 0, null, null, null);
                    } else {
                        zzge().zzim().zzd("Too many event names used, ignoring event. appId, name, supported count", zzfg.zzbm(str), zzga().zzbj(zzep.name), 500);
                        zzgb().zza(str, 8, (String) null, (String) null, 0);
                        zzix().endTransaction();
                        return;
                    }
                    zzix().zza(zzeq);
                    zzab();
                    zzkq();
                    Preconditions.checkNotNull(zzep);
                    Preconditions.checkNotNull(zzdz);
                    Preconditions.checkNotEmpty(zzep.zzti);
                    Preconditions.checkArgument(zzep.zzti.equals(zzdz2.packageName));
                    zzkq = new zzkq();
                    zzkq.zzath = 1;
                    zzkq.zzatp = "android";
                    zzkq.zzti = zzdz2.packageName;
                    zzkq.zzadt = zzdz2.zzadt;
                    zzkq.zzth = zzdz2.zzth;
                    zzkq.zzaub = zzdz2.zzads == -2147483648L ? null : Integer.valueOf((int) zzdz2.zzads);
                    zzkq.zzatt = Long.valueOf(zzdz2.zzadu);
                    zzkq.zzadm = zzdz2.zzadm;
                    zzkq.zzatx = zzdz2.zzadv == 0 ? null : Long.valueOf(zzdz2.zzadv);
                    Pair<String, Boolean> zzbo = zzgf().zzbo(zzdz2.packageName);
                    if (zzbo == null || TextUtils.isEmpty((CharSequence) zzbo.first)) {
                        if (!zzfw().zzf(getContext()) && zzdz2.zzadz) {
                            String string = Settings.Secure.getString(getContext().getContentResolver(), "android_id");
                            if (string == null) {
                                zzge().zzip().zzg("null secure ID. appId", zzfg.zzbm(zzkq.zzti));
                                string = "null";
                            } else if (string.isEmpty()) {
                                zzge().zzip().zzg("empty secure ID. appId", zzfg.zzbm(zzkq.zzti));
                            }
                            zzkq.zzaue = string;
                        }
                    } else if (zzdz2.zzady) {
                        zzkq.zzatv = (String) zzbo.first;
                        zzkq.zzatw = (Boolean) zzbo.second;
                    }
                    zzfw().zzch();
                    zzkq.zzatr = Build.MODEL;
                    zzfw().zzch();
                    zzkq.zzatq = Build.VERSION.RELEASE;
                    zzkq.zzats = Integer.valueOf((int) zzfw().zzic());
                    zzkq.zzafn = zzfw().zzid();
                    zzkq.zzatu = null;
                    zzkq.zzatk = null;
                    zzkq.zzatl = null;
                    zzkq.zzatm = null;
                    zzkq.zzaug = Long.valueOf(zzdz2.zzadx);
                    if (this.zzacw.isEnabled() && zzef.zzhk()) {
                        zzkq.zzauh = null;
                    }
                    zzdy zzbc2 = zzix().zzbc(zzdz2.packageName);
                    if (zzbc2 == null) {
                        zzbc2 = new zzdy(this.zzacw, zzdz2.packageName);
                        zzbc2.zzal(this.zzacw.zzfv().zzii());
                        zzbc2.zzao(zzdz2.zzado);
                        zzbc2.zzam(zzdz2.zzadm);
                        zzbc2.zzan(zzgf().zzbp(zzdz2.packageName));
                        zzbc2.zzr(0);
                        zzbc2.zzm(0);
                        zzbc2.zzn(0);
                        zzbc2.setAppVersion(zzdz2.zzth);
                        zzbc2.zzo(zzdz2.zzads);
                        zzbc2.zzap(zzdz2.zzadt);
                        zzbc2.zzp(zzdz2.zzadu);
                        zzbc2.zzq(zzdz2.zzadv);
                        zzbc2.setMeasurementEnabled(zzdz2.zzadw);
                        zzbc2.zzaa(zzdz2.zzadx);
                        zzix().zza(zzbc2);
                    }
                    zzkq.zzadl = zzbc2.getAppInstanceId();
                    zzkq.zzado = zzbc2.zzgj();
                    List<zzjz> zzbb = zzix().zzbb(zzdz2.packageName);
                    zzkq.zzatj = new zzks[zzbb.size()];
                    for (int i = 0; i < zzbb.size(); i++) {
                        zzks zzks = new zzks();
                        zzkq.zzatj[i] = zzks;
                        zzks.name = zzbb.get(i).name;
                        zzks.zzaun = Long.valueOf(zzbb.get(i).zzaqz);
                        zzgb().zza(zzks, zzbb.get(i).value);
                    }
                    long zza3 = zzix().zza(zzkq);
                    zzei zzix = zzix();
                    if (zzep.zzafq != null) {
                        Iterator<String> it = zzep.zzafq.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (str2.equals(it.next())) {
                                    break;
                                }
                            } else {
                                boolean zzo = zzkm().zzo(zzep.zzti, zzep.name);
                                zzej zza4 = zzix().zza(zzkr(), zzep.zzti, false, false, false, false, false);
                                if (zzo && zza4.zzafh < ((long) zzgg().zzar(zzep.zzti))) {
                                }
                            }
                        }
                    }
                    boolean z2 = false;
                    if (zzix.zza(zzep, zza3, z2)) {
                        this.zzaqh = 0;
                    }
                    zzix().setTransactionSuccessful();
                    if (zzge().isLoggable(2)) {
                        zzge().zzit().zzg("Event recorded", zzga().zza(zzep));
                    }
                    zzix().endTransaction();
                    zzku();
                    zzge().zzit().zzg("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
                } catch (IOException e) {
                    zzge().zzim().zze("Data loss. Failed to insert raw event metadata. appId", zzfg.zzbm(zzkq.zzti), e);
                } catch (Throwable th) {
                    zzix().endTransaction();
                    throw th;
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzka.zza(com.google.android.gms.internal.measurement.zzko[], java.lang.String, java.lang.Object):com.google.android.gms.internal.measurement.zzko[]
     arg types: [com.google.android.gms.internal.measurement.zzko[], java.lang.String, long]
     candidates:
      com.google.android.gms.internal.measurement.zzka.zza(int, java.lang.Object, boolean):java.lang.Object
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, boolean):java.lang.String
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String[]):java.lang.String
      com.google.android.gms.internal.measurement.zzka.zza(android.os.Bundle, java.lang.String, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(com.google.android.gms.internal.measurement.zzko[], java.lang.String, java.lang.Object):com.google.android.gms.internal.measurement.zzko[] */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x022a, code lost:
        if (r8 == null) goto L_0x0261;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x025d, code lost:
        if (r8 != null) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        r1 = r0;
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        r8 = null;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0083, code lost:
        if (r4 != null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009b, code lost:
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0129, code lost:
        if (r8 != null) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01ba, code lost:
        if (r6 != null) goto L_0x01bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x020a, code lost:
        if (r6 != null) goto L_0x01bc;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0265 A[Catch:{ SQLiteException -> 0x0a95, all -> 0x0ad0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044 A[ExcHandler: all (r0v14 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r4 10  PHI: (r4v64 android.database.Cursor) = (r4v56 android.database.Cursor), (r4v70 android.database.Cursor), (r4v70 android.database.Cursor), (r4v70 android.database.Cursor), (r4v70 android.database.Cursor), (r4v0 android.database.Cursor), (r4v0 android.database.Cursor) binds: [B:47:0x00d9, B:24:0x007d, B:30:0x008a, B:32:0x008e, B:33:?, B:10:0x0035, B:11:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:10:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0273 A[Catch:{ SQLiteException -> 0x0a95, all -> 0x0ad0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0528 A[Catch:{ SQLiteException -> 0x0a95, all -> 0x0ad0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x060a A[Catch:{ SQLiteException -> 0x0a95, all -> 0x0ad0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0622 A[Catch:{ SQLiteException -> 0x0a95, all -> 0x0ad0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0642 A[Catch:{ SQLiteException -> 0x0a95, all -> 0x0ad0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0755 A[Catch:{ SQLiteException -> 0x0a95, all -> 0x0ad0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0764 A[Catch:{ SQLiteException -> 0x0a95, all -> 0x0ad0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0767 A[Catch:{ SQLiteException -> 0x0a95, all -> 0x0ad0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x0788 A[Catch:{ SQLiteException -> 0x0a95, all -> 0x0ad0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x0ab8 A[SYNTHETIC, Splitter:B:411:0x0ab8] */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x0acc A[SYNTHETIC, Splitter:B:418:0x0acc] */
    /* JADX WARNING: Removed duplicated region for block: B:440:0x061f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0118 A[Catch:{ SQLiteException -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0130 A[SYNTHETIC, Splitter:B:64:0x0130] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:123:0x0261=Splitter:B:123:0x0261, B:28:0x0085=Splitter:B:28:0x0085, B:62:0x012b=Splitter:B:62:0x012b, B:82:0x01bc=Splitter:B:82:0x01bc} */
    private final boolean zzd(String str, long j) {
        Cursor cursor;
        Throwable th;
        boolean z;
        zzjv zzjv;
        zzkq zzkq;
        String str2;
        zzei zzix;
        long j2;
        SecureRandom secureRandom;
        zzkq zzkq2;
        int i;
        zzkn[] zzknArr;
        zzjv zzjv2;
        boolean z2;
        int zzp;
        int i2;
        String str3;
        zzeq zzad;
        zzjz zzjz;
        int i3;
        boolean z3;
        int i4;
        String str4;
        long j3;
        zzfi zzip;
        String str5;
        Object zzbm;
        boolean z4;
        String str6;
        SQLiteException sQLiteException;
        Cursor cursor2;
        String str7;
        String str8;
        String[] strArr;
        String str9;
        Cursor query;
        String[] strArr2;
        String str10 = "_lte";
        zzix().beginTransaction();
        try {
            Cursor cursor3 = null;
            zzjv zzjv3 = new zzjv(this, null);
            zzei zzix2 = zzix();
            long j4 = this.zzaqs;
            Preconditions.checkNotNull(zzjv3);
            zzix2.zzab();
            zzix2.zzch();
            try {
                SQLiteDatabase writableDatabase = zzix2.getWritableDatabase();
                String str11 = "";
                if (TextUtils.isEmpty(null)) {
                    if (j4 != -1) {
                        try {
                            strArr2 = new String[]{String.valueOf(j4), String.valueOf(j)};
                        } catch (SQLiteException e) {
                            e = e;
                            cursor = cursor3;
                            str6 = null;
                        } catch (Throwable th2) {
                        }
                    } else {
                        strArr2 = new String[]{String.valueOf(j)};
                    }
                    if (j4 != -1) {
                        str11 = "rowid <= ? and ";
                    }
                    StringBuilder sb = new StringBuilder(str11.length() + 148);
                    sb.append("select app_id, metadata_fingerprint from raw_events where ");
                    sb.append(str11);
                    sb.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
                    cursor3 = writableDatabase.rawQuery(sb.toString(), strArr2);
                    if (cursor3.moveToFirst()) {
                        str6 = cursor3.getString(0);
                        String string = cursor3.getString(1);
                        cursor3.close();
                        cursor2 = cursor3;
                        str8 = str6;
                        str7 = string;
                        try {
                            SQLiteDatabase sQLiteDatabase = writableDatabase;
                            cursor = writableDatabase.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str8, str7}, null, null, "rowid", "2");
                            try {
                                if (cursor.moveToFirst()) {
                                    zzix2.zzge().zzim().zzg("Raw event metadata record is missing. appId", zzfg.zzbm(str8));
                                } else {
                                    byte[] blob = cursor.getBlob(0);
                                    zzabv zza = zzabv.zza(blob, 0, blob.length);
                                    zzkq zzkq3 = new zzkq();
                                    try {
                                        zzkq3.zzb(zza);
                                        if (cursor.moveToNext()) {
                                            zzix2.zzge().zzip().zzg("Get multiple raw event metadata records, expected one. appId", zzfg.zzbm(str8));
                                        }
                                        cursor.close();
                                        zzjv3.zzb(zzkq3);
                                        if (j4 != -1) {
                                            str9 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                            strArr = new String[]{str8, str7, String.valueOf(j4)};
                                        } else {
                                            str9 = "app_id = ? and metadata_fingerprint = ?";
                                            strArr = new String[]{str8, str7};
                                        }
                                        query = sQLiteDatabase.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, str9, strArr, null, null, "rowid", null);
                                    } catch (IOException e2) {
                                        zzix2.zzge().zzim().zze("Data loss. Failed to merge raw event metadata. appId", zzfg.zzbm(str8), e2);
                                    }
                                    try {
                                        if (!query.moveToFirst()) {
                                            zzix2.zzge().zzip().zzg("Raw event data disappeared while in transaction. appId", zzfg.zzbm(str8));
                                        } else {
                                            do {
                                                long j5 = query.getLong(0);
                                                byte[] blob2 = query.getBlob(3);
                                                zzabv zza2 = zzabv.zza(blob2, 0, blob2.length);
                                                zzkn zzkn = new zzkn();
                                                try {
                                                    zzkn.zzb(zza2);
                                                    zzkn.name = query.getString(1);
                                                    zzkn.zzatb = Long.valueOf(query.getLong(2));
                                                    if (!zzjv3.zza(j5, zzkn)) {
                                                        if (query != null) {
                                                        }
                                                        if (zzjv3.zzaqx != null) {
                                                            if (!zzjv3.zzaqx.isEmpty()) {
                                                                z = false;
                                                                if (!z) {
                                                                    zzkq zzkq4 = zzjv3.zzaqv;
                                                                    zzkq4.zzati = new zzkn[zzjv3.zzaqx.size()];
                                                                    boolean zzav = zzgg().zzav(zzkq4.zzti);
                                                                    int i5 = 0;
                                                                    int i6 = 0;
                                                                    boolean z5 = false;
                                                                    long j6 = 0;
                                                                    while (i5 < zzjv3.zzaqx.size()) {
                                                                        zzkn zzkn2 = zzjv3.zzaqx.get(i5);
                                                                        if (zzkm().zzn(zzjv3.zzaqv.zzti, zzkn2.name)) {
                                                                            boolean z6 = z5;
                                                                            zzge().zzip().zze("Dropping blacklisted raw event. appId", zzfg.zzbm(zzjv3.zzaqv.zzti), zzga().zzbj(zzkn2.name));
                                                                            if (!zzkm().zzby(zzjv3.zzaqv.zzti)) {
                                                                                if (!zzkm().zzbz(zzjv3.zzaqv.zzti)) {
                                                                                    z4 = false;
                                                                                    if (!z4 && !"_err".equals(zzkn2.name)) {
                                                                                        zzgb().zza(zzjv3.zzaqv.zzti, 11, "_ev", zzkn2.name, 0);
                                                                                    }
                                                                                    str4 = str10;
                                                                                    i4 = i5;
                                                                                    z5 = z6;
                                                                                }
                                                                            }
                                                                            z4 = true;
                                                                            zzgb().zza(zzjv3.zzaqv.zzti, 11, "_ev", zzkn2.name, 0);
                                                                            str4 = str10;
                                                                            i4 = i5;
                                                                            z5 = z6;
                                                                        } else {
                                                                            boolean z7 = z5;
                                                                            boolean zzo = zzkm().zzo(zzjv3.zzaqv.zzti, zzkn2.name);
                                                                            if (!zzo) {
                                                                                zzgb();
                                                                                if (!zzka.zzcl(zzkn2.name)) {
                                                                                    str4 = str10;
                                                                                    i4 = i5;
                                                                                    j3 = j6;
                                                                                    z5 = z7;
                                                                                    if (zzav && "_e".equals(zzkn2.name)) {
                                                                                        if (zzkn2.zzata != null) {
                                                                                            if (zzkn2.zzata.length != 0) {
                                                                                                zzgb();
                                                                                                Long l = (Long) zzka.zzb(zzkn2, "_et");
                                                                                                if (l == null) {
                                                                                                    zzip = zzge().zzip();
                                                                                                    str5 = "Engagement event does not include duration. appId";
                                                                                                    zzbm = zzfg.zzbm(zzjv3.zzaqv.zzti);
                                                                                                    zzip.zzg(str5, zzbm);
                                                                                                } else {
                                                                                                    j6 = j3 + l.longValue();
                                                                                                    zzkq4.zzati[i6] = zzkn2;
                                                                                                    i6++;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        zzip = zzge().zzip();
                                                                                        str5 = "Engagement event does not contain any parameters. appId";
                                                                                        zzbm = zzfg.zzbm(zzjv3.zzaqv.zzti);
                                                                                        zzip.zzg(str5, zzbm);
                                                                                    }
                                                                                    j6 = j3;
                                                                                    zzkq4.zzati[i6] = zzkn2;
                                                                                    i6++;
                                                                                }
                                                                            }
                                                                            if (zzkn2.zzata == null) {
                                                                                zzkn2.zzata = new zzko[0];
                                                                            }
                                                                            zzko[] zzkoArr = zzkn2.zzata;
                                                                            int length = zzkoArr.length;
                                                                            str4 = str10;
                                                                            int i7 = 0;
                                                                            boolean z8 = false;
                                                                            boolean z9 = false;
                                                                            while (true) {
                                                                                i4 = i5;
                                                                                if (i7 >= length) {
                                                                                    break;
                                                                                }
                                                                                int i8 = length;
                                                                                zzko zzko = zzkoArr[i7];
                                                                                zzko[] zzkoArr2 = zzkoArr;
                                                                                if ("_c".equals(zzko.name)) {
                                                                                    zzko.zzate = 1L;
                                                                                    z8 = true;
                                                                                } else if ("_r".equals(zzko.name)) {
                                                                                    zzko.zzate = 1L;
                                                                                    z9 = true;
                                                                                }
                                                                                i7++;
                                                                                i5 = i4;
                                                                                length = i8;
                                                                                zzkoArr = zzkoArr2;
                                                                            }
                                                                            if (!z8 && zzo) {
                                                                                zzge().zzit().zzg("Marking event as conversion", zzga().zzbj(zzkn2.name));
                                                                                zzko[] zzkoArr3 = (zzko[]) Arrays.copyOf(zzkn2.zzata, zzkn2.zzata.length + 1);
                                                                                zzko zzko2 = new zzko();
                                                                                zzko2.name = "_c";
                                                                                zzko2.zzate = 1L;
                                                                                zzkoArr3[zzkoArr3.length - 1] = zzko2;
                                                                                zzkn2.zzata = zzkoArr3;
                                                                            }
                                                                            if (!z9) {
                                                                                zzge().zzit().zzg("Marking event as real-time", zzga().zzbj(zzkn2.name));
                                                                                zzko[] zzkoArr4 = (zzko[]) Arrays.copyOf(zzkn2.zzata, zzkn2.zzata.length + 1);
                                                                                zzko zzko3 = new zzko();
                                                                                zzko3.name = "_r";
                                                                                zzko3.zzate = 1L;
                                                                                zzkoArr4[zzkoArr4.length - 1] = zzko3;
                                                                                zzkn2.zzata = zzkoArr4;
                                                                            }
                                                                            j3 = j6;
                                                                            if (zzix().zza(zzkr(), zzjv3.zzaqv.zzti, false, false, false, false, true).zzafh > ((long) zzgg().zzar(zzjv3.zzaqv.zzti))) {
                                                                                int i9 = 0;
                                                                                while (true) {
                                                                                    if (i9 >= zzkn2.zzata.length) {
                                                                                        break;
                                                                                    } else if ("_r".equals(zzkn2.zzata[i9].name)) {
                                                                                        zzko[] zzkoArr5 = new zzko[(zzkn2.zzata.length - 1)];
                                                                                        if (i9 > 0) {
                                                                                            System.arraycopy(zzkn2.zzata, 0, zzkoArr5, 0, i9);
                                                                                        }
                                                                                        if (i9 < zzkoArr5.length) {
                                                                                            System.arraycopy(zzkn2.zzata, i9 + 1, zzkoArr5, i9, zzkoArr5.length - i9);
                                                                                        }
                                                                                        zzkn2.zzata = zzkoArr5;
                                                                                    } else {
                                                                                        i9++;
                                                                                    }
                                                                                }
                                                                                z5 = z7;
                                                                            } else {
                                                                                z5 = true;
                                                                            }
                                                                            if (zzka.zzcc(zzkn2.name) && zzo && zzix().zza(zzkr(), zzjv3.zzaqv.zzti, false, false, true, false, false).zzaff > ((long) zzgg().zzb(zzjv3.zzaqv.zzti, zzew.zzagv))) {
                                                                                zzge().zzip().zzg("Too many conversions. Not logging as conversion. appId", zzfg.zzbm(zzjv3.zzaqv.zzti));
                                                                                boolean z10 = false;
                                                                                zzko zzko4 = null;
                                                                                for (zzko zzko5 : zzkn2.zzata) {
                                                                                    if ("_c".equals(zzko5.name)) {
                                                                                        zzko4 = zzko5;
                                                                                    } else if ("_err".equals(zzko5.name)) {
                                                                                        z10 = true;
                                                                                    }
                                                                                }
                                                                                if (z10 && zzko4 != null) {
                                                                                    zzkn2.zzata = (zzko[]) ArrayUtils.removeAll(zzkn2.zzata, zzko4);
                                                                                } else if (zzko4 != null) {
                                                                                    zzko4.name = "_err";
                                                                                    zzko4.zzate = 10L;
                                                                                } else {
                                                                                    zzge().zzim().zzg("Did not find conversion parameter. appId", zzfg.zzbm(zzjv3.zzaqv.zzti));
                                                                                }
                                                                            }
                                                                            if (zzkn2.zzata != null) {
                                                                            }
                                                                            zzip = zzge().zzip();
                                                                            str5 = "Engagement event does not contain any parameters. appId";
                                                                            zzbm = zzfg.zzbm(zzjv3.zzaqv.zzti);
                                                                            zzip.zzg(str5, zzbm);
                                                                            j6 = j3;
                                                                            zzkq4.zzati[i6] = zzkn2;
                                                                            i6++;
                                                                        }
                                                                        i5 = i4 + 1;
                                                                        str10 = str4;
                                                                    }
                                                                    String str12 = str10;
                                                                    boolean z11 = z5;
                                                                    long j7 = j6;
                                                                    if (i6 < zzjv3.zzaqx.size()) {
                                                                        zzkq4.zzati = (zzkn[]) Arrays.copyOf(zzkq4.zzati, i6);
                                                                    }
                                                                    if (zzav) {
                                                                        String str13 = str12;
                                                                        zzjz zzh = zzix().zzh(zzkq4.zzti, str13);
                                                                        if (zzh != null) {
                                                                            if (zzh.value != null) {
                                                                                zzjz = new zzjz(zzkq4.zzti, "auto", "_lte", zzbt().currentTimeMillis(), Long.valueOf(((Long) zzh.value).longValue() + j7));
                                                                                zzks zzks = new zzks();
                                                                                zzks.name = str13;
                                                                                zzks.zzaun = Long.valueOf(zzbt().currentTimeMillis());
                                                                                zzks.zzate = (Long) zzjz.value;
                                                                                i3 = 0;
                                                                                while (true) {
                                                                                    if (i3 < zzkq4.zzatj.length) {
                                                                                        z3 = false;
                                                                                        break;
                                                                                    } else if (str13.equals(zzkq4.zzatj[i3].name)) {
                                                                                        zzkq4.zzatj[i3] = zzks;
                                                                                        z3 = true;
                                                                                        break;
                                                                                    } else {
                                                                                        i3++;
                                                                                    }
                                                                                }
                                                                                if (!z3) {
                                                                                    zzkq4.zzatj = (zzks[]) Arrays.copyOf(zzkq4.zzatj, zzkq4.zzatj.length + 1);
                                                                                    zzkq4.zzatj[zzjv3.zzaqv.zzatj.length - 1] = zzks;
                                                                                }
                                                                                if (j7 > 0) {
                                                                                    zzix().zza(zzjz);
                                                                                    zzge().zzis().zzg("Updated lifetime engagement user property with value. Value", zzjz.value);
                                                                                }
                                                                            }
                                                                        }
                                                                        zzjz = new zzjz(zzkq4.zzti, "auto", "_lte", zzbt().currentTimeMillis(), Long.valueOf(j7));
                                                                        zzks zzks2 = new zzks();
                                                                        zzks2.name = str13;
                                                                        zzks2.zzaun = Long.valueOf(zzbt().currentTimeMillis());
                                                                        zzks2.zzate = (Long) zzjz.value;
                                                                        i3 = 0;
                                                                        while (true) {
                                                                            if (i3 < zzkq4.zzatj.length) {
                                                                            }
                                                                            i3++;
                                                                        }
                                                                        if (!z3) {
                                                                        }
                                                                        if (j7 > 0) {
                                                                        }
                                                                    }
                                                                    zzkq4.zzaua = zza(zzkq4.zzti, zzkq4.zzatj, zzkq4.zzati);
                                                                    if (zzgg().zzau(zzjv3.zzaqv.zzti)) {
                                                                        HashMap hashMap = new HashMap();
                                                                        zzkn[] zzknArr2 = new zzkn[zzkq4.zzati.length];
                                                                        SecureRandom zzlc = zzgb().zzlc();
                                                                        zzkn[] zzknArr3 = zzkq4.zzati;
                                                                        int length2 = zzknArr3.length;
                                                                        int i10 = 0;
                                                                        int i11 = 0;
                                                                        while (i10 < length2) {
                                                                            zzkn zzkn3 = zzknArr3[i10];
                                                                            if (zzkn3.name.equals("_ep")) {
                                                                                zzgb();
                                                                                String str14 = (String) zzka.zzb(zzkn3, "_en");
                                                                                zzeq zzeq = (zzeq) hashMap.get(str14);
                                                                                if (zzeq == null) {
                                                                                    zzeq = zzix().zzf(zzjv3.zzaqv.zzti, str14);
                                                                                    hashMap.put(str14, zzeq);
                                                                                }
                                                                                if (zzeq.zzafv == null) {
                                                                                    if (zzeq.zzafw.longValue() > 1) {
                                                                                        zzgb();
                                                                                        zzkn3.zzata = zzka.zza(zzkn3.zzata, "_sr", zzeq.zzafw);
                                                                                    }
                                                                                    if (zzeq.zzafx != null && zzeq.zzafx.booleanValue()) {
                                                                                        zzgb();
                                                                                        zzkn3.zzata = zzka.zza(zzkn3.zzata, "_efs", (Object) 1L);
                                                                                    }
                                                                                    zzknArr2[i11] = zzkn3;
                                                                                    zzjv2 = zzjv3;
                                                                                    zzkq2 = zzkq4;
                                                                                    secureRandom = zzlc;
                                                                                    i11++;
                                                                                } else {
                                                                                    zzjv2 = zzjv3;
                                                                                    zzkq2 = zzkq4;
                                                                                    secureRandom = zzlc;
                                                                                }
                                                                                zzknArr = zzknArr3;
                                                                                i = length2;
                                                                            } else {
                                                                                Long l2 = 1L;
                                                                                if (!TextUtils.isEmpty("_dbg")) {
                                                                                    if (l2 != null) {
                                                                                        zzko[] zzkoArr6 = zzkn3.zzata;
                                                                                        zzknArr = zzknArr3;
                                                                                        int length3 = zzkoArr6.length;
                                                                                        i = length2;
                                                                                        int i12 = 0;
                                                                                        while (true) {
                                                                                            if (i12 >= length3) {
                                                                                                break;
                                                                                            }
                                                                                            int i13 = length3;
                                                                                            zzko zzko6 = zzkoArr6[i12];
                                                                                            zzko[] zzkoArr7 = zzkoArr6;
                                                                                            if (!"_dbg".equals(zzko6.name)) {
                                                                                                i12++;
                                                                                                length3 = i13;
                                                                                                zzkoArr6 = zzkoArr7;
                                                                                            } else if (l2 instanceof Long) {
                                                                                                if (l2.equals(zzko6.zzate)) {
                                                                                                    z2 = true;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        z2 = false;
                                                                                        zzp = z2 ? zzkm().zzp(zzjv3.zzaqv.zzti, zzkn3.name) : 1;
                                                                                        if (zzp > 0) {
                                                                                            zzge().zzip().zze("Sample rate must be positive. event, rate", zzkn3.name, Integer.valueOf(zzp));
                                                                                            zzknArr2[i11] = zzkn3;
                                                                                            zzjv2 = zzjv3;
                                                                                            zzkq2 = zzkq4;
                                                                                            secureRandom = zzlc;
                                                                                            i11++;
                                                                                        } else {
                                                                                            zzeq zzeq2 = (zzeq) hashMap.get(zzkn3.name);
                                                                                            if (zzeq2 == null && (zzeq2 = zzix().zzf(zzjv3.zzaqv.zzti, zzkn3.name)) == null) {
                                                                                                zzge().zzip().zze("Event being bundled has no eventAggregate. appId, eventName", zzjv3.zzaqv.zzti, zzkn3.name);
                                                                                                zzeq2 = new zzeq(zzjv3.zzaqv.zzti, zzkn3.name, 1, 1, zzkn3.zzatb.longValue(), 0, null, null, null);
                                                                                            }
                                                                                            zzgb();
                                                                                            Long l3 = (Long) zzka.zzb(zzkn3, "_eid");
                                                                                            Boolean valueOf = Boolean.valueOf(l3 != null);
                                                                                            if (zzp == 1) {
                                                                                                i2 = i11 + 1;
                                                                                                zzknArr2[i11] = zzkn3;
                                                                                                if (valueOf.booleanValue() && !(zzeq2.zzafv == null && zzeq2.zzafw == null && zzeq2.zzafx == null)) {
                                                                                                    zzad = zzeq2.zza(null, null, null);
                                                                                                    str3 = zzkn3.name;
                                                                                                }
                                                                                                zzjv2 = zzjv3;
                                                                                                zzkq2 = zzkq4;
                                                                                                secureRandom = zzlc;
                                                                                                i11 = i2;
                                                                                            } else if (zzlc.nextInt(zzp) == 0) {
                                                                                                zzgb();
                                                                                                long j8 = (long) zzp;
                                                                                                zzkn3.zzata = zzka.zza(zzkn3.zzata, "_sr", Long.valueOf(j8));
                                                                                                i2 = i11 + 1;
                                                                                                zzknArr2[i11] = zzkn3;
                                                                                                if (valueOf.booleanValue()) {
                                                                                                    zzeq2 = zzeq2.zza(null, Long.valueOf(j8), null);
                                                                                                }
                                                                                                str3 = zzkn3.name;
                                                                                                zzad = zzeq2.zzad(zzkn3.zzatb.longValue());
                                                                                            } else {
                                                                                                zzjv2 = zzjv3;
                                                                                                zzkq2 = zzkq4;
                                                                                                secureRandom = zzlc;
                                                                                                if (Math.abs(zzkn3.zzatb.longValue() - zzeq2.zzafu) >= 86400000) {
                                                                                                    zzgb();
                                                                                                    zzkn3.zzata = zzka.zza(zzkn3.zzata, "_efs", (Object) 1L);
                                                                                                    zzgb();
                                                                                                    long j9 = (long) zzp;
                                                                                                    zzkn3.zzata = zzka.zza(zzkn3.zzata, "_sr", Long.valueOf(j9));
                                                                                                    int i14 = i11 + 1;
                                                                                                    zzknArr2[i11] = zzkn3;
                                                                                                    if (valueOf.booleanValue()) {
                                                                                                        zzeq2 = zzeq2.zza(null, Long.valueOf(j9), Boolean.TRUE);
                                                                                                    }
                                                                                                    hashMap.put(zzkn3.name, zzeq2.zzad(zzkn3.zzatb.longValue()));
                                                                                                    i11 = i14;
                                                                                                } else if (valueOf.booleanValue()) {
                                                                                                    hashMap.put(zzkn3.name, zzeq2.zza(l3, null, null));
                                                                                                }
                                                                                                i10++;
                                                                                                zzjv3 = zzjv2;
                                                                                                zzknArr3 = zzknArr;
                                                                                                length2 = i;
                                                                                                zzkq4 = zzkq2;
                                                                                                zzlc = secureRandom;
                                                                                            }
                                                                                            hashMap.put(str3, zzad);
                                                                                            zzjv2 = zzjv3;
                                                                                            zzkq2 = zzkq4;
                                                                                            secureRandom = zzlc;
                                                                                            i11 = i2;
                                                                                        }
                                                                                    }
                                                                                }
                                                                                zzknArr = zzknArr3;
                                                                                i = length2;
                                                                                z2 = false;
                                                                                if (z2) {
                                                                                }
                                                                                if (zzp > 0) {
                                                                                }
                                                                            }
                                                                            i10++;
                                                                            zzjv3 = zzjv2;
                                                                            zzknArr3 = zzknArr;
                                                                            length2 = i;
                                                                            zzkq4 = zzkq2;
                                                                            zzlc = secureRandom;
                                                                        }
                                                                        zzjv = zzjv3;
                                                                        zzkq = zzkq4;
                                                                        if (i11 < zzkq.zzati.length) {
                                                                            zzkq.zzati = (zzkn[]) Arrays.copyOf(zzknArr2, i11);
                                                                        }
                                                                        for (Map.Entry value : hashMap.entrySet()) {
                                                                            zzix().zza((zzeq) value.getValue());
                                                                        }
                                                                    } else {
                                                                        zzjv = zzjv3;
                                                                        zzkq = zzkq4;
                                                                    }
                                                                    zzkq.zzatl = Long.MAX_VALUE;
                                                                    zzkq.zzatm = Long.MIN_VALUE;
                                                                    for (zzkn zzkn4 : zzkq.zzati) {
                                                                        if (zzkn4.zzatb.longValue() < zzkq.zzatl.longValue()) {
                                                                            zzkq.zzatl = zzkn4.zzatb;
                                                                        }
                                                                        if (zzkn4.zzatb.longValue() > zzkq.zzatm.longValue()) {
                                                                            zzkq.zzatm = zzkn4.zzatb;
                                                                        }
                                                                    }
                                                                    zzjv zzjv4 = zzjv;
                                                                    str2 = zzjv4.zzaqv.zzti;
                                                                    zzdy zzbc = zzix().zzbc(str2);
                                                                    if (zzbc == null) {
                                                                        zzge().zzim().zzg("Bundling raw events w/o app info. appId", zzfg.zzbm(zzjv4.zzaqv.zzti));
                                                                    } else if (zzkq.zzati.length > 0) {
                                                                        long zzgl = zzbc.zzgl();
                                                                        zzkq.zzato = zzgl != 0 ? Long.valueOf(zzgl) : null;
                                                                        long zzgk = zzbc.zzgk();
                                                                        if (zzgk != 0) {
                                                                            zzgl = zzgk;
                                                                        }
                                                                        zzkq.zzatn = zzgl != 0 ? Long.valueOf(zzgl) : null;
                                                                        zzbc.zzgt();
                                                                        zzkq.zzaty = Integer.valueOf((int) zzbc.zzgq());
                                                                        zzbc.zzm(zzkq.zzatl.longValue());
                                                                        zzbc.zzn(zzkq.zzatm.longValue());
                                                                        zzkq.zzaek = zzbc.zzhb();
                                                                        zzix().zza(zzbc);
                                                                    }
                                                                    if (zzkq.zzati.length > 0) {
                                                                        zzkk zzbu = zzkm().zzbu(zzjv4.zzaqv.zzti);
                                                                        if (zzbu != null) {
                                                                            if (zzbu.zzasp != null) {
                                                                                j2 = zzbu.zzasp;
                                                                                zzkq.zzauf = j2;
                                                                                zzix().zza(zzkq, z11);
                                                                            }
                                                                        }
                                                                        if (TextUtils.isEmpty(zzjv4.zzaqv.zzadm)) {
                                                                            j2 = -1L;
                                                                            zzkq.zzauf = j2;
                                                                            zzix().zza(zzkq, z11);
                                                                        } else {
                                                                            zzge().zzip().zzg("Did not find measurement config or missing version info. appId", zzfg.zzbm(zzjv4.zzaqv.zzti));
                                                                            zzix().zza(zzkq, z11);
                                                                        }
                                                                    }
                                                                    zzei zzix3 = zzix();
                                                                    List<Long> list = zzjv4.zzaqw;
                                                                    Preconditions.checkNotNull(list);
                                                                    zzix3.zzab();
                                                                    zzix3.zzch();
                                                                    StringBuilder sb2 = new StringBuilder("rowid in (");
                                                                    for (int i15 = 0; i15 < list.size(); i15++) {
                                                                        if (i15 != 0) {
                                                                            sb2.append(",");
                                                                        }
                                                                        sb2.append(list.get(i15).longValue());
                                                                    }
                                                                    sb2.append(")");
                                                                    int delete = zzix3.getWritableDatabase().delete("raw_events", sb2.toString(), null);
                                                                    if (delete != list.size()) {
                                                                        zzix3.zzge().zzim().zze("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
                                                                    }
                                                                    zzix = zzix();
                                                                    zzix.getWritableDatabase().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str2, str2});
                                                                    zzix().setTransactionSuccessful();
                                                                    zzix().endTransaction();
                                                                    return true;
                                                                }
                                                                zzix().setTransactionSuccessful();
                                                                zzix().endTransaction();
                                                                return false;
                                                            }
                                                        }
                                                        z = true;
                                                        if (!z) {
                                                        }
                                                    }
                                                } catch (IOException e3) {
                                                    zzix2.zzge().zzim().zze("Data loss. Failed to merge raw event. appId", zzfg.zzbm(str8), e3);
                                                }
                                            } while (query.moveToNext());
                                        }
                                        query.close();
                                    } catch (SQLiteException e4) {
                                        e = e4;
                                        str6 = str8;
                                        cursor = query;
                                        sQLiteException = e;
                                        try {
                                            zzix2.zzge().zzim().zze("Data loss. Error selecting raw event. appId", zzfg.zzbm(str6), sQLiteException);
                                        } catch (Throwable th3) {
                                            th = th3;
                                            if (cursor != null) {
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        cursor = query;
                                        if (cursor != null) {
                                        }
                                        throw th;
                                    }
                                    if (zzjv3.zzaqx != null) {
                                    }
                                    z = true;
                                    if (!z) {
                                    }
                                }
                            } catch (SQLiteException e5) {
                                e = e5;
                                str6 = str8;
                                sQLiteException = e;
                                zzix2.zzge().zzim().zze("Data loss. Error selecting raw event. appId", zzfg.zzbm(str6), sQLiteException);
                            }
                        } catch (SQLiteException e6) {
                            e = e6;
                            str6 = str8;
                            cursor = cursor2;
                            sQLiteException = e;
                            zzix2.zzge().zzim().zze("Data loss. Error selecting raw event. appId", zzfg.zzbm(str6), sQLiteException);
                        } catch (Throwable th5) {
                            th = th5;
                            cursor = cursor2;
                            if (cursor != null) {
                            }
                            throw th;
                        }
                    }
                } else {
                    String[] strArr3 = j4 != -1 ? new String[]{null, String.valueOf(j4)} : new String[]{null};
                    if (j4 != -1) {
                        str11 = " and rowid <= ?";
                    }
                    StringBuilder sb3 = new StringBuilder(str11.length() + 84);
                    sb3.append("select metadata_fingerprint from raw_events where app_id = ?");
                    sb3.append(str11);
                    sb3.append(" order by rowid limit 1;");
                    cursor3 = writableDatabase.rawQuery(sb3.toString(), strArr3);
                    if (!cursor3.moveToFirst()) {
                        if (cursor3 != null) {
                        }
                        if (zzjv3.zzaqx != null) {
                        }
                        z = true;
                        if (!z) {
                        }
                    } else {
                        String string2 = cursor3.getString(0);
                        cursor3.close();
                        cursor2 = cursor3;
                        str7 = string2;
                        str8 = null;
                        SQLiteDatabase sQLiteDatabase2 = writableDatabase;
                        cursor = writableDatabase.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str8, str7}, null, null, "rowid", "2");
                        if (cursor.moveToFirst()) {
                        }
                    }
                }
                cursor3.close();
            } catch (SQLiteException e7) {
                sQLiteException = e7;
                cursor = null;
                str6 = null;
                zzix2.zzge().zzim().zze("Data loss. Error selecting raw event. appId", zzfg.zzbm(str6), sQLiteException);
            } catch (Throwable th6) {
                th = th6;
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            if (zzjv3.zzaqx != null) {
            }
            z = true;
            if (!z) {
            }
        } catch (SQLiteException e8) {
            zzix.zzge().zzim().zze("Failed to remove unused event metadata. appId", zzfg.zzbm(str2), e8);
        } catch (Throwable th7) {
            Throwable th8 = th7;
            zzix().endTransaction();
            throw th8;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x014e  */
    public final zzdy zzg(zzdz zzdz) {
        boolean z;
        zzab();
        zzkq();
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz.packageName);
        zzdy zzbc = zzix().zzbc(zzdz.packageName);
        String zzbp = zzgf().zzbp(zzdz.packageName);
        if (zzbc == null) {
            zzbc = new zzdy(this.zzacw, zzdz.packageName);
            zzbc.zzal(this.zzacw.zzfv().zzii());
            zzbc.zzan(zzbp);
        } else if (!zzbp.equals(zzbc.zzgi())) {
            zzbc.zzan(zzbp);
            zzbc.zzal(this.zzacw.zzfv().zzii());
        } else {
            z = false;
            if (!TextUtils.isEmpty(zzdz.zzadm) && !zzdz.zzadm.equals(zzbc.getGmpAppId())) {
                zzbc.zzam(zzdz.zzadm);
                z = true;
            }
            if (!TextUtils.isEmpty(zzdz.zzado) && !zzdz.zzado.equals(zzbc.zzgj())) {
                zzbc.zzao(zzdz.zzado);
                z = true;
            }
            if (!(zzdz.zzadu == 0 || zzdz.zzadu == zzbc.zzgo())) {
                zzbc.zzp(zzdz.zzadu);
                z = true;
            }
            if (!TextUtils.isEmpty(zzdz.zzth) && !zzdz.zzth.equals(zzbc.zzag())) {
                zzbc.setAppVersion(zzdz.zzth);
                z = true;
            }
            if (zzdz.zzads != zzbc.zzgm()) {
                zzbc.zzo(zzdz.zzads);
                z = true;
            }
            if (zzdz.zzadt != null && !zzdz.zzadt.equals(zzbc.zzgn())) {
                zzbc.zzap(zzdz.zzadt);
                z = true;
            }
            if (zzdz.zzadv != zzbc.zzgp()) {
                zzbc.zzq(zzdz.zzadv);
                z = true;
            }
            if (zzdz.zzadw != zzbc.isMeasurementEnabled()) {
                zzbc.setMeasurementEnabled(zzdz.zzadw);
                z = true;
            }
            if (!TextUtils.isEmpty(zzdz.zzaek) && !zzdz.zzaek.equals(zzbc.zzha())) {
                zzbc.zzaq(zzdz.zzaek);
                z = true;
            }
            if (zzdz.zzadx != zzbc.zzhc()) {
                zzbc.zzaa(zzdz.zzadx);
                z = true;
            }
            if (zzdz.zzady != zzbc.zzhd()) {
                zzbc.zzd(zzdz.zzady);
                z = true;
            }
            if (zzdz.zzadz != zzbc.zzhe()) {
                zzbc.zze(zzdz.zzadz);
                z = true;
            }
            if (z) {
                zzix().zza(zzbc);
            }
            return zzbc;
        }
        z = true;
        zzbc.zzam(zzdz.zzadm);
        z = true;
        zzbc.zzao(zzdz.zzado);
        z = true;
        zzbc.zzp(zzdz.zzadu);
        z = true;
        zzbc.setAppVersion(zzdz.zzth);
        z = true;
        if (zzdz.zzads != zzbc.zzgm()) {
        }
        zzbc.zzap(zzdz.zzadt);
        z = true;
        if (zzdz.zzadv != zzbc.zzgp()) {
        }
        if (zzdz.zzadw != zzbc.isMeasurementEnabled()) {
        }
        zzbc.zzaq(zzdz.zzaek);
        z = true;
        if (zzdz.zzadx != zzbc.zzhc()) {
        }
        if (zzdz.zzady != zzbc.zzhd()) {
        }
        if (zzdz.zzadz != zzbc.zzhe()) {
        }
        if (z) {
        }
        return zzbc;
    }

    private final zzgf zzkm() {
        zza(this.zzaqa);
        return this.zzaqa;
    }

    private final zzfp zzko() {
        zzfp zzfp = this.zzaqd;
        if (zzfp != null) {
            return zzfp;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzjn zzkp() {
        zza(this.zzaqe);
        return this.zzaqe;
    }

    private final long zzkr() {
        long currentTimeMillis = zzbt().currentTimeMillis();
        zzfr zzgf = zzgf();
        zzgf.zzch();
        zzgf.zzab();
        long j = zzgf.zzajy.get();
        if (j == 0) {
            j = 1 + ((long) zzgf.zzgb().zzlc().nextInt(86400000));
            zzgf.zzajy.set(j);
        }
        return ((((currentTimeMillis + j) / 1000) / 60) / 60) / 24;
    }

    private final boolean zzkt() {
        zzab();
        zzkq();
        return zzix().zzhs() || !TextUtils.isEmpty(zzix().zzhn());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0186  */
    private final void zzku() {
        zzex<Long> zzex;
        long j;
        zzab();
        zzkq();
        if (zzky()) {
            if (this.zzaqh > 0) {
                long abs = 3600000 - Math.abs(zzbt().elapsedRealtime() - this.zzaqh);
                if (abs > 0) {
                    zzge().zzit().zzg("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    zzko().unregister();
                    zzkp().cancel();
                    return;
                }
                this.zzaqh = 0;
            }
            if (!this.zzacw.zzjv() || !zzkt()) {
                zzge().zzit().log("Nothing to upload or uploading impossible");
                zzko().unregister();
                zzkp().cancel();
                return;
            }
            long currentTimeMillis = zzbt().currentTimeMillis();
            long max = Math.max(0L, zzew.zzahi.get().longValue());
            boolean z = zzix().zzht() || zzix().zzho();
            if (z) {
                String zzhj = zzgg().zzhj();
                zzex = (TextUtils.isEmpty(zzhj) || ".none.".equals(zzhj)) ? zzew.zzahc : zzew.zzahd;
            } else {
                zzex = zzew.zzahb;
            }
            long max2 = Math.max(0L, ((Long) zzex.get()).longValue());
            long j2 = zzgf().zzaju.get();
            long j3 = zzgf().zzajv.get();
            long j4 = max2;
            long j5 = max;
            long max3 = Math.max(zzix().zzhq(), zzix().zzhr());
            if (max3 != 0) {
                long abs2 = currentTimeMillis - Math.abs(max3 - currentTimeMillis);
                long abs3 = currentTimeMillis - Math.abs(j2 - currentTimeMillis);
                long abs4 = currentTimeMillis - Math.abs(j3 - currentTimeMillis);
                long max4 = Math.max(abs3, abs4);
                long j6 = abs2 + j5;
                if (z && max4 > 0) {
                    j6 = Math.min(abs2, max4) + j4;
                }
                long j7 = j4;
                j = !zzgb().zza(max4, j7) ? max4 + j7 : j6;
                if (abs4 != 0 && abs4 >= abs2) {
                    int i = 0;
                    while (true) {
                        if (i >= Math.min(20, Math.max(0, zzew.zzahk.get().intValue()))) {
                            break;
                        }
                        j += Math.max(0L, zzew.zzahj.get().longValue()) * (1 << i);
                        if (j > abs4) {
                            break;
                        }
                        i++;
                    }
                }
                if (j != 0) {
                    zzge().zzit().log("Next upload time is 0");
                    zzko().unregister();
                    zzkp().cancel();
                    return;
                } else if (!zzkn().zzex()) {
                    zzge().zzit().log("No network");
                    zzko().zzeu();
                    zzkp().cancel();
                    return;
                } else {
                    long j8 = zzgf().zzajw.get();
                    long max5 = Math.max(0L, zzew.zzagz.get().longValue());
                    if (!zzgb().zza(j8, max5)) {
                        j = Math.max(j, j8 + max5);
                    }
                    zzko().unregister();
                    long currentTimeMillis2 = j - zzbt().currentTimeMillis();
                    if (currentTimeMillis2 <= 0) {
                        currentTimeMillis2 = Math.max(0L, zzew.zzahe.get().longValue());
                        zzgf().zzaju.set(zzbt().currentTimeMillis());
                    }
                    zzge().zzit().zzg("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
                    zzkp().zzh(currentTimeMillis2);
                    return;
                }
            }
            j = 0;
            if (j != 0) {
            }
        }
    }

    private final void zzkv() {
        zzab();
        if (this.zzaql || this.zzaqm || this.zzaqn) {
            zzge().zzit().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzaql), Boolean.valueOf(this.zzaqm), Boolean.valueOf(this.zzaqn));
            return;
        }
        zzge().zzit().log("Stopping uploading service(s)");
        List<Runnable> list = this.zzaqi;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.zzaqi.clear();
        }
    }

    @VisibleForTesting
    private final boolean zzkw() {
        String str;
        zzfi zzfi;
        zzab();
        try {
            this.zzaqp = new RandomAccessFile(new File(getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzaqo = this.zzaqp.tryLock();
            if (this.zzaqo != null) {
                zzge().zzit().log("Storage concurrent access okay");
                return true;
            }
            zzge().zzim().log("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            e = e;
            zzfi = zzge().zzim();
            str = "Failed to acquire storage lock";
            zzfi.zzg(str, e);
            return false;
        } catch (IOException e2) {
            e = e2;
            zzfi = zzge().zzim();
            str = "Failed to access storage lock file";
            zzfi.zzg(str, e);
            return false;
        }
    }

    private final boolean zzky() {
        zzab();
        zzkq();
        return this.zzaqg;
    }

    public Context getContext() {
        return this.zzacw.getContext();
    }

    /* access modifiers changed from: protected */
    public void start() {
        zzab();
        zzix().zzhp();
        if (zzgf().zzaju.get() == 0) {
            zzgf().zzaju.set(zzbt().currentTimeMillis());
        }
        zzku();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzei zzix;
        zzab();
        zzkq();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzaqm = false;
                zzkv();
                throw th2;
            }
        }
        List<Long> list = this.zzaqq;
        this.zzaqq = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                zzgf().zzaju.set(zzbt().currentTimeMillis());
                zzgf().zzajv.set(0);
                zzku();
                zzge().zzit().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzix().beginTransaction();
                try {
                    for (Long next : list) {
                        try {
                            zzix = zzix();
                            long longValue = next.longValue();
                            zzix.zzab();
                            zzix.zzch();
                            if (zzix.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzix.zzge().zzim().zzg("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzaqr == null || !this.zzaqr.contains(next)) {
                                throw e2;
                            }
                        }
                    }
                    zzix().setTransactionSuccessful();
                    zzix().endTransaction();
                    this.zzaqr = null;
                    if (!zzkn().zzex() || !zzkt()) {
                        this.zzaqs = -1;
                        zzku();
                    } else {
                        zzks();
                    }
                    this.zzaqh = 0;
                } catch (Throwable th3) {
                    zzix().endTransaction();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                zzge().zzim().zzg("Database error while trying to delete uploaded bundles", e3);
                this.zzaqh = zzbt().elapsedRealtime();
                zzge().zzit().zzg("Disable upload, time", Long.valueOf(this.zzaqh));
            }
        } else {
            zzge().zzit().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzgf().zzajv.set(zzbt().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                zzgf().zzajw.set(zzbt().currentTimeMillis());
            }
            if (zzgg().zzax(str)) {
                zzix().zzc(list);
            }
            zzku();
        }
        this.zzaqm = false;
        zzkv();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgl zzgl) {
        this.zzacw = zzgl;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzjw zzjw) {
        zzab();
        zzei zzei = new zzei(this.zzacw);
        zzei.zzm();
        this.zzaqc = zzei;
        zzgg().zza(this.zzaqa);
        zzeb zzeb = new zzeb(this.zzacw);
        zzeb.zzm();
        this.zzaqf = zzeb;
        zzjn zzjn = new zzjn(this.zzacw);
        zzjn.zzm();
        this.zzaqe = zzjn;
        this.zzaqd = new zzfp(this.zzacw);
        if (this.zzaqj != this.zzaqk) {
            zzge().zzim().zze("Not all upload components initialized", Integer.valueOf(this.zzaqj), Integer.valueOf(this.zzaqk));
        }
        this.zzvo = true;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v0, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: java.lang.Long} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzka.zza(android.os.Bundle, java.lang.String, java.lang.Object):void
     arg types: [android.os.Bundle, java.lang.String, long]
     candidates:
      com.google.android.gms.internal.measurement.zzka.zza(int, java.lang.Object, boolean):java.lang.Object
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, boolean):java.lang.String
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String[]):java.lang.String
      com.google.android.gms.internal.measurement.zzka.zza(com.google.android.gms.internal.measurement.zzko[], java.lang.String, java.lang.Object):com.google.android.gms.internal.measurement.zzko[]
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(android.os.Bundle, java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Multi-variable type inference failed */
    public final byte[] zza(zzeu zzeu, String str) {
        zzjz zzjz;
        zzkq zzkq;
        byte[] bArr;
        Bundle bundle;
        zzkp zzkp;
        zzdy zzdy;
        long j;
        zzfi zzip;
        String str2;
        Object zzbm;
        zzeu zzeu2 = zzeu;
        String str3 = str;
        zzkq();
        zzab();
        zzgl.zzfr();
        Preconditions.checkNotNull(zzeu);
        Preconditions.checkNotEmpty(str);
        zzkp zzkp2 = new zzkp();
        zzix().beginTransaction();
        try {
            zzdy zzbc = zzix().zzbc(str3);
            if (zzbc == null) {
                zzge().zzis().zzg("Log and bundle not available. package_name", str3);
            } else if (!zzbc.isMeasurementEnabled()) {
                zzge().zzis().zzg("Log and bundle disabled. package_name", str3);
            } else {
                if (("_iap".equals(zzeu2.name) || "ecommerce_purchase".equals(zzeu2.name)) && !zza(str3, zzeu2)) {
                    zzge().zzip().zzg("Failed to handle purchase event at single event bundle creation. appId", zzfg.zzbm(str));
                }
                boolean zzav = zzgg().zzav(str3);
                Long l = 0L;
                if (zzav && "_e".equals(zzeu2.name)) {
                    if (zzeu2.zzafq != null) {
                        if (zzeu2.zzafq.size() != 0) {
                            if (zzeu2.zzafq.getLong("_et") == null) {
                                zzip = zzge().zzip();
                                str2 = "The engagement event does not include duration. appId";
                                zzbm = zzfg.zzbm(str);
                                zzip.zzg(str2, zzbm);
                            } else {
                                l = zzeu2.zzafq.getLong("_et");
                            }
                        }
                    }
                    zzip = zzge().zzip();
                    str2 = "The engagement event does not contain any parameters. appId";
                    zzbm = zzfg.zzbm(str);
                    zzip.zzg(str2, zzbm);
                }
                zzkq zzkq2 = new zzkq();
                zzkp2.zzatf = new zzkq[]{zzkq2};
                zzkq2.zzath = 1;
                zzkq2.zzatp = "android";
                zzkq2.zzti = zzbc.zzah();
                zzkq2.zzadt = zzbc.zzgn();
                zzkq2.zzth = zzbc.zzag();
                long zzgm = zzbc.zzgm();
                zzkq2.zzaub = zzgm == -2147483648L ? null : Integer.valueOf((int) zzgm);
                zzkq2.zzatt = Long.valueOf(zzbc.zzgo());
                zzkq2.zzadm = zzbc.getGmpAppId();
                zzkq2.zzatx = Long.valueOf(zzbc.zzgp());
                if (this.zzacw.isEnabled() && zzef.zzhk() && zzgg().zzat(zzkq2.zzti)) {
                    zzkq2.zzauh = null;
                }
                Pair<String, Boolean> zzbo = zzgf().zzbo(zzbc.zzah());
                if (zzbc.zzhd() && zzbo != null && !TextUtils.isEmpty((CharSequence) zzbo.first)) {
                    zzkq2.zzatv = (String) zzbo.first;
                    zzkq2.zzatw = (Boolean) zzbo.second;
                }
                zzfw().zzch();
                zzkq2.zzatr = Build.MODEL;
                zzfw().zzch();
                zzkq2.zzatq = Build.VERSION.RELEASE;
                zzkq2.zzats = Integer.valueOf((int) zzfw().zzic());
                zzkq2.zzafn = zzfw().zzid();
                zzkq2.zzadl = zzbc.getAppInstanceId();
                zzkq2.zzado = zzbc.zzgj();
                List<zzjz> zzbb = zzix().zzbb(zzbc.zzah());
                zzkq2.zzatj = new zzks[zzbb.size()];
                if (zzav) {
                    zzjz = zzix().zzh(zzkq2.zzti, "_lte");
                    if (zzjz != null) {
                        if (zzjz.value != null) {
                            if (l.longValue() > 0) {
                                zzjz = new zzjz(zzkq2.zzti, "auto", "_lte", zzbt().currentTimeMillis(), Long.valueOf(((Long) zzjz.value).longValue() + l.longValue()));
                            }
                        }
                    }
                    zzjz = new zzjz(zzkq2.zzti, "auto", "_lte", zzbt().currentTimeMillis(), l);
                } else {
                    zzjz = null;
                }
                int i = 0;
                zzks zzks = null;
                while (i < zzbb.size()) {
                    zzks zzks2 = new zzks();
                    zzkq2.zzatj[i] = zzks2;
                    zzks2.name = zzbb.get(i).name;
                    zzdy zzdy2 = zzbc;
                    zzkp zzkp3 = zzkp2;
                    zzks2.zzaun = Long.valueOf(zzbb.get(i).zzaqz);
                    zzgb().zza(zzks2, zzbb.get(i).value);
                    if (zzav && "_lte".equals(zzks2.name)) {
                        zzks2.zzate = (Long) zzjz.value;
                        zzks2.zzaun = Long.valueOf(zzbt().currentTimeMillis());
                        zzks = zzks2;
                    }
                    i++;
                    zzkp2 = zzkp3;
                    zzbc = zzdy2;
                }
                zzdy zzdy3 = zzbc;
                zzkp zzkp4 = zzkp2;
                if (zzav && zzks == null) {
                    zzks zzks3 = new zzks();
                    zzks3.name = "_lte";
                    zzks3.zzaun = Long.valueOf(zzbt().currentTimeMillis());
                    zzks3.zzate = (Long) zzjz.value;
                    zzkq2.zzatj = (zzks[]) Arrays.copyOf(zzkq2.zzatj, zzkq2.zzatj.length + 1);
                    zzkq2.zzatj[zzkq2.zzatj.length - 1] = zzks3;
                }
                if (l.longValue() > 0) {
                    zzix().zza(zzjz);
                }
                Bundle zzif = zzeu2.zzafq.zzif();
                if ("_iap".equals(zzeu2.name)) {
                    zzif.putLong("_c", 1);
                    zzge().zzis().log("Marking in-app purchase as real-time");
                    zzif.putLong("_r", 1);
                }
                zzif.putString("_o", zzeu2.origin);
                if (zzgb().zzcj(zzkq2.zzti)) {
                    zzgb().zza(zzif, "_dbg", (Object) 1L);
                    zzgb().zza(zzif, "_r", (Object) 1L);
                }
                zzeq zzf = zzix().zzf(str3, zzeu2.name);
                if (zzf == null) {
                    bArr = null;
                    zzkq = zzkq2;
                    zzeq zzeq = r2;
                    zzdy = zzdy3;
                    zzkp = zzkp4;
                    bundle = zzif;
                    zzeq zzeq2 = new zzeq(str, zzeu2.name, 1, 0, zzeu2.zzagb, 0, null, null, null);
                    zzix().zza(zzeq);
                    j = 0;
                } else {
                    zzkq = zzkq2;
                    zzkp = zzkp4;
                    zzdy = zzdy3;
                    bArr = null;
                    bundle = zzif;
                    long j2 = zzf.zzaft;
                    zzix().zza(zzf.zzac(zzeu2.zzagb).zzie());
                    j = j2;
                }
                zzep zzep = new zzep(this.zzacw, zzeu2.origin, str, zzeu2.name, zzeu2.zzagb, j, bundle);
                zzkn zzkn = new zzkn();
                zzkq zzkq3 = zzkq;
                zzkq3.zzati = new zzkn[]{zzkn};
                zzkn.zzatb = Long.valueOf(zzep.timestamp);
                zzkn.name = zzep.name;
                zzkn.zzatc = Long.valueOf(zzep.zzafp);
                zzkn.zzata = new zzko[zzep.zzafq.size()];
                Iterator<String> it = zzep.zzafq.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    zzko zzko = new zzko();
                    zzkn.zzata[i2] = zzko;
                    zzko.name = next;
                    zzgb().zza(zzko, zzep.zzafq.get(next));
                    i2++;
                }
                zzkq3.zzaua = zza(zzdy.zzah(), zzkq3.zzatj, zzkq3.zzati);
                zzkq3.zzatl = zzkn.zzatb;
                zzkq3.zzatm = zzkn.zzatb;
                long zzgl = zzdy.zzgl();
                zzkq3.zzato = zzgl != 0 ? Long.valueOf(zzgl) : bArr;
                long zzgk = zzdy.zzgk();
                if (zzgk != 0) {
                    zzgl = zzgk;
                }
                zzkq3.zzatn = zzgl != 0 ? Long.valueOf(zzgl) : bArr;
                zzdy.zzgt();
                zzkq3.zzaty = Integer.valueOf((int) zzdy.zzgq());
                zzkq3.zzatu = 12451L;
                zzkq3.zzatk = Long.valueOf(zzbt().currentTimeMillis());
                zzkq3.zzatz = Boolean.TRUE;
                zzdy zzdy4 = zzdy;
                zzdy4.zzm(zzkq3.zzatl.longValue());
                zzdy4.zzn(zzkq3.zzatm.longValue());
                zzix().zza(zzdy4);
                zzix().setTransactionSuccessful();
                zzix().endTransaction();
                try {
                    byte[] bArr2 = new byte[zzkp.zzvm()];
                    zzabw zzb = zzabw.zzb(bArr2, 0, bArr2.length);
                    zzkp.zza(zzb);
                    zzb.zzve();
                    return zzgb().zza(bArr2);
                } catch (IOException e) {
                    zzge().zzim().zze("Data loss. Failed to bundle and serialize. appId", zzfg.zzbm(str), e);
                    return bArr;
                }
            }
            return new byte[0];
        } finally {
            zzix().endTransaction();
        }
    }

    public void zzab() {
        zzgd().zzab();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzed zzed, zzdz zzdz) {
        zzfi zzim;
        String str;
        Object zzbm;
        String zzbl;
        Object value;
        zzfi zzim2;
        String str2;
        Object zzbm2;
        String zzbl2;
        Object obj;
        Preconditions.checkNotNull(zzed);
        Preconditions.checkNotEmpty(zzed.packageName);
        Preconditions.checkNotNull(zzed.origin);
        Preconditions.checkNotNull(zzed.zzaep);
        Preconditions.checkNotEmpty(zzed.zzaep.name);
        zzab();
        zzkq();
        if (!TextUtils.isEmpty(zzdz.zzadm)) {
            if (!zzdz.zzadw) {
                zzg(zzdz);
                return;
            }
            zzed zzed2 = new zzed(zzed);
            boolean z = false;
            zzed2.active = false;
            zzix().beginTransaction();
            try {
                zzed zzi = zzix().zzi(zzed2.packageName, zzed2.zzaep.name);
                if (zzi != null && !zzi.origin.equals(zzed2.origin)) {
                    zzge().zzip().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", zzga().zzbl(zzed2.zzaep.name), zzed2.origin, zzi.origin);
                }
                if (zzi != null && zzi.active) {
                    zzed2.origin = zzi.origin;
                    zzed2.creationTimestamp = zzi.creationTimestamp;
                    zzed2.triggerTimeout = zzi.triggerTimeout;
                    zzed2.triggerEventName = zzi.triggerEventName;
                    zzed2.zzaer = zzi.zzaer;
                    zzed2.active = zzi.active;
                    zzed2.zzaep = new zzjx(zzed2.zzaep.name, zzi.zzaep.zzaqz, zzed2.zzaep.getValue(), zzi.zzaep.origin);
                } else if (TextUtils.isEmpty(zzed2.triggerEventName)) {
                    zzed2.zzaep = new zzjx(zzed2.zzaep.name, zzed2.creationTimestamp, zzed2.zzaep.getValue(), zzed2.zzaep.origin);
                    zzed2.active = true;
                    z = true;
                }
                if (zzed2.active) {
                    zzjx zzjx = zzed2.zzaep;
                    zzjz zzjz = new zzjz(zzed2.packageName, zzed2.origin, zzjx.name, zzjx.zzaqz, zzjx.getValue());
                    if (zzix().zza(zzjz)) {
                        zzim2 = zzge().zzis();
                        str2 = "User property updated immediately";
                        zzbm2 = zzed2.packageName;
                        zzbl2 = zzga().zzbl(zzjz.name);
                        obj = zzjz.value;
                    } else {
                        zzim2 = zzge().zzim();
                        str2 = "(2)Too many active user properties, ignoring";
                        zzbm2 = zzfg.zzbm(zzed2.packageName);
                        zzbl2 = zzga().zzbl(zzjz.name);
                        obj = zzjz.value;
                    }
                    zzim2.zzd(str2, zzbm2, zzbl2, obj);
                    if (z && zzed2.zzaer != null) {
                        zzc(new zzeu(zzed2.zzaer, zzed2.creationTimestamp), zzdz);
                    }
                }
                if (zzix().zza(zzed2)) {
                    zzim = zzge().zzis();
                    str = "Conditional property added";
                    zzbm = zzed2.packageName;
                    zzbl = zzga().zzbl(zzed2.zzaep.name);
                    value = zzed2.zzaep.getValue();
                } else {
                    zzim = zzge().zzim();
                    str = "Too many conditional properties, ignoring";
                    zzbm = zzfg.zzbm(zzed2.packageName);
                    zzbl = zzga().zzbl(zzed2.zzaep.name);
                    value = zzed2.zzaep.getValue();
                }
                zzim.zzd(str, zzbm, zzbl, value);
                zzix().setTransactionSuccessful();
            } finally {
                zzix().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzeu zzeu, zzdz zzdz) {
        List<zzed> list;
        List<zzed> list2;
        List<zzed> list3;
        zzfi zzim;
        String str;
        Object zzbm;
        String zzbl;
        Object obj;
        zzeu zzeu2 = zzeu;
        zzdz zzdz2 = zzdz;
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz2.packageName);
        zzab();
        zzkq();
        String str2 = zzdz2.packageName;
        long j = zzeu2.zzagb;
        zzgb();
        if (zzka.zzd(zzeu, zzdz)) {
            if (!zzdz2.zzadw) {
                zzg(zzdz2);
                return;
            }
            zzix().beginTransaction();
            try {
                zzei zzix = zzix();
                Preconditions.checkNotEmpty(str2);
                zzix.zzab();
                zzix.zzch();
                if (j < 0) {
                    zzix.zzge().zzip().zze("Invalid time querying timed out conditional properties", zzfg.zzbm(str2), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzix.zzb("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzed zzed : list) {
                    if (zzed != null) {
                        zzge().zzis().zzd("User property timed out", zzed.packageName, zzga().zzbl(zzed.zzaep.name), zzed.zzaep.getValue());
                        if (zzed.zzaeq != null) {
                            zzc(new zzeu(zzed.zzaeq, j), zzdz2);
                        }
                        zzix().zzj(str2, zzed.zzaep.name);
                    }
                }
                zzei zzix2 = zzix();
                Preconditions.checkNotEmpty(str2);
                zzix2.zzab();
                zzix2.zzch();
                if (j < 0) {
                    zzix2.zzge().zzip().zze("Invalid time querying expired conditional properties", zzfg.zzbm(str2), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzix2.zzb("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzed zzed2 : list2) {
                    if (zzed2 != null) {
                        zzge().zzis().zzd("User property expired", zzed2.packageName, zzga().zzbl(zzed2.zzaep.name), zzed2.zzaep.getValue());
                        zzix().zzg(str2, zzed2.zzaep.name);
                        if (zzed2.zzaes != null) {
                            arrayList.add(zzed2.zzaes);
                        }
                        zzix().zzj(str2, zzed2.zzaep.name);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList2.get(i);
                    i++;
                    zzc(new zzeu((zzeu) obj2, j), zzdz2);
                }
                zzei zzix3 = zzix();
                String str3 = zzeu2.name;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                zzix3.zzab();
                zzix3.zzch();
                if (j < 0) {
                    zzix3.zzge().zzip().zzd("Invalid time querying triggered conditional properties", zzfg.zzbm(str2), zzix3.zzga().zzbj(str3), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzix3.zzb("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzed zzed3 : list3) {
                    if (zzed3 != null) {
                        zzjx zzjx = zzed3.zzaep;
                        zzjz zzjz = r4;
                        zzjz zzjz2 = new zzjz(zzed3.packageName, zzed3.origin, zzjx.name, j, zzjx.getValue());
                        if (zzix().zza(zzjz)) {
                            zzim = zzge().zzis();
                            str = "User property triggered";
                            zzbm = zzed3.packageName;
                            zzbl = zzga().zzbl(zzjz.name);
                            obj = zzjz.value;
                        } else {
                            zzim = zzge().zzim();
                            str = "Too many active user properties, ignoring";
                            zzbm = zzfg.zzbm(zzed3.packageName);
                            zzbl = zzga().zzbl(zzjz.name);
                            obj = zzjz.value;
                        }
                        zzim.zzd(str, zzbm, zzbl, obj);
                        if (zzed3.zzaer != null) {
                            arrayList3.add(zzed3.zzaer);
                        }
                        zzed3.zzaep = new zzjx(zzjz);
                        zzed3.active = true;
                        zzix().zza(zzed3);
                    }
                }
                zzc(zzeu, zzdz);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj3 = arrayList4.get(i2);
                    i2++;
                    zzc(new zzeu((zzeu) obj3, j), zzdz2);
                }
                zzix().setTransactionSuccessful();
            } finally {
                zzix().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzjq zzjq) {
        this.zzaqj++;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, boolean):java.lang.String
     arg types: [java.lang.String, int, int]
     candidates:
      com.google.android.gms.internal.measurement.zzka.zza(int, java.lang.Object, boolean):java.lang.Object
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String[]):java.lang.String
      com.google.android.gms.internal.measurement.zzka.zza(com.google.android.gms.internal.measurement.zzko[], java.lang.String, java.lang.Object):com.google.android.gms.internal.measurement.zzko[]
      com.google.android.gms.internal.measurement.zzka.zza(android.os.Bundle, java.lang.String, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, boolean):java.lang.String */
    /* access modifiers changed from: package-private */
    public final void zzb(zzjx zzjx, zzdz zzdz) {
        zzab();
        zzkq();
        if (!TextUtils.isEmpty(zzdz.zzadm)) {
            if (!zzdz.zzadw) {
                zzg(zzdz);
                return;
            }
            int zzcf = zzgb().zzcf(zzjx.name);
            if (zzcf != 0) {
                zzgb();
                zzgb().zza(zzdz.packageName, zzcf, "_ev", zzka.zza(zzjx.name, 24, true), zzjx.name != null ? zzjx.name.length() : 0);
                return;
            }
            int zzi = zzgb().zzi(zzjx.name, zzjx.getValue());
            if (zzi != 0) {
                zzgb();
                String zza = zzka.zza(zzjx.name, 24, true);
                Object value = zzjx.getValue();
                zzgb().zza(zzdz.packageName, zzi, "_ev", zza, (value == null || (!(value instanceof String) && !(value instanceof CharSequence))) ? 0 : String.valueOf(value).length());
                return;
            }
            Object zzj = zzgb().zzj(zzjx.name, zzjx.getValue());
            if (zzj != null) {
                zzjz zzjz = new zzjz(zzdz.packageName, zzjx.origin, zzjx.name, zzjx.zzaqz, zzj);
                zzge().zzis().zze("Setting user property", zzga().zzbl(zzjz.name), zzj);
                zzix().beginTransaction();
                try {
                    zzg(zzdz);
                    boolean zza2 = zzix().zza(zzjz);
                    zzix().setTransactionSuccessful();
                    if (zza2) {
                        zzge().zzis().zze("User property set", zzga().zzbl(zzjz.name), zzjz.value);
                    } else {
                        zzge().zzim().zze("Too many unique user properties are set. Ignoring user property", zzga().zzbl(zzjz.name), zzjz.value);
                        zzgb().zza(zzdz.packageName, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zzix().endTransaction();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0120 A[Catch:{ all -> 0x0163, all -> 0x016c }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012e A[Catch:{ all -> 0x0163, all -> 0x016c }] */
    @VisibleForTesting
    public final void zzb(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        zzei zzix;
        zzab();
        zzkq();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzaql = false;
                zzkv();
                throw th2;
            }
        }
        zzge().zzit().zzg("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zzix().beginTransaction();
        zzdy zzbc = zzix().zzbc(str);
        boolean z = true;
        boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
        if (zzbc == null) {
            zzge().zzip().zzg("App does not exist in onConfigFetched. appId", zzfg.zzbm(str));
            zzix().setTransactionSuccessful();
            zzix = zzix();
        } else {
            if (!z2) {
                if (i != 404) {
                    zzbc.zzt(zzbt().currentTimeMillis());
                    zzix().zza(zzbc);
                    zzge().zzit().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
                    zzkm().zzbw(str);
                    zzgf().zzajv.set(zzbt().currentTimeMillis());
                    if (i != 503) {
                        if (i != 429) {
                            z = false;
                        }
                    }
                    if (z) {
                        zzgf().zzajw.set(zzbt().currentTimeMillis());
                    }
                    zzku();
                    zzix().setTransactionSuccessful();
                    zzix = zzix();
                }
            }
            List list = map != null ? map.get("Last-Modified") : null;
            String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
            if (i != 404) {
                if (i != 304) {
                    if (!zzkm().zza(str, bArr, str2)) {
                        zzix = zzix();
                    }
                    zzbc.zzs(zzbt().currentTimeMillis());
                    zzix().zza(zzbc);
                    if (i != 404) {
                        zzge().zziq().zzg("Config not found. Using empty config. appId", str);
                    } else {
                        zzge().zzit().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                    }
                    if (zzkn().zzex() && zzkt()) {
                        zzks();
                        zzix().setTransactionSuccessful();
                        zzix = zzix();
                    }
                    zzku();
                    zzix().setTransactionSuccessful();
                    zzix = zzix();
                }
            }
            if (zzkm().zzbu(str) == null && !zzkm().zza(str, null, null)) {
                zzix = zzix();
            }
            zzbc.zzs(zzbt().currentTimeMillis());
            zzix().zza(zzbc);
            if (i != 404) {
            }
            zzks();
            zzix().setTransactionSuccessful();
            zzix = zzix();
        }
        zzix.endTransaction();
        this.zzaql = false;
        zzkv();
    }

    public Clock zzbt() {
        return this.zzacw.zzbt();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzed zzed, zzdz zzdz) {
        Preconditions.checkNotNull(zzed);
        Preconditions.checkNotEmpty(zzed.packageName);
        Preconditions.checkNotNull(zzed.zzaep);
        Preconditions.checkNotEmpty(zzed.zzaep.name);
        zzab();
        zzkq();
        if (!TextUtils.isEmpty(zzdz.zzadm)) {
            if (!zzdz.zzadw) {
                zzg(zzdz);
                return;
            }
            zzix().beginTransaction();
            try {
                zzg(zzdz);
                zzed zzi = zzix().zzi(zzed.packageName, zzed.zzaep.name);
                if (zzi != null) {
                    zzge().zzis().zze("Removing conditional user property", zzed.packageName, zzga().zzbl(zzed.zzaep.name));
                    zzix().zzj(zzed.packageName, zzed.zzaep.name);
                    if (zzi.active) {
                        zzix().zzg(zzed.packageName, zzed.zzaep.name);
                    }
                    if (zzed.zzaes != null) {
                        Bundle bundle = null;
                        if (zzed.zzaes.zzafq != null) {
                            bundle = zzed.zzaes.zzafq.zzif();
                        }
                        Bundle bundle2 = bundle;
                        zzc(zzgb().zza(zzed.zzaes.name, bundle2, zzi.origin, zzed.zzaes.zzagb, true, false), zzdz);
                    }
                } else {
                    zzge().zzip().zze("Conditional user property doesn't exist", zzfg.zzbm(zzed.packageName), zzga().zzbl(zzed.zzaep.name));
                }
                zzix().setTransactionSuccessful();
            } finally {
                zzix().endTransaction();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzdz.<init>(java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, java.lang.String, boolean, boolean, java.lang.String, long, long, int, boolean, boolean, boolean):void
     arg types: [java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, ?[OBJECT, ARRAY], boolean, int, java.lang.String, long, int, int, boolean, boolean, int]
     candidates:
      com.google.android.gms.internal.measurement.zzdz.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, boolean, boolean, long, java.lang.String, long, long, int, boolean, boolean, boolean):void
      com.google.android.gms.internal.measurement.zzdz.<init>(java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, java.lang.String, boolean, boolean, java.lang.String, long, long, int, boolean, boolean, boolean):void */
    /* access modifiers changed from: package-private */
    public final void zzc(zzeu zzeu, String str) {
        zzeu zzeu2 = zzeu;
        String str2 = str;
        zzdy zzbc = zzix().zzbc(str2);
        if (zzbc == null || TextUtils.isEmpty(zzbc.zzag())) {
            zzge().zzis().zzg("No app data available; dropping event", str2);
            return;
        }
        Boolean zzc = zzc(zzbc);
        if (zzc == null) {
            if (!"_ui".equals(zzeu2.name)) {
                zzge().zzip().zzg("Could not find package. appId", zzfg.zzbm(str));
            }
        } else if (!zzc.booleanValue()) {
            zzge().zzim().zzg("App version does not match; dropping event. appId", zzfg.zzbm(str));
            return;
        }
        zzdz zzdz = r2;
        zzdy zzdy = zzbc;
        zzdz zzdz2 = new zzdz(str, zzbc.getGmpAppId(), zzbc.zzag(), zzbc.zzgm(), zzbc.zzgn(), zzbc.zzgo(), zzbc.zzgp(), (String) null, zzbc.isMeasurementEnabled(), false, zzdy.zzgj(), zzdy.zzhc(), 0L, 0, zzdy.zzhd(), zzdy.zzhe(), false);
        zzb(zzeu2, zzdz);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzjx zzjx, zzdz zzdz) {
        zzab();
        zzkq();
        if (!TextUtils.isEmpty(zzdz.zzadm)) {
            if (!zzdz.zzadw) {
                zzg(zzdz);
                return;
            }
            zzge().zzis().zzg("Removing user property", zzga().zzbl(zzjx.name));
            zzix().beginTransaction();
            try {
                zzg(zzdz);
                zzix().zzg(zzdz.packageName, zzjx.name);
                zzix().setTransactionSuccessful();
                zzge().zzis().zzg("User property removed", zzga().zzbl(zzjx.name));
            } finally {
                zzix().endTransaction();
            }
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzdz.<init>(java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, java.lang.String, boolean, boolean, java.lang.String, long, long, int, boolean, boolean, boolean):void
     arg types: [java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, ?[OBJECT, ARRAY], boolean, int, java.lang.String, long, int, int, boolean, boolean, int]
     candidates:
      com.google.android.gms.internal.measurement.zzdz.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, boolean, boolean, long, java.lang.String, long, long, int, boolean, boolean, boolean):void
      com.google.android.gms.internal.measurement.zzdz.<init>(java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, long, long, java.lang.String, boolean, boolean, java.lang.String, long, long, int, boolean, boolean, boolean):void */
    /* access modifiers changed from: package-private */
    public final zzdz zzcb(String str) {
        zzfi zzis;
        String str2;
        Object obj;
        String str3 = str;
        zzdy zzbc = zzix().zzbc(str3);
        if (zzbc == null || TextUtils.isEmpty(zzbc.zzag())) {
            zzis = zzge().zzis();
            str2 = "No app data available; dropping";
            obj = str3;
        } else {
            Boolean zzc = zzc(zzbc);
            if (zzc == null || zzc.booleanValue()) {
                zzdy zzdy = zzbc;
                return new zzdz(str, zzbc.getGmpAppId(), zzbc.zzag(), zzbc.zzgm(), zzbc.zzgn(), zzbc.zzgo(), zzbc.zzgp(), (String) null, zzbc.isMeasurementEnabled(), false, zzbc.zzgj(), zzbc.zzhc(), 0L, 0, zzdy.zzhd(), zzdy.zzhe(), false);
            }
            zzis = zzge().zzim();
            str2 = "App version does not match; dropping. appId";
            obj = zzfg.zzbm(str);
        }
        zzis.zzg(str2, obj);
        return null;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzd(zzdz zzdz) {
        if (this.zzaqq != null) {
            this.zzaqr = new ArrayList();
            this.zzaqr.addAll(this.zzaqq);
        }
        zzei zzix = zzix();
        String str = zzdz.packageName;
        Preconditions.checkNotEmpty(str);
        zzix.zzab();
        zzix.zzch();
        try {
            SQLiteDatabase writableDatabase = zzix.getWritableDatabase();
            String[] strArr = {str};
            int delete = writableDatabase.delete("apps", "app_id=?", strArr) + 0 + writableDatabase.delete("events", "app_id=?", strArr) + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("queue", "app_id=?", strArr) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + writableDatabase.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzix.zzge().zzit().zze("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzix.zzge().zzim().zze("Error resetting analytics data. appId, error", zzfg.zzbm(str), e);
        }
        zzdz zza = zza(getContext(), zzdz.packageName, zzdz.zzadm, zzdz.zzadw, zzdz.zzady, zzdz.zzadz, zzdz.zzaem);
        if (!zzgg().zzaz(zzdz.packageName) || zzdz.zzadw) {
            zzf(zza);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzdz zzdz) {
        zzab();
        zzkq();
        Preconditions.checkNotEmpty(zzdz.packageName);
        zzg(zzdz);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x02d6 A[Catch:{ SQLiteException -> 0x0134, all -> 0x03b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0303 A[Catch:{ SQLiteException -> 0x0134, all -> 0x03b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0387 A[Catch:{ SQLiteException -> 0x0134, all -> 0x03b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01bc A[Catch:{ SQLiteException -> 0x0134, all -> 0x03b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01c9 A[Catch:{ SQLiteException -> 0x0134, all -> 0x03b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01d7 A[Catch:{ SQLiteException -> 0x0134, all -> 0x03b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0291 A[Catch:{ SQLiteException -> 0x0134, all -> 0x03b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0296 A[Catch:{ SQLiteException -> 0x0134, all -> 0x03b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x029d A[Catch:{ SQLiteException -> 0x0134, all -> 0x03b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x029f A[Catch:{ SQLiteException -> 0x0134, all -> 0x03b3 }] */
    public final void zzf(zzdz zzdz) {
        zzdy zzbc;
        int i;
        zzeq zzeq;
        zzeu zzeu;
        zzeu zzeu2;
        long zzm;
        int i2;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        boolean z;
        zzei zzix;
        String str;
        String str2;
        zzeu zzeu3;
        zzei zzix2;
        String zzah;
        zzdz zzdz2 = zzdz;
        zzab();
        zzkq();
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz2.packageName);
        if (!TextUtils.isEmpty(zzdz2.zzadm)) {
            zzdy zzbc2 = zzix().zzbc(zzdz2.packageName);
            if (zzbc2 != null && TextUtils.isEmpty(zzbc2.getGmpAppId()) && !TextUtils.isEmpty(zzdz2.zzadm)) {
                zzbc2.zzs(0);
                zzix().zza(zzbc2);
                zzkm().zzbx(zzdz2.packageName);
            }
            if (!zzdz2.zzadw) {
                zzg(zzdz);
                return;
            }
            long j = zzdz2.zzaem;
            if (j == 0) {
                j = zzbt().currentTimeMillis();
            }
            int i3 = zzdz2.zzaen;
            if (!(i3 == 0 || i3 == 1)) {
                zzge().zzip().zze("Incorrect app type, assuming installed app. appId, appType", zzfg.zzbm(zzdz2.packageName), Integer.valueOf(i3));
                i3 = 0;
            }
            zzix().beginTransaction();
            try {
                zzbc = zzix().zzbc(zzdz2.packageName);
                if (!(zzbc == null || zzbc.getGmpAppId() == null || zzbc.getGmpAppId().equals(zzdz2.zzadm))) {
                    zzge().zzip().zzg("New GMP App Id passed in. Removing cached database data. appId", zzfg.zzbm(zzbc.zzah()));
                    zzix2 = zzix();
                    zzah = zzbc.zzah();
                    zzix2.zzch();
                    zzix2.zzab();
                    Preconditions.checkNotEmpty(zzah);
                    SQLiteDatabase writableDatabase = zzix2.getWritableDatabase();
                    String[] strArr = {zzah};
                    int delete = writableDatabase.delete("events", "app_id=?", strArr) + 0 + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("apps", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("event_filters", "app_id=?", strArr) + writableDatabase.delete("property_filters", "app_id=?", strArr) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr);
                    if (delete > 0) {
                        zzix2.zzge().zzit().zze("Deleted application data. app, records", zzah, Integer.valueOf(delete));
                    }
                    zzbc = null;
                }
            } catch (SQLiteException e) {
                zzix2.zzge().zzim().zze("Error deleting application data. appId, error", zzfg.zzbm(zzah), e);
            } catch (Throwable th) {
                zzix().endTransaction();
                throw th;
            }
            if (zzbc != null) {
                if (zzbc.zzgm() == -2147483648L) {
                    i = 1;
                    if (zzbc.zzag() != null && !zzbc.zzag().equals(zzdz2.zzth)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("_pv", zzbc.zzag());
                        zzeu3 = new zzeu("_au", new zzer(bundle), "auto", j);
                    }
                    zzg(zzdz);
                    if (i3 == 0) {
                        zzix = zzix();
                        str = zzdz2.packageName;
                        str2 = "_f";
                    } else if (i3 == i) {
                        zzix = zzix();
                        str = zzdz2.packageName;
                        str2 = "_v";
                    } else {
                        zzeq = null;
                        if (zzeq != null) {
                            long j2 = j;
                            long j3 = ((j / 3600000) + 1) * 3600000;
                            if (i3 == 0) {
                                zzb(new zzjx("_fot", j2, Long.valueOf(j3), "auto"), zzdz2);
                                zzab();
                                zzkq();
                                Bundle bundle2 = new Bundle();
                                bundle2.putLong("_c", 1);
                                bundle2.putLong("_r", 1);
                                bundle2.putLong("_uwa", 0);
                                bundle2.putLong("_pfo", 0);
                                bundle2.putLong("_sys", 0);
                                bundle2.putLong("_sysu", 0);
                                if (zzgg().zzaz(zzdz2.packageName) && zzdz2.zzaeo) {
                                    bundle2.putLong("_dac", 1);
                                }
                                if (getContext().getPackageManager() == null) {
                                    zzge().zzim().zzg("PackageManager is null, first open report might be inaccurate. appId", zzfg.zzbm(zzdz2.packageName));
                                } else {
                                    try {
                                        i2 = 0;
                                        try {
                                            packageInfo = Wrappers.packageManager(getContext()).getPackageInfo(zzdz2.packageName, 0);
                                        } catch (PackageManager.NameNotFoundException e2) {
                                            e = e2;
                                            zzge().zzim().zze("Package info is null, first open report might be inaccurate. appId", zzfg.zzbm(zzdz2.packageName), e);
                                            packageInfo = null;
                                            if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                            }
                                            zzb(new zzjx("_fi", j2, Long.valueOf(z ? 1 : 0), "auto"), zzdz2);
                                            applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(zzdz2.packageName, i2);
                                            if (applicationInfo != null) {
                                            }
                                            zzei zzix3 = zzix();
                                            String str3 = zzdz2.packageName;
                                            Preconditions.checkNotEmpty(str3);
                                            zzix3.zzab();
                                            zzix3.zzch();
                                            zzm = zzix3.zzm(str3, "first_open_count");
                                            if (zzm >= 0) {
                                            }
                                            zzeu2 = new zzeu("_f", new zzer(bundle2), "auto", j2);
                                            zzb(zzeu2, zzdz2);
                                            Bundle bundle3 = new Bundle();
                                            bundle3.putLong("_et", 1);
                                            zzeu = new zzeu("_e", new zzer(bundle3), "auto", j2);
                                            zzb(zzeu, zzdz2);
                                            zzix().setTransactionSuccessful();
                                            zzix().endTransaction();
                                        }
                                    } catch (PackageManager.NameNotFoundException e3) {
                                        e = e3;
                                        i2 = 0;
                                        zzge().zzim().zze("Package info is null, first open report might be inaccurate. appId", zzfg.zzbm(zzdz2.packageName), e);
                                        packageInfo = null;
                                        if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                        }
                                        zzb(new zzjx("_fi", j2, Long.valueOf(z ? 1 : 0), "auto"), zzdz2);
                                        applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(zzdz2.packageName, i2);
                                        if (applicationInfo != null) {
                                        }
                                        zzei zzix32 = zzix();
                                        String str32 = zzdz2.packageName;
                                        Preconditions.checkNotEmpty(str32);
                                        zzix32.zzab();
                                        zzix32.zzch();
                                        zzm = zzix32.zzm(str32, "first_open_count");
                                        if (zzm >= 0) {
                                        }
                                        zzeu2 = new zzeu("_f", new zzer(bundle2), "auto", j2);
                                        zzb(zzeu2, zzdz2);
                                        Bundle bundle32 = new Bundle();
                                        bundle32.putLong("_et", 1);
                                        zzeu = new zzeu("_e", new zzer(bundle32), "auto", j2);
                                        zzb(zzeu, zzdz2);
                                        zzix().setTransactionSuccessful();
                                        zzix().endTransaction();
                                    }
                                    if (!(packageInfo == null || packageInfo.firstInstallTime == 0)) {
                                        if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                            bundle2.putLong("_uwa", 1);
                                            z = false;
                                        } else {
                                            z = true;
                                        }
                                        zzb(new zzjx("_fi", j2, Long.valueOf(z ? 1 : 0), "auto"), zzdz2);
                                    }
                                    try {
                                        applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(zzdz2.packageName, i2);
                                    } catch (PackageManager.NameNotFoundException e4) {
                                        zzge().zzim().zze("Application info is null, first open report might be inaccurate. appId", zzfg.zzbm(zzdz2.packageName), e4);
                                        applicationInfo = null;
                                    }
                                    if (applicationInfo != null) {
                                        if ((applicationInfo.flags & 1) != 0) {
                                            bundle2.putLong("_sys", 1);
                                        }
                                        if ((applicationInfo.flags & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                                            bundle2.putLong("_sysu", 1);
                                        }
                                    }
                                }
                                zzei zzix322 = zzix();
                                String str322 = zzdz2.packageName;
                                Preconditions.checkNotEmpty(str322);
                                zzix322.zzab();
                                zzix322.zzch();
                                zzm = zzix322.zzm(str322, "first_open_count");
                                if (zzm >= 0) {
                                    bundle2.putLong("_pfo", zzm);
                                }
                                zzeu2 = new zzeu("_f", new zzer(bundle2), "auto", j2);
                            } else {
                                String str4 = "_c";
                                if (i3 == 1) {
                                    zzb(new zzjx("_fvt", j2, Long.valueOf(j3), "auto"), zzdz2);
                                    zzab();
                                    zzkq();
                                    Bundle bundle4 = new Bundle();
                                    bundle4.putLong(str4, 1);
                                    bundle4.putLong("_r", 1);
                                    if (zzgg().zzaz(zzdz2.packageName) && zzdz2.zzaeo) {
                                        bundle4.putLong("_dac", 1);
                                    }
                                    zzeu2 = new zzeu("_v", new zzer(bundle4), "auto", j2);
                                }
                                Bundle bundle322 = new Bundle();
                                bundle322.putLong("_et", 1);
                                zzeu = new zzeu("_e", new zzer(bundle322), "auto", j2);
                            }
                            zzb(zzeu2, zzdz2);
                            Bundle bundle3222 = new Bundle();
                            bundle3222.putLong("_et", 1);
                            zzeu = new zzeu("_e", new zzer(bundle3222), "auto", j2);
                        } else {
                            long j4 = j;
                            if (zzdz2.zzael) {
                                zzeu = new zzeu("_cd", new zzer(new Bundle()), "auto", j4);
                            }
                            zzix().setTransactionSuccessful();
                            zzix().endTransaction();
                        }
                        zzb(zzeu, zzdz2);
                        zzix().setTransactionSuccessful();
                        zzix().endTransaction();
                    }
                    zzeq = zzix.zzf(str, str2);
                    if (zzeq != null) {
                    }
                    zzb(zzeu, zzdz2);
                    zzix().setTransactionSuccessful();
                    zzix().endTransaction();
                } else if (zzbc.zzgm() != zzdz2.zzads) {
                    Bundle bundle5 = new Bundle();
                    bundle5.putString("_pv", zzbc.zzag());
                    zzer zzer = new zzer(bundle5);
                    i = 1;
                    zzeu3 = new zzeu("_au", zzer, "auto", j);
                }
                zzb(zzeu3, zzdz2);
                zzg(zzdz);
                if (i3 == 0) {
                }
                zzeq = zzix.zzf(str, str2);
                if (zzeq != null) {
                }
                zzb(zzeu, zzdz2);
                zzix().setTransactionSuccessful();
                zzix().endTransaction();
            }
            i = 1;
            zzg(zzdz);
            if (i3 == 0) {
            }
            zzeq = zzix.zzf(str, str2);
            if (zzeq != null) {
            }
            zzb(zzeu, zzdz2);
            zzix().setTransactionSuccessful();
            zzix().endTransaction();
        }
    }

    public zzeo zzfw() {
        return this.zzacw.zzfw();
    }

    /* access modifiers changed from: package-private */
    public final void zzg(Runnable runnable) {
        zzab();
        if (this.zzaqi == null) {
            this.zzaqi = new ArrayList();
        }
        this.zzaqi.add(runnable);
    }

    public zzfe zzga() {
        return this.zzacw.zzga();
    }

    public zzka zzgb() {
        return this.zzacw.zzgb();
    }

    public zzgg zzgd() {
        return this.zzacw.zzgd();
    }

    public zzfg zzge() {
        return this.zzacw.zzge();
    }

    public zzfr zzgf() {
        return this.zzacw.zzgf();
    }

    public zzef zzgg() {
        return this.zzacw.zzgg();
    }

    public final String zzh(zzdz zzdz) {
        try {
            return (String) zzgd().zzb(new zzju(this, zzdz)).get(DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzge().zzim().zze("Failed to get app instance id. appId", zzfg.zzbm(zzdz.packageName), e);
            return null;
        }
    }

    public final zzeb zziw() {
        zza(this.zzaqf);
        return this.zzaqf;
    }

    public final zzei zzix() {
        zza(this.zzaqc);
        return this.zzaqc;
    }

    public final zzfk zzkn() {
        zza(this.zzaqb);
        return this.zzaqb;
    }

    /* access modifiers changed from: package-private */
    public final void zzkq() {
        if (!this.zzvo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:81|82) */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        zzge().zzim().zze("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.internal.measurement.zzfg.zzbm(r5), r6);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0254 */
    public final void zzks() {
        zzdy zzbc;
        String str;
        zzfi zzit;
        String str2;
        zzab();
        zzkq();
        this.zzaqn = true;
        try {
            Boolean zzkf = this.zzacw.zzfx().zzkf();
            if (zzkf == null) {
                zzit = zzge().zzip();
                str2 = "Upload data called on the client side before use of service was decided";
            } else if (zzkf.booleanValue()) {
                zzit = zzge().zzim();
                str2 = "Upload called in the client side when service should be used";
            } else {
                if (this.zzaqh <= 0) {
                    zzab();
                    if (this.zzaqq != null) {
                        zzit = zzge().zzit();
                        str2 = "Uploading requested multiple times";
                    } else if (!zzkn().zzex()) {
                        zzge().zzit().log("Network not connected, ignoring upload request");
                    } else {
                        long currentTimeMillis = zzbt().currentTimeMillis();
                        String str3 = null;
                        zzd(null, currentTimeMillis - zzef.zzhi());
                        long j = zzgf().zzaju.get();
                        if (j != 0) {
                            zzge().zzis().zzg("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
                        }
                        String zzhn = zzix().zzhn();
                        if (!TextUtils.isEmpty(zzhn)) {
                            if (this.zzaqs == -1) {
                                this.zzaqs = zzix().zzhu();
                            }
                            List<Pair<zzkq, Long>> zzb = zzix().zzb(zzhn, zzgg().zzb(zzhn, zzew.zzago), Math.max(0, zzgg().zzb(zzhn, zzew.zzagp)));
                            if (!zzb.isEmpty()) {
                                Iterator<Pair<zzkq, Long>> it = zzb.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        str = null;
                                        break;
                                    }
                                    zzkq zzkq = (zzkq) it.next().first;
                                    if (!TextUtils.isEmpty(zzkq.zzatv)) {
                                        str = zzkq.zzatv;
                                        break;
                                    }
                                }
                                if (str != null) {
                                    int i = 0;
                                    while (true) {
                                        if (i >= zzb.size()) {
                                            break;
                                        }
                                        zzkq zzkq2 = (zzkq) zzb.get(i).first;
                                        if (!TextUtils.isEmpty(zzkq2.zzatv) && !zzkq2.zzatv.equals(str)) {
                                            zzb = zzb.subList(0, i);
                                            break;
                                        }
                                        i++;
                                    }
                                }
                                zzkp zzkp = new zzkp();
                                zzkp.zzatf = new zzkq[zzb.size()];
                                ArrayList arrayList = new ArrayList(zzb.size());
                                boolean z = zzef.zzhk() && zzgg().zzat(zzhn);
                                for (int i2 = 0; i2 < zzkp.zzatf.length; i2++) {
                                    zzkp.zzatf[i2] = (zzkq) zzb.get(i2).first;
                                    arrayList.add((Long) zzb.get(i2).second);
                                    zzkp.zzatf[i2].zzatu = 12451L;
                                    zzkp.zzatf[i2].zzatk = Long.valueOf(currentTimeMillis);
                                    zzkp.zzatf[i2].zzatz = Boolean.FALSE;
                                    if (!z) {
                                        zzkp.zzatf[i2].zzauh = null;
                                    }
                                }
                                if (zzge().isLoggable(2)) {
                                    str3 = zzga().zza(zzkp);
                                }
                                byte[] zzb2 = zzgb().zzb(zzkp);
                                String str4 = zzew.zzagy.get();
                                URL url = new URL(str4);
                                Preconditions.checkArgument(!arrayList.isEmpty());
                                if (this.zzaqq != null) {
                                    zzge().zzim().log("Set uploading progress before finishing the previous upload");
                                } else {
                                    this.zzaqq = new ArrayList(arrayList);
                                }
                                zzgf().zzajv.set(currentTimeMillis);
                                String str5 = "?";
                                if (zzkp.zzatf.length > 0) {
                                    str5 = zzkp.zzatf[0].zzti;
                                }
                                zzge().zzit().zzd("Uploading data. app, uncompressed size, data", str5, Integer.valueOf(zzb2.length), str3);
                                this.zzaqm = true;
                                zzfk zzkn = zzkn();
                                zzjs zzjs = new zzjs(this, zzhn);
                                zzkn.zzab();
                                zzkn.zzch();
                                Preconditions.checkNotNull(url);
                                Preconditions.checkNotNull(zzb2);
                                Preconditions.checkNotNull(zzjs);
                                zzkn.zzgd().zzd(new zzfo(zzkn, zzhn, url, zzb2, null, zzjs));
                            }
                        } else {
                            this.zzaqs = -1;
                            String zzab = zzix().zzab(currentTimeMillis - zzef.zzhi());
                            if (!TextUtils.isEmpty(zzab) && (zzbc = zzix().zzbc(zzab)) != null) {
                                zzb(zzbc);
                            }
                        }
                    }
                }
                zzku();
            }
            zzit.log(str2);
        } finally {
            this.zzaqn = false;
            zzkv();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzkx() {
        zzfi zzim;
        Integer valueOf;
        Integer valueOf2;
        String str;
        zzab();
        zzkq();
        if (!this.zzaqg) {
            zzge().zzir().log("This instance being marked as an uploader");
            zzab();
            zzkq();
            if (zzky() && zzkw()) {
                int zza = zza(this.zzaqp);
                int zzij = this.zzacw.zzfv().zzij();
                zzab();
                if (zza > zzij) {
                    zzim = zzge().zzim();
                    valueOf = Integer.valueOf(zza);
                    valueOf2 = Integer.valueOf(zzij);
                    str = "Panic: can't downgrade version. Previous, current version";
                } else if (zza < zzij) {
                    if (zza(zzij, this.zzaqp)) {
                        zzim = zzge().zzit();
                        valueOf = Integer.valueOf(zza);
                        valueOf2 = Integer.valueOf(zzij);
                        str = "Storage version upgraded. Previous, current version";
                    } else {
                        zzim = zzge().zzim();
                        valueOf = Integer.valueOf(zza);
                        valueOf2 = Integer.valueOf(zzij);
                        str = "Storage version upgrade failed. Previous, current version";
                    }
                }
                zzim.zze(str, valueOf, valueOf2);
            }
            this.zzaqg = true;
            zzku();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzkz() {
        this.zzaqk++;
    }

    /* access modifiers changed from: package-private */
    public final zzgl zzla() {
        return this.zzacw;
    }

    public final void zzm(boolean z) {
        zzku();
    }
}
