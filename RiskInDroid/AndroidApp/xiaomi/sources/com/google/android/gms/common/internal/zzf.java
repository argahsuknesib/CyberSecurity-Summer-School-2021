package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzf implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ GoogleApiClient.ConnectionCallbacks zztd;

    zzf(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zztd = connectionCallbacks;
    }

    public final void onConnected(Bundle bundle) {
        this.zztd.onConnected(bundle);
    }

    public final void onConnectionSuspended(int i) {
        this.zztd.onConnectionSuspended(i);
    }
}
