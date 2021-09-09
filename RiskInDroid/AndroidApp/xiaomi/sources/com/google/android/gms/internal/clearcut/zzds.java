package com.google.android.gms.internal.clearcut;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.clearcut.zzcg;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import sun.misc.Unsafe;

final class zzds<T> implements zzef<T> {
    private static final Unsafe zzmh = zzfd.zzef();
    private final int[] zzmi;
    private final Object[] zzmj;
    private final int zzmk;
    private final int zzml;
    private final int zzmm;
    private final zzdo zzmn;
    private final boolean zzmo;
    private final boolean zzmp;
    private final boolean zzmq;
    private final boolean zzmr;
    private final int[] zzms;
    private final int[] zzmt;
    private final int[] zzmu;
    private final zzdw zzmv;
    private final zzcy zzmw;
    private final zzex<?, ?> zzmx;
    private final zzbu<?> zzmy;
    private final zzdj zzmz;

    private zzds(int[] iArr, Object[] objArr, int i, int i2, int i3, zzdo zzdo, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, zzdw zzdw, zzcy zzcy, zzex<?, ?> zzex, zzbu<?> zzbu, zzdj zzdj) {
        zzdo zzdo2 = zzdo;
        zzbu<?> zzbu2 = zzbu;
        this.zzmi = iArr;
        this.zzmj = objArr;
        this.zzmk = i;
        this.zzml = i2;
        this.zzmm = i3;
        this.zzmp = zzdo2 instanceof zzcg;
        this.zzmq = z;
        this.zzmo = zzbu2 != null && zzbu2.zze(zzdo);
        this.zzmr = false;
        this.zzms = iArr2;
        this.zzmt = iArr3;
        this.zzmu = iArr4;
        this.zzmv = zzdw;
        this.zzmw = zzcy;
        this.zzmx = zzex;
        this.zzmy = zzbu2;
        this.zzmn = zzdo2;
        this.zzmz = zzdj;
    }

