package com.google.android.gms.internal.measurement;

final class zzzh {
    private static final Class<?> zzbrl = zztb();

    private static final zzzi zzfj(String str) throws Exception {
        return (zzzi) zzbrl.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }

    private static Class<?> zztb() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzzi zztc() {
        if (zzbrl != null) {
            try {
                return zzfj("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return zzzi.zzbro;
    }
}
