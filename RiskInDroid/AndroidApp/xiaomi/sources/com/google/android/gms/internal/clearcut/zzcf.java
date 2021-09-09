package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

final class zzcf implements zzdn {
    private static final zzcf zzjo = new zzcf();

    private zzcf() {
    }

    public static zzcf zzay() {
        return zzjo;
    }

    public final boolean zza(Class<?> cls) {
        return zzcg.class.isAssignableFrom(cls);
    }

    public final zzdm zzb(Class<?> cls) {
        if (!zzcg.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzdm) zzcg.zzc(cls.asSubclass(zzcg.class)).zza(zzcg.zzg.zzkf, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
