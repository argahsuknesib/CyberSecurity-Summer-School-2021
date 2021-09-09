package com.google.android.gms.internal.clearcut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zzda extends zzcy {
    private static final Class<?> zzlv = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzda() {
        super();
    }

    private static <E> List<E> zzb(Object obj, long j) {
        return (List) zzfd.zzo(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j) {
        Object obj2;
        List list = (List) zzfd.zzo(obj, j);
        if (list instanceof zzcx) {
            obj2 = ((zzcx) list).zzbu();
        } else if (!zzlv.isAssignableFrom(list.getClass())) {
            obj2 = Collections.unmodifiableList(list);
        } else {
            return;
        }
        zzfd.zza(obj, j, obj2);
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzcw;
        List zzb = zzb(obj2, j);
        int size = zzb.size();
        List zzb2 = zzb(obj, j);
        if (zzb2.isEmpty()) {
            zzb2 = zzb2 instanceof zzcx ? new zzcw(size) : new ArrayList(size);
            zzfd.zza(obj, j, zzb2);
        } else {
            if (zzlv.isAssignableFrom(zzb2.getClass())) {
                zzcw = new ArrayList(zzb2.size() + size);
                zzcw.addAll(zzb2);
            } else if (zzb2 instanceof zzfa) {
                zzcw = new zzcw(zzb2.size() + size);
                zzcw.addAll((zzfa) zzb2);
            }
            zzfd.zza(obj, j, zzcw);
            zzb2 = zzcw;
        }
        int size2 = zzb2.size();
        int size3 = zzb.size();
        if (size2 > 0 && size3 > 0) {
            zzb2.addAll(zzb);
        }
        if (size2 > 0) {
            zzb = zzb2;
        }
        zzfd.zza(obj, j, zzb);
    }
}
