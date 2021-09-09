package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;

final class LoginStatusClient extends PlatformServiceClient {
    private final String graphApiVersion;
    private final String loggerRef;
    private final long toastDurationMs;

    LoginStatusClient(Context context, String str, String str2, String str3, long j) {
        super(context, 65546, 65547, 20170411, str);
        this.loggerRef = str2;
        this.graphApiVersion = str3;
        this.toastDurationMs = j;
    }

    public final void populateRequestBundle(Bundle bundle) {
        bundle.putString("com.facebook.platform.extra.LOGGER_REF", this.loggerRef);
        bundle.putString("com.facebook.platform.extra.GRAPH_API_VERSION", this.graphApiVersion);
        bundle.putLong("com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS", this.toastDurationMs);
    }
}
