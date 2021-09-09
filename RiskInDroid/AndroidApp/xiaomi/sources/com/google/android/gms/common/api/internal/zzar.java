package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.SignInResponse;

final class zzar extends zzbe {
    private final /* synthetic */ zzaj zzic;
    private final /* synthetic */ SignInResponse zzid;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzar(zzaq zzaq, zzbc zzbc, zzaj zzaj, SignInResponse signInResponse) {
        super(zzbc);
        this.zzic = zzaj;
        this.zzid = signInResponse;
    }

    public final void zzaq() {
        this.zzic.zza(this.zzid);
    }
}
