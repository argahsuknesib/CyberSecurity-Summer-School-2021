package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

public class GoogleApiAvailabilityCache {
    private final SparseIntArray zzug;
    private GoogleApiAvailabilityLight zzuh;

    public GoogleApiAvailabilityCache() {
        this(GoogleApiAvailability.getInstance());
    }

    public GoogleApiAvailabilityCache(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zzug = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zzuh = googleApiAvailabilityLight;
    }

    public void flush() {
        this.zzug.clear();
    }

    public int getClientAvailability(Context context, Api.Client client) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int i = this.zzug.get(minApkVersion, -1);
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        while (true) {
            if (i2 < this.zzug.size()) {
                int keyAt = this.zzug.keyAt(i2);
                if (keyAt > minApkVersion && this.zzug.get(keyAt) == 0) {
                    i = 0;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (i == -1) {
            i = this.zzuh.isGooglePlayServicesAvailable(context, minApkVersion);
        }
        this.zzug.put(minApkVersion, i);
        return i;
    }
}
