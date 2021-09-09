package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzao extends zzbe {
    private final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks zzia;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzao(zzam zzam, zzbc zzbc, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zzbc);
        this.zzia = connectionProgressReportCallbacks;
    }

    public final void zzaq() {
        this.zzia.onReportServiceBinding(new ConnectionResult(16, null));
    }
}
