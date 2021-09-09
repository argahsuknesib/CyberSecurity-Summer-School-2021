package com.google.android.gms.internal.measurement;

public abstract class zzze {
    private static volatile boolean zzbrg = false;
    int zzbrd;
    private int zzbre;
    private boolean zzbrf;

    private zzze() {
        this.zzbrd = 100;
        this.zzbre = Integer.MAX_VALUE;
        this.zzbrf = false;
    }

    static zzze zza(byte[] bArr, int i, int i2, boolean z) {
        zzzg zzzg = new zzzg(bArr, i, i2);
        try {
            zzzg.zzaf(i2);
            return zzzg;
        } catch (zzzt e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int zzsz();
}
