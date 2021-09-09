package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzzq;

final class zzaad implements zzaaw {
    private static final zzaak zzbte = new zzaae();
    private final zzaak zzbtd;

    public zzaad() {
        this(new zzaaf(zzzp.zztl(), zzts()));
    }

    private zzaad(zzaak zzaak) {
        this.zzbtd = (zzaak) zzzr.zza(zzaak, "messageInfoFactory");
    }

    private static boolean zza(zzaaj zzaaj) {
        return zzaaj.zztw() == zzzq.zzb.zzbsk;
    }

    private static zzaak zzts() {
        try {
            return (zzaak) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzbte;
        }
    }

    public final <T> zzaav<T> zzg(Class<T> cls) {
        zzaax.zzh(cls);
        zzaaj zze = this.zzbtd.zze(cls);
        if (zze.zztx()) {
            return zzzq.class.isAssignableFrom(cls) ? zzaap.zza(zzaax.zzug(), zzzl.zztg(), zze.zzty()) : zzaap.zza(zzaax.zzue(), zzzl.zzth(), zze.zzty());
        }
        if (zzzq.class.isAssignableFrom(cls)) {
            if (zza(zze)) {
                return zzaao.zza(cls, zze, zzaas.zzub(), zzzz.zztr(), zzaax.zzug(), zzzl.zztg(), zzaai.zztu());
            }
            return zzaao.zza(cls, zze, zzaas.zzub(), zzzz.zztr(), zzaax.zzug(), null, zzaai.zztu());
        } else if (zza(zze)) {
            return zzaao.zza(cls, zze, zzaas.zzua(), zzzz.zztq(), zzaax.zzue(), zzzl.zzth(), zzaai.zztt());
        } else {
            return zzaao.zza(cls, zze, zzaas.zzua(), zzzz.zztq(), zzaax.zzuf(), null, zzaai.zztt());
        }
    }
}
