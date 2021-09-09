package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import java.security.KeyPair;

final class zzq {
    private final KeyPair zzbd;
    /* access modifiers changed from: private */
    public final long zzbe;

    @VisibleForTesting
    zzq(KeyPair keyPair, long j) {
        this.zzbd = keyPair;
        this.zzbe = j;
    }

    /* access modifiers changed from: private */
    public final String zzq() {
        return Base64.encodeToString(this.zzbd.getPublic().getEncoded(), 11);
    }

    /* access modifiers changed from: private */
    public final String zzr() {
        return Base64.encodeToString(this.zzbd.getPrivate().getEncoded(), 11);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzq)) {
            return false;
        }
        zzq zzq = (zzq) obj;
        return this.zzbe == zzq.zzbe && this.zzbd.getPublic().equals(zzq.zzbd.getPublic()) && this.zzbd.getPrivate().equals(zzq.zzbd.getPrivate());
    }

    /* access modifiers changed from: package-private */
    public final long getCreationTime() {
        return this.zzbe;
    }

    /* access modifiers changed from: package-private */
    public final KeyPair getKeyPair() {
        return this.zzbd;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzbd.getPublic(), this.zzbd.getPrivate(), Long.valueOf(this.zzbe));
    }
}
