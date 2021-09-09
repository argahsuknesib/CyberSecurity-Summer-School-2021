package com.google.android.gms.internal.clearcut;

final class zzfi extends IllegalArgumentException {
    /* JADX WARNING: Illegal instructions before constructor call */
    zzfi(int i, int i2) {
        super(r0.toString());
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unpaired surrogate at index ");
        sb.append(i);
        sb.append(" of ");
        sb.append(i2);
    }
}
