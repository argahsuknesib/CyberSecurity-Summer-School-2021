package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzas implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private final /* synthetic */ zzaj zzhv;

    private zzas(zzaj zzaj) {
        this.zzhv = zzaj;
    }

    /* synthetic */ zzas(zzaj zzaj, zzak zzak) {
        this(zzaj);
    }

    public final void onConnected(Bundle bundle) {
        this.zzhv.zzhn.signIn(new zzaq(this.zzhv));
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzhv.zzga.lock();
        try {
            if (this.zzhv.zzd(connectionResult)) {
                this.zzhv.zzau();
                this.zzhv.zzas();
            } else {
                this.zzhv.zze(connectionResult);
            }
        } finally {
            this.zzhv.zzga.unlock();
        }
    }

    public final void onConnectionSuspended(int i) {
    }
}
