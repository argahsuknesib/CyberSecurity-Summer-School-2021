package com.google.android.gms.internal.measurement;

import java.io.IOException;

public abstract class zzace {
    protected volatile int zzbxh = -1;

    public static final <T extends zzace> T zza(T t, byte[] bArr) throws zzacd {
        return zzb(t, bArr, 0, bArr.length);
    }

    public static final void zza(zzace zzace, byte[] bArr, int i, int i2) {
        try {
            zzabw zzb = zzabw.zzb(bArr, 0, i2);
            zzace.zza(zzb);
            zzb.zzve();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    private static final <T extends com.google.android.gms.internal.measurement.zzace> T zzb(T r0, byte[] r1, int r2, int r3) throws com.google.android.gms.internal.measurement.zzacd {
        /*
            r2 = 0
            com.google.android.gms.internal.measurement.zzabv r1 = com.google.android.gms.internal.measurement.zzabv.zza(r1, r2, r3)     // Catch:{ zzacd -> 0x0015, IOException -> 0x000c }
            r0.zzb(r1)     // Catch:{ zzacd -> 0x0015, IOException -> 0x000c }
            r1.zzaj(r2)     // Catch:{ zzacd -> 0x0015, IOException -> 0x000c }
            return r0
        L_0x000c:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Reading from a byte array threw an IOException (should never happen)."
            r1.<init>(r2, r0)
            throw r1
        L_0x0015:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzace.zzb(com.google.android.gms.internal.measurement.zzace, byte[], int, int):com.google.android.gms.internal.measurement.zzace");
    }

    public String toString() {
        return zzacf.zzc(this);
    }

    /* access modifiers changed from: protected */
    public int zza() {
        return 0;
    }

    public void zza(zzabw zzabw) throws IOException {
    }

    public abstract zzace zzb(zzabv zzabv) throws IOException;

    /* renamed from: zzvf */
    public zzace clone() throws CloneNotSupportedException {
        return (zzace) super.clone();
    }

    public final int zzvl() {
        if (this.zzbxh < 0) {
            zzvm();
        }
        return this.zzbxh;
    }

    public final int zzvm() {
        int zza = zza();
        this.zzbxh = zza;
        return zza;
    }
}
