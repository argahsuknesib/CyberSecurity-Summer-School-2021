package com.google.android.gms.common.api.internal;

import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zzaf extends GoogleApiClient {
    private final String zzhe;

    public zzaf(String str) {
        this.zzhe = str;
    }

    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public void connect() {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public void disconnect() {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public boolean hasConnectedApi(Api<?> api) {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public boolean isConnected() {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public boolean isConnecting() {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public void reconnect() {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public void stopAutoManage(FragmentActivity fragmentActivity) {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.zzhe);
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.zzhe);
    }
}
