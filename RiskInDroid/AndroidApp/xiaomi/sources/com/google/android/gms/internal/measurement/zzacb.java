package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class zzacb implements Cloneable {
    private Object value;
    private zzabz<?, ?> zzbxe;
    private List<zzacg> zzbxf = new ArrayList();

    zzacb() {
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zza()];
        zza(zzabw.zzj(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzvg */
    public final zzacb clone() {
        Object clone;
        zzacb zzacb = new zzacb();
        try {
            zzacb.zzbxe = this.zzbxe;
            if (this.zzbxf == null) {
                zzacb.zzbxf = null;
            } else {
                zzacb.zzbxf.addAll(this.zzbxf);
            }
            if (this.value != null) {
                if (this.value instanceof zzace) {
                    clone = (zzace) ((zzace) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    clone = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zzacb.value = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        clone = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        clone = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        clone = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        clone = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        clone = ((double[]) this.value).clone();
                    } else if (this.value instanceof zzace[]) {
                        zzace[] zzaceArr = (zzace[]) this.value;
                        zzace[] zzaceArr2 = new zzace[zzaceArr.length];
                        zzacb.value = zzaceArr2;
                        while (i < zzaceArr.length) {
                            zzaceArr2[i] = (zzace) zzaceArr[i].clone();
                            i++;
                        }
                    }
                }
                zzacb.value = clone;
            }
            return zzacb;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        List<zzacg> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzacb)) {
            return false;
        }
        zzacb zzacb = (zzacb) obj;
        if (this.value == null || zzacb.value == null) {
            List<zzacg> list2 = this.zzbxf;
            if (list2 != null && (list = zzacb.zzbxf) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(toByteArray(), zzacb.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            zzabz<?, ?> zzabz = this.zzbxe;
            if (zzabz != zzacb.zzbxe) {
                return false;
            }
            if (!zzabz.zzbwx.isArray()) {
                return this.value.equals(zzacb.value);
            }
            Object obj2 = this.value;
            return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) zzacb.value) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) zzacb.value) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) zzacb.value) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) zzacb.value) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) zzacb.value) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) zzacb.value) : Arrays.deepEquals((Object[]) obj2, (Object[]) zzacb.value);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        Object obj = this.value;
        if (obj != null) {
            zzabz<?, ?> zzabz = this.zzbxe;
            if (!zzabz.zzbwy) {
                return zzabz.zzv(obj);
            }
            int length = Array.getLength(obj);
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (Array.get(obj, i2) != null) {
                    i += zzabz.zzv(Array.get(obj, i2));
                }
            }
            return i;
        }
        int i3 = 0;
        for (zzacg next : this.zzbxf) {
            i3 += zzabw.zzas(next.tag) + 0 + next.zzbrc.length;
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzabw zzabw) throws IOException {
        Object obj = this.value;
        if (obj != null) {
            zzabz<?, ?> zzabz = this.zzbxe;
            if (zzabz.zzbwy) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        zzabz.zza(obj2, zzabw);
                    }
                }
                return;
            }
            zzabz.zza(obj, zzabw);
            return;
        }
        for (zzacg next : this.zzbxf) {
            zzabw.zzar(next.tag);
            zzabw.zzk(next.zzbrc);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzacg zzacg) throws IOException {
        Object obj;
        List<zzacg> list = this.zzbxf;
        if (list != null) {
            list.add(zzacg);
            return;
        }
        Object obj2 = this.value;
        if (obj2 instanceof zzace) {
            byte[] bArr = zzacg.zzbrc;
            zzabv zza = zzabv.zza(bArr, 0, bArr.length);
            int zzuy = zza.zzuy();
            if (zzuy == bArr.length - zzabw.zzao(zzuy)) {
                obj = ((zzace) this.value).zzb(zza);
            } else {
                throw zzacd.zzvh();
            }
        } else if (obj2 instanceof zzace[]) {
            zzace[] zzaceArr = (zzace[]) this.zzbxe.zzi(Collections.singletonList(zzacg));
            zzace[] zzaceArr2 = (zzace[]) this.value;
            zzace[] zzaceArr3 = (zzace[]) Arrays.copyOf(zzaceArr2, zzaceArr2.length + zzaceArr.length);
            System.arraycopy(zzaceArr, 0, zzaceArr3, zzaceArr2.length, zzaceArr.length);
            obj = zzaceArr3;
        } else {
            obj = this.zzbxe.zzi(Collections.singletonList(zzacg));
        }
        this.zzbxe = this.zzbxe;
        this.value = obj;
        this.zzbxf = null;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.gms.internal.measurement.zzabz<?, T>, com.google.android.gms.internal.measurement.zzabz, java.lang.Object, com.google.android.gms.internal.measurement.zzabz<?, ?>] */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    final <T> T zzb(com.google.android.gms.internal.measurement.zzabz<?, T> r2) {
        /*
            r1 = this;
            java.lang.Object r0 = r1.value
            if (r0 == 0) goto L_0x0015
            com.google.android.gms.internal.measurement.zzabz<?, ?> r0 = r1.zzbxe
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x000d
            goto L_0x0022
        L_0x000d:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r0 = "Tried to getExtension with a different Extension."
            r2.<init>(r0)
            throw r2
        L_0x0015:
            r1.zzbxe = r2
            java.util.List<com.google.android.gms.internal.measurement.zzacg> r0 = r1.zzbxf
            java.lang.Object r2 = r2.zzi(r0)
            r1.value = r2
            r2 = 0
            r1.zzbxf = r2
        L_0x0022:
            java.lang.Object r2 = r1.value
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzacb.zzb(com.google.android.gms.internal.measurement.zzabz):java.lang.Object");
    }
}
