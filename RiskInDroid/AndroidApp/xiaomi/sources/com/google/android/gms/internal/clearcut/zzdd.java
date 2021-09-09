package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

final class zzdd implements zzeg {
    private static final zzdn zzlz = new zzde();
    private final zzdn zzly;

    public zzdd() {
        this(new zzdf(zzcf.zzay(), zzby()));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzci.zza(java.lang.Object, java.lang.String):T
     arg types: [com.google.android.gms.internal.clearcut.zzdn, java.lang.String]
     candidates:
      com.google.android.gms.internal.clearcut.zzci.zza(java.lang.Object, java.lang.Object):java.lang.Object
      com.google.android.gms.internal.clearcut.zzci.zza(java.lang.Object, java.lang.String):T */
    private zzdd(zzdn zzdn) {
        this.zzly = (zzdn) zzci.zza((Object) zzdn, "messageInfoFactory");
    }

    private static boolean zza(zzdm zzdm) {
        return zzdm.zzcf() == zzcg.zzg.zzkl;
    }

    private static zzdn zzby() {
        try {
            return (zzdn) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzlz;
        }
    }

    public final <T> zzef<T> zzd(Class<T> cls) {
        zzeh.zzf((Class<?>) cls);
        zzdm zzb = this.zzly.zzb(cls);
        if (zzb.zzcg()) {
            return zzcg.class.isAssignableFrom(cls) ? zzdu.zza(zzeh.zzdo(), zzbx.zzap(), zzb.zzch()) : zzdu.zza(zzeh.zzdm(), zzbx.zzaq(), zzb.zzch());
        }
        if (zzcg.class.isAssignableFrom(cls)) {
            if (zza(zzb)) {
                return zzds.zza(cls, zzb, zzdy.zzck(), zzcy.zzbw(), zzeh.zzdo(), zzbx.zzap(), zzdl.zzcd());
            }
            return zzds.zza(cls, zzb, zzdy.zzck(), zzcy.zzbw(), zzeh.zzdo(), (zzbu<?>) null, zzdl.zzcd());
        } else if (zza(zzb)) {
            return zzds.zza(cls, zzb, zzdy.zzcj(), zzcy.zzbv(), zzeh.zzdm(), zzbx.zzaq(), zzdl.zzcc());
        } else {
            return zzds.zza(cls, zzb, zzdy.zzcj(), zzcy.zzbv(), zzeh.zzdn(), (zzbu<?>) null, zzdl.zzcc());
        }
    }
}
