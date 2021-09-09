package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzg implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ GoogleApiClient.OnConnectionFailedListener zzte;

    zzg(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzte = onConnectionFailedListener;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzte.onConnectionFailed(connectionResult);
    }
}
