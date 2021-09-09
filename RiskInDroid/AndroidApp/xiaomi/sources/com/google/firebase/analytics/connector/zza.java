package com.google.firebase.analytics.connector;

import android.util.Log;
import com.google.firebase.analytics.connector.AnalyticsConnector;

final class zza implements AnalyticsConnector.AnalyticsConnectorHandle {
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ AnalyticsConnectorImpl zzboh;

    zza(AnalyticsConnectorImpl analyticsConnectorImpl, String str) {
        this.zzboh = analyticsConnectorImpl;
        this.zzanh = str;
    }

    public final void unregister() {
        if (!this.zzboh.zzfc(this.zzanh)) {
            Log.d("FA-C", "No listener registered");
            return;
        }
        AnalyticsConnector.AnalyticsConnectorListener listener = this.zzboh.zzbog.get(this.zzanh).getListener();
        if (listener != null) {
            listener.onMessageTriggered(0, null);
        }
        this.zzboh.zzbog.remove(this.zzanh);
    }
}
