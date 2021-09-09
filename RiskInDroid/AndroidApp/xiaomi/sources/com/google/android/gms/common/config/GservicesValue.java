package com.google.android.gms.common.config;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.StrictMode;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.stable.zzg;
import com.google.android.gms.internal.stable.zzi;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class GservicesValue<T> {
    private static final Object sLock = new Object();
    /* access modifiers changed from: private */
    public static zza zzmu = null;
    private static int zzmv = 0;
    private static Context zzmw;
    private static String zzmx = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private static HashSet<String> zzmy;
    protected final T mDefaultValue;
    protected final String mKey;
    private T zzmz = null;

    interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Double zza(String str, Double d);

        Float zza(String str, Float f);

        Integer zza(String str, Integer num);

        String zzb(String str, String str2);
    }

    static class zzb implements zza {
        /* access modifiers changed from: private */
        public static final Collection<GservicesValue<?>> zzna = new HashSet();

        private zzb() {
        }

        /* synthetic */ zzb(zza zza) {
            this();
        }

        public final Long getLong(String str, Long l) {
            return l;
        }

        public final String getString(String str, String str2) {
            return str2;
        }

        public final Boolean zza(String str, Boolean bool) {
            return bool;
        }

        public final Double zza(String str, Double d) {
            return d;
        }

        public final Float zza(String str, Float f) {
            return f;
        }

        public final Integer zza(String str, Integer num) {
            return num;
        }

        public final String zzb(String str, String str2) {
            return str2;
        }
    }

    @Deprecated
    static class zzc implements zza {
        private final Map<String, ?> values;

        public zzc(Map<String, ?> map) {
            this.values = map;
        }

        private final <T> T zza(String str, T t) {
            return this.values.containsKey(str) ? this.values.get(str) : t;
        }

        public final Long getLong(String str, Long l) {
            return (Long) zza(str, l);
        }

        public final String getString(String str, String str2) {
            return (String) zza(str, str2);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Object):T
         arg types: [java.lang.String, java.lang.Boolean]
         candidates:
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Boolean):java.lang.Boolean
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Double):java.lang.Double
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Float):java.lang.Float
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Integer):java.lang.Integer
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Boolean):java.lang.Boolean
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Double):java.lang.Double
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Float):java.lang.Float
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Integer):java.lang.Integer
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Object):T */
        public final Boolean zza(String str, Boolean bool) {
            return (Boolean) zza(str, (Object) bool);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Object):T
         arg types: [java.lang.String, java.lang.Double]
         candidates:
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Boolean):java.lang.Boolean
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Double):java.lang.Double
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Float):java.lang.Float
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Integer):java.lang.Integer
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Boolean):java.lang.Boolean
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Double):java.lang.Double
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Float):java.lang.Float
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Integer):java.lang.Integer
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Object):T */
        public final Double zza(String str, Double d) {
            return (Double) zza(str, (Object) d);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Object):T
         arg types: [java.lang.String, java.lang.Float]
         candidates:
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Boolean):java.lang.Boolean
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Double):java.lang.Double
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Float):java.lang.Float
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Integer):java.lang.Integer
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Boolean):java.lang.Boolean
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Double):java.lang.Double
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Float):java.lang.Float
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Integer):java.lang.Integer
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Object):T */
        public final Float zza(String str, Float f) {
            return (Float) zza(str, (Object) f);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Object):T
         arg types: [java.lang.String, java.lang.Integer]
         candidates:
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Boolean):java.lang.Boolean
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Double):java.lang.Double
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Float):java.lang.Float
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Integer):java.lang.Integer
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Boolean):java.lang.Boolean
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Double):java.lang.Double
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Float):java.lang.Float
          com.google.android.gms.common.config.GservicesValue.zza.zza(java.lang.String, java.lang.Integer):java.lang.Integer
          com.google.android.gms.common.config.GservicesValue.zzc.zza(java.lang.String, java.lang.Object):T */
        public final Integer zza(String str, Integer num) {
            return (Integer) zza(str, (Object) num);
        }

        public final String zzb(String str, String str2) {
            return (String) zza(str, str2);
        }
    }

    static class zzd implements zza {
        private final ContentResolver mContentResolver;

        public zzd(ContentResolver contentResolver) {
            this.mContentResolver = contentResolver;
        }

        public final Long getLong(String str, Long l) {
            return Long.valueOf(zzi.getLong(this.mContentResolver, str, l.longValue()));
        }

        public final String getString(String str, String str2) {
            return zzi.zza(this.mContentResolver, str, str2);
        }

        public final Boolean zza(String str, Boolean bool) {
            return Boolean.valueOf(zzi.zza(this.mContentResolver, str, bool.booleanValue()));
        }

        public final Double zza(String str, Double d) {
            String zza = zzi.zza(this.mContentResolver, str, (String) null);
            if (zza != null) {
                try {
                    return Double.valueOf(Double.parseDouble(zza));
                } catch (NumberFormatException unused) {
                }
            }
            return d;
        }

        public final Float zza(String str, Float f) {
            String zza = zzi.zza(this.mContentResolver, str, (String) null);
            if (zza != null) {
                try {
                    return Float.valueOf(Float.parseFloat(zza));
                } catch (NumberFormatException unused) {
                }
            }
            return f;
        }

        public final Integer zza(String str, Integer num) {
            return Integer.valueOf(zzi.getInt(this.mContentResolver, str, num.intValue()));
        }

        public final String zzb(String str, String str2) {
            return zzg.zza(this.mContentResolver, str, str2);
        }
    }

    protected GservicesValue(String str, T t) {
        this.mKey = str;
        this.mDefaultValue = t;
    }

    @Deprecated
    @VisibleForTesting
    public static void forceInit(Context context) {
        forceInit(context, new HashSet());
    }

    @VisibleForTesting
    public static void forceInit(Context context, HashSet<String> hashSet) {
        zza(context, new zzd(context.getContentResolver()), hashSet);
    }

    @TargetApi(24)
    public static SharedPreferences getDirectBootCache(Context context) {
        return context.getApplicationContext().createDeviceProtectedStorageContext().getSharedPreferences("gservices-direboot-cache", 0);
    }

    public static int getSharedUserId() {
        return zzmv;
    }

    @Deprecated
    public static void init(Context context) {
        init(context, zzd(context) ? new HashSet() : null);
    }

    public static void init(Context context, HashSet<String> hashSet) {
        synchronized (sLock) {
            if (zzmu == null) {
                zza(context, new zzd(context.getContentResolver()), hashSet);
            }
            if (zzmv == 0) {
                try {
                    zzmv = context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).uid;
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("GservicesValue", e.toString());
                }
            }
        }
    }

    @Deprecated
    @VisibleForTesting
    public static void initForTests() {
        zza(null, new zzb(null), new HashSet());
    }

    @VisibleForTesting
    public static void initForTests(Context context, HashSet<String> hashSet) {
        zza(context, new zzb(null), hashSet);
    }

    @Deprecated
    @VisibleForTesting
    public static void initForTests(String str, Object obj) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(str, obj);
        initForTests(hashMap);
    }

    @Deprecated
    @VisibleForTesting
    public static void initForTests(Map<String, ?> map) {
        synchronized (sLock) {
            zzmu = new zzc(map);
        }
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (sLock) {
            z = zzmu != null;
        }
        return z;
    }

    public static GservicesValue<String> partnerSetting(String str, String str2) {
        return new zzg(str, str2);
    }

    @VisibleForTesting
    public static void resetAllOverrides() {
        synchronized (sLock) {
            if (zzcg()) {
                for (GservicesValue resetOverride : zzb.zzna) {
                    resetOverride.resetOverride();
                }
                zzb.zzna.clear();
            }
        }
    }

    public static GservicesValue<Double> value(String str, Double d) {
        return new zzd(str, d);
    }

    public static GservicesValue<Float> value(String str, Float f) {
        return new zze(str, f);
    }

    public static GservicesValue<Integer> value(String str, Integer num) {
        return new zzc(str, num);
    }

    public static GservicesValue<Long> value(String str, Long l) {
        return new zzb(str, l);
    }

    public static GservicesValue<String> value(String str, String str2) {
        return new zzf(str, str2);
    }

    public static GservicesValue<Boolean> value(String str, boolean z) {
        return new zza(str, Boolean.valueOf(z));
    }

    @TargetApi(24)
    private static void zza(Context context, zza zza2, HashSet<String> hashSet) {
        synchronized (sLock) {
            zzmu = zza2;
            zzmy = null;
            zzmw = null;
            if (context != null && zzd(context)) {
                zzmy = hashSet;
                zzmw = context.getApplicationContext().createDeviceProtectedStorageContext();
            }
        }
    }

    private static boolean zzcg() {
        boolean z;
        synchronized (sLock) {
            if (!(zzmu instanceof zzb)) {
                if (!(zzmu instanceof zzc)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @TargetApi(24)
    private static boolean zzd(Context context) {
        if (!PlatformVersion.isAtLeastN()) {
            return false;
        }
        UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
        return !userManager.isUserUnlocked() && !userManager.isUserRunning(Process.myUserHandle());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:44|45|46|47|48|49|50|51) */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0090, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r1 = android.os.Binder.clearCallingIdentity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r3 = retrieve(r5.mKey);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009f, code lost:
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a2, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a3, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a7, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a8, code lost:
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ab, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x0092 */
    public final T get() {
        boolean z;
        HashSet<String> hashSet;
        Context context;
        T t = this.zzmz;
        if (t != null) {
            return t;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        synchronized (sLock) {
            z = zzmw != null && zzd(zzmw);
            hashSet = zzmy;
            context = zzmw;
        }
        if (z) {
            if (Log.isLoggable("GservicesValue", 3)) {
                String valueOf = String.valueOf(this.mKey);
                Log.d("GservicesValue", valueOf.length() != 0 ? "Gservice value accessed during directboot: ".concat(valueOf) : new String("Gservice value accessed during directboot: "));
            }
            if (hashSet == null || hashSet.contains(this.mKey)) {
                return retrieveFromDirectBootCache(context, this.mKey, this.mDefaultValue);
            }
            String valueOf2 = String.valueOf(this.mKey);
            Log.e("GservicesValue", valueOf2.length() != 0 ? "Gservices key not whitelisted for directboot access: ".concat(valueOf2) : new String("Gservices key not whitelisted for directboot access: "));
            return this.mDefaultValue;
        }
        synchronized (sLock) {
            zzmy = null;
            zzmw = null;
        }
        T retrieve = retrieve(this.mKey);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return retrieve;
    }

    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    public String getKey() {
        return this.mKey;
    }

    @VisibleForTesting
    public void override(T t) {
        if (!(zzmu instanceof zzb)) {
            Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        }
        this.zzmz = t;
        synchronized (sLock) {
            if (zzcg()) {
                zzb.zzna.add(this);
            }
        }
    }

    @VisibleForTesting
    public void resetOverride() {
        this.zzmz = null;
    }

    /* access modifiers changed from: protected */
    public abstract T retrieve(String str);

    /* access modifiers changed from: protected */
    @TargetApi(24)
    public T retrieveFromDirectBootCache(Context context, String str, T t) {
        throw new UnsupportedOperationException("The Gservices classes used does not support direct-boot");
    }
}
