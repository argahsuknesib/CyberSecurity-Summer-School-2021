package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    /* access modifiers changed from: private */
    public static final Object zzsj = new Object();
    private static ClassLoader zzsk = null;
    private static Integer zzsl = null;
    private boolean zzsm = false;

    public static final class DowngradeableSafeParcelHelper {
        public static Bundle getExtras(Intent intent, Context context, Integer num) {
            Bundle extras;
            synchronized (DowngradeableSafeParcel.zzsj) {
                extras = DowngradeableSafeParcel.getExtras(intent, context, num);
            }
            return extras;
        }

        public static <T extends Parcelable> T getParcelable(Intent intent, String str, Context context, Integer num) {
            T parcelable;
            synchronized (DowngradeableSafeParcel.zzsj) {
                parcelable = DowngradeableSafeParcel.getParcelable(intent, str, context, num);
            }
            return parcelable;
        }

        public static <T extends Parcelable> T getParcelable(Bundle bundle, String str, Context context, Integer num) {
            T parcelable;
            synchronized (DowngradeableSafeParcel.zzsj) {
                parcelable = DowngradeableSafeParcel.getParcelable(bundle, str, context, num);
            }
            return parcelable;
        }

        public static boolean putParcelable(Bundle bundle, String str, DowngradeableSafeParcel downgradeableSafeParcel, Context context, Integer num) {
            return DowngradeableSafeParcel.putParcelable(bundle, str, downgradeableSafeParcel, context, num);
        }
    }

    protected static boolean canUnparcelSafely(String str) {
        ClassLoader unparcelClassLoader = getUnparcelClassLoader();
        if (unparcelClassLoader == null) {
            return true;
        }
        try {
            return zza(unparcelClassLoader.loadClass(str));
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: finally extract failed */
    static Bundle getExtras(Intent intent, Context context, Integer num) {
        Bundle bundle;
        if (context != null) {
            try {
                zza(context.getClassLoader(), num);
                if (intent.getExtras() != null) {
                    bundle = new Bundle();
                    bundle.putAll(intent.getExtras());
                    zza((ClassLoader) null, (Integer) null);
                    return bundle;
                }
            } catch (Throwable th) {
                zza((ClassLoader) null, (Integer) null);
                throw th;
            }
        }
        bundle = null;
        zza((ClassLoader) null, (Integer) null);
        return bundle;
    }

    /* JADX INFO: finally extract failed */
    static <T extends Parcelable> T getParcelable(Intent intent, String str, Context context, Integer num) {
        T t;
        if (context != null) {
            try {
                zza(context.getClassLoader(), num);
                t = intent.getParcelableExtra(str);
            } catch (Throwable th) {
                zza((ClassLoader) null, (Integer) null);
                throw th;
            }
        } else {
            t = null;
        }
        zza((ClassLoader) null, (Integer) null);
        return t;
    }

    /* JADX INFO: finally extract failed */
    static <T extends Parcelable> T getParcelable(Bundle bundle, String str, Context context, Integer num) {
        T t;
        if (context != null) {
            try {
                zza(context.getClassLoader(), num);
                t = bundle.getParcelable(str);
            } catch (Throwable th) {
                zza((ClassLoader) null, (Integer) null);
                throw th;
            }
        } else {
            t = null;
        }
        zza((ClassLoader) null, (Integer) null);
        return t;
    }

    protected static ClassLoader getUnparcelClassLoader() {
        ClassLoader classLoader;
        synchronized (zzsj) {
            classLoader = zzsk;
        }
        return classLoader;
    }

    protected static Integer getUnparcelClientVersion() {
        Integer num;
        synchronized (zzsj) {
            num = zzsl;
        }
        return num;
    }

    static boolean putParcelable(Bundle bundle, String str, DowngradeableSafeParcel downgradeableSafeParcel, Context context, Integer num) {
        if ((context == null && num == null) || !downgradeableSafeParcel.zza(context, num)) {
            return false;
        }
        bundle.putParcelable(str, downgradeableSafeParcel);
        return true;
    }

    private static void zza(ClassLoader classLoader, Integer num) {
        synchronized (zzsj) {
            zzsk = classLoader;
            zzsl = num;
        }
    }

    private final boolean zza(Context context, Integer num) {
        if (num != null) {
            return prepareForClientVersion(num.intValue());
        }
        try {
            setShouldDowngrade(!zza(context.getClassLoader().loadClass(getClass().getCanonicalName())));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean zza(Class<?> cls) {
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean prepareForClientVersion(int i);

    public void setShouldDowngrade(boolean z) {
        this.zzsm = z;
    }

    /* access modifiers changed from: protected */
    public boolean shouldDowngrade() {
        return this.zzsm;
    }
}
