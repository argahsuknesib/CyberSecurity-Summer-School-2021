package com.google.android.gms.internal.measurement;

final class zzyv {
    private static final Class<?> zzbqv = zzfh("libcore.io.Memory");
    private static final boolean zzbqw = (zzfh("org.robolectric.Robolectric") != null);

    private static <T> Class<T> zzfh(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzsv() {
        return zzbqv != null && !zzbqw;
    }

    static Class<?> zzsw() {
        return zzbqv;
    }
}
