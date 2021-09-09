package com.google.android.gms.internal.clearcut;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.clearcut.zzca;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

final class zzby<FieldDescriptorType extends zzca<FieldDescriptorType>> {
    private static final zzby zzgw = new zzby(true);
    private final zzei<FieldDescriptorType, Object> zzgt = zzei.zzaj(16);
    private boolean zzgu;
    private boolean zzgv = false;

    private zzby() {
    }

    private zzby(boolean z) {
        zzv();
    }

    static int zza(zzfl zzfl, int i, Object obj) {
        int zzr = zzbn.zzr(i);
        if (zzfl == zzfl.GROUP) {
            zzci.zzf((zzdo) obj);
            zzr <<= 1;
        }
        return zzr + zzb(zzfl, obj);
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzgt.get(fielddescriptortype);
        return obj instanceof zzcr ? zzcr.zzbr() : obj;
    }

    static void zza(zzbn zzbn, zzfl zzfl, int i, Object obj) throws IOException {
        if (zzfl == zzfl.GROUP) {
            zzdo zzdo = (zzdo) obj;
            zzci.zzf(zzdo);
            zzbn.zzb(i, 3);
            zzdo.zzb(zzbn);
            zzbn.zzb(i, 4);
            return;
        }
        zzbn.zzb(i, zzfl.zzel());
        switch (zzbz.zzgq[zzfl.ordinal()]) {
            case 1:
                zzbn.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzbn.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzbn.zzb(((Long) obj).longValue());
                return;
            case 4:
                zzbn.zzb(((Long) obj).longValue());
                return;
            case 5:
                zzbn.zzn(((Integer) obj).intValue());
                return;
            case 6:
                zzbn.zzd(((Long) obj).longValue());
                return;
            case 7:
                zzbn.zzq(((Integer) obj).intValue());
                return;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                zzbn.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzdo) obj).zzb(zzbn);
                return;
            case 10:
                zzbn.zzb((zzdo) obj);
                return;
            case 11:
                if (obj instanceof zzbb) {
                    zzbn.zza((zzbb) obj);
                    return;
                } else {
                    zzbn.zzg((String) obj);
                    return;
                }
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                if (obj instanceof zzbb) {
                    zzbn.zza((zzbb) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzbn.zzd(bArr, 0, bArr.length);
                return;
            case 13:
                zzbn.zzo(((Integer) obj).intValue());
                return;
            case 14:
                zzbn.zzq(((Integer) obj).intValue());
                return;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                zzbn.zzd(((Long) obj).longValue());
                return;
            case 16:
                zzbn.zzp(((Integer) obj).intValue());
                return;
            case 17:
                zzbn.zzc(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzcj) {
                    zzbn.zzn(((zzcj) obj).zzc());
                    return;
                } else {
                    zzbn.zzn(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzaw()) {
            zza(fielddescriptortype.zzau(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzau(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzcr) {
            this.zzgv = true;
        }
        this.zzgt.put(fielddescriptortype, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.clearcut.zzcr) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.clearcut.zzcj) == false) goto L_0x0043;
     */
    private static void zza(zzfl zzfl, Object obj) {
        boolean z;
        zzci.checkNotNull(obj);
        boolean z2 = false;
        switch (zzbz.zzgx[zzfl.zzek().ordinal()]) {
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
                if (!(obj instanceof zzbb)) {
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
                if (!(obj instanceof zzdo)) {
                    break;
                }
                z2 = true;
                break;
        }
        if (!z2) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public static <T extends zzca<T>> zzby<T> zzar() {
        return zzgw;
    }

    private static int zzb(zzca<?> zzca, Object obj) {
        zzfl zzau = zzca.zzau();
        int zzc = zzca.zzc();
        if (!zzca.zzaw()) {
            return zza(zzau, zzc, obj);
        }
        int i = 0;
        if (zzca.zzax()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzau, zzb);
            }
            return zzbn.zzr(zzc) + i + zzbn.zzz(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzau, zzc, zza);
        }
        return i;
    }

    private static int zzb(zzfl zzfl, Object obj) {
        switch (zzbz.zzgq[zzfl.ordinal()]) {
            case 1:
                return zzbn.zzb(((Double) obj).doubleValue());
            case 2:
                return zzbn.zzb(((Float) obj).floatValue());
            case 3:
                return zzbn.zze(((Long) obj).longValue());
            case 4:
                return zzbn.zzf(((Long) obj).longValue());
            case 5:
                return zzbn.zzs(((Integer) obj).intValue());
            case 6:
                return zzbn.zzh(((Long) obj).longValue());
            case 7:
                return zzbn.zzv(((Integer) obj).intValue());
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return zzbn.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzbn.zzd((zzdo) obj);
            case 10:
                return obj instanceof zzcr ? zzbn.zza((zzcr) obj) : zzbn.zzc((zzdo) obj);
            case 11:
                return obj instanceof zzbb ? zzbn.zzb((zzbb) obj) : zzbn.zzh((String) obj);
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return obj instanceof zzbb ? zzbn.zzb((zzbb) obj) : zzbn.zzd((byte[]) obj);
            case 13:
                return zzbn.zzt(((Integer) obj).intValue());
            case 14:
                return zzbn.zzw(((Integer) obj).intValue());
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return zzbn.zzi(((Long) obj).longValue());
            case 16:
                return zzbn.zzu(((Integer) obj).intValue());
            case 17:
                return zzbn.zzg(((Long) obj).longValue());
            case 18:
                return obj instanceof zzcj ? zzbn.zzx(((zzcj) obj).zzc()) : zzbn.zzx(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean zzb(Map.Entry<FieldDescriptorType, Object> entry) {
        zzca zzca = (zzca) entry.getKey();
        if (zzca.zzav() == zzfq.MESSAGE) {
            if (zzca.zzaw()) {
                for (zzdo isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzdo) {
                    if (!((zzdo) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzcr) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private final void zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        zzca zzca = (zzca) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzcr) {
            value = zzcr.zzbr();
        }
        if (zzca.zzaw()) {
            Object zza = zza(zzca);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzd : (List) value) {
                ((List) zza).add(zzd(zzd));
            }
            this.zzgt.put(zzca, zza);
        } else if (zzca.zzav() == zzfq.MESSAGE) {
            Object zza2 = zza(zzca);
            if (zza2 == null) {
                this.zzgt.put(zzca, zzd(value));
            } else {
                this.zzgt.put(zzca, zza2 instanceof zzdv ? zzca.zza((zzdv) zza2, (zzdv) value) : zzca.zza(((zzdo) zza2).zzbc(), (zzdo) value).zzbj());
            }
        } else {
            this.zzgt.put(zzca, zzd(value));
        }
    }

    private static int zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        zzca zzca = (zzca) entry.getKey();
        Object value = entry.getValue();
        return (zzca.zzav() != zzfq.MESSAGE || zzca.zzaw() || zzca.zzax()) ? zzb(zzca, value) : value instanceof zzcr ? zzbn.zzb(((zzca) entry.getKey()).zzc(), (zzcr) value) : zzbn.zzd(((zzca) entry.getKey()).zzc(), (zzdo) value);
    }

    private static Object zzd(Object obj) {
        if (obj instanceof zzdv) {
            return ((zzdv) obj).zzci();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzby zzby = new zzby();
        for (int i = 0; i < this.zzgt.zzdr(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzak = this.zzgt.zzak(i);
            zzby.zza((zzca) zzak.getKey(), zzak.getValue());
        }
        for (Map.Entry next : this.zzgt.zzds()) {
            zzby.zza((zzca) next.getKey(), next.getValue());
        }
        zzby.zzgv = this.zzgv;
        return zzby;
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        return this.zzgv ? new zzcu(this.zzgt.zzdt().iterator()) : this.zzgt.zzdt().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzby)) {
            return false;
        }
        return this.zzgt.equals(((zzby) obj).zzgt);
    }

    public final int hashCode() {
        return this.zzgt.hashCode();
    }

    /* access modifiers changed from: package-private */
    public final boolean isEmpty() {
        return this.zzgt.isEmpty();
    }

    public final boolean isImmutable() {
        return this.zzgu;
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzgt.zzdr(); i++) {
            if (!zzb(this.zzgt.zzak(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> zzb : this.zzgt.zzds()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzgv ? new zzcu(this.zzgt.entrySet().iterator()) : this.zzgt.entrySet().iterator();
    }

    public final void zza(zzby<FieldDescriptorType> zzby) {
        for (int i = 0; i < zzby.zzgt.zzdr(); i++) {
            zzc(zzby.zzgt.zzak(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzc : zzby.zzgt.zzds()) {
            zzc(zzc);
        }
    }

    public final int zzas() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzgt.zzdr(); i2++) {
            Map.Entry<FieldDescriptorType, Object> zzak = this.zzgt.zzak(i2);
            i += zzb((zzca) zzak.getKey(), zzak.getValue());
        }
        for (Map.Entry next : this.zzgt.zzds()) {
            i += zzb((zzca) next.getKey(), next.getValue());
        }
        return i;
    }

    public final int zzat() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzgt.zzdr(); i2++) {
            i += zzd((Map.Entry) this.zzgt.zzak(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzgt.zzds()) {
            i += zzd((Map.Entry) entry);
        }
        return i;
    }

    public final void zzv() {
        if (!this.zzgu) {
            this.zzgt.zzv();
            this.zzgu = true;
        }
    }
}
