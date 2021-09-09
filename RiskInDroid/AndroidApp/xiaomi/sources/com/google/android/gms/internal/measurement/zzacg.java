package com.google.android.gms.internal.measurement;

import java.util.Arrays;

final class zzacg {
    final int tag;
    final byte[] zzbrc;

    zzacg(int i, byte[] bArr) {
        this.tag = i;
        this.zzbrc = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzacg)) {
            return false;
        }
        zzacg zzacg = (zzacg) obj;
        return this.tag == zzacg.tag && Arrays.equals(this.zzbrc, zzacg.zzbrc);
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzbrc);
    }
}
