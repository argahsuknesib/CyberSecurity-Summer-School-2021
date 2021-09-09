package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

final class zzan extends zzbe {
    private final /* synthetic */ ConnectionResult zzhy;
    private final /* synthetic */ zzam zzhz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzan(zzam zzam, zzbc zzbc, ConnectionResult connectionResult) {
        super(zzbc);
        this.zzhz = zzam;
        this.zzhy = connectionResult;
    }

    public final void zzaq() {
        this.zzhz.zzhv.zze(this.zzhy);
    }
}
