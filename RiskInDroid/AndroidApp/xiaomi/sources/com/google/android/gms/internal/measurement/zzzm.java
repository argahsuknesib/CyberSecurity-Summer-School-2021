package com.google.android.gms.internal.measurement;

import com.google.android.exoplayer2.C;
import com.google.android.gms.internal.measurement.zzzo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzzm<FieldDescriptorType extends zzzo<FieldDescriptorType>> {
    private static final zzzm zzbru = new zzzm(true);
    private boolean zzbls;
    private final zzaay<FieldDescriptorType, Object> zzbrs = zzaay.zzag(16);
    private boolean zzbrt = false;

    private zzzm() {
    }

    private zzzm(boolean z) {
        if (!this.zzbls) {
            this.zzbrs.zzrg();
            this.zzbls = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzzu) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzzs) == false) goto L_0x0043;
     */
    private static void zza(zzabp zzabp, Object obj) {
        boolean z;
        zzzr.checkNotNull(obj);
        boolean z2 = false;
        switch (zzzn.zzbrv[zzabp.zzuv().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                z2 = z;
                break;
            case 2:
                z = obj instanceof Long;
                z2 = z;
                break;
            case 3:
                z = obj instanceof Float;
                z2 = z;
                break;
            case 4:
                z = obj instanceof Double;
                z2 = z;
                break;
            case 5:
                z = obj instanceof Boolean;
                z2 = z;
                break;
            case 6:
                z = obj instanceof String;
                z2 = z;
                break;
            case 7:
                if (!(obj instanceof zzyw)) {
                    break;
                }
                z2 = true;
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                if (!(obj instanceof Integer)) {
                    break;
                }
                z2 = true;
                break;
            case 9:
                if (!(obj instanceof zzaal)) {
                    break;
                }
                z2 = true;
                break;
        }
        if (!z2) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zztk()) {
            zza(fielddescriptortype.zztj(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zztj(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzzu) {
            this.zzbrt = true;
        }
        this.zzbrs.put(fielddescriptortype, obj);
    }

    public static <T extends zzzo<T>> zzzm<T> zzti() {
        return zzbru;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzzm zzzm = new zzzm();
        for (int i = 0; i < this.zzbrs.zzuj(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzah = this.zzbrs.zzah(i);
            zzzm.zza((zzzo) zzah.getKey(), zzah.getValue());
        }
        for (Map.Entry next : this.zzbrs.zzuk()) {
            zzzm.zza((zzzo) next.getKey(), next.getValue());
        }
        zzzm.zzbrt = this.zzbrt;
        return zzzm;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzzm)) {
            return false;
        }
        return this.zzbrs.equals(((zzzm) obj).zzbrs);
    }

    public final int hashCode() {
        return this.zzbrs.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzbrt ? new zzzx(this.zzbrs.entrySet().iterator()) : this.zzbrs.entrySet().iterator();
    }
}
