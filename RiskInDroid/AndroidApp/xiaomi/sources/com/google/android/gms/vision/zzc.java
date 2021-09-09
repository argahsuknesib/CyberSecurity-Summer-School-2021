package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzc {
    private static final Object sLock = new Object();
    private static int zzas = 0;
    private SparseArray<Integer> zzat = new SparseArray<>();
    private SparseArray<Integer> zzau = new SparseArray<>();

    public final int zzb(int i) {
        synchronized (sLock) {
            Integer num = this.zzat.get(i);
            if (num != null) {
                int intValue = num.intValue();
                return intValue;
            }
            int i2 = zzas;
            zzas++;
            this.zzat.append(i, Integer.valueOf(i2));
            this.zzau.append(i2, Integer.valueOf(i));
            return i2;
        }
    }

    public final int zzc(int i) {
        int intValue;
        synchronized (sLock) {
            intValue = this.zzau.get(i).intValue();
        }
        return intValue;
    }
}
