package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.util.VisibleForTesting;

public class HashAccumulator {
    @VisibleForTesting
    private static int zzad = 31;
    private int zzae = 1;

    public HashAccumulator addBoolean(boolean z) {
        this.zzae = (zzad * this.zzae) + (z ? 1 : 0);
        return this;
    }

    public HashAccumulator addObject(Object obj) {
        this.zzae = (zzad * this.zzae) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public int hash() {
        return this.zzae;
    }
}