    private static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzay zzay) throws IOException {
        return zzax.zza(i, bArr, i2, i3, zzn(obj), zzay);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzds.zza(com.google.android.gms.internal.clearcut.zzef, byte[], int, int, com.google.android.gms.internal.clearcut.zzay):int
     arg types: [com.google.android.gms.internal.clearcut.zzef<?>, byte[], int, int, com.google.android.gms.internal.clearcut.zzay]
     candidates:
      com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.clearcut.zzay):void
      com.google.android.gms.internal.clearcut.zzef.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.clearcut.zzay):void
      com.google.android.gms.internal.clearcut.zzds.zza(com.google.android.gms.internal.clearcut.zzef, byte[], int, int, com.google.android.gms.internal.clearcut.zzay):int */
    private static int zza(zzef<?> zzef, int i, byte[] bArr, int i2, int i3, zzcn<?> zzcn, zzay zzay) throws IOException {
        int zza = zza((zzef) zzef, bArr, i2, i3, zzay);
        while (true) {
            zzcn.add(zzay.zzff);
            if (zza >= i3) {
                break;
            }
            int zza2 = zzax.zza(bArr, zza, zzay);
            if (i != zzay.zzfd) {
                break;
            }
            zza = zza((zzef) zzef, bArr, zza2, i3, zzay);
        }
        return zza;
    }

    private static int zza(zzef zzef, byte[] bArr, int i, int i2, int i3, zzay zzay) throws IOException {
        zzds zzds = (zzds) zzef;
        Object newInstance = zzds.newInstance();
        int zza = zzds.zza(newInstance, bArr, i, i2, i3, zzay);
        zzds.zzc(newInstance);
        zzay.zzff = newInstance;
        return zza;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r8v4, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed */
    private static int zza(zzef zzef, byte[] bArr, int i, int i2, zzay zzay) throws IOException {
        int i3 = i + 1;
        byte b = bArr[i];
        byte b2 = b;
        if (b < 0) {
            i3 = zzax.zza(b, bArr, i3, zzay);
            b2 = zzay.zzfd;
        }
        byte b3 = i3;
        if (b2 < 0 || b2 > i2 - b3) {
            throw zzco.zzbl();
        }
        Object newInstance = zzef.newInstance();
        int i4 = b2 + b3;
        zzef.zza(newInstance, bArr, b3, i4, zzay);
        zzef.zzc(newInstance);
        zzay.zzff = newInstance;
        return i4;
    }

    private static <UT, UB> int zza(zzex<UT, UB> zzex, T t) {
        return zzex.zzm(zzex.zzq(t));
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzay zzay) throws IOException {
        int i9;
        Object obj;
        Object obj2;
        Object obj3;
        long j2;
        int zzb;
        int i10;
        int i11;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i12 = i;
        int i13 = i3;
        int i14 = i4;
        int i15 = i5;
        long j3 = j;
        int i16 = i8;
        zzay zzay2 = zzay;
        Unsafe unsafe = zzmh;
        long j4 = (long) (this.zzmi[i16 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i15 == 1) {
                    obj = Double.valueOf(zzax.zze(bArr, i));
                    unsafe.putObject(t2, j3, obj);
                    i9 = i12 + 8;
                    unsafe.putInt(t2, j4, i14);
                    return i9;
                }
                return i12;
            case 52:
                if (i15 == 5) {
                    obj2 = Float.valueOf(zzax.zzf(bArr, i));
                    unsafe.putObject(t2, j3, obj2);
                    i9 = i12 + 4;
                    unsafe.putInt(t2, j4, i14);
                    return i9;
                }
                return i12;
            case 53:
            case 54:
                if (i15 == 0) {
                    zzb = zzax.zzb(bArr2, i12, zzay2);
                    j2 = zzay2.zzfe;
                    obj3 = Long.valueOf(j2);
                    unsafe.putObject(t2, j3, obj3);
                    unsafe.putInt(t2, j4, i14);
                    return i9;
                }
                return i12;
            case 55:
            case 62:
                if (i15 == 0) {
                    i9 = zzax.zza(bArr2, i12, zzay2);
                    i10 = zzay2.zzfd;
                    obj3 = Integer.valueOf(i10);
                    unsafe.putObject(t2, j3, obj3);
                    unsafe.putInt(t2, j4, i14);
                    return i9;
                }
                return i12;
            case 56:
            case 65:
                if (i15 == 1) {
                    obj = Long.valueOf(zzax.zzd(bArr, i));
                    unsafe.putObject(t2, j3, obj);
                    i9 = i12 + 8;
                    unsafe.putInt(t2, j4, i14);
                    return i9;
                }
                return i12;
            case 57:
            case 64:
                if (i15 == 5) {
                    obj2 = Integer.valueOf(zzax.zzc(bArr, i));
                    unsafe.putObject(t2, j3, obj2);
                    i9 = i12 + 4;
                    unsafe.putInt(t2, j4, i14);
                    return i9;
                }
                return i12;
            case 58:
                if (i15 == 0) {
                    i9 = zzax.zzb(bArr2, i12, zzay2);
                    obj3 = Boolean.valueOf(zzay2.zzfe != 0);
                    unsafe.putObject(t2, j3, obj3);
                    unsafe.putInt(t2, j4, i14);
                    return i9;
                }
                return i12;
            case 59:
                if (i15 == 2) {
                    i9 = zzax.zza(bArr2, i12, zzay2);
                    i11 = zzay2.zzfd;
                    if (i11 == 0) {
                        obj3 = "";
                        unsafe.putObject(t2, j3, obj3);
                        unsafe.putInt(t2, j4, i14);
                        return i9;
                    } else if ((i6 & 536870912) == 0 || zzff.zze(bArr2, i9, i9 + i11)) {
                        unsafe.putObject(t2, j3, new String(bArr2, i9, i11, zzci.UTF_8));
                        i9 += i11;
                        unsafe.putInt(t2, j4, i14);
                        return i9;
                    } else {
                        throw zzco.zzbp();
                    }
                }
                return i12;
            case 60:
                if (i15 == 2) {
                    i9 = zza(zzad(i16), bArr2, i12, i2, zzay2);
                    Object object = unsafe.getInt(t2, j4) == i14 ? unsafe.getObject(t2, j3) : null;
                    obj3 = object == null ? zzay2.zzff : zzci.zza(object, zzay2.zzff);
                    unsafe.putObject(t2, j3, obj3);
                    unsafe.putInt(t2, j4, i14);
                    return i9;
                }
                return i12;
            case 61:
                if (i15 == 2) {
                    i9 = zzax.zza(bArr2, i12, zzay2);
                    i11 = zzay2.zzfd;
                    if (i11 == 0) {
                        obj3 = zzbb.zzfi;
                        unsafe.putObject(t2, j3, obj3);
                        unsafe.putInt(t2, j4, i14);
                        return i9;
                    }
                    unsafe.putObject(t2, j3, zzbb.zzb(bArr2, i9, i11));
                    i9 += i11;
                    unsafe.putInt(t2, j4, i14);
                    return i9;
                }
                return i12;
            case 63:
                if (i15 == 0) {
                    int zza = zzax.zza(bArr2, i12, zzay2);
                    int i17 = zzay2.zzfd;
                    zzck<?> zzaf = zzaf(i16);
                    if (zzaf == null || zzaf.zzb(i17) != null) {
                        unsafe.putObject(t2, j3, Integer.valueOf(i17));
                        i9 = zza;
                        unsafe.putInt(t2, j4, i14);
                        return i9;
                    }
                    zzn(t).zzb(i13, Long.valueOf((long) i17));
                    return zza;
                }
                return i12;
            case 66:
                if (i15 == 0) {
                    i9 = zzax.zza(bArr2, i12, zzay2);
                    i10 = zzbk.zzm(zzay2.zzfd);
                    obj3 = Integer.valueOf(i10);
                    unsafe.putObject(t2, j3, obj3);
                    unsafe.putInt(t2, j4, i14);
                    return i9;
                }
                return i12;
            case 67:
                if (i15 == 0) {
                    zzb = zzax.zzb(bArr2, i12, zzay2);
                    j2 = zzbk.zza(zzay2.zzfe);
                    obj3 = Long.valueOf(j2);
                    unsafe.putObject(t2, j3, obj3);
                    unsafe.putInt(t2, j4, i14);
                    return i9;
                }
                return i12;
            case 68:
                if (i15 == 3) {
                    i9 = zza(zzad(i16), bArr, i, i2, (i13 & -8) | 4, zzay);
                    Object object2 = unsafe.getInt(t2, j4) == i14 ? unsafe.getObject(t2, j3) : null;
                    obj3 = object2 == null ? zzay2.zzff : zzci.zza(object2, zzay2.zzff);
                    unsafe.putObject(t2, j3, obj3);
                    unsafe.putInt(t2, j4, i14);
                    return i9;
                }
                return i12;
            default:
                return i12;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0236, code lost:
        if (r7.zzfe != 0) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0238, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x023a, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x023b, code lost:
        r11.addBoolean(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x023e, code lost:
        if (r4 >= r5) goto L_0x039f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0240, code lost:
        r6 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0246, code lost:
        if (r2 != r7.zzfd) goto L_0x039f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0248, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0250, code lost:
        if (r7.zzfe == 0) goto L_0x023a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x013a, code lost:
        if (r4 == 0) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013c, code lost:
        r11.add(com.google.android.gms.internal.clearcut.zzbb.zzfi);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0142, code lost:
        r11.add(com.google.android.gms.internal.clearcut.zzbb.zzb(r3, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x014a, code lost:
        if (r1 >= r5) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x014c, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0152, code lost:
        if (r2 != r7.zzfd) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7);
        r4 = r7.zzfd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x015a, code lost:
        if (r4 != 0) goto L_0x0142;
     */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01d7  */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzay zzay) throws IOException {
        int zzb;
        int i8;
        int zza;
        int zzb2;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i5;
        int i13 = i6;
        long j3 = j2;
        zzay zzay2 = zzay;
        zzcn zzcn = (zzcn) zzmh.getObject(t2, j3);
        if (!zzcn.zzu()) {
            int size = zzcn.size();
            zzcn = zzcn.zzi(size == 0 ? 10 : size << 1);
            zzmh.putObject(t2, j3, zzcn);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i12 == 2) {
                    zzbq zzbq = (zzbq) zzcn;
                    int zza2 = zzax.zza(bArr2, i9, zzay2);
                    int i14 = zzay2.zzfd + zza2;
                    while (zza2 < i14) {
                        zzbq.zzc(zzax.zze(bArr2, zza2));
                        zza2 += 8;
                    }
                    if (zza2 == i14) {
                        return zza2;
                    }
                    throw zzco.zzbl();
                }
                if (i12 == 1) {
                    zzbq zzbq2 = (zzbq) zzcn;
                    zzbq2.zzc(zzax.zze(bArr, i));
                    while (true) {
                        int i15 = i9 + 8;
                        if (i15 >= i10) {
                            return i15;
                        }
                        i9 = zzax.zza(bArr2, i15, zzay2);
                        if (i11 != zzay2.zzfd) {
                            return i15;
                        }
                        zzbq2.zzc(zzax.zze(bArr2, i9));
                    }
                }
                return i9;
            case 19:
            case 36:
                if (i12 == 2) {
                    zzce zzce = (zzce) zzcn;
                    int zza3 = zzax.zza(bArr2, i9, zzay2);
                    int i16 = zzay2.zzfd + zza3;
                    while (zza3 < i16) {
                        zzce.zzc(zzax.zzf(bArr2, zza3));
                        zza3 += 4;
                    }
                    if (zza3 == i16) {
                        return zza3;
                    }
                    throw zzco.zzbl();
                }
                if (i12 == 5) {
                    zzce zzce2 = (zzce) zzcn;
                    zzce2.zzc(zzax.zzf(bArr, i));
                    while (true) {
                        int i17 = i9 + 4;
                        if (i17 >= i10) {
                            return i17;
                        }
                        i9 = zzax.zza(bArr2, i17, zzay2);
                        if (i11 != zzay2.zzfd) {
                            return i17;
                        }
                        zzce2.zzc(zzax.zzf(bArr2, i9));
                    }
                }
                return i9;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i12 == 2) {
                    zzdc zzdc = (zzdc) zzcn;
                    int zza4 = zzax.zza(bArr2, i9, zzay2);
                    int i18 = zzay2.zzfd + zza4;
                    while (zza4 < i18) {
                        zza4 = zzax.zzb(bArr2, zza4, zzay2);
                        zzdc.zzm(zzay2.zzfe);
                    }
                    if (zza4 == i18) {
                        return zza4;
                    }
                    throw zzco.zzbl();
                }
                if (i12 == 0) {
                    zzdc zzdc2 = (zzdc) zzcn;
                    do {
                        zzb = zzax.zzb(bArr2, i9, zzay2);
                        zzdc2.zzm(zzay2.zzfe);
                        if (zzb >= i10) {
                            return zzb;
                        }
                        i9 = zzax.zza(bArr2, zzb, zzay2);
                    } while (i11 == zzay2.zzfd);
                    return zzb;
                }
                return i9;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i12 == 2) {
                    return zzax.zza(bArr2, i9, zzcn, zzay2);
                }
                if (i12 == 0) {
                    return zzax.zza(i3, bArr, i, i2, zzcn, zzay);
                }
                return i9;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i12 == 2) {
                    zzdc zzdc3 = (zzdc) zzcn;
                    int zza5 = zzax.zza(bArr2, i9, zzay2);
                    int i19 = zzay2.zzfd + zza5;
                    while (zza5 < i19) {
                        zzdc3.zzm(zzax.zzd(bArr2, zza5));
                        zza5 += 8;
                    }
                    if (zza5 == i19) {
                        return zza5;
                    }
                    throw zzco.zzbl();
                }
                if (i12 == 1) {
                    zzdc zzdc4 = (zzdc) zzcn;
                    zzdc4.zzm(zzax.zzd(bArr, i));
                    while (true) {
                        int i20 = i9 + 8;
                        if (i20 >= i10) {
                            return i20;
                        }
                        i9 = zzax.zza(bArr2, i20, zzay2);
                        if (i11 != zzay2.zzfd) {
                            return i20;
                        }
                        zzdc4.zzm(zzax.zzd(bArr2, i9));
                    }
                }
                return i9;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i12 == 2) {
                    zzch zzch = (zzch) zzcn;
                    int zza6 = zzax.zza(bArr2, i9, zzay2);
                    int i21 = zzay2.zzfd + zza6;
                    while (zza6 < i21) {
                        zzch.zzac(zzax.zzc(bArr2, zza6));
                        zza6 += 4;
                    }
                    if (zza6 == i21) {
                        return zza6;
                    }
                    throw zzco.zzbl();
                }
                if (i12 == 5) {
                    zzch zzch2 = (zzch) zzcn;
                    zzch2.zzac(zzax.zzc(bArr, i));
                    while (true) {
                        int i22 = i9 + 4;
                        if (i22 >= i10) {
                            return i22;
                        }
                        i9 = zzax.zza(bArr2, i22, zzay2);
                        if (i11 != zzay2.zzfd) {
                            return i22;
                        }
                        zzch2.zzac(zzax.zzc(bArr2, i9));
                    }
                }
                return i9;
            case 25:
            case 42:
                if (i12 == 2) {
                    zzaz zzaz = (zzaz) zzcn;
                    int zza7 = zzax.zza(bArr2, i9, zzay2);
                    int i23 = zzay2.zzfd + zza7;
                    while (i8 < i23) {
                        zza7 = zzax.zzb(bArr2, i8, zzay2);
                        zzaz.addBoolean(zzay2.zzfe != 0);
                    }
                    if (i8 != i23) {
                        throw zzco.zzbl();
                    }
                    return i8;
                }
                if (i12 == 0) {
                    zzaz zzaz2 = (zzaz) zzcn;
                    int zzb3 = zzax.zzb(bArr2, i9, zzay2);
                    break;
                }
                return i9;
            case 26:
                if (i12 == 2) {
                    if ((j & 536870912) == 0) {
                        int zza8 = zzax.zza(bArr2, i9, zzay2);
                        int i24 = zzay2.zzfd;
                        if (i24 != 0) {
                            String str = new String(bArr2, zza8, i24, zzci.UTF_8);
                            zzcn.add(str);
                            zza8 += i24;
                            if (i9 < i10) {
                                int zza9 = zzax.zza(bArr2, i9, zzay2);
                                if (i11 == zzay2.zzfd) {
                                    zza8 = zzax.zza(bArr2, zza9, zzay2);
                                    i24 = zzay2.zzfd;
                                    if (i24 != 0) {
                                        str = new String(bArr2, zza8, i24, zzci.UTF_8);
                                        zzcn.add(str);
                                        zza8 += i24;
                                        if (i9 < i10) {
                                        }
                                    }
                                }
                            }
                        }
                        zzcn.add("");
                        if (i9 < i10) {
                        }
                    } else {
                        int zza10 = zzax.zza(bArr2, i9, zzay2);
                        int i25 = zzay2.zzfd;
                        if (i25 != 0) {
                            int i26 = zza10 + i25;
                            if (zzff.zze(bArr2, zza10, i26)) {
                                String str2 = new String(bArr2, zza10, i25, zzci.UTF_8);
                                zzcn.add(str2);
                                zza10 = i26;
                                if (i9 < i10) {
                                    int zza11 = zzax.zza(bArr2, i9, zzay2);
                                    if (i11 == zzay2.zzfd) {
                                        zza10 = zzax.zza(bArr2, zza11, zzay2);
                                        int i27 = zzay2.zzfd;
                                        if (i27 != 0) {
                                            i26 = zza10 + i27;
                                            if (zzff.zze(bArr2, zza10, i26)) {
                                                str2 = new String(bArr2, zza10, i27, zzci.UTF_8);
                                                zzcn.add(str2);
                                                zza10 = i26;
                                                if (i9 < i10) {
                                                }
                                            }
                                            throw zzco.zzbp();
                                        }
                                    }
                                }
                            } else {
                                throw zzco.zzbp();
                            }
                        }
                        zzcn.add("");
                        if (i9 < i10) {
                        }
                    }
                }
                return i9;
            case 27:
                if (i12 == 2) {
                    return zza(zzad(i13), i3, bArr, i, i2, zzcn, zzay);
                }
                return i9;
            case 28:
                if (i12 == 2) {
                    int zza12 = zzax.zza(bArr2, i9, zzay2);
                    int i28 = zzay2.zzfd;
                    break;
                }
                return i9;
            case 30:
            case 44:
                if (i12 == 2) {
                    i8 = zzax.zza(bArr2, i9, zzcn, zzay2);
                } else {
                    if (i12 == 0) {
                        i8 = zzax.zza(i3, bArr, i, i2, zzcn, zzay);
                    }
                    return i9;
                }
                zzcg zzcg = (zzcg) t2;
                zzey zzey = zzcg.zzjp;
                if (zzey == zzey.zzea()) {
                    zzey = null;
                }
                zzey zzey2 = (zzey) zzeh.zza(i4, zzcn, zzaf(i13), zzey, this.zzmx);
                if (zzey2 != null) {
                    zzcg.zzjp = zzey2;
                }
                return i8;
            case 33:
            case 47:
                if (i12 == 2) {
                    zzch zzch3 = (zzch) zzcn;
                    int zza13 = zzax.zza(bArr2, i9, zzay2);
                    int i29 = zzay2.zzfd + zza13;
                    while (zza13 < i29) {
                        zza13 = zzax.zza(bArr2, zza13, zzay2);
                        zzch3.zzac(zzbk.zzm(zzay2.zzfd));
                    }
                    if (zza13 == i29) {
                        return zza13;
                    }
                    throw zzco.zzbl();
                }
                if (i12 == 0) {
                    zzch zzch4 = (zzch) zzcn;
                    do {
                        zza = zzax.zza(bArr2, i9, zzay2);
                        zzch4.zzac(zzbk.zzm(zzay2.zzfd));
                        if (zza >= i10) {
                            return zza;
                        }
                        i9 = zzax.zza(bArr2, zza, zzay2);
                    } while (i11 == zzay2.zzfd);
                    return zza;
                }
                return i9;
            case 34:
            case 48:
                if (i12 == 2) {
                    zzdc zzdc5 = (zzdc) zzcn;
                    int zza14 = zzax.zza(bArr2, i9, zzay2);
                    int i30 = zzay2.zzfd + zza14;
                    while (zza14 < i30) {
                        zza14 = zzax.zzb(bArr2, zza14, zzay2);
                        zzdc5.zzm(zzbk.zza(zzay2.zzfe));
                    }
                    if (zza14 == i30) {
                        return zza14;
                    }
                    throw zzco.zzbl();
                }
                if (i12 == 0) {
                    zzdc zzdc6 = (zzdc) zzcn;
                    do {
                        zzb2 = zzax.zzb(bArr2, i9, zzay2);
                        zzdc6.zzm(zzbk.zza(zzay2.zzfe));
                        if (zzb2 >= i10) {
                            return zzb2;
                        }
                        i9 = zzax.zza(bArr2, zzb2, zzay2);
                    } while (i11 == zzay2.zzfd);
                    return zzb2;
                }
                return i9;
            case 49:
                if (i12 == 3) {
                    zzef zzad = zzad(i13);
                    int i31 = (i11 & -8) | 4;
                    i9 = zza(zzad, bArr, i, i2, i31, zzay);
                    while (true) {
                        zzcn.add(zzay2.zzff);
                        if (i9 < i10) {
                            int zza15 = zzax.zza(bArr2, i9, zzay2);
                            if (i11 == zzay2.zzfd) {
                                i9 = zza(zzad, bArr, zza15, i2, i31, zzay);
                            }
                        }
                    }
                }
                return i9;
            default:
                return i9;
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, long j, zzay zzay) throws IOException {
        Unsafe unsafe = zzmh;
        Object zzae = zzae(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzmz.zzi(object)) {
            Object zzk = this.zzmz.zzk(zzae);
            this.zzmz.zzb(zzk, object);
            unsafe.putObject(t, j, zzk);
            object = zzk;
        }
        zzdh<?, ?> zzl = this.zzmz.zzl(zzae);
        Map<?, ?> zzg = this.zzmz.zzg(object);
        int zza = zzax.zza(bArr, i, zzay);
        int i5 = zzay.zzfd;
        if (i5 < 0 || i5 > i2 - zza) {
            throw zzco.zzbl();
        }
        int i6 = i5 + zza;
        K k = zzl.zzmc;
        V v = zzl.zzdu;
        while (zza < i6) {
            int i7 = zza + 1;
            byte b = bArr[zza];
            int i8 = b;
            if (b < 0) {
                i7 = zzax.zza(b, bArr, i7, zzay);
                i8 = zzay.zzfd;
            }
            int i9 = i7;
            int i10 = i8 >>> 3;
            int i11 = i8 & 7;
            if (i10 != 1) {
                if (i10 == 2 && i11 == zzl.zzmd.zzel()) {
                    zza = zza(bArr, i9, i2, zzl.zzmd, zzl.zzdu.getClass(), zzay);
                    v = zzay.zzff;
                }
            } else if (i11 == zzl.zzmb.zzel()) {
                zza = zza(bArr, i9, i2, zzl.zzmb, (Class<?>) null, zzay);
                k = zzay.zzff;
            }
            zza = zzax.zza(i8, bArr, i9, i2, zzay);
        }
        if (zza == i6) {
            zzg.put(k, v);
            return i6;
        }
        throw zzco.zzbo();
    }

    /* JADX WARN: Type inference failed for: r31v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v44, types: [int] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, boolean):void
     arg types: [T, long, boolean]
     candidates:
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.clearcut.zzfd.zza(byte[], long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, float):void
     arg types: [T, long, float]
     candidates:
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.clearcut.zzfd.zza(byte[], long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, float):void */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02fa, code lost:
        if (r0 == r15) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x033b, code lost:
        if (r0 == r15) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0359, code lost:
        if (r0 == r15) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x035b, code lost:
        r6 = r29;
        r7 = r31;
        r2 = r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0371 A[ADDED_TO_REGION] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final int zza(T t, byte[] bArr, int i, int i2, int r31, zzay zzay) throws IOException {
        int i3;
        int i4;
        Unsafe unsafe;
        byte b;
        int i5;
        byte b2;
        T t2;
        zzck<?> zzaf;
        byte b3;
        int i6;
        byte b4;
        int i7;
        int zza;
        byte[] bArr2;
        int i8;
        zzay zzay2;
        byte b5;
        byte b6;
        int i9;
        int i10;
        byte b7;
        int i11;
        int i12;
        byte[] bArr3;
        zzay zzay3;
        int i13;
        zzay zzay4;
        byte[] bArr4;
        int i14;
        int i15;
        long j;
        Object obj;
        zzay zzay5;
        int i16;
        zzay zzay6;
        int i17;
        byte[] bArr5;
        Object obj2;
        zzds zzds = this;
        T t3 = t;
        byte[] bArr6 = bArr;
        int i18 = i2;
        byte b8 = r31;
        zzay zzay7 = zzay;
        Unsafe unsafe2 = zzmh;
        int i19 = -1;
        int i20 = i;
        byte b9 = 0;
        int i21 = 0;
        int i22 = -1;
        while (true) {
            if (i20 < i18) {
                int i23 = i20 + 1;
                byte b10 = bArr6[i20];
                if (b10 < 0) {
                    i6 = zzax.zza(b10, bArr6, i23, zzay7);
                    b3 = zzay7.zzfd;
                } else {
                    b3 = b10;
                    i6 = i23;
                }
                int i24 = b3 >>> 3;
                byte b11 = b3 & 7;
                int zzai = zzds.zzai(i24);
                if (zzai != i19) {
                    int[] iArr = zzds.zzmi;
                    int i25 = iArr[zzai + 1];
                    int i26 = (i25 & 267386880) >>> 20;
                    byte b12 = b3;
                    long j2 = (long) (i25 & 1048575);
                    int i27 = i25;
                    if (i26 <= 17) {
                        int i28 = iArr[zzai + 2];
                        int i29 = 1 << (i28 >>> 20);
                        int i30 = i28 & 1048575;
                        if (i30 != i22) {
                            if (i22 != -1) {
                                unsafe2.putInt(t3, (long) i22, i21);
                            }
                            i21 = unsafe2.getInt(t3, (long) i30);
                            i22 = i30;
                        }
                        switch (i26) {
                            case 0:
                                b7 = b12;
                                zzay4 = zzay;
                                i11 = i6;
                                i10 = i22;
                                long j3 = j2;
                                bArr4 = bArr;
                                if (b11 == 1) {
                                    zzfd.zza(t3, j3, zzax.zze(bArr4, i11));
                                    i14 = i11 + 8;
                                    i21 |= i29;
                                    i22 = i10;
                                    i12 = i2;
                                    b9 = b7;
                                    zzay7 = zzay3;
                                    i19 = -1;
                                    b8 = r31;
                                    break;
                                }
                                i4 = i10;
                                b = r31;
                                i7 = i11;
                                i3 = i21;
                                b4 = b7;
                                unsafe = unsafe2;
                                if (b4 != b && b != 0) {
                                    i5 = i7;
                                    b2 = b4;
                                    break;
                                } else {
                                    zza = zza(b4, bArr, i7, i2, t, zzay);
                                    zzds = this;
                                    t3 = t;
                                    bArr2 = bArr;
                                    i8 = i2;
                                    zzay2 = zzay;
                                    b5 = b4;
                                    b8 = b;
                                    i22 = i4;
                                    i21 = i3;
                                    unsafe2 = unsafe;
                                    i19 = -1;
                                    break;
                                }
                            case 1:
                                b7 = b12;
                                zzay4 = zzay;
                                i11 = i6;
                                i10 = i22;
                                long j4 = j2;
                                bArr4 = bArr;
                                if (b11 == 5) {
                                    zzfd.zza((Object) t3, j4, zzax.zzf(bArr4, i11));
                                    i14 = i11 + 4;
                                    i21 |= i29;
                                    i22 = i10;
                                    i12 = i2;
                                    b9 = b7;
                                    zzay7 = zzay3;
                                    i19 = -1;
                                    b8 = r31;
                                    break;
                                }
                                i4 = i10;
                                b = r31;
                                i7 = i11;
                                i3 = i21;
                                b4 = b7;
                                unsafe = unsafe2;
                                if (b4 != b) {
                                }
                                zza = zza(b4, bArr, i7, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i8 = i2;
                                zzay2 = zzay;
                                b5 = b4;
                                b8 = b;
                                i22 = i4;
                                i21 = i3;
                                unsafe2 = unsafe;
                                i19 = -1;
                                break;
                            case 2:
                            case 3:
                                b7 = b12;
                                zzay zzay8 = zzay;
                                i11 = i6;
                                i10 = i22;
                                long j5 = j2;
                                bArr3 = bArr;
                                if (b11 == 0) {
                                    int zzb = zzax.zzb(bArr3, i11, zzay8);
                                    unsafe2.putLong(t, j5, zzay8.zzfe);
                                    i21 |= i29;
                                    i22 = i10;
                                    i12 = i2;
                                    b9 = b7;
                                    zzay7 = zzay8;
                                    i13 = zzb;
                                    i19 = -1;
                                    b8 = r31;
                                    break;
                                }
                                i4 = i10;
                                b = r31;
                                i7 = i11;
                                i3 = i21;
                                b4 = b7;
                                unsafe = unsafe2;
                                if (b4 != b) {
                                }
                                zza = zza(b4, bArr, i7, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i8 = i2;
                                zzay2 = zzay;
                                b5 = b4;
                                b8 = b;
                                i22 = i4;
                                i21 = i3;
                                unsafe2 = unsafe;
                                i19 = -1;
                                break;
                            case 4:
                            case 11:
                                b7 = b12;
                                zzay4 = zzay;
                                i11 = i6;
                                i10 = i22;
                                long j6 = j2;
                                bArr4 = bArr;
                                if (b11 == 0) {
                                    i14 = zzax.zza(bArr4, i11, zzay4);
                                    unsafe2.putInt(t3, j6, zzay4.zzfd);
                                    i21 |= i29;
                                    i22 = i10;
                                    i12 = i2;
                                    b9 = b7;
                                    zzay7 = zzay3;
                                    i19 = -1;
                                    b8 = r31;
                                    break;
                                }
                                i4 = i10;
                                b = r31;
                                i7 = i11;
                                i3 = i21;
                                b4 = b7;
                                unsafe = unsafe2;
                                if (b4 != b) {
                                }
                                zza = zza(b4, bArr, i7, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i8 = i2;
                                zzay2 = zzay;
                                b5 = b4;
                                b8 = b;
                                i22 = i4;
                                i21 = i3;
                                unsafe2 = unsafe;
                                i19 = -1;
                                break;
                            case 5:
                            case 14:
                                b7 = b12;
                                zzay4 = zzay;
                                i10 = i22;
                                long j7 = j2;
                                bArr4 = bArr;
                                if (b11 == 1) {
                                    unsafe2.putLong(t, j7, zzax.zzd(bArr4, i6));
                                    i14 = i6 + 8;
                                    i21 |= i29;
                                    i22 = i10;
                                    i12 = i2;
                                    b9 = b7;
                                    zzay7 = zzay3;
                                    i19 = -1;
                                    b8 = r31;
                                    break;
                                }
                                i11 = i6;
                                i4 = i10;
                                b = r31;
                                i7 = i11;
                                i3 = i21;
                                b4 = b7;
                                unsafe = unsafe2;
                                if (b4 != b) {
                                }
                                zza = zza(b4, bArr, i7, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i8 = i2;
                                zzay2 = zzay;
                                b5 = b4;
                                b8 = b;
                                i22 = i4;
                                i21 = i3;
                                unsafe2 = unsafe;
                                i19 = -1;
                                break;
                            case 6:
                            case 13:
                                b7 = b12;
                                i15 = i2;
                                zzay3 = zzay;
                                i10 = i22;
                                long j8 = j2;
                                bArr3 = bArr;
                                if (b11 == 5) {
                                    unsafe2.putInt(t3, j8, zzax.zzc(bArr3, i6));
                                    i13 = i6 + 4;
                                    i21 |= i29;
                                    i22 = i10;
                                    i12 = i15;
                                    b9 = b7;
                                    zzay7 = zzay3;
                                    i19 = -1;
                                    b8 = r31;
                                    break;
                                }
                                i11 = i6;
                                i4 = i10;
                                b = r31;
                                i7 = i11;
                                i3 = i21;
                                b4 = b7;
                                unsafe = unsafe2;
                                if (b4 != b) {
                                }
                                zza = zza(b4, bArr, i7, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i8 = i2;
                                zzay2 = zzay;
                                b5 = b4;
                                b8 = b;
                                i22 = i4;
                                i21 = i3;
                                unsafe2 = unsafe;
                                i19 = -1;
                                break;
                            case 7:
                                b7 = b12;
                                i15 = i2;
                                zzay3 = zzay;
                                i10 = i22;
                                long j9 = j2;
                                bArr3 = bArr;
                                if (b11 == 0) {
                                    i13 = zzax.zzb(bArr3, i6, zzay3);
                                    zzfd.zza((Object) t3, j9, zzay3.zzfe != 0);
                                    i21 |= i29;
                                    i22 = i10;
                                    i12 = i15;
                                    b9 = b7;
                                    zzay7 = zzay3;
                                    i19 = -1;
                                    b8 = r31;
                                    break;
                                }
                                i11 = i6;
                                i4 = i10;
                                b = r31;
                                i7 = i11;
                                i3 = i21;
                                b4 = b7;
                                unsafe = unsafe2;
                                if (b4 != b) {
                                }
                                zza = zza(b4, bArr, i7, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i8 = i2;
                                zzay2 = zzay;
                                b5 = b4;
                                b8 = b;
                                i22 = i4;
                                i21 = i3;
                                unsafe2 = unsafe;
                                i19 = -1;
                                break;
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                b7 = b12;
                                i15 = i2;
                                zzay3 = zzay;
                                i10 = i22;
                                j = j2;
                                bArr3 = bArr;
                                if (b11 == 2) {
                                    i13 = (i27 & 536870912) == 0 ? zzax.zzc(bArr3, i6, zzay3) : zzax.zzd(bArr3, i6, zzay3);
                                    obj = zzay3.zzff;
                                    unsafe2.putObject(t3, j, obj);
                                    i21 |= i29;
                                    i22 = i10;
                                    i12 = i15;
                                    b9 = b7;
                                    zzay7 = zzay3;
                                    i19 = -1;
                                    b8 = r31;
                                    break;
                                }
                                i11 = i6;
                                i4 = i10;
                                b = r31;
                                i7 = i11;
                                i3 = i21;
                                b4 = b7;
                                unsafe = unsafe2;
                                if (b4 != b) {
                                }
                                zza = zza(b4, bArr, i7, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i8 = i2;
                                zzay2 = zzay;
                                b5 = b4;
                                b8 = b;
                                i22 = i4;
                                i21 = i3;
                                unsafe2 = unsafe;
                                i19 = -1;
                                break;
                            case 9:
                                b7 = b12;
                                zzay3 = zzay;
                                i10 = i22;
                                j = j2;
                                bArr3 = bArr;
                                if (b11 != 2) {
                                    i11 = i6;
                                    i4 = i10;
                                    b = r31;
                                    i7 = i11;
                                    i3 = i21;
                                    b4 = b7;
                                    unsafe = unsafe2;
                                    if (b4 != b) {
                                    }
                                    zza = zza(b4, bArr, i7, i2, t, zzay);
                                    zzds = this;
                                    t3 = t;
                                    bArr2 = bArr;
                                    i8 = i2;
                                    zzay2 = zzay;
                                    b5 = b4;
                                    b8 = b;
                                    i22 = i4;
                                    i21 = i3;
                                    unsafe2 = unsafe;
                                    i19 = -1;
                                    break;
                                } else {
                                    i15 = i2;
                                    i13 = zza(zzds.zzad(zzai), bArr3, i6, i15, zzay3);
                                    obj = (i21 & i29) == 0 ? zzay3.zzff : zzci.zza(unsafe2.getObject(t3, j), zzay3.zzff);
                                    unsafe2.putObject(t3, j, obj);
                                    i21 |= i29;
                                    i22 = i10;
                                    i12 = i15;
                                    b9 = b7;
                                    zzay7 = zzay3;
                                    i19 = -1;
                                    b8 = r31;
                                    break;
                                }
                                break;
                            case 10:
                                b7 = b12;
                                zzay6 = zzay;
                                long j10 = j2;
                                i17 = -1;
                                bArr5 = bArr;
                                if (b11 == 2) {
                                    i16 = zzax.zze(bArr5, i6, zzay6);
                                    unsafe2.putObject(t3, j10, zzay6.zzff);
                                    i21 |= i29;
                                    i18 = i2;
                                    i20 = i16;
                                    b9 = b7;
                                    zzay7 = zzay5;
                                    b8 = r31;
                                    break;
                                }
                                i11 = i6;
                                i10 = i22;
                                i4 = i10;
                                b = r31;
                                i7 = i11;
                                i3 = i21;
                                b4 = b7;
                                unsafe = unsafe2;
                                if (b4 != b) {
                                }
                                zza = zza(b4, bArr, i7, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i8 = i2;
                                zzay2 = zzay;
                                b5 = b4;
                                b8 = b;
                                i22 = i4;
                                i21 = i3;
                                unsafe2 = unsafe;
                                i19 = -1;
                                break;
                            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                                b7 = b12;
                                zzay5 = zzay;
                                long j11 = j2;
                                i19 = -1;
                                bArr6 = bArr;
                                if (b11 == 0) {
                                    i20 = zzax.zza(bArr6, i6, zzay5);
                                    int i31 = zzay5.zzfd;
                                    zzck<?> zzaf2 = zzds.zzaf(zzai);
                                    if (zzaf2 == null || zzaf2.zzb(i31) != null) {
                                        unsafe2.putInt(t3, j11, i31);
                                        i21 |= i29;
                                    } else {
                                        zzn(t).zzb(b7, Long.valueOf((long) i31));
                                    }
                                    i18 = i2;
                                    b9 = b7;
                                    zzay7 = zzay5;
                                    b8 = r31;
                                    break;
                                }
                                i11 = i6;
                                i10 = i22;
                                i4 = i10;
                                b = r31;
                                i7 = i11;
                                i3 = i21;
                                b4 = b7;
                                unsafe = unsafe2;
                                if (b4 != b) {
                                }
                                zza = zza(b4, bArr, i7, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i8 = i2;
                                zzay2 = zzay;
                                b5 = b4;
                                b8 = b;
                                i22 = i4;
                                i21 = i3;
                                unsafe2 = unsafe;
                                i19 = -1;
                                break;
                            case GmsLogger.MAX_PII_TAG_LENGTH:
                                b7 = b12;
                                zzay6 = zzay;
                                long j12 = j2;
                                i17 = -1;
                                bArr5 = bArr;
                                if (b11 == 0) {
                                    i16 = zzax.zza(bArr5, i6, zzay6);
                                    unsafe2.putInt(t3, j12, zzbk.zzm(zzay6.zzfd));
                                    i21 |= i29;
                                    i18 = i2;
                                    i20 = i16;
                                    b9 = b7;
                                    zzay7 = zzay5;
                                    b8 = r31;
                                    break;
                                }
                                i11 = i6;
                                i10 = i22;
                                i4 = i10;
                                b = r31;
                                i7 = i11;
                                i3 = i21;
                                b4 = b7;
                                unsafe = unsafe2;
                                if (b4 != b) {
                                }
                                zza = zza(b4, bArr, i7, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i8 = i2;
                                zzay2 = zzay;
                                b5 = b4;
                                b8 = b;
                                i22 = i4;
                                i21 = i3;
                                unsafe2 = unsafe;
                                i19 = -1;
                                break;
                            case 16:
                                b7 = b12;
                                zzay zzay9 = zzay;
                                i19 = -1;
                                if (b11 == 0) {
                                    long j13 = j2;
                                    bArr6 = bArr;
                                    int zzb2 = zzax.zzb(bArr6, i6, zzay9);
                                    unsafe2.putLong(t, j13, zzbk.zza(zzay9.zzfe));
                                    i21 |= i29;
                                    b9 = b7;
                                    zzay7 = zzay9;
                                    i20 = zzb2;
                                    i18 = i2;
                                    b8 = r31;
                                    break;
                                }
                                i11 = i6;
                                i10 = i22;
                                i4 = i10;
                                b = r31;
                                i7 = i11;
                                i3 = i21;
                                b4 = b7;
                                unsafe = unsafe2;
                                if (b4 != b) {
                                }
                                zza = zza(b4, bArr, i7, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i8 = i2;
                                zzay2 = zzay;
                                b5 = b4;
                                b8 = b;
                                i22 = i4;
                                i21 = i3;
                                unsafe2 = unsafe;
                                i19 = -1;
                                break;
                            case 17:
                                if (b11 != 3) {
                                    b7 = b12;
                                    i11 = i6;
                                    i10 = i22;
                                    i4 = i10;
                                    b = r31;
                                    i7 = i11;
                                    i3 = i21;
                                    b4 = b7;
                                    unsafe = unsafe2;
                                    if (b4 != b) {
                                    }
                                    zza = zza(b4, bArr, i7, i2, t, zzay);
                                    zzds = this;
                                    t3 = t;
                                    bArr2 = bArr;
                                    i8 = i2;
                                    zzay2 = zzay;
                                    b5 = b4;
                                    b8 = b;
                                    i22 = i4;
                                    i21 = i3;
                                    unsafe2 = unsafe;
                                    i19 = -1;
                                    break;
                                } else {
                                    b7 = b12;
                                    i19 = -1;
                                    i20 = zza(zzds.zzad(zzai), bArr, i6, i2, (i24 << 3) | 4, zzay);
                                    if ((i21 & i29) == 0) {
                                        zzay5 = zzay;
                                        obj2 = zzay5.zzff;
                                    } else {
                                        zzay5 = zzay;
                                        obj2 = zzci.zza(unsafe2.getObject(t3, j2), zzay5.zzff);
                                    }
                                    unsafe2.putObject(t3, j2, obj2);
                                    i21 |= i29;
                                    bArr6 = bArr;
                                    i18 = i2;
                                    b9 = b7;
                                    zzay7 = zzay5;
                                    b8 = r31;
                                    break;
                                }
                                break;
                            default:
                                b7 = b12;
                                i11 = i6;
                                i10 = i22;
                                i4 = i10;
                                b = r31;
                                i7 = i11;
                                i3 = i21;
                                b4 = b7;
                                unsafe = unsafe2;
                                if (b4 != b) {
                                }
                                zza = zza(b4, bArr, i7, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i8 = i2;
                                zzay2 = zzay;
                                b5 = b4;
                                b8 = b;
                                i22 = i4;
                                i21 = i3;
                                unsafe2 = unsafe;
                                i19 = -1;
                                break;
                        }
                    } else {
                        byte b13 = b12;
                        int i32 = i6;
                        i4 = i22;
                        long j14 = j2;
                        bArr6 = bArr;
                        if (i26 != 27) {
                            i3 = i21;
                            if (i26 <= 49) {
                                int i33 = i32;
                                b6 = b13;
                                unsafe = unsafe2;
                                zza = zza(t, bArr, i32, i2, b13, i24, b11, zzai, (long) i27, i26, j14, zzay);
                            } else {
                                byte b14 = b11;
                                int i34 = i24;
                                i9 = i32;
                                long j15 = j14;
                                b6 = b13;
                                unsafe = unsafe2;
                                int i35 = i27;
                                int i36 = zzai;
                                if (i26 == 50) {
                                    if (b14 == 2) {
                                        zza = zza(t, bArr, i9, i2, i36, i34, j15, zzay);
                                    }
                                    b4 = b6;
                                    b = r31;
                                    i7 = i9;
                                    if (b4 != b) {
                                    }
                                    zza = zza(b4, bArr, i7, i2, t, zzay);
                                    zzds = this;
                                    t3 = t;
                                    bArr2 = bArr;
                                    i8 = i2;
                                    zzay2 = zzay;
                                    b5 = b4;
                                    b8 = b;
                                    i22 = i4;
                                    i21 = i3;
                                    unsafe2 = unsafe;
                                    i19 = -1;
                                } else {
                                    zza = zza(t, bArr, i9, i2, b6, i34, b14, i35, i26, j15, i36, zzay);
                                }
                            }
                            zzds = this;
                            t3 = t;
                            bArr2 = bArr;
                            b5 = b6;
                            i8 = i2;
                            b8 = r31;
                            zzay2 = zzay;
                            i22 = i4;
                            i21 = i3;
                            unsafe2 = unsafe;
                            i19 = -1;
                        } else if (b11 == 2) {
                            zzcn zzcn = (zzcn) unsafe2.getObject(t3, j14);
                            if (!zzcn.zzu()) {
                                int size = zzcn.size();
                                zzcn = zzcn.zzi(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t3, j14, zzcn);
                            }
                            zzcn zzcn2 = zzcn;
                            zzef zzad = zzds.zzad(zzai);
                            b9 = b13;
                            i20 = zza(zzad, b9, bArr, i32, i2, zzcn2, zzay);
                            i18 = i2;
                            b8 = r31;
                            i22 = i4;
                            i21 = i21;
                            i19 = -1;
                            zzay7 = zzay;
                        } else {
                            i3 = i21;
                            i9 = i32;
                            b6 = b13;
                        }
                    }
                } else {
                    i9 = i6;
                    b6 = b3;
                    i3 = i21;
                    i4 = i22;
                }
                unsafe = unsafe2;
                b4 = b6;
                b = r31;
                i7 = i9;
                if (b4 != b) {
                }
                zza = zza(b4, bArr, i7, i2, t, zzay);
                zzds = this;
                t3 = t;
                bArr2 = bArr;
                i8 = i2;
                zzay2 = zzay;
                b5 = b4;
                b8 = b;
                i22 = i4;
                i21 = i3;
                unsafe2 = unsafe;
                i19 = -1;
            } else {
                i3 = i21;
                i4 = i22;
                unsafe = unsafe2;
                b = b8;
                i5 = i20;
                b2 = b9;
            }
        }
        int i37 = i4;
        int i38 = i3;
        if (i37 != -1) {
            t2 = t;
            unsafe.putInt(t2, (long) i37, i38);
        } else {
            t2 = t;
        }
        int[] iArr2 = this.zzmt;
        if (iArr2 != null) {
            Object obj3 = null;
            for (int i39 : iArr2) {
                zzex<?, ?> zzex = this.zzmx;
                int i40 = this.zzmi[i39];
                Object zzo = zzfd.zzo(t2, (long) (zzag(i39) & 1048575));
                if (!(zzo == null || (zzaf = zzaf(i39)) == null)) {
                    obj3 = zza(i39, i40, this.zzmz.zzg(zzo), zzaf, obj3, zzex);
                }
                obj3 = (zzey) obj3;
            }
            if (obj3 != null) {
                this.zzmx.zzf(t2, obj3);
            }
        }
        if (b == 0) {
            if (i5 != i2) {
                throw zzco.zzbo();
            }
        } else if (i5 > i2 || b2 != b) {
            throw zzco.zzbo();
        }
        return i5;
    }

    private static int zza(byte[] bArr, int i, int i2, zzfl zzfl, Class<?> cls, zzay zzay) throws IOException {
        int zzb;
        Object valueOf;
        Object obj;
        Object obj2;
        int i3;
        int zza;
        long j;
        switch (zzdt.zzgq[zzfl.ordinal()]) {
            case 1:
                zzb = zzax.zzb(bArr, i, zzay);
                valueOf = Boolean.valueOf(zzay.zzfe != 0);
                zzay.zzff = valueOf;
                return zzb;
            case 2:
                return zzax.zze(bArr, i, zzay);
            case 3:
                obj = Double.valueOf(zzax.zze(bArr, i));
                zzay.zzff = obj;
                return i + 8;
            case 4:
            case 5:
                obj2 = Integer.valueOf(zzax.zzc(bArr, i));
                zzay.zzff = obj2;
                return i + 4;
            case 6:
            case 7:
                obj = Long.valueOf(zzax.zzd(bArr, i));
                zzay.zzff = obj;
                return i + 8;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                obj2 = Float.valueOf(zzax.zzf(bArr, i));
                zzay.zzff = obj2;
                return i + 4;
            case 9:
            case 10:
            case 11:
                zza = zzax.zza(bArr, i, zzay);
                i3 = zzay.zzfd;
                valueOf = Integer.valueOf(i3);
                zzay.zzff = valueOf;
                return zzb;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
            case 13:
                zzb = zzax.zzb(bArr, i, zzay);
                j = zzay.zzfe;
                valueOf = Long.valueOf(j);
                zzay.zzff = valueOf;
                return zzb;
            case 14:
                return zza(zzea.zzcm().zze(cls), bArr, i, i2, zzay);
            case GmsLogger.MAX_PII_TAG_LENGTH:
                zza = zzax.zza(bArr, i, zzay);
                i3 = zzbk.zzm(zzay.zzfd);
                valueOf = Integer.valueOf(i3);
                zzay.zzff = valueOf;
                return zzb;
            case 16:
                zzb = zzax.zzb(bArr, i, zzay);
                j = zzbk.zza(zzay.zzfe);
                valueOf = Long.valueOf(j);
                zzay.zzff = valueOf;
                return zzb;
            case 17:
                return zzax.zzd(bArr, i, zzay);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    static <T> zzds<T> zza(Class cls, zzdm zzdm, zzdw zzdw, zzcy zzcy, zzex<?, ?> zzex, zzbu<?> zzbu, zzdj zzdj) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        zzdm zzdm2 = zzdm;
        if (zzdm2 instanceof zzec) {
            zzec zzec = (zzec) zzdm2;
            boolean z = zzec.zzcf() == zzcg.zzg.zzkm;
            if (zzec.getFieldCount() == 0) {
                i3 = 0;
                i2 = 0;
                i = 0;
            } else {
                int zzcp = zzec.zzcp();
                int zzcq = zzec.zzcq();
                i3 = zzec.zzcu();
                i2 = zzcp;
                i = zzcq;
            }
            int[] iArr = new int[(i3 << 2)];
            Object[] objArr = new Object[(i3 << 1)];
            int[] iArr2 = zzec.zzcr() > 0 ? new int[zzec.zzcr()] : null;
            int[] iArr3 = zzec.zzcs() > 0 ? new int[zzec.zzcs()] : null;
            zzed zzco = zzec.zzco();
            if (zzco.next()) {
                int zzcx = zzco.zzcx();
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    if (zzcx >= zzec.zzcv() || i7 >= ((zzcx - i2) << 2)) {
                        if (zzco.zzda()) {
                            i6 = (int) zzfd.zza(zzco.zzdb());
                            i4 = (int) zzfd.zza(zzco.zzdc());
                            i5 = 0;
                        } else {
                            i6 = (int) zzfd.zza(zzco.zzdd());
                            if (zzco.zzde()) {
                                i4 = (int) zzfd.zza(zzco.zzdf());
                                i5 = zzco.zzdg();
                            } else {
                                i5 = 0;
                                i4 = 0;
                            }
                        }
                        iArr[i7] = zzco.zzcx();
                        int i10 = i7 + 1;
                        iArr[i10] = (zzco.zzdi() ? 536870912 : 0) | (zzco.zzdh() ? 268435456 : 0) | (zzco.zzcy() << 20) | i6;
                        iArr[i7 + 2] = (i5 << 20) | i4;
                        if (zzco.zzdl() != null) {
                            int i11 = (i7 / 4) << 1;
                            objArr[i11] = zzco.zzdl();
                            if (zzco.zzdj() != null) {
                                objArr[i11 + 1] = zzco.zzdj();
                            } else if (zzco.zzdk() != null) {
                                objArr[i11 + 1] = zzco.zzdk();
                            }
                        } else if (zzco.zzdj() != null) {
                            objArr[((i7 / 4) << 1) + 1] = zzco.zzdj();
                        } else if (zzco.zzdk() != null) {
                            objArr[((i7 / 4) << 1) + 1] = zzco.zzdk();
                        }
                        int zzcy2 = zzco.zzcy();
                        if (zzcy2 == zzcb.MAP.ordinal()) {
                            iArr2[i8] = i7;
                            i8++;
                        } else if (zzcy2 >= 18 && zzcy2 <= 49) {
                            iArr3[i9] = iArr[i10] & 1048575;
                            i9++;
                        }
                        if (!zzco.next()) {
                            break;
                        }
                        zzcx = zzco.zzcx();
                    } else {
                        for (int i12 = 0; i12 < 4; i12++) {
                            iArr[i7 + i12] = -1;
                        }
                    }
                    i7 += 4;
                }
            }
            return new zzds(iArr, objArr, i2, i, zzec.zzcv(), zzec.zzch(), z, false, zzec.zzct(), iArr2, iArr3, zzdw, zzcy, zzex, zzbu, zzdj);
        }
        ((zzes) zzdm2).zzcf();
        throw new NoSuchMethodError();
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzck<?> zzck, UB ub, zzex<UT, UB> zzex) {
        zzdh<?, ?> zzl = this.zzmz.zzl(zzae(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (zzck.zzb(((Integer) next.getValue()).intValue()) == null) {
                if (ub == null) {
                    ub = zzex.zzdz();
                }
                zzbg zzk = zzbb.zzk(zzdg.zza(zzl, next.getKey(), next.getValue()));
                try {
                    zzdg.zza(zzk.zzae(), zzl, next.getKey(), next.getValue());
                    zzex.zza(ub, i2, zzk.zzad());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private static void zza(int i, Object obj, zzfr zzfr) throws IOException {
        if (obj instanceof String) {
            zzfr.zza(i, (String) obj);
        } else {
            zzfr.zza(i, (zzbb) obj);
        }
    }

    private static <UT, UB> void zza(zzex<UT, UB> zzex, T t, zzfr zzfr) throws IOException {
        zzex.zza(zzex.zzq(t), zzfr);
    }

    private final <K, V> void zza(zzfr zzfr, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzfr.zza(i, this.zzmz.zzl(zzae(i2)), this.zzmz.zzh(obj));
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzag = (long) (zzag(i) & 1048575);
        if (zza(t2, i)) {
            Object zzo = zzfd.zzo(t, zzag);
            Object zzo2 = zzfd.zzo(t2, zzag);
            if (zzo != null && zzo2 != null) {
                zzfd.zza(t, zzag, zzci.zza(zzo, zzo2));
                zzb(t, i);
            } else if (zzo2 != null) {
                zzfd.zza(t, zzag, zzo2);
                zzb(t, i);
            }
        }
    }

    private final boolean zza(T t, int i) {
        if (this.zzmq) {
            int zzag = zzag(i);
            long j = (long) (zzag & 1048575);
            switch ((zzag & 267386880) >>> 20) {
                case 0:
                    return zzfd.zzn(t, j) != 0.0d;
                case 1:
                    return zzfd.zzm(t, j) != 0.0f;
                case 2:
                    return zzfd.zzk(t, j) != 0;
                case 3:
                    return zzfd.zzk(t, j) != 0;
                case 4:
                    return zzfd.zzj(t, j) != 0;
                case 5:
                    return zzfd.zzk(t, j) != 0;
                case 6:
                    return zzfd.zzj(t, j) != 0;
                case 7:
                    return zzfd.zzl(t, j);
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    Object zzo = zzfd.zzo(t, j);
                    if (zzo instanceof String) {
                        return !((String) zzo).isEmpty();
                    }
                    if (zzo instanceof zzbb) {
                        return !zzbb.zzfi.equals(zzo);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzfd.zzo(t, j) != null;
                case 10:
                    return !zzbb.zzfi.equals(zzfd.zzo(t, j));
                case 11:
                    return zzfd.zzj(t, j) != 0;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    return zzfd.zzj(t, j) != 0;
                case 13:
                    return zzfd.zzj(t, j) != 0;
                case 14:
                    return zzfd.zzk(t, j) != 0;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    return zzfd.zzj(t, j) != 0;
                case 16:
                    return zzfd.zzk(t, j) != 0;
                case 17:
                    return zzfd.zzo(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzah = zzah(i);
            return (zzfd.zzj(t, (long) (zzah & 1048575)) & (1 << (zzah >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzfd.zzj(t, (long) (zzah(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        return this.zzmq ? zza(t, i) : (i2 & i3) != 0;
    }

    private static boolean zza(Object obj, int i, zzef zzef) {
        return zzef.zzo(zzfd.zzo(obj, (long) (i & 1048575)));
    }

    private final zzef zzad(int i) {
        int i2 = (i / 4) << 1;
        zzef zzef = (zzef) this.zzmj[i2];
        if (zzef != null) {
            return zzef;
        }
        zzef zze = zzea.zzcm().zze((Class) this.zzmj[i2 + 1]);
        this.zzmj[i2] = zze;
        return zze;
    }

    private final Object zzae(int i) {
        return this.zzmj[(i / 4) << 1];
    }

    private final zzck<?> zzaf(int i) {
        return (zzck) this.zzmj[((i / 4) << 1) + 1];
    }

    private final int zzag(int i) {
        return this.zzmi[i + 1];
    }

    private final int zzah(int i) {
        return this.zzmi[i + 2];
    }

    private final int zzai(int i) {
        int i2 = this.zzmk;
        if (i >= i2) {
            int i3 = this.zzmm;
            if (i < i3) {
                int i4 = (i - i2) << 2;
                if (this.zzmi[i4] == i) {
                    return i4;
                }
                return -1;
            } else if (i <= this.zzml) {
                int i5 = i3 - i2;
                int length = (this.zzmi.length / 4) - 1;
                while (i5 <= length) {
                    int i6 = (length + i5) >>> 1;
                    int i7 = i6 << 2;
                    int i8 = this.zzmi[i7];
                    if (i == i8) {
                        return i7;
                    }
                    if (i < i8) {
                        length = i6 - 1;
                    } else {
                        i5 = i6 + 1;
                    }
                }
            }
        }
        return -1;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, int):void
     arg types: [T, long, int]
     candidates:
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.clearcut.zzfd.zza(byte[], long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, int):void */
    private final void zzb(T t, int i) {
        if (!this.zzmq) {
            int zzah = zzah(i);
            long j = (long) (zzah & 1048575);
            zzfd.zza((Object) t, j, zzfd.zzj(t, j) | (1 << (zzah >>> 20)));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, int):void
     arg types: [T, long, int]
     candidates:
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.clearcut.zzfd.zza(byte[], long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, int):void */
    private final void zzb(T t, int i, int i2) {
        zzfd.zza((Object) t, (long) (zzah(i2) & 1048575), i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzeh.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.clearcut.zzfr, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.clearcut.zzfr, int]
     candidates:
      com.google.android.gms.internal.clearcut.zzeh.zzb(int, java.util.List<?>, com.google.android.gms.internal.clearcut.zzfr, com.google.android.gms.internal.clearcut.zzef):void
      com.google.android.gms.internal.clearcut.zzeh.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.clearcut.zzfr, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzeh.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.clearcut.zzfr, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.clearcut.zzfr, int]
     candidates:
      com.google.android.gms.internal.clearcut.zzeh.zza(int, int, java.lang.Object, com.google.android.gms.internal.clearcut.zzex):UB
      com.google.android.gms.internal.clearcut.zzeh.zza(int, java.util.List<?>, com.google.android.gms.internal.clearcut.zzfr, com.google.android.gms.internal.clearcut.zzef):void
      com.google.android.gms.internal.clearcut.zzeh.zza(com.google.android.gms.internal.clearcut.zzdj, java.lang.Object, java.lang.Object, long):void
      com.google.android.gms.internal.clearcut.zzeh.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.clearcut.zzfr, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    private final void zzb(T t, zzfr zzfr) throws IOException {
        Map.Entry entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        Map.Entry entry2;
        int i2;
        boolean z;
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        boolean z6;
        List list;
        int i8;
        Map.Entry entry3;
        T t2 = t;
        zzfr zzfr2 = zzfr;
        if (this.zzmo) {
            zzby<?> zza = this.zzmy.zza((Object) t2);
            if (!zza.isEmpty()) {
                it = zza.iterator();
                entry = it.next();
                int i9 = -1;
                length = this.zzmi.length;
                Unsafe unsafe = zzmh;
                Map.Entry entry4 = entry;
                int i10 = 0;
                for (i = 0; i < length; i += 4) {
                    int zzag = zzag(i);
                    int[] iArr = this.zzmi;
                    int i11 = iArr[i];
                    int i12 = (267386880 & zzag) >>> 20;
                    if (this.zzmq || i12 > 17) {
                        entry4 = entry4;
                        i2 = 0;
                    } else {
                        int i13 = iArr[i + 2];
                        int i14 = i13 & 1048575;
                        if (i14 != i9) {
                            entry3 = entry4;
                            i10 = unsafe.getInt(t2, (long) i14);
                        } else {
                            entry3 = entry4;
                            i14 = i9;
                        }
                        i2 = 1 << (i13 >>> 20);
                        i9 = i14;
                        entry4 = entry3;
                    }
                    while (entry4 != null && this.zzmy.zza((Map.Entry<?, ?>) entry4) <= i11) {
                        this.zzmy.zza(zzfr2, entry4);
                        entry4 = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    long j = (long) (zzag & 1048575);
                    switch (i12) {
                        case 0:
                            if ((i10 & i2) != 0) {
                                zzfr2.zza(i11, zzfd.zzn(t2, j));
                                continue;
                            }
                        case 1:
                            if ((i10 & i2) != 0) {
                                zzfr2.zza(i11, zzfd.zzm(t2, j));
                            } else {
                                continue;
                            }
                        case 2:
                            if ((i10 & i2) != 0) {
                                zzfr2.zzi(i11, unsafe.getLong(t2, j));
                            } else {
                                continue;
                            }
                        case 3:
                            if ((i10 & i2) != 0) {
                                zzfr2.zza(i11, unsafe.getLong(t2, j));
                            } else {
                                continue;
                            }
                        case 4:
                            if ((i10 & i2) != 0) {
                                zzfr2.zzc(i11, unsafe.getInt(t2, j));
                            } else {
                                continue;
                            }
                        case 5:
                            if ((i10 & i2) != 0) {
                                zzfr2.zzc(i11, unsafe.getLong(t2, j));
                            } else {
                                continue;
                            }
                        case 6:
                            if ((i10 & i2) != 0) {
                                zzfr2.zzf(i11, unsafe.getInt(t2, j));
                            } else {
                                continue;
                            }
                        case 7:
                            if ((i10 & i2) != 0) {
                                zzfr2.zzb(i11, zzfd.zzl(t2, j));
                            } else {
                                continue;
                            }
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            if ((i10 & i2) != 0) {
                                zza(i11, unsafe.getObject(t2, j), zzfr2);
                            } else {
                                continue;
                            }
                        case 9:
                            if ((i10 & i2) != 0) {
                                zzfr2.zza(i11, unsafe.getObject(t2, j), zzad(i));
                            } else {
                                continue;
                            }
                        case 10:
                            if ((i10 & i2) != 0) {
                                zzfr2.zza(i11, (zzbb) unsafe.getObject(t2, j));
                            } else {
                                continue;
                            }
                        case 11:
                            if ((i10 & i2) != 0) {
                                zzfr2.zzd(i11, unsafe.getInt(t2, j));
                            } else {
                                continue;
                            }
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            if ((i10 & i2) != 0) {
                                zzfr2.zzn(i11, unsafe.getInt(t2, j));
                            } else {
                                continue;
                            }
                        case 13:
                            if ((i10 & i2) != 0) {
                                zzfr2.zzm(i11, unsafe.getInt(t2, j));
                            } else {
                                continue;
                            }
                        case 14:
                            if ((i10 & i2) != 0) {
                                zzfr2.zzj(i11, unsafe.getLong(t2, j));
                            } else {
                                continue;
                            }
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            if ((i10 & i2) != 0) {
                                zzfr2.zze(i11, unsafe.getInt(t2, j));
                            } else {
                                continue;
                            }
                        case 16:
                            if ((i10 & i2) != 0) {
                                zzfr2.zzb(i11, unsafe.getLong(t2, j));
                            } else {
                                continue;
                            }
                        case 17:
                            if ((i10 & i2) != 0) {
                                zzfr2.zzb(i11, unsafe.getObject(t2, j), zzad(i));
                            } else {
                                continue;
                            }
                        case 18:
                            zzeh.zza(this.zzmi[i], (List<Double>) ((List) unsafe.getObject(t2, j)), zzfr2, false);
                            continue;
                        case 19:
                            zzeh.zzb(this.zzmi[i], (List<Float>) ((List) unsafe.getObject(t2, j)), zzfr2, false);
                            continue;
                        case 20:
                            zzeh.zzc(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2, false);
                            continue;
                        case 21:
                            zzeh.zzd(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2, false);
                            continue;
                        case 22:
                            zzeh.zzh(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2, false);
                            continue;
                        case 23:
                            zzeh.zzf(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2, false);
                            continue;
                        case 24:
                            zzeh.zzk(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2, false);
                            continue;
                        case 25:
                            zzeh.zzn(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2, false);
                            continue;
                        case 26:
                            zzeh.zza(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2);
                            break;
                        case 27:
                            zzeh.zza(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2, zzad(i));
                            break;
                        case 28:
                            zzeh.zzb(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2);
                            break;
                        case 29:
                            z = false;
                            i3 = this.zzmi[i];
                            zzeh.zzi(i3, (List) unsafe.getObject(t2, j), zzfr2, z);
                            break;
                        case 30:
                            z2 = false;
                            i4 = this.zzmi[i];
                            zzeh.zzm(i4, (List) unsafe.getObject(t2, j), zzfr2, z2);
                            break;
                        case 31:
                            z3 = false;
                            i5 = this.zzmi[i];
                            zzeh.zzl(i5, (List) unsafe.getObject(t2, j), zzfr2, z3);
                            break;
                        case 32:
                            z4 = false;
                            i6 = this.zzmi[i];
                            zzeh.zzg(i6, (List) unsafe.getObject(t2, j), zzfr2, z4);
                            break;
                        case 33:
                            z5 = false;
                            i7 = this.zzmi[i];
                            zzeh.zzj(i7, (List) unsafe.getObject(t2, j), zzfr2, z5);
                            break;
                        case 34:
                            i8 = this.zzmi[i];
                            list = (List) unsafe.getObject(t2, j);
                            z6 = false;
                            zzeh.zze(i8, list, zzfr2, z6);
                            break;
                        case 35:
                            zzeh.zza(this.zzmi[i], (List<Double>) ((List) unsafe.getObject(t2, j)), zzfr2, true);
                            break;
                        case 36:
                            zzeh.zzb(this.zzmi[i], (List<Float>) ((List) unsafe.getObject(t2, j)), zzfr2, true);
                            break;
                        case 37:
                            zzeh.zzc(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2, true);
                            break;
                        case 38:
                            zzeh.zzd(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2, true);
                            break;
                        case 39:
                            zzeh.zzh(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2, true);
                            break;
                        case 40:
                            zzeh.zzf(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2, true);
                            break;
                        case 41:
                            zzeh.zzk(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2, true);
                            break;
                        case 42:
                            zzeh.zzn(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2, true);
                            break;
                        case 43:
                            z = true;
                            i3 = this.zzmi[i];
                            zzeh.zzi(i3, (List) unsafe.getObject(t2, j), zzfr2, z);
                            break;
                        case 44:
                            z2 = true;
                            i4 = this.zzmi[i];
                            zzeh.zzm(i4, (List) unsafe.getObject(t2, j), zzfr2, z2);
                            break;
                        case 45:
                            z3 = true;
                            i5 = this.zzmi[i];
                            zzeh.zzl(i5, (List) unsafe.getObject(t2, j), zzfr2, z3);
                            break;
                        case 46:
                            z4 = true;
                            i6 = this.zzmi[i];
                            zzeh.zzg(i6, (List) unsafe.getObject(t2, j), zzfr2, z4);
                            break;
                        case 47:
                            z5 = true;
                            i7 = this.zzmi[i];
                            zzeh.zzj(i7, (List) unsafe.getObject(t2, j), zzfr2, z5);
                            break;
                        case 48:
                            i8 = this.zzmi[i];
                            list = (List) unsafe.getObject(t2, j);
                            z6 = true;
                            zzeh.zze(i8, list, zzfr2, z6);
                            break;
                        case 49:
                            zzeh.zzb(this.zzmi[i], (List) unsafe.getObject(t2, j), zzfr2, zzad(i));
                            break;
                        case 50:
                            zza(zzfr2, i11, unsafe.getObject(t2, j), i);
                            break;
                        case 51:
                            if (zza(t2, i11, i)) {
                                zzfr2.zza(i11, zze(t2, j));
                                break;
                            }
                            break;
                        case 52:
                            if (zza(t2, i11, i)) {
                                zzfr2.zza(i11, zzf(t2, j));
                                break;
                            }
                            break;
                        case 53:
                            if (zza(t2, i11, i)) {
                                zzfr2.zzi(i11, zzh(t2, j));
                                break;
                            }
                            break;
                        case 54:
                            if (zza(t2, i11, i)) {
                                zzfr2.zza(i11, zzh(t2, j));
                                break;
                            }
                            break;
                        case 55:
                            if (zza(t2, i11, i)) {
                                zzfr2.zzc(i11, zzg(t2, j));
                                break;
                            }
                            break;
                        case 56:
                            if (zza(t2, i11, i)) {
                                zzfr2.zzc(i11, zzh(t2, j));
                                break;
                            }
                            break;
                        case 57:
                            if (zza(t2, i11, i)) {
                                zzfr2.zzf(i11, zzg(t2, j));
                                break;
                            }
                            break;
                        case 58:
                            if (zza(t2, i11, i)) {
                                zzfr2.zzb(i11, zzi(t2, j));
                                break;
                            }
                            break;
                        case 59:
                            if (zza(t2, i11, i)) {
                                zza(i11, unsafe.getObject(t2, j), zzfr2);
                                break;
                            }
                            break;
                        case 60:
                            if (zza(t2, i11, i)) {
                                zzfr2.zza(i11, unsafe.getObject(t2, j), zzad(i));
                                break;
                            }
                            break;
                        case 61:
                            if (zza(t2, i11, i)) {
                                zzfr2.zza(i11, (zzbb) unsafe.getObject(t2, j));
                                break;
                            }
                            break;
                        case 62:
                            if (zza(t2, i11, i)) {
                                zzfr2.zzd(i11, zzg(t2, j));
                                break;
                            }
                            break;
                        case 63:
                            if (zza(t2, i11, i)) {
                                zzfr2.zzn(i11, zzg(t2, j));
                                break;
                            }
                            break;
                        case 64:
                            if (zza(t2, i11, i)) {
                                zzfr2.zzm(i11, zzg(t2, j));
                                break;
                            }
                            break;
                        case 65:
                            if (zza(t2, i11, i)) {
                                zzfr2.zzj(i11, zzh(t2, j));
                                break;
                            }
                            break;
                        case 66:
                            if (zza(t2, i11, i)) {
                                zzfr2.zze(i11, zzg(t2, j));
                                break;
                            }
                            break;
                        case 67:
                            if (zza(t2, i11, i)) {
                                zzfr2.zzb(i11, zzh(t2, j));
                                break;
                            }
                            break;
                        case 68:
                            if (zza(t2, i11, i)) {
                                zzfr2.zzb(i11, unsafe.getObject(t2, j), zzad(i));
                                break;
                            }
                            break;
                    }
                }
                for (entry2 = entry4; entry2 != null; entry2 = it.hasNext() ? (Map.Entry) it.next() : null) {
                    this.zzmy.zza(zzfr2, entry2);
                }
                zza(this.zzmx, t2, zzfr2);
            }
        }
        it = null;
        entry = null;
        int i92 = -1;
        length = this.zzmi.length;
        Unsafe unsafe2 = zzmh;
        Map.Entry entry42 = entry;
        int i102 = 0;
        while (i < length) {
        }
        while (entry2 != null) {
        }
        zza(this.zzmx, t2, zzfr2);
    }

    private final void zzb(T t, T t2, int i) {
        int zzag = zzag(i);
        int i2 = this.zzmi[i];
        long j = (long) (zzag & 1048575);
        if (zza(t2, i2, i)) {
            Object zzo = zzfd.zzo(t, j);
            Object zzo2 = zzfd.zzo(t2, j);
            if (zzo != null && zzo2 != null) {
                zzfd.zza(t, j, zzci.zza(zzo, zzo2));
                zzb(t, i2, i);
            } else if (zzo2 != null) {
                zzfd.zza(t, j, zzo2);
                zzb(t, i2, i);
            }
        }
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzfd.zzo(obj, j);
    }

    private static <T> double zze(T t, long j) {
        return ((Double) zzfd.zzo(t, j)).doubleValue();
    }

    private static <T> float zzf(T t, long j) {
        return ((Float) zzfd.zzo(t, j)).floatValue();
    }

    private static <T> int zzg(T t, long j) {
        return ((Integer) zzfd.zzo(t, j)).intValue();
    }

    private static <T> long zzh(T t, long j) {
        return ((Long) zzfd.zzo(t, j)).longValue();
    }

    private static <T> boolean zzi(T t, long j) {
        return ((Boolean) zzfd.zzo(t, j)).booleanValue();
    }

    private static zzey zzn(Object obj) {
        zzcg zzcg = (zzcg) obj;
        zzey zzey = zzcg.zzjp;
        if (zzey != zzey.zzea()) {
            return zzey;
        }
        zzey zzeb = zzey.zzeb();
        zzcg.zzjp = zzeb;
        return zzeb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010e, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzl(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzl(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0132, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0145, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0156, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0169, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017c, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x018d, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01a0, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    public final boolean equals(T t, T t2) {
        int length = this.zzmi.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int zzag = zzag(i);
                long j = (long) (zzag & 1048575);
                switch ((zzag & 267386880) >>> 20) {
                    case 0:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 1:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 2:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 3:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 4:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 5:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 6:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 7:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 9:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 10:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 11:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 13:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 14:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 16:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 17:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                        z = zzeh.zzd(zzfd.zzo(t, j), zzfd.zzo(t2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long zzah = (long) (zzah(i) & 1048575);
                        if (zzfd.zzj(t, zzah) == zzfd.zzj(t2, zzah)) {
                            break;
                        }
                        z = false;
                        break;
                }
                if (!z) {
                    return false;
                }
                i += 4;
            } else if (!this.zzmx.zzq(t).equals(this.zzmx.zzq(t2))) {
                return false;
            } else {
                if (this.zzmo) {
                    return this.zzmy.zza((Object) t).equals(this.zzmy.zza((Object) t2));
                }
                return true;
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r2 = (r2 * 53) + r7;
     */
    public final int hashCode(T t) {
        int i;
        int i2;
        long j;
        double d;
        int i3;
        float f;
        int i4;
        boolean z;
        int i5;
        Object obj;
        Object obj2;
        int length = this.zzmi.length;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7 += 4) {
            int zzag = zzag(i7);
            int i8 = this.zzmi[i7];
            long j2 = (long) (1048575 & zzag);
            int i9 = 37;
            switch ((zzag & 267386880) >>> 20) {
                case 0:
                    i3 = i6 * 53;
                    d = zzfd.zzn(t, j2);
                    j = Double.doubleToLongBits(d);
                    i = zzci.zzl(j);
                    i6 = i2 + i;
                    break;
                case 1:
                    i4 = i6 * 53;
                    f = zzfd.zzm(t, j2);
                    i = Float.floatToIntBits(f);
                    i6 = i2 + i;
                    break;
                case 2:
                case 3:
                case 5:
                case 14:
                case 16:
                    i3 = i6 * 53;
                    j = zzfd.zzk(t, j2);
                    i = zzci.zzl(j);
                    i6 = i2 + i;
                    break;
                case 4:
                case 6:
                case 11:
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                case 13:
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    i2 = i6 * 53;
                    i = zzfd.zzj(t, j2);
                    i6 = i2 + i;
                    break;
                case 7:
                    i5 = i6 * 53;
                    z = zzfd.zzl(t, j2);
                    i = zzci.zzc(z);
                    i6 = i2 + i;
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    i2 = i6 * 53;
                    i = ((String) zzfd.zzo(t, j2)).hashCode();
                    i6 = i2 + i;
                    break;
                case 9:
                    obj = zzfd.zzo(t, j2);
                    break;
                case 10:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    i2 = i6 * 53;
                    obj2 = zzfd.zzo(t, j2);
                    i = obj2.hashCode();
                    i6 = i2 + i;
                    break;
                case 17:
                    obj = zzfd.zzo(t, j2);
                    break;
                case 51:
                    if (!zza(t, i8, i7)) {
                        break;
                    } else {
                        i3 = i6 * 53;
                        d = zze(t, j2);
                        j = Double.doubleToLongBits(d);
                        i = zzci.zzl(j);
                        i6 = i2 + i;
                        break;
                    }
                case 52:
                    if (!zza(t, i8, i7)) {
                        break;
                    } else {
                        i4 = i6 * 53;
                        f = zzf(t, j2);
                        i = Float.floatToIntBits(f);
                        i6 = i2 + i;
                        break;
                    }
                case 53:
                    if (!zza(t, i8, i7)) {
                        break;
                    }
                    i3 = i6 * 53;
                    j = zzh(t, j2);
                    i = zzci.zzl(j);
                    i6 = i2 + i;
                    break;
                case 54:
                    if (!zza(t, i8, i7)) {
                        break;
                    }
                    i3 = i6 * 53;
                    j = zzh(t, j2);
                    i = zzci.zzl(j);
                    i6 = i2 + i;
                    break;
                case 55:
                    if (!zza(t, i8, i7)) {
                        break;
                    }
                    i2 = i6 * 53;
                    i = zzg(t, j2);
                    i6 = i2 + i;
                    break;
                case 56:
                    if (!zza(t, i8, i7)) {
                        break;
                    }
                    i3 = i6 * 53;
                    j = zzh(t, j2);
                    i = zzci.zzl(j);
                    i6 = i2 + i;
                    break;
                case 57:
                    if (!zza(t, i8, i7)) {
                        break;
                    }
                    i2 = i6 * 53;
                    i = zzg(t, j2);
                    i6 = i2 + i;
                    break;
                case 58:
                    if (!zza(t, i8, i7)) {
                        break;
                    } else {
                        i5 = i6 * 53;
                        z = zzi(t, j2);
                        i = zzci.zzc(z);
                        i6 = i2 + i;
                        break;
                    }
                case 59:
                    if (!zza(t, i8, i7)) {
                        break;
                    }
                    i2 = i6 * 53;
                    i = ((String) zzfd.zzo(t, j2)).hashCode();
                    i6 = i2 + i;
                    break;
                case 60:
                    if (!zza(t, i8, i7)) {
                        break;
                    }
                    obj2 = zzfd.zzo(t, j2);
                    i2 = i6 * 53;
                    i = obj2.hashCode();
                    i6 = i2 + i;
                    break;
                case 61:
                    if (!zza(t, i8, i7)) {
                        break;
                    }
                    i2 = i6 * 53;
                    obj2 = zzfd.zzo(t, j2);
                    i = obj2.hashCode();
                    i6 = i2 + i;
                    break;
                case 62:
                    if (!zza(t, i8, i7)) {
                        break;
                    }
                    i2 = i6 * 53;
                    i = zzg(t, j2);
                    i6 = i2 + i;
                    break;
                case 63:
                    if (!zza(t, i8, i7)) {
                        break;
                    }
                    i2 = i6 * 53;
                    i = zzg(t, j2);
                    i6 = i2 + i;
                    break;
                case 64:
                    if (!zza(t, i8, i7)) {
                        break;
                    }
                    i2 = i6 * 53;
                    i = zzg(t, j2);
                    i6 = i2 + i;
                    break;
                case 65:
                    if (!zza(t, i8, i7)) {
                        break;
                    }
                    i3 = i6 * 53;
                    j = zzh(t, j2);
                    i = zzci.zzl(j);
                    i6 = i2 + i;
                    break;
                case 66:
                    if (!zza(t, i8, i7)) {
                        break;
                    }
                    i2 = i6 * 53;
                    i = zzg(t, j2);
                    i6 = i2 + i;
                    break;
                case 67:
                    if (!zza(t, i8, i7)) {
                        break;
                    }
                    i3 = i6 * 53;
                    j = zzh(t, j2);
                    i = zzci.zzl(j);
                    i6 = i2 + i;
                    break;
                case 68:
                    if (!zza(t, i8, i7)) {
                        break;
                    }
                    obj2 = zzfd.zzo(t, j2);
                    i2 = i6 * 53;
                    i = obj2.hashCode();
                    i6 = i2 + i;
                    break;
            }
        }
        int hashCode = (i6 * 53) + this.zzmx.zzq(t).hashCode();
        return this.zzmo ? (hashCode * 53) + this.zzmy.zza((Object) t).hashCode() : hashCode;
    }

    public final T newInstance() {
        return this.zzmv.newInstance(this.zzmn);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzeh.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.clearcut.zzfr, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.clearcut.zzfr, int]
     candidates:
      com.google.android.gms.internal.clearcut.zzeh.zzb(int, java.util.List<?>, com.google.android.gms.internal.clearcut.zzfr, com.google.android.gms.internal.clearcut.zzef):void
      com.google.android.gms.internal.clearcut.zzeh.zzb(int, java.util.List<java.lang.Float>, com.google.android.gms.internal.clearcut.zzfr, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzeh.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.clearcut.zzfr, boolean):void
     arg types: [int, java.util.List, com.google.android.gms.internal.clearcut.zzfr, int]
     candidates:
      com.google.android.gms.internal.clearcut.zzeh.zza(int, int, java.lang.Object, com.google.android.gms.internal.clearcut.zzex):UB
      com.google.android.gms.internal.clearcut.zzeh.zza(int, java.util.List<?>, com.google.android.gms.internal.clearcut.zzfr, com.google.android.gms.internal.clearcut.zzef):void
      com.google.android.gms.internal.clearcut.zzeh.zza(com.google.android.gms.internal.clearcut.zzdj, java.lang.Object, java.lang.Object, long):void
      com.google.android.gms.internal.clearcut.zzeh.zza(int, java.util.List<java.lang.Double>, com.google.android.gms.internal.clearcut.zzfr, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04f7  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0977  */
    public final void zza(T t, zzfr zzfr) throws IOException {
        Map.Entry entry;
        Iterator it;
        int length;
        Map.Entry entry2;
        int i;
        double d;
        float f;
        long j;
        long j2;
        int i2;
        long j3;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        long j4;
        int i7;
        long j5;
        Map.Entry entry3;
        Iterator it2;
        int length2;
        double d2;
        float f2;
        long j6;
        long j7;
        int i8;
        long j8;
        int i9;
        boolean z2;
        int i10;
        int i11;
        int i12;
        long j9;
        int i13;
        long j10;
        if (zzfr.zzaj() == zzcg.zzg.zzkp) {
            zza(this.zzmx, t, zzfr);
            if (this.zzmo) {
                zzby<?> zza = this.zzmy.zza((Object) t);
                if (!zza.isEmpty()) {
                    it2 = zza.descendingIterator();
                    entry3 = (Map.Entry) it2.next();
                    for (length2 = this.zzmi.length - 4; length2 >= 0; length2 -= 4) {
                        int zzag = zzag(length2);
                        int i14 = this.zzmi[length2];
                        while (entry3 != null && this.zzmy.zza((Map.Entry<?, ?>) entry3) > i14) {
                            this.zzmy.zza(zzfr, entry3);
                            entry3 = it2.hasNext() ? (Map.Entry) it2.next() : null;
                        }
                        switch ((zzag & 267386880) >>> 20) {
                            case 0:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    d2 = zzfd.zzn(t, (long) (zzag & 1048575));
                                    zzfr.zza(i14, d2);
                                    break;
                                }
                            case 1:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    f2 = zzfd.zzm(t, (long) (zzag & 1048575));
                                    zzfr.zza(i14, f2);
                                    break;
                                }
                            case 2:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    j6 = zzfd.zzk(t, (long) (zzag & 1048575));
                                    zzfr.zzi(i14, j6);
                                    break;
                                }
                            case 3:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    j7 = zzfd.zzk(t, (long) (zzag & 1048575));
                                    zzfr.zza(i14, j7);
                                    break;
                                }
                            case 4:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    i8 = zzfd.zzj(t, (long) (zzag & 1048575));
                                    zzfr.zzc(i14, i8);
                                    break;
                                }
                            case 5:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    j8 = zzfd.zzk(t, (long) (zzag & 1048575));
                                    zzfr.zzc(i14, j8);
                                    break;
                                }
                            case 6:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    i9 = zzfd.zzj(t, (long) (zzag & 1048575));
                                    zzfr.zzf(i14, i9);
                                    break;
                                }
                            case 7:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    z2 = zzfd.zzl(t, (long) (zzag & 1048575));
                                    zzfr.zzb(i14, z2);
                                    break;
                                }
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                if (!zza(t, length2)) {
                                    break;
                                }
                                zza(i14, zzfd.zzo(t, (long) (zzag & 1048575)), zzfr);
                                break;
                            case 9:
                                if (!zza(t, length2)) {
                                    break;
                                }
                                zzfr.zza(i14, zzfd.zzo(t, (long) (zzag & 1048575)), zzad(length2));
                                break;
                            case 10:
                                if (!zza(t, length2)) {
                                    break;
                                }
                                zzfr.zza(i14, (zzbb) zzfd.zzo(t, (long) (zzag & 1048575)));
                                break;
                            case 11:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    i10 = zzfd.zzj(t, (long) (zzag & 1048575));
                                    zzfr.zzd(i14, i10);
                                    break;
                                }
                            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    i11 = zzfd.zzj(t, (long) (zzag & 1048575));
                                    zzfr.zzn(i14, i11);
                                    break;
                                }
                            case 13:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    i12 = zzfd.zzj(t, (long) (zzag & 1048575));
                                    zzfr.zzm(i14, i12);
                                    break;
                                }
                            case 14:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    j9 = zzfd.zzk(t, (long) (zzag & 1048575));
                                    zzfr.zzj(i14, j9);
                                    break;
                                }
                            case GmsLogger.MAX_PII_TAG_LENGTH:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    i13 = zzfd.zzj(t, (long) (zzag & 1048575));
                                    zzfr.zze(i14, i13);
                                    break;
                                }
                            case 16:
                                if (!zza(t, length2)) {
                                    break;
                                } else {
                                    j10 = zzfd.zzk(t, (long) (zzag & 1048575));
                                    zzfr.zzb(i14, j10);
                                    break;
                                }
                            case 17:
                                if (!zza(t, length2)) {
                                    break;
                                }
                                zzfr.zzb(i14, zzfd.zzo(t, (long) (zzag & 1048575)), zzad(length2));
                                break;
                            case 18:
                                zzeh.zza(this.zzmi[length2], (List<Double>) ((List) zzfd.zzo(t, (long) (zzag & 1048575))), zzfr, false);
                                break;
                            case 19:
                                zzeh.zzb(this.zzmi[length2], (List<Float>) ((List) zzfd.zzo(t, (long) (zzag & 1048575))), zzfr, false);
                                break;
                            case 20:
                                zzeh.zzc(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 21:
                                zzeh.zzd(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 22:
                                zzeh.zzh(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 23:
                                zzeh.zzf(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 24:
                                zzeh.zzk(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 25:
                                zzeh.zzn(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 26:
                                zzeh.zza(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr);
                                break;
                            case 27:
                                zzeh.zza(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, zzad(length2));
                                break;
                            case 28:
                                zzeh.zzb(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr);
                                break;
                            case 29:
                                zzeh.zzi(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 30:
                                zzeh.zzm(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 31:
                                zzeh.zzl(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 32:
                                zzeh.zzg(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 33:
                                zzeh.zzj(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 34:
                                zzeh.zze(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 35:
                                zzeh.zza(this.zzmi[length2], (List<Double>) ((List) zzfd.zzo(t, (long) (zzag & 1048575))), zzfr, true);
                                break;
                            case 36:
                                zzeh.zzb(this.zzmi[length2], (List<Float>) ((List) zzfd.zzo(t, (long) (zzag & 1048575))), zzfr, true);
                                break;
                            case 37:
                                zzeh.zzc(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 38:
                                zzeh.zzd(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 39:
                                zzeh.zzh(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 40:
                                zzeh.zzf(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 41:
                                zzeh.zzk(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 42:
                                zzeh.zzn(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 43:
                                zzeh.zzi(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 44:
                                zzeh.zzm(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 45:
                                zzeh.zzl(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 46:
                                zzeh.zzg(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 47:
                                zzeh.zzj(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 48:
                                zzeh.zze(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 49:
                                zzeh.zzb(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, zzad(length2));
                                break;
                            case 50:
                                zza(zzfr, i14, zzfd.zzo(t, (long) (zzag & 1048575)), length2);
                                break;
                            case 51:
                                if (!zza(t, i14, length2)) {
                                    break;
                                } else {
                                    d2 = zze(t, (long) (zzag & 1048575));
                                    zzfr.zza(i14, d2);
                                    break;
                                }
                            case 52:
                                if (!zza(t, i14, length2)) {
                                    break;
                                } else {
                                    f2 = zzf(t, (long) (zzag & 1048575));
                                    zzfr.zza(i14, f2);
                                    break;
                                }
                            case 53:
                                if (!zza(t, i14, length2)) {
                                    break;
                                } else {
                                    j6 = zzh(t, (long) (zzag & 1048575));
                                    zzfr.zzi(i14, j6);
                                    break;
                                }
                            case 54:
                                if (!zza(t, i14, length2)) {
                                    break;
                                } else {
                                    j7 = zzh(t, (long) (zzag & 1048575));
                                    zzfr.zza(i14, j7);
                                    break;
                                }
                            case 55:
                                if (!zza(t, i14, length2)) {
                                    break;
                                } else {
                                    i8 = zzg(t, (long) (zzag & 1048575));
                                    zzfr.zzc(i14, i8);
                                    break;
                                }
                            case 56:
                                if (!zza(t, i14, length2)) {
                                    break;
                                } else {
                                    j8 = zzh(t, (long) (zzag & 1048575));
                                    zzfr.zzc(i14, j8);
                                    break;
                                }
                            case 57:
                                if (!zza(t, i14, length2)) {
                                    break;
                                } else {
                                    i9 = zzg(t, (long) (zzag & 1048575));
                                    zzfr.zzf(i14, i9);
                                    break;
                                }
                            case 58:
                                if (!zza(t, i14, length2)) {
                                    break;
                                } else {
                                    z2 = zzi(t, (long) (zzag & 1048575));
                                    zzfr.zzb(i14, z2);
                                    break;
                                }
                            case 59:
                                if (!zza(t, i14, length2)) {
                                    break;
                                }
                                zza(i14, zzfd.zzo(t, (long) (zzag & 1048575)), zzfr);
                                break;
                            case 60:
                                if (!zza(t, i14, length2)) {
                                    break;
                                }
                                zzfr.zza(i14, zzfd.zzo(t, (long) (zzag & 1048575)), zzad(length2));
                                break;
                            case 61:
                                if (!zza(t, i14, length2)) {
                                    break;
                                }
                                zzfr.zza(i14, (zzbb) zzfd.zzo(t, (long) (zzag & 1048575)));
                                break;
                            case 62:
                                if (!zza(t, i14, length2)) {
                                    break;
                                } else {
                                    i10 = zzg(t, (long) (zzag & 1048575));
                                    zzfr.zzd(i14, i10);
                                    break;
                                }
                            case 63:
                                if (!zza(t, i14, length2)) {
                                    break;
                                } else {
                                    i11 = zzg(t, (long) (zzag & 1048575));
                                    zzfr.zzn(i14, i11);
                                    break;
                                }
                            case 64:
                                if (!zza(t, i14, length2)) {
                                    break;
                                } else {
                                    i12 = zzg(t, (long) (zzag & 1048575));
                                    zzfr.zzm(i14, i12);
                                    break;
                                }
                            case 65:
                                if (!zza(t, i14, length2)) {
                                    break;
                                } else {
                                    j9 = zzh(t, (long) (zzag & 1048575));
                                    zzfr.zzj(i14, j9);
                                    break;
                                }
                            case 66:
                                if (!zza(t, i14, length2)) {
                                    break;
                                } else {
                                    i13 = zzg(t, (long) (zzag & 1048575));
                                    zzfr.zze(i14, i13);
                                    break;
                                }
                            case 67:
                                if (!zza(t, i14, length2)) {
                                    break;
                                } else {
                                    j10 = zzh(t, (long) (zzag & 1048575));
                                    zzfr.zzb(i14, j10);
                                    break;
                                }
                            case 68:
                                if (!zza(t, i14, length2)) {
                                    break;
                                }
                                zzfr.zzb(i14, zzfd.zzo(t, (long) (zzag & 1048575)), zzad(length2));
                                break;
                        }
                    }
                    while (entry3 != null) {
                        this.zzmy.zza(zzfr, entry3);
                        entry3 = it2.hasNext() ? (Map.Entry) it2.next() : null;
                    }
                }
            }
            it2 = null;
            entry3 = null;
            while (length2 >= 0) {
            }
            while (entry3 != null) {
            }
        } else if (this.zzmq) {
            if (this.zzmo) {
                zzby<?> zza2 = this.zzmy.zza((Object) t);
                if (!zza2.isEmpty()) {
                    it = zza2.iterator();
                    entry = (Map.Entry) it.next();
                    length = this.zzmi.length;
                    entry2 = entry;
                    for (i = 0; i < length; i += 4) {
                        int zzag2 = zzag(i);
                        int i15 = this.zzmi[i];
                        while (entry2 != null && this.zzmy.zza((Map.Entry<?, ?>) entry2) <= i15) {
                            this.zzmy.zza(zzfr, entry2);
                            entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
                        }
                        switch ((zzag2 & 267386880) >>> 20) {
                            case 0:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    d = zzfd.zzn(t, (long) (zzag2 & 1048575));
                                    zzfr.zza(i15, d);
                                    break;
                                }
                            case 1:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    f = zzfd.zzm(t, (long) (zzag2 & 1048575));
                                    zzfr.zza(i15, f);
                                    break;
                                }
                            case 2:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    j = zzfd.zzk(t, (long) (zzag2 & 1048575));
                                    zzfr.zzi(i15, j);
                                    break;
                                }
                            case 3:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    j2 = zzfd.zzk(t, (long) (zzag2 & 1048575));
                                    zzfr.zza(i15, j2);
                                    break;
                                }
                            case 4:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    i2 = zzfd.zzj(t, (long) (zzag2 & 1048575));
                                    zzfr.zzc(i15, i2);
                                    break;
                                }
                            case 5:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    j3 = zzfd.zzk(t, (long) (zzag2 & 1048575));
                                    zzfr.zzc(i15, j3);
                                    break;
                                }
                            case 6:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    i3 = zzfd.zzj(t, (long) (zzag2 & 1048575));
                                    zzfr.zzf(i15, i3);
                                    break;
                                }
                            case 7:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    z = zzfd.zzl(t, (long) (zzag2 & 1048575));
                                    zzfr.zzb(i15, z);
                                    break;
                                }
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                if (!zza(t, i)) {
                                    break;
                                }
                                zza(i15, zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr);
                                break;
                            case 9:
                                if (!zza(t, i)) {
                                    break;
                                }
                                zzfr.zza(i15, zzfd.zzo(t, (long) (zzag2 & 1048575)), zzad(i));
                                break;
                            case 10:
                                if (!zza(t, i)) {
                                    break;
                                }
                                zzfr.zza(i15, (zzbb) zzfd.zzo(t, (long) (zzag2 & 1048575)));
                                break;
                            case 11:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    i4 = zzfd.zzj(t, (long) (zzag2 & 1048575));
                                    zzfr.zzd(i15, i4);
                                    break;
                                }
                            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    i5 = zzfd.zzj(t, (long) (zzag2 & 1048575));
                                    zzfr.zzn(i15, i5);
                                    break;
                                }
                            case 13:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    i6 = zzfd.zzj(t, (long) (zzag2 & 1048575));
                                    zzfr.zzm(i15, i6);
                                    break;
                                }
                            case 14:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    j4 = zzfd.zzk(t, (long) (zzag2 & 1048575));
                                    zzfr.zzj(i15, j4);
                                    break;
                                }
                            case GmsLogger.MAX_PII_TAG_LENGTH:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    i7 = zzfd.zzj(t, (long) (zzag2 & 1048575));
                                    zzfr.zze(i15, i7);
                                    break;
                                }
                            case 16:
                                if (!zza(t, i)) {
                                    break;
                                } else {
                                    j5 = zzfd.zzk(t, (long) (zzag2 & 1048575));
                                    zzfr.zzb(i15, j5);
                                    break;
                                }
                            case 17:
                                if (!zza(t, i)) {
                                    break;
                                }
                                zzfr.zzb(i15, zzfd.zzo(t, (long) (zzag2 & 1048575)), zzad(i));
                                break;
                            case 18:
                                zzeh.zza(this.zzmi[i], (List<Double>) ((List) zzfd.zzo(t, (long) (zzag2 & 1048575))), zzfr, false);
                                break;
                            case 19:
                                zzeh.zzb(this.zzmi[i], (List<Float>) ((List) zzfd.zzo(t, (long) (zzag2 & 1048575))), zzfr, false);
                                break;
                            case 20:
                                zzeh.zzc(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 21:
                                zzeh.zzd(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 22:
                                zzeh.zzh(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 23:
                                zzeh.zzf(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 24:
                                zzeh.zzk(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 25:
                                zzeh.zzn(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 26:
                                zzeh.zza(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr);
                                break;
                            case 27:
                                zzeh.zza(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, zzad(i));
                                break;
                            case 28:
                                zzeh.zzb(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr);
                                break;
                            case 29:
                                zzeh.zzi(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 30:
                                zzeh.zzm(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 31:
                                zzeh.zzl(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 32:
                                zzeh.zzg(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 33:
                                zzeh.zzj(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 34:
                                zzeh.zze(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 35:
                                zzeh.zza(this.zzmi[i], (List<Double>) ((List) zzfd.zzo(t, (long) (zzag2 & 1048575))), zzfr, true);
                                break;
                            case 36:
                                zzeh.zzb(this.zzmi[i], (List<Float>) ((List) zzfd.zzo(t, (long) (zzag2 & 1048575))), zzfr, true);
                                break;
                            case 37:
                                zzeh.zzc(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 38:
                                zzeh.zzd(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 39:
                                zzeh.zzh(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 40:
                                zzeh.zzf(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 41:
                                zzeh.zzk(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 42:
                                zzeh.zzn(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 43:
                                zzeh.zzi(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 44:
                                zzeh.zzm(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 45:
                                zzeh.zzl(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 46:
                                zzeh.zzg(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 47:
                                zzeh.zzj(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 48:
                                zzeh.zze(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 49:
                                zzeh.zzb(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, zzad(i));
                                break;
                            case 50:
                                zza(zzfr, i15, zzfd.zzo(t, (long) (zzag2 & 1048575)), i);
                                break;
                            case 51:
                                if (!zza(t, i15, i)) {
                                    break;
                                } else {
                                    d = zze(t, (long) (zzag2 & 1048575));
                                    zzfr.zza(i15, d);
                                    break;
                                }
                            case 52:
                                if (!zza(t, i15, i)) {
                                    break;
                                } else {
                                    f = zzf(t, (long) (zzag2 & 1048575));
                                    zzfr.zza(i15, f);
                                    break;
                                }
                            case 53:
                                if (!zza(t, i15, i)) {
                                    break;
                                } else {
                                    j = zzh(t, (long) (zzag2 & 1048575));
                                    zzfr.zzi(i15, j);
                                    break;
                                }
                            case 54:
                                if (!zza(t, i15, i)) {
                                    break;
                                } else {
                                    j2 = zzh(t, (long) (zzag2 & 1048575));
                                    zzfr.zza(i15, j2);
                                    break;
                                }
                            case 55:
                                if (!zza(t, i15, i)) {
                                    break;
                                } else {
                                    i2 = zzg(t, (long) (zzag2 & 1048575));
                                    zzfr.zzc(i15, i2);
                                    break;
                                }
                            case 56:
                                if (!zza(t, i15, i)) {
                                    break;
                                } else {
                                    j3 = zzh(t, (long) (zzag2 & 1048575));
                                    zzfr.zzc(i15, j3);
                                    break;
                                }
                            case 57:
                                if (!zza(t, i15, i)) {
                                    break;
                                } else {
                                    i3 = zzg(t, (long) (zzag2 & 1048575));
                                    zzfr.zzf(i15, i3);
                                    break;
                                }
                            case 58:
                                if (!zza(t, i15, i)) {
                                    break;
                                } else {
                                    z = zzi(t, (long) (zzag2 & 1048575));
                                    zzfr.zzb(i15, z);
                                    break;
                                }
                            case 59:
                                if (!zza(t, i15, i)) {
                                    break;
                                }
                                zza(i15, zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr);
                                break;
                            case 60:
                                if (!zza(t, i15, i)) {
                                    break;
                                }
                                zzfr.zza(i15, zzfd.zzo(t, (long) (zzag2 & 1048575)), zzad(i));
                                break;
                            case 61:
                                if (!zza(t, i15, i)) {
                                    break;
                                }
                                zzfr.zza(i15, (zzbb) zzfd.zzo(t, (long) (zzag2 & 1048575)));
                                break;
                            case 62:
                                if (!zza(t, i15, i)) {
                                    break;
                                } else {
                                    i4 = zzg(t, (long) (zzag2 & 1048575));
                                    zzfr.zzd(i15, i4);
                                    break;
                                }
                            case 63:
                                if (!zza(t, i15, i)) {
                                    break;
                                } else {
                                    i5 = zzg(t, (long) (zzag2 & 1048575));
                                    zzfr.zzn(i15, i5);
                                    break;
                                }
                            case 64:
                                if (!zza(t, i15, i)) {
                                    break;
                                } else {
                                    i6 = zzg(t, (long) (zzag2 & 1048575));
                                    zzfr.zzm(i15, i6);
                                    break;
                                }
                            case 65:
                                if (!zza(t, i15, i)) {
                                    break;
                                } else {
                                    j4 = zzh(t, (long) (zzag2 & 1048575));
                                    zzfr.zzj(i15, j4);
                                    break;
                                }
                            case 66:
                                if (!zza(t, i15, i)) {
                                    break;
                                } else {
                                    i7 = zzg(t, (long) (zzag2 & 1048575));
                                    zzfr.zze(i15, i7);
                                    break;
                                }
                            case 67:
                                if (!zza(t, i15, i)) {
                                    break;
                                } else {
                                    j5 = zzh(t, (long) (zzag2 & 1048575));
                                    zzfr.zzb(i15, j5);
                                    break;
                                }
                            case 68:
                                if (!zza(t, i15, i)) {
                                    break;
                                }
                                zzfr.zzb(i15, zzfd.zzo(t, (long) (zzag2 & 1048575)), zzad(i));
                                break;
                        }
                    }
                    while (entry2 != null) {
                        this.zzmy.zza(zzfr, entry2);
                        entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    zza(this.zzmx, t, zzfr);
                }
            }
            it = null;
            entry = null;
            length = this.zzmi.length;
            entry2 = entry;
            while (i < length) {
            }
            while (entry2 != null) {
            }
            zza(this.zzmx, t, zzfr);
        } else {
            zzb(t, zzfr);
        }
    }

    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, boolean):void
     arg types: [T, long, boolean]
     candidates:
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.clearcut.zzfd.zza(byte[], long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, float):void
     arg types: [T, long, float]
     candidates:
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.clearcut.zzfd.zza(byte[], long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, float):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.clearcut.zzay):int
     arg types: [T, byte[], int, int, int, com.google.android.gms.internal.clearcut.zzay]
     candidates:
      com.google.android.gms.internal.clearcut.zzds.zza(int, byte[], int, int, java.lang.Object, com.google.android.gms.internal.clearcut.zzay):int
      com.google.android.gms.internal.clearcut.zzds.zza(com.google.android.gms.internal.clearcut.zzef, byte[], int, int, int, com.google.android.gms.internal.clearcut.zzay):int
      com.google.android.gms.internal.clearcut.zzds.zza(byte[], int, int, com.google.android.gms.internal.clearcut.zzfl, java.lang.Class<?>, com.google.android.gms.internal.clearcut.zzay):int
      com.google.android.gms.internal.clearcut.zzds.zza(int, int, java.util.Map, com.google.android.gms.internal.clearcut.zzck<?>, java.lang.Object, com.google.android.gms.internal.clearcut.zzex):UB
      com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.clearcut.zzay):int */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        if (r7 == 0) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ce, code lost:
        if (r7 == 0) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d0, code lost:
        r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r10, r11);
        r1 = r11.zzfd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0164, code lost:
        if (r0 == r15) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0188, code lost:
        if (r0 == r15) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01a1, code lost:
        if (r0 == r15) goto L_0x01a3;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void zza(T t, byte[] bArr, int i, int i2, zzay zzay) throws IOException {
        byte b;
        int i3;
        Unsafe unsafe;
        int i4;
        int zza;
        int i5;
        int i6;
        long j;
        Object zza2;
        zzds zzds = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i7 = i2;
        zzay zzay2 = zzay;
        if (zzds.zzmq) {
            Unsafe unsafe2 = zzmh;
            int i8 = i;
            while (i8 < i7) {
                int i9 = i8 + 1;
                byte b2 = bArr2[i8];
                if (b2 < 0) {
                    i3 = zzax.zza(b2, bArr2, i9, zzay2);
                    b = zzay2.zzfd;
                } else {
                    b = b2;
                    i3 = i9;
                }
                int i10 = b >>> 3;
                byte b3 = b & 7;
                int zzai = zzds.zzai(i10);
                if (zzai >= 0) {
                    int i11 = zzds.zzmi[zzai + 1];
                    int i12 = (267386880 & i11) >>> 20;
                    long j2 = (long) (1048575 & i11);
                    if (i12 <= 17) {
                        boolean z = true;
                        switch (i12) {
                            case 0:
                                if (b3 == 1) {
                                    zzfd.zza(t2, j2, zzax.zze(bArr2, i3));
                                    i8 = i3 + 8;
                                    break;
                                }
                                break;
                            case 1:
                                if (b3 == 5) {
                                    zzfd.zza((Object) t2, j2, zzax.zzf(bArr2, i3));
                                    i8 = i3 + 4;
                                    break;
                                }
                                break;
                            case 2:
                            case 3:
                                if (b3 == 0) {
                                    i6 = zzax.zzb(bArr2, i3, zzay2);
                                    j = zzay2.zzfe;
                                    unsafe2.putLong(t, j2, j);
                                    i8 = i6;
                                    break;
                                }
                                break;
                            case 5:
                            case 14:
                                if (b3 == 1) {
                                    unsafe2.putLong(t, j2, zzax.zzd(bArr2, i3));
                                    i8 = i3 + 8;
                                    break;
                                }
                                break;
                            case 6:
                            case 13:
                                if (b3 == 5) {
                                    unsafe2.putInt(t2, j2, zzax.zzc(bArr2, i3));
                                    i8 = i3 + 4;
                                    break;
                                }
                                break;
                            case 7:
                                if (b3 == 0) {
                                    i8 = zzax.zzb(bArr2, i3, zzay2);
                                    if (zzay2.zzfe == 0) {
                                        z = false;
                                    }
                                    zzfd.zza((Object) t2, j2, z);
                                    break;
                                }
                                break;
                            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                                if (b3 == 2) {
                                    i8 = (536870912 & i11) == 0 ? zzax.zzc(bArr2, i3, zzay2) : zzax.zzd(bArr2, i3, zzay2);
                                    zza2 = zzay2.zzff;
                                    unsafe2.putObject(t2, j2, zza2);
                                    break;
                                }
                                break;
                            case 9:
                                if (b3 == 2) {
                                    i8 = zza(zzds.zzad(zzai), bArr2, i3, i7, zzay2);
                                    Object object = unsafe2.getObject(t2, j2);
                                    if (object != null) {
                                        zza2 = zzci.zza(object, zzay2.zzff);
                                        unsafe2.putObject(t2, j2, zza2);
                                        break;
                                    }
                                    zza2 = zzay2.zzff;
                                    unsafe2.putObject(t2, j2, zza2);
                                }
                                break;
                            case 10:
                                if (b3 == 2) {
                                    i8 = zzax.zze(bArr2, i3, zzay2);
                                    zza2 = zzay2.zzff;
                                    unsafe2.putObject(t2, j2, zza2);
                                    break;
                                }
                                break;
                            case GmsLogger.MAX_PII_TAG_LENGTH:
                                if (b3 == 0) {
                                    int zza3 = zzax.zza(bArr2, i3, zzay2);
                                    int i13 = zzbk.zzm(zzay2.zzfd);
                                    unsafe2.putInt(t2, j2, i13);
                                    break;
                                }
                                break;
                            case 16:
                                if (b3 == 0) {
                                    i6 = zzax.zzb(bArr2, i3, zzay2);
                                    j = zzbk.zza(zzay2.zzfe);
                                    unsafe2.putLong(t, j2, j);
                                    i8 = i6;
                                    break;
                                }
                                break;
                        }
                    } else if (i12 != 27) {
                        if (i12 <= 49) {
                            unsafe = unsafe2;
                            int i14 = i3;
                            zza = zza(t, bArr, i3, i2, b, i10, b3, zzai, (long) i11, i12, j2, zzay);
                        } else {
                            long j3 = j2;
                            unsafe = unsafe2;
                            i5 = i3;
                            int i15 = i12;
                            if (i15 == 50) {
                                if (b3 == 2) {
                                    zza = zza(t, bArr, i5, i2, zzai, i10, j3, zzay);
                                }
                                i4 = i5;
                                zza = zza(b, bArr, i4, i2, t, zzay);
                                zzds = this;
                                t2 = t;
                                bArr2 = bArr;
                                i7 = i2;
                                zzay2 = zzay;
                                unsafe2 = unsafe;
                            } else {
                                zza = zza(t, bArr, i5, i2, b, i10, b3, i11, i15, j3, zzai, zzay);
                            }
                        }
                        i4 = zza;
                        zza = zza(b, bArr, i4, i2, t, zzay);
                        zzds = this;
                        t2 = t;
                        bArr2 = bArr;
                        i7 = i2;
                        zzay2 = zzay;
                        unsafe2 = unsafe;
                    } else if (b3 == 2) {
                        zzcn zzcn = (zzcn) unsafe2.getObject(t2, j2);
                        if (!zzcn.zzu()) {
                            int size = zzcn.size();
                            zzcn = zzcn.zzi(size == 0 ? 10 : size << 1);
                            unsafe2.putObject(t2, j2, zzcn);
                        }
                        i8 = zza(zzds.zzad(zzai), b, bArr, i3, i2, zzcn, zzay);
                    }
                }
                unsafe = unsafe2;
                i5 = i3;
                i4 = i5;
                zza = zza(b, bArr, i4, i2, t, zzay);
                zzds = this;
                t2 = t;
                bArr2 = bArr;
                i7 = i2;
                zzay2 = zzay;
                unsafe2 = unsafe;
            }
            if (i8 != i7) {
                throw zzco.zzbo();
            }
            return;
        }
        zza((Object) t, bArr, i, i2, 0, zzay);
    }

    public final void zzc(T t) {
        int[] iArr = this.zzmt;
        if (iArr != null) {
            for (int zzag : iArr) {
                long zzag2 = (long) (zzag(zzag) & 1048575);
                Object zzo = zzfd.zzo(t, zzag2);
                if (zzo != null) {
                    zzfd.zza(t, zzag2, this.zzmz.zzj(zzo));
                }
            }
        }
        int[] iArr2 = this.zzmu;
        if (iArr2 != null) {
            for (int i : iArr2) {
                this.zzmw.zza(t, (long) i);
            }
        }
        this.zzmx.zzc(t);
        if (this.zzmo) {
            this.zzmy.zzc(t);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, boolean):void
     arg types: [T, long, boolean]
     candidates:
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.clearcut.zzfd.zza(byte[], long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, int):void
     arg types: [T, long, int]
     candidates:
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.clearcut.zzfd.zza(byte[], long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, long):void
     arg types: [T, long, long]
     candidates:
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, float):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.clearcut.zzfd.zza(byte[], long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, long):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, float):void
     arg types: [T, long, float]
     candidates:
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, double):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, int):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, long):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, java.lang.Object):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, boolean):void
      com.google.android.gms.internal.clearcut.zzfd.zza(byte[], long, byte):void
      com.google.android.gms.internal.clearcut.zzfd.zza(java.lang.Object, long, float):void */
    public final void zzc(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzmi.length; i += 4) {
                int zzag = zzag(i);
                long j = (long) (1048575 & zzag);
                int i2 = this.zzmi[i];
                switch ((zzag & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzfd.zza(t, j, zzfd.zzn(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzfd.zza((Object) t, j, zzfd.zzm(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                        zzb(t, i);
                        break;
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                        zzb(t, i);
                        break;
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                        zzb(t, i);
                        break;
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                        zzb(t, i);
                        break;
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                        zzb(t, i);
                        break;
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzfd.zza((Object) t, j, zzfd.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza(t, j, zzfd.zzo(t2, j));
                        zzb(t, i);
                        break;
                    case 9:
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza(t, j, zzfd.zzo(t2, j));
                        zzb(t, i);
                        break;
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                        zzb(t, i);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                        zzb(t, i);
                        break;
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                        zzb(t, i);
                        break;
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                        zzb(t, i);
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                        zzb(t, i);
                        break;
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                        zzb(t, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzmw.zza(t, t2, j);
                        break;
                    case 50:
                        zzeh.zza(this.zzmz, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        }
                        zzfd.zza(t, j, zzfd.zzo(t2, j));
                        zzb(t, i2, i);
                        break;
                    case 60:
                    case 68:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        }
                        zzfd.zza(t, j, zzfd.zzo(t2, j));
                        zzb(t, i2, i);
                        break;
                }
            }
            if (!this.zzmq) {
                zzeh.zza(this.zzmx, t, t2);
                if (this.zzmo) {
                    zzeh.zza(this.zzmy, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzbn.zzh(int, long):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.clearcut.zzbn.zzh(int, int):int
      com.google.android.gms.internal.clearcut.zzbn.zzh(int, long):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzbn.zzc(int, boolean):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.clearcut.zzbn.zzc(int, com.google.android.gms.internal.clearcut.zzbb):int
      com.google.android.gms.internal.clearcut.zzbn.zzc(int, com.google.android.gms.internal.clearcut.zzdo):int
      com.google.android.gms.internal.clearcut.zzbn.zzc(int, int):void
      com.google.android.gms.internal.clearcut.zzbn.zzc(int, long):void
      com.google.android.gms.internal.clearcut.zzbn.zzc(int, boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzbn.zzg(int, long):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.clearcut.zzbn.zzg(int, int):int
      com.google.android.gms.internal.clearcut.zzbn.zzg(int, long):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzbn.zzb(int, float):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, double):int
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, com.google.android.gms.internal.clearcut.zzcv):int
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, java.lang.String):int
      com.google.android.gms.internal.clearcut.zzbn.zzb(com.google.android.gms.internal.clearcut.zzdo, com.google.android.gms.internal.clearcut.zzef):int
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, int):void
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, long):void
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, com.google.android.gms.internal.clearcut.zzbb):void
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, com.google.android.gms.internal.clearcut.zzdo):void
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, boolean):void
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, float):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzbn.zzb(int, double):int
     arg types: [int, int]
     candidates:
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, float):int
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, com.google.android.gms.internal.clearcut.zzcv):int
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, java.lang.String):int
      com.google.android.gms.internal.clearcut.zzbn.zzb(com.google.android.gms.internal.clearcut.zzdo, com.google.android.gms.internal.clearcut.zzef):int
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, int):void
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, long):void
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, com.google.android.gms.internal.clearcut.zzbb):void
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, com.google.android.gms.internal.clearcut.zzdo):void
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, boolean):void
      com.google.android.gms.internal.clearcut.zzbn.zzb(int, double):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.clearcut.zzds.zza(com.google.android.gms.internal.clearcut.zzex, java.lang.Object):int
     arg types: [com.google.android.gms.internal.clearcut.zzex<?, ?>, T]
     candidates:
      com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, int):boolean
      com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, com.google.android.gms.internal.clearcut.zzfr):void
      com.google.android.gms.internal.clearcut.zzef.zza(java.lang.Object, com.google.android.gms.internal.clearcut.zzfr):void
      com.google.android.gms.internal.clearcut.zzds.zza(com.google.android.gms.internal.clearcut.zzex, java.lang.Object):int */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d8, code lost:
        if (r0.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e9, code lost:
        if (r0.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01fa, code lost:
        if (r0.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x020b, code lost:
        if (r0.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x020d, code lost:
        r2.putInt(r1, (long) r14, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0211, code lost:
        r3 = (com.google.android.gms.internal.clearcut.zzbn.zzr(r3) + com.google.android.gms.internal.clearcut.zzbn.zzt(r5)) + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0331, code lost:
        if ((r5 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0334, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzb(r3, (java.lang.String) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0417, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x06b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0437, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x06e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x043f, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x06f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x045f, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x0716;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0467, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x0725;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0477, code lost:
        if ((r4 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x071a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x047f, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x074c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x0517, code lost:
        if (r0.zzmr != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0529, code lost:
        if (r0.zzmr != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x053b, code lost:
        if (r0.zzmr != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x054d, code lost:
        if (r0.zzmr != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x055f, code lost:
        if (r0.zzmr != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x0571, code lost:
        if (r0.zzmr != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0583, code lost:
        if (r0.zzmr != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x0595, code lost:
        if (r0.zzmr != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x05a6, code lost:
        if (r0.zzmr != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x05b7, code lost:
        if (r0.zzmr != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x05c8, code lost:
        if (r0.zzmr != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x05d9, code lost:
        if (r0.zzmr != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x05ea, code lost:
        if (r0.zzmr != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x05fb, code lost:
        if (r0.zzmr != false) goto L_0x05fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x05fd, code lost:
        r2.putInt(r1, (long) r11, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x0601, code lost:
        r9 = (com.google.android.gms.internal.clearcut.zzbn.zzr(r15) + com.google.android.gms.internal.clearcut.zzbn.zzt(r4)) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x06b7, code lost:
        if ((r12 & r18) != 0) goto L_0x06b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x06b9, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, (com.google.android.gms.internal.clearcut.zzdo) r2.getObject(r1, r9), zzad(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x06e4, code lost:
        if ((r12 & r18) != 0) goto L_0x06e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x06e6, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzh(r15, 0L);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x06ef, code lost:
        if ((r12 & r18) != 0) goto L_0x06f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x06f1, code lost:
        r9 = com.google.android.gms.internal.clearcut.zzbn.zzk(r15, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x0714, code lost:
        if ((r12 & r18) != 0) goto L_0x0716;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x0716, code lost:
        r4 = r2.getObject(r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x071a, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, (com.google.android.gms.internal.clearcut.zzbb) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x0723, code lost:
        if ((r12 & r18) != 0) goto L_0x0725;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0725, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzc(r15, r2.getObject(r1, r9), zzad(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ab, code lost:
        if ((r5 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x073d, code lost:
        if ((r4 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x071a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x0740, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzb(r15, (java.lang.String) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x074a, code lost:
        if ((r12 & r18) != 0) goto L_0x074c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x074c, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0127, code lost:
        if (r0.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0139, code lost:
        if (r0.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014b, code lost:
        if (r0.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x015d, code lost:
        if (r0.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x016f, code lost:
        if (r0.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0181, code lost:
        if (r0.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0193, code lost:
        if (r0.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a5, code lost:
        if (r0.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01b6, code lost:
        if (r0.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01c7, code lost:
        if (r0.zzmr != false) goto L_0x020d;
     */
    public final int zzm(T t) {
        int i;
        int i2;
        long j;
        int i3;
        int zzc;
        Object obj;
        int i4;
        int i5;
        int i6;
        int i7;
        long j2;
        int i8;
        int zzb;
        long j3;
        long j4;
        int i9;
        Object obj2;
        int i10;
        int i11;
        int i12;
        long j5;
        int i13;
        T t2 = t;
        int i14 = 267386880;
        if (this.zzmq) {
            Unsafe unsafe = zzmh;
            int i15 = 0;
            int i16 = 0;
            while (i15 < this.zzmi.length) {
                int zzag = zzag(i15);
                int i17 = (zzag & i14) >>> 20;
                int i18 = this.zzmi[i15];
                long j6 = (long) (zzag & 1048575);
                int i19 = (i17 < zzcb.DOUBLE_LIST_PACKED.id() || i17 > zzcb.SINT64_LIST_PACKED.id()) ? 0 : this.zzmi[i15 + 2] & 1048575;
                switch (i17) {
                    case 0:
                        if (!zza(t2, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzb(i18, 0.0d);
                        break;
                    case 1:
                        if (!zza(t2, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzb(i18, 0.0f);
                        break;
                    case 2:
                        if (zza(t2, i15)) {
                            j3 = zzfd.zzk(t2, j6);
                            zzb = zzbn.zzd(i18, j3);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 3:
                        if (zza(t2, i15)) {
                            j4 = zzfd.zzk(t2, j6);
                            zzb = zzbn.zze(i18, j4);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 4:
                        if (zza(t2, i15)) {
                            i9 = zzfd.zzj(t2, j6);
                            zzb = zzbn.zzg(i18, i9);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 5:
                        if (!zza(t2, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzg(i18, 0L);
                        break;
                    case 6:
                        if (!zza(t2, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzj(i18, 0);
                        break;
                    case 7:
                        if (!zza(t2, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzc(i18, true);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        if (zza(t2, i15)) {
                            obj2 = zzfd.zzo(t2, j6);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 9:
                        if (!zza(t2, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzeh.zzc(i18, zzfd.zzo(t2, j6), zzad(i15));
                        break;
                    case 10:
                        if (!zza(t2, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        obj2 = zzfd.zzo(t2, j6);
                        zzb = zzbn.zzc(i18, (zzbb) obj2);
                        break;
                    case 11:
                        if (zza(t2, i15)) {
                            i10 = zzfd.zzj(t2, j6);
                            zzb = zzbn.zzh(i18, i10);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        if (zza(t2, i15)) {
                            i11 = zzfd.zzj(t2, j6);
                            zzb = zzbn.zzl(i18, i11);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 13:
                        if (!zza(t2, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzk(i18, 0);
                        break;
                    case 14:
                        if (!zza(t2, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzh(i18, 0L);
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        if (zza(t2, i15)) {
                            i12 = zzfd.zzj(t2, j6);
                            zzb = zzbn.zzi(i18, i12);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 16:
                        if (zza(t2, i15)) {
                            j5 = zzfd.zzk(t2, j6);
                            zzb = zzbn.zzf(i18, j5);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 17:
                        if (!zza(t2, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzc(i18, (zzdo) zzfd.zzo(t2, j6), zzad(i15));
                        break;
                    case 18:
                    case 23:
                    case 32:
                        zzb = zzeh.zzw(i18, zzd(t2, j6), false);
                        break;
                    case 19:
                    case 24:
                    case 31:
                        zzb = zzeh.zzv(i18, zzd(t2, j6), false);
                        break;
                    case 20:
                        zzb = zzeh.zzo(i18, zzd(t2, j6), false);
                        break;
                    case 21:
                        zzb = zzeh.zzp(i18, zzd(t2, j6), false);
                        break;
                    case 22:
                        zzb = zzeh.zzs(i18, zzd(t2, j6), false);
                        break;
                    case 25:
                        zzb = zzeh.zzx(i18, zzd(t2, j6), false);
                        break;
                    case 26:
                        zzb = zzeh.zzc(i18, zzd(t2, j6));
                        break;
                    case 27:
                        zzb = zzeh.zzc(i18, (List<?>) zzd(t2, j6), zzad(i15));
                        break;
                    case 28:
                        zzb = zzeh.zzd(i18, zzd(t2, j6));
                        break;
                    case 29:
                        zzb = zzeh.zzt(i18, zzd(t2, j6), false);
                        break;
                    case 30:
                        zzb = zzeh.zzr(i18, zzd(t2, j6), false);
                        break;
                    case 33:
                        zzb = zzeh.zzu(i18, zzd(t2, j6), false);
                        break;
                    case 34:
                        zzb = zzeh.zzq(i18, zzd(t2, j6), false);
                        break;
                    case 35:
                        i13 = zzeh.zzi((List) unsafe.getObject(t2, j6));
                        if (i13 > 0) {
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 36:
                        i13 = zzeh.zzh((List) unsafe.getObject(t2, j6));
                        if (i13 > 0) {
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 37:
                        i13 = zzeh.zza((List) unsafe.getObject(t2, j6));
                        if (i13 > 0) {
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 38:
                        i13 = zzeh.zzb((List) unsafe.getObject(t2, j6));
                        if (i13 > 0) {
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 39:
                        i13 = zzeh.zze((List) unsafe.getObject(t2, j6));
                        if (i13 > 0) {
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 40:
                        i13 = zzeh.zzi((List) unsafe.getObject(t2, j6));
                        if (i13 > 0) {
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 41:
                        i13 = zzeh.zzh((List) unsafe.getObject(t2, j6));
                        if (i13 > 0) {
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 42:
                        i13 = zzeh.zzj((List) unsafe.getObject(t2, j6));
                        if (i13 > 0) {
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 43:
                        i13 = zzeh.zzf((List) unsafe.getObject(t2, j6));
                        if (i13 > 0) {
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 44:
                        i13 = zzeh.zzd((List) unsafe.getObject(t2, j6));
                        if (i13 > 0) {
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 45:
                        i13 = zzeh.zzh((List) unsafe.getObject(t2, j6));
                        if (i13 > 0) {
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 46:
                        i13 = zzeh.zzi((List) unsafe.getObject(t2, j6));
                        if (i13 > 0) {
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 47:
                        i13 = zzeh.zzg((List) unsafe.getObject(t2, j6));
                        if (i13 > 0) {
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 48:
                        i13 = zzeh.zzc((List) unsafe.getObject(t2, j6));
                        if (i13 > 0) {
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 49:
                        zzb = zzeh.zzd(i18, zzd(t2, j6), zzad(i15));
                        break;
                    case 50:
                        zzb = this.zzmz.zzb(i18, zzfd.zzo(t2, j6), zzae(i15));
                        break;
                    case 51:
                        if (!zza(t2, i18, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzb(i18, 0.0d);
                        break;
                    case 52:
                        if (!zza(t2, i18, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzb(i18, 0.0f);
                        break;
                    case 53:
                        if (zza(t2, i18, i15)) {
                            j3 = zzh(t2, j6);
                            zzb = zzbn.zzd(i18, j3);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 54:
                        if (zza(t2, i18, i15)) {
                            j4 = zzh(t2, j6);
                            zzb = zzbn.zze(i18, j4);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 55:
                        if (zza(t2, i18, i15)) {
                            i9 = zzg(t2, j6);
                            zzb = zzbn.zzg(i18, i9);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 56:
                        if (!zza(t2, i18, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzg(i18, 0L);
                        break;
                    case 57:
                        if (!zza(t2, i18, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzj(i18, 0);
                        break;
                    case 58:
                        if (!zza(t2, i18, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzc(i18, true);
                        break;
                    case 59:
                        if (zza(t2, i18, i15)) {
                            obj2 = zzfd.zzo(t2, j6);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 60:
                        if (!zza(t2, i18, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzeh.zzc(i18, zzfd.zzo(t2, j6), zzad(i15));
                        break;
                    case 61:
                        if (!zza(t2, i18, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        obj2 = zzfd.zzo(t2, j6);
                        zzb = zzbn.zzc(i18, (zzbb) obj2);
                        break;
                    case 62:
                        if (zza(t2, i18, i15)) {
                            i10 = zzg(t2, j6);
                            zzb = zzbn.zzh(i18, i10);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 63:
                        if (zza(t2, i18, i15)) {
                            i11 = zzg(t2, j6);
                            zzb = zzbn.zzl(i18, i11);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 64:
                        if (!zza(t2, i18, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzk(i18, 0);
                        break;
                    case 65:
                        if (!zza(t2, i18, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzh(i18, 0L);
                        break;
                    case 66:
                        if (zza(t2, i18, i15)) {
                            i12 = zzg(t2, j6);
                            zzb = zzbn.zzi(i18, i12);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 67:
                        if (zza(t2, i18, i15)) {
                            j5 = zzh(t2, j6);
                            zzb = zzbn.zzf(i18, j5);
                            break;
                        } else {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                    case 68:
                        if (!zza(t2, i18, i15)) {
                            continue;
                            i15 += 4;
                            i14 = 267386880;
                        }
                        zzb = zzbn.zzc(i18, (zzdo) zzfd.zzo(t2, j6), zzad(i15));
                        break;
                    default:
                        i15 += 4;
                        i14 = 267386880;
                }
                i16 += zzb;
                i15 += 4;
                i14 = 267386880;
            }
            return i16 + zza((zzex) this.zzmx, (Object) t2);
        }
        Unsafe unsafe2 = zzmh;
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        int i23 = 0;
        while (i20 < this.zzmi.length) {
            int zzag2 = zzag(i20);
            int[] iArr = this.zzmi;
            int i24 = iArr[i20];
            int i25 = (zzag2 & 267386880) >>> 20;
            if (i25 <= 17) {
                i2 = iArr[i20 + 2];
                int i26 = i2 & 1048575;
                i = 1 << (i2 >>> 20);
                if (i26 != i22) {
                    i23 = unsafe2.getInt(t2, (long) i26);
                } else {
                    i26 = i22;
                }
                i22 = i26;
            } else {
                i2 = (!this.zzmr || i25 < zzcb.DOUBLE_LIST_PACKED.id() || i25 > zzcb.SINT64_LIST_PACKED.id()) ? 0 : this.zzmi[i20 + 2] & 1048575;
                i = 0;
            }
            long j7 = (long) (zzag2 & 1048575);
            switch (i25) {
                case 0:
                    j = 0;
                    if ((i23 & i) != 0) {
                        i21 += zzbn.zzb(i24, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    j = 0;
                    if ((i23 & i) != 0) {
                        i21 += zzbn.zzb(i24, 0.0f);
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i23 & i) != 0) {
                        i3 = zzbn.zzd(i24, unsafe2.getLong(t2, j7));
                        i21 += i3;
                    }
                    break;
                case 3:
                    j = 0;
                    if ((i23 & i) != 0) {
                        i3 = zzbn.zze(i24, unsafe2.getLong(t2, j7));
                        i21 += i3;
                    }
                    break;
                case 4:
                    j = 0;
                    if ((i23 & i) != 0) {
                        i3 = zzbn.zzg(i24, unsafe2.getInt(t2, j7));
                        i21 += i3;
                    }
                    break;
                case 5:
                    if ((i23 & i) != 0) {
                        j = 0;
                        i3 = zzbn.zzg(i24, 0L);
                        i21 += i3;
                        break;
                    } else {
                        j = 0;
                    }
                case 6:
                    if ((i23 & i) != 0) {
                        i21 += zzbn.zzj(i24, 0);
                        j = 0;
                        break;
                    }
                    j = 0;
                case 7:
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    if ((i23 & i) != 0) {
                        obj = unsafe2.getObject(t2, j7);
                        break;
                    }
                    j = 0;
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    if ((i23 & i) != 0) {
                        i4 = unsafe2.getInt(t2, j7);
                        zzc = zzbn.zzh(i24, i4);
                        i21 += zzc;
                    }
                    j = 0;
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    if ((i23 & i) != 0) {
                        i5 = unsafe2.getInt(t2, j7);
                        zzc = zzbn.zzl(i24, i5);
                        i21 += zzc;
                    }
                    j = 0;
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    if ((i23 & i) != 0) {
                        i7 = unsafe2.getInt(t2, j7);
                        zzc = zzbn.zzi(i24, i7);
                        i21 += zzc;
                    }
                    j = 0;
                    break;
                case 16:
                    if ((i23 & i) != 0) {
                        j2 = unsafe2.getLong(t2, j7);
                        zzc = zzbn.zzf(i24, j2);
                        i21 += zzc;
                    }
                    j = 0;
                    break;
                case 17:
                    break;
                case 18:
                case 23:
                case 32:
                    zzc = zzeh.zzw(i24, (List) unsafe2.getObject(t2, j7), false);
                    i21 += zzc;
                    j = 0;
                    break;
                case 19:
                case 24:
                case 31:
                    zzc = zzeh.zzv(i24, (List) unsafe2.getObject(t2, j7), false);
                    i21 += zzc;
                    j = 0;
                    break;
                case 20:
                    zzc = zzeh.zzo(i24, (List) unsafe2.getObject(t2, j7), false);
                    i21 += zzc;
                    j = 0;
                    break;
                case 21:
                    zzc = zzeh.zzp(i24, (List) unsafe2.getObject(t2, j7), false);
                    i21 += zzc;
                    j = 0;
                    break;
                case 22:
                    zzc = zzeh.zzs(i24, (List) unsafe2.getObject(t2, j7), false);
                    i21 += zzc;
                    j = 0;
                    break;
                case 25:
                    zzc = zzeh.zzx(i24, (List) unsafe2.getObject(t2, j7), false);
                    i21 += zzc;
                    j = 0;
                    break;
                case 26:
                    zzc = zzeh.zzc(i24, (List) unsafe2.getObject(t2, j7));
                    i21 += zzc;
                    j = 0;
                    break;
                case 27:
                    zzc = zzeh.zzc(i24, (List<?>) ((List) unsafe2.getObject(t2, j7)), zzad(i20));
                    i21 += zzc;
                    j = 0;
                    break;
                case 28:
                    zzc = zzeh.zzd(i24, (List) unsafe2.getObject(t2, j7));
                    i21 += zzc;
                    j = 0;
                    break;
                case 29:
                    zzc = zzeh.zzt(i24, (List) unsafe2.getObject(t2, j7), false);
                    i21 += zzc;
                    j = 0;
                    break;
                case 30:
                    zzc = zzeh.zzr(i24, (List) unsafe2.getObject(t2, j7), false);
                    i21 += zzc;
                    j = 0;
                    break;
                case 33:
                    zzc = zzeh.zzu(i24, (List) unsafe2.getObject(t2, j7), false);
                    i21 += zzc;
                    j = 0;
                    break;
                case 34:
                    zzc = zzeh.zzq(i24, (List) unsafe2.getObject(t2, j7), false);
                    i21 += zzc;
                    j = 0;
                    break;
                case 35:
                    i8 = zzeh.zzi((List) unsafe2.getObject(t2, j7));
                    if (i8 > 0) {
                        break;
                    }
                    j = 0;
                    break;
                case 36:
                    i8 = zzeh.zzh((List) unsafe2.getObject(t2, j7));
                    if (i8 > 0) {
                        break;
                    }
                    j = 0;
                    break;
                case 37:
                    i8 = zzeh.zza((List) unsafe2.getObject(t2, j7));
                    if (i8 > 0) {
                        break;
                    }
                    j = 0;
                    break;
                case 38:
                    i8 = zzeh.zzb((List) unsafe2.getObject(t2, j7));
                    if (i8 > 0) {
                        break;
                    }
                    j = 0;
                    break;
                case 39:
                    i8 = zzeh.zze((List) unsafe2.getObject(t2, j7));
                    if (i8 > 0) {
                        break;
                    }
                    j = 0;
                    break;
                case 40:
                    i8 = zzeh.zzi((List) unsafe2.getObject(t2, j7));
                    if (i8 > 0) {
                        break;
                    }
                    j = 0;
                    break;
                case 41:
                    i8 = zzeh.zzh((List) unsafe2.getObject(t2, j7));
                    if (i8 > 0) {
                        break;
                    }
                    j = 0;
                    break;
                case 42:
                    i8 = zzeh.zzj((List) unsafe2.getObject(t2, j7));
                    if (i8 > 0) {
                        break;
                    }
                    j = 0;
                    break;
                case 43:
                    i8 = zzeh.zzf((List) unsafe2.getObject(t2, j7));
                    if (i8 > 0) {
                        break;
                    }
                    j = 0;
                    break;
                case 44:
                    i8 = zzeh.zzd((List) unsafe2.getObject(t2, j7));
                    if (i8 > 0) {
                        break;
                    }
                    j = 0;
                    break;
                case 45:
                    i8 = zzeh.zzh((List) unsafe2.getObject(t2, j7));
                    if (i8 > 0) {
                        break;
                    }
                    j = 0;
                    break;
                case 46:
                    i8 = zzeh.zzi((List) unsafe2.getObject(t2, j7));
                    if (i8 > 0) {
                        break;
                    }
                    j = 0;
                    break;
                case 47:
                    i8 = zzeh.zzg((List) unsafe2.getObject(t2, j7));
                    if (i8 > 0) {
                        break;
                    }
                    j = 0;
                    break;
                case 48:
                    i8 = zzeh.zzc((List) unsafe2.getObject(t2, j7));
                    if (i8 > 0) {
                        break;
                    }
                    j = 0;
                    break;
                case 49:
                    zzc = zzeh.zzd(i24, (List) unsafe2.getObject(t2, j7), zzad(i20));
                    i21 += zzc;
                    j = 0;
                    break;
                case 50:
                    zzc = this.zzmz.zzb(i24, unsafe2.getObject(t2, j7), zzae(i20));
                    i21 += zzc;
                    j = 0;
                    break;
                case 51:
                    if (zza(t2, i24, i20)) {
                        zzc = zzbn.zzb(i24, 0.0d);
                        i21 += zzc;
                    }
                    j = 0;
                    break;
                case 52:
                    if (zza(t2, i24, i20)) {
                        i6 = zzbn.zzb(i24, 0.0f);
                        i21 += i6;
                    }
                    j = 0;
                    break;
                case 53:
                    if (zza(t2, i24, i20)) {
                        zzc = zzbn.zzd(i24, zzh(t2, j7));
                        i21 += zzc;
                    }
                    j = 0;
                    break;
                case 54:
                    if (zza(t2, i24, i20)) {
                        zzc = zzbn.zze(i24, zzh(t2, j7));
                        i21 += zzc;
                    }
                    j = 0;
                    break;
                case 55:
                    if (zza(t2, i24, i20)) {
                        zzc = zzbn.zzg(i24, zzg(t2, j7));
                        i21 += zzc;
                    }
                    j = 0;
                    break;
                case 56:
                    if (zza(t2, i24, i20)) {
                        zzc = zzbn.zzg(i24, 0L);
                        i21 += zzc;
                    }
                    j = 0;
                    break;
                case 57:
                    if (zza(t2, i24, i20)) {
                        i6 = zzbn.zzj(i24, 0);
                        i21 += i6;
                    }
                    j = 0;
                    break;
                case 58:
                    break;
                case 59:
                    if (zza(t2, i24, i20)) {
                        obj = unsafe2.getObject(t2, j7);
                        break;
                    }
                    j = 0;
                    break;
                case 60:
                    break;
                case 61:
                    break;
                case 62:
                    if (zza(t2, i24, i20)) {
                        i4 = zzg(t2, j7);
                        zzc = zzbn.zzh(i24, i4);
                        i21 += zzc;
                    }
                    j = 0;
                    break;
                case 63:
                    if (zza(t2, i24, i20)) {
                        i5 = zzg(t2, j7);
                        zzc = zzbn.zzl(i24, i5);
                        i21 += zzc;
                    }
                    j = 0;
                    break;
                case 64:
                    break;
                case 65:
                    break;
                case 66:
                    if (zza(t2, i24, i20)) {
                        i7 = zzg(t2, j7);
                        zzc = zzbn.zzi(i24, i7);
                        i21 += zzc;
                    }
                    j = 0;
                    break;
                case 67:
                    if (zza(t2, i24, i20)) {
                        j2 = zzh(t2, j7);
                        zzc = zzbn.zzf(i24, j2);
                        i21 += zzc;
                    }
                    j = 0;
                    break;
                case 68:
                    break;
                default:
                    j = 0;
                    break;
            }
            i20 += 4;
        }
        int zza = i21 + zza((zzex) this.zzmx, (Object) t2);
        return this.zzmo ? zza + this.zzmy.zza((Object) t2).zzas() : zza;
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0109 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x011b A[SYNTHETIC] */
    public final boolean zzo(T t) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        T t2 = t;
        int[] iArr = this.zzms;
        int i3 = 1;
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        int length = iArr.length;
        int i4 = 0;
        int i5 = -1;
        int i6 = 0;
        while (i4 < length) {
            int i7 = iArr[i4];
            int zzai = zzai(i7);
            int zzag = zzag(zzai);
            if (!this.zzmq) {
                int i8 = this.zzmi[zzai + 2];
                int i9 = i8 & 1048575;
                i2 = i3 << (i8 >>> 20);
                if (i9 != i5) {
                    i = i4;
                    i6 = zzmh.getInt(t2, (long) i9);
                    i5 = i9;
                } else {
                    i = i4;
                }
            } else {
                i = i4;
                i2 = 0;
            }
            if (((268435456 & zzag) != 0) && !zza(t2, zzai, i6, i2)) {
                return false;
            }
            int i10 = (267386880 & zzag) >>> 20;
            if (i10 != 9 && i10 != 17) {
                if (i10 != 27) {
                    if (i10 == 60 || i10 == 68) {
                        if (zza(t2, i7, zzai) && !zza(t2, zzag, zzad(zzai))) {
                            return false;
                        }
                    } else if (i10 != 49) {
                        if (i10 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzh = this.zzmz.zzh(zzfd.zzo(t2, (long) (zzag & 1048575)));
                            if (!zzh.isEmpty()) {
                                if (this.zzmz.zzl(zzae(zzai)).zzmd.zzek() == zzfq.MESSAGE) {
                                    zzef zzef = null;
                                    Iterator<?> it = zzh.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzef == null) {
                                            zzef = zzea.zzcm().zze(next.getClass());
                                        }
                                        if (!zzef.zzo(next)) {
                                            z2 = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            z2 = true;
                            if (!z2) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzfd.zzo(t2, (long) (zzag & 1048575));
                if (!list.isEmpty()) {
                    zzef zzad = zzad(zzai);
                    int i11 = 0;
                    while (true) {
                        if (i11 >= list.size()) {
                            break;
                        } else if (!zzad.zzo(list.get(i11))) {
                            z = false;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (z) {
                        return false;
                    }
                }
                z = true;
                if (z) {
                }
            } else if (zza(t2, zzai, i6, i2) && !zza(t2, zzag, zzad(zzai))) {
                return false;
            }
            i4 = i + 1;
            i3 = 1;
        }
        return !this.zzmo || this.zzmy.zza(t2).isInitialized();
    }
}
