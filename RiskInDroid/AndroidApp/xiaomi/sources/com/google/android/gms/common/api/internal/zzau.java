package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.Collections;

public final class zzau implements zzbc {
    private final zzbd zzhf;

    public zzau(zzbd zzbd) {
        this.zzhf = zzbd;
    }

    public final void begin() {
        for (Api.Client disconnect : this.zzhf.zzil.values()) {
            disconnect.disconnect();
        }
        this.zzhf.zzfq.zzim = Collections.emptySet();
    }

    public final void connect() {
        this.zzhf.zzbc();
    }

    public final boolean disconnect() {
        return true;
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        this.zzhf.zzfq.zzgo.add(t);
        return t;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void onConnected(Bundle bundle) {
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }
}
