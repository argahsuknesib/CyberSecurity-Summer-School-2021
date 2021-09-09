package com.google.android.gms.internal.clearcut;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzea {
    private static final zzea zznc = new zzea();
    private final zzeg zznd;
    private final ConcurrentMap<Class<?>, zzef<?>> zzne = new ConcurrentHashMap();

    private zzea() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        zzeg zzeg = null;
        for (int i = 0; i <= 0; i++) {
            zzeg = zzk(strArr[0]);
            if (zzeg != null) {
                break;
            }
        }
        this.zznd = zzeg == null ? new zzdd() : zzeg;
    }

    public static zzea zzcm() {
        return zznc;
    }

    private static zzeg zzk(String str) {
        try {
            return (zzeg) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzci.zza(java.lang.Object, java.lang.String):T
     arg types: [java.lang.Class<T>, java.lang.String]
     candidates:
      com.google.android.gms.internal.clearcut.zzci.zza(java.lang.Object, java.lang.Object):java.lang.Object
      com.google.android.gms.internal.clearcut.zzci.zza(java.lang.Object, java.lang.String):T */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzci.zza(java.lang.Object, java.lang.String):T
     arg types: [com.google.android.gms.internal.clearcut.zzef<T>, java.lang.String]
     candidates:
      com.google.android.gms.internal.clearcut.zzci.zza(java.lang.Object, java.lang.Object):java.lang.Object
      com.google.android.gms.internal.clearcut.zzci.zza(java.lang.Object, java.lang.String):T */
    public final <T> zzef<T> zze(Class<T> cls) {
        zzci.zza((Object) cls, "messageType");
        zzef<T> zzef = this.zzne.get(cls);
        if (zzef != null) {
            return zzef;
        }
        zzef<T> zzd = this.zznd.zzd(cls);
        zzci.zza((Object) cls, "messageType");
        zzci.zza((Object) zzd, "schema");
        zzef<T> putIfAbsent = this.zzne.putIfAbsent(cls, zzd);
        return putIfAbsent != null ? putIfAbsent : zzd;
    }

    public final <T> zzef<T> zzp(T t) {
        return zze(t.getClass());
    }
}
