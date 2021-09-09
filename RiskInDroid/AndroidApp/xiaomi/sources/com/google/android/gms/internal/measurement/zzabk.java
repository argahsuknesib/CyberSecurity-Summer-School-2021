package com.google.android.gms.internal.measurement;

public final class zzabk {
    private static final zzabk zzbuj = new zzabk(0, new int[0], new Object[0], false);
    private int count;
    private int zzbrz;
    private int[] zzbuk;
    private Object[] zzbul;
    private boolean zzbum;

    private zzabk() {
        this(0, new int[8], new Object[8], true);
    }

    private zzabk(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzbrz = -1;
        this.count = 0;
        this.zzbuk = iArr;
        this.zzbul = objArr;
        this.zzbum = z;
    }

    public static zzabk zzuq() {
        return zzbuj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && (obj instanceof zzabk);
    }

    public final int hashCode() {
        return 506991;
    }
}
