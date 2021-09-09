package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FirebaseInstanceId {
    private static final long zzah = TimeUnit.HOURS.toSeconds(8);
    private static zzao zzai;
    @VisibleForTesting
    private static ScheduledThreadPoolExecutor zzaj;
    private final FirebaseApp zzak;
    private final zzae zzal;
    private final zzo zzam;
    private final zzah zzan;
    private boolean zzao;
    private boolean zzap;

    FirebaseInstanceId(FirebaseApp firebaseApp) {
        this(firebaseApp, new zzae(firebaseApp.getApplicationContext()));
    }

    private FirebaseInstanceId(FirebaseApp firebaseApp, zzae zzae) {
        this.zzan = new zzah();
        this.zzao = false;
        if (zzae.zza(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (zzai == null) {
                    zzai = new zzao(firebaseApp.getApplicationContext());
                }
            }
            this.zzak = firebaseApp;
            this.zzal = zzae;
            this.zzam = new zzl(firebaseApp, this, zzae);
            this.zzap = zzm();
            if (zzo()) {
                zzd();
                return;
            }
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(FirebaseApp firebaseApp) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) firebaseApp.get(FirebaseInstanceId.class);
        }
        return firebaseInstanceId;
    }

    private final synchronized void startSync() {
        if (!this.zzao) {
            zza(0);
        }
    }

    private static <T> T zza(Task<T> task) throws IOException {
        try {
            return Tasks.await(task);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw new IOException(cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    private final String zza(String str, String str2, Bundle bundle) throws IOException {
        return ((zzl) this.zzam).zza(str, str2, bundle);
    }

    static void zza(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (zzaj == null) {
                zzaj = new ScheduledThreadPoolExecutor(1);
            }
            zzaj.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    private static String zzd(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) ? "*" : str;
    }

    private final void zzd() {
        zzap zzg = zzg();
        if (zzg == null || zzg.zzj(this.zzal.zzy()) || zzai.zzaf() != null) {
            startSync();
        }
    }

    static String zzf() {
        return zzae.zza(zzai.zzg("").getKeyPair());
    }

    static zzao zzi() {
        return zzai;
    }

    static boolean zzj() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
        }
        return true;
    }

    private final boolean zzm() {
        ApplicationInfo applicationInfo;
        Context applicationContext = this.zzak.getApplicationContext();
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
        if (sharedPreferences.contains("auto_init")) {
            return sharedPreferences.getBoolean("auto_init", true);
        }
        try {
            PackageManager packageManager = applicationContext.getPackageManager();
            if (!(packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY)) == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled"))) {
                return applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return zzn();
    }

    private final boolean zzn() {
        try {
            Class.forName("com.google.firebase.messaging.FirebaseMessaging");
            return true;
        } catch (ClassNotFoundException unused) {
            Context applicationContext = this.zzak.getApplicationContext();
            Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
            intent.setPackage(applicationContext.getPackageName());
            ResolveInfo resolveService = applicationContext.getPackageManager().resolveService(intent, 0);
            return (resolveService == null || resolveService.serviceInfo == null) ? false : true;
        }
    }

    public void deleteInstanceId() throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Bundle bundle = new Bundle();
            bundle.putString("iid-operation", "delete");
            bundle.putString("delete", "1");
            zza("*", "*", bundle);
            zzk();
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    public void deleteToken(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            String zzd = zzd(str2);
            Bundle bundle = new Bundle();
            bundle.putString("delete", "1");
            zza(str, zzd, bundle);
            zzai.zzc("", str, zzd);
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    public long getCreationTime() {
        return zzai.zzg("").getCreationTime();
    }

    public String getId() {
        zzd();
        return zzf();
    }

    public String getToken() {
        zzap zzg = zzg();
        if (zzg == null || zzg.zzj(this.zzal.zzy())) {
            startSync();
        }
        if (zzg != null) {
            return zzg.zzcu;
        }
        return null;
    }

    public String getToken(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            String zzd = zzd(str2);
            zzap zzb = zzai.zzb("", str, zzd);
            return (zzb == null || zzb.zzj(this.zzal.zzy())) ? this.zzan.zza(str, zzd, new zzk(this, str, zzd)) : zzb.zzcu;
        }
        throw new IOException("MAIN_THREAD");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zza(String str, String str2) throws IOException {
        String str3 = (String) zza(this.zzam.zzb(str, str2));
        zzai.zza("", str, str2, str3, this.zzal.zzy());
        return str3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    /* access modifiers changed from: package-private */
    public final synchronized void zza(long j) {
        zza(new zzaq(this, this.zzal, Math.min(Math.max(30L, j << 1), zzah)), j);
        this.zzao = true;
    }

    public final synchronized void zza(String str) {
        zzai.zza(str);
        startSync();
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(boolean z) {
        this.zzao = z;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str) throws IOException {
        zzap zzg = zzg();
        if (zzg == null || zzg.zzj(this.zzal.zzy())) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        String str2 = zzg.zzcu;
        String valueOf2 = String.valueOf(str);
        zza(str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle);
    }

    @VisibleForTesting
    public final synchronized void zzb(boolean z) {
        SharedPreferences.Editor edit = this.zzak.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
        edit.putBoolean("auto_init", z);
        edit.apply();
        if (!this.zzap && z) {
            zzd();
        }
        this.zzap = z;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(String str) throws IOException {
        zzap zzg = zzg();
        if (zzg == null || zzg.zzj(this.zzal.zzy())) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        bundle.putString("delete", "1");
        String str2 = zzg.zzcu;
        String valueOf2 = String.valueOf(str);
        zza(str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle);
    }

    /* access modifiers changed from: package-private */
    public final FirebaseApp zze() {
        return this.zzak;
    }

    /* access modifiers changed from: package-private */
    public final zzap zzg() {
        return zzai.zzb("", zzae.zza(this.zzak), "*");
    }

    /* access modifiers changed from: package-private */
    public final String zzh() throws IOException {
        return getToken(zzae.zza(this.zzak), "*");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzk() {
        zzai.zzag();
        if (zzo()) {
            startSync();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzl() {
        zzai.zzh("");
        startSync();
    }

    @VisibleForTesting
    public final synchronized boolean zzo() {
        return this.zzap;
    }
}
