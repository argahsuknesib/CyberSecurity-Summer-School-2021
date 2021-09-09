package com.google.firebase.components;

public final class zzk {
    public static void checkState(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
