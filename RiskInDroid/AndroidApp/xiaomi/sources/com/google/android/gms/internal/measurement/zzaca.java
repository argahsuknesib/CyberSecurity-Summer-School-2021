package com.google.android.gms.internal.measurement;

public final class zzaca implements Cloneable {
    private static final zzacb zzbxa = new zzacb();
    private int mSize;
    private boolean zzbxb;
    private int[] zzbxc;
    private zzacb[] zzbxd;

    zzaca() {
        this(10);
    }

    private zzaca(int i) {
        this.zzbxb = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzbxc = new int[idealIntArraySize];
        this.zzbxd = new zzacb[idealIntArraySize];
        this.mSize = 0;
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    private final int zzav(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzbxc[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ -1;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzaca zzaca = new zzaca(i);
        System.arraycopy(this.zzbxc, 0, zzaca.zzbxc, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            zzacb[] zzacbArr = this.zzbxd;
            if (zzacbArr[i2] != null) {
                zzaca.zzbxd[i2] = (zzacb) zzacbArr[i2].clone();
            }
        }
        zzaca.mSize = i;
        return zzaca;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaca)) {
            return false;
        }
        zzaca zzaca = (zzaca) obj;
        int i = this.mSize;
        if (i != zzaca.mSize) {
            return false;
        }
        int[] iArr = this.zzbxc;
        int[] iArr2 = zzaca.zzbxc;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            } else if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            zzacb[] zzacbArr = this.zzbxd;
            zzacb[] zzacbArr2 = zzaca.zzbxd;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!zzacbArr[i4].equals(zzacbArr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzbxc[i2]) * 31) + this.zzbxd[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        return this.mSize;
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, zzacb zzacb) {
        int zzav = zzav(i);
        if (zzav >= 0) {
            this.zzbxd[zzav] = zzacb;
            return;
        }
        int i2 = zzav ^ -1;
        if (i2 < this.mSize) {
            zzacb[] zzacbArr = this.zzbxd;
            if (zzacbArr[i2] == zzbxa) {
                this.zzbxc[i2] = i;
                zzacbArr[i2] = zzacb;
                return;
            }
        }
        int i3 = this.mSize;
        if (i3 >= this.zzbxc.length) {
            int idealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            zzacb[] zzacbArr2 = new zzacb[idealIntArraySize];
            int[] iArr2 = this.zzbxc;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            zzacb[] zzacbArr3 = this.zzbxd;
            System.arraycopy(zzacbArr3, 0, zzacbArr2, 0, zzacbArr3.length);
            this.zzbxc = iArr;
            this.zzbxd = zzacbArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.zzbxc;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            zzacb[] zzacbArr4 = this.zzbxd;
            System.arraycopy(zzacbArr4, i2, zzacbArr4, i5, this.mSize - i2);
        }
        this.zzbxc[i2] = i;
        this.zzbxd[i2] = zzacb;
        this.mSize++;
    }

    /* access modifiers changed from: package-private */
    public final zzacb zzat(int i) {
        int zzav = zzav(i);
        if (zzav < 0) {
            return null;
        }
        zzacb[] zzacbArr = this.zzbxd;
        if (zzacbArr[zzav] == zzbxa) {
            return null;
        }
        return zzacbArr[zzav];
    }

    /* access modifiers changed from: package-private */
    public final zzacb zzau(int i) {
        return this.zzbxd[i];
    }
}
