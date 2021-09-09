package com.google.android.gms.internal.measurement;

final class zzyz extends zzzc {
    private final int zzbra;
    private final int zzbrb;

    zzyz(byte[] bArr, int i, int i2) {
        super(bArr);
        zzb(i, i + i2, bArr.length);
        this.zzbra = i;
        this.zzbrb = i2;
    }

    public final int size() {
        return this.zzbrb;
    }

    public final byte zzae(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzbrc[this.zzbra + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: protected */
    public final int zzsy() {
        return this.zzbra;
    }
}
