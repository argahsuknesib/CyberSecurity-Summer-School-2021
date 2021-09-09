package com.google.android.gms.common.internal;

public class GmsServiceEndpoint {
    private final String mPackageName;
    private final int zztq;
    private final String zzue;
    private final boolean zzuf;

    public GmsServiceEndpoint(String str, String str2, boolean z, int i) {
        this.mPackageName = str;
        this.zzue = str2;
        this.zzuf = z;
        this.zztq = i;
    }

    /* access modifiers changed from: package-private */
    public final int getBindFlags() {
        return this.zztq;
    }

    /* access modifiers changed from: package-private */
    public final String getPackageName() {
        return this.mPackageName;
    }

    /* access modifiers changed from: package-private */
    public final String zzcw() {
        return this.zzue;
    }
}
