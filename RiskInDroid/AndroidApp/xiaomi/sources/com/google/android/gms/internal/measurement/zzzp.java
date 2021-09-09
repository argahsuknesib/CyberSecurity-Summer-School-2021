package com.google.android.gms.internal.measurement;

final class zzzp implements zzaak {
    private static final zzzp zzbrx = new zzzp();

    private zzzp() {
    }

    public static zzzp zztl() {
        return zzbrx;
    }

    public final boolean zzd(Class<?> cls) {
        return zzzq.class.isAssignableFrom(cls);
    }

    public final zzaaj zze(Class<?> cls) {
        if (!zzzq.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzaaj) zzzq.zzf(cls.asSubclass(zzzq.class)).zza(3, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
