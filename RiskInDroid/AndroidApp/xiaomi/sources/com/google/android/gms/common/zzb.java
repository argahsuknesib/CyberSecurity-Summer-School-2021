package com.google.android.gms.common;

import com.google.android.gms.common.GoogleCertificates;
import java.util.Arrays;

final class zzb extends GoogleCertificates.CertData {
    private final byte[] zzbd;

    zzb(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zzbd = bArr;
    }

    /* access modifiers changed from: package-private */
    public final byte[] getBytes() {
        return this.zzbd;
    }
}
