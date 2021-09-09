package com.xiaomi.mico.common.event;

import android.net.Uri;

public class OAuthEvent {
    public boolean cancel;
    public boolean success;
    public Uri uri;

    static OAuthEvent completeEvent(Uri uri2) {
        OAuthEvent oAuthEvent = new OAuthEvent();
        oAuthEvent.uri = uri2;
        if (uri2 != null) {
            try {
                oAuthEvent.success = !"fail".equalsIgnoreCase(uri2.getQueryParameter("status"));
            } catch (Exception unused) {
            }
        }
        return oAuthEvent;
    }
}
